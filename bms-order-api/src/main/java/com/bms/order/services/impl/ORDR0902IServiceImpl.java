package com.bms.order.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bms.order.bean.entity.*;
import com.bms.order.bean.param.ORDR0904IFilter;
import com.bms.order.bean.result.ORDR0904IRestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.SearchRestResult;
import com.bms.order.constant.enumeration.*;
import com.bms.order.external.bean.param.LinvRestParam;
import com.bms.order.fms.common.FmsCommon;
import com.bms.order.services.ORDR0904IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.order.archive.impl.BsOrder;
import com.bms.order.archive.impl.BsOrderDetail;
import com.bms.order.archive.impl.BsReturn;
import com.bms.order.archive.impl.BsReturnDetail;
import com.bms.order.archive.impl.BsStockpileSplitDetail;
import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.param.ORDR0902IBean;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BsOrderAttachedDao;
import com.bms.order.dao.BsOrderDao;
import com.bms.order.dao.BsOrderDetailAttachedDao;
import com.bms.order.dao.BsOrderDetailDao;
import com.bms.order.dao.BsReturnDao;
import com.bms.order.dao.BsReturnDetailDao;
import com.bms.order.dao.BsStockpileSplitDetailAttachedDao;
import com.bms.order.dao.BsStockpileSplitDetailDao;
import com.bms.order.external.archive.Stock;
import com.bms.order.external.bean.param.StockRestParam;
import com.bms.order.services.ORDR0902IService;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.DecimalUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;

/**
 * 买手退货单确认接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0902IServiceImpl implements ORDR0902IService {

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
    private BsReturnDao bsReturnDao;
    @Autowired
    private BsReturnDetailDao bsReturnDetailDao;
    @Autowired
    private ORDR0904IService ordr0904IService;

    @Autowired
    private FmsCommon fmsCommon;

    public static final Logger logger = LoggerFactory.getLogger(ORDR0902IServiceImpl.class);


    /**
     * 接收买手退回确认信息，更改退货状态
     *
     * @param operator 操作者
     * @param bean     ORDR0902IBean
     */
    @Override
    public void execute(Operator operator, ORDR0902IBean bean) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        ;
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
     * @param map HashMap
     */
    private void pre(HashMap<String, Object> map) {
        // 获取参数
        ORDR0902IBean param = (ORDR0902IBean) map.get("bean");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(bsOrderDao);
        blackboard.putBaseDao(bsOrderAttachedDao);
        blackboard.putBaseDao(bsOrderDetailDao);
        blackboard.putBaseDao(bsOrderDetailAttachedDao);
        blackboard.putBaseDao(bsStockpileSplitDetailDao);
        blackboard.putBaseDao(bsStockpileSplitDetailAttachedDao);
        blackboard.putBaseDao(bsReturnDao);
        blackboard.putBaseDao(bsReturnDetailDao);
        //操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);
        BsReturn bsReturn = this.checkBsReturnStu(param, blackboard);
        // 返回参数
        map.put("bsReturn", bsReturn);
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        BsReturn bsReturn = (BsReturn) map.get("bsReturn");
        ORDR0902IBean param = (ORDR0902IBean) map.get("bean");
        // 执行操作
        BsReturnEntity bsReturnEntity = bsReturn.getEntity();
        bsReturnEntity.setBsReturnStu(BsReturnStu.COMPLETE.getCode());//根据接口传递的接口信息更新退货单主表信息，状态为“已完成”
        bsReturnEntity.setConfirmUid(param.getConfirmUid());
        bsReturnEntity.setConfirmUname(param.getConfirmUname());
        bsReturnEntity.setConfirmRemark(param.getConfirmRemark());
        bsReturnEntity.setConfirmTime(DateUtils.parseDateTime(param.getConfirmTime()));
        bsReturn.modify();
        BsOrder bsOrder = this.releaseStock(bsReturn);
        bsOrder = this.getBsOrder(bsOrder);
        if (bsOrder != null) {
            bsOrder.modify();// 修改买手退货状态
        }
    }

    /**
     * 收尾
     *
     * @param map HashMap
     */
    private void post(HashMap<String, Object> map) {
        BsReturn bsReturn = (BsReturn) map.get("bsReturn");
        Long bsOrderId = bsReturn.getEntity().getOrderId();
        // 推送买手退货完成订单
        try {
            fmsCommon.pushAgentReturnOrder(bsOrderId);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

    /**
     * 需要是待确认状态的退货单才能被确认
     *
     * @param bean
     * @param blackboard
     */
    private BsReturn checkBsReturnStu(ORDR0902IBean bean, Blackboard blackboard) {
        BsReturn bsReturn = new BsReturn(bean.getReturnId());
        bsReturn.setBlackboard(blackboard);
        bsReturn.complete(false);
        if (!bsReturn.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E090201);
        }
        BsReturnEntity bsReturnEntity = bsReturn.getEntity();
        if (!bsReturnEntity.getVersion().equals(bean.getVer())) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E090202);
        }
        String stu = bsReturnEntity.getBsReturnStu();
        if (!(stu != null && stu.equals(BsReturnStu.TO_CONFIRM.getCode()))) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E090203);
        }
        return bsReturn;
    }


    /**
     * 需要调用库存接口，处理买手囤货库存数据的处理，根据囤货订单类型不同，区分库存类型，实物囤货库存、货权囤货库存
     *
     * @param bsReturn
     */
    public BsOrder releaseStock(BsReturn bsReturn) {
        BsReturnEntity bsReturnEntity = bsReturn.getEntity();
        Long bsOrderId = bsReturnEntity.getOrderId();
        BsOrder bsOrder = new BsOrder(bsOrderId);
        bsOrder.setBlackboard(bsReturn.getBlackboard());
        bsOrder.complete(false);
        if (!bsOrder.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E090204);
        }
        BsOrderEntity bsOrderEntity = bsOrder.getEntity();
        String bsOrderType = bsOrderEntity.getOrderType();
        BsOrderAttachedEntity bsOrderAttachedEntity =  bsOrder.getAttachedEntity();
        List<BsReturnDetail> bsReturnDetailList = bsReturn.getBsReturnDetails();
            ArrayList<LinvRestParam> linvRestParams = new ArrayList<>();
            for (BsReturnDetail bsReturnDetail : bsReturnDetailList) {
                BsReturnDetailEntity bsReturnDetailEntity = bsReturnDetail.getEntity();

                LinvRestParam linvRestParam = new LinvRestParam();
                linvRestParam.setLogicAreaId(bsOrderEntity.getLogisticsZoneId());// 物流区id
                linvRestParam.setOwnerId(bsOrderEntity.getBsId());//买手id  货主Id
                linvRestParam.setOwnerCode(bsOrderAttachedEntity.getBsCode());
                linvRestParam.setOwnerType(OwnerType.Agent.getCode());
                linvRestParam.setCommodityId(bsReturnDetailEntity.getGoodsId());//商品Id
                if (BsOrderType.BS_B_STOCKPILING_ORDER.getCode().equals(bsOrderType)){
                    linvRestParam.setComoIvType(ComoIvType.Virtual.getCode());
                    linvRestParam.setAddTargetInv(false);
                    linvRestParam.setBizType(BizType.VirtualStoreReturn.getCode());
                } else {
                    linvRestParam.setComoIvType(ComoIvType.Actual.getCode());
                    linvRestParam.setAddTargetInv(true);
                    linvRestParam.setBizType(BizType.ActualStoreReturn.getCode());
                }
                linvRestParam.setRefNo(bsReturnEntity.getReturnCode());//退货单编码
                linvRestParam.setTransactionId(bsReturnEntity.getReturnId());// 退货单id
                linvRestParam.setTransactionNo(bsReturnEntity.getReturnCode());// 退货单编号
                linvRestParam.setTransactionDetailId(bsReturnDetailEntity.getDetailId());//退货单明细ID
                linvRestParam.setTransactionSequence(1);
                linvRestParam.setReleaseQty(bsReturnDetailEntity.getReturnQty());//释放数量
                linvRestParams.add(linvRestParam);
            }
            Stock.StoreRelease(linvRestParams);
        return bsOrder;
    }


    /**
     * 判断 买手的退货状态
     *
     * @param bsOrder
     * @return
     */
    public BsOrder getBsOrder(BsOrder bsOrder) {
        Boolean isAllReturn = true;
        List<BsOrderDetail> bsOrderDetailList = bsOrder.getBsOrderDetails();
        if (CollectionUtils.isNotEmpty(bsOrderDetailList)) {
            for (int index = 0; index < bsOrderDetailList.size() && isAllReturn; index++) {
                BsOrderDetail bsOrderDetail = bsOrderDetailList.get(index);
                List<BsStockpileSplitDetail> bsStockpileSplitDetailList = bsOrderDetail.getBsStockpileSplitDetails();
                for (BsStockpileSplitDetail bsStockpileSplitDetail : bsStockpileSplitDetailList) {
                    BsStockpileSplitDetailEntity bsStockpileSplitDetailEntity = bsStockpileSplitDetail.getEntity();
                    BigDecimal returnQuantity = bsStockpileSplitDetailEntity.getReturnQuantity();// 退货数量
                    BigDecimal goodsQuantity = bsStockpileSplitDetailEntity.getGoodsQuantity();
                    if (!DecimalUtils.eq(returnQuantity, goodsQuantity)) {
                        isAllReturn = false;
                        break;
                    }
                }
            }
        }
        // 获取买手订单下关联的退货单
        Operator operator = new Operator();
        operator.setOperatorId(OperatorType.MANAGER.getCode());
        operator.setOperatorType(OperatorType.MANAGER.getCode());
        SearchRestParam<ORDR0904IFilter> searchParam = new SearchRestParam<ORDR0904IFilter>();
        ORDR0904IFilter filter = new ORDR0904IFilter();
        filter.setOrderId(bsOrder.getEntity().getBsOrderId());
        searchParam.setFilter(filter);
        SearchRestResult<ORDR0904IRestResult> restResult = ordr0904IService.execute(operator, searchParam);
        for (ORDR0904IRestResult result : restResult.getData()){
            if (!BsReturnStu.COMPLETE.getCode().equals(result.getReturnStatus())) {
                isAllReturn = false;
                break;
            }
        }

        if (isAllReturn) {
            bsOrder.getEntity().setBsOrderStu(BsOrderStu.RETURNED.getCode());// 全部退货
            return bsOrder;
        } else {
            return null;
        }
    }

}
