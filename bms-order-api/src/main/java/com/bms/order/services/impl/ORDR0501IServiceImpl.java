package com.bms.order.services.impl;

import com.bms.order.archive.impl.*;
import com.bms.order.archive.impl.externalCall.cashPooling.CashPooling;
import com.bms.order.archive.impl.list.BuyerBatchOrderDetailList;
import com.bms.order.archive.impl.list.BuyerForcastDeliverDetailList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.*;
import com.bms.order.bean.param.*;
import com.bms.order.bean.result.ORDR0501IGoodPriceResult;
import com.bms.order.bean.result.ORDR0501IGoodQtyResult;
import com.bms.order.bean.result.ORDR0501IRestResult;
import com.bms.order.constant.enumeration.*;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.*;
import com.bms.order.external.archive.Stock;
import com.bms.order.external.archive.Ydp;
import com.bms.order.services.ORDR0501IService;
import com.bms.order.services.ORDR0803IService;
import com.bms.order.services.ORDR0804IService;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.DecimalUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * 收货通知回传接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0501IServiceImpl implements ORDR0501IService {

    @Autowired
    private ORDR0803IService ordr0803IService;// 迟收

    @Autowired
    private ORDR0804IService ordr0804IService;// 拒收

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
    private PriceChannelNotificationDao priceChannelNotificationDao;

    @Autowired
    private PriceChannelNotificationDetailDao priceChannelNotificationDetailDao;

    @Autowired
    private BuyerForcastDeliverDetailDao buyerForcastDeliverDetailDao;

    @Autowired
    private BuyerForcastDeliverDetailAttachedDao buyerForcastDeliverDetailAttachedDao;

    @Autowired
    private DistributionNotificationDao distributionNotificationDao;

    @Autowired
    private DistributionNotificationDetailDao distributionNotificationDetailDao;

    @Autowired
    private ReceiveNotificationDao receiveNotificationDao;

    @Autowired
    private ReceiveNotificationDetailDao receiveNotificationDetailDao;

    @Autowired
    private SendNotificationDao sendNotificationDao;

    @Autowired
    private SendNotificationDetailDao sendNotificationDetailDao;

    @Autowired
    private BuyerSellerDetailDao buyerSellerDetailDao;

    public static final Logger logger = LoggerFactory.getLogger(ORDR0401IServiceImpl.class);

    /**
     * WMS系统发送收货通知单，通知订单系统进行系统内收货、拒收退货、迟收退货
     *
     * @param operator 操作者
     * @param param    ORDR0501IRestParam
     */
    @Transactional
    @Override
    public ORDR0501IRestResult execute(Operator operator, ORDR0501IRestParam param) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        blackboard.setOperator(operator);
        map.put("param", param);
        map.put("blackboard", blackboard);
        pre(map);
        process(map);
        post(map);
        return (ORDR0501IRestResult) map.get("restResult");
    }

    /**
     * 准备
     *
     * @param map HashMap
     */
    private void pre(HashMap<String, Object> map) {
        // 获取参数

        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(buyerOrderDao);
        blackboard.putBaseDao(buyerBatchOrderDao);
        blackboard.putBaseDao(buyerBatchOrderDetailDao);
        blackboard.putBaseDao(priceChannelNotificationDao);
        blackboard.putBaseDao(priceChannelNotificationDetailDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailDao);
        blackboard.putBaseDao(distributionNotificationDao);
        blackboard.putBaseDao(distributionNotificationDetailDao);
        blackboard.putBaseDao(buyerOrderAttachedDao);
        blackboard.putBaseDao(buyerBatchOrderAttachedDao);
        blackboard.putBaseDao(buyerBatchOrderDetailAttachedDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailAttachedDao);
        blackboard.putBaseDao(receiveNotificationDao);
        blackboard.putBaseDao(receiveNotificationDetailDao);
        blackboard.putBaseDao(sendNotificationDao);
        blackboard.putBaseDao(sendNotificationDetailDao);
        blackboard.putBaseDao(buyerSellerDetailDao);
        Operator operator = blackboard.getOperator();// 操作者
        operator.setBlackboard(blackboard);
        operator.complete(false); // 获取完整操作者
        if (!operator.getOperatorType().equals(OperatorType.MADE_4_NET.getCode())) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E050101);
        }
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        ORDR0501IRestParam param = (ORDR0501IRestParam) map.get("param");
        Long distributionNotificationId = param.getShipId();
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        DistributionNotification distributionNotification = new DistributionNotification(distributionNotificationId);
        distributionNotification.setBlackboard(blackboard);
        distributionNotification.complete(false);
        if (!distributionNotification.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR, "配送单不存在");
        }
        this.checkSendQty(distributionNotification,param);
        this.checkIsFirstReceive(distributionNotification);//  判断是否存在收货操作
        this.receipt(distributionNotification, param, blackboard);
        map.put("distributionNotification", distributionNotification);
    }


    /**
     * 收货操作
     *
     * @param distributionNotification
     * @param param
     */
    public void receipt(DistributionNotification distributionNotification, ORDR0501IRestParam param,
                        Blackboard blackboard) {
        List<ORDR0501IPaymentRestParam> paymentList = param.getPaymentList();
        this.checkReceipt(distributionNotification, param);  // 判断收货内容是否全
        BuyerOrder buyerOrder = distributionNotification.getBuyerOrder(); // 这个配送单所有订单信息

        List<Long> orderIds = new ArrayList<>();
        if (!orderIds.contains(buyerOrder.getEntity().getBuyerOrderId())) {
            orderIds.add(buyerOrder.getEntity().getBuyerOrderId());
        }

        BuyerOrderEntity buyerOrderEntity = buyerOrder.getEntity();
        if (!buyerOrderEntity.getBuyerId().equals(param.getBuyerId())) {
            throw  new BusinessException(ModuleCode.ORDR,"buyerId不对！");
        }
        buyerOrder.complete(false);
        CashPooling cashPooling = new CashPooling();
        String paymentStu = buyerOrderEntity.getPaymentStu();
        BigDecimal payedMoney = buyerOrder.getEntity().getReceiveAmount();  // 已付金额
        if (PaymentStu.ALL_PAYMENT.getCode().equals(paymentStu)) {// 全部付款
            this.dealReceiptInfo(distributionNotification, param); // 这个配送单正常收货操作
            modifyDistributionStu(distributionNotification); // 设置配送单状态
            modifyBatchOrderStu(distributionNotification);    // 更新这个分批订单的状态
            cashPooling.aPAPByBuyerOrder(buyerOrder);  // 调用资金池
            modifyBuyerOrderStu(buyerOrder);   // 设置订单状态
            BigDecimal receiveOfPayMoney = this.getTotalPayMoney(paymentList); // 收货时付款
            buyerOrder.getEntity().setReceiveAmount(DecimalUtils.add(payedMoney, receiveOfPayMoney));// 重新设定 收款
        } else {
            List<ORDR0501IGoodPriceResult> priceResults = this.getGoodPriceResult(buyerOrder, param, distributionNotification);// 得到这个订单所有产品的单价
            BigDecimal receiveOfPayMoney = this.getTotalPayMoney(paymentList); // 收货时付款
            BigDecimal freight = buyerOrder.getEntity().getFreight();  // 运费金额
            BigDecimal preferentialAmount = buyerOrder.getEntity().getPreferentialAmount();// 优惠金额
            Map<String, BigDecimal> receiveAndDistributionNotificationMoney = this.getReceiveAndDistributionMoney(param, distributionNotification, priceResults); // 这个配送单应付的金额
            //  BigDecimal orderAmountWithoutDeal = this.getOrderTotalMoney(priceResults);// 第一批 收+迟+ 其他配送
            BigDecimal orderPayedAmount = DecimalUtils.add(receiveOfPayMoney, payedMoney);// 收货付款+下单时支付
            BigDecimal orderTotalMoney = DecimalUtils.subtract(DecimalUtils.add(freight, orderPayedAmount), preferentialAmount); // 订单总金额
            BigDecimal receiveMoney = receiveAndDistributionNotificationMoney.get("receiveMoney");// 收货时应付金额
            BigDecimal distributionNotificationMoney = receiveAndDistributionNotificationMoney.get("distributionNotificationMoney");
            if (DecimalUtils.lt(orderPayedAmount, receiveMoney)) {//已收金额 + 收货单付款的金额 < 收货单中的商品总价
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E050102);
            }
            this.dealReceiptInfo(distributionNotification, param);   // 这个配送单正常收货操作
            this.modifyDistributionStu(distributionNotification);  // 设置配送单状态
            this.modifyOrderDetailPrice(priceResults, buyerOrder); // 更新订单所有实际单价
            this.modifyBatchOrderStu(distributionNotification);  // 更新这个分批订单的状态
            cashPooling.aPAPByBuyerOrder(buyerOrder);  // 调用资金池
            BigDecimal orderAmount = buyerOrder.calculateOrderAmount(); // 设置订单总金额
            buyerOrder.getEntity().setPaymentStu(PaymentStu.ALL_PAYMENT.getCode());
            buyerOrder.getEntity().setReceiveAmount(DecimalUtils.add(payedMoney, receiveOfPayMoney));// 重新设定 收款
            BigDecimal subtractResult = DecimalUtils.subtract(orderTotalMoney, receiveMoney);// 总-第一单收货
            BigDecimal otherDistributionNotificationMoney = DecimalUtils.subtract(orderAmount, distributionNotificationMoney);
            if (DecimalUtils.lt(subtractResult, otherDistributionNotificationMoney)) {// 支付的<本次收货+剩余要发的    取消其他
                List<BuyerBatchOrder> otherBatchOrders = this.getOtherBatchOrders(distributionNotification);
                this.cancelOtherBatchOrder(otherBatchOrders, blackboard); // 取消其他分批订单
                this.cancelOtherDistributionNotification(buyerOrder, distributionNotification);// 取消其他配送通知
            }
            buyerOrder.getEntity().setOrderAmount(buyerOrder.calculateOrderAmount());
            this.modifyBuyerOrderStu(buyerOrder);
        }

        // 调用云冻品前台，通知订单变更
        try {
            Ydp.pushMsg(orderIds);
        } catch (Exception e) {
            logger.error("千米前台调用错误：", e.getMessage());
        }
    }


    /**
     * 判断是否是第一次收货
     *
     * @param distributionNotification
     */
    public void checkIsFirstReceive(DistributionNotification distributionNotification) {
        List<ReceiveNotification> receiveNotificationList = distributionNotification.getReceiveNotifications();
        if (CollectionUtils.isNotEmpty(receiveNotificationList)) {// 已经收货了
            throw new BusinessException(ModuleCode.ORDR, "已经收货操作了");
        }
    }


    /**
     * 更新订单数据
     *
     * @param buyerOrder
     */
    public void modifyBuyerOrderStu(BuyerOrder buyerOrder) {
        int cancelCount = 0; // 取消
        int finishCount = 0;  // 完成
        List<BuyerBatchOrder> buyerBatchOrders = buyerOrder.getBuyerBatchOrders();
        for (BuyerBatchOrder buyerBatchOrder : buyerBatchOrders) {
            String buyerBatchOrderStu = buyerBatchOrder.getEntity().getBuyerBatchOrderStu();// 分批订单状态
            if (buyerBatchOrderStu.equals(BuyerBatchOrderStu.CANCEL.getCode())) {
                cancelCount = cancelCount + 1;
            }
            if (buyerBatchOrderStu.equals(BuyerBatchOrderStu.RECEIPT_FINISH.getCode())) {
                finishCount = finishCount + 1;
            }
        }
        int buyerBatchOrderSize = buyerBatchOrders.size();
        BuyerOrderEntity buyerOrderEntity = buyerOrder.getEntity();
        if (buyerBatchOrderSize == cancelCount) {// 全部取消
            buyerOrderEntity.setBuyerOrderStu(BuyerOrderStu.CANCEL.getCode());
        }
        if (buyerBatchOrderSize == finishCount) {// 收货完成
            buyerOrderEntity.setBuyerOrderStu(BuyerOrderStu.ALREADY_COMPLETED.getCode());
        }
        if (buyerBatchOrderSize == finishCount + cancelCount) {// 收货完成
            buyerOrderEntity.setBuyerOrderStu(BuyerOrderStu.ALREADY_COMPLETED.getCode());
        }
        buyerOrder.modify();
    }

    /**
     * 更新配送单状态 修改成配送状态
     *
     * @param distributionNotification
     */
    public void modifyDistributionStu(DistributionNotification distributionNotification) {
        DistributionNotificationEntity distributionNotificationEntity = distributionNotification.getEntity();
        List<DistributionNotificationDetail> distributionNotificationDetailList = distributionNotification.getDistributionNotificationDetails();
        BigDecimal allDistributionQuantity = null;// 所有配送数量
        for (DistributionNotificationDetail distributionNotificationDetail : distributionNotificationDetailList) {
            DistributionNotificationDetailEntity distributionNotificationDetailEntity = distributionNotificationDetail.getEntity();
            BigDecimal distributionQuantity = DecimalUtils.subtract(distributionNotificationDetailEntity.getDistributionQuantity(), distributionNotificationDetailEntity.getCancelQuantity());
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
        if (DecimalUtils.lt(realReceiveQty, allDistributionQuantity) && DecimalUtils.gt(realReceiveQty, BigDecimal.ZERO)) { // 收货<配送数量  部分收货  收货>0
            distributionNotificationEntity.setDistributionNotificationStu(DistributionNotificationStu.PARTIAL_RECEIPT.getCode());
        } else if (DecimalUtils.eq(realReceiveQty, allDistributionQuantity)) { // 收货数量+迟收=配送数量  完成
            distributionNotificationEntity.setDistributionNotificationStu(DistributionNotificationStu.RECEIPT_FINISH.getCode());
        }
        distributionNotification.modify();
    }

    /**
     * 取消其他所有分批订单
     *
     * @param otherBatchOrders
     * @param blackboard
     */
    public void cancelOtherBatchOrder(List<BuyerBatchOrder> otherBatchOrders, Blackboard blackboard) {
        if (CollectionUtils.isEmpty(otherBatchOrders)) {
            return;
        }
        List<BuyerBatchOrderDetail> buyerBatchOrderDetails = new ArrayList<>();
        List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails = new ArrayList<>();
        for (BuyerBatchOrder otherBatchOrder : otherBatchOrders) {
            buyerBatchOrderDetails.addAll(otherBatchOrder.getBuyerBatchOrderDetails());
            if (!CollectionUtils.isEmpty(otherBatchOrder.getBuyerForcastDeliverDetails())) {
                buyerForcastDeliverDetails.addAll(otherBatchOrder.getBuyerForcastDeliverDetails());
            }
            for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerBatchOrderDetails) {
                buyerBatchOrderDetail.getEntity().setCancelQuantity(buyerBatchOrderDetail.getEntity().getGoodsQuantity());
            }
            // 更新分批订单状态
            otherBatchOrder.getEntity().setBuyerBatchOrderStu(BuyerBatchOrderStu.CANCEL.getCode());
            otherBatchOrder.modify();
        }
        // 更新分批订单明细取消数量
        BuyerBatchOrderDetailList buyerBatchOrderDetailList = new BuyerBatchOrderDetailList(
                buyerBatchOrderDetails.toArray(new BuyerBatchOrderDetail[0]));
        buyerBatchOrderDetailList.setBlackboard(blackboard);
        buyerBatchOrderDetailList.complete(false);
        buyerBatchOrderDetailList.modify();
        // 库存释放
        logger.debug("调用取消商品占用 开始");
        cancelComoAllocate(buyerBatchOrderDetails);
        logger.debug("调用取消商品占用 结束");
        logger.debug("调用取消产品占用 开始");
        cancelLinvAllocate(buyerForcastDeliverDetails);
        logger.debug("调用取消产品占用 结束");
        // 逻辑删除预配送明细
        BuyerForcastDeliverDetailList list = BuyerForcastDeliverDetailList.build(blackboard)
                .forUpdate(buyerForcastDeliverDetails.toArray(new BuyerForcastDeliverDetail[0]));
        list.delete();
    }

    /**
     * 取消其他 配送通知单
     *
     * @param distributionNotification
     */
    public void cancelOtherDistributionNotification(BuyerOrder buyerOrder, DistributionNotification distributionNotification) {
        Long distributionNotificationId = distributionNotification.getEntity().getDistributionNotificationId();
        List<DistributionNotification> distributionNotificationList = buyerOrder.getDistributionNotifications();
        for (DistributionNotification distribution : distributionNotificationList) {
            Long shipId = distribution.getEntity().getDistributionNotificationId();
            if (!shipId.equals(distributionNotificationId)) {
                distribution.getEntity().setDistributionNotificationStu(DistributionNotificationStu.CANCEL.getCode());
                distribution.modify();
            }
        }


    }

    /**
     * 得到这个收货单以外的分批订单信息
     *
     * @param distributionNotification
     * @return
     */
    public List<BuyerBatchOrder> getOtherBatchOrders(DistributionNotification distributionNotification) {
        List<BuyerBatchOrder> otherBatchOrders = new ArrayList<>();
        List<DistributionNotificationDetail> distributionNotificationDetails = distributionNotification
                .getDistributionNotificationDetails();
        Map<Long, BuyerBatchOrder> buyerBatchOrderMap = new HashMap<>();
        for (DistributionNotificationDetail distributionNotificationDetail : distributionNotificationDetails) {
            BuyerBatchOrder buyerBatchOrder = distributionNotificationDetail.getBuyerForcastDeliverDetail().getBuyerBatchOrder();
            Long buyerBatchOrderId = buyerBatchOrder.getEntity().getBuyerBatchOrderId();
            buyerBatchOrderMap.put(buyerBatchOrderId, buyerBatchOrder);
        }
        BuyerOrder buyerOrder = distributionNotification.getBuyerOrder();
        buyerOrder.complete(false);
        List<BuyerBatchOrder> batchOrders = buyerOrder.getBuyerBatchOrders();
        for (BuyerBatchOrder batchOrder : batchOrders) {
            Long buyerBatchOrderId = batchOrder.getEntity().getBuyerBatchOrderId();
            BuyerBatchOrder mapOfBuyerBatchOrder = buyerBatchOrderMap.get(buyerBatchOrderId);
            if (mapOfBuyerBatchOrder == null) {
                otherBatchOrders.add(batchOrder);
            }
        }
        return otherBatchOrders;
    }

    /**
     * 更新分批订单状态
     *
     * @param distributionNotification
     */
    public void modifyBatchOrderStu(DistributionNotification distributionNotification) {
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
                if (DecimalUtils.gt(sum, BigDecimal.ZERO)) {// 不是新生成的
                    batchOrderRealSendQuantity = DecimalUtils.add(batchOrderRealSendQuantity, realSendQuantity);
                    batchOrderReceiveQuantity = DecimalUtils.add(batchOrderReceiveQuantity, receiveQuantity);
                    batchOrderRejectQuantity = DecimalUtils.add(batchOrderRejectQuantity, rejectQuantity);
                    batchOrderDelayQuantity = DecimalUtils.add(batchOrderDelayQuantity, delayQuantity);
                }
            }
            if (DecimalUtils.eq(batchOrderRealSendQuantity, batchOrderReceiveQuantity) && DecimalUtils.gt(batchOrderReceiveQuantity, BigDecimal.ZERO)) {  // 收货
                buyerBatchOrder.getEntity().setBuyerBatchOrderStu(BuyerBatchOrderStu.RECEIPT_FINISH.getCode());   // 收货完成
            } else if (DecimalUtils.gt(batchOrderRealSendQuantity, batchOrderReceiveQuantity) && DecimalUtils.gt(batchOrderReceiveQuantity, BigDecimal.ZERO)) {// 收+
                buyerBatchOrder.getEntity().setBuyerBatchOrderStu(BuyerBatchOrderStu.PARTIAL_RECEIPT.getCode());   // 部分收货
            }
            BigDecimal batchAllAmount = buyerBatchOrder.calculateOrderAmount(); // 设置分批订单总金额
            buyerBatchOrder.getEntity().setOrderAmount(batchAllAmount);
            buyerBatchOrder.modify();
        }
    }

    /**
     * 更新分批订单明细实际下单价格
     *
     * @param priceResults
     * @param buyerOrder
     */
    public void modifyOrderDetailPrice(List<ORDR0501IGoodPriceResult> priceResults, BuyerOrder buyerOrder) {
        List<BuyerBatchOrderDetail> buyerBatchOrderDetails = buyerOrder.getBuyerBatchOrderDetails();
        for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerBatchOrderDetails) {
            for (ORDR0501IGoodPriceResult priceResult : priceResults) {
                if (priceResult.getGoodsId().equals(buyerBatchOrderDetail.getEntity().getGoodsId())) {
                    buyerBatchOrderDetail.getEntity().setRealUnitPrice(priceResult.getReceivePrice());// 箱价
                    buyerBatchOrderDetail.getEntity().setRealKgPrice(priceResult.getKgPrice());// 公斤价
                    buyerBatchOrderDetail.modify();
                    break;
                }
            }
        }
    }

    /**
     * 处理收货数据
     *
     * @param distributionNotification
     * @param param
     */
    public void dealReceiptInfo(DistributionNotification distributionNotification, ORDR0501IRestParam param) {
        BigDecimal paymentMoney = this.getTotalPayMoney(param.getPaymentList());// 支付金额
        DistributionNotificationEntity distributionNotificationEntity = distributionNotification.getEntity();
        String distributionNotificationStu = distributionNotificationEntity.getDistributionNotificationStu();// 配送单状态
        if (!DistributionNotificationStu.IN_DISTRIBUTION.getCode().equals(distributionNotificationStu)) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E050103);
        }
        Blackboard blackboard = distributionNotification.getBlackboard();
        List<ORDR0501IShipRestParam> shipList = param.getShipList();
        Map<Long, ORDR0501IGoodQtyResult> goodQtyResultMap = new HashMap<>();
        for (ORDR0501IShipRestParam ship : shipList) {// 创建收货主表数据
            ReceiveNotificationEntity receiveNotificationEntity = new ReceiveNotificationEntity();
            String actualReceiveDate = ship.getActualReceiveDate();// 收货日期
            Long distributionNotificationId = distributionNotificationEntity.getDistributionNotificationId();
            receiveNotificationEntity.setReceiveTime(DateUtils.parseDateTime(actualReceiveDate));// 收货日期
            receiveNotificationEntity.setDistributionNotificationId(distributionNotificationId);// 配送单id
            Long shipId = this.getShipId(distributionNotification, ship.getDeliverCode());
            receiveNotificationEntity.setSendNotificationId(shipId);// 发货单id
            String distributionNotificationCode = distributionNotificationEntity.getDistributionNotificationCode();
            receiveNotificationEntity.setDistributionNotificationCode(distributionNotificationCode);// 配送单编码
            receiveNotificationEntity.setSendNotificationCode(ship.getDeliverCode());
            receiveNotificationEntity.setPaymentMoney(paymentMoney);
            ReceiveNotification receiveNotification = new ReceiveNotification(receiveNotificationEntity);
            receiveNotification.setBlackboard(blackboard);
            receiveNotification.create();
            List<ORDR0501IProductRestParam> productList = ship.getProductList();
            this.createReceiveNotificationDetail(productList, receiveNotification, distributionNotification);
            receiveNotification.complete(false);
            this.getGoodQtyResults(receiveNotification, goodQtyResultMap);
        }

        List<BuyerBatchOrderDetail> buyerBatchOrderDetails = distributionNotification.getBuyerOrder()
                .getBuyerBatchOrderDetails();
        if (CollectionUtils.isEmpty(buyerBatchOrderDetails)) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E050104);
        }
        for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerBatchOrderDetails) {
            buyerBatchOrderDetail.complete(false);
            if (!CollectionUtils.isEmpty(buyerBatchOrderDetail.getBuyerForcastDeliverDetails())) {    // 处理预配送明细数据
                this.dealBuyerForcastDeliverDetails(buyerBatchOrderDetail.getBuyerForcastDeliverDetails(), goodQtyResultMap);
            }
        }

    }

    /**
     * 获取发货单id
     *
     * @param distributionNotification
     * @param deliverCode
     * @return
     */
    public Long getShipId(DistributionNotification distributionNotification, String deliverCode) {
        Long shipId = null;
        List<SendNotification> sendNotificationList = distributionNotification.getSendNotifications();
        for (SendNotification sendNotification : sendNotificationList) {
            SendNotificationEntity sendNotificationEntity = sendNotification.getEntity();
            String sendNotificationCode = sendNotificationEntity.getSendNotificationCode();
            if (deliverCode.equals(sendNotificationCode)) {
                shipId = sendNotificationEntity.getSendNotificationId();
                break;
            }
        }
        return shipId;
    }

    /**
     * 对配送单的预配送明细进行处理更新数据
     *
     * @param buyerForcastDeliverDetails
     */
    public void dealBuyerForcastDeliverDetails(List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails,
                                               Map<Long, ORDR0501IGoodQtyResult> goodQtyResultMap) {
        for (BuyerForcastDeliverDetail buyerForcastDeliverDetail : buyerForcastDeliverDetails) {
            this.dealBuyerForcastDeliverDetail(buyerForcastDeliverDetail, goodQtyResultMap);
        }
    }

    /**
     * 对预配送明细进行处理更新数据
     *
     * @param buyerForcastDeliverDetail
     */
    public void dealBuyerForcastDeliverDetail(BuyerForcastDeliverDetail buyerForcastDeliverDetail,
                                              Map<Long, ORDR0501IGoodQtyResult> goodQtyResultMap) {
        Long buyerForcastDeliverDetailId = buyerForcastDeliverDetail.getEntity().getBuyerForcastDeliverDetailId();
        ORDR0501IGoodQtyResult goodQtyResult = goodQtyResultMap.get(buyerForcastDeliverDetailId);
        if (goodQtyResult != null) {
            BigDecimal receiveQty = goodQtyResult.getReceiveQty();
            buyerForcastDeliverDetail.getEntity().setReceiveQuantity(receiveQty);
            buyerForcastDeliverDetail.modify();
        }

    }


    /**
     * 创建收货明细数据
     *
     * @param productList
     * @param receiveNotification
     * @param distributionNotification
     */
    public void createReceiveNotificationDetail(List<ORDR0501IProductRestParam> productList,
                                                ReceiveNotification receiveNotification, DistributionNotification distributionNotification
    ) {
        Blackboard blackboard = distributionNotification.getBlackboard();
        // 创建收货明细数据
        for (ORDR0501IProductRestParam product : productList) {
            Long shipDetailId = product.getShipDetailId();
            ReceiveNotificationDetailEntity receiveNotificationDetailEntity = new ReceiveNotificationDetailEntity();
            Long receiveNotificationId = receiveNotification.getEntity().getReceiveNotificationId();
            receiveNotificationDetailEntity.setReceiveNotificationId(receiveNotificationId);
            receiveNotificationDetailEntity.setDistributionNotificationDetailId(shipDetailId);
            receiveNotificationDetailEntity.setPricePlateUnitPrice(product.getReceivePrice());
            List<DistributionNotificationDetail> distributionNotificationDetails = distributionNotification
                    .getDistributionNotificationDetails();
            // 得到配送明细信息
            for (DistributionNotificationDetail distributionNotificationDetail : distributionNotificationDetails) {
                DistributionNotificationDetailEntity distributionNotificationDetailEntity = distributionNotificationDetail
                        .getEntity();
                if (distributionNotificationDetailEntity.getDistributionNotificationDetailId()
                        .equals(shipDetailId)) {
                    receiveNotificationDetailEntity.setGoodsId(distributionNotificationDetailEntity.getGoodsId());
                    receiveNotificationDetailEntity.setSku(distributionNotificationDetailEntity.getSku());
                    receiveNotificationDetailEntity.setBatch(distributionNotificationDetailEntity.getBatchCode());
                }
            }
            BigDecimal receiveQty = product.getReceiveQty();
            receiveNotificationDetailEntity.setReceiveQuantity(receiveQty);
            ReceiveNotificationDetail receiveNotificationDetail = new ReceiveNotificationDetail(receiveNotificationDetailEntity);
            receiveNotificationDetail.setBlackboard(blackboard);
            receiveNotificationDetail.create();
            receiveNotification.link(receiveNotificationDetail);
            receiveNotificationDetail.receiveNotificationLinked();
        }
        receiveNotification.receiveNotificationDetailsLinked();
    }


    /**
     * 收集 收货单中
     *
     * @param receiveNotification
     * @param goodQtyResultMap
     */
    public void getGoodQtyResults(ReceiveNotification receiveNotification, Map<Long, ORDR0501IGoodQtyResult> goodQtyResultMap) {
        List<ReceiveNotificationDetail> receiveNotificationDetailList = receiveNotification.getReceiveNotificationDetails();
        for (ReceiveNotificationDetail receiveNotificationDetail : receiveNotificationDetailList) {// 收货单
            DistributionNotificationDetailEntity distributionNotificationDetailEntity = receiveNotificationDetail
                    .getDistributionNotificationDetail().getEntity();
            ReceiveNotificationDetailEntity receiveNotificationDetailEntity = receiveNotificationDetail.getEntity();
            BigDecimal receiveQuantity = receiveNotificationDetailEntity.getReceiveQuantity();
            Long buyerForcastDeliverDetailId = distributionNotificationDetailEntity.getBuyerForcastDeliverDetailId();
            ORDR0501IGoodQtyResult goodQtyResult = goodQtyResultMap.get(buyerForcastDeliverDetailId);
            if (goodQtyResult == null) {
                ORDR0501IGoodQtyResult newGoodQty = new ORDR0501IGoodQtyResult();
                newGoodQty.setBuyerForcastDeliverDetailId(buyerForcastDeliverDetailId);
                newGoodQty.setReceiveQty(receiveQuantity);
                goodQtyResultMap.put(buyerForcastDeliverDetailId, newGoodQty);
            } else {
                BigDecimal oldReceiveQty = goodQtyResult.getReceiveQty();
                BigDecimal sum = DecimalUtils.add(oldReceiveQty, receiveQuantity);
                goodQtyResult.setReceiveQty(sum);
            }
        }
    }


    /**
     * 得到收货单中收货商品的总价
     *
     * @param param
     * @return
     */
    public Map<String, BigDecimal> getReceiveAndDistributionMoney(ORDR0501IRestParam param, DistributionNotification distributionNotification, List<ORDR0501IGoodPriceResult> priceResults) {
        BigDecimal receiveMoney = BigDecimal.ZERO;
        BigDecimal distributionNotificationMoney = BigDecimal.ZERO;
        List<ORDR0501IShipRestParam> shipList = param.getShipList();
        for (ORDR0501IShipRestParam ship : shipList) {
            List<ORDR0501IProductRestParam> productList = ship.getProductList();
            for (ORDR0501IProductRestParam product : productList) {
                BigDecimal receiveQty = product.getReceiveQty();
                BigDecimal delayQty = product.getDelayQty();
                BigDecimal shouldReceiveQty = DecimalUtils.add(receiveQty, delayQty);
                BigDecimal price = product.getReceivePrice();
                BigDecimal productMoney = DecimalUtils.multiply(shouldReceiveQty, price);
                receiveMoney = DecimalUtils.add(receiveMoney, productMoney);
            }
        }
        Map<String, BigDecimal> goodsPriceMap = new HashMap<>();
        for (ORDR0501IGoodPriceResult ordr0501IGoodPriceResult : priceResults) {
            String goodsId = ordr0501IGoodPriceResult.getGoodsId();
            BigDecimal price = ordr0501IGoodPriceResult.getReceivePrice();
            goodsPriceMap.put(goodsId, price);
        }

        List<DistributionNotificationDetail> distributionNotificationDetailList = distributionNotification.getDistributionNotificationDetails();
        for (DistributionNotificationDetail distributionNotificationDetail : distributionNotificationDetailList) {
            DistributionNotificationDetailEntity distributionNotificationDetailEntity = distributionNotificationDetail.getEntity();
            String goodsId = distributionNotificationDetailEntity.getGoodsId();
            BigDecimal distributionQuantity = DecimalUtils.subtract(distributionNotificationDetailEntity.getDistributionQuantity(), distributionNotificationDetailEntity.getCancelQuantity());
            BigDecimal price = goodsPriceMap.get(goodsId);
            if (price == null) {
                throw new BusinessException(ModuleCode.ORDR, "价格同步有问题");
            }
            BigDecimal productMoney = DecimalUtils.multiply(distributionQuantity, price);
            distributionNotificationMoney = DecimalUtils.add(distributionNotificationMoney, productMoney);
        }

        Map<String, BigDecimal> receiveAndDistributionNotificationMoney = new HashMap<>();
        receiveAndDistributionNotificationMoney.put("receiveMoney", receiveMoney);
        receiveAndDistributionNotificationMoney.put("distributionNotificationMoney", distributionNotificationMoney);
        return receiveAndDistributionNotificationMoney;
    }

    /**
     * 得到收货时这个订单下所有商品的单价
     *
     * @param buyerOrder
     * @param param
     * @param distributionNotification
     * @return
     */
    public List<ORDR0501IGoodPriceResult> getGoodPriceResult(BuyerOrder buyerOrder, ORDR0501IRestParam param, DistributionNotification distributionNotification) {
        List<ORDR0501IGoodPriceResult> priceResults = new ArrayList<>();  // 这个配送单下的所有发货单信息
        Map<String, ORDR0501IGoodPriceResult> receiveGoodsPriceMap = this.synchronousReceivePrice(param, distributionNotification);
        Map<String, ORDR0501IGoodPriceResult> otherGoodsPriceMap = this.completeOtherGoodsPrice(buyerOrder, receiveGoodsPriceMap);
        Collection<ORDR0501IGoodPriceResult> receiveGoodsPrices = receiveGoodsPriceMap.values();
        if (CollectionUtils.isNotEmpty(receiveGoodsPrices)) {
            priceResults.addAll(receiveGoodsPrices);
        }
        Collection<ORDR0501IGoodPriceResult> otherGoodsPrices = otherGoodsPriceMap.values();
        if (CollectionUtils.isNotEmpty(otherGoodsPrices)) {
            priceResults.addAll(otherGoodsPrices);
        }
        return priceResults;
    }


    /**
     * 得到所有收货时的商品单价
     *
     * @param param
     * @param distributionNotification
     */
    public Map<String, ORDR0501IGoodPriceResult> synchronousReceivePrice(ORDR0501IRestParam param, DistributionNotification distributionNotification) {
        Map<String, ORDR0501IGoodPriceResult> receiveGoodsPriceMap = new HashMap<>();
        List<DistributionNotificationDetail> distributionNotificationDetailList = distributionNotification
                .getDistributionNotificationDetails();
        if (CollectionUtils.isEmpty(distributionNotificationDetailList)) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E050107);
        }
        List<ORDR0501IShipRestParam> shipList = param.getShipList();  // 收货传过来的发货单信息
        for (ORDR0501IShipRestParam ship : shipList) {// 不同车
            List<ORDR0501IProductRestParam> productList = ship.getProductList();
            for (ORDR0501IProductRestParam product : productList) {
                Long shipDetailId = product.getShipDetailId();
                DistributionNotificationDetail distributionNotificationDetail = this.getDistributionNotificationDetailByShipDetailId(shipDetailId, distributionNotificationDetailList);
                BigDecimal netWeight = distributionNotificationDetail.getBuyerForcastDeliverDetail().getAttachedEntity().getNetWeight();// 净重
                // BigDecimal grossWeight = distributionNotificationDetail.getBuyerForcastDeliverDetail().getAttachedEntity().getGrossWeight();// 毛重
                String goodsId = distributionNotificationDetail.getEntity().getGoodsId();
                ORDR0501IGoodPriceResult goodPriceResult = receiveGoodsPriceMap.get(goodsId);
                if (goodPriceResult == null) {
                    ORDR0501IGoodPriceResult receiveGoodsPriceResult = new ORDR0501IGoodPriceResult();
                    receiveGoodsPriceResult.setGoodsId(goodsId);
                    BigDecimal receiveQty = product.getReceiveQty();
                    BigDecimal delayQty = product.getDelayQty();
                    receiveGoodsPriceResult.setOrderQty(DecimalUtils.add(receiveQty, delayQty));
                    BigDecimal receivePrice = product.getReceivePrice();
                    BigDecimal kgPrice = DecimalUtils.divide(receivePrice, netWeight, 2, RoundingMode.HALF_UP);
                    receiveGoodsPriceResult.setReceivePrice(product.getReceivePrice());
                    receiveGoodsPriceResult.setKgPrice(kgPrice);    //   计算 收货公斤价=箱价/净重
                    receiveGoodsPriceMap.put(goodsId, receiveGoodsPriceResult);
                } else {
                    BigDecimal orderQty = goodPriceResult.getOrderQty();
                    BigDecimal receiveQty = product.getReceiveQty();
                    BigDecimal delayQty = product.getDelayQty();
                    goodPriceResult.setOrderQty(DecimalUtils.add(orderQty, DecimalUtils.add(receiveQty, delayQty)));
                    BigDecimal receivePrice = product.getReceivePrice();
                    BigDecimal kgPrice = DecimalUtils.divide(receivePrice, netWeight, 2, RoundingMode.HALF_UP);
                    goodPriceResult.setReceivePrice(product.getReceivePrice());
                    goodPriceResult.setKgPrice(kgPrice);    //   计算 收货公斤价=箱价/净重
                }
            }

        }
        return receiveGoodsPriceMap;
    }

    /**
     * \
     * 根据shipDetailId  获取配送单
     *
     * @param shipDetailId
     * @return
     */
    public DistributionNotificationDetail getDistributionNotificationDetailByShipDetailId(Long shipDetailId, List<DistributionNotificationDetail> distributionNotificationDetailList) {
        DistributionNotificationDetail target = null;
        for (DistributionNotificationDetail distributionNotificationDetail : distributionNotificationDetailList) {
            DistributionNotificationDetailEntity distributionNotificationDetailEntity = distributionNotificationDetail.getEntity();
            Long distributionNotificationDetailId = distributionNotificationDetailEntity.getDistributionNotificationDetailId();
            if (distributionNotificationDetailId.equals(shipDetailId)) {
                target = distributionNotificationDetail;
                break;
            }
        }
        return target;
    }

    /**
     * 补全 整个订单 除了收货其他 商品价格
     *
     * @param buyerOrder
     * @param receiveGoodsPriceMap 收货时商品集合
     */
    public Map<String, ORDR0501IGoodPriceResult> completeOtherGoodsPrice(BuyerOrder buyerOrder, Map<String, ORDR0501IGoodPriceResult> receiveGoodsPriceMap) {
        // 得到这个订单的所有商品的总数量
        BuyerOrderEntity buyerOrderEntity = buyerOrder.getEntity();
        Map<String, ORDR0501IGoodPriceResult> otherGoodsPriceMap = new HashMap<>();// 收集非收货的商品
        List<BuyerBatchOrderDetail> buyerBatchOrderDetailList = buyerOrder.getBuyerBatchOrderDetails();
        if (CollectionUtils.isEmpty(buyerBatchOrderDetailList)) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E050108);
        }
        for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerBatchOrderDetailList) {
            BuyerBatchOrderDetailEntity buyerBatchOrderDetailEntity = buyerBatchOrderDetail.getEntity();
            BigDecimal goodsQuantity = buyerBatchOrderDetailEntity.getGoodsQuantity();
            BigDecimal cancelQuantity = buyerBatchOrderDetailEntity.getCancelQuantity();
            BigDecimal realQty = DecimalUtils.subtract(goodsQuantity, cancelQuantity);
            String orderDetailGoodsId = buyerBatchOrderDetailEntity.getGoodsId();
            ORDR0501IGoodPriceResult goodPriceResult = receiveGoodsPriceMap.get(orderDetailGoodsId);
            if (goodPriceResult == null) {// 收货入参中没有改商品
                ORDR0501IGoodPriceResult otherGoodsPriceResult = otherGoodsPriceMap.get(orderDetailGoodsId);
                if (otherGoodsPriceResult == null) {//该商品第一次  添加到 otherGoodsPriceMap
                    ORDR0501IGoodPriceResult orderDetailGoodsPriceResult = new ORDR0501IGoodPriceResult();
                    orderDetailGoodsPriceResult.setBuyerOrderId(buyerOrderEntity.getBuyerOrderId());
                    orderDetailGoodsPriceResult.setGoodsId(buyerBatchOrderDetailEntity.getGoodsId());
                    orderDetailGoodsPriceResult.setOrderQty(realQty);
                    otherGoodsPriceMap.put(orderDetailGoodsId, orderDetailGoodsPriceResult);
                } else {//该商品  不是第一次  添加到 otherGoodsPriceMap   累加数量
                    BigDecimal oldOrderQty = otherGoodsPriceResult.getOrderQty();//
                    BigDecimal sum = DecimalUtils.add(oldOrderQty, realQty);
                    otherGoodsPriceResult.setOrderQty(sum);
                }
            }
        }

        Set<String> otherGoodsIds = otherGoodsPriceMap.keySet();
        if (CollectionUtils.isNotEmpty(otherGoodsIds)) {
            List<PriceChannelNotificationDetail> priceChannelNotificationDetails = buyerOrder
                    .getPriceChannelNotification().getPriceChannelNotificationDetails();
            if (CollectionUtils.isEmpty(priceChannelNotificationDetails)) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E050109);
            }
            for (String orderDetailGoodsId : otherGoodsIds) {
                ORDR0501IGoodPriceResult orderDetailGoodsPriceResult = otherGoodsPriceMap.get(orderDetailGoodsId);
                PriceChannelNotificationDetailEntity priceChannelNotificationDetailEntity = this.getPriceChannelNotificationDetailByGoodPriceResult(priceChannelNotificationDetails, orderDetailGoodsPriceResult);
                if (priceChannelNotificationDetailEntity == null) {
                    throw new BusinessException(ModuleCode.ORDR, "价盘查询不到单价");
                }
                orderDetailGoodsPriceResult.setReceivePrice(priceChannelNotificationDetailEntity.getPriceChannelUnitPrice());
                orderDetailGoodsPriceResult.setKgPrice(priceChannelNotificationDetailEntity.getPriceChannelKgPrice());
            }
        }

        return otherGoodsPriceMap;
    }


    /**
     * 根据 商品信息  查询价盘
     *
     * @param priceChannelNotificationDetails
     * @param orderDetailGoodsPriceResult
     * @return
     */
    public PriceChannelNotificationDetailEntity getPriceChannelNotificationDetailByGoodPriceResult
    (List<PriceChannelNotificationDetail> priceChannelNotificationDetails, ORDR0501IGoodPriceResult
            orderDetailGoodsPriceResult) {
        PriceChannelNotificationDetailEntity priceChannelNotificationDetailEntity = null;
        String orderDetailGoodsId = orderDetailGoodsPriceResult.getGoodsId();
        BigDecimal orderQty = orderDetailGoodsPriceResult.getOrderQty();
        for (PriceChannelNotificationDetail priceChannelNotificationDetail : priceChannelNotificationDetails) {
            PriceChannelNotificationDetailEntity entity = priceChannelNotificationDetail
                    .getEntity();
            if (entity.getGoodsId().equals(orderDetailGoodsId)) {
                BigDecimal priceChannelEndQuantity = entity.getPriceChannelEndQuantity();// 通道结束数量
                BigDecimal priceChannelStartQuantity = entity.getPriceChannelStartQuantity();// 通道开始数量
                if (DecimalUtils.le(priceChannelStartQuantity, orderQty) && DecimalUtils.ge(priceChannelEndQuantity, orderQty)) {//  符合取值范围
                    priceChannelNotificationDetailEntity = entity;
                    break;
                }
            }
        }
        return priceChannelNotificationDetailEntity;
    }


    /**
     * 得到这个订单应该付的处运费和优惠的总金额
     *
     * @param priceResults
     * @return
     */
    public BigDecimal getOrderTotalMoney(List<ORDR0501IGoodPriceResult> priceResults) {
        if (CollectionUtils.isEmpty(priceResults)) {
            return BigDecimal.ZERO;
        }
        BigDecimal orderTotalMoney = BigDecimal.ZERO; // 订单总金额
        for (ORDR0501IGoodPriceResult priceResult : priceResults) {
            BigDecimal orderQty = priceResult.getOrderQty();
            BigDecimal receivePrice = priceResult.getReceivePrice();
            BigDecimal orderDetailAmount = DecimalUtils.multiply(orderQty, receivePrice);
            orderTotalMoney = DecimalUtils.add(orderTotalMoney, orderDetailAmount);
        }
        return orderTotalMoney;
    }

    /**
     * 收货单得到所有付款的钱
     *
     * @param paymentList
     * @return
     */
    public BigDecimal getTotalPayMoney(List<ORDR0501IPaymentRestParam> paymentList) {
        if (CollectionUtils.isEmpty(paymentList)) {
            return BigDecimal.ZERO;
        }
        BigDecimal totalPayMoney = BigDecimal.ZERO;
        for (ORDR0501IPaymentRestParam payment : paymentList) {
            BigDecimal paymentMoney = payment.getPaymentMoney();
            totalPayMoney = DecimalUtils.add(totalPayMoney, paymentMoney);
        }
        return totalPayMoney;
    }

    /**
     * 检验收货的发货信息
     *
     * @param distributionNotification
     * @param param
     */
    public void checkReceipt(DistributionNotification distributionNotification, ORDR0501IRestParam param) {
        List<SendNotification> sendNotifications = distributionNotification.getSendNotifications(); // 这个配送单下的所有发货单信息
        if (CollectionUtils.isEmpty(sendNotifications)) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E050110);
        }
        List<ORDR0501IShipRestParam> shipRestParams = param.getShipList(); // 收货传过来的发货单信息
        for (ORDR0501IShipRestParam shipRestParam : shipRestParams) {      // 判断这个发货单中的发货单号是否正确和数量是否正确
            boolean shipIsSendNotification = false;
            for (SendNotification sendNotification : sendNotifications) {
                if (sendNotification.getEntity().getSendNotificationCode().equals(shipRestParam.getDeliverCode())) {
                    shipIsSendNotification = true;
                    List<ORDR0501IProductRestParam> productList = shipRestParam.getProductList();
                    List<SendNotificationDetail> sendNotificationDetails = sendNotification.getSendNotificationDetails();
                    this.checkSendDetailQty(productList, sendNotificationDetails);
                }
            }
            if (!shipIsSendNotification) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E050111, shipRestParam.getDeliverCode());
            }
        }
    }

    /**
     * 检查 发货明细中的数量  sku
     *
     * @param productList
     * @param sendNotificationDetails
     */
    public void checkSendDetailQty(List<ORDR0501IProductRestParam> productList,
                                   List<SendNotificationDetail> sendNotificationDetails) {
        if (CollectionUtils.isEmpty(sendNotificationDetails)) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E050114);
        }
        List<SendNotificationDetail> sendNotificationDetailList = new ArrayList<>();
        sendNotificationDetailList.addAll(sendNotificationDetails);

        Map<String, SendNotificationDetail> sendNotificationSkuMap = new HashMap<>();
        for (SendNotificationDetail sendNotificationDetail : sendNotificationDetailList) {
            String sku = sendNotificationDetail.getEntity().getSku();
            Long distributionNotificationDetailId = sendNotificationDetail.getEntity().getDistributionNotificationDetailId();
            String key = sku + distributionNotificationDetailId;
            BigDecimal tmpQty = sendNotificationDetail.getEntity().getRealSendQuantity();// 发货单发货数量
            if (sendNotificationSkuMap.containsKey(key)) {
                SendNotificationDetailEntity entity = sendNotificationSkuMap.get(key).getEntity();
                BigDecimal sendQty = entity.getRealSendQuantity();
                sendQty = sendQty.add(tmpQty);
                entity.setRealSendQuantity(sendQty);
            } else {
                sendNotificationSkuMap.put(key, sendNotificationDetail);
            }
        }

        Map<String, ORDR0501IProductRestParam> ORDR0501IProductRestParamMap = new HashMap<>();
        for (ORDR0501IProductRestParam productRestParam : productList) {
            String sku = productRestParam.getSkuCode();
            Long distributionNotificationDetailId = productRestParam.getShipDetailId();
            String key = sku + distributionNotificationDetailId;
            BigDecimal tmpDelayQty = productRestParam.getDelayQty();// 收货单迟收数量
            BigDecimal tmpReceiveQty = productRestParam.getReceiveQty();// 收货单收货数量
            BigDecimal tmpReturnQty = productRestParam.getReturnQty();// 收货单退货数量

            if (ORDR0501IProductRestParamMap.containsKey(key)) {
                ORDR0501IProductRestParam param = ORDR0501IProductRestParamMap.get(key);
                BigDecimal delayQty = param.getDelayQty();
                BigDecimal receiveQty = param.getReceiveQty();
                BigDecimal returnQty = param.getReturnQty();

                delayQty = delayQty.add(tmpDelayQty);
                receiveQty = receiveQty.add(tmpReceiveQty);
                returnQty = returnQty.add(tmpReturnQty);

                param.setDelayQty(delayQty);
                param.setReceiveQty(receiveQty);
                param.setReturnQty(returnQty);
            } else {
                ORDR0501IProductRestParam tempParam = new ORDR0501IProductRestParam();
                BeanUtils.copyProperties(productRestParam, tempParam);
                ORDR0501IProductRestParamMap.put(key, tempParam);
            }
        }

        Iterator it = sendNotificationSkuMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry dataEntry = (Map.Entry)it.next();
            String key = (String) dataEntry.getKey();
            SendNotificationDetail sendNotificationDetail = (SendNotificationDetail) dataEntry.getValue();

            boolean receiveFlg = false;

            ORDR0501IProductRestParam productRestParam = ORDR0501IProductRestParamMap.get(key);

            if (productRestParam != null) {
                BigDecimal receiveQty = productRestParam.getReceiveQty();// 收货数量
                BigDecimal delayQty = productRestParam.getDelayQty();
                BigDecimal returnQty = productRestParam.getReturnQty();
                receiveFlg = true;
                SendNotificationDetailEntity sendNotificationDetailEntity = sendNotificationDetail.getEntity();
                BigDecimal realSendQuantity = sendNotificationDetailEntity.getRealSendQuantity();// 发货单发货数量
                if (delayQty != null && returnQty != null) {//  三合一  含有迟收，拒收数量
                    BigDecimal qty = DecimalUtils.add(DecimalUtils.add(receiveQty, delayQty), returnQty);
                    if (!DecimalUtils.eq(realSendQuantity, qty)) {
                        throw new BusinessException(ModuleCode.ORDR, ErrorCode.E050116);
                    }
                } else {// 单个 收货接口 使用
                    if (DecimalUtils.lt(realSendQuantity, receiveQty)) {
                        throw new BusinessException(ModuleCode.ORDR, ErrorCode.E050116);// 收货数量大于发货数量
                    }
                }
            }
            if (!receiveFlg) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E050115);
            }
        }
    }


    /**
     * 收尾
     *
     * @param map HashMap
     */
    private void post(HashMap<String, Object> map) {
        DistributionNotification distributionNotification = (DistributionNotification) map
                .get("distributionNotification");
        String buyerCode = distributionNotification.getBuyerOrder().getAttachedEntity().getBuyerCode();
        this.splitReceiveAndDelayAndRejectPram(map, buyerCode);// 拆分入参
        ORDR0803IBean ordr0803IBean = (ORDR0803IBean) map.get("ordr0803IBean");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        Operator operator = blackboard.getOperator();
        if (ordr0803IBean != null) {// 迟收
            this.ordr0803IService.execute(operator, ordr0803IBean);
        }
        ORDR0804IBean ordr0804IBean = (ORDR0804IBean) map.get("ordr0804IBean");
        if (ordr0804IBean != null) {// 拒收
            this.ordr0804IService.execute(operator, ordr0804IBean);
        }
        ORDR0501IRestResult restResult = new ORDR0501IRestResult();
        Long buyerOrderId=  distributionNotification.getBuyerOrder().getEntity().getBuyerOrderId();
        BuyerOrder buyerOrder=new BuyerOrder(buyerOrderId);
        buyerOrder.setBlackboard(blackboard);
        buyerOrder.complete(false);
        BuyerOrderEntity buyerOrderEntity=  buyerOrder.getEntity();
        restResult.setOrderId(buyerOrderEntity.getBuyerOrderId());
        restResult.setOrderStatus(buyerOrderEntity.getBuyerOrderStu());
        restResult.setShipId(distributionNotification.getEntity().getDistributionNotificationId());
        restResult.setVer(buyerOrderEntity.getVersion());
        restResult.setPaymentType(buyerOrderEntity.getPaymentType());
        map.put("restResult", restResult);
    }

    /**
     * 拆成 3个 接口 入参
     *
     * @param map
     * @return
     */
    public void splitReceiveAndDelayAndRejectPram(HashMap<String, Object> map, String buyerCode) {
        ORDR0501IRestParam param = (ORDR0501IRestParam) map.get("param");
        List<ORDR0501IShipRestParam> shipList = param.getShipList();
        List<ORDR0803ShipIBean> ordr0803ShipIBeanList = new ArrayList<>();
        List<ORDR0804ShipIBean> ordr0804ShipIBeanList = new ArrayList<>();
        for (ORDR0501IShipRestParam ship : shipList) {
            String deliverCode = ship.getDeliverCode();
            List<ORDR0501IProductRestParam> productList = ship.getProductList();
            List<ORDR0803ProductBean> ordr0803ProductBeanList = new ArrayList<>();// 迟收
            List<ORDR0804ProductBean> ordr0804ProductBeanList = new ArrayList<>();// 拒收
            for (ORDR0501IProductRestParam product : productList) {
                BigDecimal delayQty = product.getDelayQty();
                BigDecimal returnQty = product.getReturnQty();
                Long shipDetailId = product.getShipDetailId();
                String skuCode = product.getSkuCode();
                Boolean isDelayFlg = false;
                Boolean isReturnFlg = false;
                if (DecimalUtils.gt(delayQty, new BigDecimal(0))) {// 迟收
                    isDelayFlg = true;
                }
                if (DecimalUtils.gt(returnQty, new BigDecimal(0))) {// 拒收
                    isReturnFlg = true;
                }
                if (isDelayFlg) {// 迟收
                    ORDR0803ProductBean ordr0803ProductBean = new ORDR0803ProductBean();
                    ordr0803ProductBean.setReturnQty(delayQty);
                    ordr0803ProductBean.setShipDetailId(shipDetailId);
                    ordr0803ProductBean.setSkuCode(skuCode);
                    ordr0803ProductBeanList.add(ordr0803ProductBean);
                }
                if (isReturnFlg) {// 拒收
                    ORDR0804ProductBean ordr0804ProductBean = new ORDR0804ProductBean();
                    ordr0804ProductBean.setShipDetailId(shipDetailId);
                    ordr0804ProductBean.setSkuCode(skuCode);
                    ordr0804ProductBean.setReturnQty(returnQty);
                    ordr0804ProductBeanList.add(ordr0804ProductBean);
                }
            }
            if (CollectionUtils.isNotEmpty(ordr0803ProductBeanList)) {// 迟收
                ORDR0803ShipIBean ordr0803ShipIBean = new ORDR0803ShipIBean();
                ordr0803ShipIBean.setDeliverCode(deliverCode);
                ordr0803ShipIBean.setProductList(ordr0803ProductBeanList);
                ordr0803ShipIBeanList.add(ordr0803ShipIBean);// 组装到ship
            }
            if (CollectionUtils.isNotEmpty(ordr0804ProductBeanList)) {// 拒收
                ORDR0804ShipIBean ordr0804ShipIBean = new ORDR0804ShipIBean();
                ordr0804ShipIBean.setDeliverCode(deliverCode);
                ordr0804ShipIBean.setProductList(ordr0804ProductBeanList);
                ordr0804ShipIBeanList.add(ordr0804ShipIBean);//组装到ship
            }

        }
        if (CollectionUtils.isNotEmpty(ordr0803ShipIBeanList)) {// 迟收
            ORDR0803IBean ordr0803IBean = new ORDR0803IBean();
            ordr0803IBean.setApplyMan(param.getApplyMan());
            ordr0803IBean.setApplyRemark(param.getApplyRemark());
            ordr0803IBean.setApplyTime(param.getApplyTime());
            ordr0803IBean.setBuyerCode(buyerCode);
            ordr0803IBean.setBuyerId(param.getBuyerId());
            ordr0803IBean.setImage1(param.getImage1());
            ordr0803IBean.setImage2(param.getImage2());
            ordr0803IBean.setImage3(param.getImage3());
            ordr0803IBean.setImage4(param.getImage4());
            ordr0803IBean.setImage5(param.getImage5());
            ordr0803IBean.setIsPaid(param.getIsPaid());
            ordr0803IBean.setReceiptDate(param.getReceiptDate());
            ordr0803IBean.setReturnMode(Integer.parseInt(BuyerReturnMode.PART.getCode()));// 部分
            Long returnReasonID = param.getReturnReasonID();
            if (returnReasonID != null) {
                ordr0803IBean.setReturnReasonID(new Long(returnReasonID));
            }
            ordr0803IBean.setReturnReasonName(param.getReturnReasonName());
            ordr0803IBean.setShipId(param.getShipId().toString());
            ordr0803IBean.setShipList(ordr0803ShipIBeanList);
            map.put("ordr0803IBean", ordr0803IBean);
        }
        if (CollectionUtils.isNotEmpty(ordr0804ShipIBeanList)) {// 迟收
            ORDR0804IBean ordr0804IBean = new ORDR0804IBean();
            ordr0804IBean.setApplyMan(param.getApplyMan());
            ordr0804IBean.setApplyRemark(param.getApplyRemark());
            ordr0804IBean.setApplyTime(param.getApplyTime());
            ordr0804IBean.setBuyerCode(buyerCode);
            ordr0804IBean.setBuyerId(param.getBuyerId());
            ordr0804IBean.setImage1(param.getImage1());
            ordr0804IBean.setImage2(param.getImage2());
            ordr0804IBean.setImage3(param.getImage3());
            ordr0804IBean.setImage4(param.getImage4());
            ordr0804IBean.setImage5(param.getImage5());
            ordr0804IBean.setIsPaid(param.getIsPaid());
            ordr0804IBean.setReturnMode(Integer.parseInt(BuyerReturnMode.PART.getCode()));// 部分
            Long returnReasonID = param.getReturnReasonID();
            if (returnReasonID != null) {
                ordr0804IBean.setReturnReasonID(new Long(returnReasonID));
            }
            ordr0804IBean.setReturnReasonName(param.getReturnReasonName());
            ordr0804IBean.setShipId(param.getShipId().toString());
            ordr0804IBean.setShipList(ordr0804ShipIBeanList);
            map.put("ordr0804IBean", ordr0804IBean);
        }

    }

    /**
     * 检查发货数量
     *
     * @param distributionNotification
     * @param param
     */
    public void checkSendQty(DistributionNotification distributionNotification, ORDR0501IRestParam param) {
        // 数据库中配送单详细数量MAP
        Map<Long,BigDecimal> disMap = new HashMap<>();
        for (DistributionNotificationDetail detail : distributionNotification.getDistributionNotificationDetails()){
            DistributionNotificationDetailEntity entity = detail.getEntity();
            BigDecimal realDistributionQuantity = DecimalUtils.subtract(entity.getDistributionQuantity(),entity.getCancelQuantity());
            disMap.put(entity.getDistributionNotificationDetailId(),realDistributionQuantity);
        }
        // 数据库中发货单详细数量MAP
        Map<Long,BigDecimal> sendMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(distributionNotification.getSendNotifications())){
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
        }
        // 校验数量
        for (Long detailId : disMap.keySet()) {
            BigDecimal disQty = disMap.get(detailId);
            BigDecimal paramQty = sendMap.get(detailId);
            if (!DecimalUtils.eq(disQty,paramQty)){
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E050117);
            }
        }
    }

    /**
     * 取消商品占用
     *
     * @param buyerBatchOrderDetails
     */
    public void cancelComoAllocate(List<BuyerBatchOrderDetail> buyerBatchOrderDetails) {
        ArrayList<LINV0104IParam> paramList = new ArrayList<>();
        for (BuyerBatchOrderDetail batchOrderDetail : buyerBatchOrderDetails){
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
     * @param buyerForcastDeliverDetails
     */
    public void cancelLinvAllocate(List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails) {
        ArrayList<LINV0104IParam> paramList = new ArrayList<>();
        for (BuyerForcastDeliverDetail forcastDeliverDetail : buyerForcastDeliverDetails){
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
            param.setCancelQty(forcastDeliverDetail.getEntity().getPlanSendQuantity());
            paramList.add(param);

        }
        Stock.CancelLinvAllocate(paramList);
    }
}

