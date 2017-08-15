package com.bms.order.services.impl;

import com.bms.order.archive.impl.*;
import com.bms.order.archive.impl.list.BuyerReturnDetailList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.param.ORDR0805IBeanParam;
import com.bms.order.bean.param.ORDR0805ILotParam;
import com.bms.order.bean.param.ORDR0805IProductParam;
import com.bms.order.bean.param.ORDR0901IBean;
import com.bms.order.constant.enumeration.*;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.*;
import com.bms.order.external.archive.Bs;
import com.bms.order.external.archive.Seller;
import com.bms.order.external.archive.Stock;
import com.bms.order.external.bean.param.LINV0116IParam;
import com.bms.order.external.bean.param.LinvRestParam;
import com.bms.order.external.bean.result.LINV0116IResult;
import com.bms.order.external.bean.result.LINV0116ISrcListResult;
import com.bms.order.fms.common.FmsCommon;
import com.bms.order.services.ORDR0805IService;
import com.bms.order.services.ORDR0901IService;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
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
import java.util.List;

/**
 * 买家订单修改接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0805IServiceImpl implements ORDR0805IService {
    @Autowired
    private BaseRedisDao redisDao;
    @Autowired
    private BuyerReturnDao buyerReturnDao;
    @Autowired
    private BuyerReturnDetailDao buyerReturnDetailDao;
    @Autowired
    private DistributionNotificationDetailDao distributionNotificationDetailDao;
    @Autowired
    private BuyerForcastDeliverDetailDao buyerForcastDeliverDetailDao;
    @Autowired
    private BuyerForcastDeliverDetailAttachedDao buyerForcastDeliverDetailAttachedDao;
    @Autowired
    private BuyerBatchOrderDao buyerBatchOrderDao;
    @Autowired
    private BuyerBatchOrderAttachedDao buyerBatchOrderAttachedDao;
    @Autowired
    private BuyerOrderDao buyerOrderDao;
    @Autowired
    private BuyerOrderAttachedDao buyerOrderAttachedDao;
    @Autowired
    private BsStockpileSaleDetailDao bsStockpileSaleDetailDao;
    @Autowired
    private BsStockpileSplitDetailDao bsStockpileSplitDetailDao;
    @Autowired
    private BsStockpileSplitDetailAttachedDao bsStockpileSplitDetailAttachedDao;
    @Autowired
    private BsOrderDetailDao bsOrderDetailDao;
    @Autowired
    private BsOrderDetailAttachedDao bsOrderDetailAttachedDao;
    @Autowired
    private BsOrderDao bsOrderDao;
    @Autowired
    private BsOrderAttachedDao bsOrderAttachedDao;
    @Autowired
    private SendNotificationDetailDao sendNotificationDetailDao;

    @Autowired
    private ORDR0901IService service;

    @Autowired
    private FmsCommon fmsCommon;

    public static final Logger logger = LoggerFactory.getLogger(ORDR0805IServiceImpl.class);

    /**
     * 订单配送通知单发送给美迪福之前，对订单基本信息进行修改
     *
     * @param operator 操作者
     * @param bean     ORDR0102IRestParam
     */
    @Transactional
    @Override
    public void execute(Operator operator, ORDR0805IBeanParam bean) {
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
     * @param map HashMap
     */
    private void pre(HashMap<String, Object> map) {
        // 获取参数
        @SuppressWarnings("unused")
        ORDR0805IBeanParam param = (ORDR0805IBeanParam) map.get("bean");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(buyerReturnDao);
        blackboard.putBaseDao(buyerReturnDetailDao);
        blackboard.putBaseDao(distributionNotificationDetailDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailAttachedDao);
        blackboard.putBaseDao(buyerBatchOrderDao);
        blackboard.putBaseDao(buyerBatchOrderAttachedDao);
        blackboard.putBaseDao(bsStockpileSaleDetailDao);
        blackboard.putBaseDao(buyerOrderDao);
        blackboard.putBaseDao(buyerOrderAttachedDao);
        blackboard.putBaseDao(bsStockpileSplitDetailDao);
        blackboard.putBaseDao(bsStockpileSplitDetailAttachedDao);
        blackboard.putBaseDao(bsOrderDetailDao);
        blackboard.putBaseDao(bsOrderDetailAttachedDao);
        blackboard.putBaseDao(bsOrderDao);
        blackboard.putBaseDao(bsOrderAttachedDao);
        blackboard.putBaseDao(sendNotificationDetailDao);
        // 操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);

        // 获取完整操作者
        operator.complete(false);
        OperatorType operatorType = OperatorType.getInstance(operator.getOperatorType());
        if (!operator.getOperatorType().equals(OperatorType.MADE_4_NET.getCode())) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000001, operatorType.getName());
        }
        BuyerReturn buyerReturn = BuyerReturn.build(blackboard).forComplete(Long.valueOf(param.getReturnId()));
        buyerReturn.complete(false);
        map.put("buyerReturn", buyerReturn);
        //1.2.1
        if (!buyerReturn.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080501, param.getReturnId() + "");
        } else {
            String returnStatus = buyerReturn.getEntity().getBuyerReturnStatus();
            if (!BuyerReturnStu.TO_STORE.getCode().equals(returnStatus)) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080502);
            }
        }
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        ORDR0805IBeanParam param = (ORDR0805IBeanParam) map.get("bean");
        BuyerReturn buyerReturn = (BuyerReturn) map.get("buyerReturn");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        List<BuyerReturnDetail> detailList = new ArrayList<>();//需要更新的退回明细
        List<ORDR0901IBean> ordr0901IBeanList = new ArrayList<>();//供货主体为买手，需要创建买手被动退货的数据
        ArrayList<LinvRestParam> linvRestParams = new ArrayList<>();
        for (BuyerReturnDetail detail : buyerReturn.getBuyerReturnDetails()) {
            ArrayList<LINV0116IParam> linv0116Params = new ArrayList<>();
            String detailId = String.valueOf(detail.getEntity().getDetailId());
            for (ORDR0805IProductParam productParam : param.getProductList()) {
                for (ORDR0805ILotParam lotParam : productParam.getLotList()){
                    if (detailId.equals(productParam.getReturnDetailId())) {
                        detail.getEntity().setInboundQty(DecimalUtils.add(detail.getEntity().getInboundQty(), DecimalUtils.getBigDecimal(lotParam.getInboundQty())));
                        String inboundBatch = detail.getEntity().getInboundBatch();
                        if (!StringUtils.isEmpty(inboundBatch)){
                            inboundBatch +=  ","+ lotParam.getLotNo();
                        } else {
                            inboundBatch = lotParam.getLotNo();
                        }
                        detail.getEntity().setInboundBatch(inboundBatch);
                        //获取退回订单对应的配送明细对象
                        DistributionNotificationDetail notificationDetail = DistributionNotificationDetail.build(blackboard).forComplete(detail.getEntity().getDistributionNotificationDetailId());
                        notificationDetail.complete(false);
                        BuyerForcastDeliverDetail buyerForcastDeliverDetail = notificationDetail.getBuyerForcastDeliverDetail();
                        BuyerBatchOrder batchOrder = buyerForcastDeliverDetail.getBuyerBatchOrder();
                        BuyerOrder buyerOrder = batchOrder.getBuyerOrder();
                        if (!notificationDetail.getEntity().getSku().equals(productParam.getSkuCode())) {
                            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080503, productParam.getSkuCode() + "");
                        }
//                        //判断买家配送明细供货主题是否是买手
//                        if (buyerForcastDeliverDetail.getEntity().getSellSideType().equals(SellSideType.SELL_TYPE.getCode())) {
//                            List<BsStockpileSaleDetail> deliverDetailList = buyerForcastDeliverDetail.getBsStockpileSaleDetails();//获取买手囤货销售明细
//                            BigDecimal inboundQty = DecimalUtils.getBigDecimal(lotParam.getInboundQty());//退货数量
//                            List<ORDR0901IDetailBean> details = new ArrayList<>();
//                            ORDR0901IDetailBean detailBean = new ORDR0901IDetailBean();
//                            ORDR0901IBean ordr0901IBean = new ORDR0901IBean();
//                            Map<Long, ORDR0901IBean> beanMap = new HashMap<>();
//                            for (BsStockpileSaleDetail saleDetail : deliverDetailList) {
//                                BsStockpileSplitDetail splitDetail = saleDetail.getBsStockpileSplitDetail();//获取买手囤货分拆单明细
//                                BsOrderDetail orderDetail = splitDetail.getBsOrderDetail();//获取买手订单明细
//                                BsOrder bsOrder = orderDetail.getBsOrder();//获取买手订单信息
//                                if (CollectionUtils.isNotEmpty(ordr0901IBeanList)) {
//                                    Boolean flag = true;
//                                    for (ORDR0901IBean ordr0901IBean1 : ordr0901IBeanList) {
//                                        if (ordr0901IBean1.getOrderId().equals(bsOrder.getEntity().getBsOrderId())) {
//                                            ordr0901IBean = ordr0901IBean1;
//                                            details = ordr0901IBean.getDetails();
//                                            flag = false;
//                                        }
//                                    }
//                                    if (flag) {
//                                        ordr0901IBean = new ORDR0901IBean();
//                                        ordr0901IBean.setOrderId(bsOrder.getEntity().getBsOrderId());
//                                        ordr0901IBean.setBsId(bsOrder.getEntity().getBsId());
//                                        ordr0901IBean.setReturnSource(BsReturnSource.ORDER_BACKEND.getCode());
//                                        ordr0901IBean.setReturnReasonId(1l);//TODO 未定义买手退货原因 暂时用1
//                                        ordr0901IBean.setApplyUserType(BsApplyUserType.PLATFORM_STAFF.getCode());
//                                        ordr0901IBean.setApplyUid(buyerOrder.getEntity().getBuyerId());
//                                        ordr0901IBean.setApplyUname(buyerOrder.getAttachedEntity().getBuyerName());
//                                        ordr0901IBean.setApplyTime(DateUtils.fmtCurrent());
//                                        details = new ArrayList<>();
//                                        ordr0901IBean.setDetails(details);
//                                        ordr0901IBeanList.add(ordr0901IBean);
//                                    }
//                                    detailBean = new ORDR0901IDetailBean();
//                                    detailBean.setBsStockpileSplitDetailId(splitDetail.getEntity().getBsStockpileSplitDetailId());
//                                    detailBean.setGoodsId(splitDetail.getEntity().getGoodsId());
//                                    BigDecimal goodsQuantity = splitDetail.getEntity().getGoodsQuantity();//买手分拆明细商品数量
//                                    BigDecimal returnQuantity = splitDetail.getEntity().getReturnQuantity();//买手分拆明细已退数量
//                                    BigDecimal actualQuantity = DecimalUtils.subtract(goodsQuantity, returnQuantity);//剩余数量
//                                    if (DecimalUtils.ge(inboundQty, actualQuantity)) {
//                                        detailBean.setReturnQty(actualQuantity);
//                                        inboundQty = DecimalUtils.subtract(inboundQty, actualQuantity);//总退货数量-已退数量
//                                    } else {
//                                        detailBean.setReturnQty(inboundQty);
//                                    }
//                                    details.add(detailBean);
//                                } else {
//                                    ordr0901IBean = new ORDR0901IBean();
//                                    ordr0901IBean.setOrderId(bsOrder.getEntity().getBsOrderId());
//                                    ordr0901IBean.setBsId(bsOrder.getEntity().getBsId());
//                                    ordr0901IBean.setReturnSource(BsReturnSource.ORDER_BACKEND.getCode());
//                                    ordr0901IBean.setReturnReasonId(1l);//TODO 未定义买手退货原因 暂时用1
//                                    ordr0901IBean.setApplyUserType(BsApplyUserType.PLATFORM_STAFF.getCode());
//                                    ordr0901IBean.setApplyUid(buyerOrder.getEntity().getBuyerId());
//                                    ordr0901IBean.setApplyUname(buyerOrder.getAttachedEntity().getBuyerName());
//                                    ordr0901IBean.setApplyTime(DateUtils.fmtCurrent());
//                                    details = new ArrayList<>();
//                                    detailBean = new ORDR0901IDetailBean();
//                                    detailBean.setBsStockpileSplitDetailId(splitDetail.getEntity().getBsStockpileSplitDetailId());
//                                    detailBean.setGoodsId(splitDetail.getEntity().getGoodsId());
//                                    BigDecimal goodsQuantity = splitDetail.getEntity().getGoodsQuantity();//买手分拆明细商品数量
//                                    BigDecimal returnQuantity = splitDetail.getEntity().getReturnQuantity();//买手分拆明细已退数量
//                                    BigDecimal actualQuantity = DecimalUtils.subtract(goodsQuantity, returnQuantity);//剩余数量
//                                    if (DecimalUtils.ge(inboundQty, actualQuantity)) {
//                                        detailBean.setReturnQty(actualQuantity);
//                                        inboundQty = DecimalUtils.subtract(inboundQty, actualQuantity);//总退货数量-已退数量
//                                    } else {
//                                        detailBean.setReturnQty(inboundQty);
//                                    }
//                                    details.add(detailBean);
//                                    ordr0901IBean.setDetails(details);
//                                    ordr0901IBeanList.add(ordr0901IBean);
//                                }
//                            }
//                        }
                        detailList.add(detail);
                    }
                }
            }
            //获取退回订单对应的配送明细对象
            DistributionNotificationDetail notificationDetail = DistributionNotificationDetail.build(blackboard).forComplete(detail.getEntity().getDistributionNotificationDetailId());
            notificationDetail.complete(false);
            BuyerForcastDeliverDetail buyerForcastDeliverDetail = notificationDetail.getBuyerForcastDeliverDetail();
            BuyerBatchOrder batchOrder = buyerForcastDeliverDetail.getBuyerBatchOrder();
            BuyerOrder buyerOrder = batchOrder.getBuyerOrder();

            // 调用溯源接口
            for (SendNotificationDetail sendNotificationDetail : notificationDetail.getSendNotificationDetails()){
                LINV0116IParam linv0116Param = new LINV0116IParam();
                linv0116Param.setOwnerId(buyerForcastDeliverDetail.getEntity().getSellSideId());
                linv0116Param.setTargetId(buyerOrder.getEntity().getBuyerId());
                linv0116Param.setTransactionId(buyerOrder.getEntity().getBuyerOrderId());
                linv0116Param.setTransactionNo(buyerOrder.getEntity().getBuyerOrderCode());
                linv0116Param.setTransactionDetailId(sendNotificationDetail.getEntity().getSendNotificationDetailId());
                linv0116Param.setCommodityId(detail.getEntity().getGoodsId());
                if (buyerForcastDeliverDetail.getEntity().getSellSideType().equals(SellSideType.PLATFORM_TYPE.getCode())) {
                    // 平台
                    linv0116Param.setBizType(BizType.SellerSale.getCode());
                } else {
                    // 买手
                    linv0116Param.setBizType(BizType.AgentSale.getCode());
                }
                linv0116Params.add(linv0116Param);
            }
            List<LINV0116IResult> linv0116IResults = Stock.AllocationSearch(linv0116Params);

            if (CollectionUtils.isEmpty(linv0116IResults)){
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080504);
            }
            BigDecimal inboundQty = detail.getEntity().getInboundQty();
            BigDecimal alreadyReturn = buyerReturnDao.findAlreadyReturn(detail.getEntity());
            BigDecimal srcQty = BigDecimal.ZERO;
            Boolean flg = true;
            Integer seq = 1;
            for(LINV0116IResult linv0116IResult : linv0116IResults){
                for (LINV0116ISrcListResult srcListResult : linv0116IResult.getSrcList()){
                    srcQty = DecimalUtils.add(srcQty,srcListResult.getSrcDealQty());
                    if (DecimalUtils.gt(srcQty,alreadyReturn) && DecimalUtils.gt(inboundQty,BigDecimal.ZERO)){
                        if (flg){
                            srcListResult.setSrcDealQty(DecimalUtils.subtract(srcQty, alreadyReturn));
                            flg = false;
                        }
                        LinvRestParam linvRestParam = new LinvRestParam();
                        linvRestParam.setLogicAreaId(buyerOrder.getEntity().getLogisticsZoneId());// 物流区id
                        linvRestParam.setOwnerId(buyerOrder.getEntity().getBuyerId());//买手id  货主Id
                        linvRestParam.setOwnerCode(buyerOrder.getAttachedEntity().getBuyerCode());
                        linvRestParam.setOwnerType(OwnerType.Buyer.getCode());
                        linvRestParam.setCommodityId(buyerForcastDeliverDetail.getEntity().getGoodsId());//商品Id
                        linvRestParam.setComoIvType(ComoIvType.Actual.getCode());
                        linvRestParam.setAddTargetInv(true);
                        linvRestParam.setDeductSrcInv(false);

                        linvRestParam.setRefNo(buyerReturn.getEntity().getReturnCode());//退货单编码
                        linvRestParam.setTransactionId(buyerReturn.getEntity().getReturnId());// 退货单id
                        linvRestParam.setTransactionNo(buyerReturn.getEntity().getReturnCode());// 退货单编号
                        linvRestParam.setTransactionDetailId(detail.getEntity().getDetailId());//退货单明细ID
                        linvRestParam.setTransactionSequence(seq++);
                        if (buyerForcastDeliverDetail.getEntity().getSellSideType().equals(SellSideType.PLATFORM_TYPE.getCode())){
                            Seller seller =  Seller.getSellerByCode(Seller.SELLER_CODE);
                            linvRestParam.setTargetId(seller.getEntity().getSellerId().toString());
                            linvRestParam.setTargetCode(Seller.SELLER_CODE);
                            linvRestParam.setTargetType(OwnerType.Seller.getCode());
                            linvRestParam.setBizType(BizType.SellerSaleReturn.getCode());
                        } else {
                            linvRestParam.setTargetId(buyerForcastDeliverDetail.getEntity().getSellSideId());
                            Bs bs = Bs.getBsInfoById(buyerForcastDeliverDetail.getEntity().getSellSideId());
                            linvRestParam.setTargetCode(bs.getEntity().getBsCode());
                            linvRestParam.setTargetType(OwnerType.Agent.getCode());
                            linvRestParam.setBizType(BizType.AgentSaleReturn.getCode());
                        }
                        if (DecimalUtils.ge(srcListResult.getSrcDealQty(),inboundQty)){
                            linvRestParam.setReleaseQty(inboundQty);
                            inboundQty = BigDecimal.ZERO;
                        } else {
                            linvRestParam.setReleaseQty(srcListResult.getSrcDealQty());
                            inboundQty = DecimalUtils.subtract(inboundQty, srcListResult.getSrcDealQty());
                        }
                        linvRestParam.setSrcTransactionId(srcListResult.getSrcTransactionId());
                        linvRestParam.setSrcTransactionNo(srcListResult.getSrcTransactionNo());
                        linvRestParam.setSrcTransactionDetailId(srcListResult.getSrcTransactionDetailId());
                        linvRestParams.add(linvRestParam);
                    }
                }
            }
        }
        //更新退货明细信息
        BuyerReturnDetailList buyerReturnDetailList = BuyerReturnDetailList.build(blackboard).forUpdate(detailList.toArray(new BuyerReturnDetail[detailList.size()]));
        buyerReturnDetailList.modify();
        //更新退货信息状态为已退货
        buyerReturn.getEntity().setBuyerReturnStatus(BuyerReturnStu.STORED.getCode());
        buyerReturn.getEntity().setInboundUname(param.getInboundPerson());
        buyerReturn.getEntity().setInboundTime(DateUtils.parseDateTime(param.getInboundTime()));
        buyerReturn.modify();
        Stock.BuyerReturn(linvRestParams);
        map.put("ordr0901IBeanList", ordr0901IBeanList);
    }

    /**
     * 收尾
     *
     * @param map HashMap
     */

    private void post(HashMap<String, Object> map) {
        // 获取参数
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        List<ORDR0901IBean> ordr0901IBeanList = (List<ORDR0901IBean>) map.get("ordr0901IBeanList");
        if (null != ordr0901IBeanList && ordr0901IBeanList.size() > 0) {
            Operator operator = blackboard.getOperator();
            operator.setOperatorType(OperatorType.MANAGER.getCode());
            for (ORDR0901IBean bean : ordr0901IBeanList) {
                service.execute(operator, bean, BsReturnType.PASSIVE.getCode());
            }
        }

        BuyerReturn buyerReturn = (BuyerReturn) map.get("buyerReturn");
        Long returnId = buyerReturn.getEntity().getReturnId();

        // 推送买家退货入库订单
        try {
//            if (!BuyerReturnType.DELAY_RETURN.equals(buyerReturn.getEntity().getBuyerReturnType())) {
                // 迟收不推送，退货和拒收推送
                fmsCommon.pushBuyerReturnOrder(returnId);
//            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }
}
