package com.bms.order.services.impl;

import com.bms.order.archive.impl.*;
import com.bms.order.archive.impl.list.DistributionNotificationList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.*;
import com.bms.order.bean.param.ORDR0402IFilterOrderParam;
import com.bms.order.bean.param.ORDR0402IFilterParam;
import com.bms.order.bean.result.ORDR0402IOrderDetailResult;
import com.bms.order.bean.result.ORDR0402IOrderPriceResult;
import com.bms.order.bean.result.ORDR0402IOrderResult;
import com.bms.order.bean.result.ORDR0402IRestResult;
import com.bms.order.constant.enumeration.OperatorType;
import com.bms.order.constant.enumeration.PriceReturnType;
import com.bms.order.constant.enumeration.PriceUserType;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.*;
import com.bms.order.external.archive.Price;
import com.bms.order.external.bean.entity.PlateDetailEntity;
import com.bms.order.external.bean.entity.PriceEntity;
import com.bms.order.external.bean.param.PriceRestParam;
import com.bms.order.services.ORDR0402IService;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.DecimalUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单信息及对应价盘查询接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0402IServiceImpl implements ORDR0402IService {


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

    @Autowired
    private PriceChannelNotificationDao priceChannelNotificationDao;

    @Autowired
    private PriceChannelNotificationDetailDao priceChannelNotificationDetailDao;

    @Autowired
    private BuyerForcastDeliverDetailDao buyerForcastDeliverDetailDao;

    @Autowired
    private BuyerForcastDeliverDetailAttachedDao buyerForcastDeliverDetailAttachedDao;

    @Autowired
    private DistributionNotificationDao distributionNotificationDao;

    @Autowired
    private DistributionNotificationDetailDao distributionNotificationDetailDao;

    /**
     * 美迪福调用，获取最终的价盘通道
     *
     * @param operator
     * @param param
     * @return
     */
    @Transactional
    @Override
    public ORDR0402IRestResult execute(Operator operator, ORDR0402IFilterParam param) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        ORDR0402IRestResult result = new ORDR0402IRestResult();
        ORDR0402IFilterParam filterParam = param;

        blackboard.setOperator(operator);
        map.put("param", filterParam);
        map.put("blackboard", blackboard);
        map.put("result", result);

        pre(map);
        process(map);
        post(map);
        return (ORDR0402IRestResult) map.get("result");
    }

    /**
     * 准备
     *
     * @param map HashMap
     */
    private void pre(HashMap<String, Object> map) {
        // 获取参数
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(buyerOrderDao);
        blackboard.putBaseDao(buyerBatchOrderDao);
        blackboard.putBaseDao(buyerBatchOrderDetailDao);
        blackboard.putBaseDao(priceChannelNotificationDao);
        blackboard.putBaseDao(priceChannelNotificationDetailDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailDao);
        blackboard.putBaseDao(distributionNotificationDao);
        blackboard.putBaseDao(distributionNotificationDetailDao);
        blackboard.putBaseDao(buyerOrderAttachedDao);
        blackboard.putBaseDao(buyerBatchOrderAttachedDao);
        blackboard.putBaseDao(buyerBatchOrderDetailAttachedDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailAttachedDao);

        //操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);
        if (!operator.getOperatorType().equals(OperatorType.MADE_4_NET.getCode())) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E040201);
        }
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        ORDR0402IFilterParam param = (ORDR0402IFilterParam) map.get("param");
        List<Long> shipId = new ArrayList<>();
        for (ORDR0402IFilterOrderParam order : param.getOrderList()){
            shipId.add(order.getShipId());
        }
        DistributionNotificationList distributionNotificationList = ((ORDR0402IFilterParam) map.get("param")).generateDistributionNotification(shipId.toArray(new Long[shipId.size()]));
        distributionNotificationList.setBlackboard((Blackboard) map.get("blackboard"));
        distributionNotificationList.complete(false);
        List<DistributionNotification> distributionNotifications = distributionNotificationList.getArchives();
        this.getPricePlate(distributionNotifications);
        map.put("distributionNotifications", distributionNotifications);
    }

    /**
     * 得到订单数据
     *
     * @param distributionNotifications
     */
    public void getPricePlate(List<DistributionNotification> distributionNotifications) {
        if (CollectionUtils.isEmpty(distributionNotifications)) {
            return;
        }
        List<BuyerOrder> buyerOrders = null;

        for (DistributionNotification distributionNotification : distributionNotifications) {
            if (CollectionUtils.isEmpty(buyerOrders)) {
                buyerOrders = new ArrayList<>();
                BuyerOrder buyerOrder = distributionNotification.getBuyerOrder();
                buyerOrders.add(buyerOrder);
                continue;
            }
            boolean priceFlg = false;

            for (BuyerOrder buyerOrder : buyerOrders) {
                if (buyerOrder.getEntity().getBuyerOrderId().equals(distributionNotification.getEntity().getBuyerOrderId())) {
                    priceFlg = true;
                    break;
                }
            }

            if (!priceFlg) {
                buyerOrders.add(distributionNotification.getBuyerOrder());
            }
        }

        for (BuyerOrder buyerOrder : buyerOrders) {
            PriceChannelNotification priceChannel = buyerOrder.getPriceChannelNotification();
            if (null == priceChannel) {
                PriceChannelNotificationEntity priceChannelNotificationEntity = new PriceChannelNotificationEntity();
                priceChannelNotificationEntity.setBuyerOrderId(buyerOrder.getEntity().getBuyerOrderId());
                priceChannelNotificationEntity.setBuyerOrderCode(buyerOrder.getEntity().getBuyerOrderCode());
                priceChannelNotificationEntity.setSendFlg(false);
                PriceChannelNotification priceChannelNotification = PriceChannelNotification.build(buyerOrder.getBlackboard()).forCreate(priceChannelNotificationEntity);
                priceChannelNotification.create();
                buyerOrder.link(priceChannelNotification);
                buyerOrder.priceChannelNotificationLinked();


                HashMap<String, Object> map = getPriceChannelList(buyerOrder);
                List<PriceEntity> priceEntityList = (List<PriceEntity>) map.get("priceEntityList");
                Map<String, BigDecimal> goodsMap = (Map<String, BigDecimal>) map.get("goods");
                for (PriceEntity priceEntity : priceEntityList) {
                    List<PlateDetailEntity> plateDetailList = priceEntity.getPlateDetailList();
                    if (CollectionUtils.isEmpty(plateDetailList)) {
                        throw new BusinessException(ModuleCode.ORDR, ErrorCode.E040202);
                    }
                    for (PlateDetailEntity plateDetailEntity : plateDetailList) {
                        PriceChannelNotificationDetailEntity priceChannelNotificationDetailEntity = new PriceChannelNotificationDetailEntity();
                        priceChannelNotificationDetailEntity.setPriceChannelNotificationId(priceChannelNotificationEntity.getPriceChannelNotificationId());
                        priceChannelNotificationDetailEntity.setGoodsId(plateDetailEntity.getGoodId());
                        priceChannelNotificationDetailEntity.setGoodsQuantity(goodsMap.get(plateDetailEntity.getGoodId()));
                        priceChannelNotificationDetailEntity.setWayTypeId(plateDetailEntity.getWayTypeId());
                        priceChannelNotificationDetailEntity.setWayTypeName(plateDetailEntity.getWayTypeName());
                        priceChannelNotificationDetailEntity.setWayDesc(plateDetailEntity.getWayDesc());
                        priceChannelNotificationDetailEntity.setWayConfigId(plateDetailEntity.getWayConfigId());
                        priceChannelNotificationDetailEntity.setPriceChannelStartQuantity(plateDetailEntity.getStartQty());
                        priceChannelNotificationDetailEntity.setPriceChannelEndQuantity(plateDetailEntity.getEndQty());
                        priceChannelNotificationDetailEntity.setPriceChannelUnitPrice(plateDetailEntity.getUnitPrice());
                        priceChannelNotificationDetailEntity.setPriceChannelKgPrice(plateDetailEntity.getPrice());// 公斤价
                        PriceChannelNotificationDetail priceChannelNotificationDetail = PriceChannelNotificationDetail.build(buyerOrder.getBlackboard()).forCreate(priceChannelNotificationDetailEntity);
                        priceChannelNotificationDetail.create();
                    }
                }
            }
        }
    }

    /**
     * 从价盘接口获取商品价盘信息
     *
     * @param buyerOrder
     * @return
     */
    public HashMap<String, Object> getPriceChannelList(BuyerOrder buyerOrder) {
        BuyerOrderEntity buyerOrderEntity = buyerOrder.getEntity();
        String frequenterLevelCode = buyerOrderEntity.getFrequenterLevelCode();//常客买家等级编码 [默认共四级：0，1，2，3]
        Boolean netBuyerFlg = buyerOrderEntity.getNetBuyerFlg();
        String buyerLevel=null;
        if (StringUtils.isEmpty(frequenterLevelCode)) {
            buyerLevel = "0";
//           throw new BusinessException(ModuleCode.ORDR,"查询价盘需要买家等级！如果买有请到订单表中手动填入。目前 取值 默认共四级：0，1，2，3");
        }else {
            buyerLevel=frequenterLevelCode;
        }
        HashMap<String, Object> map = new HashMap<>();
        ArrayList<PriceRestParam> params = new ArrayList<>();
        List<BuyerBatchOrder> buyerBatchOrders = buyerOrder.getBuyerBatchOrders();
        if (CollectionUtils.isEmpty(buyerBatchOrders)) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E040203);
        }

        for (BuyerBatchOrder buyerBatchOrder : buyerBatchOrders) {
            List<BuyerBatchOrderDetail> buyerBatchOrderDetails = buyerBatchOrder.getBuyerBatchOrderDetails();
            if (CollectionUtils.isEmpty(buyerBatchOrderDetails)) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E040204);
            }
            for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerBatchOrderDetails) {
                if (CollectionUtils.isEmpty(params)) {
                    PriceRestParam priceChannelQueryParam = new PriceRestParam();
                    priceChannelQueryParam.setGoodId(buyerBatchOrderDetail.getEntity().getGoodsId());
                    priceChannelQueryParam.setLgcsAreaCode(buyerOrder.getAttachedEntity().getLogisticsZoneCode());
                    if (netBuyerFlg != null && netBuyerFlg) {
                        priceChannelQueryParam.setUserType(PriceUserType.PERIOD_USER.getCode());
                    } else {
                        priceChannelQueryParam.setUserType(PriceUserType.STANDARD_USER.getCode());
                    }
                    priceChannelQueryParam.setBuyerLevel(buyerLevel);
                    priceChannelQueryParam.setCompareTimeOne(buyerBatchOrderDetail.getEntity().getPriceCreateTime());
                    priceChannelQueryParam.setReturnType(PriceReturnType.MIN_PRICE.getCode());
                    priceChannelQueryParam.setQty(buyerBatchOrderDetail.getEntity().getGoodsQuantity());
                    params.add(priceChannelQueryParam);
                    continue;
                }
                boolean goodsFlg = true;
                for (PriceRestParam param : params) {
                    if (param.getGoodId().equals(buyerBatchOrderDetail.getEntity().getGoodsId())) {
                        param.setQty(param.getQty().add(buyerBatchOrderDetail.getEntity().getGoodsQuantity()));
                        goodsFlg = false;
                        break;
                    }
                }

                if (goodsFlg) {
                    PriceRestParam priceChannelQueryParam = new PriceRestParam();
                    priceChannelQueryParam.setGoodId(buyerBatchOrderDetail.getEntity().getGoodsId());
                    priceChannelQueryParam.setLgcsAreaCode(buyerOrder.getAttachedEntity().getLogisticsZoneCode());
                    priceChannelQueryParam.setBuyerLevel(buyerLevel);
                    if (netBuyerFlg != null && netBuyerFlg) {
                        priceChannelQueryParam.setUserType(PriceUserType.PERIOD_USER.getCode());
                    } else {
                        priceChannelQueryParam.setUserType(PriceUserType.STANDARD_USER.getCode());
                    }
                    priceChannelQueryParam.setCompareTimeOne(buyerBatchOrderDetail.getEntity().getPriceCreateTime());
                    priceChannelQueryParam.setReturnType(PriceReturnType.MIN_PRICE.getCode());
                    priceChannelQueryParam.setQty(buyerBatchOrderDetail.getEntity().getGoodsQuantity());
                    params.add(priceChannelQueryParam);
                }
            }
        }
        Map<String, BigDecimal> goods = new HashMap<>();
        for (PriceRestParam param : params) {
            goods.put(param.getGoodId(), param.getQty());
        }
        List<PriceEntity> priceEntityList = Price.queryPricePlateDetail(params);
        map.put("priceEntityList", priceEntityList);
        map.put("goods", goods);
        return map;
    }

    /**
     * 收尾
     *
     * @param map HashMap
     */
    private void post(HashMap<String, Object> map) {
        ORDR0402IRestResult ordr0402IRestResult1 = new ORDR0402IRestResult();
        List<DistributionNotification> distributionNotifications = (List<DistributionNotification>) map.get("distributionNotifications");

        if (CollectionUtils.isEmpty(distributionNotifications)) {
            return;
        }
        List<ORDR0402IOrderResult> orderList = new ArrayList<>();
        for (DistributionNotification distributionNotification : distributionNotifications) {
            ORDR0402IOrderResult ordr0402IOrderResult = new ORDR0402IOrderResult();
            ordr0402IOrderResult.setShipId(distributionNotification.getEntity().getDistributionNotificationId());
            ordr0402IOrderResult.setPaymentRule(1);
            ordr0402IOrderResult.setOrderId(distributionNotification.getEntity().getBuyerOrderId());

            List<ORDR0402IOrderDetailResult> details = new ArrayList<>();
            BuyerOrder buyerOrder = distributionNotification.getBuyerOrder();
            List<BuyerForcastDeliverDetail> forcastDeliverDetails = new ArrayList<>();
            for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerOrder.getBuyerBatchOrderDetails()){
                forcastDeliverDetails.addAll(buyerBatchOrderDetail.getBuyerForcastDeliverDetails());
            }
            if (CollectionUtils.isNotEmpty(forcastDeliverDetails)){
                for (BuyerForcastDeliverDetail forcastDeliverDetail : forcastDeliverDetails){
                    BuyerForcastDeliverDetailEntity forcastEntity = forcastDeliverDetail.getEntity();
                    BuyerForcastDeliverDetailAttachedEntity attachedEntity = forcastDeliverDetail.getAttachedEntity();
                    BuyerBatchOrderEntity buyerBatchOrderEntity = forcastDeliverDetail.getBuyerBatchOrder().getEntity();

                    ORDR0402IOrderDetailResult ordr0402IOrderDetailResult = new ORDR0402IOrderDetailResult();
                    ordr0402IOrderDetailResult.setDetailId(forcastEntity.getBuyerForcastDeliverDetailId());
                    ordr0402IOrderDetailResult.setProDate(DateUtils.formatDate(buyerBatchOrderEntity.getExpectedSendDatetime()));
                    ordr0402IOrderDetailResult.setSalesLabel(attachedEntity.getSaleLabelCode());
                    ordr0402IOrderDetailResult.setPdCode(attachedEntity.getGoodsCode());
                    ordr0402IOrderDetailResult.setPdName(attachedEntity.getGoodsName());
                    ordr0402IOrderDetailResult.setSkuCode(forcastEntity.getSku());
                    ordr0402IOrderDetailResult.setOrderQty(forcastEntity.getPlanSendQuantity());
                    ordr0402IOrderDetailResult.setOrderPrice(forcastDeliverDetail.getBuyerBatchOrderDetail().getEntity().getOrderCreateUnitPrice());

                    List<PriceChannelNotificationDetail> priceChannelNotificationDetails = buyerOrder.getPriceChannelNotification().getPriceChannelNotificationDetails();
                    List<ORDR0402IOrderPriceResult> priceList = new ArrayList<>();
                    for (PriceChannelNotificationDetail priceChannelNotificationDetail : priceChannelNotificationDetails) {
                        PriceChannelNotificationDetailEntity priceChannelNotificationDetailEntity = priceChannelNotificationDetail.getEntity();
                        if (priceChannelNotificationDetailEntity.getGoodsId().equals(forcastEntity.getGoodsId())) {
                            ORDR0402IOrderPriceResult priceResult = new ORDR0402IOrderPriceResult();
                            if (priceChannelNotificationDetailEntity.getPriceChannelEndQuantity() == null){
                                priceResult.setLevelEnd(new BigDecimal("999999"));
                            } else {
                                priceResult.setLevelEnd(priceChannelNotificationDetailEntity.getPriceChannelEndQuantity());
                            }
                            priceResult.setOrderLevel(Long.valueOf(priceChannelNotificationDetailEntity.getWayDesc()).longValue());
                            priceResult.setLevelStart(priceChannelNotificationDetailEntity.getPriceChannelStartQuantity());
                            priceResult.setLevelPrice(priceChannelNotificationDetailEntity.getPriceChannelUnitPrice());
                            priceList.add(priceResult);
                        }
                    }
                    ordr0402IOrderDetailResult.setPriceList(priceList);
                    details.add(ordr0402IOrderDetailResult);
                }
            }

            Map<String ,ORDR0402IOrderDetailResult> detailsMap = new HashMap<>();
            for (ORDR0402IOrderDetailResult detailResult : details){
                if (detailsMap.get(detailResult.getPdCode()) == null){
                    detailsMap.put(detailResult.getPdCode(),detailResult);
                } else {
                    BigDecimal orderQty1 = detailResult.getOrderQty();
                    BigDecimal orderQty2 = detailsMap.get(detailResult.getPdCode()).getOrderQty();
                    detailsMap.get(detailResult.getPdCode()).setOrderQty(DecimalUtils.add(orderQty1, orderQty2));
                }
            }
            ordr0402IOrderResult.setOrderDetail(new ArrayList<ORDR0402IOrderDetailResult>(detailsMap.values()));
            orderList.add(ordr0402IOrderResult);
        }
        ordr0402IRestResult1.setOrderList(orderList);
        map.put("result", ordr0402IRestResult1);
    }
}
