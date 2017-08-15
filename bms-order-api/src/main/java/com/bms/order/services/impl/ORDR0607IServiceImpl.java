package com.bms.order.services.impl;

import com.bms.order.archive.impl.BsOrder;
import com.bms.order.archive.impl.BsOrderDetail;
import com.bms.order.archive.impl.BsStockpileSplitDetail;
import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.param.ORDR0607IFilterParam;
import com.bms.order.constant.enumeration.*;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.*;
import com.bms.order.external.archive.Stock;
import com.bms.order.external.bean.param.LinvRestParam;
import com.bms.order.fms.common.FmsCommon;
import com.bms.order.services.ORDR0607IService;
import com.framework.core.utils.DecimalUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 买手订单查询接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0607IServiceImpl implements ORDR0607IService {

    public static final Logger logger = LoggerFactory.getLogger(ORDR0607IServiceImpl.class);

    @Autowired
    private BaseRedisDao redisDao;

    @Autowired
    private BsOrderDao bsOrderDao;

    @Autowired
    private BsOrderAttachedDao bsOrderAttachedDao;

    @Autowired
    private BsOrderDetailDao bsOrderDetailDao;

    @Autowired
    private BsOrderDetailAttachedDao bsOrderDetailAttachedDao;

    @Autowired
    private BsStockpileSplitDetailDao bsStockpileSplitDetailDao;

    @Autowired
    private BsStockpileSplitDetailAttachedDao bsStockpileSplitDetailAttachedDao;

    @Autowired
    private FmsCommon fmsCommon;

    /**
     * 买手囤货完成前，对订单基本信息进行修改
     *
     * @param operator 操作者
     * @param param    ORDR0602IRestParam
     */
    @Transactional
    @Override
    public void execute(Operator operator, ORDR0607IFilterParam param) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();

        blackboard.setOperator(operator);

        Long bsOrderId = param.getBsOrderId();

        map.put("bsOrderId", bsOrderId);
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
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(bsOrderDao);
        blackboard.putBaseDao(bsOrderAttachedDao);
        blackboard.putBaseDao(bsOrderDetailDao);
        blackboard.putBaseDao(bsOrderDetailAttachedDao);
        blackboard.putBaseDao(bsStockpileSplitDetailDao);
        blackboard.putBaseDao(bsStockpileSplitDetailAttachedDao);

        // 操作者
        Operator operator = blackboard.getOperator();
        OperatorType operatorType = OperatorType.getInstance(operator.getOperatorType());
        if (!operator.getOperatorType().equals(OperatorType.MANAGER.getCode())) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000001, operatorType.getName());
        }
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        Long bsOrderId = (Long) map.get("bsOrderId");
        Blackboard blackboard = (Blackboard) map.get("blackboard");

        // 查询订单是否存在
        BsOrder bsOrder = BsOrder.build(blackboard).forComplete(bsOrderId);
        bsOrder.complete(false);
        if (!bsOrder.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060201);
        }
        // 校验买手订单状态
        checkBsOrderStatus(bsOrder);
//        // 校验买手订单支付状态是否是未付款（实付＜预付应付+定金应付）
//        checkBsOrderAmountStatus(bsOrder);
        // 调用商品交易完成接口
        postBsOrder(bsOrder);
        bsOrder.modify();
    }

    /**
     * 收尾
     *
     * @param map HashMap
     */
    private void post(HashMap<String, Object> map) {
        Long bsOrderId = (Long) map.get("bsOrderId");
        // 推送买手囤货完成订单
        try {
            fmsCommon.pushAgentOrder(bsOrderId);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

    /**
     * 订单状态是：已确认、 囤货失败 的订单才能囤货。
     *
     * @param bsOrder
     */
    private void checkBsOrderStatus(BsOrder bsOrder) {

        String bsOrderStu = bsOrder.getEntity().getBsOrderStu();

        if (null != bsOrderStu && !bsOrderStu.equals(BsOrderStu.CONFIRMED.getCode())
                && !bsOrderStu.equals(BsOrderStu.STOCKPILE_FAILURE.getCode())) {

            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060203);
        }

    }

    /**
     * 校验买手订单支付状态是否是未付款（实付＜预付应付+定金应付）
     *
     * @param bsOrder
     */
    private void checkBsOrderAmountStatus(BsOrder bsOrder) {
        if (StringUtils.isEmpty(bsOrder.getEntity().getPaymentStu())) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060203);
        }
        if (!bsOrder.getEntity().getPaymentStu().equals(PaymentStu.ALL_PAYMENT.getCode())) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060203);
        }
        // 已收金额
        BigDecimal receiveAmount = bsOrder.getEntity().getReceiveAmount();
        // 预付应付
        BigDecimal advancePaymentAmount = bsOrder.getEntity().getAdvancePaymentAmount();
        // 定金应付
        BigDecimal earnestAmount = bsOrder.getEntity().getEarnestAmount();

        if (null == receiveAmount) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060701);
        }
        if (null == advancePaymentAmount) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060702);
        }
        if (null == earnestAmount) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060703);
        }
        if (receiveAmount.compareTo(DecimalUtils.add(advancePaymentAmount, earnestAmount)) < 0) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060704);
        }
    }

    /**
     *  调用商品交易完成接口
     *
     * @param bsOrder
     */
    private void postBsOrder(BsOrder bsOrder) {
        ArrayList<LinvRestParam> stockList = new ArrayList<>();
        for (BsOrderDetail orderDetail : bsOrder.getBsOrderDetails()) {
            for (BsStockpileSplitDetail bsStockSplitDetail : orderDetail.getBsStockpileSplitDetails()) {
                LinvRestParam linvRestParam = new LinvRestParam();
                if (bsOrder.getEntity().getOrderType().equals(BsOrderType.BS_A_STOCKPILING_ORDER.getCode())) {
                    linvRestParam.setDeductSrcInv(true);
                    linvRestParam.setComoIvType(ComoIvType.Actual.getCode());
                    linvRestParam.setBizType(BizType.ActualStore.getCode());
                } else if (bsOrder.getEntity().getOrderType().equals(BsOrderType.BS_B_STOCKPILING_ORDER.getCode())) {
                    linvRestParam.setDeductSrcInv(false);
                    linvRestParam.setComoIvType(ComoIvType.Virtual.getCode());
                    linvRestParam.setBizType(BizType.VirtualStore.getCode());
                } else if (bsOrder.getEntity().getOrderType().equals(BsOrderType.BS_SHORT_SELLING_ORDER.getCode())){
                    linvRestParam.setDeductSrcInv(true);
                    linvRestParam.setComoIvType(ComoIvType.Actual.getCode());
                    linvRestParam.setBizType(BizType.AlgorithmicStore.getCode());
                } else {
                    throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060203);
                }
                linvRestParam.setLogicAreaId(bsOrder.getEntity().getLogisticsZoneId());
                linvRestParam.setOwnerId(bsStockSplitDetail.getEntity().getSellerId());
                linvRestParam.setOwnerType(OwnerType.Seller.getCode());
                linvRestParam.setOwnerCode(bsStockSplitDetail.getAttachedEntity().getSellerCode());
                linvRestParam.setCommodityId(orderDetail.getEntity().getGoodsId());
                linvRestParam.setAddTargetInv(true);
                linvRestParam.setRefNo(bsOrder.getEntity().getBsOrderCode());
                linvRestParam.setTransactionId(bsOrder.getEntity().getBsOrderId());
                linvRestParam.setTransactionNo(bsOrder.getEntity().getBsOrderCode());
                linvRestParam.setTransactionDetailId(bsStockSplitDetail.getEntity().getBsStockpileSplitDetailId());
                linvRestParam.setTargetId(bsOrder.getEntity().getBsId());
                linvRestParam.setTargetCode(bsOrder.getAttachedEntity().getBsCode());
                linvRestParam.setTargetType(OwnerType.Agent.getCode());
                linvRestParam.setTargetName(bsOrder.getAttachedEntity().getBsName());
                linvRestParam.setBuyPrice(orderDetail.getEntity().getRealUnitPrice());
                // 货权的时候不占用库存，不需要扣减库存
                if (bsOrder.getEntity().getOrderType().equals(BsOrderType.BS_A_STOCKPILING_ORDER.getCode())) {
                    linvRestParam.setReleaseQty(bsStockSplitDetail.getEntity().getGoodsQuantity());
                } else if (bsOrder.getEntity().getOrderType().equals(BsOrderType.BS_B_STOCKPILING_ORDER.getCode())) {
                    linvRestParam.setReleaseQty(BigDecimal.ZERO);
                } else if (bsOrder.getEntity().getOrderType().equals(BsOrderType.BS_SHORT_SELLING_ORDER.getCode())){
                    linvRestParam.setReleaseQty(bsStockSplitDetail.getEntity().getGoodsQuantity());
                }
                linvRestParam.setDealQty(bsStockSplitDetail.getEntity().getGoodsQuantity());
                stockList.add(linvRestParam);
            }
        }
        try {
            // 囤货成功
            Stock.StoreObtain(stockList);
            bsOrder.getEntity().setBsOrderStu(BsOrderStu.COMPLETE_STOCKPILE.getCode());
        } catch (Exception e) {
            logger.info(e.getMessage());
            bsOrder.getEntity().setBsOrderStu(BsOrderStu.STOCKPILE_FAILURE.getCode());
        }
    }
}
