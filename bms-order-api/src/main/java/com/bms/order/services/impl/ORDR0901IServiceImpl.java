package com.bms.order.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bms.order.archive.impl.*;
import com.bms.order.archive.impl.list.BsReturnDetailList;
import com.bms.order.archive.impl.list.BsStockpileSplitDetailList;
import com.bms.order.bean.param.ORDR0801IDetailBean;
import com.bms.order.bean.param.ORDR0901IDetailBean;
import com.bms.order.constant.enumeration.BsOrderStu;
import com.bms.order.constant.enumeration.BsReturnStu;
import com.bms.order.constant.enumeration.BsReturnType;
import com.bms.order.constant.enumeration.OperatorType;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.*;
import com.framework.core.utils.DecimalUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.param.ORDR0901IBean;
import com.bms.order.services.ORDR0901IService;
import com.framework.redis.dao.BaseRedisDao;
import org.springframework.util.CollectionUtils;

/**
 * 买手退货单创建接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0901IServiceImpl implements ORDR0901IService {

    @Autowired
    private BaseRedisDao redisDao;

    @Autowired
    private BsReturnDao bsReturnDao;

    @Autowired
    private BsReturnDetailDao bsReturnDetailDao;

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
    private BsStockpileSaleDetailDao bsStockpileSaleDetailDao;

    @Autowired
    private ReturnReasonDao returnReasonDao;

    /**
     * 接收买手退货信息，创建买手退货订单
     *
     * @param operator 操作者
     * @param bean     ORDR0901IBean
     */
    @Override
    public Long execute(Operator operator, ORDR0901IBean bean,String returnType) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        blackboard.setOperator(operator);
        map.put("bean", bean);
        map.put("blackboard", blackboard);
        map.put("returnType",returnType);

        pre(map);
        Long id = process(map);
        post(map);
        return id;
    }

    /**
     * 准备
     *
     * @param map HashMap
     */
    private void pre(HashMap<String, Object> map) {
        // 获取参数
        ORDR0901IBean bean = (ORDR0901IBean) map.get("bean");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        // TODO 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(bsReturnDao);
        blackboard.putBaseDao(bsReturnDetailDao);
        blackboard.putBaseDao(bsOrderDao);
        blackboard.putBaseDao(bsOrderDetailDao);
        blackboard.putBaseDao(bsStockpileSplitDetailDao);
        blackboard.putBaseDao(bsOrderAttachedDao);
        blackboard.putBaseDao(bsOrderDetailAttachedDao);
        blackboard.putBaseDao(bsStockpileSplitDetailAttachedDao);
        blackboard.putBaseDao(bsStockpileSaleDetailDao);
        blackboard.putBaseDao(returnReasonDao);

        //操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);
        checkOperatorType(operator,bean);

    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private Long process(HashMap<String, Object> map) {
        // 获取参数
        ORDR0901IBean bean = (ORDR0901IBean) map.get("bean");
        Blackboard blackboard = (Blackboard) map.get("blackboard");

        String returnType = (String) map.get("returnType");
        BsOrder bsOrder = bean.findBsOrderById();
        bsOrder.setBlackboard(blackboard);
        BsReturn bsReturn = bean.generateBsReturn();
        bsReturn.setBlackboard(blackboard);
        List<BsReturnDetail> bsReturnDetails = bsReturn.getBsReturnDetails();
        map.put("bsOrder",bsOrder);
        map.put("bsReturnDetails",bsReturnDetails);
        map.put("bsReturn",bsReturn);
        //为了给堂堂公用代码
        checkForCreate(map);
        bsReturn.create();
        for(BsReturnDetail returnDetail : bsReturnDetails){
            returnDetail.getEntity().setReturnId(bsReturn.getEntity().getReturnId());
            if(StringUtils.isEmpty(returnDetail.getEntity().getSalesUnit())) {
                returnDetail.getEntity().setSalesUnit("001");
            }
        }
        BsReturnDetailList bsReturnDetailList = BsReturnDetailList.build(blackboard).forCreate(bsReturnDetails.toArray(new BsReturnDetail[0]));
        bsReturnDetailList.create();
        //更新退货数量
        modify(bsReturnDetailList,blackboard);
        return bsReturn.getEntity().getReturnId();
    }


    /**
     * 更新买手囤货分拆明细退货数量
     * @param bsReturnDetailList
     */
    private void modify(BsReturnDetailList bsReturnDetailList,Blackboard blackboard){
        List<BsReturnDetail> bsReturnDetails = bsReturnDetailList.getArchives();

        List<Long> ids = new ArrayList<>();
        Map<Long,BigDecimal> map = new HashMap<>();
        for(BsReturnDetail bsReturnDetail : bsReturnDetails){
            ids.add(bsReturnDetail.getEntity().getBsStockpileSplitDetailId());
            map.put(bsReturnDetail.getEntity().getBsStockpileSplitDetailId(),bsReturnDetail.getEntity().getReturnQty());
        }
        BsStockpileSplitDetailList bsStockpileSplitDetails = BsStockpileSplitDetailList.build(blackboard).forComplete(ids.toArray(new Long[0]));
        bsStockpileSplitDetails.complete(false);
        for(BsStockpileSplitDetail bsStockpileSplitDetail : bsStockpileSplitDetails.getArchives()){
            bsStockpileSplitDetail.getEntity().setReturnQuantity(
                    DecimalUtils.add(map.get(bsStockpileSplitDetail.getEntity().getBsStockpileSplitDetailId()),
                            bsStockpileSplitDetail.getEntity().getReturnQuantity()));
        }
        BsStockpileSplitDetailList modifyList = BsStockpileSplitDetailList.build(blackboard).forUpdate(
                bsStockpileSplitDetails.getArchives().toArray(new BsStockpileSplitDetail[0]));
        modifyList.modify();
    }

    /**
     * 收尾
     *
     * @param map HashMap
     */
    private void post(HashMap<String, Object> map) {
        // 获取参数

        // 执行操作

    }

    /**
     * 权限验证
     * @param operator
     */
    private void checkOperatorType(Operator operator,ORDR0901IBean bean){
        OperatorType operatorType = OperatorType.getInstance(operator.getOperatorType());
        if(operatorType == OperatorType.BS){

        }else if(operatorType == OperatorType.MANAGER){

        }else {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000001,operatorType.getName());
        }

        if("001".equals(bean.getApplyUserType()) && operatorType == OperatorType.BS){
            if(null != bean.getApplyUid()){
                if(!bean.getBsId().equals(bean.getApplyUid())){
                    throw new BusinessException(ModuleCode.ORDR,ErrorCode.E090101);
                }
            }
        }else if("002".equals(bean.getApplyUserType()) && operatorType == OperatorType.MANAGER){

        }
        else {
                throw new BusinessException(ModuleCode.ORDR,ErrorCode.E090102);
        }
    }

    /**
     * 检查是否可以创建退货单
     * @param map
     */
    private void checkForCreate(HashMap<String, Object> map){
        ORDR0901IBean bean = (ORDR0901IBean) map.get("bean");
        Map<Long, BigDecimal> priceMap = new HashMap<>();
        for (ORDR0901IDetailBean detail : bean.getDetails()){
            priceMap.put(detail.getBsStockpileSplitDetailId(),detail.getReturnPriceUnit());
        }
        BsOrder bsOrder = (BsOrder) map.get("bsOrder");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        BsReturn bsReturn = (BsReturn) map.get("bsReturn");
        String returnType = (String)map.get("returnType");
        List<BsReturnDetail> bsReturnDetails = (List<BsReturnDetail>) map.get("bsReturnDetails");
        bsOrder.complete(false);

        if(!bsOrder.isDataSynced()){
            //该囤货订单不存在
            throw new BusinessException(ModuleCode.ORDR,ErrorCode.E090103);
        }
        /*if(!bean.getApplyUname().equals(bsOrder.getAttachedEntity().getBsName())){
            throw new BusinessException(ModuleCode.ORDR,ErrorCode.E090104);
        }*/
        //检查买手囤货订单状态是否是已完成
        if(!BsOrderStu.COMPLETE_STOCKPILE.getCode().equals(bsOrder.getEntity().getBsOrderStu())){
            //只有囤货完成的买手订单才能退货
            throw new BusinessException(ModuleCode.ORDR,ErrorCode.E090105);
        }
        ReturnReason returnReason = ReturnReason.build(blackboard).forComplete(bean.getReturnReasonId());
        returnReason.complete(false);
        if(!returnReason.isDataSynced()){
            throw new BusinessException(ModuleCode.ORDR,ErrorCode.E090106);
        }

        //退货总金额
        BigDecimal returnAmount = BigDecimal.ZERO;
        //检查退货数量和囤货数量
        for(BsReturnDetail bsReturnDetail : bsReturnDetails){
            BsStockpileSplitDetail bsStockpileSplitDetail =
                    BsStockpileSplitDetail.build(blackboard).forComplete(bsReturnDetail.getEntity().getBsStockpileSplitDetailId());
            bsStockpileSplitDetail.complete(false);
            if(!bsStockpileSplitDetail.isDataSynced()){
                throw new BusinessException(ModuleCode.ORDR,ErrorCode.E090107);
            }
            if(null != bsReturnDetail.getEntity().getReasonId()){
                ReturnReason detailReturnReason = ReturnReason.build(blackboard).forComplete(bsReturnDetail.getEntity().getReasonId());
                detailReturnReason.complete(false);
                if(!detailReturnReason.isDataSynced()){
                    throw new BusinessException(ModuleCode.ORDR,ErrorCode.E090108);
                }
            }

            //屯货数量
            BigDecimal stockQty = bsStockpileSplitDetail.getEntity().getGoodsQuantity();
            //已退货数量
            BigDecimal returnQty = bsStockpileSplitDetail.getEntity().getReturnQuantity();
            //销售数量
            BigDecimal saleQty = BigDecimal.ZERO;
            List<BsStockpileSaleDetail> bsStockpileSaleDetails = bsStockpileSplitDetail.getBsStockpileSaleDetails();
            if(!CollectionUtils.isEmpty(bsStockpileSaleDetails)){
                for(BsStockpileSaleDetail bsStockpileSaleDetail : bsStockpileSaleDetails){
                    saleQty = DecimalUtils.add(saleQty,bsStockpileSaleDetail.getEntity().getSaleQuantity());
                }
            }
            //可退货数量
            BigDecimal canReturnQty = DecimalUtils.subtract(DecimalUtils.subtract(stockQty,returnQty),saleQty);

            if(bsReturnDetail.getEntity().getReturnQty().compareTo(canReturnQty) > 0){
                throw new BusinessException(ModuleCode.ORDR,ErrorCode.E090109);
            }

            //计算退货金额
            BsOrderDetail bsOrderDetail = bsStockpileSplitDetail.getBsOrderDetail();
            //产品实际单价
            BigDecimal perAmount = null;
            if (priceMap.get(bsReturnDetail.getEntity().getBsStockpileSplitDetailId())!= null){
                perAmount = priceMap.get(bsReturnDetail.getEntity().getBsStockpileSplitDetailId());
            }else {
                perAmount = bsOrderDetail.getEntity().getRealUnitPrice();
            }
            bsReturnDetail.getEntity().setSalesUnit(bsOrderDetail.getEntity().getGoodsUnit());
            returnAmount = DecimalUtils.add(returnAmount,DecimalUtils.multiplyAndRound(perAmount,bsReturnDetail.getEntity().getReturnQty(),2));
        }
        //设置退货金额
        bsReturn.getEntity().setReturnAmount(returnAmount);
        //设置买手相关信息
        bsReturn.getEntity().setBsCode(bsOrder.getAttachedEntity().getBsCode());
        bsReturn.getEntity().setBsName(bsOrder.getAttachedEntity().getBsName());
        //设置退货类型
        bsReturn.getEntity().setBsReturnType(returnType);
        //设置退货状态
        if(BsReturnType.PASSIVE.getCode().equals(returnType)){
            bsReturn.getEntity().setBsReturnStu(BsReturnStu.COMPLETE.getCode());
        }else {
            bsReturn.getEntity().setBsReturnStu(BsReturnStu.TO_CONFIRM.getCode());
        }
    }
}
