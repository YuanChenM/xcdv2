package com.bms.order.services.impl;

import com.bms.order.archive.impl.*;
import com.bms.order.archive.impl.list.*;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.DistributionNotificationEntity;
import com.bms.order.bean.entity.SendNotificationDetailEntity;
import com.bms.order.bean.entity.SendNotificationEntity;
import com.bms.order.bean.param.LINV0104IParam;
import com.bms.order.bean.param.ORDR0401IBeanParam;
import com.bms.order.constant.enumeration.*;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.*;
import com.bms.order.external.archive.Stock;
import com.bms.order.external.archive.Ydp;
import com.bms.order.external.bean.param.LinvRestParam;
import com.bms.order.fms.common.FmsCommon;
import com.bms.order.services.ORDR0401IService;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DecimalUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 发货通知回传接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0401IServiceImpl implements ORDR0401IService {

    @Autowired
    private BaseRedisDao redisDao;

    @Autowired
    private DistributionNotificationDao distributionNotificationDao;

    @Autowired
    private DistributionNotificationDetailDao distributionNotificationDetailDao;

    @Autowired
    private SendNotificationDao sendNotificationDao;

    @Autowired
    private SendNotificationDetailDao sendNotificationDetailDao;

    @Autowired
    private BuyerBatchOrderDao buyerBatchOrderDao;

    @Autowired
    private BuyerBatchOrderAttachedDao attachedDao;

    @Autowired
    private BuyerForcastDeliverDetailDao buyerForcastDeliverDetailDao;

    @Autowired
    private BuyerForcastDeliverDetailAttachedDao buyerForcastDeliverDetailAttachedDao;
    @Autowired
    private BuyerOrderDao buyerOrderDao;
    @Autowired
    private BuyerOrderAttachedDao buyerOrderAttachedDao;
    @Autowired
    private BuyerBatchOrderDetailDao buyerBatchOrderDetailDao;
    @Autowired
    private BuyerBatchOrderDetailAttachedDao buyerBatchOrderDetailAttachedDao;

    public static final Logger logger = LoggerFactory.getLogger(ORDR0401IServiceImpl.class);

    @Autowired
    private FmsCommon fmsCommon;

    /**
     * WMS系统发送发货通知单，通知订单系统进行系统内发货
     *
     * @param operator 操作者
     * @param param    ORDR0401IRestParam
     */
    @Transactional
    @Override
    public void execute(Operator operator, ORDR0401IBeanParam param) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        blackboard.setOperator(operator);
        map.put("param", param);
        map.put("blackboard", blackboard);
        map.put("buyerOrderId", param.getOrderId());
        for (ORDR0401IBeanParam.ORDR0401IDetail ship : param.getShipList()) {
            map.put("ship", ship);
            pre(map);
            process(map);
        }
        post(map);
    }

    /**
     * 准备
     *
     * @param map HashMap
     */
    private void pre(HashMap<String, Object> map) {
        // 获取参数
        ORDR0401IBeanParam param = (ORDR0401IBeanParam) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        ORDR0401IBeanParam.ORDR0401IDetail ship = (ORDR0401IBeanParam.ORDR0401IDetail) map.get("ship");
        // 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(distributionNotificationDao);
        blackboard.putBaseDao(distributionNotificationDetailDao);
        blackboard.putBaseDao(sendNotificationDao);
        blackboard.putBaseDao(sendNotificationDetailDao);
        blackboard.putBaseDao(buyerBatchOrderDao);
        blackboard.putBaseDao(attachedDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailAttachedDao);
        blackboard.putBaseDao(buyerOrderDao);
        blackboard.putBaseDao(buyerOrderAttachedDao);
        blackboard.putBaseDao(buyerBatchOrderDetailDao);
        blackboard.putBaseDao(buyerBatchOrderDetailAttachedDao);


        //操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);

        // 获取运送者
        getCarrier(operator);
        //获得配送通知单表信息
        DistributionNotification distributionNotification = param.generateDistributionNotification();
        distributionNotification.setBlackboard(blackboard);

        //创建发货的通知单
        SendNotification sendNotificationForCreat = ship.generateSendNotificationForCreat();
        sendNotificationForCreat.setBlackboard(blackboard);

        //检查配送明细准备数据
        List<DistributionNotificationDetail> disDetails = ship.disDetails(blackboard);
        List<SendNotificationDetail> sendNotificationDetails = new ArrayList<>();
        for (ORDR0401IBeanParam.ORDR0401IDetail.ORDR0401IProductList product : ship.getProductList()){
            for(ORDR0401IBeanParam.ORDR0401IDetail.ORDR0401IProductList.ORDR0401ILotList lot : product.getLotList()){
                SendNotificationDetail sendNotificationDetail = lot.generateSendNotificationDetail();
                sendNotificationDetail.setBlackboard(blackboard);
                sendNotificationDetail.getEntity().setDistributionNotificationDetailId(product.getShipDetailId());
                sendNotificationDetail.getEntity().setSku(product.getSkuCode());
                sendNotificationDetail.getEntity().setTransactionSequence(0);
                sendNotificationDetails.add(sendNotificationDetail);
            }
        }
        map.put("sendNotificationForCreat", sendNotificationForCreat);
        map.put("distributionNotification", distributionNotification);
        map.put("sendNotificationDetails", sendNotificationDetails);
        map.put("disDetails", disDetails);
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        DistributionNotification distributionNotification = (DistributionNotification) map.get("distributionNotification");
        ORDR0401IBeanParam param = (ORDR0401IBeanParam) map.get("param");
        SendNotification sendNotificationForCreat = (SendNotification) map.get("sendNotificationForCreat");
        List<SendNotificationDetail> sendNotificationDetails = (List<SendNotificationDetail>) map.get("sendNotificationDetails");
        List<DistributionNotificationDetail> disDetails = (List<DistributionNotificationDetail>) map.get("disDetails");
        ORDR0401IBeanParam.ORDR0401IDetail ship = (ORDR0401IBeanParam.ORDR0401IDetail) map.get("ship");

        sendOutGoodsNotificate(distributionNotification, param, sendNotificationDetails, sendNotificationForCreat, disDetails, ship);
        // 返回参数
        BuyerOrder buyerOrder = BuyerOrder.build(blackboard).forComplete(distributionNotification.getEntity().getBuyerOrderId());
        buyerOrder.complete(false);
        ArrayList<LinvRestParam> paramList = new ArrayList<>();
        List<Long> orderIds = new ArrayList<>();
        for (SendNotificationDetail detail : sendNotificationDetails) {// 针对发货明细  做库存处理
            DistributionNotificationDetail distributionNotificationDetail = detail.getDistributionNotificationDetail();
            BuyerForcastDeliverDetail forcastDeliverDetail = distributionNotificationDetail.getBuyerForcastDeliverDetail();
            BuyerBatchOrderDetail batchOrderDetail = forcastDeliverDetail.getBuyerBatchOrderDetail();
            LinvRestParam linvRestParam = new LinvRestParam();
            linvRestParam.setWhId(distributionNotification.getEntity().getFactWhId());
            linvRestParam.setCommodityId(detail.getEntity().getGoodsId());
            linvRestParam.setLogicAreaId(buyerOrder.getEntity().getLogisticsZoneId());
            linvRestParam.setOwnerId(forcastDeliverDetail.getEntity().getSellSideId());
            if (forcastDeliverDetail.getEntity().getSellSideType().equals(SellSideType.PLATFORM_TYPE.getCode())) {// 平台
                linvRestParam.setOwnerType(OwnerType.Seller.getCode());
                linvRestParam.setBizType(BizType.SellerSale.getCode());
            } else {// 买手
                linvRestParam.setOwnerType(OwnerType.Agent.getCode());
                linvRestParam.setBizType(BizType.AgentSale.getCode());
            }
            linvRestParam.setSkuCode(detail.getEntity().getSku());
            linvRestParam.setLotNo(detail.getEntity().getBatch());
            linvRestParam.setRefNo(buyerOrder.getEntity().getBuyerOrderCode());
            linvRestParam.setTransactionId(buyerOrder.getEntity().getBuyerOrderId());
            linvRestParam.setTransactionNo(buyerOrder.getEntity().getBuyerOrderCode());
            linvRestParam.setTransactionDetailId(detail.getEntity().getSendNotificationDetailId());// 发货明细id
            linvRestParam.setTransactionSequence(detail.getEntity().getTransactionSequence() + 1);
            linvRestParam.setTargetId(buyerOrder.getEntity().getBuyerId());
            linvRestParam.setTargetCode(buyerOrder.getAttachedEntity().getBuyerCode());
            linvRestParam.setTargetType(OwnerType.Buyer.getCode());
            linvRestParam.setSellPrice(batchOrderDetail.getEntity().getRealUnitPrice());
            linvRestParam.setReleaseQty(detail.getEntity().getRealSendQuantity());
            linvRestParam.setDispatchedQty(detail.getEntity().getRealSendQuantity());
            linvRestParam.setReleaseTransactionId(buyerOrder.getEntity().getBuyerOrderId());
            linvRestParam.setReleaseTransactionNo(buyerOrder.getEntity().getBuyerOrderCode());
            linvRestParam.setReleaseTransactionDetailId(forcastDeliverDetail.getEntity().getBuyerForcastDeliverDetailId());
            paramList.add(linvRestParam);

            if (!orderIds.contains(buyerOrder.getEntity().getBuyerOrderId())) {
                orderIds.add(buyerOrder.getEntity().getBuyerOrderId());
            }

        }
        Stock.DispatchLoad(paramList);

        // 调用云冻品前台，通知订单变更
        try {
            Ydp.pushMsg(orderIds);
        } catch (Exception e) {
            logger.error("千米前台调用错误：", e.getMessage());
        }

    }

    /**
     * 收尾
     *
     * @param map HashMap
     */
    private void post(HashMap<String, Object> map) {
        Long buyerOrderId = (Long) map.get("buyerOrderId");
        ORDR0401IBeanParam param = (ORDR0401IBeanParam) map.get("param");
        ArrayList<Long> detailIds = new ArrayList<>();
        for (ORDR0401IBeanParam.ORDR0401IDetail ship : param.getShipList()) {
            if (ship == null)
                continue;
            List<ORDR0401IBeanParam.ORDR0401IDetail.ORDR0401IProductList> productList = ship.getProductList();
            if (CollectionUtils.isNotEmpty(productList)) {
                for (ORDR0401IBeanParam.ORDR0401IDetail.ORDR0401IProductList product : productList){
                    if (product == null)
                        continue;
                    Long distributionDetailId = product.getShipDetailId();
                    if (!detailIds.contains(distributionDetailId)) {
                        detailIds.add(distributionDetailId);
                    }
                }
            }
        }

        Long[] distributionDetailIds = detailIds.toArray(new Long[0]);

        // 推送买家已收货订单
        try {
            fmsCommon.pushBuyerOrder(buyerOrderId, distributionDetailIds);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

    private void sendOutGoodsNotificate(DistributionNotification distributionNotification, ORDR0401IBeanParam param,
                                       List<SendNotificationDetail> sendNotificationDetails, SendNotification sendNotificationForCreat,
                                       List<DistributionNotificationDetail> disDetails,ORDR0401IBeanParam.ORDR0401IDetail ship) {
        // 获取配送单相关信息
        distributionNotification.complete(false);
        if (!distributionNotification.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR,ErrorCode.E040102 );
        }

        // 判断配送单是否有发货记录
        List<SendNotification> sendNotifications = distributionNotification.getSendNotifications();
        if (CollectionUtils.isNotEmpty(sendNotifications)){
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E040111);
        }

        // 检查脏数据
        checkData(distributionNotification, disDetails);

        // 补全信息
        sendNotificationForCreat.getEntity().setDistributionNotificationCode(distributionNotification.getEntity().getDistributionNotificationCode());
        for(DistributionNotificationDetail disDetail : disDetails){
            for (SendNotificationDetail sendNotificationDetail :sendNotificationDetails){
                if (sendNotificationDetail.getEntity().getDistributionNotificationDetailId().equals(disDetail.getEntity().getDistributionNotificationDetailId())){
                    sendNotificationDetail.getEntity().setGoodsId(disDetail.getEntity().getGoodsId());
                }
            }
        }

        // 实际发货数量必须大于0
        for (ORDR0401IBeanParam.ORDR0401IDetail.ORDR0401IProductList product : ship.getProductList()){
            for(ORDR0401IBeanParam.ORDR0401IDetail.ORDR0401IProductList.ORDR0401ILotList lot : product.getLotList()){
                if (DecimalUtils.le(lot.getSendQty(), BigDecimal.ZERO)) {
                    throw new BusinessException(ModuleCode.ORDR, ErrorCode.E040103);
                }
            }
        }

        // 保存发货通知单信息
        saveSendNotification(sendNotificationForCreat, distributionNotification);
        // 1.遍历发货通知单明细
        // 1.1对比发货通知单明细和配送通知单明细
        // 1.2根据配送id判断商品id、sku和批次是否正确
        checkDetails(ship, distributionNotification);
        // 1.3保存发货通知单明细信息
        saveSendNotificationDetails(sendNotificationForCreat, sendNotificationDetails);
        // 更新各级数量，欠发部分从订单中取消，调用库存取消占用接口
        modifyDisDetail(distributionNotification);
        // 更新分批订单状态
        modifyBatchOrderStu(distributionNotification);
        // 更新配送通知单状态
        modifyDistributionNotification(distributionNotification, param);
    }

    /**
     * 检查配送单和配送明细是否匹配
     *
     * @param distributionNotification
     * @param paramDisDetails
     */
    private void checkData(DistributionNotification distributionNotification,
                           List<DistributionNotificationDetail> paramDisDetails) {

        String disCode = distributionNotification.getEntity().getDistributionNotificationCode();
        // 入参配送单号对应的配送明细
        List<DistributionNotificationDetail> dataBaseDetails = distributionNotification
                .getDistributionNotificationDetails();

        if (CollectionUtils.isEmpty(dataBaseDetails)) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E040104);
        }
        for (DistributionNotificationDetail paramDetail : paramDisDetails) {
            Long paramDetailId = paramDetail.getEntity().getDistributionNotificationDetailId();
            boolean find = false;

            for (DistributionNotificationDetail dataBaseDetail : dataBaseDetails) {
                Long dataBaseDetailId = dataBaseDetail.getEntity().getDistributionNotificationDetailId();
                if (paramDetailId.equals(dataBaseDetailId)) {
                    find = true;
                }
            }

            if (!find) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E040105 );
            }
        }

    }

    /**
     * 保存发货通知单信息
     *
     * @param sendNotification
     * @param distributionNotification
     */
    private void saveSendNotification(SendNotification sendNotification, DistributionNotification distributionNotification) {
        SendNotificationEntity sendNotificationEntity = sendNotification.getEntity();
        DistributionNotificationEntity distributionNotificationEntity = distributionNotification.getEntity();
        sendNotificationEntity
                .setDistributionNotificationId(distributionNotificationEntity.getDistributionNotificationId());
        sendNotification.create();
    }

    /**
     * 对比发货通知单明细和配送通知单明细
     *
     * @param distributionNotification
     */
    private void checkDetails(ORDR0401IBeanParam.ORDR0401IDetail ship, DistributionNotification distributionNotification) {
        List<DistributionNotificationDetail> distributionNotificationDetailList = distributionNotification.getDistributionNotificationDetails();
        if (CollectionUtils.isNotEmpty(distributionNotificationDetailList)) {
            for (DistributionNotificationDetail distributionNotificationDetail : distributionNotificationDetailList) {
                Long sourceId = distributionNotificationDetail.getEntity().getDistributionNotificationDetailId();
                for (ORDR0401IBeanParam.ORDR0401IDetail.ORDR0401IProductList detail : ship.getProductList()) {
                    Long paramId = detail.getShipDetailId();
                    if (paramId.equals(sourceId)) {
                        // SKU
                        if (!detail.getSkuCode().equals(distributionNotificationDetail.getEntity().getSku())) {
                            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E040107);
                        }
                    }
                }
            }
        }
    }

    /**
     * 保存发货明细
     *
     * @param sendNotification
     * @param sendNotificationDetails
     */
    private void saveSendNotificationDetails(SendNotification sendNotification,
                                             List<SendNotificationDetail> sendNotificationDetails) {
        for (SendNotificationDetail sendNotificationDetail : sendNotificationDetails) {
            sendNotificationDetail.getEntity()
                    .setSendNotificationId(sendNotification.getEntity().getSendNotificationId());
        }
        SendNotificationDetailList sendNotificationDetailList = SendNotificationDetailList
                .build(sendNotification.getBlackboard())
                .forCreate(sendNotificationDetails.toArray(new SendNotificationDetail[0]));
        sendNotificationDetailList.create();
    }

    /**
     * 更新分批订单状态
     *
     * @param distributionNotification
     */
    private void modifyBatchOrderStu(DistributionNotification distributionNotification) {
        String status = "";
        List<BuyerBatchOrder> buyerBatchOrders = new ArrayList<>();
        List<DistributionNotificationDetail> distributionNotificationDetailList = distributionNotification
                .getDistributionNotificationDetails();
        for (DistributionNotificationDetail distributionNotificationDetail : distributionNotificationDetailList) {
            BuyerForcastDeliverDetail buyerForcastDeliverDetail = distributionNotificationDetail
                    .getBuyerForcastDeliverDetail();
            BuyerBatchOrder buyerBatchOrder = buyerForcastDeliverDetail.getBuyerBatchOrder();
            if (!buyerBatchOrders.contains(buyerBatchOrder)) {
                buyerBatchOrders.add(buyerBatchOrder);
            }
        }

        // 判断分批订单状态
        for (BuyerBatchOrder buyerBatchOrder : buyerBatchOrders) {
            BigDecimal realNum = BigDecimal.ZERO;
            BigDecimal planNum = BigDecimal.ZERO;
            for (BuyerForcastDeliverDetail deliverDetail : buyerBatchOrder.getBuyerForcastDeliverDetails()) {
                realNum = DecimalUtils.add(DecimalUtils.add(realNum, deliverDetail.getEntity().getRealSendQuantity()),deliverDetail.getEntity().getCancelQuantity());
                planNum = DecimalUtils.add(planNum, deliverDetail.getEntity().getPlanSendQuantity());
                if (DecimalUtils.gt(realNum, planNum)) {
                    throw new BusinessException(ModuleCode.ORDR, ErrorCode.E040109);
                }
            }
            if (realNum.equals(planNum)) {
                status = BuyerBatchOrderStu.ALL_SHIPMENT.getCode();
            } else {
                status = BuyerBatchOrderStu.PARTIAL_SHIPMENT.getCode();
            }
            buyerBatchOrder.getEntity().setBuyerBatchOrderStu(status);
        }

        BuyerBatchOrderList buyerBatchOrderList = BuyerBatchOrderList.build(distributionNotification.getBlackboard())
                .forUpdate(buyerBatchOrders.toArray(new BuyerBatchOrder[0]));
        buyerBatchOrderList.modify();
    }

    /**
     * 更新配送通知单状态为配送中
     *
     * @param distributionNotification
     */
    private void modifyDistributionNotification(DistributionNotification distributionNotification,ORDR0401IBeanParam param) {
        distributionNotification.getEntity()
                .setDistributionNotificationStu(DistributionNotificationStu.IN_DISTRIBUTION.getCode());
        distributionNotification.getEntity().setFactWhId(Stock.getWareHouseId(param.getWhCode()));
        distributionNotification.getEntity().setFactWhCode(param.getWhCode());
        distributionNotification.getEntity().setFactWhName(param.getWhName());
        distributionNotification.modify();
    }

    /**
     * 获取 角色-运输者（美迪福WMS）
     *
     * @param operator
     * @return
     */
    private void getCarrier(Operator operator) {
        Assert.notNull(operator);
        if (operator.isCarrier()) {
        }else {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E040110);
        }
    }

    /**
     * 更新各级数量，欠发部分从订单中取消，调用库存取消占用接口
     *
     * @param distributionNotification
     */
    private void modifyDisDetail(DistributionNotification distributionNotification) {
        // 配送通知明细
        List<DistributionNotificationDetail> distributionNotificationDetails = distributionNotification.getDistributionNotificationDetails();
        List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails = new ArrayList<>();
        List<BuyerBatchOrderDetail> buyerBatchOrderDetails = new ArrayList<>();
        // 数据库中发货单详细数量MAP
        Map<Long,BigDecimal> sendMap = new HashMap<>();
        for (SendNotification sendNotification : distributionNotification.getSendNotifications()){
            for (SendNotificationDetail sendNotificationDetail : sendNotification.getSendNotificationDetails()){
                SendNotificationDetailEntity entity = sendNotificationDetail.getEntity();
                if (sendMap.get(entity.getDistributionNotificationDetailId()) != null){
                    BigDecimal targetQty = DecimalUtils.add(sendMap.get(entity.getDistributionNotificationDetailId()), entity.getRealSendQuantity());
                    sendMap.put(entity.getDistributionNotificationDetailId(), targetQty);
                } else {
                    sendMap.put(entity.getDistributionNotificationDetailId(), entity.getRealSendQuantity());
                }
            }
        }
        Map<Long,BuyerBatchOrderDetail> cancelComoMap = new HashMap<>();
        Map<Long,BuyerForcastDeliverDetail> cancelLinvMap = new HashMap<>();
        for (DistributionNotificationDetail detail : distributionNotificationDetails){
            BigDecimal realSendQty = sendMap.get(detail.getEntity().getDistributionNotificationDetailId());
            BigDecimal cancelQty =  DecimalUtils.subtract(detail.getEntity().getDistributionQuantity(),realSendQty);
            detail.getEntity().setCancelQuantity(cancelQty);

            // 配送通知明细对应的预配送明细
            BuyerForcastDeliverDetail buyerForcastDeliverDetail = detail.getBuyerForcastDeliverDetail();
            buyerForcastDeliverDetail.getEntity().setRealSendQuantity(realSendQty);
            buyerForcastDeliverDetail.getEntity().setCancelQuantity(cancelQty);
            buyerForcastDeliverDetails.add(buyerForcastDeliverDetail);

            // 配送通知明细对应的分批订单明细
            BuyerBatchOrderDetail buyerBatchOrderDetail = buyerForcastDeliverDetail.getBuyerBatchOrderDetail();
            buyerBatchOrderDetail.getEntity().setCancelQuantity(cancelQty);
            buyerBatchOrderDetails.add(buyerBatchOrderDetail);

            // 发生取消的场合，记录数据调用库存占用取消
            if (DecimalUtils.gt(cancelQty,BigDecimal.ZERO)){
                cancelComoMap.put(buyerBatchOrderDetail.getEntity().getBuyerBatchOrderDetailId(),buyerBatchOrderDetail);
                cancelLinvMap.put(buyerForcastDeliverDetail.getEntity().getBuyerForcastDeliverDetailId(),buyerForcastDeliverDetail);
            }
        }
        // 更新配送明细
        DistributionNotificationDetailList distributionNotificationDetailList = DistributionNotificationDetailList
                .build(distributionNotification.getBlackboard())
                .forUpdate(distributionNotificationDetails.toArray(new DistributionNotificationDetail[0]));
        distributionNotificationDetailList.modify();
        // 更新预配送明细
        BuyerForcastDeliverDetailList buyerForcastDeliverDetailList = BuyerForcastDeliverDetailList
                .build(distributionNotification.getBlackboard())
                .forUpdate(buyerForcastDeliverDetails.toArray(new BuyerForcastDeliverDetail[0]));
        buyerForcastDeliverDetailList.modify();
        // 调用库存占用取消
        if (CollectionUtils.isNotEmpty(cancelComoMap.values())){
            // 更新分批订单明细
            BuyerBatchOrderDetailList buyerBatchOrderDetailList = BuyerBatchOrderDetailList
                    .build(distributionNotification.getBlackboard())
                    .forUpdate(buyerBatchOrderDetails.toArray(new BuyerBatchOrderDetail[0]));
            buyerBatchOrderDetailList.modify();
            logger.debug("调用取消商品占用 开始");
            cancelComoAllocate(cancelComoMap);
            logger.debug("调用取消商品占用 结束");
            logger.debug("调用取消产品占用 开始");
            cancelLinvAllocate(cancelLinvMap);
            logger.debug("调用取消产品占用 结束");
        }
    }

    /**
     * 取消商品占用
     *
     * @param cancelComoMap
     */
    public void cancelComoAllocate(Map<Long,BuyerBatchOrderDetail> cancelComoMap) {
        ArrayList<LINV0104IParam> paramList = new ArrayList<>();
        for (BuyerBatchOrderDetail batchOrderDetail : cancelComoMap.values()){
            BuyerOrder buyerOrder = batchOrderDetail.getBuyerOrder();
            String sellSideType = batchOrderDetail.getBuyerForcastDeliverDetails().get(0).getEntity().getSellSideType();
                LINV0104IParam param = new LINV0104IParam();
                if (SellSideType.PLATFORM_TYPE.getCode().equals(sellSideType)){
                    param.setBizType(BizType.SellerSale.getCode());
                } else {
                    param.setBizType(BizType.AgentSale.getCode());
                }
                param.setTransactionId(buyerOrder.getEntity().getBuyerOrderId());
                param.setTransactionNo(buyerOrder.getEntity().getBuyerOrderCode());
                param.setTransactionDetailId(batchOrderDetail.getEntity().getBuyerBatchOrderDetailId());
                param.setTransactionSequence(NumberConst.IntDef.INT_ONE);
                param.setTransactionSource("ORDR");
                param.setCancelQty(batchOrderDetail.getEntity().getCancelQuantity());
                paramList.add(param);
        }
        Stock.CancelComoAllocate(paramList);
    }

    /**
     * 取消产品占用
     *
     * @param cancelLinvMap
     */
    public void cancelLinvAllocate(Map<Long,BuyerForcastDeliverDetail> cancelLinvMap) {
        ArrayList<LINV0104IParam> paramList = new ArrayList<>();
        for (BuyerForcastDeliverDetail forcastDeliverDetail : cancelLinvMap.values()){
                LINV0104IParam param = new LINV0104IParam();
                BuyerOrder buyerOrder = forcastDeliverDetail.getBuyerBatchOrder().getBuyerOrder();
                if (SellSideType.PLATFORM_TYPE.getCode().equals(forcastDeliverDetail.getEntity().getSellSideType())){
                    param.setBizType(BizType.SellerSale.getCode());
                } else {
                    param.setBizType(BizType.AgentSale.getCode());
                }
                param.setTransactionId(buyerOrder.getEntity().getBuyerOrderId());
                param.setTransactionNo(buyerOrder.getEntity().getBuyerOrderCode());
                param.setTransactionDetailId(forcastDeliverDetail.getEntity().getBuyerForcastDeliverDetailId());
                param.setTransactionSequence(NumberConst.IntDef.INT_ONE);
                param.setTransactionSource("ORDR");
                param.setCancelQty(forcastDeliverDetail.getEntity().getCancelQuantity());
                paramList.add(param);

        }
        Stock.CancelLinvAllocate(paramList);
    }
}
