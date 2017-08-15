package com.bms.order.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bms.order.bean.entity.BsOrderAttachedEntity;
import com.bms.order.bean.entity.BsOrderEntity;
import com.framework.core.utils.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.BsOrder;
import com.bms.order.archive.impl.BsOrderDetail;
import com.bms.order.archive.impl.BsStockpileSplitDetail;
import com.bms.order.archive.impl.Cancel;
import com.bms.order.archive.impl.Operator;
import com.bms.order.archive.impl.list.BsOrderDetailList;
import com.bms.order.archive.impl.list.BsStockpileSplitDetailList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.param.ORDR0603IBeanParam;
import com.bms.order.constant.enumeration.BsOrderStu;
import com.bms.order.constant.enumeration.BsOrderType;
import com.bms.order.constant.enumeration.OperatorType;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BsOrderAttachedDao;
import com.bms.order.dao.BsOrderDao;
import com.bms.order.dao.BsOrderDetailAttachedDao;
import com.bms.order.dao.BsOrderDetailDao;
import com.bms.order.dao.BsStockpileSplitDetailAttachedDao;
import com.bms.order.dao.BsStockpileSplitDetailDao;
import com.bms.order.dao.CancelDao;
import com.bms.order.external.archive.Stock;
import com.bms.order.external.bean.param.StockRestParam;
import com.bms.order.services.ORDR0603IService;
import com.framework.core.utils.DecimalUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;

/**
 * 买手订单取消接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0603IServiceImpl implements ORDR0603IService {

    @Autowired
    private BaseRedisDao redisDao;

    @Autowired
    private CancelDao cancelDao;

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

    /**
     * 囤货完成前，买手订单整单取消
     *
     * @param operator 操作者
     * @param param    ORDR0603IBeanParam
     */
    @Transactional
    @Override
    public void execute(Operator operator, ORDR0603IBeanParam param) {
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
        ORDR0603IBeanParam param = (ORDR0603IBeanParam) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(cancelDao);
        blackboard.putBaseDao(bsOrderDao);
        blackboard.putBaseDao(bsOrderAttachedDao);
        blackboard.putBaseDao(bsOrderDetailDao);
        blackboard.putBaseDao(bsOrderDetailAttachedDao);
        blackboard.putBaseDao(bsStockpileSplitDetailDao);
        blackboard.putBaseDao(bsStockpileSplitDetailAttachedDao);

        //操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);

        // 获取买手订单
        if (null != param.getBsOrderId()) {
        BsOrder bsOrder = param.generateBsOrder();
        bsOrder.setBlackboard(blackboard);
        bsOrder.complete(false);
            // 验证买手订单（买手订单在没有验证的条件下，数据权限验证会出现空指针错误）
            checkBsOrder(bsOrder, param.getVer());
            // 验证数据权限
            checkDataAuthority(bsOrder, operator);
            // 验证订单是否已完成
            checkStatus(bsOrder);
            Cancel cancel = param.generateCancel();
            cancel.setBlackboard(blackboard);
            map.put("bsOrder", bsOrder);
            map.put("cancel", cancel);
            map.put("operator", operator);
        } else if (!StringUtils.isEmpty(param.getBackNo()) && null == param.getBsOrderId()) {
            BsOrderEntity entity = new BsOrderEntity();
            entity.setBackNo(param.getBackNo());
            BsOrderAttachedEntity attachedEntity = new BsOrderAttachedEntity();
            BsOrder bsOrder = BsOrder.build(blackboard).forCreate(entity,attachedEntity);

            bsOrder.setBlackboard(blackboard);
            bsOrder.complete(false);
        // 验证买手订单（买手订单在没有验证的条件下，数据权限验证会出现空指针错误）
        checkBsOrder(bsOrder, param.getVer());
        // 验证数据权限
        checkDataAuthority(bsOrder, operator);
        // 验证订单是否已完成
        checkStatus(bsOrder);
        Cancel cancel = param.generateCancel();
        cancel.setBlackboard(blackboard);
        map.put("bsOrder",bsOrder);
        map.put("cancel",cancel);
        map.put("operator",operator);
        }else {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000002, "订单id，订单：参考号不能同时为空");
        }

    }

    /**
     * 买手订单验证
     * 
     * @param bsOrder
     * @param ver
     */
    private void checkBsOrder(BsOrder bsOrder, Integer ver) {
        // 验证买手订单是否存在
        if (!bsOrder.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060301,
                    String.valueOf(bsOrder.getEntity().getBsOrderId()));
        }
        // 验证版本号
        if (!bsOrder.getEntity().getVersion().equals(ver)) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060302,
                    String.valueOf(bsOrder.getEntity().getBsOrderId()));
        }
    }

    /**
     * 验证操作人权限
     * 
     * @param bsOrder
     * @param operator
     */
    private void checkDataAuthority(BsOrder bsOrder, Operator operator) {
        if (operator.isBuyer()) {
            // 无权限
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000001, OperatorType.BUYER.getName());
        } else if (operator.isBs()) {
            // 买手仅能操作自己名下的买手订单
            if (!operator.getOperatorId().equals(String.valueOf(bsOrder.getEntity().getBsOrderId()))) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060303,
                        String.valueOf(bsOrder.getEntity().getBsOrderId()));
            }
        } else if (operator.isSa()) {
            // 无权限
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000001, OperatorType.BUYER.getName());
        } else if (operator.isOrderSystem()) {}
    }

    /**
     * 买手订单状态验证
     * 
     * @param bsOrder
     */
    private void checkStatus(BsOrder bsOrder) {
        BsOrderStu bsOrderStu = BsOrderStu.getInstance(bsOrder.getEntity().getBsOrderStu());
        // 判断买手订单是否取消
        if (bsOrderStu == BsOrderStu.CANCEL) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060304,
                    String.valueOf(bsOrder.getEntity().getBsOrderId()));
        }

        // 判断买手订单的状态是否在已完成之前
        if (bsOrderStu == BsOrderStu.COMPLETE_STOCKPILE || bsOrderStu == BsOrderStu.STOCKPILE_FAILURE) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060305,
                    String.valueOf(bsOrder.getEntity().getBsOrderId()));
        }
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        BsOrder bsOrder = (BsOrder) map.get("bsOrder");
        Cancel cancel = (Cancel) map.get("cancel");

        // 保存取消信息
        cancel.create();

        // 创建库存取消接口参数
        List<StockRestParam> params = stockRestParams(bsOrder);

        // 设置取消数量与库存变更Sequence
        modifyBsOrderDetail(bsOrder);

        // 设置买手订单状态为取消
        modifyBsOrder(bsOrder);

        // 删除买手囤货分拆明细
        dropStockSplitDetail(bsOrder);

        BsOrderType bsOrderType = BsOrderType.getInstance(bsOrder.getEntity().getOrderType());
        if (bsOrderType == BsOrderType.BS_A_STOCKPILING_ORDER) { // 囤实物订单
            // 取消库存占用
            releaseStock(params);
        }

        // TODO: 2017/1/11 调用资金池接口
    }

    /**
     * 库存取消参数创建
     * 
     * @param bsOrder
     * @return
     */
    private List<StockRestParam> stockRestParams(BsOrder bsOrder) {
        List<StockRestParam> params = new ArrayList<>();
        BsOrderStu bsOrderStu = BsOrderStu.getInstance(bsOrder.getEntity().getBsOrderStu());
        if (bsOrderStu != BsOrderStu.IN_CONFIRMATION) { // 如果在确认中，则没有占用货主库存，不需要释放
            for (BsOrderDetail bsOrderDetail : bsOrder.getBsOrderDetails()) {
                StockRestParam param = new StockRestParam();
                params.add(param);
                param.setTransactionId(bsOrder.getEntity().getBsOrderId());
                param.setTransactionNo(bsOrder.getEntity().getBsOrderCode());
                param.setTransactionDetailId(bsOrderDetail.getEntity().getBsOrderDetailId());
                param.setTransactionSequence(bsOrderDetail.getEntity().getTransactionSequence() + 1);
                param.setCancelQty(DecimalUtils.subtract(bsOrderDetail.getEntity().getGoodsQuantity(),
                        bsOrderDetail.getEntity().getCancelQuantity()));
                param.setAlocType(Stock.ALOC_TYPE_OWNER);
            }
        }
        return params;
    }

    /**
     * 释放库存
     * 
     * @param bsOrder
     */
    private void releaseStock(List<StockRestParam> params) {
        if (!params.isEmpty())
            Stock.ReleaseAllocation(params);
    }

    /**
     * 更新买手订单明细取消数量为下单时商品数量，更新库存变更Sequence
     * 
     * @param bsOrder
     */
    private void modifyBsOrderDetail(BsOrder bsOrder) {
            List<BsOrderDetail> bsOrderDetails = bsOrder.getBsOrderDetails();
            for (BsOrderDetail bsOrderDetail : bsOrderDetails) {
                bsOrderDetail.getEntity().setCancelQuantity(bsOrderDetail.getEntity().getGoodsQuantity());
            bsOrderDetail.getEntity().setTransactionSequence(bsOrderDetail.getEntity().getTransactionSequence() + 1);
            }
            // 批量更新
            BsOrderDetailList bsOrderDetailList = BsOrderDetailList.build(bsOrder.getBlackboard())
                    .forUpdate(bsOrderDetails.toArray(new BsOrderDetail[0]));
            bsOrderDetailList.modify();
    }

    // 更新买手订单状态为取消
    private void modifyBsOrder(BsOrder bsOrder) {
        bsOrder.getEntity().setBsOrderStu(BsOrderStu.CANCEL.getCode());
        bsOrder.modify();
    }

    // 删除买手囤货分拆单明细
    private void dropStockSplitDetail(BsOrder bsOrder) {
        List<BsOrderDetail> details = bsOrder.getBsOrderDetails();
        List<BsStockpileSplitDetail> splitDetails = new ArrayList<>();

        for (BsOrderDetail detail : details) {
            if (CollectionUtils.isNotEmpty(detail.getBsStockpileSplitDetails())) {
                List<BsStockpileSplitDetail> newSplitDetails = new ArrayList<>();
                newSplitDetails = detail.getBsStockpileSplitDetails();
                splitDetails.addAll(newSplitDetails);
            }
        }
        // 批量更新，删除买手分拆明细
        if (splitDetails.size() > 0) {
            BsStockpileSplitDetailList bsStockpileSplitDetailList = BsStockpileSplitDetailList
                    .build(bsOrder.getBlackboard()).forUpdate(splitDetails.toArray(new BsStockpileSplitDetail[0]));
            bsStockpileSplitDetailList.delete();
        }
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
