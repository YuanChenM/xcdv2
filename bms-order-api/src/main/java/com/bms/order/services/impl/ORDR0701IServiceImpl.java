package com.bms.order.services.impl;

import com.bms.order.archive.impl.*;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.PaymentEntity;
import com.bms.order.bean.param.ORDR0701IBeanParam;
import com.bms.order.constant.enumeration.BsOrderStu;
import com.bms.order.constant.enumeration.DistributionNotificationStu;
import com.bms.order.constant.enumeration.OrderType;
import com.bms.order.constant.enumeration.PaymentStu;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.*;
import com.bms.order.services.ORDR0701IService;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.DecimalUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * 支付通知回传接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0701IServiceImpl implements ORDR0701IService {

    @Autowired
    private BaseRedisDao baseRedisDao;

    @Autowired
    private BuyerOrderDao buyerOrderDao;

    @Autowired
    private BuyerOrderAttachedDao buyerOrderAttachedDao;

    @Autowired
    private BsOrderDao bsOrderDao;

    @Autowired
    private BsOrderAttachedDao bsOrderAttachedDao;

    @Autowired
    private DistributionNotificationDao distributionNotificationDao;

    @Autowired
    private BsOrderDetailDao bsOrderDetailDao;

    @Autowired
    private BsOrderDetailAttachedDao bsOrderDetailAttachedDao;

    @Autowired
    private BsStockpileSplitDetailDao bsStockpileSplitDetailDao;

    @Autowired
    private BsStockpileSplitDetailAttachedDao bsStockpileSplitDetailAttachedDao;

    @Autowired
    private PaymentDao paymentDao;

    /**
     * 资金结算系统发送支付信息，通知订单系统进行系统内支付
     *
     * @param operator 操作者
     * @param param    ORDR0701IRestParam
     */
    @Override
    public void execute(Operator operator, ORDR0701IBeanParam param) {
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
        ORDR0701IBeanParam param = (ORDR0701IBeanParam) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.setBaseRedisDao(baseRedisDao);
        blackboard.putBaseDao(buyerOrderDao);
        blackboard.putBaseDao(buyerOrderAttachedDao);
        blackboard.putBaseDao(bsOrderDao);
        blackboard.putBaseDao(bsOrderAttachedDao);
        blackboard.putBaseDao(distributionNotificationDao);
        blackboard.putBaseDao(bsOrderDetailDao);
        blackboard.putBaseDao(bsOrderDetailAttachedDao);
        blackboard.putBaseDao(bsStockpileSplitDetailDao);
        blackboard.putBaseDao(bsStockpileSplitDetailAttachedDao);
        blackboard.putBaseDao(paymentDao);

        //操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);

        getCashPool(operator);
        BuyerOrder buyerOrder = param.generateBuyerOrder();
        buyerOrder.setBlackboard(blackboard);
        BsOrder bsOrder = param.generateBsOrder();
        bsOrder.setBlackboard(blackboard);
        map.put("buyerOrder", buyerOrder);
        map.put("bsOrder", bsOrder);
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        BuyerOrder buyerOrder = (BuyerOrder) map.get("buyerOrder");
        BsOrder bsOrder = (BsOrder) map.get("bsOrder");
        ORDR0701IBeanParam param = (ORDR0701IBeanParam) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        modifyPaymentInfo(buyerOrder, bsOrder, param);
        saveOrderPayment(param, blackboard);
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

    /**
     * 更新买家订单/买手订单的相关支付信息
     *
     * @param buyerOrder
     * @param bsOrder
     * @param param
     */
    public void modifyPaymentInfo(BuyerOrder buyerOrder, BsOrder bsOrder, ORDR0701IBeanParam param) {
        // 判断订单分类
        if (OrderType.BUYER_ORDER.getCode().equals(param.getOrderType())) {
            dealBuyerOrder(buyerOrder, param);
        } else {
            dealBsOrder(bsOrder, param);
        }
    }

    /**
     * 买家订单处理逻辑
     *
     * @param buyerOrder
     * @param param
     */
    private void dealBuyerOrder(BuyerOrder buyerOrder, ORDR0701IBeanParam param) {
        buyerOrder.complete(false);
        // 判断买家订单是否存在
        if (!buyerOrder.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E070101 + buyerOrder.getEntity().getBuyerOrderId());
        }
        // 判断支付金额
        checkPaymentAmount(param);
        // 判断订单是否生成配送通知单
        if (CollectionUtils.isNotEmpty(buyerOrder.getDistributionNotifications())) {
            for (DistributionNotification distributionNotification : buyerOrder.getDistributionNotifications()) {
                if (!distributionNotification.getEntity().getDistributionNotificationStu()
                        .equals(DistributionNotificationStu.CANCEL.getCode())
                        && distributionNotification.getEntity().getDelFlg()) {
                    throw new BusinessException(ModuleCode.ORDR,
                            ErrorCode.E070102 + buyerOrder.getEntity().getBuyerOrderId());
                }
            }
        }
        // 更新买家订单
        modifyBuyerOrder(buyerOrder, param);

    }

    /**
     * 买手订单处理逻辑
     *
     * @param bsOrder
     * @param param
     */
    private void dealBsOrder(BsOrder bsOrder, ORDR0701IBeanParam param) {

        bsOrder.complete(false);
        // 判断买手订单是否存在
        if (!bsOrder.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E070103 + bsOrder.getEntity().getBsOrderId());
        }
        // 判断支付金额
        checkPaymentAmount(param);
        // 判断订单状态
        if (!BsOrderStu.CONFIRMED.getCode().equals(bsOrder.getEntity().getBsOrderStu())) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E070104, StringUtils.toString(bsOrder.getEntity().getBsOrderId()));
        }
        // 更新买手订单
        modifyBsOrder(bsOrder, param);
    }

    /**
     * 判断支付金额
     *
     * @param param
     */
    private void checkPaymentAmount(ORDR0701IBeanParam param) {
        if (!DecimalUtils.gt(param.getPaymentAmount(), BigDecimal.ZERO)) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E070105);
        }
    }

    /**
     * 更新买家订单
     *
     * @param buyerOrder
     * @param param
     */
    private void modifyBuyerOrder(BuyerOrder buyerOrder, ORDR0701IBeanParam param) {
        // 已收金额 = 原已收金额 + 支付金额
        BigDecimal receiveAmount = DecimalUtils.add(buyerOrder.getEntity().getReceiveAmount(),
                param.getPaymentAmount());
        // 订单金额
        BigDecimal orderAmount = buyerOrder.getEntity().getOrderAmount();
        // 运费金额
        BigDecimal freight = buyerOrder.getEntity().getFreight();
        // 优惠金额
        BigDecimal preferentialAmount = buyerOrder.getEntity().getPreferentialAmount();
        // 总金额
        BigDecimal sumAmount = DecimalUtils.subtract(DecimalUtils.add(orderAmount, freight), preferentialAmount);
        // 更新已收金额
        buyerOrder.getEntity().setReceiveAmount(receiveAmount);
        // 支付状态
        String paymentStatus = buyerOrderPaymentStu(receiveAmount, sumAmount);
        // 更新支付状态
        buyerOrder.getEntity().setPaymentStu(paymentStatus);
        buyerOrder.modify();
    }

    /**
     * 更新买手订单
     *
     * @param bsOrder
     * @param param
     */
    private void modifyBsOrder(BsOrder bsOrder, ORDR0701IBeanParam param) {
        // 已收金额 = 原已收金额 + 支付金额
        BigDecimal receiveAmount = DecimalUtils.add(bsOrder.getEntity().getReceiveAmount(), param.getPaymentAmount());
        // 订单金额
        BigDecimal orderAmount = bsOrder.getEntity().getOrderAmount();
        // 优惠金额
        BigDecimal preferentialAmount = bsOrder.getEntity().getPreferentialAmount();
        // 总金额
        BigDecimal sumAmount = DecimalUtils.subtract(orderAmount, preferentialAmount);
        // 更新已收金额
        bsOrder.getEntity().setReceiveAmount(receiveAmount);
        // 支付状态
        String paymentStatus = bsOrderPaymentStu(receiveAmount, sumAmount);
        bsOrder.getEntity().setPaymentStu(paymentStatus);
        bsOrder.modify();
    }

    /**
     * 买家订单支付状态判断
     *
     * @param receiveAmount 已收金额
     * @param sumAmount     总金额
     * @return
     */
    private String buyerOrderPaymentStu(BigDecimal receiveAmount, BigDecimal sumAmount) {

        if (DecimalUtils.ge(receiveAmount, sumAmount)) {
            return PaymentStu.ALL_PAYMENT.getCode();
        }
        return PaymentStu.PART_PAYMENT.getCode();
    }

    /**
     * 买手订单支付状态判断
     *
     * @param receiveAmount 已收金额
     * @param sumAmount     总金额
     * @return
     */
    private String bsOrderPaymentStu(BigDecimal receiveAmount, BigDecimal sumAmount) {

        if (DecimalUtils.ge(receiveAmount, sumAmount)) {
            return PaymentStu.ALL_PAYMENT.getCode();
        }
        return PaymentStu.PART_PAYMENT.getCode();
    }

    /**
     * 资金池调用人
     *
     * @param operator
     * @return
     */
    public void getCashPool(Operator operator) {
        Assert.notNull(operator);
        if (operator.isCashPool()) {
        } else {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E070106);
        }
    }

    /**
     * 保存支付信息
     *
     * @param param
     */

    public void saveOrderPayment(ORDR0701IBeanParam param, Blackboard blackboard) {
        PaymentEntity entity = new PaymentEntity();
        BeanUtils.copyProperties(param, entity);
        entity.setPaymentDatetime(DateUtils.getCurrent());
        Payment payment = Payment.build(blackboard).forCreate(entity);
        payment.create();
    }
}
