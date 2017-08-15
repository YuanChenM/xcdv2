package com.bms.order.services.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.order.archive.impl.BuyerBatchOrder;
import com.bms.order.archive.impl.BuyerBatchOrderDetail;
import com.bms.order.archive.impl.BuyerForcastDeliverDetail;
import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.param.ORDR0203IBeanParam;
import com.bms.order.constant.enumeration.BuyerBatchOrderStu;
import com.bms.order.constant.enumeration.OperatorType;
import com.bms.order.dao.BuyerBatchOrderAttachedDao;
import com.bms.order.dao.BuyerBatchOrderDao;
import com.bms.order.dao.BuyerBatchOrderDetailAttachedDao;
import com.bms.order.dao.BuyerBatchOrderDetailDao;
import com.bms.order.dao.BuyerForcastDeliverDetailAttachedDao;
import com.bms.order.dao.BuyerForcastDeliverDetailDao;
import com.bms.order.services.ORDR0203IService;
import com.framework.core.utils.DecimalUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;

/**
 * 订单分拆结果确认接口Service
 *
 * @author peng_hao
 */
@Service
public class ORDR0203IServiceImpl implements ORDR0203IService {

    @Autowired
    private BaseRedisDao redisDao;

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

    /**
     * 订单系统/平台订单人员对分拆待确认的订单分拆单进行确认
     *
     * @param operator
     *            操作者
     * @param bean
     *            ORDR0203IRestParam
     *
     */
    @Override
    public void execute(Operator operator, ORDR0203IBeanParam bean) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        blackboard.setOperator(operator);
        map.put("bean", bean);
        map.put("blackboard", blackboard);

        pre(map);
        process(map);
        post(map);
    }

    /**
     * 准备
     *
     * @param map
     *            HashMap
     */
    private void pre(HashMap<String, Object> map) {
        // 获取参数
        ORDR0203IBeanParam bean = (ORDR0203IBeanParam) map.get("bean");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.putBaseDao(buyerBatchOrderAttachedDao);
        blackboard.putBaseDao(buyerBatchOrderDao);
        blackboard.putBaseDao(buyerBatchOrderDetailDao);
        blackboard.putBaseDao(buyerBatchOrderDetailAttachedDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailAttachedDao);
        blackboard.setBaseRedisDao(redisDao);

        // 操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);

        // 获取分批单
        BuyerBatchOrder buyerBatchOrder = bean.generateBuyerBatchOrder();
        buyerBatchOrder.setBlackboard(blackboard);
        buyerBatchOrder.complete(false);

        // 数据权限验证
        checkDataAuthority(operator);

        // 验证买家分批订单的有效性
        checkBuyerBatchOrder(buyerBatchOrder);

        // 验证买家分批订单明细的有效性
        checkBuyerBatchOrderDetails(buyerBatchOrder.getBuyerBatchOrderDetails());

        // 返回参数
        map.put("buyerBatchOrder", buyerBatchOrder);
    }

    /**
     * 数据权限验证
     * 
     * @param operator
     */
    private void checkDataAuthority(Operator operator) {
        OperatorType operatorType = OperatorType.getInstance(operator.getOperatorType());
        switch (operatorType) {
        // 只有平台人员能够取消分批订单明细
        case MANAGER:
            break;
        default:
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020301, operatorType.getName());
        }
    }

    /**
     * 验证买家分批订单的有效性
     * 
     * @param buyerBatchOrder
     */
    private void checkBuyerBatchOrder(BuyerBatchOrder buyerBatchOrder) {
        // 分批订单必须存在
        if (!buyerBatchOrder.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020302);
        }

        // 分批订单结果必须为分拆待确认
        BuyerBatchOrderStu stu = BuyerBatchOrderStu.getInstance(buyerBatchOrder.getEntity().getBuyerBatchOrderStu());
        if (stu == BuyerBatchOrderStu.CONFIRMED) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020303);
        } else if (stu != BuyerBatchOrderStu.SPLIT_CONFIRM) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020304, stu == null ? "空" : stu.getName());
        }
    }

    /**
     * 验证买家分批订单明细的有效性
     * 
     * @param buyerBatchOrderDetails
     */
    private void checkBuyerBatchOrderDetails(List<BuyerBatchOrderDetail> buyerBatchOrderDetails) {
        // 分批订单明细必须存在
        if (buyerBatchOrderDetails == null || buyerBatchOrderDetails.size() == 0) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020305);
        }

        // 分批订单明细必须已经分拆
        for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerBatchOrderDetails) {
            if (buyerBatchOrderDetail.getEntity().getSplitFlg() == false) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020306);
            }
        }

        // 分批订单明细必须有预配送明细
        for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerBatchOrderDetails) {
            List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails = buyerBatchOrderDetail
                    .getBuyerForcastDeliverDetails();
            if (buyerForcastDeliverDetails == null || buyerForcastDeliverDetails.size() == 0) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020307);
            }
        }

        // 分批订单明细必须全部分拆
        for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerBatchOrderDetails) {
            List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails = buyerBatchOrderDetail
                    .getBuyerForcastDeliverDetails();

            // 商品数量-取消数量
            BigDecimal splitNum = DecimalUtils.subtract(buyerBatchOrderDetail.getEntity().getGoodsQuantity(),
                    buyerBatchOrderDetail.getEntity().getCancelQuantity());

            // SUM(预配送明细.应该发货数量)
            BigDecimal sumPlanSendNum = BigDecimal.ZERO;
            for (BuyerForcastDeliverDetail buyerForcastDeliverDetail : buyerForcastDeliverDetails) {
                sumPlanSendNum = DecimalUtils.add(sumPlanSendNum,
                        buyerForcastDeliverDetail.getEntity().getPlanSendQuantity());
            }

            // 商品数量-取消数量=SUM(预配送明细.应该发货数量)
            if (!DecimalUtils.eq(splitNum, sumPlanSendNum)) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020308);
            }
        }
    }

    /**
     * 执行
     *
     * @param map
     *            HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        BuyerBatchOrder buyerBatchOrder = (BuyerBatchOrder) map.get("buyerBatchOrder");

        // 修改分批订单状态
        buyerBatchOrder.getEntity().setBuyerBatchOrderStu(BuyerBatchOrderStu.CONFIRMED.getCode());
        buyerBatchOrder.modify();
    }

    /**
     * 收尾
     *
     * @param map
     *            HashMap
     */
    private void post(HashMap<String, Object> map) {
        // 获取参数

        // 返回参数

    }
}
