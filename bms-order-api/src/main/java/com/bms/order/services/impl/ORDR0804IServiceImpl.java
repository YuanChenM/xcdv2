package com.bms.order.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.order.archive.impl.BuyerBatchOrder;
import com.bms.order.archive.impl.BuyerBatchOrderDetail;
import com.bms.order.archive.impl.BuyerForcastDeliverDetail;
import com.bms.order.archive.impl.BuyerOrder;
import com.bms.order.archive.impl.BuyerReturn;
import com.bms.order.archive.impl.BuyerReturnDetail;
import com.bms.order.archive.impl.DistributionNotification;
import com.bms.order.archive.impl.DistributionNotificationDetail;
import com.bms.order.archive.impl.Operator;
import com.bms.order.archive.impl.ReceiveNotification;
import com.bms.order.archive.impl.ReceiveNotificationDetail;
import com.bms.order.archive.impl.ReturnReason;
import com.bms.order.archive.impl.SendNotification;
import com.bms.order.archive.impl.SendNotificationDetail;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.BuyerForcastDeliverDetailEntity;
import com.bms.order.bean.entity.BuyerOrderEntity;
import com.bms.order.bean.entity.BuyerReturnDetailEntity;
import com.bms.order.bean.entity.BuyerReturnEntity;
import com.bms.order.bean.entity.DistributionNotificationDetailEntity;
import com.bms.order.bean.entity.DistributionNotificationEntity;
import com.bms.order.bean.entity.ReceiveNotificationDetailEntity;
import com.bms.order.bean.entity.ReceiveNotificationEntity;
import com.bms.order.bean.entity.ReturnReasonEntity;
import com.bms.order.bean.entity.SendNotificationEntity;
import com.bms.order.bean.param.ORDR0804IBean;
import com.bms.order.bean.param.ORDR0804ProductBean;
import com.bms.order.bean.param.ORDR0804ShipIBean;
import com.bms.order.constant.enumeration.ApplyObject;
import com.bms.order.constant.enumeration.BuyerBatchOrderStu;
import com.bms.order.constant.enumeration.BuyerOrderStu;
import com.bms.order.constant.enumeration.BuyerReturnApplyerType;
import com.bms.order.constant.enumeration.BuyerReturnMode;
import com.bms.order.constant.enumeration.BuyerReturnSource;
import com.bms.order.constant.enumeration.BuyerReturnStu;
import com.bms.order.constant.enumeration.BuyerReturnType;
import com.bms.order.constant.enumeration.DistributionNotificationStu;
import com.bms.order.constant.enumeration.OperatorType;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BuyerBatchOrderAttachedDao;
import com.bms.order.dao.BuyerBatchOrderDao;
import com.bms.order.dao.BuyerBatchOrderDetailAttachedDao;
import com.bms.order.dao.BuyerBatchOrderDetailDao;
import com.bms.order.dao.BuyerForcastDeliverDetailAttachedDao;
import com.bms.order.dao.BuyerForcastDeliverDetailDao;
import com.bms.order.dao.BuyerOrderAttachedDao;
import com.bms.order.dao.BuyerOrderDao;
import com.bms.order.dao.BuyerReturnDao;
import com.bms.order.dao.BuyerReturnDetailDao;
import com.bms.order.dao.DistributionNotificationDao;
import com.bms.order.dao.DistributionNotificationDetailDao;
import com.bms.order.dao.ReceiveNotificationDao;
import com.bms.order.dao.ReceiveNotificationDetailDao;
import com.bms.order.dao.ReturnReasonDao;
import com.bms.order.dao.SendNotificationDao;
import com.bms.order.dao.SendNotificationDetailDao;
import com.bms.order.services.ORDR0804IService;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.DecimalUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;

/**
 * 买家现场退货数据接收接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0804IServiceImpl implements ORDR0804IService {
    @Autowired
    private BaseRedisDao redisDao;
    @Autowired
    private BuyerOrderDao buyerOrderDao;// 订单
    @Autowired
    private BuyerOrderAttachedDao buyerOrderAttachedDao;
    @Autowired
    private BuyerBatchOrderDao buyerBatchOrderDao;// 分配订单
    @Autowired
    private BuyerBatchOrderAttachedDao buyerBatchOrderAttachedDao;
    @Autowired
    private BuyerBatchOrderDetailDao buyerBatchOrderDetailDao;// 分配订单明细
    @Autowired
    private BuyerBatchOrderDetailAttachedDao buyerBatchOrderDetailAttachedDao;
    @Autowired
    private BuyerForcastDeliverDetailDao buyerForcastDeliverDetailDao;// 预配送明细
    @Autowired
    private BuyerForcastDeliverDetailAttachedDao buyerForcastDeliverDetailAttachedDao;// 预配送明细附表
    @Autowired
    private DistributionNotificationDao distributionNotificationDao;// 配送通知单
    @Autowired
    private DistributionNotificationDetailDao distributionNotificationDetailDao;// 配送通知单明细
    @Autowired
    private SendNotificationDao sendNotificationDao;// 发货通知单
    @Autowired
    private SendNotificationDetailDao sendNotificationDetailDao;//发货通知单明细
    @Autowired
    private ReceiveNotificationDao receiveNotificationDao;// 收货
    @Autowired
    private ReceiveNotificationDetailDao receiveNotificationDetailDao;// 收货明细
    @Autowired
    private BuyerReturnDao buyerReturnDao;// 退货
    @Autowired
    private BuyerReturnDetailDao buyerReturnDetailDao;// 退货明细
    @Autowired
    private ReturnReasonDao returnReasonDao;// 退货原因

    /**
     * 接收配送PDA系统的迟收再配送信息，创建退货单，创建完成的退货即为已确认状态，由于是在现场发起的退货，即认为是已经确认的退货
     *
     * @param operator 操作者
     * @param bean     ORDR0803IBean
     */
    @Override
    public Long execute(Operator operator, ORDR0804IBean bean) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        String operatorType = operator.getOperatorType();
        if (!(OperatorType.MADE_4_NET.getCode().equals(operatorType) || OperatorType.MANAGER.getCode().equals(operatorType))) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080413);
        }
        blackboard.setOperator(operator);
        map.put("bean", bean);
        map.put("blackboard", blackboard);
        pre(map);
        process(map);
        post(map);
        BuyerReturn buyerReturn = (BuyerReturn) map.get("buyerReturn");
        return buyerReturn.getEntity().getReturnId();
    }

    /**
     * 准备
     *
     * @param map HashMap
     */
    private void pre(HashMap<String, Object> map) {
        // 获取参数
        ORDR0804IBean param = (ORDR0804IBean) map.get("bean");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(buyerOrderDao);
        blackboard.putBaseDao(buyerOrderAttachedDao);
        blackboard.putBaseDao(buyerBatchOrderDao);
        blackboard.putBaseDao(buyerBatchOrderAttachedDao);
        blackboard.putBaseDao(buyerBatchOrderDetailDao);
        blackboard.putBaseDao(buyerBatchOrderDetailAttachedDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailAttachedDao);
        blackboard.putBaseDao(distributionNotificationDao);
        blackboard.putBaseDao(distributionNotificationDetailDao);
        blackboard.putBaseDao(sendNotificationDao);
        blackboard.putBaseDao(sendNotificationDetailDao);
        blackboard.putBaseDao(receiveNotificationDao);
        blackboard.putBaseDao(receiveNotificationDetailDao);
        blackboard.putBaseDao(buyerReturnDao);
        blackboard.putBaseDao(buyerReturnDetailDao);
        blackboard.putBaseDao(returnReasonDao);


        //renturnMode
        Integer returnMode = param.getReturnMode();
        if (!(returnMode.toString().equals(BuyerReturnMode.ALL.getCode()) || returnMode.toString().equals(BuyerReturnMode.PART.getCode()))) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080401);
        }

        DistributionNotification distributionNotification = this.checkDistributionNotification(param, blackboard);
        this.checkAlreadyFirstReceive(distributionNotification, param);
        this.checkDeliverCodeAndReturnQty(param, distributionNotification);
        BuyerReturn buyerReturn = this.getOrderBuyerReturnAndReceiveNotice(param, distributionNotification);
        List<BuyerForcastDeliverDetail> buyerForcastDeliverDetailList = this.getBuyerForcastDeliverDetailList(distributionNotification, param);
        Map<String, Object> objectMap = this.getReceiveNotificationList(distributionNotification, param);// 收货
        List<ReceiveNotification> receiveNotificationList = (List<ReceiveNotification>) objectMap.get("receiveNotificationList");
        BigDecimal returnAmount = (BigDecimal) objectMap.get("returnAmount");
        //操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);
        // 返回参数
        map.put("buyerReturn", buyerReturn);
        map.put("returnAmount", returnAmount);
        map.put("buyerForcastDeliverDetailList", buyerForcastDeliverDetailList);
        map.put("receiveNotificationList", receiveNotificationList);
        map.put("distributionNotification", distributionNotification);
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        // 退货
        BuyerReturn buyerReturn = (BuyerReturn) map.get("buyerReturn");
        BigDecimal returnAmount = (BigDecimal) map.get("returnAmount");
        buyerReturn.getEntity().setReturnAmount(returnAmount);
        buyerReturn.create();
        buyerReturn.complete(false);
        Long returnId = buyerReturn.getEntity().getReturnId();// 退货单id

        List<ReceiveNotification> receiveNotificationList = (List<ReceiveNotification>) map.get("receiveNotificationList");             // 收货
        for (ReceiveNotification receiveNotification : receiveNotificationList) {
            Long receiveNotificationId = receiveNotification.getEntity().getReceiveNotificationId();
            if (receiveNotificationId != null) {
                //  receiveNotification.modify();
            } else {
                receiveNotification.create();
                receiveNotificationId = receiveNotification.getEntity().getReceiveNotificationId();
            }
            List<ReceiveNotificationDetail> receiveNotificationDetailList = receiveNotification.getReceiveNotificationDetails();
            for (ReceiveNotificationDetail receiveNotificationDetail : receiveNotificationDetailList) {
                Long receiveNotificationDetailId = receiveNotificationDetail.getEntity().getReceiveNotificationDetailId();
                if (receiveNotificationDetailId != null) {
                    receiveNotificationDetail.modify();

                } else {
                    receiveNotificationDetail.getEntity().setReceiveNotificationId(receiveNotificationId);
                    receiveNotificationDetail.create();
                    receiveNotificationDetailId = receiveNotificationDetail.getEntity().getReceiveNotificationDetailId();

                }
                //  生成对应的 退货明细：收货明细=1:1  在迟收 拒收中
                List<BuyerReturnDetail> buyerReturnDetailList = receiveNotificationDetail.getBuyerReturnDetails();
                if (CollectionUtils.isNotEmpty(buyerReturnDetailList)) {
                    for (BuyerReturnDetail buyerReturnDetail : buyerReturnDetailList) {
                        BuyerReturnDetailEntity buyerReturnDetailEntity = buyerReturnDetail.getEntity();
                        Long detailId = buyerReturnDetailEntity.getDetailId();
                        if(detailId==null){
                            buyerReturnDetailEntity.setReturnId(returnId);//  退货单id
                            buyerReturnDetailEntity.setReceiveNotificationId(receiveNotificationId);// 收货id
                            buyerReturnDetailEntity.setReceiveNotificationDetailId(receiveNotificationDetailId);// 收货明细id
                            buyerReturnDetailEntity.setReasonId(buyerReturn.getEntity().getReturnReasonId());
                            buyerReturnDetail.create();
                        }
                    }
                }

            }
        }


        //  预配送
        List<BuyerForcastDeliverDetail> buyerForcastDeliverDetailList = (List<BuyerForcastDeliverDetail>) map.get("buyerForcastDeliverDetailList");
        if (CollectionUtils.isNotEmpty(buyerForcastDeliverDetailList)) {
            for (BuyerForcastDeliverDetail buyerForcastDeliverDetail : buyerForcastDeliverDetailList) {
                buyerForcastDeliverDetail.modify();
            }
        }
        // 配送
        DistributionNotification dbDistributionNotification = (DistributionNotification) map.get("distributionNotification");
        DistributionNotification distributionNotification = this.getDistributionNotification(dbDistributionNotification);
        distributionNotification.modify();
        // 分批订单
        Collection<BuyerBatchOrder> buyerBatchOrderList = this.getBatchBuyerOrderList(distributionNotification);
        if (CollectionUtils.isNotEmpty(buyerBatchOrderList)) {
            for (BuyerBatchOrder buyerBatchOrder : buyerBatchOrderList) {
                buyerBatchOrder.modify();//  修改
            }
        }

        BuyerOrder buyerOrder = this.getBuyerOrder(distributionNotification);
        if (buyerOrder != null) {// 修改订单的状态
            buyerOrder.modify();
        }

        // 执行操作

    }

    /**
     * 收尾
     *
     * @param map HashMap
     */
    private void post(HashMap<String, Object> map) {
        // 获取参数

        // 执行操作

    }

    /**
     * 拒收数量判断：
     * 拒收数量 != 发货数量时，报错，提示必须先调用收货接口
     * 判断是否需要调用  收货
     *
     * @param distributionNotification
     * @param bean
     */
    public void checkAlreadyFirstReceive(DistributionNotification distributionNotification, ORDR0804IBean bean) {
        Integer returnMode = bean.getReturnMode();
        BigDecimal allDistributionQuantity = null;
        if (returnMode.toString().equals(BuyerReturnMode.PART.getCode())) {
            List<DistributionNotificationDetail> distributionNotificationDetailList = distributionNotification.getDistributionNotificationDetails();
            for (DistributionNotificationDetail distributionNotificationDetail : distributionNotificationDetailList) {
                BigDecimal distributionQuantity = DecimalUtils.subtract(distributionNotificationDetail.getEntity().getDistributionQuantity(),distributionNotificationDetail.getEntity().getCancelQuantity());
                allDistributionQuantity = DecimalUtils.add(allDistributionQuantity, distributionQuantity);
            }

            BigDecimal allRejectQty = null;
            List<ORDR0804ShipIBean> shipList = bean.getShipList();
            for (ORDR0804ShipIBean ship : shipList) {
                List<ORDR0804ProductBean> productList = ship.getProductList();
                for (ORDR0804ProductBean product : productList) {
                    BigDecimal rejectQty = product.getReturnQty();
                    allRejectQty = DecimalUtils.add(allRejectQty, rejectQty);
                }
            }
            if (!DecimalUtils.eq(allDistributionQuantity, allRejectQty)) {// 如果不是全部拒收 需要先收货
                List<ReceiveNotification> receiveNotificationList = distributionNotification.getReceiveNotifications();
                if (CollectionUtils.isEmpty(receiveNotificationList)) {// 没有收货
                    throw new BusinessException(ModuleCode.ORDR, "不是全部拒收，需要先调用收货");
                }
            }

        }
    }


    /**
     * 1配送状态只能为“配送中”或“部分收货”
     * buyerId,buyerCode
     *
     * @param param
     * @param blackboard
     * @return
     */
    public DistributionNotification checkDistributionNotification(ORDR0804IBean param, Blackboard blackboard) {
        Long shipIdOfLong = null;
        try {
            shipIdOfLong = Long.parseLong(param.getShipId());
        } catch (Exception e) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080402);
        }
        DistributionNotification distributionNotification = new DistributionNotification(shipIdOfLong);
        distributionNotification.setBlackboard(blackboard);
        distributionNotification.complete(false);
        if (!distributionNotification.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080402);
        }
        DistributionNotificationEntity distributionNotificationEntity = distributionNotification.getEntity();
        String stu = distributionNotificationEntity.getDistributionNotificationStu();

        if (!(DistributionNotificationStu.IN_DISTRIBUTION.getCode().equals(stu) || DistributionNotificationStu.PARTIAL_RECEIPT.getCode().equals(stu))) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080403);
        }


        // 判断 buyer  buyerId  buyerCode
        BuyerOrder buyerOrder = distributionNotification.getBuyerOrder();
        String dbBuyerId = buyerOrder.getEntity().getBuyerId();
        if (!param.getBuyerId().equals(dbBuyerId)) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080404);
        }
        String dbBuyerCode = buyerOrder.getAttachedEntity().getBuyerCode();
        if (!param.getBuyerCode().equals(dbBuyerCode)) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080405);
        }
        return distributionNotification;
    }


    /**
     * 查询对应的配送信息，退货迟收数量必须小于等于 配送明细表中发货数量 - 收货明细中收货数量合计 - 收货明细拒收数量合计 - 收货明细退货数量合计
     * 对于传入的SKU也需要和配送单明细中SKU进行验证
     *
     * @param bean                     入参
     * @param distributionNotification 配送通知单
     * @return
     */
    public void checkDeliverCodeAndReturnQty(ORDR0804IBean bean, DistributionNotification distributionNotification) {
        Blackboard blackboard = distributionNotification.getBlackboard();
        this.checkReturnReason(bean.getReturnReasonID(), blackboard);
        List<ORDR0804ShipIBean> shipList = bean.getShipList();
        if (CollectionUtils.isNotEmpty(shipList)) {
            Map<String, String> map = new HashMap<>();
            for (ORDR0804ShipIBean ship : shipList) {
                String diverCode = ship.getDeliverCode();//WMS配送单号   发货单中
                List<ORDR0804ProductBean> productList = ship.getProductList();
                if (CollectionUtils.isNotEmpty(productList)) {
                    for (ORDR0804ProductBean product : productList) {
                        this.checkCanReturnQtyAndSkuByProduct(diverCode, product, blackboard, map);
                    }
                }
            }
        }
    }


    /**
     * 2 查询对应的配送信息，退货迟收数量必须小于等于 配送明细表中发货数量 - 收货明细中收货数量合计 - 收货明细拒收数量合计 - 收货明细退货数量合计
     * 3 对于传入的SKU也需要和配送单明细中SKU进行验证
     *
     * @param diverCode  发货单中的配送单号
     * @param product
     * @param blackboard
     */
    public void checkCanReturnQtyAndSkuByProduct(String diverCode, ORDR0804ProductBean product, Blackboard blackboard, Map<String, String> map) {
        Long shipDetailId = product.getShipDetailId();//原发货明细ID
        String key = diverCode.trim() + shipDetailId;
        String productSkuCode = product.getSkuCode();
        String value = map.get(key);
        if (StringUtils.isNotEmpty(value)) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080313);
        }
        map.put(key, productSkuCode);
        Long detailReasonID = product.getDetailReasonID();
        if (detailReasonID != null) {
            this.checkReturnReason(detailReasonID, blackboard);
        }
        DistributionNotificationDetail distributionNotificationDetail = new DistributionNotificationDetail(shipDetailId);
        distributionNotificationDetail.setBlackboard(blackboard);
        distributionNotificationDetail.complete(false);
        if (!distributionNotificationDetail.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR, "配送明细错误！shipDetailId", shipDetailId.toString());
        }
        List<SendNotificationDetail> sendNotificationDetailList = distributionNotificationDetail.getSendNotificationDetails();
        if (CollectionUtils.isEmpty(sendNotificationDetailList)) {
            throw new BusinessException(ModuleCode.ORDR, "配送明细错误！shipDetailId", shipDetailId.toString());
        }
        SendNotificationDetail sendNotificationDetail = sendNotificationDetailList.get(0);
        SendNotification sendNotification = sendNotificationDetail.getSendNotification();// 发货单
        if (!diverCode.equals(sendNotification.getEntity().getSendNotificationCode())) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080407);
        }
        BuyerForcastDeliverDetail buyerForcastDeliverDetail = distributionNotificationDetail.getBuyerForcastDeliverDetail();
        if (!buyerForcastDeliverDetail.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080408);
        }
        BuyerForcastDeliverDetailEntity buyerForcastDeliverDetailEntity = buyerForcastDeliverDetail.getEntity();

        BigDecimal realSendQuantity = buyerForcastDeliverDetailEntity.getRealSendQuantity();//实际发货数量
        BigDecimal receiveQuantity = buyerForcastDeliverDetailEntity.getReceiveQuantity();//收货数量
        BigDecimal rejectQuantity = buyerForcastDeliverDetailEntity.getRejectQuantity();// 拒收数量
        BigDecimal returnQuantity = buyerForcastDeliverDetailEntity.getReturnQuantity();// 退货数量
        BigDecimal delayQuantity = buyerForcastDeliverDetailEntity.getDelayQuantity();// 迟收数量

        BigDecimal sum = DecimalUtils.add(receiveQuantity, rejectQuantity);
        sum = DecimalUtils.add(sum, returnQuantity);
        sum = DecimalUtils.add(sum, delayQuantity);
        BigDecimal canReturnQty = DecimalUtils.subtract(realSendQuantity, sum);

        BigDecimal preReturnQty = product.getReturnQty();// 准备退货的数量
        if (DecimalUtils.lt(canReturnQty, preReturnQty)) {//  可退的小于 准备退得
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080409);
        }
        String dbSku = distributionNotificationDetail.getEntity().getSku();
        if (!productSkuCode.equals(dbSku)) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080410);
        }
    }

    /**
     * 1	买家退货主表数据，退货类型为：拒收退货
     * 获取 退货单
     *
     * @param param
     * @return
     */
    public BuyerReturn getOrderBuyerReturnAndReceiveNotice(ORDR0804IBean param, DistributionNotification distributionNotification) {
        BuyerOrder buyerOrder = distributionNotification.getBuyerOrder();
        //  拒收退货单
        BuyerReturnEntity buyerReturnEntity = new BuyerReturnEntity();
        buyerReturnEntity.setOrderId(buyerOrder.getEntity().getBuyerOrderId());// 订单id
        buyerReturnEntity.setBuyerId(buyerOrder.getEntity().getBuyerId());
        buyerReturnEntity.setBuyerCode(buyerOrder.getAttachedEntity().getBuyerCode());// 买家编码
        buyerReturnEntity.setBuyerName(buyerOrder.getAttachedEntity().getBuyerName());//设置买家名称 [买家名称，冗余]
        buyerReturnEntity.setApplyRemark(param.getApplyRemark());
        buyerReturnEntity.setApplyTime(DateUtils.parseDateTime(param.getApplyTime()));
        buyerReturnEntity.setApplyUid(null);//退货申请人ID
        buyerReturnEntity.setApplyUname(param.getApplyMan());// 申请人姓名
        buyerReturnEntity.setBuyerApplyUserType(BuyerReturnApplyerType.BUYER.getCode());//设置买家退货申请人类型 [退货申请人类型]
        buyerReturnEntity.setBuyerReturnSource(BuyerReturnSource.DISTRIBUTION_SYSTEM.getCode());//设置买家退货单来源 [退货单系统来源-CodeMaster  * 1-司机PDA，2-云冻品平台，3-云冻品B2B平台]  todo 常量
        buyerReturnEntity.setBuyerReturnStatus(BuyerReturnStu.CONFIRMED.getCode());// 退货单状态  已确认
        buyerReturnEntity.setBuyerReturnType(BuyerReturnType.REJECT_RETURN.getCode());// 设置买家退货类型 [买家退货类型-CodeMaster * 1-迟收；2-拒收；3-退货]
        buyerReturnEntity.setImage1(param.getImage1());
        buyerReturnEntity.setImage2(param.getImage2());
        buyerReturnEntity.setImage3(param.getImage3());
        buyerReturnEntity.setImage4(param.getImage4());
        buyerReturnEntity.setImage5(param.getImage5());
        buyerReturnEntity.setReturnReasonId(param.getReturnReasonID());
        BuyerReturn buyerReturn = new BuyerReturn(buyerReturnEntity);
        buyerReturn.setBlackboard(distributionNotification.getBlackboard());
        return buyerReturn;
    }


    /**
     * 2	买家退货明细数据
     *
     * @return
     */

    /**
     * 预配送明细
     *
     * @param distributionNotification
     * @param param
     * @return
     */
    public List<BuyerForcastDeliverDetail> getBuyerForcastDeliverDetailList(DistributionNotification distributionNotification, ORDR0804IBean param) {
        List<BuyerForcastDeliverDetail> buyerForcastDeliverDetailList = new ArrayList<>();//预配送明细
        Blackboard blackboard = distributionNotification.getBlackboard();
        if (param.getReturnMode().toString().equals(BuyerReturnMode.ALL.getCode())) {// 全部  迟收模式：1-全部，整单发货单SHIPID全部迟收，无需关注ShipList部分【2016/10/11】，2-部分
            List<DistributionNotificationDetail> distributionNotificationDetailList = distributionNotification.getDistributionNotificationDetails();
            if (CollectionUtils.isNotEmpty(distributionNotificationDetailList)) {
                for (DistributionNotificationDetail distributionNotificationDetail : distributionNotificationDetailList) {//  配送明细:退货明细=1:1
                    DistributionNotificationDetailEntity distributionNotificationDetailEntity = distributionNotificationDetail.getEntity();
                    //预配送明细
                    BuyerForcastDeliverDetail buyerForcastDeliverDetail = distributionNotificationDetail.getBuyerForcastDeliverDetail();
                    buyerForcastDeliverDetail.getEntity().setRejectQuantity(DecimalUtils.subtract(distributionNotificationDetailEntity.getDistributionQuantity(),distributionNotificationDetailEntity.getCancelQuantity()));
                    buyerForcastDeliverDetail.setBlackboard(blackboard);
                    buyerForcastDeliverDetailList.add(buyerForcastDeliverDetail);

                }
            }
        } else if (param.getReturnMode().toString().equals(BuyerReturnMode.PART.getCode())) {// 部分
            List<ORDR0804ShipIBean> shipList = param.getShipList();//  发货单
            if (CollectionUtils.isNotEmpty(shipList)) {
                for (ORDR0804ShipIBean shipIBean : shipList) {
                    List<ORDR0804ProductBean> productBeanLis = shipIBean.getProductList();// 商品
                    if (CollectionUtils.isNotEmpty(productBeanLis)) {
                        for (ORDR0804ProductBean productBean : productBeanLis) {
                            Long shipDetailId = productBean.getShipDetailId();
                            DistributionNotificationDetail distributionNotificationDetail = new DistributionNotificationDetail(shipDetailId);
                            distributionNotificationDetail.setBlackboard(blackboard);
                            distributionNotificationDetail.complete(false);
                            //预配送明细
                            BuyerForcastDeliverDetail buyerForcastDeliverDetail = distributionNotificationDetail.getBuyerForcastDeliverDetail();
                            BigDecimal rejectQuantity = buyerForcastDeliverDetail.getEntity().getRejectQuantity();
                            BigDecimal sum = DecimalUtils.add(rejectQuantity, productBean.getReturnQty());
                            buyerForcastDeliverDetail.getEntity().setRejectQuantity(sum);// 拒收数量
                            buyerForcastDeliverDetail.setBlackboard(blackboard);
                            buyerForcastDeliverDetailList.add(buyerForcastDeliverDetail);
                        }
                    }
                }
            }
        }
        return buyerForcastDeliverDetailList;
    }


    /**
     * 根据拒收退货的数量与对应配送通知明细中数量、分批订单明细的数量进行对比判定，若全部拒收，对应的配送单、分批订单需要更新状态为全部拒收
     * 配送通知单状态
     *
     * @param distributionNotification
     * @return
     */
    public DistributionNotification getDistributionNotification(DistributionNotification distributionNotification) {
        DistributionNotificationEntity distributionNotificationEntity = distributionNotification.getEntity();
        List<DistributionNotificationDetail> distributionNotificationDetailList = distributionNotification.getDistributionNotificationDetails();
        BigDecimal allDistributionQuantity = null;// 所有配送数量
        for (DistributionNotificationDetail distributionNotificationDetail : distributionNotificationDetailList) {
            DistributionNotificationDetailEntity distributionNotificationDetailEntity = distributionNotificationDetail.getEntity();
            BigDecimal distributionQuantity = DecimalUtils.subtract(distributionNotificationDetailEntity.getDistributionQuantity(),distributionNotificationDetailEntity.getCancelQuantity());
            allDistributionQuantity = DecimalUtils.add(allDistributionQuantity, distributionQuantity);
        }
        BigDecimal allReceiveQty = null;
        BigDecimal allDelayQty = null;
        BigDecimal allRejectQty = null;
        List<ReceiveNotification> receiveNotificationList = distributionNotification.getReceiveNotifications();
        for (ReceiveNotification receiveNotification : receiveNotificationList) {
            List<ReceiveNotificationDetail> receiveNotificationDetailList = receiveNotification.getReceiveNotificationDetails();
            for (ReceiveNotificationDetail receiveNotificationDetail : receiveNotificationDetailList) {
                ReceiveNotificationDetailEntity receiveNotificationDetailEntity = receiveNotificationDetail.getEntity();
                BigDecimal receiveQuantity = receiveNotificationDetailEntity.getReceiveQuantity();
                BigDecimal delayQty = receiveNotificationDetailEntity.getDelayQuantity();
                BigDecimal rejectQty = receiveNotificationDetailEntity.getRejectQuantity();
                allReceiveQty = DecimalUtils.add(allReceiveQty, receiveQuantity);
                allDelayQty = DecimalUtils.add(allDelayQty, delayQty);
                allRejectQty = DecimalUtils.add(allRejectQty, rejectQty);
            }
        }
        BigDecimal realReceiveQty = DecimalUtils.add(DecimalUtils.add(allReceiveQty, allRejectQty), allDelayQty);
        if (DecimalUtils.eq(allRejectQty, allDistributionQuantity)) {// 全部拒收
            distributionNotificationEntity.setDistributionNotificationStu(DistributionNotificationStu.ALL_RETURN.getCode());
        } else if (DecimalUtils.eq(realReceiveQty, allDistributionQuantity)) { // 收货数量+迟收=配送数量  完成
            distributionNotificationEntity.setDistributionNotificationStu(DistributionNotificationStu.RECEIPT_FINISH.getCode());
        }
        return distributionNotification;
    }

    /**
     * 判断 分配订单的状态
     *
     * @param distributionNotification
     * @return
     */
    public Collection<BuyerBatchOrder> getBatchBuyerOrderList(DistributionNotification distributionNotification) {
        distributionNotification.complete(false);
        Map<Long, BuyerBatchOrder> buyerBatchOrderMap = new HashMap<>();
        List<DistributionNotificationDetail> distributionNotificationDetails = distributionNotification
                .getDistributionNotificationDetails();
        for (DistributionNotificationDetail distributionNotificationDetail : distributionNotificationDetails) {
            BuyerBatchOrder buyerBatchOrder = distributionNotificationDetail.getBuyerForcastDeliverDetail()
                    .getBuyerBatchOrder();
            Long buyerBatchOrderId = buyerBatchOrder.getEntity().getBuyerBatchOrderId();
            BuyerBatchOrder mapOfBuyerBatchOrder = buyerBatchOrderMap.get(buyerBatchOrderId);
            if (mapOfBuyerBatchOrder == null) {
                buyerBatchOrderMap.put(buyerBatchOrderId, buyerBatchOrder);
            }
        }
        Collection<BuyerBatchOrder> buyerBatchOrderList = buyerBatchOrderMap.values();
        for (BuyerBatchOrder buyerBatchOrder : buyerBatchOrderList) {
            BigDecimal batchOrderRealSendQuantity = BigDecimal.ZERO; // 应该发货数量
            BigDecimal batchOrderReceiveQuantity = BigDecimal.ZERO;  // 收货数量
            BigDecimal batchOrderRejectQuantity = BigDecimal.ZERO;  // 拒收数量
            BigDecimal batchOrderDelayQuantity = BigDecimal.ZERO;  // 迟收数量
            BigDecimal batchOrderReturnQuantity = BigDecimal.ZERO; // 退货数量
            List<BuyerForcastDeliverDetail> forcastDeliverDetails = buyerBatchOrder.getBuyerForcastDeliverDetails();
            //预配送明细 为判断单位
            for (BuyerForcastDeliverDetail buyerForcastDeliverDetail : forcastDeliverDetails) {
                BuyerForcastDeliverDetailEntity buyerForcastDeliverDetailEntity = buyerForcastDeliverDetail.getEntity();
                BigDecimal realSendQuantity = buyerForcastDeliverDetailEntity.getRealSendQuantity();
                BigDecimal receiveQuantity = buyerForcastDeliverDetailEntity.getReceiveQuantity();
                BigDecimal rejectQuantity = buyerForcastDeliverDetailEntity.getRejectQuantity();
                BigDecimal delayQuantity = buyerForcastDeliverDetailEntity.getDelayQuantity();
                BigDecimal sum = DecimalUtils.add(DecimalUtils.add(receiveQuantity, rejectQuantity), delayQuantity);
                if (DecimalUtils.gt(sum, BigDecimal.ZERO)) {// 没有数据  就是                 新生成的
                    batchOrderRealSendQuantity = DecimalUtils.add(batchOrderRealSendQuantity, realSendQuantity);
                    batchOrderReceiveQuantity = DecimalUtils.add(batchOrderReceiveQuantity, receiveQuantity);
                    batchOrderRejectQuantity = DecimalUtils.add(batchOrderRejectQuantity, rejectQuantity);
                    batchOrderDelayQuantity = DecimalUtils.add(batchOrderDelayQuantity, delayQuantity);
                }
            }
            BigDecimal receiveAddRejectQty = DecimalUtils.add(batchOrderReceiveQuantity, batchOrderRejectQuantity);
            if (DecimalUtils.eq(batchOrderRealSendQuantity, batchOrderRejectQuantity)) {// 全部拒收
                buyerBatchOrder.getEntity().setBuyerBatchOrderStu(BuyerBatchOrderStu.ALL_RETURN.getCode());   // 全部拒收
            } else if (DecimalUtils.gt(batchOrderReceiveQuantity,BigDecimal.ZERO)&&DecimalUtils.eq(batchOrderRealSendQuantity, receiveAddRejectQty)) {// 有收货  有拒收
                buyerBatchOrder.getEntity().setBuyerBatchOrderStu(BuyerBatchOrderStu.RECEIPT_FINISH.getCode());   // 收货完成
            } else if (DecimalUtils.gt(batchOrderRealSendQuantity, receiveAddRejectQty) && DecimalUtils.gt(batchOrderReceiveQuantity, BigDecimal.ZERO)) {
                buyerBatchOrder.getEntity().setBuyerBatchOrderStu(BuyerBatchOrderStu.PARTIAL_RECEIPT.getCode());   // 部分收货
            }
        }
        return buyerBatchOrderList;
    }


    /**
     * 获取订单
     *
     * @param distributionNotification
     * @return
     */
    public BuyerOrder getBuyerOrder(DistributionNotification distributionNotification) {
        Long buyerOrderId = distributionNotification.getBuyerOrder().getEntity().getBuyerOrderId();
        BuyerOrder buyerOrder = new BuyerOrder(buyerOrderId);
        buyerOrder.setBlackboard(distributionNotification.getBlackboard());
        buyerOrder.complete(false);
        int cancelCount = 0; // 取消
        int finishCount = 0;  // 完成
        int returnCount = 0;// 拒收
        List<BuyerBatchOrder> buyerBatchOrders = buyerOrder.getBuyerBatchOrders();
        for (BuyerBatchOrder buyerBatchOrder : buyerBatchOrders) {
            String buyerBatchOrderStu = buyerBatchOrder.getEntity().getBuyerBatchOrderStu();// 分批订单状态
            if (buyerBatchOrderStu.equals(BuyerBatchOrderStu.CANCEL.getCode())) {
                cancelCount = cancelCount + 1;
            }
            if (buyerBatchOrderStu.equals(BuyerBatchOrderStu.RECEIPT_FINISH.getCode())) {
                finishCount = finishCount + 1;
            }

            if (buyerBatchOrderStu.equals(BuyerBatchOrderStu.ALL_RETURN.getCode())) {
                returnCount = returnCount + 1;
            }
        }
        int buyerBatchOrderSize = buyerBatchOrders.size();
        BuyerOrderEntity buyerOrderEntity = buyerOrder.getEntity();
        if (buyerBatchOrderSize == cancelCount) {// 全部取消
            buyerOrderEntity.setBuyerOrderStu(BuyerOrderStu.CANCEL.getCode());
        }
        if (buyerBatchOrderSize == returnCount) {// 全部退货
            buyerOrderEntity.setBuyerOrderStu(BuyerOrderStu.RETURNED.getCode());
        }
        if (finishCount > 0 && buyerBatchOrderSize == (finishCount + cancelCount + returnCount)) {// 收货完成
            buyerOrderEntity.setBuyerOrderStu(BuyerOrderStu.ALREADY_COMPLETED.getCode());
        }
        return buyerOrder;
    }


    /**
     * @param returnReasonId
     * @param blackboard
     */
    public void checkReturnReason(Long returnReasonId, Blackboard blackboard) {
        ReturnReason returnReason = new ReturnReason(returnReasonId);
        returnReason.setBlackboard(blackboard);
        returnReason.complete(false);
        if (!returnReason.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080411);
        }
        ReturnReasonEntity returnReasonEntity = returnReason.getEntity();
        String applyObject = returnReasonEntity.getApplyObject();//适用对象 [使用对象,001-买家，002-买手]
        String applyType = returnReasonEntity.getApplyType();//获取适用类型 [以逗号分隔的退货类型]
        if (!(applyObject != null && applyObject.contains(ApplyObject.BUYER.getCode()))) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080412);
        }
        if (!(applyType != null && applyType.contains(BuyerReturnType.REJECT_RETURN.getCode()))) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080412);
        }
    }

    /**
     * 获取对应的 收货和收货明细
     *
     * @param distributionNotification
     * @param param
     * @return
     */
    public Map<String, Object> getReceiveNotificationList(DistributionNotification distributionNotification, ORDR0804IBean param) {
        List<ReceiveNotification> receiveNotificationList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        BigDecimal returnAmount = new BigDecimal(0);
        String distributionNotificationCode = distributionNotification.getEntity().getDistributionNotificationCode();
        if (param.getReturnMode().toString().equals(BuyerReturnMode.ALL.getCode())) {// 全部
            List<SendNotification> sendNotifications = distributionNotification.getSendNotifications();
            for (SendNotification sendNotification : sendNotifications) {// 发货单：收货单  1:1
                SendNotificationEntity sendNotificationEntity = sendNotification.getEntity();
                ReceiveNotification receiveNotification = this.getReceiveNotificationByDeliverCodeAndDistributionNotificationCode(distributionNotification.getReceiveNotifications(), sendNotificationEntity.getSendNotificationCode(), distributionNotificationCode);
                if (receiveNotification == null) {// 没有生成收货单
                    ReceiveNotificationEntity receiveNotificationEntity = new ReceiveNotificationEntity();// 新建
                    receiveNotificationEntity.setDistributionNotificationCode(distributionNotification.getEntity().getDistributionNotificationCode());// 配送单
                    receiveNotificationEntity.setDistributionNotificationId(new Long(param.getShipId()));// 配送单id
                    receiveNotificationEntity.setSendNotificationCode(sendNotification.getEntity().getSendNotificationCode());// 发货单编号
                    receiveNotificationEntity.setSendNotificationId(sendNotification.getEntity().getSendNotificationId());// 发货单Id
                    receiveNotification = new ReceiveNotification(receiveNotificationEntity);
                    receiveNotification.setBlackboard(distributionNotification.getBlackboard());
                }
                List<SendNotificationDetail> sendNotificationDetails = sendNotification.getSendNotificationDetails();
                List<ReceiveNotificationDetail> receiveNotificationDetails = new ArrayList<>();
                for (SendNotificationDetail sendNotificationDetail : sendNotificationDetails) {
                    DistributionNotificationDetail distributionNotificationDetail = sendNotificationDetail.getDistributionNotificationDetail();
                    DistributionNotificationDetailEntity distributionNotificationDetailEntity = distributionNotificationDetail.getEntity();
                    Long distributionNotificationDetailId = distributionNotificationDetailEntity.getDistributionNotificationDetailId();
                    BuyerBatchOrderDetail buyerBatchOrderDetail = distributionNotificationDetail.getBuyerForcastDeliverDetail().getBuyerBatchOrderDetail();
                    BigDecimal realUnitPrice = buyerBatchOrderDetail.getEntity().getRealUnitPrice();
                    ReceiveNotificationDetail receiveNotificationDetail = this.getReceiveNotificationDetailByDistributionNotificationDetailId(receiveNotification, distributionNotificationDetailId);
                    if (receiveNotificationDetail != null) {// 已经生成
                        ReceiveNotificationDetailEntity receiveNotificationDetailEntity = receiveNotificationDetail.getEntity();
                        receiveNotificationDetailEntity.setRejectQuantity(sendNotificationDetail.getEntity().getRealSendQuantity());// 全部拒收
                        BuyerReturnDetailEntity buyerReturnDetailEntity = new BuyerReturnDetailEntity();
                        buyerReturnDetailEntity.setDistributionNotificationId(distributionNotificationDetailEntity.getDistributionNotificationId());//配送单ID
                        buyerReturnDetailEntity.setDistributionNotificationDetailId(distributionNotificationDetailEntity.getDistributionNotificationDetailId());//配送明细ID
                        buyerReturnDetailEntity.setGoodsId(distributionNotificationDetailEntity.getGoodsId());//商品ID
                        buyerReturnDetailEntity.setSalesUnit(distributionNotificationDetailEntity.getGoodsUnit());//销售单位
                        buyerReturnDetailEntity.setReturnQty(DecimalUtils.subtract(distributionNotificationDetailEntity.getDistributionQuantity(),distributionNotificationDetailEntity.getCancelQuantity()));//拒退数量
                        buyerReturnDetailEntity.setReceiveNotificationDetailId(receiveNotificationDetailEntity.getReceiveNotificationDetailId());
                        BuyerReturnDetail buyerReturnDetail = new BuyerReturnDetail(buyerReturnDetailEntity);
                        buyerReturnDetail.setBlackboard(distributionNotification.getBlackboard());
                        List<BuyerReturnDetail> buyerReturnDetailList = new ArrayList<>();
                        buyerReturnDetailList.add(buyerReturnDetail);
                        receiveNotificationDetail.link(buyerReturnDetailList);                                    // 绑定配送明细
                        receiveNotificationDetail.buyerReturnDetailsLinked();


                    } else {// 没有生成
                        ReceiveNotificationDetailEntity receiveNotificationDetailEntity = new ReceiveNotificationDetailEntity();
                        receiveNotificationDetailEntity.setReceiveNotificationId(receiveNotification.getEntity().getReceiveNotificationId());
                        receiveNotificationDetailEntity.setDistributionNotificationDetailId(distributionNotificationDetailEntity.getDistributionNotificationDetailId());//配送明细ID
                        receiveNotificationDetailEntity.setGoodsId(distributionNotificationDetailEntity.getGoodsId());//商品ID
                        receiveNotificationDetailEntity.setSku(distributionNotificationDetailEntity.getSku());//
                        receiveNotificationDetailEntity.setBatch(distributionNotificationDetailEntity.getBatchCode());//批次	BATCH
                        receiveNotificationDetailEntity.setRejectQuantity(DecimalUtils.subtract(distributionNotificationDetailEntity.getDistributionQuantity(), distributionNotificationDetailEntity.getCancelQuantity()));// 拒收数量
                        receiveNotificationDetailEntity.setPricePlateUnitPrice(null);// 价盘单价
                        receiveNotificationDetail = new ReceiveNotificationDetail(receiveNotificationDetailEntity);
                        receiveNotificationDetail.setBlackboard(distributionNotification.getBlackboard());
                        BuyerReturnDetailEntity buyerReturnDetailEntity = new BuyerReturnDetailEntity();
                        buyerReturnDetailEntity.setDistributionNotificationId(distributionNotificationDetailEntity.getDistributionNotificationId());//配送单ID
                        buyerReturnDetailEntity.setDistributionNotificationDetailId(distributionNotificationDetailEntity.getDistributionNotificationDetailId());//配送明细ID
                        buyerReturnDetailEntity.setGoodsId(distributionNotificationDetailEntity.getGoodsId());//商品ID
                        buyerReturnDetailEntity.setSalesUnit(distributionNotificationDetailEntity.getGoodsUnit());//销售单位
                        buyerReturnDetailEntity.setReturnQty(DecimalUtils.subtract(distributionNotificationDetailEntity.getDistributionQuantity(), distributionNotificationDetailEntity.getCancelQuantity()));//拒收数量
                        BuyerReturnDetail buyerReturnDetail = new BuyerReturnDetail(buyerReturnDetailEntity);
                        buyerReturnDetail.setBlackboard(distributionNotification.getBlackboard());
                        List<BuyerReturnDetail> buyerReturnDetailList = new ArrayList<>();
                        buyerReturnDetailList.add(buyerReturnDetail);
                        receiveNotificationDetail.link(buyerReturnDetailList);                                    // 绑定配送明细
                        receiveNotificationDetail.buyerReturnDetailsLinked();


                    }

                    receiveNotificationDetails.add(receiveNotificationDetail);
                    BigDecimal returnDetailAmount = DecimalUtils.multiply(realUnitPrice, DecimalUtils.subtract(distributionNotificationDetailEntity.getDistributionQuantity(), distributionNotificationDetailEntity.getCancelQuantity()));
                    returnAmount = DecimalUtils.add(returnAmount, returnDetailAmount);
                }
                receiveNotification.link(receiveNotificationDetails);
                receiveNotification.receiveNotificationDetailsLinked();
                receiveNotificationList.add(receiveNotification);
            }

        } else if (param.getReturnMode().toString().equals(BuyerReturnMode.PART.getCode())) {// 部分
            List<SendNotification> sendNotificationList = distributionNotification.getSendNotifications();
            List<ORDR0804ShipIBean> shipList = param.getShipList();
            for (ORDR0804ShipIBean ship : shipList) {
                String deliverCode = ship.getDeliverCode();// 发货单编码
                SendNotification sendNotification = this.getSendNotificationByDeliverCode(sendNotificationList, deliverCode);// 发货单
                ReceiveNotification receiveNotification = this.getReceiveNotificationByDeliverCodeAndDistributionNotificationCode(distributionNotification.getReceiveNotifications(), deliverCode, distributionNotificationCode);
                if (receiveNotification == null) {// 数据库不存在
                    ReceiveNotificationEntity receiveNotificationEntity = new ReceiveNotificationEntity();// 新建
                    receiveNotificationEntity.setDistributionNotificationCode(distributionNotification.getEntity().getDistributionNotificationCode());// 配送单
                    receiveNotificationEntity.setDistributionNotificationId(new Long(param.getShipId()));// 配送单id
                    receiveNotificationEntity.setSendNotificationCode(sendNotification.getEntity().getSendNotificationCode());// 发货单id
                    receiveNotificationEntity.setSendNotificationId(sendNotification.getEntity().getSendNotificationId());// 发货单编码
                    receiveNotification = new ReceiveNotification(receiveNotificationEntity);
                    receiveNotification.setBlackboard(distributionNotification.getBlackboard());
                }
                List<ORDR0804ProductBean> productList = ship.getProductList();
                List<ReceiveNotificationDetail> receiveNotificationDetails = new ArrayList<>();
                for (ORDR0804ProductBean product : productList) {// 对应的发货明细
                    Long shipDetailId = product.getShipDetailId();
                    DistributionNotificationDetail distributionNotificationDetail = new DistributionNotificationDetail(shipDetailId);
                    distributionNotificationDetail.setBlackboard(distributionNotification.getBlackboard());
                    distributionNotificationDetail.complete(false);
                    DistributionNotificationDetailEntity distributionNotificationDetailEntity = distributionNotificationDetail.getEntity();
                    Long distributionNotificationDetailId = distributionNotificationDetailEntity.getDistributionNotificationDetailId();
                    ReceiveNotificationDetail receiveNotificationDetail = this.getReceiveNotificationDetailByDistributionNotificationDetailId(receiveNotification, distributionNotificationDetailEntity.getDistributionNotificationDetailId());
                    BuyerBatchOrderDetail buyerBatchOrderDetail = distributionNotificationDetail.getBuyerForcastDeliverDetail().getBuyerBatchOrderDetail();
                    BigDecimal realUnitPrice = buyerBatchOrderDetail.getEntity().getRealUnitPrice();
                    BigDecimal qty = product.getReturnQty();
                    if (receiveNotificationDetail != null) {
                        ReceiveNotificationDetailEntity receiveNotificationDetailEntity = receiveNotificationDetail.getEntity();
                        BigDecimal rejectQty = receiveNotificationDetailEntity.getRejectQuantity();// 已经拒收
                        receiveNotificationDetailEntity.setRejectQuantity(DecimalUtils.add(rejectQty, qty));// 累加拒收
                        BuyerReturnDetailEntity buyerReturnDetailEntity = new BuyerReturnDetailEntity();
                        buyerReturnDetailEntity.setReceiveNotificationDetailId(receiveNotificationDetailEntity.getReceiveNotificationDetailId());
                        buyerReturnDetailEntity.setDistributionNotificationId(distributionNotificationDetailEntity.getDistributionNotificationId());//配送单ID
                        buyerReturnDetailEntity.setDistributionNotificationDetailId(distributionNotificationDetailEntity.getDistributionNotificationDetailId());//配送明细ID
                        buyerReturnDetailEntity.setGoodsId(distributionNotificationDetailEntity.getGoodsId());//商品ID
                        buyerReturnDetailEntity.setSalesUnit(distributionNotificationDetailEntity.getGoodsUnit());//销售单位
                        buyerReturnDetailEntity.setReturnQty(product.getReturnQty());//退货数量
                        buyerReturnDetailEntity.setReasonId(product.getDetailReasonID());// 原因id
                        BuyerReturnDetail buyerReturnDetail = new BuyerReturnDetail(buyerReturnDetailEntity);
                        buyerReturnDetail.setBlackboard(distributionNotification.getBlackboard());
                        List<BuyerReturnDetail> buyerReturnDetailList = new ArrayList<>();
                        buyerReturnDetailList.add(buyerReturnDetail);
                        receiveNotificationDetail.link(buyerReturnDetailList);                                    // 绑定配送明细
                        receiveNotificationDetail.buyerReturnDetailsLinked();


                    } else {
                        ReceiveNotificationDetailEntity receiveNotificationDetailEntity = new ReceiveNotificationDetailEntity();
                        receiveNotificationDetailEntity.setReceiveNotificationId(receiveNotification.getEntity().getReceiveNotificationId());
                        receiveNotificationDetailEntity.setDistributionNotificationDetailId(distributionNotificationDetailId);//配送明细ID
                        receiveNotificationDetailEntity.setGoodsId(distributionNotificationDetailEntity.getGoodsId());//商品ID
                        receiveNotificationDetailEntity.setSku(distributionNotificationDetailEntity.getSku());//
                        receiveNotificationDetailEntity.setBatch(distributionNotificationDetailEntity.getBatchCode());//批次	BATCH
                        receiveNotificationDetailEntity.setRejectQuantity(product.getReturnQty());// 设置拒收数量
                        receiveNotificationDetailEntity.setPricePlateUnitPrice(null);// 价盘单价
                        receiveNotificationDetail = new ReceiveNotificationDetail(receiveNotificationDetailEntity);
                        receiveNotificationDetail.setBlackboard(distributionNotification.getBlackboard());
                        BuyerReturnDetailEntity buyerReturnDetailEntity = new BuyerReturnDetailEntity();
                        buyerReturnDetailEntity.setDistributionNotificationId(distributionNotificationDetailEntity.getDistributionNotificationId());//配送单ID
                        buyerReturnDetailEntity.setDistributionNotificationDetailId(distributionNotificationDetailEntity.getDistributionNotificationDetailId());//配送明细ID
                        buyerReturnDetailEntity.setGoodsId(distributionNotificationDetailEntity.getGoodsId());//商品ID
                        buyerReturnDetailEntity.setSalesUnit(distributionNotificationDetailEntity.getGoodsUnit());//销售单位
                        buyerReturnDetailEntity.setReturnQty(product.getReturnQty());//拒收数量
                        buyerReturnDetailEntity.setReasonId(product.getDetailReasonID());// 原因id
                        BuyerReturnDetail buyerReturnDetail = new BuyerReturnDetail(buyerReturnDetailEntity);
                        buyerReturnDetail.setBlackboard(distributionNotification.getBlackboard());
                        List<BuyerReturnDetail> buyerReturnDetailList = new ArrayList<>();
                        buyerReturnDetailList.add(buyerReturnDetail);
                        receiveNotificationDetail.link(buyerReturnDetailList);                                    // 绑定配送明细
                        receiveNotificationDetail.buyerReturnDetailsLinked();

                    }
                    receiveNotificationDetails.add(receiveNotificationDetail);
                    BigDecimal returnDetailAmount = DecimalUtils.multiply(realUnitPrice, product.getReturnQty());
                    returnAmount = DecimalUtils.add(returnAmount, returnDetailAmount);
                }
                receiveNotification.link(receiveNotificationDetails);
                receiveNotification.receiveNotificationDetailsLinked();
                receiveNotificationList.add(receiveNotification);
            }
        }
        map.put("receiveNotificationList", receiveNotificationList);
        map.put("returnAmount", returnAmount);
        return map;
    }


    /**
     * 获取发货单 根据发货单code
     *
     * @param sendNotificationList
     * @param deliverCode
     * @return
     */
    public SendNotification getSendNotificationByDeliverCode(List<SendNotification> sendNotificationList, String deliverCode) {
        SendNotification sendNotification = null;
        for (SendNotification send : sendNotificationList) {
            String sendNotificationCode = send.getEntity().getSendNotificationCode();
            if (deliverCode.equals(sendNotificationCode)) {
                sendNotification = send;
                break;
            }
        }
        return sendNotification;
    }


    /**
     * 根据配送明细获取
     *
     * @param receiveNotification
     * @param distributionNotificationDetailId
     * @return
     */
    public ReceiveNotificationDetail getReceiveNotificationDetailByDistributionNotificationDetailId(ReceiveNotification receiveNotification, Long distributionNotificationDetailId) {
        List<ReceiveNotificationDetail> receiveNotificationDetailList = receiveNotification.getReceiveNotificationDetails();
        if (CollectionUtils.isNotEmpty(receiveNotificationDetailList)) {
            for (ReceiveNotificationDetail receiveNotificationDetail : receiveNotificationDetailList) {
                Long dbDistributionNotificationDetailId = receiveNotificationDetail.getEntity().getDistributionNotificationDetailId();
                if (dbDistributionNotificationDetailId.equals(distributionNotificationDetailId)) {
                    return receiveNotificationDetail;
                }
            }
        }
        return null;
    }

    /**
     * 获取数据库中的收货
     *
     * @param receiveNotificationList
     * @param deliverCode
     * @return
     */
    public ReceiveNotification getReceiveNotificationByDeliverCodeAndDistributionNotificationCode(List<ReceiveNotification> receiveNotificationList, String deliverCode, String distributionNotificationCode) {
        ReceiveNotification receiveNotification = null;
        if (CollectionUtils.isNotEmpty(receiveNotificationList)) {
            for (ReceiveNotification receive : receiveNotificationList) {
                ReceiveNotificationEntity receiveNotificationEntity = receive.getEntity();
                String dbistributionNotificationCode = receiveNotificationEntity.getDistributionNotificationCode();
                String dbSendNotificationCode = receiveNotificationEntity.getSendNotificationCode();
                if (deliverCode.equals(dbSendNotificationCode) && distributionNotificationCode.equals(dbistributionNotificationCode)) {
                    receiveNotification = receive;
                    break;
                }
            }
        }
        return receiveNotification;
    }
}
