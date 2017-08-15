package com.bms.order.services.impl;

import com.bms.order.archive.impl.*;
import com.bms.order.archive.impl.list.BsVirtualPerformDetailList;
import com.bms.order.archive.impl.list.BsVirtualPerformList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.BsVirtualPerformDetailEntity;
import com.bms.order.bean.entity.BsVirtualPerformEntity;
import com.bms.order.bean.entity.BuyerSellerDetailEntity;
import com.bms.order.bean.param.ORDR1001IBeanParam;
import com.bms.order.bean.result.ORDR1001IBsOrderDetailCountResult;
import com.bms.order.constant.enumeration.*;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.dao.*;
import com.bms.order.external.archive.Bs;
import com.bms.order.external.archive.Price;
import com.bms.order.external.archive.Seller;
import com.bms.order.external.archive.Stock;
import com.bms.order.external.bean.entity.BsEntity;
import com.bms.order.external.bean.entity.PriceEntity;
import com.bms.order.external.bean.param.LinvRestParam;
import com.bms.order.external.bean.param.PriceRestParam;
import com.bms.order.services.ORDR1001IService;
import com.bms.order.util.CodeRule;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DecimalUtils;
import com.framework.core.utils.NumberUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * 行权接口Service
 *
 * @author qiu_wenting
 */
@Service
public class ORDR1001IServiceImpl implements ORDR1001IService {

    @Autowired
    private BaseRedisDao baseRedisDao;

    @Autowired
    private BuyerOrderDao buyerOrderDao;

    @Autowired
    private BuyerOrderAttachedDao buyerOrderAttachedDao;

    @Autowired
    private BuyerSellerDetailDao buyerSellerDetailDao;

    @Autowired
    private BsVirtualPerformDao bsVirtualPerformDao;

    @Autowired
    private  BsVirtualPerformDetailDao bsVirtualPerformDetailDao;

    @Autowired
    private BsStockpileSplitDetailDao bsStockpileSplitDetailDao;

    @Autowired
    private BsStockpileSplitDetailAttachedDao bsStockpileSplitDetailAttachedDao;

    @Autowired
    private BuyerBatchOrderDetailDao buyerBatchOrderDetailDao;

    @Autowired
    private BuyerBatchOrderDetailAttachedDao buyerBatchOrderDetailAttachedDao;

    @Autowired
    private BuyerBatchOrderDao buyerBatchOrderDao;

    @Autowired
    private BuyerBatchOrderAttachedDao buyerBatchOrderAttachedDao;

    public Long logisticsZoneId;
    public String logisticsZoneCode;

    public static final Logger logger = LoggerFactory.getLogger(ORDR1001IServiceImpl.class);


    /**
     * 资金结算系统发送支付信息，通知订单系统进行系统内支付
     *
     * @param operator 操作者
     * @param param    ORDR0701IRestParam
     */
    @Override
    public void execute(Operator operator, ORDR1001IBeanParam param) {
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
        @SuppressWarnings("unused")
        ORDR1001IBeanParam param = (ORDR1001IBeanParam) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.setBaseRedisDao(baseRedisDao);
        blackboard.putBaseDao(buyerOrderDao);
        blackboard.putBaseDao(buyerSellerDetailDao);
        blackboard.putBaseDao(bsVirtualPerformDao);
        blackboard.putBaseDao(bsVirtualPerformDetailDao);
        blackboard.putBaseDao(bsStockpileSplitDetailDao);
        blackboard.putBaseDao(buyerOrderAttachedDao);
        blackboard.putBaseDao(bsStockpileSplitDetailAttachedDao);
        blackboard.putBaseDao(buyerBatchOrderDetailDao);
        blackboard.putBaseDao(buyerBatchOrderDetailAttachedDao);
        blackboard.putBaseDao(buyerBatchOrderAttachedDao);
        blackboard.putBaseDao(buyerBatchOrderDao);

        //操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);

        BuyerOrder buyerOrder = param.generateBuyerOrder();
        buyerOrder.setBlackboard(blackboard);
        buyerOrder.complete(false);
        logisticsZoneId = buyerOrder.getEntity().getLogisticsZoneId();
        logisticsZoneCode = buyerOrder.getAttachedEntity().getLogisticsZoneCode();
        buyerOrder.setBlackboard(blackboard);
        map.put("buyerOrder", buyerOrder);
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        BuyerOrder buyerOrder = (BuyerOrder) map.get("buyerOrder");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        Map<String, Map<Long,BuyerSellerDetailEntity>> exerciseDataMap = preExerciseData(buyerOrder);
        createBsVirtualPerform(blackboard, exerciseDataMap, buyerOrder);
    }

    /**
     * 准备需要行权的供货明细数据，按照订单下商品集计汇总
     * @param buyerOrder
     * @return
     */
    private Map<String, Map<Long, BuyerSellerDetailEntity>> preExerciseData(BuyerOrder buyerOrder) {

        Map<String, Map<Long,BuyerSellerDetailEntity>> exerciseDataMap = new HashMap<>();

        List<BuyerBatchOrderDetail> buyerBatchOrderDetails = buyerOrder.getBuyerBatchOrderDetails();
        for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerBatchOrderDetails) {
            // 下单时的商品ID
            String goodsId = buyerBatchOrderDetail.getEntity().getGoodsId();
            List<BuyerSellerDetail> buyerSellerDetails = buyerBatchOrderDetail.getBuyerSellerDetails();
            for (BuyerSellerDetail buyerSellerDetail : buyerSellerDetails) {

                // 供货明细的商品ID
                Long exerciseGoodsId = buyerSellerDetail.getEntity().getAllocateGoodsId();

                // 不需要行权的商品
                if (ComoIvType.Actual.getCode().equals(buyerSellerDetail.getEntity().getComoIvType())) {
                    continue;
                }

                // 对需要行权的商品进行处理
                if (exerciseDataMap.containsKey(goodsId)) {
                    Map<Long, BuyerSellerDetailEntity> sellerDetailMap = exerciseDataMap.get(goodsId);
                    if (sellerDetailMap.containsKey(exerciseGoodsId)) {
                        BuyerSellerDetailEntity entity = sellerDetailMap.get(exerciseGoodsId);
                        BigDecimal qty = entity.getSellQty().add(buyerSellerDetail.getEntity().getSellQty());
                        entity.setSellQty(qty);
                    } else {
                        BuyerSellerDetailEntity entity = buyerSellerDetail.getEntity();
                        sellerDetailMap.put(exerciseGoodsId, entity);
                    }

                } else {
                    Map<Long, BuyerSellerDetailEntity> sellerDetailMap = new HashMap<>();
                    BuyerSellerDetailEntity entity = buyerSellerDetail.getEntity();
                    sellerDetailMap.put(exerciseGoodsId, entity);
                    exerciseDataMap.put(goodsId, sellerDetailMap);
                }
            }
        }
        return exerciseDataMap;
    }

    /**
     * 生产买手囤货行权单主表信息
     * @param blackboard
     * @param exerciseDataMap
     */
    private void createBsVirtualPerform(Blackboard blackboard, Map<String, Map<Long,BuyerSellerDetailEntity>> exerciseDataMap, BuyerOrder buyerOrder) {

        // 按照行权方ID，构建的行权商品集合
        Map<String, List<BsVirtualPerformDetailEntity>> bsVirtualPerformDetailMap = new HashMap<>();

        Iterator dataEntries = exerciseDataMap.entrySet().iterator();
        while (dataEntries.hasNext()) {
            Map.Entry dataEntry = (Map.Entry)dataEntries.next();
            String newGoodsId = (String) dataEntry.getKey();
            Map<String, BuyerSellerDetailEntity> exerciseGoodsMap = (Map<String,BuyerSellerDetailEntity>) dataEntry.getValue();

            Iterator entries = exerciseGoodsMap.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry entry = (Map.Entry) entries.next();
                Long oldGoodsId = (Long) entry.getKey();
                BuyerSellerDetailEntity buyerSellerDetailEntity = (BuyerSellerDetailEntity) entry.getValue();

                BsVirtualPerformDetailEntity performDetail = new BsVirtualPerformDetailEntity();
                performDetail.setNewGoodsId(NumberUtils.createLong(newGoodsId));
                performDetail.setOldGoodsId(oldGoodsId);
                performDetail.setPerformQty(buyerSellerDetailEntity.getSellQty());

                String performerId = buyerSellerDetailEntity.getSellSideId();
                if (bsVirtualPerformDetailMap.containsKey(performerId)) {
                    List<BsVirtualPerformDetailEntity> performDetails = bsVirtualPerformDetailMap.get(performerId);
                    performDetails.add(performDetail);
                } else {
                    List<BsVirtualPerformDetailEntity> performDetails = new ArrayList<>();
                    performDetails.add(performDetail);
                    bsVirtualPerformDetailMap.put(performerId, performDetails);
                }
            }
        }

        //  创建买手囤货行权单主表数据
        List<BsVirtualPerform> bsVirtualPerforms = new ArrayList<>();
        Iterator virtualDataEntries = bsVirtualPerformDetailMap.entrySet().iterator();
        while (virtualDataEntries.hasNext()) {
            Map.Entry entry = (Map.Entry)virtualDataEntries.next();
            String performerId = (String) entry.getKey();

            BsVirtualPerformEntity entity = new BsVirtualPerformEntity();
            entity.setPerformerId(performerId);

            // 调用买手、合伙人信息查询接口
            entity.setPerformerCode(Bs.getBsById(performerId).getEntity().getBsCode());

            // 生成行权单编码
            String performCode = CodeRule.commonRule("MSXQ");
            entity.setPerformCode(performCode);
            entity.setPerformStu(PerformStu.COMPLETE.getCode());
            entity.setPerformTime(new Date());

            BsVirtualPerform bsVirtualPerform = BsVirtualPerform.build(null).forCreate(entity);
            bsVirtualPerform.setBlackboard(blackboard);
            bsVirtualPerforms.add(bsVirtualPerform);
        }

        BsVirtualPerformList bsVirtualPerformList = BsVirtualPerformList.build(blackboard)
                .forCreate(bsVirtualPerforms.toArray(new BsVirtualPerform[0]));
        bsVirtualPerformList.create();

        // 生成买手囤货行权单明细表信息
        createBsVirtualPerformDetail(blackboard, bsVirtualPerformList, bsVirtualPerformDetailMap);

        // 调用库存，商品完成
        dealComoInv(bsVirtualPerformList);
    }

    /**
     * 生成买手囤货行权单明细表信息
     * @param bsVirtualPerformList
     * @param bsVirtualPerformDetailMap
     */
    private BsVirtualPerformDetailList createBsVirtualPerformDetail(Blackboard blackboard, BsVirtualPerformList bsVirtualPerformList, Map<String, List<BsVirtualPerformDetailEntity>> bsVirtualPerformDetailMap) {

        List<BsVirtualPerformDetail> bsVirtualPerformDetailList = new ArrayList<>();

        for (BsVirtualPerform bsVirtualPerform : bsVirtualPerformList.getArchives()) {

            String performerId = bsVirtualPerform.getEntity().getPerformerId();
            List<BsVirtualPerformDetailEntity> bsVirtualPerformDetails = bsVirtualPerformDetailMap.get(performerId);

            for (BsVirtualPerformDetailEntity bsVirtualPerformDetailEntity : bsVirtualPerformDetails) {
                // 行权前的商品ID
                Long goodsId = bsVirtualPerformDetailEntity.getOldGoodsId();

                ORDR1001IBsOrderDetailCountResult param = new ORDR1001IBsOrderDetailCountResult();
                param.setGoodsId(StringUtils.toString(goodsId));
                param.setOwnerId(performerId);

                List<ORDR1001IBsOrderDetailCountResult> results = bsVirtualPerformDetailDao.getBsVirtualPerforming(param);

                if (CollectionUtils.isEmpty(results)) {
                    return null;
                }
                BigDecimal totalPerformQty = bsVirtualPerformDetailEntity.getPerformQty();
                for (ORDR1001IBsOrderDetailCountResult result : results) {
                    if (totalPerformQty.compareTo(BigDecimal.ZERO) == NumberUtils.INTEGER_ZERO) {
                        break;
                    }

                    BsVirtualPerformDetailEntity bsVirtualPerformDetail = new BsVirtualPerformDetailEntity();
                    BeanUtils.copyProperties(bsVirtualPerformDetailEntity, bsVirtualPerformDetail);

                    BigDecimal performQty = result.getSaleQuantity();
                    if (totalPerformQty.compareTo(performQty) > NumberUtils.INTEGER_ZERO) {
                        totalPerformQty = DecimalUtils.subtract(totalPerformQty, performQty);
                        BsVirtualPerformDetail performDetail = createPerformDetail(blackboard, performQty, result, bsVirtualPerformDetail, bsVirtualPerform);
                        bsVirtualPerformDetailList.add(performDetail);
                    } else {
                        BsVirtualPerformDetail performDetail = createPerformDetail(blackboard, totalPerformQty, result, bsVirtualPerformDetail, bsVirtualPerform);
                        bsVirtualPerformDetailList.add(performDetail);
                        totalPerformQty = BigDecimal.ZERO;
                    }
                }
            }
        }

        BsVirtualPerformDetailList bsVirtualPerformDetails = BsVirtualPerformDetailList.build(blackboard)
                .forCreate(bsVirtualPerformDetailList.toArray(new BsVirtualPerformDetail[0]));
        bsVirtualPerformDetails.create();

        return bsVirtualPerformDetails;
    }

    /**
     * 创建行权明细
     * @param blackboard
     * @param performQty
     * @param baseBsVirtualPerformDetailEntity
     * @return
     */
    private BsVirtualPerformDetail createPerformDetail(Blackboard blackboard,BigDecimal performQty, ORDR1001IBsOrderDetailCountResult result, BsVirtualPerformDetailEntity baseBsVirtualPerformDetailEntity, BsVirtualPerform bsVirtualPerform) {
        BsVirtualPerformDetailEntity bsVirtualPerformDetailEntity = new BsVirtualPerformDetailEntity();
        bsVirtualPerformDetailEntity.setNewGoodsId(baseBsVirtualPerformDetailEntity.getNewGoodsId());
        bsVirtualPerformDetailEntity.setOldGoodsId(baseBsVirtualPerformDetailEntity.getOldGoodsId());
        bsVirtualPerformDetailEntity.setPerformQty(baseBsVirtualPerformDetailEntity.getPerformQty());

        BsVirtualPerformDetail bsVirtualPerformDetail = BsVirtualPerformDetail.build(blackboard).forCreate(bsVirtualPerformDetailEntity);
        bsVirtualPerformDetail.getEntity().setPerformQty(performQty);
        bsVirtualPerformDetail.getEntity().setPerformId(bsVirtualPerform.getEntity().getPerformId());
        bsVirtualPerformDetail.getEntity().setBsOrderId(result.getBsOrderId());
        bsVirtualPerformDetail.getEntity().setBsStockpileSplitDetailId(result.getBsStockpileSplitDetailId());

        ArrayList<PriceRestParam> paramList = new ArrayList<>();

        // 获取价盘
        PriceRestParam param = new PriceRestParam();
        param.setLgcsAreaCode(logisticsZoneCode);
        param.setGoodId(StringUtils.toString(bsVirtualPerformDetailEntity.getNewGoodsId())); // 转换的实物商品ID
        param.setUserType(PriceUserType.BS_USER.getCode());
        param.setCompareTimeOne(result.getBsOrderTime());
        // 数量
        param.setQty(result.getOrderGoodsQty());
        // 返回类型
        param.setReturnType(PriceReturnType.ALL_PRICE.getCode());
        paramList.add(param);

        List<PriceEntity> priceEntityList = Price.queryPricePlate(paramList);

        if (CollectionUtils.isEmpty(priceEntityList)) {
            throw new BusinessException(ErrorCode.E000002, "价盘不存在");
        }

        bsVirtualPerformDetail.getEntity().setPerformPrice(priceEntityList.get(0).getUnitPrice());
        bsVirtualPerformDetail.getEntity().setPerformPriceWay(priceEntityList.get(0).getWayDesc());

        BsVirtualPerformDetailEntity bsVirtualPerformDetailForLog = bsVirtualPerformDetail.getEntity();
        logger.debug("virtualPerformDetailId:" + bsVirtualPerformDetailForLog.getPerformDetailId() + "newGoodsId:" + bsVirtualPerformDetailForLog.getNewGoodsId() +
                "oldGoodsId:" + bsVirtualPerformDetailForLog.getOldGoodsId() + "performQty:" + bsVirtualPerformDetailForLog.getPerformQty() + "bsSplitDetailId:" + bsVirtualPerformDetailForLog.getBsStockpileSplitDetailId() +
        "PerformPrice:" + bsVirtualPerformDetailForLog.getPerformPrice() + "PerformPriceWay:" + bsVirtualPerformDetailForLog.getPerformPriceWay());

        return bsVirtualPerformDetail;
    }

    /**
     * 调用库存，商品完成
     * @param bsVirtualPerformList
     */
    private void dealComoInv(BsVirtualPerformList bsVirtualPerformList) {

        Seller seller = Seller.getSellerByCode(Seller.SELLER_CODE);

        ArrayList<LinvRestParam> completeParams = new ArrayList<>();
        for (BsVirtualPerform bsVirtualPerform : bsVirtualPerformList.getArchives()) {

            String performerId = bsVirtualPerform.getEntity().getPerformerId();
            BsEntity performer = Bs.getBsById(performerId).getEntity();
            List<BsVirtualPerformDetail> bsVirtualPerformDetails = bsVirtualPerform.getBsVirtualPerformDetails();
            if (CollectionUtils.isEmpty(bsVirtualPerformDetails)) {
                continue;
            }
            for (BsVirtualPerformDetail bsVirtualPerformDetail : bsVirtualPerformDetails) {

                // 扣减买手货权库存，不增加平台库存
                BsVirtualPerformDetailEntity bsVirtualPerformDetailEntity = bsVirtualPerformDetail.getEntity();
                LinvRestParam linvRestParam = new LinvRestParam();
                linvRestParam.setLogicAreaId(logisticsZoneId);
                linvRestParam.setOwnerId(performerId);
                linvRestParam.setOwnerCode(performer.getBsCode());
                linvRestParam.setOwnerType(OwnerType.Agent.getCode());
                linvRestParam.setCommodityId(StringUtils.toString(bsVirtualPerformDetailEntity.getOldGoodsId()));
                linvRestParam.setComoIvType(ComoIvType.Virtual.getCode());
                linvRestParam.setDeductSrcInv(true);
                linvRestParam.setAddTargetInv(false);
                linvRestParam.setRefNo(bsVirtualPerform.getEntity().getPerformCode());
                linvRestParam.setTransactionId(bsVirtualPerform.getEntity().getPerformId());
                linvRestParam.setTransactionNo(bsVirtualPerform.getEntity().getPerformCode());
                linvRestParam.setTransactionDetailId(bsVirtualPerformDetailEntity.getPerformDetailId());

                linvRestParam.setTargetId(StringUtils.toString(seller.getEntity().getSellerId()));
                linvRestParam.setTargetName(seller.getEntity().getSellerName());
                linvRestParam.setTargetCode(Seller.SELLER_CODE);
                linvRestParam.setTargetType(OwnerType.Seller.getCode());
                linvRestParam.setReleaseQty(bsVirtualPerformDetail.getEntity().getPerformQty());
                linvRestParam.setBizType(BizType.Virtual2Actual.getCode());
                linvRestParam.setDealQty(bsVirtualPerformDetail.getEntity().getPerformQty());
                completeParams.add(linvRestParam);


                // 减少平台实物库存，增加买手实物库存
                LinvRestParam linvParam = new LinvRestParam();
                linvParam.setLogicAreaId(logisticsZoneId);
                linvParam.setOwnerId(StringUtils.toString(seller.getEntity().getSellerId()));
                linvParam.setOwnerCode(Seller.SELLER_CODE);
                linvParam.setOwnerType(OwnerType.Seller.getCode());
                linvParam.setCommodityId(StringUtils.toString(bsVirtualPerformDetailEntity.getNewGoodsId()));
                linvParam.setComoIvType(ComoIvType.Actual.getCode());
                linvParam.setDeductSrcInv(true);
                linvParam.setAddTargetInv(true);
                linvParam.setRefNo(bsVirtualPerform.getEntity().getPerformCode());
                linvParam.setTransactionId(bsVirtualPerform.getEntity().getPerformId());
                linvParam.setTransactionNo(bsVirtualPerform.getEntity().getPerformCode());
                linvParam.setTransactionDetailId(bsVirtualPerformDetailEntity.getPerformDetailId());

                linvParam.setTargetId(performerId);
                linvParam.setTargetName(performer.getBsName());
                linvParam.setTargetCode(performer.getBsCode());
                linvParam.setTargetType(OwnerType.Agent.getCode());
                linvParam.setReleaseQty(bsVirtualPerformDetail.getEntity().getPerformQty());
                linvParam.setBizType(BizType.Virtual2Actual.getCode());
                linvParam.setDealQty(bsVirtualPerformDetail.getEntity().getPerformQty());

                completeParams.add(linvParam);
            }
        }

        Stock.StoreObtain(completeParams);
    }

    /**
     * 收尾
     *
     * @param map HashMap
     */
    private void post(HashMap<String, Object> map) {
        // 获取参数

        // 返回参数

    }

}
