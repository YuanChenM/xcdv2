package com.bms.order.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bms.order.bean.param.LINV0104IParam;
import com.bms.order.constant.enumeration.*;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.BuyerBatchOrder;
import com.bms.order.archive.impl.BuyerBatchOrderDetail;
import com.bms.order.archive.impl.BuyerForcastDeliverDetail;
import com.bms.order.archive.impl.BuyerOrder;
import com.bms.order.archive.impl.DistributionNotification;
import com.bms.order.archive.impl.DistributionNotificationDetail;
import com.bms.order.archive.impl.Operator;
import com.bms.order.archive.impl.list.BuyerForcastDeliverDetailList;
import com.bms.order.archive.impl.list.DistributionNotificationList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.param.ORDR0202IBeanParam;
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
import com.bms.order.dao.DistributionCancelNotificationDao;
import com.bms.order.dao.DistributionNotificationDao;
import com.bms.order.dao.DistributionNotificationDetailDao;
import com.bms.order.external.archive.Stock;
import com.bms.order.external.bean.param.StockRestParam;
import com.bms.order.services.ORDR0202IService;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;

/**
 * 订单分拆结果取消接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0202IServiceImpl implements ORDR0202IService {

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
    private BuyerBatchOrderDetailDao buyerbatchOrderDetailDao;

    @Autowired
    private BuyerBatchOrderDetailAttachedDao buyerBatchOrderDetailAttachedDao;

    @Autowired
    private BuyerForcastDeliverDetailDao buyerForcastDeliverDetailDao;

    @Autowired
    private BuyerForcastDeliverDetailAttachedDao buyerForcastDeliverDetailAttachedDao;

    @Autowired
    private DistributionNotificationDetailDao distributionNotificationDetailDao;

    @Autowired
    private DistributionNotificationDao distributionNotificationDao;

    @Autowired
    private DistributionCancelNotificationDao distributionCancelNotificationDao;

    /**
     * 平台订单人员取消订单分拆结果
     *
     * @param operator
     *            操作者
     * @param bean ORDR0202IRestParam
     *
     */
    @Transactional
    @Override
    public void execute(Operator operator, ORDR0202IBeanParam bean) {
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
        ORDR0202IBeanParam bean = (ORDR0202IBeanParam) map.get("bean");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(buyerOrderDao);
        blackboard.putBaseDao(buyerOrderAttachedDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailAttachedDao);
        blackboard.putBaseDao(buyerBatchOrderDao);
        blackboard.putBaseDao(buyerBatchOrderAttachedDao);
        blackboard.putBaseDao(buyerbatchOrderDetailDao);
        blackboard.putBaseDao(buyerBatchOrderDetailAttachedDao);
        blackboard.putBaseDao(distributionNotificationDao);
        blackboard.putBaseDao(distributionNotificationDetailDao);
        blackboard.putBaseDao(distributionCancelNotificationDao);

        // 操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);

        // 获取买家分批订单明细
        BuyerBatchOrderDetail buyerBatchOrderDetail = bean.generateBuyerBatchOrderDetail();
        buyerBatchOrderDetail.setBlackboard(blackboard);
        buyerBatchOrderDetail.complete(false);

        // 数据权限验证
        checkDataAuthority(operator);

        // 验证买家分批订单明细的有效性
        checkBuyerBatchOrderDetail(buyerBatchOrderDetail);

        // 验证买家订单的有效性
        checkBuyerOrder(buyerBatchOrderDetail);

        // 返回参数
        map.put("buyerBatchOrderDetail", buyerBatchOrderDetail);
    }

    /**
     * 数据权限验证
     * 
     * @param operator
     * @param operator
     */
    private void checkDataAuthority(Operator operator) {
        OperatorType operatorType = OperatorType.getInstance(operator.getOperatorType());
        switch (operatorType) {
        // 只有平台人员能够取消分批订单明细
        case MANAGER:
            break;
        default:
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020201, operatorType.getName());
        }
    }

    /**
     * 验证买家分批订单明细的有效性
     * 
     * @param buyerBatchOrderDetail
     */
    private void checkBuyerBatchOrderDetail(BuyerBatchOrderDetail buyerBatchOrderDetail) {
        // 分批订单明细必须存在
        if (!buyerBatchOrderDetail.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020202);
        }
        // 分批订单明细必须已经分拆
        if (!buyerBatchOrderDetail.getEntity().getSplitFlg()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020203);
        }
        // 获取预配送明细
        List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails = buyerBatchOrderDetail
                .getBuyerForcastDeliverDetails();
        if (buyerForcastDeliverDetails == null || buyerForcastDeliverDetails.size() == 0) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020204);
        }
    }

    /**
     * 验证买家订单的有效性
     * 
     * @param buyerBatchOrderDetail
     */
    private void checkBuyerOrder(BuyerBatchOrderDetail buyerBatchOrderDetail) {
        BuyerOrder buyerOrder = buyerBatchOrderDetail.getBuyerOrder();
        if (buyerOrder == null) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000002, "分批订单明细没有找到订单");
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
        BuyerBatchOrderDetail buyerBatchOrderDetail = (BuyerBatchOrderDetail) map.get("buyerBatchOrderDetail");

        // 获取预配送明细
        List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails = buyerBatchOrderDetail
                .getBuyerForcastDeliverDetails();

        // 根据预配送明细获取配送通知单
        List<DistributionNotification> distributionNotifications = findDistributionNotifications(
                buyerForcastDeliverDetails);

        if (distributionNotifications == null || distributionNotifications.size() == 0) {
            // 未生成配送通知单的情况
            // 删除分拆明细
            cancelBuyerForcastDeliverDetails(buyerBatchOrderDetail);
        } else {
            // 生成配送通知单的情况

            // 配送通知单状态为已取消
            if (isDistributionNotificationsCancelled(distributionNotifications)) {
                cancelBuyerForcastDeliverDetails(buyerBatchOrderDetail);
            }

            // 配送通知单状态为取消中
            else if (isDistributionNotificationsCancelling(distributionNotifications)) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020205);
            }

            else if (isDistributionNotificationsNotDistribute(distributionNotifications)) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020206);
            }

            // 配送通知单为其他状态
            else {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020207);
            }
        }
        cancelAllocateInv(buyerBatchOrderDetail,buyerForcastDeliverDetails);
    }

    /**
     * 根据预配送明细获取配送通知单
     * 
     * @param buyerForcastDeliverDetails
     * @return
     */
    private List<DistributionNotification> findDistributionNotifications(
            List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails) {
        // 获取blackboard
        Blackboard blackboard = buyerForcastDeliverDetails.get(0).getBlackboard();

        // 获取配送单Id
        List<Long> distributionNotificationIds = new ArrayList<>();
        for (BuyerForcastDeliverDetail buyerForcastDeliverDetail : buyerForcastDeliverDetails) {
            // 根据预配送明细获取配送明细
            DistributionNotificationDetail distributionNotificationDetail = buyerForcastDeliverDetail
                    .getDistributionNotificationDetail();
            // 获取配送明细ID
            Long distributionNotificationId = null;
            if (distributionNotificationDetail != null)
                distributionNotificationId = distributionNotificationDetail.getEntity().getDistributionNotificationId();
            // 如果配送明细不为空
            if (distributionNotificationId != null
                    && !distributionNotificationIds.contains(distributionNotificationId)) {
                distributionNotificationIds.add(distributionNotificationId);
            }
        }

        // 获取订单配送单
        List<DistributionNotification> distributionNotifications = null;
        if (distributionNotificationIds.size() != 0) {
            DistributionNotificationList distributionNotificationList = DistributionNotificationList.build(blackboard)
                    .forComplete(distributionNotificationIds.toArray(new Long[0]));
            distributionNotificationList.complete(false);
            distributionNotifications = distributionNotificationList.getArchives();
            if (distributionNotifications == null
                    || distributionNotifications.size() != distributionNotificationIds.size())
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E020208);
        }

        return distributionNotifications;
    }

    /**
     * 取消分拆明细
     * 
     * @param buyerBatchOrderDetail
     */
    private void cancelBuyerForcastDeliverDetails(BuyerBatchOrderDetail buyerBatchOrderDetail) {
        // 删除预配送明细
        deleteBuyerForcastDeliverDetails(buyerBatchOrderDetail.getBuyerForcastDeliverDetails());

        // 更新分批订单明细状态
        updateBuyerBatchOrderDetail(buyerBatchOrderDetail);

        // 更新分批订单状态
        updateBuyerBatchOrder(buyerBatchOrderDetail.getBuyerBatchOrder());

        // 取消库存占用
//        List<StockRestParam> params = new ArrayList<>();
//        for (BuyerForcastDeliverDetail deliverDetail : buyerBatchOrderDetail.getBuyerForcastDeliverDetails()) {
//            StockRestParam param = new StockRestParam();
//            param.setTransactionId(buyerBatchOrderDetail.getEntity().getBuyerOrderId());
//            param.setTransactionNo(buyerBatchOrderDetail.getBuyerOrder().getEntity().getBuyerOrderCode());
//            param.setTransactionDetailId(deliverDetail.getEntity().getBuyerForcastDeliverDetailId());
//            param.setTransactionSequence(null);// 预配送明细不需要传
//            param.setCancelQty(deliverDetail.getEntity().getPlanSendQuantity());
//            param.setAlocType(Stock.ALOC_TYPE_NORMAL);
//            params.add(param);
//        }
//        Stock.ReleaseAllocation(params);
    }

    /**
     * 删除预配送明细
     * 
     * @param buyerForcastDeliverDetails
     */
    private void deleteBuyerForcastDeliverDetails(List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails) {
        // 获取blackboard
        Blackboard blackboard = buyerForcastDeliverDetails.get(0).getBlackboard();

        BuyerForcastDeliverDetailList list = BuyerForcastDeliverDetailList.build(blackboard)
                .forUpdate(buyerForcastDeliverDetails.toArray(new BuyerForcastDeliverDetail[0]));
        list.delete();
    }

    /**
     * 更新分批订单明细
     * 
     * @param buyerBatchOrderDetail
     */
    private void updateBuyerBatchOrderDetail(BuyerBatchOrderDetail buyerBatchOrderDetail) {
        // 设置未分拆完成
        buyerBatchOrderDetail.getEntity().setSplitFlg(false);
        // 设置手动分拆
        buyerBatchOrderDetail.getEntity().setManualSplitFlg(true);
        buyerBatchOrderDetail.modify();
    }

    /**
     * 更新分批订单状态
     * 
     * @param buyerBatchOrder
     */
    private void updateBuyerBatchOrder(BuyerBatchOrder buyerBatchOrder) {
        // 设置待分拆
        buyerBatchOrder.buyerForcastDeliverDetailsUnlink();
        List<BuyerForcastDeliverDetail> detail = buyerBatchOrder.getBuyerForcastDeliverDetails();
        if(CollectionUtils.isNotEmpty(detail)) {
            buyerBatchOrder.getEntity().setBuyerBatchOrderStu(BuyerBatchOrderStu.PART_SPLIT.getCode());
        }else {
            buyerBatchOrder.getEntity().setBuyerBatchOrderStu(BuyerBatchOrderStu.TO_SPLIT.getCode());
        }
        buyerBatchOrder.modify();
    }

    /**
     * 判断配送通知单是否全部取消
     * 
     * @param distributionNotifications
     * @return
     */
    private boolean isDistributionNotificationsCancelled(List<DistributionNotification> distributionNotifications) {
        boolean allCancel = true;
        for (DistributionNotification distributionNotification : distributionNotifications) {
            DistributionNotificationStu stu = DistributionNotificationStu
                    .getInstance(distributionNotification.getEntity().getDistributionNotificationStu());
            if (stu != DistributionNotificationStu.CANCEL) {
                allCancel = false;
                break;
            }
        }
        return allCancel;
    }

    /**
     * 判断配送通知单是否为取消中（前提：不全都是已取消）
     * 
     * @param distributionNotifications
     * @return
     */
    private boolean isDistributionNotificationsCancelling(List<DistributionNotification> distributionNotifications) {
        boolean cancelling = true;
        for (DistributionNotification distributionNotification : distributionNotifications) {
            DistributionNotificationStu stu = DistributionNotificationStu
                    .getInstance(distributionNotification.getEntity().getDistributionNotificationStu());
            if (stu != DistributionNotificationStu.CANCEL && stu != DistributionNotificationStu.IN_CANCEL) {
                cancelling = false;
                break;
            }
        }
        return cancelling;
    }

    /**
     * 判断配送通知单是否全部为待发货（前提：不是已取消，不在取消中）
     * 
     * @param distributionNotifications
     * @return
     */
    private boolean isDistributionNotificationsNotDistribute(List<DistributionNotification> distributionNotifications) {
        boolean notDistribute = true;
        for (DistributionNotification distributionNotification : distributionNotifications) {
            DistributionNotificationStu stu = DistributionNotificationStu
                    .getInstance(distributionNotification.getEntity().getDistributionNotificationStu());
            if (stu != DistributionNotificationStu.CANCEL && stu != DistributionNotificationStu.IN_CANCEL
                    && stu != DistributionNotificationStu.TO_DISTRIBUTION) {
                notDistribute = false;
                break;
            }
        }
        return notDistribute;
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

    /**
     * 取消占用
     *
     * @param buyerForcastDeliverDetails
     */
    public void cancelAllocateInv(BuyerBatchOrderDetail buyerBatchOrderDetail, List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails) {
        Long orderId = buyerBatchOrderDetail.getBuyerOrder().getEntity().getBuyerOrderId();
        String orderCode = buyerBatchOrderDetail.getBuyerOrder().getEntity().getBuyerOrderCode();
        ArrayList<LINV0104IParam> paramList = new ArrayList<>();
        for (BuyerForcastDeliverDetail detail : buyerForcastDeliverDetails) {
            LINV0104IParam param = new LINV0104IParam();
            if (detail.getEntity().getSellSideType().equals(SellSideType.PLATFORM_TYPE.getCode())){
                param.setBizType(BizType.SellerSale.getCode());
            } else {
                param.setBizType(BizType.AgentSale.getCode());
            }
            param.setTransactionId(orderId);
            param.setTransactionNo(orderCode);
            param.setTransactionDetailId(detail.getEntity().getBuyerForcastDeliverDetailId());
            param.setTransactionSequence(NumberConst.IntDef.INT_ONE);
            param.setTransactionSource("ORDR");
            param.setCancelQty(detail.getEntity().getPlanSendQuantity());
            paramList.add(param);
        }
        Stock.CancelLinvAllocate(paramList);
    }
}
