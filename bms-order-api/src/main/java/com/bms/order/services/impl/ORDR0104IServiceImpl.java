package com.bms.order.services.impl;

import com.bms.order.archive.impl.*;
import com.bms.order.archive.impl.list.BuyerBatchOrderDetailList;
import com.bms.order.archive.impl.list.BuyerSellerDetailList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.BuyerBatchOrderDetailEntity;
import com.bms.order.bean.entity.BuyerSellerDetailEntity;
import com.bms.order.bean.param.ORDR0104IBeanParam;
import com.bms.order.bean.param.ORDR1001IBeanParam;
import com.bms.order.constant.enumeration.*;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.*;
import com.bms.order.external.archive.Goods;
import com.bms.order.external.archive.Seller;
import com.bms.order.external.archive.SellerSide;
import com.bms.order.external.archive.Stock;
import com.bms.order.external.bean.entity.SellerSideEntity;
import com.bms.order.external.bean.param.LINV0113IRestParam;
import com.bms.order.external.bean.param.LinvRestParam;
import com.bms.order.external.bean.param.StockRestParam;
import com.bms.order.services.ORDR0104IService;
import com.bms.order.services.ORDR1001IService;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.NumberUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * 买家订单确认接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0104IServiceImpl implements ORDR0104IService {
    public static final Logger logger = LoggerFactory.getLogger(ORDR0104IServiceImpl.class);

    @Autowired
    private BaseRedisDao redisDao;

    @Autowired
    private BuyerOrderDao buyerOrderDao;

    @Autowired
    private BuyerOrderAttachedDao buyerOrderAttachedDao;

    @Autowired
    private BuyerBatchOrderDetailDao buyerBatchOrderDetailDao;

    @Autowired
    private BuyerBatchOrderDetailAttachedDao buyerBatchOrderDetailAttachedDao;

    @Autowired
    private BuyerSellerDetailDao buyerSellerDetailDao;

    @Autowired
    private ORDR1001IService exerciseService;

    /**
     * 订单系统/平台订单人员确认买家订单，占用库存，生成记账凭证
     *
     * @param operator
     *            操作者
     * @param param
     *            ORDR0104IRestParam
     */

    @Override
    public Long execute(Operator operator, ORDR0104IBeanParam param) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        blackboard.setOperator(operator);
        map.put("param", param);
        map.put("blackboard", blackboard);
        pre(map);
        process(map);
        post(map);

        BuyerOrder buyerOrder = (BuyerOrder) map.get("buyerOrder");
        return buyerOrder.getEntity().getBuyerOrderId();
    }

    /**
     * 准备
     *
     * @param map
     *            HashMap
     */

    private void pre(HashMap<String, Object> map) {
        // 获取参数
        ORDR0104IBeanParam param = (ORDR0104IBeanParam) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(buyerOrderDao);
        blackboard.putBaseDao(buyerBatchOrderDetailDao);
        blackboard.putBaseDao(buyerSellerDetailDao);
        blackboard.putBaseDao(buyerOrderAttachedDao);
        blackboard.putBaseDao(buyerBatchOrderDetailAttachedDao);

        // 操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取买家订单
        BuyerOrder buyerOrder = param.getBuyerOrder();
        buyerOrder.setBlackboard(blackboard);
        // 验证订单状态
        buyerOrder.complete(false);

        if (!buyerOrder.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010401, param.getBuyerOrderId() + "");
        } else {
            String orderStu = buyerOrder.getEntity().getBuyerOrderStu();
            if (!BuyerOrderStu.IN_CONFIRMATION.getCode().equals(orderStu)) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010402, param.getBuyerOrderId() + "");
            }
        }
        // 返回参数
        map.put("buyerOrder", buyerOrder);
        // 获取完整操作者
        operator.complete(false);

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

        // 确认订单
        buyerOrder.getEntity().setBuyerOrderStu(BuyerOrderStu.CONFIRMED.getCode());
        buyerOrder.modify();

        // 组装参数
        ArrayList<StockRestParam> paramList = new ArrayList<>();
        List<BuyerBatchOrderDetail> detailList = buyerOrder.getBuyerBatchOrderDetails();
        for (BuyerBatchOrderDetail detail : detailList) {
            if (detail.getEntity().getTransactionSequence() == 0) {
                detail.getEntity().setTransactionSequence(NumberConst.IntDef.INT_ONE);
                StockRestParam param = new StockRestParam();
                param.setLogicAreaId(buyerOrder.getEntity().getLogisticsZoneId());
                param.setGoodsId(detail.getEntity().getGoodsId());
                param.setRefNo(buyerOrder.getEntity().getBuyerOrderCode());
                param.setTransactionId(buyerOrder.getEntity().getBuyerOrderId());
                param.setTransactionNo(buyerOrder.getEntity().getBuyerOrderCode());
                param.setTransactionDetailId(detail.getEntity().getBuyerBatchOrderDetailId());
                param.setTransactionSequence(detail.getEntity().getTransactionSequence());
                param.setAllocatedQty(detail.getEntity().getGoodsQuantity());
                param.setTargetId(buyerOrder.getEntity().getBuyerId());
                param.setTargetCode(buyerOrder.getAttachedEntity().getBuyerCode());
                param.setTargetType(OwnerType.Buyer.getCode());
                paramList.add(param);
            }
        }
        BuyerBatchOrderDetailList buyerBatchOrderDetailList = BuyerBatchOrderDetailList
                .build(buyerOrder.getBlackboard())
                .forUpdate(buyerOrder.getBuyerBatchOrderDetails().toArray(new BuyerBatchOrderDetail[0]));
        buyerBatchOrderDetailList.modify();
        // 形成供货明细
        ChooseSellerSide(buyerOrder);
        // 平台商品占用
        boolean exerciseFlg = false;
        if (!paramList.isEmpty()) {
            exerciseFlg = allocateOwCommInv(buyerOrder);
        }

        // 返回参数
        map.put("buyerOrder", buyerOrder);
        map.put("exerciseFlg", exerciseFlg);

    }

    /**
     * 形成供货明细
     * @param buyerOrder
     */
    private void ChooseSellerSide(BuyerOrder buyerOrder) {

        // 订单下所有商品ID的合集
        List<String> goodsIds = new ArrayList<>();

        // 处理订单数据（按商品汇总）
        List<BuyerBatchOrderDetail> buyerBatchOrderDetails = buyerOrder.getBuyerBatchOrderDetails();

        // 按照商品ID，订单明细合集的Map（同一商品组成的List的Map）
        Map<String, List<BuyerBatchOrderDetail>> orderDetailMap = new HashMap<>();

        // 按照商品ID，集计商品数量，形成订单的原始商品Map
        Map<String, ExerciseGoods> orderGoodsQtyMap = new HashMap<>();

        for(BuyerBatchOrderDetail detail : buyerBatchOrderDetails) {
            BuyerBatchOrderDetailEntity detailEntity  = detail.getEntity();
            String goodsId = detailEntity.getGoodsId();
            BigDecimal qty = detailEntity.getGoodsQuantity();
            if (orderGoodsQtyMap.containsKey(goodsId)) {
                ExerciseGoods orderGoods  = orderGoodsQtyMap.get(goodsId);
                BigDecimal goodsQty = orderGoods.getQty().add(qty);
                orderGoods.setQty(goodsQty);

                orderDetailMap.get(goodsId).add(detail);
            } else {
                ExerciseGoods orderGoods = new ExerciseGoods();
                orderGoods.setGoodsId(goodsId);
                orderGoods.setQty(qty);
                orderGoodsQtyMap.put(goodsId, orderGoods);
                goodsIds.add(detailEntity.getGoodsId());

                List<BuyerBatchOrderDetail> detailList = new ArrayList<>();
                detailList.add(detail);
                orderDetailMap.put(goodsId, detailList);
            }
        }

        // 获取商品详细信息（单品ID）
        List<Goods> goodsList = Goods.findByIds(goodsIds, buyerOrder.getEntity().getLogisticsZoneId());
        List<String> itemIds = new ArrayList<>();
        for (Goods goods : goodsList) {
            String itemId = goods.getEntity().getItemId();
            if (!itemIds.contains(itemId)) {
                itemIds.add(itemId);
            }
        }

        // 获取行权商品
        List<Goods> exerciseGoodsIds = Goods.findByItemIds(itemIds);

        // 商品及其行权商品关系合集
        Map<String, List<String>> goodsExerciseGoodsMap = new HashMap<>();
        for (Goods goods : goodsList) {
            String originItemId = goods.getEntity().getItemId();
            String originGoodsId = goods.getEntity().getGoodsId();
            for (Goods exerciseGood : exerciseGoodsIds) {
                String exerciseGoodsId = exerciseGood.getEntity().getGoodsId();
                // 相同的单品，且不是商品本身
                if (originItemId.equals(exerciseGood.getEntity().getItemId()) && !originGoodsId.equals(exerciseGoodsId)) {
                    if (goodsExerciseGoodsMap.containsKey(originGoodsId)) {
                        if (!goodsExerciseGoodsMap.get(originGoodsId).contains(exerciseGoodsId)) {
                            goodsExerciseGoodsMap.get(originGoodsId).add(exerciseGoodsId);
                        }
                    } else {
                        List<String> exerciseGoods = new ArrayList<>();
                        exerciseGoods.add(exerciseGoodsId);
                        goodsExerciseGoodsMap.put(originGoodsId, exerciseGoods);
                    }
                }
            }
        }

        // 根据买家ID获取买手及合伙人
        List<SellerSideEntity> sellerSideList = SellerSide.getSellerSideListByBuyer(buyerOrder.getEntity().getBuyerId());

        List<String> sellerSideIds = new ArrayList<>();
        Map<String, SellerSideEntity> sellerSideMap = new HashMap<>();

        // 存在专属买手时
        if(CollectionUtils.isNotEmpty(sellerSideList)) {
            for(SellerSideEntity sellerSide : sellerSideList) {
                String sellerSideId = sellerSide.getSellerSideId();
                sellerSideIds.add(sellerSideId);
                sellerSideMap.put(sellerSideId, sellerSide);
            }
        }


        // 查询货权人商品货权库存（放在获取平台卖家之前，平台卖家目前认为没有货权库存）
        LINV0113IRestParam param = new LINV0113IRestParam();
        List<String> exerciseGoodsList = getValueListForMap(goodsExerciseGoodsMap);
        exerciseGoodsList.addAll(goodsIds); // 商品本身也可以货权转换为实物
        param.setCommodityId(exerciseGoodsList.toArray(new String[exerciseGoodsList.size()]));
        param.setComoIvType(new String[]{ComoIvType.Virtual.getCode()});
        param.setIvType(new String[]{IvType.Normal.getCode()});
        param.setLogisticsId(new String[]{StringUtils.toStr(buyerOrder.getEntity().getLogisticsZoneId())});
        param.setOwnerId(sellerSideIds.toArray(new String[sellerSideIds.size()]));
        param.setSalePlatform(new String[]{SalePlatformType.YDP.getCode()});
        param.setUom(new String[]{LinvUom.Box.getCode()});

        Map<String, List<Stock>> virtualStockMap = new HashMap<>();
        // 以行权GoodsId为Key的货权库存集合
        if (CollectionUtils.isNotEmpty(sellerSideIds)) {
            virtualStockMap = Stock.getComonInv(param);
        }

        // 获取平台卖家信息（00000001）
        Seller seller = Seller.getSellerByCode(Seller.SELLER_CODE);

        // 将平台卖家信息保存至销售方列表及Map中
        SellerSideEntity sl = new SellerSideEntity();
        String sellerId = StringUtils.toStr(seller.getEntity().getSellerId());
        sl.setSellerSideId(sellerId);
        sl.setSellerSideCode(seller.getEntity().getSellerCode());
        sl.setSellerSideName(seller.getEntity().getSellerName());
        sl.setSellerSideRole(SellSideType.PLATFORM_TYPE.getCode());
        sellerSideIds.add(sellerId);
        sellerSideMap.put(sellerId, sl);
        sellerSideList.add(sl);

        // 查询货权人商品实物库存
        param = new LINV0113IRestParam();
//        List<String> originGoodsList = getKeyListForMap(goodsExerciseGoodsMap);
        param.setCommodityId(goodsIds.toArray(new String[goodsIds.size()]));
        param.setComoIvType(new String[]{ComoIvType.Actual.getCode()});
        param.setIvType(new String[]{IvType.Normal.getCode()});
        param.setLogisticsId(new String[]{StringUtils.toStr(buyerOrder.getEntity().getLogisticsZoneId())});
        param.setOwnerId(sellerSideIds.toArray(new String[sellerSideIds.size()]));
        param.setSalePlatform(new String[]{SalePlatformType.YDP.getCode()});
        param.setUom(new String[]{LinvUom.Box.getCode()});

        // 以原goodsId为Key的实物库存集合
        Map<String, List<Stock>> actualStockMap = Stock.getComonInv(param);

        // 按照商品，货权人库存的集合（实物库存、商品库存）
        Map<String, List<List<Stock>>> forExerciseOwnerStockMap = new HashMap<>();
//        Map<String, List<ExerciseGoods>> exerciseOwnerStockQtyMap = new HashMap<>();
        for (String goodsId : goodsIds) {

            List<Stock> actualStockList = actualStockMap.get(goodsId);
            if (CollectionUtils.isNotEmpty(actualStockList)) {
                for (Stock stock : actualStockList) {
                    // 遵照货权人，库存的集合（实物库存、货权库存）
                    List<Stock> ownerStockList = new ArrayList<>();
                    ownerStockList.add(stock);

                    if (forExerciseOwnerStockMap.containsKey(goodsId)) {
                        forExerciseOwnerStockMap.get(goodsId).add(ownerStockList);
                    } else {
                        List<List<Stock>> ownerStockMapList = new ArrayList<>();
                        ownerStockMapList.add(ownerStockList);
                        forExerciseOwnerStockMap.put(goodsId, ownerStockMapList);
                    }
                }
            }


            // 获取该商品对应的可货权转换的商品ID合集
            List<String> exerciseGoodsIdList = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(goodsExerciseGoodsMap.get(goodsId))){
                exerciseGoodsIdList = goodsExerciseGoodsMap.get(goodsId);
            }
            exerciseGoodsIdList.add(goodsId);

            for (String exerciseGoodsId : exerciseGoodsIdList) {
                if (virtualStockMap == null) {
                    continue;
                }
                List<Stock> virtualStockList = virtualStockMap.get(exerciseGoodsId);
                if (CollectionUtils.isEmpty(virtualStockList)) {
                    continue;
                }
                for (Stock stock : virtualStockList) {
                    String ownerId = stock.getEntity().getOwnerId();
                    Boolean flg = false;
                    // 获取货权人商品库存集合的List
                    List<List<Stock>> ownerStockMapList = forExerciseOwnerStockMap.get(goodsId);
                    for (List<Stock> tmp : ownerStockMapList) {
                        if (tmp.get(0).getEntity().getOwnerId().equals(ownerId)) {
                            tmp.add(stock);// 追加货权库存
                            flg = true;// 已经存在这个货权人
                        }
                    }
                    if (!flg) {
                        // 该货权人不存在时，向货权人商品库存集合的List添加货权人商品库存集合
                        List<Stock> ownerStockList = new ArrayList<>();
                        ownerStockList.add(stock);
                        ownerStockMapList.add(ownerStockList);
                    }
                }
            }
        }

        // 判断库存且形成供货明细
        List<BuyerSellerDetail> buyerSellerDetails = new ArrayList<>();
        for (String goodsId : goodsIds) {
            List<List<Stock>> forExerciseOwnerStockList = forExerciseOwnerStockMap.get(goodsId);
            // 排序（买手优先）
            if (CollectionUtils.isEmpty(forExerciseOwnerStockList)) {
                // 所有货权人库存均不满足，确认失败
                throw new BusinessException(ErrorCode.E010403, buyerOrder.getEntity().getBuyerId().toString());
            }
            if (forExerciseOwnerStockList.get(0).get(0).getEntity().getOwnerId().equals(sellerId)){
                Collections.reverse(forExerciseOwnerStockList);
            }
            List<BuyerSellerDetail> sellerDetails = null;
            for (List<Stock> stockList : forExerciseOwnerStockList) {
                String ownerId = stockList.get(0).getEntity().getOwnerId();
                BigDecimal originalQty = orderGoodsQtyMap.get(goodsId).getQty(); // 商品的下单数量（每个货权人判断时，初始化一次）
                BigDecimal actualAvailableQty  = BigDecimal.ZERO;
                BigDecimal virtualAvailableQty  = BigDecimal.ZERO;
                Stock actualAvailableStock = null;
                List<Stock> virtualAvailableStockList = new ArrayList<>();
                for (Stock stock : stockList) {
                    BigDecimal stockQty = stock.getEntity().getAvailableQty();// 可用库存
                    String comoIvType = stock.getEntity().getComoIvType(); // 库存类型
                    if (ComoIvType.Actual.getCode().equals(comoIvType)){
                        actualAvailableQty = actualAvailableQty.add(stockQty);
                        actualAvailableStock = stock;
                    }
                    if (ComoIvType.Virtual.getCode().equals(comoIvType)){
                        virtualAvailableQty = virtualAvailableQty.add(stockQty);
                        virtualAvailableStockList.add(stock);
                    }
                }

                BigDecimal availableQty  = actualAvailableQty.add(virtualAvailableQty);
                if (originalQty.compareTo(availableQty) > 0) {
                    // 库存不足
                    continue;
                }

                if (originalQty.compareTo(actualAvailableQty) <= 0) {
                    // 实物库存满足，全部使用实物库存
                    sellerDetails = createBuyerSellerDetail(buyerOrder, orderDetailMap.get(goodsId), sellerSideMap, actualAvailableStock, null, seller, ownerId);
                } else {
                    // 实物库存不满足,部分使用实物,部分使用货权
                    sellerDetails = createBuyerSellerDetail(buyerOrder, orderDetailMap.get(goodsId), sellerSideMap, actualAvailableStock, virtualAvailableStockList, seller, ownerId);
                }

                if (CollectionUtils.isNotEmpty(sellerDetails)) {
                    break;
                }
            }

            if (CollectionUtils.isEmpty(sellerDetails)) {
                // 所有货权人库存均不满足，确认失败
                throw new BusinessException(ErrorCode.E010403, buyerOrder.getEntity().getBuyerId().toString());
            } else {
                buyerSellerDetails.addAll(sellerDetails);// 所有商品的供货明细集合
            }
        }

        BuyerSellerDetailList buyerSellerDetailList = BuyerSellerDetailList.build(buyerOrder.getBlackboard())
                .forCreate(buyerSellerDetails.toArray(new BuyerSellerDetail[0]));
        buyerSellerDetailList.create();

    }

    /**
     * 生成货权供货关系数据
     * @param buyerOrder
     * @param buyerBatchOrderDetails
     * @param sellerSideMap
     * @param actualAvailableStock
     * @param virtualAvailableStockList
     * @param seller
     * @return
     */
    public List<BuyerSellerDetail> createBuyerSellerDetail(BuyerOrder buyerOrder, List<BuyerBatchOrderDetail> buyerBatchOrderDetails
            , Map<String, SellerSideEntity> sellerSideMap, Stock actualAvailableStock, List<Stock> virtualAvailableStockList, Seller seller, String ownerId) {

        List<BuyerSellerDetail> buyerSellerDetailList = new ArrayList<>();

        if (CollectionUtils.isEmpty(virtualAvailableStockList)) {
            for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerBatchOrderDetails) {
                BuyerSellerDetail buyerSellerDetail = buyerOrder.generateBuyerSellerDetail();
                buyerSellerDetail.setBlackboard(buyerOrder.getBlackboard());
                BuyerSellerDetailEntity buyerSellerDetailEntity = buyerSellerDetail.getEntity();
                buyerSellerDetailEntity.setBuyerBatchOrderDetailId(buyerBatchOrderDetail.getEntity().getBuyerBatchOrderDetailId());
                buyerSellerDetailEntity.setSellerId(seller.getEntity().getSellerId());
                buyerSellerDetailEntity.setSellerCode(seller.getEntity().getSellerCode());
                buyerSellerDetailEntity.setSellSideId(ownerId);
                buyerSellerDetailEntity.setSellSideType(sellerSideMap.get(ownerId).getSellerSideRole());
                buyerSellerDetailEntity.setComoIvType(ComoIvType.Actual.getCode());
                buyerSellerDetailEntity.setAllocateGoodsId(NumberUtils.createLong(actualAvailableStock.getEntity().getGoodsId()));
                buyerSellerDetailEntity.setSellQty(buyerBatchOrderDetail.getEntity().getGoodsQuantity());

                buyerSellerDetailList.add(buyerSellerDetail);

                logger.debug("buyerSellerDetailId:" + buyerSellerDetailEntity.getSellerDetailId() + "sellerId:" + buyerSellerDetailEntity.getSellerId() +
                        "sellerCode:" + buyerSellerDetailEntity.getSellerCode() + "sellerSideId:" + buyerSellerDetailEntity.getSellSideId() + "sellerSideType:" +
                        buyerSellerDetailEntity.getSellSideType() + "comoIvType:" + buyerSellerDetailEntity.getComoIvType() + "qty:" + buyerSellerDetailEntity.getSellQty() +
                        "allocateGoodsId" + buyerSellerDetailEntity.getAllocateGoodsId());
            }
        } else {
            BigDecimal actualAvailableQty = BigDecimal.ZERO;

            if (actualAvailableStock != null && actualAvailableStock.getEntity() != null && (actualAvailableStock.getEntity().getAvailableQty().compareTo(BigDecimal.ZERO) > 0)) {
                actualAvailableQty = actualAvailableStock.getEntity().getAvailableQty();
            }

            for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerBatchOrderDetails) {
                BigDecimal buyerBatchDetailQty = buyerBatchOrderDetail.getEntity().getGoodsQuantity();
                BigDecimal tmpActualAvailableQty = actualAvailableQty.subtract(buyerBatchDetailQty);
                if (tmpActualAvailableQty.compareTo(BigDecimal.ZERO) >= 0) {
                    // 实物库存满足明细数量
                    BuyerSellerDetail buyerSellerDetail = buyerOrder.generateBuyerSellerDetail();
                    buyerSellerDetail.setBlackboard(buyerOrder.getBlackboard());
                    BuyerSellerDetailEntity buyerSellerDetailEntity = buyerSellerDetail.getEntity();
                    buyerSellerDetailEntity.setBuyerBatchOrderDetailId(buyerBatchOrderDetail.getEntity().getBuyerBatchOrderDetailId());
                    buyerSellerDetailEntity.setSellerId(seller.getEntity().getSellerId());
                    buyerSellerDetailEntity.setSellerCode(seller.getEntity().getSellerCode());
                    buyerSellerDetailEntity.setSellSideId(ownerId);
                    buyerSellerDetailEntity.setSellSideType(sellerSideMap.get(ownerId).getSellerSideRole());
                    buyerSellerDetailEntity.setComoIvType(ComoIvType.Actual.getCode());
                    buyerSellerDetailEntity.setAllocateGoodsId(NumberUtils.createLong(actualAvailableStock.getEntity().getGoodsId()));
                    buyerSellerDetailEntity.setSellQty(buyerBatchDetailQty);
                    actualAvailableStock.getEntity().setAvailableQty(tmpActualAvailableQty);// 一条明细扣减一次数量

                    buyerSellerDetailList.add(buyerSellerDetail);

                    logger.debug("buyerSellerDetailId:" + buyerSellerDetailEntity.getSellerDetailId() + "sellerId:" + buyerSellerDetailEntity.getSellerId() +
                            "sellerCode:" + buyerSellerDetailEntity.getSellerCode() + "sellerSideId:" + buyerSellerDetailEntity.getSellSideId() + "sellerSideType:" +
                            buyerSellerDetailEntity.getSellSideType() + "comoIvType:" + buyerSellerDetailEntity.getComoIvType() + "qty:" + buyerSellerDetailEntity.getSellQty() +
                            "allocateGoodsId" + buyerSellerDetailEntity.getAllocateGoodsId());
                } else {
                    BigDecimal tmpBuyerBatchDetailQty = buyerBatchDetailQty;
                    // 实物库存不满足明细数量
                    if (actualAvailableQty.compareTo(BigDecimal.ZERO) > 0) {
                        // 有实物库存
                        BuyerSellerDetail buyerSellerDetail = buyerOrder.generateBuyerSellerDetail();
                        buyerSellerDetail.setBlackboard(buyerOrder.getBlackboard());
                        BuyerSellerDetailEntity buyerSellerDetailEntity = buyerSellerDetail.getEntity();
                        buyerSellerDetailEntity.setBuyerBatchOrderDetailId(buyerBatchOrderDetail.getEntity().getBuyerBatchOrderDetailId());
                        buyerSellerDetailEntity.setSellerId(seller.getEntity().getSellerId());
                        buyerSellerDetailEntity.setSellerCode(seller.getEntity().getSellerCode());
                        buyerSellerDetailEntity.setSellSideId(ownerId);
                        buyerSellerDetailEntity.setSellSideType(sellerSideMap.get(ownerId).getSellerSideRole());
                        buyerSellerDetailEntity.setComoIvType(ComoIvType.Actual.getCode());
                        buyerSellerDetailEntity.setAllocateGoodsId(NumberUtils.createLong(actualAvailableStock.getEntity().getGoodsId()));
                        buyerSellerDetailEntity.setSellQty(actualAvailableQty);
                        actualAvailableStock.getEntity().setAvailableQty(BigDecimal.ZERO);// 一条明细扣减一次数量
                        tmpBuyerBatchDetailQty = buyerBatchDetailQty.subtract(actualAvailableQty);

                        buyerSellerDetailList.add(buyerSellerDetail);

                        logger.debug("buyerSellerDetailId:" + buyerSellerDetailEntity.getSellerDetailId() + "sellerId:" + buyerSellerDetailEntity.getSellerId() +
                                "sellerCode:" + buyerSellerDetailEntity.getSellerCode() + "sellerSideId:" + buyerSellerDetailEntity.getSellSideId() + "sellerSideType:" +
                                buyerSellerDetailEntity.getSellSideType() + "comoIvType:" + buyerSellerDetailEntity.getComoIvType() + "qty:" + buyerSellerDetailEntity.getSellQty() +
                                "allocateGoodsId" + buyerSellerDetailEntity.getAllocateGoodsId());
                    }

                    // 无实物库存
                    for (Stock stock : virtualAvailableStockList) {
                        if (stock.getEntity().getAvailableQty().compareTo(BigDecimal.ZERO)<=0){
                            continue;
                        }
                        BigDecimal virtualAvailableQty = stock.getEntity().getAvailableQty();
                        if (tmpBuyerBatchDetailQty.compareTo(BigDecimal.ZERO) > 0) { // 明细未全部指定完成
                            // 设置货权库存
                            BuyerSellerDetail buyerSellerDetail = buyerOrder.generateBuyerSellerDetail();
                            buyerSellerDetail.setBlackboard(buyerOrder.getBlackboard());
                            BuyerSellerDetailEntity buyerSellerDetailEntity = buyerSellerDetail.getEntity();
                            buyerSellerDetailEntity.setBuyerBatchOrderDetailId(buyerBatchOrderDetail.getEntity().getBuyerBatchOrderDetailId());
                            buyerSellerDetailEntity.setSellerId(seller.getEntity().getSellerId());
                            buyerSellerDetailEntity.setSellerCode(seller.getEntity().getSellerCode());
                            buyerSellerDetailEntity.setSellSideId(ownerId);
                            buyerSellerDetailEntity.setSellSideType(sellerSideMap.get(ownerId).getSellerSideRole());
                            buyerSellerDetailEntity.setComoIvType(ComoIvType.Virtual.getCode());
                            buyerSellerDetailEntity.setAllocateGoodsId(NumberUtils.createLong(stock.getEntity().getGoodsId()));//货权商品ID

                            if (virtualAvailableQty.compareTo(tmpBuyerBatchDetailQty) >= 0) {
                                // 当前货权库存 >= 明细需扣减库存
                                buyerSellerDetailEntity.setSellQty(tmpBuyerBatchDetailQty);
                                virtualAvailableQty = virtualAvailableQty.subtract(tmpBuyerBatchDetailQty);
                                stock.getEntity().setAvailableQty(virtualAvailableQty);// 一条明细扣减一次数量
                                tmpBuyerBatchDetailQty = BigDecimal.ZERO;
                            } else {
                                // 当前货权库存 < 明细需扣减库存
                                buyerSellerDetailEntity.setSellQty(virtualAvailableQty);
                                stock.getEntity().setAvailableQty(BigDecimal.ZERO);// 一条明细扣减一次数量
                                tmpBuyerBatchDetailQty = tmpBuyerBatchDetailQty.subtract(virtualAvailableQty);
                            }

                            buyerSellerDetailList.add(buyerSellerDetail);

                            logger.debug("buyerSellerDetailId:" + buyerSellerDetailEntity.getSellerDetailId() + "sellerId:" + buyerSellerDetailEntity.getSellerId() +
                                    "sellerCode:" + buyerSellerDetailEntity.getSellerCode() + "sellerSideId:" + buyerSellerDetailEntity.getSellSideId() + "sellerSideType:" +
                                    buyerSellerDetailEntity.getSellSideType() + "comoIvType:" + buyerSellerDetailEntity.getComoIvType() + "qty:" + buyerSellerDetailEntity.getSellQty() +
                                    "allocateGoodsId" + buyerSellerDetailEntity.getAllocateGoodsId());
                        }
                    }
                }
            }
        }
        return  buyerSellerDetailList;
    }

    public List<String> getKeyListForMap(Map<String, List<String>> map) {
        Set<String> keySet = new HashSet<String>();
        keySet.addAll(map.keySet());
        List<String> keyList = new ArrayList<String>();
        keyList.addAll(keySet);

        return keyList;
    }

    public List<String> getValueListForMap(Map<String, List<String>> map) {
        List<String> value = new ArrayList<String>();
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next().toString();
            value.addAll(map.get(key));
        }
        return value;
    }

    /**
     * 针对货权销售的部分，为买手占用相应的平台实物库存，且为行权占用对应的买手货权库存
     * @param buyerOrder
     */
    public boolean allocateOwCommInv(BuyerOrder buyerOrder) {

        boolean exerciseFlg = false;

        ArrayList<LinvRestParam> paramList = new ArrayList<>();

        // 获取平台卖家信息（00000001）
        Seller seller = Seller.getSellerByCode(Seller.SELLER_CODE);

        // 根据买家ID获取买手及合伙人
        List<SellerSideEntity> sellerSideList = SellerSide.getSellerSideListByBuyer(buyerOrder.getEntity().getBuyerId());

        BuyerOrder order = BuyerOrder.build(buyerOrder.getBlackboard())
                .forComplete(buyerOrder.getEntity().getBuyerOrderId());
        order.complete(false);

        for (BuyerBatchOrderDetail detail : order.getBuyerBatchOrderDetails()) {
            String oldGoodsId = detail.getEntity().getGoodsId();
            List<BuyerSellerDetail> goodsBuyerSellerDetails = detail.getBuyerSellerDetails();

            if (CollectionUtils.isEmpty(goodsBuyerSellerDetails))
                continue;

            for (BuyerSellerDetail buyerSellerDetail : goodsBuyerSellerDetails) {
                if (ComoIvType.Actual.getCode().equals(buyerSellerDetail.getEntity().getComoIvType())) {
                    // 实物销售，在此处不占用库存，在所有操作结束后，按照分批订单明细进行商品库存的占用
                    continue;
                }

                // 货权库存，占用买手货权库存，占用对应的平台实物库存
                exerciseFlg = true;// 需要行权
                LinvRestParam param = new LinvRestParam();
                param.setLogicAreaId(buyerOrder.getEntity().getLogisticsZoneId());
                String sellSideId = buyerSellerDetail.getEntity().getSellSideId();
                param.setOwnerId(sellSideId);
                // 设定编码
                if (StringUtils.toString(seller.getEntity().getSellerId()).equals(sellSideId)) {
                    param.setOwnerCode(Seller.SELLER_CODE);
                    param.setOwnerType(OwnerType.Seller.getCode());
                    param.setBizType(BizType.SellerSale.getCode());
                } else {
                    for (SellerSideEntity sellerSide : sellerSideList) {
                        if (sellSideId.equals(sellerSide.getSellerSideId())) {
                            param.setOwnerCode(sellerSide.getSellerSideCode());
                            param.setOwnerType(OwnerType.Agent.getCode());
                        }
                    }

                    if (ComoIvType.Actual.getCode().equals(buyerSellerDetail.getEntity().getComoIvType())) {
                        param.setBizType(BizType.AgentSale.getCode()); // 实物，买手销售
                    } else if (ComoIvType.Virtual.getCode().equals(buyerSellerDetail.getEntity().getComoIvType())) {
                        param.setBizType(BizType.Virtual2Actual.getCode()); // 货权，行权
                    }
                }

                param.setComoIvType(ComoIvType.Virtual.getCode());
                param.setTargetId(StringUtils.toString(seller.getEntity().getSellerId()));
                param.setTargetCode(Seller.SELLER_CODE);
                param.setTargetType(OwnerType.Seller.getCode());

                param.setCommodityId(buyerSellerDetail.getEntity().getAllocateGoodsId().toString());
                param.setRefNo(buyerOrder.getEntity().getBuyerOrderCode());
                param.setTransactionId(buyerOrder.getEntity().getBuyerOrderId());
                param.setTransactionNo(buyerOrder.getEntity().getBuyerOrderCode());
                param.setTransactionDetailId(buyerSellerDetail.getEntity().getSellerDetailId());
                param.setTransactionSequence(NumberConst.IntDef.INT_ONE);//初次占用传1
                param.setAllocatedQty(buyerSellerDetail.getEntity().getSellQty());

                paramList.add(param);

                // 占用平台实物库存数据整理
                allocatePlateFormComoInv(paramList, buyerOrder, buyerSellerDetail, seller, param.getOwnerCode(), oldGoodsId);
            }

        }

        if (CollectionUtils.isNotEmpty(paramList)) {
            Stock.AllocateOwCommInv(paramList);
        }

        return exerciseFlg;
    }

    /**
     * 组装平台商品实物库存占用数据
     * @param paramList
     * @param buyerOrder
     * @param buyerSellerDetail
     */
    public void allocatePlateFormComoInv(List<LinvRestParam> paramList, BuyerOrder buyerOrder, BuyerSellerDetail buyerSellerDetail, Seller seller, String ownerCode, String oldGoodsId) {

        LinvRestParam param = new LinvRestParam();
        param.setLogicAreaId(buyerOrder.getEntity().getLogisticsZoneId());

        // 设定平台卖家ID
            param.setOwnerId(seller.getEntity().getSellerId().toString());
        // 设定平台卖家编码
        param.setOwnerCode(seller.getEntity().getSellerCode());
        param.setOwnerType(OwnerType.Seller.getCode());
        param.setCommodityId(oldGoodsId);
        param.setComoIvType(ComoIvType.Actual.getCode());
        param.setBizType(BizType.Virtual2Actual.getCode()); // 行权
        param.setRefNo(buyerOrder.getEntity().getBuyerOrderCode());
        param.setTransactionId(buyerOrder.getEntity().getBuyerOrderId());
        param.setTransactionNo(buyerOrder.getEntity().getBuyerOrderCode());
        param.setTransactionDetailId(buyerSellerDetail.getEntity().getSellerDetailId());
        param.setTransactionSequence(NumberConst.IntDef.INT_ONE);//初次占用传1
        param.setAllocatedQty(buyerSellerDetail.getEntity().getSellQty());
        // 设定买手、合伙人ID
        param.setTargetId(buyerSellerDetail.getEntity().getSellSideId());
        // 设定买手、合伙人编码
        param.setTargetCode(ownerCode);
        param.setTargetType(OwnerType.Agent.getCode());
        paramList.add(param);

    }

    /**
     * 收尾
     *
     * @param map
     *            HashMap
     */
    private void post(HashMap<String, Object> map) {

        ORDR0104IBeanParam param = (ORDR0104IBeanParam)map.get("param");
        Blackboard blackboard = (Blackboard)map.get("blackboard");
        BuyerOrder buyerOrder = (BuyerOrder)map.get("buyerOrder");

        // 行权
        ORDR1001IBeanParam exerciseBean = new ORDR1001IBeanParam();
        exerciseBean.setBuyerOrderId(param.getBuyerOrderId());
        Operator exerciseOperator = blackboard.getOperator();

        boolean exerciseFlg = (boolean)map.get("exerciseFlg");
        if (exerciseFlg) {
            exerciseService.execute(exerciseOperator, exerciseBean);
        }

        // 为买家占用实物库存（以分批订单明细为单位）
        allocateInv(buyerOrder);
    }

    /**
     * 为买家占用实物库存（以分批订单明细为单位）
     * @param buyerOrder
     */
    private void allocateInv (BuyerOrder buyerOrder) {

        // 根据买家ID获取买手及合伙人
        List<SellerSideEntity> sellerSideList = SellerSide.getSellerSideListByBuyer(buyerOrder.getEntity().getBuyerId());

        ArrayList<LinvRestParam> allocateParams = new ArrayList<>();

        Long logisticsZoneId = buyerOrder.getEntity().getLogisticsZoneId();
        String buyerId = buyerOrder.getEntity().getBuyerId();
        String buyerName = buyerOrder.getAttachedEntity().getBuyerName();
        String buyerCode = buyerOrder.getAttachedEntity().getBuyerCode();

        List<BuyerBatchOrderDetail> buyerBatchOrderDetails = buyerOrder.getBuyerBatchOrderDetails();
        if (CollectionUtils.isEmpty(buyerBatchOrderDetails)) {
            throw new BusinessException(ErrorCode.E000002, "该订单下没有分批订单明细");
        }

        for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerBatchOrderDetails) {
            List<BuyerSellerDetail> buyerSellerDetails =  buyerBatchOrderDetail.getBuyerSellerDetails();
            if (CollectionUtils.isEmpty(buyerSellerDetails)) {
                throw new BusinessException(ErrorCode.E000002, "该分批订单下没有供货明细");
            }

            String sellSideId = buyerSellerDetails.get(0).getEntity().getSellSideId();
            String sellSideCode = null;
            String ownerType = OwnerType.Agent.getCode();
            String bizType = BizType.AgentSale.getCode();
            for (SellerSideEntity sellerSide : sellerSideList) {
                if (sellSideId.equals(sellerSide.getSellerSideId())) {
                    sellSideCode = sellerSide.getSellerSideCode();
                }
            }
            if (StringUtils.isEmpty(sellSideCode)){
                sellSideCode = Seller.SELLER_CODE;
                ownerType = OwnerType.Seller.getCode();
                bizType = BizType.SellerSale.getCode();
            }

            // 为买家占用买手的货权人商品实物库存
            LinvRestParam allocateRestParam = new LinvRestParam();
            allocateRestParam.setLogicAreaId(logisticsZoneId);
            allocateRestParam.setOwnerId(sellSideId);
            allocateRestParam.setOwnerCode(sellSideCode);
            allocateRestParam.setOwnerType(ownerType);
            allocateRestParam.setCommodityId(buyerBatchOrderDetail.getEntity().getGoodsId());
            allocateRestParam.setComoIvType(ComoIvType.Actual.getCode());
            allocateRestParam.setRefNo(buyerOrder.getEntity().getBuyerOrderCode());
            allocateRestParam.setTransactionId(buyerOrder.getEntity().getBuyerOrderId());
            allocateRestParam.setTransactionNo(buyerOrder.getEntity().getBuyerOrderCode());
            allocateRestParam.setTransactionDetailId(buyerBatchOrderDetail.getEntity().getBuyerBatchOrderDetailId());
            allocateRestParam.setTransactionSequence(NumberUtils.INTEGER_ONE);

            allocateRestParam.setTargetId(buyerId);
            allocateRestParam.setTargetName(buyerName);
            allocateRestParam.setTargetCode(buyerCode);
            allocateRestParam.setTargetType(OwnerType.Buyer.getCode());
            allocateRestParam.setAllocatedQty(buyerBatchOrderDetail.getEntity().getGoodsQuantity());
            allocateRestParam.setBizType(bizType);
            allocateParams.add(allocateRestParam);
        }
        Stock.AllocateOwCommInv(allocateParams);
    }
}
