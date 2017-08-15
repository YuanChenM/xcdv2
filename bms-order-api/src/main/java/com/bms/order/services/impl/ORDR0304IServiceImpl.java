package com.bms.order.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.BuyerBatchOrder;
import com.bms.order.archive.impl.BuyerBatchOrderDetail;
import com.bms.order.archive.impl.BuyerForcastDeliverDetail;
import com.bms.order.archive.impl.DistributionCancelNotification;
import com.bms.order.archive.impl.DistributionNotification;
import com.bms.order.archive.impl.DistributionNotificationDetail;
import com.bms.order.archive.impl.Operator;
import com.bms.order.archive.impl.list.BuyerBatchOrderDetailList;
import com.bms.order.archive.impl.list.BuyerBatchOrderList;
import com.bms.order.archive.impl.list.BuyerForcastDeliverDetailList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.param.ORDR0304IBeanParam;
import com.bms.order.constant.enumeration.BuyerBatchOrderStu;
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
import com.bms.order.dao.DistributionCancelNotificationDao;
import com.bms.order.dao.DistributionNotificationDao;
import com.bms.order.dao.DistributionNotificationDetailDao;
import com.bms.order.services.ORDR0304IService;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;

/**
 * 配送通知单取消回传接口Service
 *
 * @author wu_honglei
 */
@Service
public class ORDR0304IServiceImpl implements ORDR0304IService {

    @Autowired
    private BaseRedisDao redisDao;

    @Autowired
    private DistributionCancelNotificationDao disCancelDao;

    @Autowired
    private DistributionNotificationDao disDao;

    @Autowired
    private DistributionNotificationDetailDao disDetailDao;

    @Autowired
    private BuyerForcastDeliverDetailDao forcastDetailDao;

    @Autowired
    private BuyerForcastDeliverDetailAttachedDao forcastDetailAttachedDao;

    @Autowired
    private BuyerBatchOrderDetailDao buyerBatchOrderDetailDao;

    @Autowired
    private BuyerBatchOrderDetailAttachedDao buyerBatchOrderDetailAttachedDao;

    @Autowired
    private BuyerBatchOrderDao buyerBatchOrderDao;

    @Autowired
    private BuyerBatchOrderAttachedDao buyerBatchOrderAttachedDao;

    /**
     * 配送通知单取消取消通知WMS后收到的是否成功的回传信息
     *
     * @param operator
     *            操作者
     * @param bean
     *            ORDR0602IRestParam
     */
    @Transactional
    @Override
    public void execute(Operator operator, ORDR0304IBeanParam bean) {
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
        ORDR0304IBeanParam bean = (ORDR0304IBeanParam) map.get("bean");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(disCancelDao);
        blackboard.putBaseDao(disDao);
        blackboard.putBaseDao(disDetailDao);
        blackboard.putBaseDao(forcastDetailDao);
        blackboard.putBaseDao(forcastDetailAttachedDao);
        blackboard.putBaseDao(buyerBatchOrderDetailDao);
        blackboard.putBaseDao(buyerBatchOrderDetailAttachedDao);
        blackboard.putBaseDao(buyerBatchOrderDao);
        blackboard.putBaseDao(buyerBatchOrderAttachedDao);

        // 操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);

        // 获取配送通知单
        DistributionNotification distributionNotification = bean.distributionNotification();
        distributionNotification.setBlackboard(blackboard);

        // 数据权限验证
        checkDataAuthority(operator);

        // 验证配送通知单
        checkDistributionNotification(distributionNotification,bean);

        // 验证配送取消通知单
        checkDistributionCancelNotification(distributionNotification);

        // 设置参数
        map.put("distributionNotification", distributionNotification);
    }

    /**
     * 数据权限验证
     * 
     * @param operator
     */
    private void checkDataAuthority(Operator operator) {
        OperatorType operatorType = OperatorType.getInstance(operator.getOperatorType());

        // 仅有美迪福有操作该接口的权限
        if (operatorType != OperatorType.MADE_4_NET) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000001, operatorType.getName());
        }
    }

    /**
     * 验证配送通知单
     * 
     * @param distributionNotification
     */
    private void checkDistributionNotification(DistributionNotification distributionNotification, ORDR0304IBeanParam bean) {
        // 验证配送通知单是否存在
        distributionNotification.complete(false);
        if (!distributionNotification.isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E030401);

        if (!bean.getOrderId().equals(distributionNotification.getEntity().getBuyerOrderId())){
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E030401);
        }
        // 验证配送通知单状态是否为取消中
        DistributionNotificationStu stu = DistributionNotificationStu
                .getInstance(distributionNotification.getEntity().getDistributionNotificationStu());
        if (stu != DistributionNotificationStu.IN_CANCEL)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E030402);
    }

    /**
     * 验证配送取消通知单
     * 
     * @param distributionNotification
     */
    private void checkDistributionCancelNotification(DistributionNotification distributionNotification) {
        // 获取配送取消通知单
        DistributionCancelNotification distributionCancelNotification = distributionNotification
                .getDistributionCancelNotification();

        // 验证配送取消通知单是否存在
        if (distributionCancelNotification == null)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E030403);
    }

    /**
     * 执行
     *
     * @param map
     *            HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        ORDR0304IBeanParam bean = (ORDR0304IBeanParam) map.get("bean");
        // 获取配送通知单
        DistributionNotification distributionNotification = (DistributionNotification) map
                .get("distributionNotification");
        // 获取取消结果
        DistributionCancelNotification cancelResult = bean.cancelResult();
        // 获取配送取消通知单
        DistributionCancelNotification distributionCancelNotification = distributionNotification
                .getDistributionCancelNotification();

        Boolean success = cancelResult.getEntity().getSuccessFlg();
        if (success) {
            // 取消成功
            // 更新配送取消通知单
            distributionCancelNotification.getEntity().setSuccessFlg(success);
            distributionCancelNotification.getEntity()
                    .setWmsCancelDatetime(cancelResult.getEntity().getWmsCancelDatetime());
            distributionCancelNotification.modify();

            // 更新配送单状态
            distributionNotification.getEntity()
                    .setDistributionNotificationStu(DistributionNotificationStu.CANCEL.getCode());
            distributionNotification.modify();

            // 更新分批订单状态
            List<BuyerBatchOrder> buyerBatchOrders = getBuyerBatchOrders(distributionNotification);
            List<BuyerBatchOrder> modifiedBuyerBatchOrders = new ArrayList<>();
            for (BuyerBatchOrder buyerBatchOrder : buyerBatchOrders) {
                BuyerBatchOrderStu buyerBatchOrderStu = BuyerBatchOrderStu
                        .getInstance(buyerBatchOrder.getEntity().getBuyerBatchOrderStu());
                // 如果状态为待发货，回滚为已确认
                if (buyerBatchOrderStu == BuyerBatchOrderStu.WAIT_SEND) {
                    buyerBatchOrder.getEntity().setBuyerBatchOrderStu(BuyerBatchOrderStu.CONFIRMED.getCode());
                    modifiedBuyerBatchOrders.add(buyerBatchOrder);
                }
            }
            if (modifiedBuyerBatchOrders.size() > 0) {
                BuyerBatchOrderList buyerBatchOrderList = BuyerBatchOrderList
                        .build(distributionNotification.getBlackboard())
                        .forUpdate(modifiedBuyerBatchOrders.toArray(new BuyerBatchOrder[0]));
                buyerBatchOrderList.modify();
            }

        } else {
            // 取消失败
            // 更新配送取消通知单的是否取消成功标志
            distributionCancelNotification.getEntity().setSuccessFlg(success);
            distributionCancelNotification.modify();

            // 更新配送通知单状态
            distributionNotification.getEntity()
                    .setDistributionNotificationStu(DistributionNotificationStu.TO_DISTRIBUTION.getCode());
            distributionNotification.modify();
        }
    }

    /**
     * 获取分批订单
     * 
     * @param distributionNotification
     * @return
     */
    private List<BuyerBatchOrder> getBuyerBatchOrders(DistributionNotification distributionNotification) {
        // 配送通知单->配送通知单明细
        List<DistributionNotificationDetail> distributionNotificationDetails = distributionNotification
                .getDistributionNotificationDetails();
        if (distributionNotificationDetails == null) // 数据异常
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000002, "配送通知单明细不存在");

        // 配送通知单明细->预配送明细
        Long[] buyerForcastDeliverDetailIds = new Long[distributionNotificationDetails.size()];
        for (int i = 0; i < distributionNotificationDetails.size(); i++) {
            buyerForcastDeliverDetailIds[i] = distributionNotificationDetails.get(i).getEntity()
                    .getBuyerForcastDeliverDetailId();
        }
        BuyerForcastDeliverDetailList buyerForcastDeliverDetailList = BuyerForcastDeliverDetailList
                .build(distributionNotification.getBlackboard()).forComplete(buyerForcastDeliverDetailIds);
        buyerForcastDeliverDetailList.complete(false);
        List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails = buyerForcastDeliverDetailList.getArchives();
        if (buyerForcastDeliverDetails == null
                || buyerForcastDeliverDetails.size() != buyerForcastDeliverDetailIds.length) // 数据异常
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000002, "预配送明细与配送通知单明细不一一对应");

        // 预配送明细->分批订单明细
        List<Long> buyerBatchOrderDetailIds = new ArrayList<>();
        for (BuyerForcastDeliverDetail buyerForcastDeliverDetail : buyerForcastDeliverDetails) {
            Long buyerBatchOrderDetailId = buyerForcastDeliverDetail.getEntity().getBuyerBatchOrderDetailId();
            if (!buyerBatchOrderDetailIds.contains(buyerBatchOrderDetailId))
                buyerBatchOrderDetailIds.add(buyerBatchOrderDetailId);
        }
        BuyerBatchOrderDetailList buyerBatchOrderDetailList = BuyerBatchOrderDetailList
                .build(distributionNotification.getBlackboard())
                .forComplete(buyerBatchOrderDetailIds.toArray(new Long[0]));
        buyerBatchOrderDetailList.complete(false);
        List<BuyerBatchOrderDetail> buyerBatchOrderDetails = buyerBatchOrderDetailList.getArchives();
        if (buyerBatchOrderDetails == null) // 数据异常
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000002, "买家分批订单明细不存在");

        // 分批订单明细->分批订单
        List<Long> buyerBatchOrderIds = new ArrayList<>();
        for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerBatchOrderDetails) {
            Long buyerBatchOrderId = buyerBatchOrderDetail.getEntity().getBuyerBatchOrderId();
            if (!buyerBatchOrderIds.contains(buyerBatchOrderId))
                buyerBatchOrderIds.add(buyerBatchOrderId);
        }
        BuyerBatchOrderList buyerBatchOrderList = BuyerBatchOrderList.build(distributionNotification.getBlackboard())
                .forComplete(buyerBatchOrderIds.toArray(new Long[0]));
        buyerBatchOrderList.complete(false);
        List<BuyerBatchOrder> buyerBatchOrders = buyerBatchOrderList.getArchives();
        if (buyerBatchOrders == null) // 数据异常
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000002, "买家分批订单不存在");

        return buyerBatchOrders;
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
