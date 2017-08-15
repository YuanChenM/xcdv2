package com.bms.order.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.bms.order.archive.impl.BuyerBatchOrder;
import com.bms.order.archive.impl.BuyerForcastDeliverDetail;
import com.bms.order.archive.impl.BuyerOrder;
import com.bms.order.archive.impl.DistributionNotification;
import com.bms.order.archive.impl.DistributionNotificationDetail;
import com.bms.order.archive.impl.Operator;
import com.bms.order.archive.impl.list.DistributionNotificationDetailList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.BuyerBatchOrderAttachedEntity;
import com.bms.order.bean.entity.BuyerBatchOrderEntity;
import com.bms.order.bean.entity.BuyerOrderAttachedEntity;
import com.bms.order.bean.entity.BuyerOrderEntity;
import com.bms.order.bean.entity.DistributionNotificationDetailEntity;
import com.bms.order.bean.entity.DistributionNotificationEntity;
import com.bms.order.bean.param.ORDR0301IBeanParam;
import com.bms.order.bean.result.ORDR0301IXMLResult;
import com.bms.order.constant.enumeration.BuyerBatchOrderStu;
import com.bms.order.constant.enumeration.BuyerOrderStu;
import com.bms.order.constant.enumeration.DistributionNotificationStu;
import com.bms.order.constant.enumeration.GoodsUnit;
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
import com.bms.order.dao.DistributionNotificationDao;
import com.bms.order.dao.DistributionNotificationDetailDao;
import com.bms.order.services.ORDR0301IService;
import com.framework.core.utils.DecimalUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;

/**
 * 配送通知单创建接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0301IServiceImpl implements ORDR0301IService {

    @Autowired
    private BaseRedisDao redisDao;

    @Autowired
    private BuyerOrderDao buyerOrderDao;

    @Autowired
    private BuyerOrderAttachedDao buyerOrderAttachedDao;

    @Autowired
    private BuyerBatchOrderDao buyerBatchOrderDao;

    @Autowired
    private BuyerBatchOrderAttachedDao buyerBatchOrderAttachedDao;

    @Autowired
    private BuyerBatchOrderDetailDao buyerBatchOrderDetailDao;

    @Autowired
    private BuyerBatchOrderDetailAttachedDao buyerBatchOrderDetailAttachedDao;

    @Autowired
    private BuyerForcastDeliverDetailDao buyerForcastDeliverDetailDao;

    @Autowired
    private BuyerForcastDeliverDetailAttachedDao buyerForcastDeliverDetailAttachedDao;

    @Autowired
    private DistributionNotificationDao distributionNotificationDao;

    @Autowired
    private DistributionNotificationDetailDao distributionNotificationDetailDao;



    /**
     * 订单系统根据期望配送日期对已分单的分批订单生成配送通知单，并发送给WMS系统
     *
     * @param operator 操作者
     * @param param   ORDR0301IBeanParam
     */
    @Override
    public void execute(Operator operator, ORDR0301IBeanParam param) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        blackboard.setOperator(operator);
        map.put("param", param);
        map.put("blackboard", blackboard);
        pre(map);
        process(map);
        post(map);
    }

    /**
     * 准备
     *
     * @param map HashMap
     */
    private void pre(HashMap<String, Object> map) {
        // 获取参数
        @SuppressWarnings("unused")
        ORDR0301IBeanParam param = (ORDR0301IBeanParam) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        // TODO 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(buyerOrderDao);
        blackboard.putBaseDao(buyerBatchOrderDao);
        blackboard.putBaseDao(buyerBatchOrderDetailDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailDao);
        blackboard.putBaseDao(buyerOrderAttachedDao);
        blackboard.putBaseDao(buyerBatchOrderAttachedDao);
        blackboard.putBaseDao(buyerBatchOrderDetailAttachedDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailAttachedDao);
        blackboard.putBaseDao(distributionNotificationDao);
        blackboard.putBaseDao(distributionNotificationDetailDao);

        //操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);
        // 获取角色-后台
        checkBackground(operator);
        BuyerOrder buyerOrder = param.generateBuyerOrder();
        buyerOrder.setBlackboard(blackboard);
        List<ORDR0301IBeanParam.ORDR0301IDetail> details = param.getDetails();
        List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails = new ArrayList<BuyerForcastDeliverDetail>();
        List<DistributionNotificationDetail> distributionNotificationDetails = new ArrayList<DistributionNotificationDetail>();
        for(ORDR0301IBeanParam.ORDR0301IDetail detail : details){
            BuyerForcastDeliverDetail buyerForcastDeliverDetail = detail.generateBuyerForcastDeliverDetail();
            buyerForcastDeliverDetail.setBlackboard(blackboard);
            DistributionNotificationDetail distributionNotificationDetail = detail.generateDistributionNotification();
            distributionNotificationDetail.setBlackboard(blackboard);
            buyerForcastDeliverDetails.add(buyerForcastDeliverDetail);
            distributionNotificationDetails.add(distributionNotificationDetail);
        }
        map.put("buyerOrder",buyerOrder);
        map.put("distributionNotificationDetails",distributionNotificationDetails);
        map.put("buyerForcastDeliverDetails",buyerForcastDeliverDetails);
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        BuyerOrder buyerOrder = (BuyerOrder) map.get("buyerOrder");
        List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails = (List<BuyerForcastDeliverDetail>) map.get("buyerForcastDeliverDetails");
        List<DistributionNotificationDetail> distributionNotificationDetails = (List<DistributionNotificationDetail>) map.get("distributionNotificationDetails");
        createDistributionNotification(buyerOrder,buyerForcastDeliverDetails,distributionNotificationDetails);

        // 返回参数

    }

    /**
     * 收尾
     *
     * @param map HashMap
     */
    private void post(HashMap<String, Object> map) {
    // 获取参数

    // 返回参数

    }

    private void createDistributionNotification(BuyerOrder buyerOrder,
                                               List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails,
                                               List<DistributionNotificationDetail> distributionNotificationDetails) {
        buyerOrder.complete(false);
        // 判断买家订单是否存在并且状态为未完成
        if (!buyerOrder.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E030101 + buyerOrder.getEntity().getBuyerOrderId());
            // 2017/1/5
            // 国际化
        }

        if (!BuyerOrderStu.NOT_COMPLETED.getCode().equals(buyerOrder.getEntity().getBuyerOrderStu())) {
            throw new BusinessException(ModuleCode.ORDR,
                    ErrorCode.E030102 + buyerOrder.getEntity().getBuyerOrderId());
        }

        for (BuyerForcastDeliverDetail buyerForcastDeliverDetail : buyerForcastDeliverDetails) {
            buyerForcastDeliverDetail.complete(false);
            // 判断预配送明细是否存在
            if (!buyerForcastDeliverDetail.isDataSynced()) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E030103
                        + buyerForcastDeliverDetail.getEntity().getBuyerForcastDeliverDetailId());
            }
        }

        for (DistributionNotificationDetail distributionNotificationDetail : distributionNotificationDetails) {
            distributionNotificationDetail.complete(false);
            // 判断预配送明细是否已经生成配送通知单
            if (distributionNotificationDetail.isDataSynced()) {
                if (null != distributionNotificationDetail.getDistributionNotification()
                        && null != distributionNotificationDetail.getDistributionNotification().getEntity()
                        && !DistributionNotificationStu.CANCEL.getCode().equals(distributionNotificationDetail
                        .getDistributionNotification().getEntity().getDistributionNotificationStu())) {
                    throw new BusinessException(ModuleCode.ORDR,ErrorCode.E030104
                            + distributionNotificationDetail.getEntity().getBuyerForcastDeliverDetailId()
                                    );
                }
            }
        }

        // 判断是否欠款付清
        // 1.账期买家且使用账期
        if (buyerOrder.getEntity().getNetBuyerFlg() && buyerOrder.getEntity().getUseNetFlg()) {

            if (!checkAmount(buyerOrder)) {
                throw new BusinessException(ModuleCode.ORDR,
                        ErrorCode.E030105  + buyerOrder.getEntity().getBuyerOrderId());
            }
        }

        // 2.非账期买家订单或未使用账期
        if (!buyerOrder.getEntity().getNetBuyerFlg() || !buyerOrder.getEntity().getUseNetFlg()) {
            if (null != buyerOrder.getDistributionNotifications()) {
                if (!checkAmount(buyerOrder)) {
                    throw new BusinessException(ModuleCode.ORDR,
                            ErrorCode.E030106 + buyerOrder.getEntity().getBuyerOrderId());
                    // 2017/1/5
                    // 国际化
                }
            }
        }

        // 组装配送通知单数据并保存
        DistributionNotificationEntity distributionNotificationEntity = preDistributionNotification(buyerOrder,
                buyerForcastDeliverDetails);
        DistributionNotification distributionNotification = DistributionNotification.build(buyerOrder.getBlackboard())
                .forCreate(distributionNotificationEntity);
        distributionNotification.create();
        // 组装配送通知单明细数据并保存
        List<DistributionNotificationDetail> distributionNotificationDetailList = preDistributionNotificationDetail(
                buyerForcastDeliverDetails, distributionNotification);
        DistributionNotificationDetailList detailList = DistributionNotificationDetailList
                .build(buyerOrder.getBlackboard())
                .forCreate(distributionNotificationDetailList.toArray(new DistributionNotificationDetail[0]));
        detailList.create();

        // TODO: 2017/1/9 发送给美迪福
        // XML数据对象
        ORDR0301IXMLResult result = new ORDR0301IXMLResult();

        List<BuyerBatchOrder> buyerBatchOrders = new ArrayList<>();
        // 更新分批订单状态
        Map<Long, Long> batchOrderMap = new HashMap<>();
        for (BuyerForcastDeliverDetail deliverDetail : buyerForcastDeliverDetails) {
            BuyerBatchOrder buyerBatchOrder = deliverDetail.getBuyerBatchOrder();
            buyerBatchOrder.getEntity().setBuyerBatchOrderStu(BuyerBatchOrderStu.WAIT_SEND.getCode());

            if (null == batchOrderMap.get(buyerBatchOrder.getEntity().getBuyerBatchOrderId())) {
                buyerBatchOrders.add(buyerBatchOrder);
                buyerBatchOrder.modify();
            }
            batchOrderMap.put(buyerBatchOrder.getEntity().getBuyerBatchOrderId(),
                    buyerBatchOrder.getEntity().getBuyerBatchOrderId());

        }
        // BuyerBatchOrderList buyerBatchOrderList =
        // BuyerBatchOrderList.build(buyerOrder.getBlackboard()).forCreate(buyerBatchOrders.toArray(new
        // BuyerBatchOrder[0]));
        // buyerBatchOrderList.modify();
    }

    /**
     * 判断尾款是否付清
     *
     * @param buyerOrder
     * @return
     */
    private boolean checkAmount(BuyerOrder buyerOrder) {
        // 订单总金额
        BigDecimal sumAmount = DecimalUtils.subtract(
                DecimalUtils.add(buyerOrder.getEntity().getOrderAmount(), buyerOrder.getEntity().getFreight()),
                buyerOrder.getEntity().getPreferentialAmount());
        // 剩余尾款
        BigDecimal leftAmount = DecimalUtils.subtract(sumAmount, buyerOrder.getEntity().getReceiveAmount());

        if (DecimalUtils.gt(leftAmount, BigDecimal.ZERO)) {
            return false;
        }
        return true;
    }

    /**
     * 准备配送通知单表数据
     *
     * @param buyerOrder
     * @param buyerForcastDeliverDetails
     */
    private DistributionNotificationEntity preDistributionNotification(BuyerOrder buyerOrder,
                                                                       List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails) {
        DistributionNotificationEntity distributionNotificationEntity = new DistributionNotificationEntity();
        // 买家订单表
        BuyerOrderEntity buyerOrderEntity = buyerOrder.getEntity();
        // 买家订单附表
        BuyerOrderAttachedEntity buyerOrderAttachedEntity = buyerOrder.getAttachedEntity();
        com.bms.order.util.BeanUtils.copyProperties(buyerOrderEntity, distributionNotificationEntity);
        com.bms.order.util.BeanUtils.copyProperties(buyerOrderAttachedEntity, distributionNotificationEntity);
        // 买家分批订单表
        BuyerBatchOrderEntity buyerBatchOrderEntity = buyerForcastDeliverDetails.get(0).getBuyerBatchOrder()
                .getEntity();
        // 买家分批订单附表
        BuyerBatchOrderAttachedEntity buyerBatchOrderAttachedEntity = buyerForcastDeliverDetails.get(0)
                .getBuyerBatchOrder().getAttachedEntity();
        com.bms.order.util.BeanUtils.copyProperties(buyerBatchOrderEntity, distributionNotificationEntity);
        com.bms.order.util.BeanUtils.copyProperties(buyerBatchOrderAttachedEntity, distributionNotificationEntity);
        distributionNotificationEntity.setSendFlg(false);
        distributionNotificationEntity
                .setDistributionNotificationStu(DistributionNotificationStu.TO_DISTRIBUTION.getCode());
        return distributionNotificationEntity;
    }

    /**
     * 准备配送通知单明细数据
     *
     * @param buyerForcastDeliverDetails
     * @param distributionNotification
     * @return
     */
    private List<DistributionNotificationDetail> preDistributionNotificationDetail(
            List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails,
            DistributionNotification distributionNotification) {
        List<DistributionNotificationDetail> details = new ArrayList<DistributionNotificationDetail>();

        for (BuyerForcastDeliverDetail deliverDetail : buyerForcastDeliverDetails) {

            DistributionNotificationDetailEntity distributionNotificationDetailEntity = new DistributionNotificationDetailEntity();
            distributionNotificationDetailEntity.setDistributionNotificationId(
                    distributionNotification.getEntity().getDistributionNotificationId());
            com.bms.order.util.BeanUtils.copyProperties(deliverDetail.getAttachedEntity(),
                    distributionNotificationDetailEntity);
            com.bms.order.util.BeanUtils.copyProperties(deliverDetail.getEntity(),
                    distributionNotificationDetailEntity);
            distributionNotificationDetailEntity
                    .setDistributionQuantity(deliverDetail.getEntity().getPlanSendQuantity());
            distributionNotificationDetailEntity.setLogisticsZoneName(
                    deliverDetail.getBuyerBatchOrder().getBuyerOrder().getAttachedEntity().getLogisticsZoneName());
            distributionNotificationDetailEntity.setGoodsUnit(GoodsUnit.PACKAGE.getCode());
            details.add(DistributionNotificationDetail.build(distributionNotification.getBlackboard())
                    .forCreate(distributionNotificationDetailEntity));

        }
        return details;
    }

    private String generateDistributionNotificationCode(BuyerOrder buyerOrder) {
        // 编码开头
        String start = "Dis";
        // 当前时间
        String date = String.valueOf(new Date().getTime());
        String disCode = start + date;
        return disCode;
    }

    /**
     * 获取 角色-后台（平台订单人员）
     *
     * @param operator
     * @return
     */
    private void checkBackground(Operator operator) {
        Assert.notNull(operator);
        if (operator.isStaff()) {
        } else if (operator.isOrderSystem()) {
        }else {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E030107);
        }
    }
}
