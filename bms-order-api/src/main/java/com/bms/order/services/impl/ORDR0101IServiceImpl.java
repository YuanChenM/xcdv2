package com.bms.order.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bms.order.external.archive.Logistics;
import com.bms.order.external.bean.result.REGN0102IRestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.order.archive.impl.BuyerBatchOrder;
import com.bms.order.archive.impl.BuyerBatchOrderDetail;
import com.bms.order.archive.impl.BuyerOrder;
import com.bms.order.archive.impl.Operator;
import com.bms.order.archive.impl.list.BuyerBatchOrderDetailList;
import com.bms.order.archive.impl.list.BuyerBatchOrderList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.param.ORDR0101IBeanParam;
import com.bms.order.constant.OrderConst;
import com.bms.order.constant.enumeration.BuyerBatchOrderStu;
import com.bms.order.constant.enumeration.BuyerOrderStu;
import com.bms.order.constant.enumeration.BuyerOrderType;
import com.bms.order.constant.enumeration.GoodsUnit;
import com.bms.order.constant.enumeration.OperatorType;
import com.bms.order.constant.enumeration.OrderPlaceType;
import com.bms.order.constant.enumeration.OrderPlacerType;
import com.bms.order.constant.enumeration.OrderSplitType;
import com.bms.order.constant.enumeration.PaymentStu;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BuyerBatchOrderAttachedDao;
import com.bms.order.dao.BuyerBatchOrderDao;
import com.bms.order.dao.BuyerBatchOrderDetailAttachedDao;
import com.bms.order.dao.BuyerBatchOrderDetailDao;
import com.bms.order.dao.BuyerOrderAttachedDao;
import com.bms.order.dao.BuyerOrderDao;
import com.bms.order.external.archive.Buyer;
import com.bms.order.external.archive.Goods;
import com.bms.order.services.ORDR0101IService;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.DecimalUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;

/**
 * 买家订单创建接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0101IServiceImpl implements ORDR0101IService {

    public static final Logger logger = LoggerFactory.getLogger(ORDR0101IServiceImpl.class);
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
    private BuyerBatchOrderDetailDao buyerBatchOrderDetailDao;

    @Autowired
    private BuyerBatchOrderDetailAttachedDao buyerBatchOrderDetailAttachedDao;

    /**
     * A类、B类的标准订单和分批订单创建
     *
     * @param operator
     *            操作者
     */
    @Override
    public Long execute(Operator operator, ORDR0101IBeanParam bean) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        blackboard.setOperator(operator);
        map.put("bean", bean);
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
        ORDR0101IBeanParam param = (ORDR0101IBeanParam) map.get("bean");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(buyerOrderDao);
        blackboard.putBaseDao(buyerOrderAttachedDao);

        blackboard.putBaseDao(buyerBatchOrderDao);
        blackboard.putBaseDao(buyerBatchOrderAttachedDao);

        blackboard.putBaseDao(buyerBatchOrderDetailDao);
        blackboard.putBaseDao(buyerBatchOrderDetailAttachedDao);

        // 操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);

        // 获取买家订单
        BuyerOrder buyerOrder = param.generateBuyerOrder();
        buyerOrder.setBlackboard(blackboard);
        // 获取买家分批订单
        List<BuyerBatchOrder> buyerBatchOrderList = buyerOrder.getBuyerBatchOrders();
        for (BuyerBatchOrder buyerBatchOrder : buyerBatchOrderList) {
            buyerBatchOrder.setBlackboard(blackboard);
            String deliveryAreaCode = Buyer.getDeliveryAreaCode(buyerOrder.getEntity().getBuyerId(), buyerBatchOrder.getAttachedEntity());
            buyerBatchOrder.getAttachedEntity().setDeliveryAreaCode(deliveryAreaCode);
            // 获取买家分批订单明细
            List<BuyerBatchOrderDetail> detailList = buyerBatchOrder.getBuyerBatchOrderDetails();
            for (BuyerBatchOrderDetail batchOrderDetail : detailList) {
                batchOrderDetail.setBlackboard(blackboard);
            }
        }

        // 获取买家信息
        Buyer buyer = Buyer.findById(buyerOrder.getEntity().getBuyerId());
        if (buyer == null)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010106, buyerOrder.getEntity().getBuyerId());

        // 数据权限验证
        checkDataAuthority(operator, buyerOrder, buyer);

        // 验证下单员类型
        checkOrderPlacer(buyerOrder);

        // 是否可以使用账期的验证
        checkNetUse(buyerOrder, buyer);

        if (!StringUtils.isEmpty(param.getBackNo())){
            // 校验backNo是否重复
            BuyerOrder buyerOrderBackNo = param.generateBuyerOrderByBackNo();
            buyerOrderBackNo.setBlackboard(blackboard);
            buyerOrderBackNo.complete(false);
            if (buyerOrderBackNo.isDataSynced()) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010108);
            }
        }

        // 返回参数
        map.put("buyerOrder", buyerOrder);
        map.put("buyer", buyer);
    }

    /**
     * 数据权限验证
     *
     * @param operator
     * @param buyerOrder
     */
    private void checkDataAuthority(Operator operator, BuyerOrder buyerOrder, Buyer buyer) {
        if (OperatorType.BUYER.getCode().equals(operator.getOperatorType())) {
            // 买家：创建自己的买家订单
            if (!operator.getOperatorId().equals(buyerOrder.getEntity().getBuyerId())) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010101);
            }
        } else if (OperatorType.SA.getCode().equals(operator.getOperatorType())) {
            // 管家：带下自己管理的买家的订单
            // 判断买家的管家是否为操作人
            if (!operator.getOperatorId().equals(buyer.getEntity().getSaId())) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010102);
            }
        } else if (OperatorType.MANAGER.getCode().equals(operator.getOperatorType())) {
            // 平台管理人员可以代下所有买家的订单
        } else {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000001,
                    OperatorType.findName(operator.getOperatorType()));
        }
    }

    /**
     * 验证是否可以使用账期
     *
     * @param buyerOrder
     */
    private void checkNetUse(BuyerOrder buyerOrder, Buyer buyer) {
        // 是否是账期买家，买家模块的数据可能为空
        boolean netBuyerFlg = buyer.getEntity().getNetBuyerFlg() == null ? false : buyer.getEntity().getNetBuyerFlg();

        // 只有账期买家才能使用账期
        if (buyerOrder.getEntity().getUseNetFlg() && !netBuyerFlg) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010103);
        }
        buyerOrder.getEntity().setNetBuyerFlg(buyer.getEntity().getNetBuyerFlg());
    }

    /**
     * 验证下单员类型
     *
     * @param buyerOrder
     */
    private void checkOrderPlacer(BuyerOrder buyerOrder) {
        // 下单员仅能为 买家、管家、平台人员
        OrderPlacerType orderPlacerType = OrderPlacerType.getInstance(buyerOrder.getEntity().getOrderPlacerType());
        if (orderPlacerType != OrderPlacerType.BUYER && orderPlacerType != OrderPlacerType.SA
                && orderPlacerType != OrderPlacerType.MANAGER) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010104);
        }
    }

    /**
     * 执行
     *
     * @param map
     *            HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取买家订单
        BuyerOrder buyerOrder = (BuyerOrder) map.get("buyerOrder");
        Buyer buyer = (Buyer) map.get("buyer");
        ORDR0101IBeanParam param = (ORDR0101IBeanParam) map.get("bean");
        if (!StringUtils.isEmpty(param.getLgcsAreaCode())){
            REGN0102IRestResult regn0102IRestResult = Logistics.findLogisticsByCode(param.getLgcsAreaCode());
            buyerOrder.getEntity().setLogisticsZoneId(regn0102IRestResult.getLgcsAreaId());
            buyerOrder.getAttachedEntity().setLogisticsZoneCode(regn0102IRestResult.getLgcsAreaCode());
            buyerOrder.getAttachedEntity().setLogisticsZoneName(regn0102IRestResult.getLgcsAreaName());
        } else {
            buyerOrder.getEntity().setLogisticsZoneId(buyer.getEntity().getLogisticsZoneId());
            buyerOrder.getAttachedEntity().setLogisticsZoneCode(buyer.getEntity().getLogisticsZoneCode());
            buyerOrder.getAttachedEntity().setLogisticsZoneName(buyer.getEntity().getLogisticsZoneName());
        }
        buyerOrder.getEntity().setFrequenterLevelCode(buyer.getEntity().getFrequenterLevelCode());

        // 更新价格创建时间
        updatePriceCreateTime(buyerOrder);
        if (StringUtils.isEmpty(param.getLgcsAreaCode())){
            // 更新所有商品价格信息
            buyerOrder.updateGoodsPrice();
        }
        // 给买家订单设值
        completeBuyerOrder(buyerOrder, buyer);
        // 给分批订单设置值
        completeBuyerBatchOrder(buyerOrder);
        // 给分批订单明细设置值
        completeBuyerBatchOrderDetail(buyerOrder);
        // 插入买家订单表
        buyerOrder.create();

        // 插入分批订单表
        for (BuyerBatchOrder buyerBatchOrder : buyerOrder.getBuyerBatchOrders()) {
            buyerBatchOrder.getEntity().setBuyerOrderId(buyerOrder.getEntity().getBuyerOrderId());
        }
        BuyerBatchOrderList buyerBatchOrderList = BuyerBatchOrderList.build(buyerOrder.getBlackboard())
                .forCreate(buyerOrder.getBuyerBatchOrders().toArray(new BuyerBatchOrder[0]));
        buyerBatchOrderList.create();

        // 插入分批订单明细表
        for (BuyerBatchOrder buyerBatchOrder : buyerOrder.getBuyerBatchOrders()) {
            for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerBatchOrder.getBuyerBatchOrderDetails()) {
                buyerBatchOrderDetail.getEntity().setBuyerOrderId(buyerOrder.getEntity().getBuyerOrderId());
                buyerBatchOrderDetail.getEntity()
                        .setBuyerBatchOrderId(buyerBatchOrder.getEntity().getBuyerBatchOrderId());
                buyerBatchOrderDetail.getEntity().setTransactionSequence(NumberConst.IntDef.INT_ZERO);
                buyerBatchOrderDetail.getEntity().setManualSplitFlg(false);
            }
        }
        BuyerBatchOrderDetailList buyerBatchOrderDetailList = BuyerBatchOrderDetailList
                .build(buyerOrder.getBlackboard())
                .forCreate(buyerOrder.getBuyerBatchOrderDetails().toArray(new BuyerBatchOrderDetail[0]));
        buyerBatchOrderDetailList.create();
    }

    /**
     * 更新价格创建时间
     * 
     * @param buyerOrder
     */
    private void updatePriceCreateTime(BuyerOrder buyerOrder) {
        for (BuyerBatchOrderDetail detail : buyerOrder.getBuyerBatchOrderDetails()) {
            detail.getEntity().setPriceCreateTime(DateUtils.getCurrent());
        }
    }

    /**
     * 补充买家订单信息
     *
     * @param buyerOrder
     */
    private void completeBuyerOrder(BuyerOrder buyerOrder, Buyer buyer) {
        // 查询买家及其买手、管家信息
        // 设置买家信息
        buyerOrder.getEntity().setBuyerType(buyer.getEntity().getBuyerType());
        buyerOrder.getEntity().setBuyerTypeName(buyer.getEntity().getBuyerTypeName());
        buyerOrder.getEntity().setNetBuyerFlg(
                buyer.getEntity().getNetBuyerFlg() == null ? false : buyer.getEntity().getNetBuyerFlg());
        buyerOrder.getAttachedEntity().setBuyerCode(buyer.getEntity().getBuyerCode());
        buyerOrder.getAttachedEntity().setBuyerName(buyer.getEntity().getBuyerName());
        buyerOrder.getAttachedEntity().setBuyerPhone(buyer.getEntity().getBuyerPhone());
        buyerOrder.getAttachedEntity().setBuyerWechat(buyer.getEntity().getBuyerWechat());
        buyerOrder.getAttachedEntity().setBuyerQq(buyer.getEntity().getBuyerQq());
        buyerOrder.getAttachedEntity().setBuyerMail(buyer.getEntity().getBuyerMail());
        // 设置买手信息
        buyerOrder.getEntity().setBsId(buyer.getEntity().getBsId());
        buyerOrder.getEntity().setBsType(buyer.getEntity().getBsType());
        buyerOrder.getAttachedEntity().setRegionalBsId(buyer.getEntity().getRegionalBsId());
        buyerOrder.getAttachedEntity().setRegionalBsCode(buyer.getEntity().getRegionalBsCode());
        buyerOrder.getAttachedEntity().setRegionalBsName(buyer.getEntity().getRegionalBsName());
        buyerOrder.getAttachedEntity().setNonRegionalBsId(buyer.getEntity().getNonRegionalBsId());
        buyerOrder.getAttachedEntity().setNonRegionalBsCode(buyer.getEntity().getNonRegionalBsCode());
        buyerOrder.getAttachedEntity().setNonRegionalBsName(buyer.getEntity().getNonRegionalBsName());
        buyerOrder.getAttachedEntity().setRegionalDistributionBsId(buyer.getEntity().getRegionalDistributionBsId());
        buyerOrder.getAttachedEntity().setRegionalDistributionBsCode(buyer.getEntity().getRegionalDistributionBsCode());
        buyerOrder.getAttachedEntity().setRegionalDistributionBsName(buyer.getEntity().getRegionalDistributionBsName());
        buyerOrder.getAttachedEntity().setNetUserBsId(buyer.getEntity().getNetUserBsId());
        buyerOrder.getAttachedEntity().setNetUserBsCode(buyer.getEntity().getNetUserBsCode());
        buyerOrder.getAttachedEntity().setNetUserBsName(buyer.getEntity().getNetUserBsName());
        // 设置冻品管家信息
        buyerOrder.getAttachedEntity().setSaId(buyer.getEntity().getSaId());
        buyerOrder.getAttachedEntity().setSaCode(buyer.getEntity().getSaCode());
        buyerOrder.getAttachedEntity().setSaName(buyer.getEntity().getSaName());
        // 区域配送站
        buyerOrder.getAttachedEntity()
                .setRegionalDistributionStation(buyer.getEntity().getRegionalDistributionStation());
        buyerOrder.getAttachedEntity()
                .setRegionalDistributionStationCode(buyer.getEntity().getRegionalDistributionStationCode());
        buyerOrder.getAttachedEntity()
                .setRegionalDistributionStationName(buyer.getEntity().getRegionalDistributionStationName());

        // 设置物流区信息
        buyerOrder.getAttachedEntity().setCityId(buyer.getEntity().getCityId());
        buyerOrder.getAttachedEntity().setCityCode(buyer.getEntity().getCityCode());
        buyerOrder.getAttachedEntity().setCityName(buyer.getEntity().getCityName());
        buyerOrder.getAttachedEntity().setCountryId(buyer.getEntity().getCountryId());
        buyerOrder.getAttachedEntity().setCountryCode(buyer.getEntity().getCountryCode());
        buyerOrder.getAttachedEntity().setCountryName(buyer.getEntity().getCountryName());

        // 设置下单员信息
        OrderPlacerType orderPlacerType = OrderPlacerType.getInstance(buyerOrder.getEntity().getOrderPlacerType());
        switch (orderPlacerType) {
        case BUYER:
            buyerOrder.getAttachedEntity().setOrderPlacerCode(buyer.getEntity().getBuyerCode());
            buyerOrder.getAttachedEntity().setOrderPlacerName(buyer.getEntity().getBuyerName());
            break;
        case SA:
            buyerOrder.getAttachedEntity().setOrderPlacerCode(buyer.getEntity().getSaCode());
            buyerOrder.getAttachedEntity().setOrderPlacerName(buyer.getEntity().getSaName());
            break;
        case MANAGER:
            buyerOrder.getAttachedEntity().setOrderPlacerCode(buyerOrder.getBlackboard().getOperator().getOperatorId());
            buyerOrder.getAttachedEntity().setOrderPlacerName(buyerOrder.getBlackboard().getOperator().getOperatorId());
            break;
        default:
            break;
        }

        // 设置下单类型
        Boolean batchFlg = buyerOrder.getEntity().getBatchFlg(); // 是否分批
        switch (orderPlacerType) {
        // 买家、平台管理员代下单视为自主下单
        case BUYER:
        case MANAGER:
            buyerOrder.getEntity().setOrderPlaceType(OrderPlaceType.A_TYPE.getCode());
            buyerOrder.getEntity().setOrderType(batchFlg ? BuyerOrderType.BUYER_A_BATCH_ORDER.getCode()
                    : BuyerOrderType.BUYER_A_STANDARD_ORDER.getCode());
            break;
        // 管家代下单视为非自出下单
        case SA:
            buyerOrder.getEntity().setOrderPlaceType(OrderPlaceType.B_TYPE.getCode());
            buyerOrder.getEntity().setOrderType(batchFlg ? BuyerOrderType.BUYER_B_BATCH_ORDER.getCode()
                    : BuyerOrderType.BUYER_B_STANDARD_ORDER.getCode());
            break;
        default:
            break;
        }

        // 设置分拆规则
        buyerOrder.getEntity().setOrderSplitType(OrderSplitType.SPLIT_BY_ORDER.getCode());

        // 设置支付状态
        buyerOrder.getEntity().setPaymentStu(PaymentStu.NOT_PAYMENT.getCode());

        // 计算订单金额
        buyerOrder.getEntity().setOrderAmount(buyerOrder.calculateOrderAmount());

        // 设置运费金额
        if (buyerOrder.getEntity().getFreight() == null)
            buyerOrder.getEntity().setFreight(BigDecimal.ZERO);

        // 设置优惠金额
        if (buyerOrder.getEntity().getPreferentialAmount() == null)
            buyerOrder.getEntity().setPreferentialAmount(BigDecimal.ZERO);

        // 设置已收金额
        buyerOrder.getEntity().setReceiveAmount(BigDecimal.ZERO);

        // 设置定金预付金信息
        if (buyerOrder.getEntity().getEarnestAmount() == null)
            buyerOrder.getEntity().setEarnestAmount(BigDecimal.ZERO);
        // 百分比 = 数值 / 订单金额 * 100 ，单位%
        buyerOrder.getEntity()
                .setEarnestPercent(DecimalUtils.divideAndRound(
                        DecimalUtils.multiply(buyerOrder.getEntity().getEarnestAmount(), new BigDecimal(100)),
                buyerOrder.getEntity().getOrderAmount(), OrderConst.MAX_D_PERCENT));
        if (buyerOrder.getEntity().getAdvancePaymentAmount() == null)
            buyerOrder.getEntity().setAdvancePaymentAmount(BigDecimal.ZERO);
        // 百分比 = 数值 / 订单金额 * 100，单位%
        buyerOrder.getEntity()
                .setAdvancePaymentPercent(DecimalUtils.divideAndRound(
                        DecimalUtils.multiply(buyerOrder.getEntity().getAdvancePaymentAmount(), new BigDecimal(100)),
                        buyerOrder.getEntity().getOrderAmount(), OrderConst.MAX_D_PERCENT));

        // 设置买家订单状态
        buyerOrder.getEntity().setBuyerOrderStu(BuyerOrderStu.IN_CONFIRMATION.getCode());
    }

    /**
     * 补充买家分批订单信息
     *
     * @param buyerOrder
     */
    private void completeBuyerBatchOrder(BuyerOrder buyerOrder) {
        for (BuyerBatchOrder buyerBatchOrder : buyerOrder.getBuyerBatchOrders()) {
            _completeBuyerBatchOrder(buyerOrder, buyerBatchOrder);
        }
    }

    /**
     * 补充买家分批订单信息
     *
     * @param buyerOrder
     * @param buyerBatchOrder
     */
    private void _completeBuyerBatchOrder(BuyerOrder buyerOrder, BuyerBatchOrder buyerBatchOrder) {
        // 设置分批订单Code
        buyerBatchOrder.getEntity().setBuyerBatchOrderCode(buyerBatchOrder.createBuyerBatchOrderCode());

        // 计算订单金额
        buyerBatchOrder.getEntity().setOrderAmount(buyerBatchOrder.calculateOrderAmount());

        // 设置预留金额
        buyerBatchOrder.getEntity().setFreight(BigDecimal.ZERO);
        buyerBatchOrder.getEntity().setPreferentialAmount(BigDecimal.ZERO);
        buyerBatchOrder.getEntity().setReceiveAmount(BigDecimal.ZERO);
        buyerBatchOrder.getEntity().setEarnestPercent(BigDecimal.ZERO);
        buyerBatchOrder.getEntity().setEarnestAmount(BigDecimal.ZERO);
        buyerBatchOrder.getEntity().setAdvancePaymentPercent(BigDecimal.ZERO);
        buyerBatchOrder.getEntity().setAdvancePaymentAmount(BigDecimal.ZERO);

        // 设置买家分批订单状态
        buyerBatchOrder.getEntity().setBuyerBatchOrderStu(BuyerBatchOrderStu.TO_SPLIT.getCode());
    }

    /**
     * 补充买家分批订单明细信息
     *
     * @param buyerOrder
     */
    private void completeBuyerBatchOrderDetail(BuyerOrder buyerOrder) {
        // 获取商品信息;

        Map<String, Goods> goodsMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (BuyerBatchOrder buyerBatchOrder : buyerOrder.getBuyerBatchOrders()) {
            for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerBatchOrder.getBuyerBatchOrderDetails()) {
                String goodsId = buyerBatchOrderDetail.getEntity().getGoodsId();
                if (StringUtils.isNotEmpty(goodsId)) {
                    list.add(goodsId);
                }
            }
        }
        List<Goods> goodsList = Goods.findByIds(list, buyerOrder.getEntity().getLogisticsZoneId());
        if (null != goodsList && goodsList.size() > 0) {
            for (Goods goods : goodsList) {
                goodsMap.put(goods.getEntity().getGoodsId(), goods);
            }
        }
        for (BuyerBatchOrder buyerBatchOrder : buyerOrder.getBuyerBatchOrders()) {
            for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerBatchOrder.getBuyerBatchOrderDetails()) {
                _completeBuyerBatchOrderDetail(buyerBatchOrderDetail, goodsMap);
            }
        }
    }

    /**
     * 补充买家分批订单明细信息
     *
     * @param buyerBatchOrderDetail
     */
    private void _completeBuyerBatchOrderDetail(BuyerBatchOrderDetail buyerBatchOrderDetail,
            Map<String, Goods> goodsMap) {

        buyerBatchOrderDetail.getEntity().setGoodsUnit(GoodsUnit.PACKAGE.getCode());
        // 设置取消数量
        buyerBatchOrderDetail.getEntity().setCancelQuantity(BigDecimal.ZERO);

        // 设置是否分拆完成
        buyerBatchOrderDetail.getEntity().setSplitFlg(false);

        // 获取商品信息
        Goods goods = goodsMap.get(buyerBatchOrderDetail.getEntity().getGoodsId().toString());
        if (goods == null)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E010105,
                    buyerBatchOrderDetail.getEntity().getGoodsId().toString());

        buyerBatchOrderDetail.getEntity().setProductId(goods.getEntity().getProductId());
        buyerBatchOrderDetail.getEntity().setManufacturerId(goods.getEntity().getManufacturerId());
        buyerBatchOrderDetail.getEntity().setSellerId(goods.getEntity().getSellerId());
        buyerBatchOrderDetail.getEntity().setBatchId(goods.getEntity().getBatchId());
        buyerBatchOrderDetail.getEntity().setSaleLabelId(goods.getEntity().getSaleLabelId());

        buyerBatchOrderDetail.getAttachedEntity().setItemCode(goods.getEntity().getItemCode());
        buyerBatchOrderDetail.getAttachedEntity().setItemName(goods.getEntity().getItemName());
        buyerBatchOrderDetail.getAttachedEntity().setBrandCode(goods.getEntity().getBrandCode());
        buyerBatchOrderDetail.getAttachedEntity().setBrandName(goods.getEntity().getBrandName());
        buyerBatchOrderDetail.getAttachedEntity().setItemBrandCode(goods.getEntity().getItemBrandCode());
        buyerBatchOrderDetail.getAttachedEntity().setManufacturerCode(goods.getEntity().getManufacturerCode());
        buyerBatchOrderDetail.getAttachedEntity().setManufacturerName(goods.getEntity().getManufacturerName());
        buyerBatchOrderDetail.getAttachedEntity().setSellerCode(goods.getEntity().getSellerCode());
        buyerBatchOrderDetail.getAttachedEntity().setSellerName(goods.getEntity().getSellerName());
        buyerBatchOrderDetail.getAttachedEntity().setBatchCode(goods.getEntity().getBatchCode());
        buyerBatchOrderDetail.getAttachedEntity().setSaleLabelCode(goods.getEntity().getSaleLabelCode());
        buyerBatchOrderDetail.getAttachedEntity().setSaleLabelName(goods.getEntity().getSaleLabelName());
        buyerBatchOrderDetail.getAttachedEntity().setSmallPackageFeature(goods.getEntity().getSmallPackageFeature());
        buyerBatchOrderDetail.getAttachedEntity().setQuantityPerPackage(goods.getEntity().getQuantityPerPackage());
        buyerBatchOrderDetail.getAttachedEntity().setNetWeight(goods.getEntity().getNetWeight());
        buyerBatchOrderDetail.getAttachedEntity().setGrossWeight(goods.getEntity().getGrossWeight());
        buyerBatchOrderDetail.getAttachedEntity().setCartonSize(goods.getEntity().getCartonSize());
        buyerBatchOrderDetail.getAttachedEntity().setProductLevel(goods.getEntity().getProductLevel());
        buyerBatchOrderDetail.getAttachedEntity()
                .setPalletStandardStackQuantity(goods.getEntity().getPalletStandardStackQuantity());
        buyerBatchOrderDetail.getAttachedEntity().setGoodsCode(goods.getEntity().getGoodsCode());
        buyerBatchOrderDetail.getAttachedEntity().setGoodsName(goods.getEntity().getGoodsName());

    }

    /**
     * 收尾
     *
     * @param map
     *            HashMap
     */
    private void post(HashMap<String, Object> map) {
    }
}
