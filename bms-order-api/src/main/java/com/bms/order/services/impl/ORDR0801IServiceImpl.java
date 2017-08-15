package com.bms.order.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bms.order.bean.entity.BuyerReturnDetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.order.archive.impl.BuyerForcastDeliverDetail;
import com.bms.order.archive.impl.BuyerOrder;
import com.bms.order.archive.impl.BuyerReturn;
import com.bms.order.archive.impl.BuyerReturnDetail;
import com.bms.order.archive.impl.DistributionNotificationDetail;
import com.bms.order.archive.impl.Operator;
import com.bms.order.archive.impl.ReceiveNotification;
import com.bms.order.archive.impl.ReceiveNotificationDetail;
import com.bms.order.archive.impl.ReturnReason;
import com.bms.order.archive.impl.list.BuyerReturnDetailList;
import com.bms.order.archive.impl.list.ReceiveNotificationDetailList;
import com.bms.order.archive.impl.list.ReceiveNotificationList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.param.ORDR0801IBean;
import com.bms.order.bean.param.ORDR0801IDetailBean;
import com.bms.order.constant.enumeration.BuyerApplyUserType;
import com.bms.order.constant.enumeration.BuyerReturnStu;
import com.bms.order.constant.enumeration.BuyerReturnType;
import com.bms.order.constant.enumeration.OperatorType;
import com.bms.order.constant.enumeration.OrderPlacerType;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BuyerForcastDeliverDetailAttachedDao;
import com.bms.order.dao.BuyerForcastDeliverDetailDao;
import com.bms.order.dao.BuyerOrderAttachedDao;
import com.bms.order.dao.BuyerOrderDao;
import com.bms.order.dao.BuyerReturnDao;
import com.bms.order.dao.BuyerReturnDetailDao;
import com.bms.order.dao.DistributionNotificationDetailDao;
import com.bms.order.dao.ReceiveNotificationDao;
import com.bms.order.dao.ReceiveNotificationDetailDao;
import com.bms.order.dao.ReturnReasonDao;
import com.bms.order.services.ORDR0801IService;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.DecimalUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;

/**
 * 买家退货单创建接口Service
 *
 * @author wang_jianzhou
 */
@Service
public class ORDR0801IServiceImpl implements ORDR0801IService {

    @Autowired
    private BaseRedisDao redisDao;

    @Autowired
    private BuyerOrderDao buyerOrderDao;

    @Autowired
    private BuyerOrderAttachedDao buyerOrderAttachedDao;

    @Autowired
    private ReturnReasonDao returnReasonDao;

    @Autowired
    private BuyerReturnDao buyerReturnDao;

    @Autowired
    private BuyerReturnDetailDao buyerReturnDetailDao;

    @Autowired
    private ReceiveNotificationDetailDao receiveNotificationDetailDao;

    @Autowired
    private ReceiveNotificationDao receiveNotificationDao;

    @Autowired
    private DistributionNotificationDetailDao distributionNotificationDetailDao;

    @Autowired
    private BuyerForcastDeliverDetailDao buyerForcastDeliverDetailDao;

    @Autowired
    private BuyerForcastDeliverDetailAttachedDao buyerForcastDeliverDetailAttachedDao;



    /**
     * 接收买家平台退货信息，创建退货订单
     *
     * @param operator 操作者
     * @param param     ORDR0801IBean
     */
    @Override
    public Long execute(Operator operator, ORDR0801IBean param) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        blackboard.setOperator(operator);
        map.put("param", param);
        map.put("blackboard", blackboard);

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
        ORDR0801IBean param = (ORDR0801IBean) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        // TODO 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(buyerOrderDao);
        blackboard.putBaseDao(buyerOrderAttachedDao);
        blackboard.putBaseDao(returnReasonDao);
        blackboard.putBaseDao(buyerReturnDao);
        blackboard.putBaseDao(buyerReturnDetailDao);
        blackboard.putBaseDao(receiveNotificationDetailDao);
        blackboard.putBaseDao(receiveNotificationDao);
        blackboard.putBaseDao(distributionNotificationDetailDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailAttachedDao);


        //操作者
        Operator operator = blackboard.getOperator(); operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);
        //数据权限验证
        checkOperator(operator,param);
        BuyerOrder buyerOrder = param.findBuyerOrder();
        buyerOrder.setBlackboard(blackboard);
        ReturnReason returnReason = param.findReturnReason();
        returnReason.setBlackboard(blackboard);

        BuyerReturn buyerReturn = param.generateBuyerReturn();
        buyerReturn.setBlackboard(blackboard);
        List<ORDR0801IDetailBean> returnDetails = param.getDetails();
        map.put("buyerOrder",buyerOrder);
        map.put("returnReason",returnReason);
        map.put("buyerReturn",buyerReturn);
        map.put("returnDetails",returnDetails);



    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private Long process(HashMap<String, Object> map) {
        // 获取参数

        Blackboard blackboard = (Blackboard) map.get("blackboard");
        BuyerOrder buyerOrder = (BuyerOrder) map.get("buyerOrder");
        buyerOrder.complete(false);
        List<ORDR0801IDetailBean> returnDetails = (List<ORDR0801IDetailBean>) map.get("returnDetails");
        ReturnReason returnReason = (ReturnReason) map.get("returnReason");
        returnReason.complete(false);
        if(!buyerOrder.isDataSynced()){
            throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080101);
        }

        if(!returnReason.isDataSynced()){
            throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080102);
        }

        List<ReceiveNotificationDetail> receiveNotificationDetailFilters = new ArrayList<>();
        if(!CollectionUtils.isEmpty(returnDetails)){
            for(ORDR0801IDetailBean returnDetail : returnDetails){
                ReceiveNotificationDetail receiveNotificationDetail = returnDetail.findReceiveNotificationDetail();
                receiveNotificationDetail.setBlackboard(blackboard);
                ReturnReason detailReturnReason = returnDetail.detailFindReturnReason();
                if(null != detailReturnReason){
                    detailReturnReason.setBlackboard(blackboard);
                    detailReturnReason.complete(false);
                    if(!detailReturnReason.isDataSynced()){
                        throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080103);
                    }
                }
                receiveNotificationDetailFilters.add(receiveNotificationDetail);
            }
        }
        map.put("receiveNotificationDetailFilters",receiveNotificationDetailFilters);
        //查询收货明细
        getReceiveDetails(map);
        //检查是否满足退货要求
        check(map);
        //插入数据
        Long id = createBuyerReturn(map);
        //更新订单相关数据
        modify(map);
        return id;
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
     * 查询收货明细
     * @param map
     */
    private void getReceiveDetails(HashMap<String, Object> map){
        List<ReceiveNotificationDetail> receiveNotificationDetailFilters = (List<ReceiveNotificationDetail>) map.get("receiveNotificationDetailFilters");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        List<Long> ids = new ArrayList<>();
        for(ReceiveNotificationDetail receiveNotificationDetail : receiveNotificationDetailFilters){
            ids.add(receiveNotificationDetail.getEntity().getReceiveNotificationDetailId());
        }
        ReceiveNotificationDetailList receiveNotificationDetailList = ReceiveNotificationDetailList.build(blackboard).forComplete(
                ids.toArray(new Long[ids.size()]));
        receiveNotificationDetailList.complete(false);
        List<ReceiveNotificationDetail> receiveDetailResults = receiveNotificationDetailList.getArchives();
        //检查输入的收货明细ID 是否都存在数据
        Map<Long,Long> checkReceiveDetailMap = new HashMap<>();
        if(!CollectionUtils.isEmpty(receiveDetailResults)){
            for(ReceiveNotificationDetail resultReceiveNotificationDetail : receiveDetailResults){
                Long resultReceiveDetailId = resultReceiveNotificationDetail.getEntity().getReceiveNotificationDetailId();
                checkReceiveDetailMap.put(resultReceiveDetailId,resultReceiveDetailId);
            }
        }else {
            throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080104);
        }

        for(ReceiveNotificationDetail filterReceiveDetail : receiveNotificationDetailFilters){
            Long filterReceiveDetailId = filterReceiveDetail.getEntity().getReceiveNotificationDetailId();
            if(null == checkReceiveDetailMap.get(filterReceiveDetailId)){
                throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080105);
            }

        }
        map.put("receiveDetailResults",receiveDetailResults);

    }

    /**
     * 检查是否满足退货条件
     * @param map
     */
    private void check(HashMap<String, Object> map){

        BuyerOrder buyerOrder = (BuyerOrder) map.get("buyerOrder");
        BuyerReturn buyerReturn = (BuyerReturn) map.get("buyerReturn");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        List<ReceiveNotificationDetail> receiveDetailResults = (List<ReceiveNotificationDetail>) map.get("receiveDetailResults");
        List<ReceiveNotificationDetail> receiveNotificationDetailFilters = (List<ReceiveNotificationDetail>) map.get("receiveNotificationDetailFilters");
        List<ORDR0801IDetailBean> returnDetails = (List<ORDR0801IDetailBean>) map.get("returnDetails");
        if(!buyerOrder.getEntity().getBuyerId().equals(buyerReturn.getEntity().getBuyerId())){
            throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080106);
        }

        //申请人类型为买家
        if(BuyerApplyUserType.BUYER.getCode().equals(buyerReturn.getEntity().getBuyerApplyUserType())){

            if(null != buyerReturn.getEntity().getApplyUid()
                    && !buyerReturn.getEntity().getApplyUid().equals(buyerOrder.getEntity().getBuyerId())){
                throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080107);
            }

            if(!buyerReturn.getEntity().getApplyUname().equals(buyerOrder.getAttachedEntity().getBuyerName())){
                throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080108);
            }
        }

        //申请人类型为管家
        if(BuyerApplyUserType.SA.getCode().equals(buyerReturn.getEntity().getBuyerApplyUserType())){
            if(null != buyerReturn.getEntity().getApplyUid()
                    && !OrderPlacerType.SA.equals(buyerOrder.getEntity().getOrderPlacerType())
                    && !buyerOrder.getEntity().getOrderPlacerId().equals(buyerReturn.getEntity().getApplyUid())){
                throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080109);
            }

            if(!buyerReturn.getEntity().getApplyUname().equals(buyerOrder.getAttachedEntity().getOrderPlacerName())){
                throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080110);
            }
        }


        //判断是或否收货
        if (receiveNotificationDetailFilters.size() != receiveDetailResults.size()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080111);
        }

        // 判断商品ID与收货通知单明细ID是否一一对应
        Map<String,String> goodsIdMap = new HashMap<>();
        for(ReceiveNotificationDetail result : receiveDetailResults){
            goodsIdMap.put(result.getEntity().getGoodsId(),result.getEntity().getGoodsId());
        }
        for(ORDR0801IDetailBean returnDetail : returnDetails){
            if(null == goodsIdMap.get(returnDetail.getGoodsId())){
                throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080112);
            }
        }

        // 判断收货通知单是否存在
        List<Long> receiveNotificationIds = new ArrayList<>();
        for (ReceiveNotificationDetail detail : receiveDetailResults) {
            Long receiveNotificationId = detail.getEntity().getReceiveNotificationId();
            if (!receiveNotificationIds.contains(receiveNotificationId))
                receiveNotificationIds.add(receiveNotificationId);
        }
        ReceiveNotificationList receiveNotificationList = ReceiveNotificationList.build(blackboard)
                .forComplete(receiveNotificationIds.toArray(new Long[0]));
        receiveNotificationList.complete(false);
        if (receiveNotificationList.getArchives() == null
                || receiveNotificationIds.size() != receiveNotificationList.getArchives().size()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000002, "收货通知单明细没有对应的收货通知单");
        }
        // 判断收货时间
        for (ReceiveNotification receiveNotification : receiveNotificationList.getArchives()) {
            if (receiveNotification.getEntity().getReceiveTime() == null)
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000002, "收货通知单没有收货时间");
        }

        // 判断时间, 退货数量是否满足
        for(ReceiveNotificationDetail receiveDetail : receiveDetailResults){
            for(ORDR0801IDetailBean returnDetail : returnDetails){
                if(returnDetail.getReceiveNotificationDetailId().equals(receiveDetail.getEntity().getReceiveNotificationDetailId())){
                    Date receiveTime = receiveDetail.getReceiveNotification().getEntity().getReceiveTime();
                    Date latestDate = DateUtils.addDays(receiveTime, 3);
                    if(buyerReturn.getEntity().getApplyTime().getTime() > latestDate.getTime()){
                        throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080113, returnDetail.getReceiveNotificationDetailId().toString());
                    }
                    //可退货数量
                    BigDecimal canReturnQty = DecimalUtils.subtract(receiveDetail.getEntity().getReceiveQuantity(),receiveDetail.getEntity().getReturnQuantity());
                    if(DecimalUtils.gt(returnDetail.getReturnQty(),canReturnQty)){
                        throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080114);
                    }
                }
            }
        }


    }

    /**
     * 创建退货单，退货明细
     * @param map
     */
    private Long createBuyerReturn(HashMap<String, Object> map){
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        BuyerOrder buyerOrder = (BuyerOrder) map.get("buyerOrder");
        BuyerReturn buyerReturn = (BuyerReturn) map.get("buyerReturn");
        List<ReceiveNotificationDetail> receiveDetailResults = (List<ReceiveNotificationDetail>) map.get("receiveDetailResults");


        buyerReturn.getEntity().setBuyerName(buyerOrder.getAttachedEntity().getBuyerName());
        buyerReturn.getEntity().setBuyerCode(buyerOrder.getAttachedEntity().getBuyerCode());
        buyerReturn.getEntity().setBuyerReturnType(BuyerReturnType.RECEIVE_RETURN.getCode());
        buyerReturn.getEntity().setBuyerReturnStatus(BuyerReturnStu.TO_CONFIRM.getCode());
        setReturnAmount(map);
        buyerReturn.create();

        List<BuyerReturnDetail> buyerReturnDetails = new ArrayList<>();
        List<ORDR0801IDetailBean> detailBeans = (List<ORDR0801IDetailBean>)map.get("returnDetails");
        for(ORDR0801IDetailBean detailBean : detailBeans){
            BuyerReturnDetail buyerReturnDetail = detailBean.generateBuyerReturnDetail();
            buyerReturnDetails.add(buyerReturnDetail);
        }
        Map<Long,Long> receiveId = new HashMap<>();
        for(ReceiveNotificationDetail receiveNotificationDetail : receiveDetailResults){
            receiveId.put(receiveNotificationDetail.getEntity().getReceiveNotificationDetailId(),receiveNotificationDetail.getEntity().getReceiveNotificationId());
        }
        if(!CollectionUtils.isEmpty(buyerReturnDetails)){
            for(BuyerReturnDetail buyerReturnDetail : buyerReturnDetails){
                buyerReturnDetail.getEntity().setReturnId(buyerReturn.getEntity().getReturnId());
                // TODO: 2017/3/3 暂时先写死，后期用CodeMaster
                buyerReturnDetail.getEntity().setSalesUnit("001");
                buyerReturnDetail.getEntity().setReceiveNotificationId(receiveId.get(buyerReturnDetail.getEntity().getReceiveNotificationDetailId()));
            }
        }
        BuyerReturnDetailList buyerReturnDetailList = BuyerReturnDetailList.build(blackboard).forCreate(buyerReturnDetails.toArray(new BuyerReturnDetail[0]));
        buyerReturnDetailList.create();
        return buyerReturn.getEntity().getReturnId();
    }


    /**
     * 设置退货总金额
     * @param map
     */
    private void setReturnAmount(HashMap<String, Object> map){
        List<ReceiveNotificationDetail> receiveDetailResults = (List<ReceiveNotificationDetail>) map.get("receiveDetailResults");
        BuyerReturn buyerReturn = (BuyerReturn) map.get("buyerReturn");
        ORDR0801IBean param = (ORDR0801IBean) map.get("param");
        Map<Long, BigDecimal> priceMap = new HashMap<>();
        for (ORDR0801IDetailBean bean : param.getDetails()){
            priceMap.put(bean.getReceiveNotificationDetailId(),bean.getReturnPriceUnit());
        }
        List<BuyerReturnDetail> buyerReturnDetails = buyerReturn.getBuyerReturnDetails();
        //退货总金额
        BigDecimal totalAmount =BigDecimal.ZERO;
        for(BuyerReturnDetail buyerReturnDetail : buyerReturnDetails){
            BuyerReturnDetailEntity entity = buyerReturnDetail.getEntity();
            //退货数量*单价
            if (priceMap.get(entity.getReceiveNotificationDetailId()) != null){
                //产品单价
                BigDecimal perPrice = priceMap.get(entity.getReceiveNotificationDetailId());
                //退货数量
                BigDecimal returnQty = entity.getReturnQty();
                //单条明细总价
                BigDecimal detailAmount = DecimalUtils.multiplyAndRound(returnQty,perPrice,2);
                //退货总金额
                totalAmount = DecimalUtils.add(totalAmount,detailAmount);
            } else {
                for(ReceiveNotificationDetail receiveNotificationDetail : receiveDetailResults){
                    if(receiveNotificationDetail.getEntity().getReceiveNotificationDetailId().
                            equals(entity.getReceiveNotificationDetailId())){
                        //产品单价
                        BigDecimal perPrice = receiveNotificationDetail.getEntity().getPricePlateUnitPrice();
                        //退货数量
                        BigDecimal returnQty = entity.getReturnQty();
                        //单条明细总价
                        BigDecimal detailAmount = DecimalUtils.multiplyAndRound(returnQty,perPrice,2);
                        //退货总金额
                        totalAmount = DecimalUtils.add(totalAmount,detailAmount);
                    }
                }
            }
        }
        buyerReturn.getEntity().setReturnAmount(totalAmount);
    }

    /**
     * 验证数据权限
     * @param operator
     * @param bean
     */
    private void checkOperator(Operator operator,ORDR0801IBean bean){
        OperatorType operatorType = OperatorType.getInstance(operator.getOperatorType());
        if(operatorType == OperatorType.BUYER){

        }else if(operatorType == OperatorType.SA){

        }else if(operatorType == OperatorType.MANAGER){

        }else {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000001,operatorType.getName());
        }

        if(BuyerApplyUserType.BUYER.getCode().equals(bean.getApplyUserType()) && operatorType == OperatorType.BUYER){
            if(null != bean.getApplyUid()){
                if(!bean.getBuyerId().equals(bean.getApplyUid())){
                    throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080115);
                }
            }
        }else if(BuyerApplyUserType.SA.getCode().equals(bean.getApplyUserType()) && operatorType == OperatorType.SA){

        }else if(BuyerApplyUserType.PLATFORM_STAFF.getCode().equals(bean.getApplyUserType()) && operatorType == OperatorType.MANAGER){

        }else {
            throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080116);
        }
    }

    /**
     * 更新订单相关数据
     * @param map
     */
    private void modify(HashMap<String, Object> map){
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        //收货明细
        List<ReceiveNotificationDetail> receiveDetailResults = (List<ReceiveNotificationDetail>) map.get("receiveDetailResults");
        //退货明细
        List<ORDR0801IDetailBean> returnDetails = (List<ORDR0801IDetailBean>) map.get("returnDetails");
        //更新收货明细退货数量
        Map<Long,BigDecimal> receiveReturnQtyMap = new HashMap<>();

        for(ORDR0801IDetailBean returnDetail : returnDetails){
            receiveReturnQtyMap.put(returnDetail.getReceiveNotificationDetailId(),returnDetail.getReturnQty());
        }
        for(ReceiveNotificationDetail receiveNotificationDetail : receiveDetailResults){
            BigDecimal returnQty = receiveReturnQtyMap.get(receiveNotificationDetail.getEntity().getReceiveNotificationDetailId());
            receiveNotificationDetail.getEntity().setReturnQuantity(DecimalUtils.add(receiveNotificationDetail.getEntity().getReturnQuantity(),returnQty));

        }
        //更新收货明细退货数量
        ReceiveNotificationDetailList receiveNotificationDetailList = ReceiveNotificationDetailList.build(blackboard).forUpdate(receiveDetailResults.toArray(new ReceiveNotificationDetail[0]));
        receiveNotificationDetailList.modify();
        //更新预配送明细
        Map<Long,BigDecimal> forCastMap = new HashMap<>();
        for(ORDR0801IDetailBean returnDetail : returnDetails){
            DistributionNotificationDetail distributionNotificationDetail = DistributionNotificationDetail.build(blackboard).forComplete(returnDetail.getDistributionNotificationDetailId());
            distributionNotificationDetail.complete(false);
            if(!distributionNotificationDetail.isDataSynced()){
                throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080117);
            }
            BuyerForcastDeliverDetail buyerForcastDeliverDetail = distributionNotificationDetail.getBuyerForcastDeliverDetail();
            if(null == buyerForcastDeliverDetail){
                throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080118);
            }
            Long id = buyerForcastDeliverDetail.getEntity().getBuyerForcastDeliverDetailId();
            if(null == forCastMap.get(id)){
                forCastMap.put(id,returnDetail.getReturnQty());
            }else {
                BigDecimal qty = forCastMap.get(id).add(returnDetail.getReturnQty());
                forCastMap.put(id,qty);
            }
        }

        for(Long id : forCastMap.keySet()){
            BuyerForcastDeliverDetail buyerForcastDeliverDetail = BuyerForcastDeliverDetail.build(blackboard).forComplete(id);
            buyerForcastDeliverDetail.complete(false);
            buyerForcastDeliverDetail.getEntity().setReturnQuantity(DecimalUtils.add(buyerForcastDeliverDetail.getEntity().getReturnQuantity(),forCastMap.get(id)));
            buyerForcastDeliverDetail.modify();
        }
    }

}

