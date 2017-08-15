package com.bms.order.services.impl;

import com.bms.order.archive.impl.*;
import com.bms.order.archive.impl.list.BuyerBatchOrderDetailList;
import com.bms.order.archive.impl.list.BuyerBatchOrderList;
import com.bms.order.archive.impl.list.BuyerForcastDeliverDetailList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.BuyerOrderAttachedEntity;
import com.bms.order.bean.entity.BuyerOrderEntity;
import com.bms.order.bean.entity.CancelEntity;
import com.bms.order.bean.param.LINV0104IParam;
import com.bms.order.bean.param.ORDR0103IBeanParam;
import com.bms.order.constant.enumeration.*;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.*;
import com.bms.order.external.archive.Stock;
import com.bms.order.external.bean.param.StockRestParam;
import com.bms.order.services.ORDR0103IService;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DecimalUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 买家订单取消接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0103IServiceImpl implements ORDR0103IService {

    private static final Logger logger = LoggerFactory.getLogger(ORDR0103IServiceImpl.class);

    @Autowired
    private BaseRedisDao redisDao;

    @Autowired
    private BuyerOrderDao buyerOrderDao;

    @Autowired
    private BuyerOrderAttachedDao buyerOrderAttachedDao;

    @Autowired
    private DistributionNotificationDao distributionNotificationDao;

    @Autowired
    private CancelDao cancelDao;

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
    private BuyerSellerDetailDao buyerSellerDetailDao;
    /**
     * 收货之前都允许买家订单整单取消，但可能会取消失败，需要后续拒收或者退货
     *
     * @param operator
     *            操作者
     * @param param
     *            ORDR0103IBeanParam
     */
    @Override
    public void execute(Operator operator, ORDR0103IBeanParam param) {
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
     * @param map
     *            HashMap
     */
    private void pre(HashMap<String, Object> map) {
        // 获取参数
        ORDR0103IBeanParam param = (ORDR0103IBeanParam) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(buyerOrderDao);
        blackboard.putBaseDao(buyerOrderAttachedDao);
        blackboard.putBaseDao(distributionNotificationDao);
        blackboard.putBaseDao(cancelDao);
        blackboard.putBaseDao(buyerBatchOrderDao);
        blackboard.putBaseDao(buyerBatchOrderAttachedDao);
        blackboard.putBaseDao(buyerBatchOrderDetailDao);
        blackboard.putBaseDao(buyerBatchOrderDetailAttachedDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailAttachedDao);
        blackboard.putBaseDao(buyerSellerDetailDao);
        // 操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);
        // 获取买家订单
        if (null != param.getBuyerOrderId()) {
        BuyerOrder buyerOrder = param.generateBuyerOrder();
        // 获取买家订单
        buyerOrder.setBlackboard(blackboard);
        buyerOrder.complete(false);
        // 验证买家订单 （买家订单没有验证的情况下，数据权限验证会出现空指针错误）
        checkBuyerOrder(buyerOrder, param.getVer());
        // 验证数据权限
        checkAuthority(operator, buyerOrder);
        // 验证订单是否收货
        checkReceive(buyerOrder);
        // 验证配送通知单是否生成
        checkDistributionNotification(buyerOrder);
        // 要创建的取消表数据
        Cancel cancel = param.generateCancel();
        cancel.setBlackboard(blackboard);
        map.put("buyerOrder", buyerOrder);
        map.put("cancel", cancel);
        map.put("operator", operator);
        } else if (!StringUtils.isEmpty(param.getBackNo()) && null == param.getBuyerOrderId()) {
            // 获取买家订单
            BuyerOrderEntity buyerOrderEntity = new BuyerOrderEntity();
            BuyerOrderAttachedEntity attachedEntity = new BuyerOrderAttachedEntity();
            buyerOrderEntity.setBackNo(param.getBackNo());
            BuyerOrder buyerOrder = new BuyerOrder(buyerOrderEntity,attachedEntity);
            buyerOrder.setBlackboard(blackboard);
            buyerOrder.complete(false);
            // 验证买家订单 （买家订单没有验证的情况下，数据权限验证会出现空指针错误）
            checkBuyerOrder(buyerOrder, param.getVer());
            // 验证数据权限
            checkAuthority(operator, buyerOrder);
            // 验证订单是否收货
            checkReceive(buyerOrder);
            // 验证配送通知单是否生成
            checkDistributionNotification(buyerOrder);
            // 要创建的取消表数据
            Cancel cancel = param.generateCancel();
            cancel.setBlackboard(blackboard);
            map.put("buyerOrder", buyerOrder);
            map.put("cancel", cancel);
            map.put("operator", operator);
        }else{
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000002, "订单id，订单：参考号不能同时为空");
        }
    }

    private void checkAuthority(Operator operator, BuyerOrder buyerOrder) {
        if (operator.isBuyer()) {
            // 买家仅能操作自己的订单
            if (!buyerOrder.getEntity().getBuyerId().equals(operator.getOperatorId())) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000001, OperatorType.BUYER.getName());
            }
        } else if (operator.isBs()) {
            // 无权限
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000001, OperatorType.BS.getName());
        } else if (operator.isSa()) {
            // 自己管理的买家的订单
            if (!operator.getOperatorId().equals(buyerOrder.getAttachedEntity().getSaId())) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000001, OperatorType.SA.getName());
            }
        } else if (operator.isOrderSystem()) {

        }
    }

    /**
     * 验证买家订单
     * 
     * @param buyerOrder
     */
    private void checkBuyerOrder(BuyerOrder buyerOrder, Integer ver) {
        // 验证买家订单是否存在
        if (!buyerOrder.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010301,
                    String.valueOf(buyerOrder.getEntity().getBuyerOrderId()));
        }
        // 验证版本号
        if (!buyerOrder.getEntity().getVersion().equals(ver)) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010302,
                    String.valueOf(buyerOrder.getEntity().getBuyerOrderId()));
        }
    }

    /**
     * 验证订单是否收货
     * 
     * @param buyerOrder
     */
    private void checkReceive(BuyerOrder buyerOrder) {
        // 判断该订单下是否有分批订单已经发生收货
        for (BuyerBatchOrder buyerBatchOrder : buyerOrder.getBuyerBatchOrders()) {
            if (BuyerBatchOrderStu.PARTIAL_RECEIPT.getCode().equals(buyerBatchOrder.getEntity().getBuyerBatchOrderStu())
                    || BuyerBatchOrderStu.ALL_LATE_RECEIPT.getCode()
                            .equals(buyerBatchOrder.getEntity().getBuyerBatchOrderStu())
                    || BuyerBatchOrderStu.RECEIPT_FINISH.getCode()
                            .equals(buyerBatchOrder.getEntity().getBuyerBatchOrderStu())
                    || BuyerBatchOrderStu.ALL_RETURN.getCode()
                            .equals(buyerBatchOrder.getEntity().getBuyerBatchOrderStu())
                    || BuyerBatchOrderStu.CANCEL.getCode()
                            .equals(buyerBatchOrder.getEntity().getBuyerBatchOrderStu())) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010304,
                        String.valueOf(buyerOrder.getEntity().getBuyerOrderId()));
            }
        }
    }

    /**
     * 验证配送通知单是否生成
     * 
     * @param buyerOrder
     */
    private void checkDistributionNotification(BuyerOrder buyerOrder) {
        if (buyerOrder.isOnDistribute())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010305,
                    String.valueOf(buyerOrder.getEntity().getBuyerOrderId()));
    }

    /**
     * 执行
     *
     * @param map
     *            HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        BuyerOrder buyerOrder = (BuyerOrder) map.get("buyerOrder");
        Cancel cancel = (Cancel) map.get("cancel");

        // 插入取消表
        saveCancel(cancel);
        // 调用库存占用释放接口
        cancelAllocateInv(buyerOrder);
        // 创建库存取消接口参数
//        List<StockRestParam> params = stockRestParams(buyerOrder);
        // 删除预配送明细
        deleteBuyerForcastDeliverDetail(buyerOrder);
        // 修改分批订单明细取消数量与库存Sequence
        modifyBatchOrderDetail(buyerOrder);
        // 修改分批订单状态为取消
        modifyBatchOrder(buyerOrder);
        // 修改买家订单状态为取消
        modifyBuyerOrder(buyerOrder);
        // 释放库存调用库存接口
//        releaseStock(params);

    }

    // 插入取消数据
    private void saveCancel(Cancel cancel) {
        CancelEntity entity = cancel.getEntity();
        Cancel cancelData = Cancel.build(cancel.getBlackboard()).forCreate(entity);
        cancelData.create();
    }

    /**
     * 库存取消参数创建
     * 
     * @param buyerOrder
     * @return
     */
    private List<StockRestParam> stockRestParams(BuyerOrder buyerOrder) {
        List<StockRestParam> params = new ArrayList<>();
        List<BuyerBatchOrderDetail> buyerBatchOrderDetails = buyerOrder.getBuyerBatchOrderDetails();
        List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails = new ArrayList<>();
        for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerBatchOrderDetails) {
            if (buyerBatchOrderDetail.getBuyerForcastDeliverDetails() != null)
                buyerForcastDeliverDetails.addAll(buyerBatchOrderDetail.getBuyerForcastDeliverDetails());
        }

        // 组装预配送明细数据
        for (BuyerForcastDeliverDetail buyerForcastDeliverDetail : buyerForcastDeliverDetails) {
            StockRestParam param = new StockRestParam();
            params.add(param);
            param.setTransactionId(buyerOrder.getEntity().getBuyerOrderId());
            param.setTransactionNo(buyerOrder.getEntity().getBuyerOrderCode());
            param.setTransactionDetailId(buyerForcastDeliverDetail.getEntity().getBuyerForcastDeliverDetailId());
            param.setTransactionSequence(null);
            param.setCancelQty(buyerForcastDeliverDetail.getEntity().getPlanSendQuantity());
            param.setAlocType(Stock.ALOC_TYPE_NORMAL);
        }

        // 组装订单分批明细数据
        BuyerOrderStu buyerOrderStu = BuyerOrderStu.getInstance(buyerOrder.getEntity().getBuyerOrderStu());
        if (buyerOrderStu != BuyerOrderStu.IN_CONFIRMATION) { // 如果在确认中，则没有占用平台库存，不需要释放
            for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerBatchOrderDetails) {
                StockRestParam param = new StockRestParam();
                params.add(param);
                param.setTransactionId(buyerOrder.getEntity().getBuyerOrderId());
                param.setTransactionNo(buyerOrder.getEntity().getBuyerOrderCode());
                param.setTransactionDetailId(buyerBatchOrderDetail.getEntity().getBuyerBatchOrderDetailId());
                param.setTransactionSequence(buyerBatchOrderDetail.getEntity().getTransactionSequence() + 1);
                param.setCancelQty(DecimalUtils.subtract(buyerBatchOrderDetail.getEntity().getGoodsQuantity(),
                        buyerBatchOrderDetail.getEntity().getCancelQuantity()));
                param.setAlocType(Stock.ALOC_TYPE_PLATFORM);
            }
        }
        return params;
    }

    /**
     * 删除预配送明细
     * 
     * @param buyerOrder
     */
    private void deleteBuyerForcastDeliverDetail(BuyerOrder buyerOrder) {
        List<BuyerBatchOrderDetail> buyerBatchOrderDetails = buyerOrder.getBuyerBatchOrderDetails();
        List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails = new ArrayList<>();
        for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerBatchOrderDetails) {
            if (buyerBatchOrderDetail.getBuyerForcastDeliverDetails() != null)
                buyerForcastDeliverDetails.addAll(buyerBatchOrderDetail.getBuyerForcastDeliverDetails());
        }

        if (!buyerForcastDeliverDetails.isEmpty()) {
            Blackboard blackboard = buyerOrder.getBlackboard();
            BuyerForcastDeliverDetailList list = BuyerForcastDeliverDetailList.build(blackboard)
                    .forUpdate(buyerForcastDeliverDetails.toArray(new BuyerForcastDeliverDetail[0]));
            list.delete();
        }
    }

    // 更新分批订单明细取消数量与库存Sequence
    private void modifyBatchOrderDetail(BuyerOrder buyerOrder) {
        List<BuyerBatchOrderDetail> details = buyerOrder.getBuyerBatchOrderDetails();
        if (CollectionUtils.isNotEmpty(details)) {
            for (BuyerBatchOrderDetail detail : details) {
                detail.getEntity().setCancelQuantity(detail.getEntity().getGoodsQuantity());
                detail.getEntity().setTransactionSequence(detail.getEntity().getTransactionSequence() + 1);
            }
            // 批量更新
            BuyerBatchOrderDetailList buyerBatchOrderDetailList = BuyerBatchOrderDetailList
                    .build(buyerOrder.getBlackboard()).forUpdate(details.toArray(new BuyerBatchOrderDetail[0]));
            buyerBatchOrderDetailList.modify();
        }

    }

    // 更新分批订单状态为已取消
    private void modifyBatchOrder(BuyerOrder buyerOrder) {
        List<BuyerBatchOrder> batchOrders = buyerOrder.getBuyerBatchOrders();
        if (CollectionUtils.isNotEmpty(batchOrders)) {
            for (BuyerBatchOrder batchOrder : batchOrders) {
                batchOrder.getEntity().setBuyerBatchOrderStu(BuyerBatchOrderStu.CANCEL.getCode());
            }
            // 批量更新
            BuyerBatchOrderList buyerBatchOrderList = BuyerBatchOrderList.build(buyerOrder.getBlackboard())
                    .forUpdate(batchOrders.toArray(new BuyerBatchOrder[0]));
            buyerBatchOrderList.modify();
        }
    }

    // 更新订单状态为已取消
    private void modifyBuyerOrder(BuyerOrder buyerOrder) {
        buyerOrder.getEntity().setBuyerOrderStu(BuyerOrderStu.CANCEL.getCode());
        buyerOrder.modify();
    }

    // 释放库存调用库存接口
    private void releaseStock(List<StockRestParam> params) {
        if (!params.isEmpty())
            Stock.ReleaseAllocation(params);
    }

    /**
     * 买家订单取消人
     * 
     * @param operator
     * @return
     */
    public void checkBuyerCanceler(Operator operator) {
        Assert.notNull(operator);
        if (operator.isBuyer()) {
        } else if (operator.isSa()) {
        } else if (operator.isStaff()) {
        } else {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010306);
        }
    }

    /**
     * 取消占用
     *
     * @param buyerOrder
     */
    public void cancelAllocateInv(BuyerOrder buyerOrder) {
        String stu = buyerOrder.getEntity().getBuyerOrderStu();
        Boolean flg = false;
        for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerOrder.getBuyerBatchOrderDetails()){
           if (CollectionUtils.isNotEmpty(buyerBatchOrderDetail.getBuyerForcastDeliverDetails())){
               flg=true;
               break;
           }
        }
        if (flg){
            logger.debug("调用两层取消占用");
            logger.debug("调用取消商品占用 开始");
            cancelComoAllocate(buyerOrder);
            logger.debug("调用取消商品占用 结束");
            logger.debug("调用取消产品占用 开始");
            cancelLinvAllocate(buyerOrder);
            logger.debug("调用取消产品占用 结束");
        } else if (!BuyerOrderStu.IN_CONFIRMATION.getCode().equals(stu)){
            logger.debug("调用一层取消占用");
            logger.debug("调用取消商品占用 开始");
            cancelComoAllocate(buyerOrder);
            logger.debug("调用取消商品占用 结束");
        }
    }

    /**
     * 取消产品占用
     *
     * @param buyerOrder
     */
    public void cancelLinvAllocate(BuyerOrder buyerOrder) {
        ArrayList<LINV0104IParam> paramList = new ArrayList<>();
        for (BuyerBatchOrderDetail batchOrderDetail : buyerOrder.getBuyerBatchOrderDetails()){
            for (BuyerForcastDeliverDetail forcastDeliverDetail : batchOrderDetail.getBuyerForcastDeliverDetails()){
                LINV0104IParam param = new LINV0104IParam();
                if (forcastDeliverDetail.getEntity().getSellSideType().equals(SellSideType.PLATFORM_TYPE.getCode())){
                    param.setBizType(BizType.SellerSale.getCode());
                } else {
                    param.setBizType(BizType.AgentSale.getCode());
                }
                param.setTransactionId(buyerOrder.getEntity().getBuyerOrderId());
                param.setTransactionNo(buyerOrder.getEntity().getBuyerOrderCode());
                param.setTransactionDetailId(forcastDeliverDetail.getEntity().getBuyerForcastDeliverDetailId());
                param.setTransactionSequence(NumberConst.IntDef.INT_ONE);
                param.setTransactionSource("ORDR");
                param.setCancelQty(DecimalUtils.subtract(forcastDeliverDetail.getEntity().getPlanSendQuantity(),forcastDeliverDetail.getEntity().getCancelQuantity()));
                paramList.add(param);
            }
        }
        Stock.CancelLinvAllocate(paramList);
    }

    /**
     * 取消商品占用
     *
     * @param buyerOrder
     */
    public void cancelComoAllocate(BuyerOrder buyerOrder) {
        ArrayList<LINV0104IParam> paramList = new ArrayList<>();
        for (BuyerBatchOrderDetail batchOrderDetail : buyerOrder.getBuyerBatchOrderDetails()){
            String sellSideType = batchOrderDetail.getBuyerSellerDetails().get(0).getEntity().getSellSideType();
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
                param.setCancelQty(DecimalUtils.subtract(batchOrderDetail.getEntity().getGoodsQuantity(),batchOrderDetail.getEntity().getCancelQuantity()));
                paramList.add(param);
        }
        Stock.CancelComoAllocate(paramList);
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
