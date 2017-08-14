package com.batch.order.service.impl;

import com.batch.order.bean.RestRequest;
import com.batch.order.bean.RestResponse;
import com.batch.order.bean.entity.*;
import com.batch.order.bean.inv.param.LINV0103IAllocationParam;
import com.batch.order.bean.inv.param.LINV0103IParam;
import com.batch.order.bean.inv.param.LINV0103ISourceParam;
import com.batch.order.bean.inv.param.LINV0110IParam;
import com.batch.order.bean.inv.result.LINV0110IInvResult;
import com.batch.order.bean.param.MailSendRsParam;
import com.batch.order.bean.price.param.PRCE0211IParam;
import com.batch.order.bean.price.result.PRCE0211IDetailResult;
import com.batch.order.bean.price.result.PRCE0211IResult;
import com.batch.order.bean.result.*;
import com.batch.order.bean.seller.param.SLIM0250IParam;
import com.batch.order.bean.seller.result.SLIM0250IEntitySellerResult;
import com.batch.order.constant.OrderConstant;
import com.batch.order.constant.OrderStatusConstant;
import com.batch.order.constant.inv.*;
import com.batch.order.constant.ordr.ForcastType;
import com.batch.order.constant.ordr.SellSideType;
import com.batch.order.constant.ordr.UserType;
import com.batch.order.dao.ORDR0201BDao;
import com.batch.order.service.ORDR0201BService;
import com.batch.order.util.client.BaseRestClientUtil;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.DecimalUtils;
import com.framework.core.utils.NumberUtils;
import com.framework.core.utils.StringUtils;
import com.framework.redis.dao.BaseRedisDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by liutao on 2017/1/4.
 */
@Service
public class ORDR0201BServiceImpl extends BaseServiceImpl implements ORDR0201BService {

    private static final Logger logger = LoggerFactory.getLogger(ORDR0201BServiceImpl.class);

    @Autowired
    private ORDR0201BDao ordr0201BDao;

    @Autowired
    private BaseRedisDao baseRedisDao;

    @Autowired
    private BaseRestClientUtil baseRestClientUtil;

    @Override
    public List<ORDR0201BOrderResult> getOrderResults() {
        //查询所有满足条件的订单信息
        logger.debug("查询所有满足条件的订单信息");
        List<ORDR0201BOrderResult> orderResults = ordr0201BDao.getOrderResults();
        return orderResults;
    }

    /**
     * 分拆操作
     */
    @Override
    public void createSplitOrderDetail(ORDR0201BOrderResult orderResult) {
        try{
            //查询出这个订单下所有商品总和信息（商品为纬度）
            logger.debug("查询出这个订单下所有商品总和信息");
            List<ORDR0201BOrderGoodsResult> orderGoodsResults = ordr0201BDao.getOrderGoodsResults(orderResult);
            if (CollectionUtils.isEmpty(orderGoodsResults)) {
                return;
            }
            // 合计订单下所有分批订单信息
            List<ORDR0201BOrderBatchResult> batchResults = new ArrayList<>();

            List<ORDR0201BForecastOrderResult> forecastOrderResults = new ArrayList<>();

            for (ORDR0201BOrderGoodsResult orderGoodsResult : orderGoodsResults) {
                //查询单个商品对应的分批订单信息
                logger.debug("查询单个商品对应的分批订单信息");
                List<ORDR0201BOrderBatchResult> orderBatchResults = ordr0201BDao.getOrderBatchResults(orderGoodsResult);
                //产品库存查询
                List<LINV0110IInvResult> invResults = loadInvSearch(orderGoodsResult);

                if (checkAllStockByGoods(orderGoodsResult, invResults, orderBatchResults)) {
                    // 库存足够，开始分拆
                    logger.debug("库存足够，开始分拆");
                    List<ORDR0201BForecastOrderResult> results = splitOrderInfo(orderGoodsResult, invResults);
                    if (CollectionUtils.isEmpty(results)) {
                        continue;
                    }

                    //region 得到生产商的基本信息
                    logger.debug("得到生产商的基本信息");
                    SLIM0250IEntitySellerResult slim0250IResult = getSLIM0250IResult(results);
                    if (!CollectionUtils.isEmpty(results)) {
                        for (ORDR0201BForecastOrderResult result : results) {
                            if (null != slim0250IResult) {
                                result.getBuyerForcastDeliverDetailAttachedEntity().setManufacturerName(slim0250IResult.getFullName());
                                result.getBuyerForcastDeliverDetailAttachedEntity().setManufacturerCode(slim0250IResult.getEntitySellerCode());
                            }
                        }
                    }
                    //endregion
                    //region 得到卖家基本信息
                    logger.debug("得到卖家基本信息");
                    getSellerResult(results);
                    //endregion
                    forecastOrderResults.addAll(results);
                    //插入数据库
                    for (ORDR0201BForecastOrderResult result : results) {
                        // 如果是从买手走的话 生成买手销售数据
                        if (!orderGoodsResult.getOwnerType().equals(SellSideType.PLATFORM_TYPE.getCode())) {
                            logger.debug("如果是从买手走的话 生成买手销售数据");
                            List<BsStockpileSaleDetailResult> stockpileSaleDetailResults = ordr0201BDao.getBsStockpilingOrder(orderGoodsResult);
                            saveBsStockpileSaleDetail(result, stockpileSaleDetailResults);
                        }
                        BuyerForcastDeliverDetailEntity detail = result.getBuyerForcastDeliverDetailEntity();
                        BuyerForcastDeliverDetailAttachedEntity detailAttached = result.getBuyerForcastDeliverDetailAttachedEntity();
                        logger.debug("插入预配送数据");
                        ordr0201BDao.saveBuyerForcastDeliverDetail(detail);
                        ordr0201BDao.saveBuyerForcastDeliverDetailAttached(detailAttached);
                    }

                    List<ORDR0201BOrderBatchDetailResult> detailResults = ordr0201BDao.getOrderBatchDetails(orderGoodsResult);
                    for (ORDR0201BOrderBatchDetailResult detailResult : detailResults) {
                        logger.debug("修改分批订单明细");
                        ordr0201BDao.modifyBatchOrderDetail(detailResult);
                    }
                }
                batchResults.addAll(orderBatchResults);
            }

            //分拆成功 明细状态处理 判定是否可以确认操作
            logger.debug("分拆成功 明细状态处理 判定是否可以确认操作");
            confirmBatchOrder(batchResults, orderResult, orderGoodsResults);
            //占用库存
            addStockInfo(forecastOrderResults, orderResult);
        } catch (Exception e){
            // 模板邮件内容
            List<OrderBatchEmailResult> emailResults = new ArrayList<>();
            OrderBatchEmailResult result = new OrderBatchEmailResult();
            result.setBatchNo("ORDR0201B");
            result.setErrorMessage(e.getMessage());
            result.setOrderId(orderResult.getBuyerOrderId());
            result.setOrderCode(orderResult.getBuyerOrderCode());
            emailResults.add(result);
            baseRestClientUtil.sendFailMail(emailResults);

            logger.debug(e.getMessage());
            throw e;
        }
    }

    /**
     * 产品库存查询
     *
     * @param orderGoodsResult
     * @return
     */
    public List<LINV0110IInvResult> loadInvSearch(ORDR0201BOrderGoodsResult orderGoodsResult) {
        logger.debug("产品库存查询开始");
        LINV0110IParam linvParam = new LINV0110IParam();
        if (orderGoodsResult.getLogisticsZoneId()!= null){
            linvParam.setLogisticsId(new String[]{orderGoodsResult.getLogisticsZoneId().toString()});
        }
        linvParam.setSalePlatform(new String[]{SalePlatform.YDP_PLATFORM.getCode()});
        linvParam.setOwnerId(new String[]{orderGoodsResult.getSellerId()});
        linvParam.setOwnerType(new String[]{LinvOwnerType.Seller.getCode()});
        if (orderGoodsResult.getManufacturerId() != null){
            linvParam.setProducerId(new String[]{orderGoodsResult.getManufacturerId().toString()});
        }
        if (orderGoodsResult.getSaleLabelId() != null){
            linvParam.setSaleStatusId(new String[]{orderGoodsResult.getSaleLabelId().toString()});
        }
        linvParam.setCommodityId(new String[]{orderGoodsResult.getGoodsId()});
        if (!StringUtils.isEmpty(orderGoodsResult.getBatchCode())){
            linvParam.setLotNo(new String[]{orderGoodsResult.getBatchCode()});
        }
        linvParam.setUom(new String[]{LinvUom.Box.getCode()});
        //查询所有平台商品库存信息
        BaseRestPaginationResult<LINV0110IInvResult> response = baseRestClientUtil.loadInvSearch(linvParam);
        if (null != response && null != response.getData() && !CollectionUtils.isEmpty(response.getData())) {
            return response.getData();
        }
        return new ArrayList<>();
    }

    /**
     * 判断单个商品库存是否充足（到生产商）
     *
     * @param orderGoodsResult
     * @param invResults
     * @return true 充足 false 不充足
     */
    public boolean checkAllStockByGoods(ORDR0201BOrderGoodsResult orderGoodsResult, List<LINV0110IInvResult> invResults, List<ORDR0201BOrderBatchResult> orderBatchResults) {
        //判断所有商品库存是否充足
        if(orderGoodsResult.getManufacturerId() != null){
            // 已确认生产商的情况
            for (LINV0110IInvResult invResult :invResults){
                if (invResult.getProducerId().equals(orderGoodsResult.getManufacturerId().toString())){
                    BigDecimal goodsQuantity = orderGoodsResult.getGoodsQuantity();
                    BigDecimal availableQty = invResult.getAvailableQty();
                    if (goodsQuantity.compareTo(availableQty) <= 0) {
                        return true;
                    }
                }
            }
        } else {
            // 无生产商的情况
            for (LINV0110IInvResult invResult :invResults){
                BigDecimal goodsQuantity = orderGoodsResult.getGoodsQuantity();
                BigDecimal availableQty = invResult.getAvailableQty();
                if (goodsQuantity.compareTo(availableQty) <= 0) {
                    return true;
                }
            }
        }
        for (ORDR0201BOrderBatchResult result : orderBatchResults){
            result.setBuyerBatchOrderSplitFlg("1");
        }
        return false;
    }

    /**
     * 明细产品分拆动作
     *
     * @param orderGoodsResult
     * @param invResults
     */
    public List<ORDR0201BForecastOrderResult> splitOrderInfo(ORDR0201BOrderGoodsResult orderGoodsResult, List<LINV0110IInvResult> invResults) {
        List<ORDR0201BForecastOrderResult> results = new ArrayList<>();
        // map形式整合库存数据
        Map<String,LINV0110IInvResult> invResultMap = new HashMap<>();
        for (LINV0110IInvResult invResult : invResults){
            invResultMap.put(invResult.getProducerId(),invResult);
        }
        List<ORDR0201BOrderBatchDetailResult> detailResults = ordr0201BDao.getOrderBatchDetails(orderGoodsResult);

        if (orderGoodsResult.getManufacturerId() != null){
            // 指定生产商
            for (ORDR0201BOrderBatchDetailResult batchOrderDetail : detailResults){
                LINV0110IInvResult invResult = invResultMap.get(orderGoodsResult.getManufacturerId().toString());
                ORDR0201BForecastOrderResult result = getSplitResult(batchOrderDetail, invResult);
                results.add(result);
            }
        } else {
            // 未指定生产商
            logger.debug("获取认可生产商");
            List<ORDR0201BManufacturerResult> manufacturerResults = this.getManufacturerResults(orderGoodsResult);
            for (ORDR0201BOrderBatchDetailResult batchOrderDetail : detailResults){
                // 在认可生产商阶段是否分拆完成
                Boolean flg = false;
                for (ORDR0201BManufacturerResult manufacturerResult : manufacturerResults){
                    LINV0110IInvResult invResult = invResultMap.get(manufacturerResult.getManufacturerId().toString());
                    if (invResult != null && invResult.getAvailableQty().compareTo(orderGoodsResult.getGoodsQuantity()) >= 0){
                        ORDR0201BForecastOrderResult result = getSplitResult(batchOrderDetail, invResult);
                        results.add(result);
                        flg = true;
                        break;
                    }
                }
                if (!flg){
                    for (LINV0110IInvResult invResult : invResults){
                        if (invResult.getAvailableQty().compareTo(orderGoodsResult.getGoodsQuantity()) >= 0){
                            ORDR0201BForecastOrderResult result = getSplitResult(batchOrderDetail, invResult);
                            results.add(result);
                            break;
                        }
                    }
                }
            }
        }
        return results;
    }

    /**
     * 组装预配送数据
     *
     * @param batchOrderDetail
     * @param invResult
     */
    public ORDR0201BForecastOrderResult getSplitResult(ORDR0201BOrderBatchDetailResult batchOrderDetail, LINV0110IInvResult invResult) {
        logger.debug("组装预配送数据");
        ORDR0201BForecastOrderResult batchOrderResult = new ORDR0201BForecastOrderResult();
        // region 设置预配送表
        Date createTime = DateUtils.getCurrent();
        Long buyerForcastDeliverDetailId = baseRedisDao.getTablePrimaryKey("ORDR_BUYER_FORCAST_DELIVER_DETAIL", 1);
        BuyerForcastDeliverDetailEntity buyerForcastDeliverDetailEntity = new BuyerForcastDeliverDetailEntity();
        buyerForcastDeliverDetailEntity.setBuyerForcastDeliverDetailId(buyerForcastDeliverDetailId);
        buyerForcastDeliverDetailEntity.setBuyerBatchOrderId(batchOrderDetail.getBuyerBatchOrderId());
        buyerForcastDeliverDetailEntity.setBuyerBatchOrderDetailId(batchOrderDetail.getBuyerBatchOrderDetailId());
        buyerForcastDeliverDetailEntity.setForcastType(ForcastType.STANDARD_SPLIT_DISTRIBUTION.getCode());
        buyerForcastDeliverDetailEntity.setSellSideType(batchOrderDetail.getSellSideType());
        buyerForcastDeliverDetailEntity.setSellSideId(batchOrderDetail.getSellSideId());
        buyerForcastDeliverDetailEntity.setGoodsId(batchOrderDetail.getGoodsId());
        buyerForcastDeliverDetailEntity.setProductId(batchOrderDetail.getProductId());
        buyerForcastDeliverDetailEntity.setManufacturerId(Long.valueOf(invResult.getProducerId()));
        buyerForcastDeliverDetailEntity.setSellerId(batchOrderDetail.getSellerId());
        buyerForcastDeliverDetailEntity.setSku(invResult.getSkuCode());
        buyerForcastDeliverDetailEntity.setBatchId(batchOrderDetail.getBatchId());
        buyerForcastDeliverDetailEntity.setSaleLabelId(batchOrderDetail.getSaleLabelId());
        buyerForcastDeliverDetailEntity.setDelFlg(false);
        buyerForcastDeliverDetailEntity.setCrtId("ORDR0201B");
        buyerForcastDeliverDetailEntity.setCrtTime(createTime);
        buyerForcastDeliverDetailEntity.setUpdId("ORDR0201B");
        buyerForcastDeliverDetailEntity.setUpdTime(createTime);
        buyerForcastDeliverDetailEntity.setVersion(1);
        buyerForcastDeliverDetailEntity.setPlanSendQuantity(batchOrderDetail.getGoodsQuantity());
        buyerForcastDeliverDetailEntity.setDelayQuantity(BigDecimal.ZERO);
        buyerForcastDeliverDetailEntity.setReceiveQuantity(BigDecimal.ZERO);
        buyerForcastDeliverDetailEntity.setRejectQuantity(BigDecimal.ZERO);
        buyerForcastDeliverDetailEntity.setReturnQuantity(BigDecimal.ZERO);
        buyerForcastDeliverDetailEntity.setRealSendQuantity(BigDecimal.ZERO);
        // endregion
        // region 设置预配送附表
        BuyerForcastDeliverDetailAttachedEntity buyerForcastDeliverDetailAttachedEntity = new BuyerForcastDeliverDetailAttachedEntity();
        buyerForcastDeliverDetailAttachedEntity.setBuyerForcastDeliverDetailId(buyerForcastDeliverDetailId);
        buyerForcastDeliverDetailAttachedEntity.setItemCode(batchOrderDetail.getItemCode());
        buyerForcastDeliverDetailAttachedEntity.setItemName(batchOrderDetail.getItemName());
        buyerForcastDeliverDetailAttachedEntity.setBrandCode(batchOrderDetail.getBrandCode());
        buyerForcastDeliverDetailAttachedEntity.setBrandName(batchOrderDetail.getBrandName());
        buyerForcastDeliverDetailAttachedEntity.setItemBrandCode(batchOrderDetail.getBrandCode());
        buyerForcastDeliverDetailAttachedEntity.setBatchCode(batchOrderDetail.getBatchCode());
        buyerForcastDeliverDetailAttachedEntity.setSaleLabelCode(batchOrderDetail.getSaleLabelCode());
        buyerForcastDeliverDetailAttachedEntity.setSaleLabelName(batchOrderDetail.getSaleLabelName());
        buyerForcastDeliverDetailAttachedEntity.setSmallPackageFeature(batchOrderDetail.getSmallPackageFeature());
        buyerForcastDeliverDetailAttachedEntity.setQuantityPerPackage(batchOrderDetail.getQuantityPerPackage());
        buyerForcastDeliverDetailAttachedEntity.setNetWeight(batchOrderDetail.getNetWeight());
        buyerForcastDeliverDetailAttachedEntity.setGrossWeight(batchOrderDetail.getGrossWeight());
        buyerForcastDeliverDetailAttachedEntity.setCartonSize(batchOrderDetail.getCartonSize());
        buyerForcastDeliverDetailAttachedEntity.setGoodsCode(batchOrderDetail.getGoodsCode());
        buyerForcastDeliverDetailAttachedEntity.setGoodsName(batchOrderDetail.getGoodsName());
        buyerForcastDeliverDetailAttachedEntity.setProductLevel(batchOrderDetail.getProductLevel());
        buyerForcastDeliverDetailAttachedEntity.setPalletStandardStackQuantity(batchOrderDetail.getPalletStandardStackQuantity());
        buyerForcastDeliverDetailAttachedEntity.setCrtId("ORDR0201B");
        buyerForcastDeliverDetailAttachedEntity.setCrtTime(createTime);
        buyerForcastDeliverDetailAttachedEntity.setUpdId("ORDR0201B");
        buyerForcastDeliverDetailAttachedEntity.setUpdTime(createTime);
        buyerForcastDeliverDetailAttachedEntity.setDelFlg(false);
        buyerForcastDeliverDetailAttachedEntity.setVersion(1);
        // endregion
        batchOrderResult.setBuyerForcastDeliverDetailAttachedEntity(buyerForcastDeliverDetailAttachedEntity);
        batchOrderResult.setBuyerForcastDeliverDetailEntity(buyerForcastDeliverDetailEntity);
        return batchOrderResult;
    }


    // region 保存买手囤货销售数据
    /**
     * 保存买手囤货销售数据
     *
     * @param result
     * @param stockpileSaleDetailResults
     */
    public void saveBsStockpileSaleDetail(ORDR0201BForecastOrderResult result, List<BsStockpileSaleDetailResult> stockpileSaleDetailResults) {
        if (CollectionUtils.isEmpty(stockpileSaleDetailResults)) {
            return;
        }
        BuyerForcastDeliverDetailEntity buyerForcastDeliverDetailEntity = result.getBuyerForcastDeliverDetailEntity();
        BigDecimal planSendQuantity = buyerForcastDeliverDetailEntity.getPlanSendQuantity();
        for (BsStockpileSaleDetailResult stockpileSaleDetailResult : stockpileSaleDetailResults) {
            if (planSendQuantity.compareTo(BigDecimal.ZERO) == NumberUtils.INTEGER_ZERO) {
                break;
            }
            BsStockpileSaleDetailEntity bsStockpileSaleDetailEntity = new BsStockpileSaleDetailEntity();
            if (planSendQuantity.compareTo(stockpileSaleDetailResult.getSaleQuantity()) > NumberUtils.INTEGER_ZERO) {
                planSendQuantity = DecimalUtils.subtract(planSendQuantity, stockpileSaleDetailResult.getSaleQuantity());
                bsStockpileSaleDetailEntity = getBsStockpileSaleDetail(stockpileSaleDetailResult.getSaleQuantity(), stockpileSaleDetailResult, buyerForcastDeliverDetailEntity);
                ordr0201BDao.saveBsStockpileSaleDetail(bsStockpileSaleDetailEntity);
            } else {
                bsStockpileSaleDetailEntity = getBsStockpileSaleDetail(planSendQuantity, stockpileSaleDetailResult, buyerForcastDeliverDetailEntity);
                ordr0201BDao.saveBsStockpileSaleDetail(bsStockpileSaleDetailEntity);
                planSendQuantity = BigDecimal.ZERO;
            }
        }
    }

    /**
     * 得到买手销售明细数据
     *
     * @param saleQuantity
     * @param stockpileSaleDetailResult
     * @param buyerForcastDeliverDetailEntity
     * @return
     */
    public BsStockpileSaleDetailEntity getBsStockpileSaleDetail(BigDecimal saleQuantity, BsStockpileSaleDetailResult stockpileSaleDetailResult, BuyerForcastDeliverDetailEntity buyerForcastDeliverDetailEntity) {
        Date createTime = DateUtils.getCurrent();
        BsStockpileSaleDetailEntity bsStockpileSaleDetailEntity = new BsStockpileSaleDetailEntity();
        bsStockpileSaleDetailEntity.setBsStockpileSplitDetailId(stockpileSaleDetailResult.getBsStockpileSplitDetailId());
        bsStockpileSaleDetailEntity.setStockpileSaleDetailId(baseRedisDao.getTablePrimaryKey("ORDR_BS_STOCKPILE_SALE_DETAIL", NumberUtils.INTEGER_ONE));
        bsStockpileSaleDetailEntity.setBuyerForcastDeliverDetailId(buyerForcastDeliverDetailEntity.getBuyerForcastDeliverDetailId());
        bsStockpileSaleDetailEntity.setSaleQuantity(saleQuantity);
        bsStockpileSaleDetailEntity.setVersion(NumberUtils.INTEGER_ONE);
        bsStockpileSaleDetailEntity.setCrtTime(createTime);
        bsStockpileSaleDetailEntity.setCrtId("ORDR0201B");
        bsStockpileSaleDetailEntity.setUpdTime(createTime);
        bsStockpileSaleDetailEntity.setUpdId("ORDR0201B");
        bsStockpileSaleDetailEntity.setDelFlg(false);
        return bsStockpileSaleDetailEntity;
    }
    // endregion

    /**
     * 查询生产商基本信息
     *
     * @param results
     * @return
     */
    public SLIM0250IEntitySellerResult getSLIM0250IResult(List<ORDR0201BForecastOrderResult> results) {
        SLIM0250IParam param = new SLIM0250IParam();
        ORDR0201BForecastOrderResult result = results.get(NumberUtils.INTEGER_ZERO);
        List<Long> producerIds = new ArrayList<>();
        producerIds.add(new Long(result.getBuyerForcastDeliverDetailEntity().getManufacturerId()));
        param.setEntitySellerIds(producerIds);
        param.setRoleId("1");
        return baseRestClientUtil.getManufactureInfo(param);
    }

    /**
     * 得到卖家基本信息
     *
     * @param results
     */
    public void getSellerResult(List<ORDR0201BForecastOrderResult> results) {
        List<Long> sellerIds = new ArrayList<>();
        SLIM0250IParam param = new SLIM0250IParam();
        for (ORDR0201BForecastOrderResult result : results) {
            sellerIds.add(Long.valueOf(result.getBuyerForcastDeliverDetailEntity().getSellerId()));
        }
        param.setEntitySellerIds(sellerIds);
        param.setRoleId("4");
        List<SLIM0250IEntitySellerResult> slim0250IResults = baseRestClientUtil.getSellerInfo(param);
        if (CollectionUtils.isEmpty(slim0250IResults)) {
            return;
        }
        for (ORDR0201BForecastOrderResult result : results) {
            for (SLIM0250IEntitySellerResult slim0250IResult : slim0250IResults) {
                if (result.getBuyerForcastDeliverDetailEntity().getSellerId().equals(slim0250IResult.getEntitySellerId().toString())) {
                    result.getBuyerForcastDeliverDetailAttachedEntity().setSellerName(slim0250IResult.getFullName());
                    result.getBuyerForcastDeliverDetailAttachedEntity().setSellerCode(slim0250IResult.getEntitySellerCode());
                    //todo 买手信息补全
//                    result.getBuyerForcastDeliverDetailAttachedEntity().setSellSideName(slim0250IResult.getFullName());
//                    result.getBuyerForcastDeliverDetailAttachedEntity().setSellSideCode(slim0250IResult.getEntitySellerCode());
                    break;
                }
            }
        }
    }

    /**
     * 获取认可生产商
     *
     * @param result
     * @return
     */
    public List<ORDR0201BManufacturerResult> getManufacturerResults(ORDR0201BOrderGoodsResult result) {
        //根据买家Id 查询买家接口得到买家认可生产商信息和买手信息 todo 调用接口
        logger.debug("查询买家接口 得到买家认可生产商信息和买手信息");
        List<ORDR0201BManufacturerResult> manufacturerResults = getBuyerManufacturerInfo(result);
        //查询订单这边买家历史无退货品牌生产商
        logger.debug("查询订单这边买家历史无退货品牌生产商");
        List<ORDR0201BManufacturerResult> orderManufacturerResults = ordr0201BDao.getOrderManufacturer(result);
        //整合上面两个List
        List<ORDR0201BManufacturerResult> allManufacturerResults = getAllManufacturer(manufacturerResults, orderManufacturerResults);
        return allManufacturerResults;
    }

    /**
     * 调用查询查询买家可用生产商数据
     *
     * @param orderResult
     * @return
     */
    public List<ORDR0201BManufacturerResult> getBuyerManufacturerInfo(ORDR0201BOrderGoodsResult orderResult) {
//        List<ORDR0201BManufacturerResult> results = new ArrayList<>();
//        QueryApproveManufactureRestParam param = new QueryApproveManufactureRestParam();
//        List<String> buyersIds = new ArrayList<>();
//        buyersIds.add(orderResult.getBuyerId());
//        param.setBuyersIds(buyersIds);
//        RestResponse<QueryApproveManufactureRestResult> response = BaseRestClientUtil.getBuyerManufactureInfo(param);
//
//        if (null != response && null != response.getResult() && !CollectionUtils.isEmpty(response.getResult().getManufactureList())) {
//            List<QueryApproveManufactureRestResult.Manufacture> manufactureList = response.getResult().getManufactureList();
//            String bsId = "";
//            if (!CollectionUtils.isEmpty(response.getResult().getBsList())) {
//                bsId = response.getResult().getBsList().get(0).getBsId();
//            }
//            for (QueryApproveManufactureRestResult.Manufacture manufacture : manufactureList) {
//                ORDR0201BManufacturerResult result = new ORDR0201BManufacturerResult();
//                result.setManufacturerId(manufacture.getManufacturerId());
//                result.setManufacturerCode(manufacture.getManufacturerCode());
//                result.setManufacturerName(manufacture.getManufacturerName());
//                result.setBsId(bsId);
//                results.add(result);
//            }
//        }
        return null;
    }

    /**
     * 整合数据
     * 买家那边的认可生产商数据如果和订单的这边认可生产商数据，买家那边的优先选择分拆
     *
     * @param manufacturerResults
     * @param orderManufacturerResults
     * @return
     */
    public List<ORDR0201BManufacturerResult> getAllManufacturer(List<ORDR0201BManufacturerResult> manufacturerResults, List<ORDR0201BManufacturerResult> orderManufacturerResults) {
        if (CollectionUtils.isEmpty(manufacturerResults)) {
            return orderManufacturerResults;
        }

        if (CollectionUtils.isEmpty(orderManufacturerResults)) {
            return manufacturerResults;
        }
        List<ORDR0201BManufacturerResult> newManufacturerResults = new ArrayList<>();
        newManufacturerResults.addAll(manufacturerResults);

        for (ORDR0201BManufacturerResult manufacturerResult : manufacturerResults) {
            for (ORDR0201BManufacturerResult orderManufacturerResult : orderManufacturerResults) {
                if (manufacturerResult.getManufacturerId() != orderManufacturerResult.getManufacturerId()) {
                    newManufacturerResults.add(orderManufacturerResult);
                }
            }
        }

        return newManufacturerResults;
    }

    /**
     * 更新订单状态和分批订单状态
     *
     * @param paramOrderBatchResults
     * @param orderResult
     * @param orderGoodsResults
     */
    public void confirmBatchOrder(List<ORDR0201BOrderBatchResult> paramOrderBatchResults, ORDR0201BOrderResult orderResult, List<ORDR0201BOrderGoodsResult> orderGoodsResults) {
        List<ORDR0201BOrderBatchResult> orderBatchResults = dealOrderBatchResults(paramOrderBatchResults);
        // region 首次下单
        logger.debug("首次下单判断");
        Integer count = ordr0201BDao.getOtherOrderCount(orderResult);
        if (count > NumberUtils.INTEGER_ZERO) {
            //更改分批订单明细状态为分拆待确认
            for (ORDR0201BOrderBatchResult orderBatchResult : orderBatchResults) {
                orderBatchResult.setBuyerBatchOrderFlg(false);
            }
        }
        // endregion
        // region 买家的商品存在退货
        logger.debug("买家的商品存在退货");
        for (ORDR0201BOrderGoodsResult orderGoodsResult : orderGoodsResults) {
            Integer returnCount = ordr0201BDao.getReturnCount(orderGoodsResult);
            if (returnCount > NumberUtils.INTEGER_ZERO) {
                dealMostPriceFailBatchOrderFlg(orderBatchResults, orderGoodsResult);
            }
        }
        // endregion
        //region 价盘超过大宗一级订单
        //组装查询价盘参数
        ArrayList<PRCE0211IParam> paramList = new ArrayList<PRCE0211IParam>();
        for (ORDR0201BOrderGoodsResult orderGoodsResult : orderGoodsResults) {
            PRCE0211IParam restParam = new PRCE0211IParam();
            restParam.setBuyerLevel(NumberUtils.INTEGER_ZERO.toString());
            String[] compareTime = {orderGoodsResult.getOrderPlaceDatetime()};
            restParam.setCompareTime(compareTime);
            restParam.setReturnType(NumberUtils.INTEGER_ZERO);
            restParam.setGoodId(orderGoodsResult.getGoodsId());
            restParam.setLgcsAreaCode(orderResult.getLogisticsZoneCode());
            if (orderResult.getNetBuyerFlg()) {
                restParam.setUserType(UserType.NET_BUYER.getCode());
            } else {
                restParam.setUserType(UserType.STANDARD_BUYER.getCode());
            }
            paramList.add(restParam);
        }

        //调用价盘接口得到结果
        logger.debug("调用价盘接口");
        List<PRCE0211IResult> results = baseRestClientUtil.getPriceResult(paramList);
        if (!CollectionUtils.isEmpty(results)) {
            //得到不需要确认的分批订单
            for (ORDR0201BOrderGoodsResult orderGoodsResult : orderGoodsResults) {
                for (PRCE0211IResult result : results) {
                    if (result.getGoodId().equals(orderGoodsResult.getGoodsId())) {
                        List<PRCE0211IDetailResult> plateDetailList = result.getPlateDetailList();
                        PRCE0211IDetailResult detailResult = plateDetailList.get(NumberUtils.INTEGER_ZERO);
                        if (orderGoodsResult.getGoodsQuantity().compareTo(detailResult.getStartQty()) >= NumberUtils.INTEGER_ZERO) {
                            //是超过大宗一级订单的产品
                            dealMostPriceFailBatchOrderFlg(orderBatchResults, orderGoodsResult);
                            break;
                        }
                    }
                }
            }
        }
        //endregion

        for (ORDR0201BOrderBatchResult orderBatchResult : orderBatchResults) {
            //分拆失败 分批订单状态为分拆失败
            // todo 待确认的状态优先于部分分拆，需修改
            if ("1".equals(orderBatchResult.getBuyerBatchOrderSplitFlg())) {
                orderBatchResult.setBuyerBatchOrderStu(OrderStatusConstant.BuyerBatchOrderStu.SPLIT_FAIL);
            } else if ("2".equals(orderBatchResult.getBuyerBatchOrderSplitFlg())){
                orderBatchResult.setBuyerBatchOrderStu(OrderStatusConstant.BuyerBatchOrderStu.PART_SPLIT);
            } else if (orderBatchResult.getBuyerBatchOrderFlg()) {
                //分拆成功的并且不满足上诉条件的分批订单状态为已确认
                logger.debug("分拆成功 已确认");
                orderBatchResult.setBuyerBatchOrderStu(OrderStatusConstant.BuyerBatchOrderStu.CONFIRMED);
            } else {
                //其他的为分拆待确认
                logger.debug("分拆成功 待确认");
                orderBatchResult.setBuyerBatchOrderStu(OrderStatusConstant.BuyerBatchOrderStu.SPLIT_CONFIRM);
            }
            //插入分批订单履历表
            logger.debug("插入分批订单履历表");
            BuyerBatchOrderHistoryEntity buyerBatchOrderHistoryEntity = ordr0201BDao.getBuyerBatchOrderHistory(orderBatchResult);
            buyerBatchOrderHistoryEntity.setHistoryId(baseRedisDao.getTablePrimaryKey("ORDR_BUYER_BATCH_ORDER_HISTORY", 1));
            ordr0201BDao.saveBuyerBatchOrderHistory(buyerBatchOrderHistoryEntity);
            //更新分批订单状态
            logger.debug("更新分批订单状态");
            ordr0201BDao.modifyBatchOrderStu(orderBatchResult);
        }
        orderResult.setBuyerOrderStu(OrderStatusConstant.BuyerOrderStu.NOT_COMPLETED);
        //插入订单履历表
        BuyerOrderHistoryEntity buyerOrderHistoryEntity = ordr0201BDao.getBuyerOrderHistory(orderResult);
        buyerOrderHistoryEntity.setHistoryId(baseRedisDao.getTablePrimaryKey("ORDR_BUYER_ORDER_HISTORY", 1));
        ordr0201BDao.saveBuyerOrderHistory(buyerOrderHistoryEntity);
        //更新订单状态
        logger.debug("更新订单状态");
        ordr0201BDao.modifyBuyerOrderStu(orderResult);
    }

    /**
     * 处理分批订单
     *
     * @param paramOrderBatchResults
     */
    public List<ORDR0201BOrderBatchResult> dealOrderBatchResults(List<ORDR0201BOrderBatchResult> paramOrderBatchResults) {
        // paramOrderBatchResults可能会有重复，既有成功又有失败的，标记为部分分拆
        Map<Long,ORDR0201BOrderBatchResult> orderBatchMap = new HashMap<>();
        for (ORDR0201BOrderBatchResult result : paramOrderBatchResults){
            if (orderBatchMap.get(result.getBuyerBatchOrderId())== null){
                orderBatchMap.put(result.getBuyerBatchOrderId(),result);
            } else {
                ORDR0201BOrderBatchResult orderBatchResult = orderBatchMap.get(result.getBuyerBatchOrderId());
                if (!result.getBuyerBatchOrderSplitFlg().equals(orderBatchResult.getBuyerBatchOrderSplitFlg())) {
                    result.setBuyerBatchOrderSplitFlg("2");
                }
                orderBatchMap.put(result.getBuyerBatchOrderId(),result);
            }
        }
        return new ArrayList<ORDR0201BOrderBatchResult>(orderBatchMap.values());
    }

    /**
     * 分拆待确认flg设置
     *
     * @param orderBatchResults
     * @param orderGoodsResult
     */
    public void dealMostPriceFailBatchOrderFlg(List<ORDR0201BOrderBatchResult> orderBatchResults, ORDR0201BOrderGoodsResult orderGoodsResult) {
        List<ORDR0201BOrderBatchResult> newOrderBatchResults = ordr0201BDao.getNewOrderBatchResult(orderGoodsResult);
        if (CollectionUtils.isEmpty(newOrderBatchResults)) {
            return;
        }

        for (ORDR0201BOrderBatchResult orderBatchResult : orderBatchResults) {
            for (ORDR0201BOrderBatchResult newOrderBatchResult : newOrderBatchResults) {
                if (newOrderBatchResult.getBuyerBatchOrderId().equals(orderBatchResult.getBuyerBatchOrderId())) {
                    orderBatchResult.setBuyerBatchOrderFlg(false);
                }
            }
        }
    }

    /**
     * 占用库存 并且返回占用正确与否
     *
     * @return
     */
    public void addStockInfo(List<ORDR0201BForecastOrderResult> results, ORDR0201BOrderResult orderResult) {
        logger.debug("占用库存");
        if (CollectionUtils.isEmpty(results)) {
            return;
        }
        ArrayList<LINV0103IParam> params = new ArrayList<>();
        for (ORDR0201BForecastOrderResult result : results) {
            LINV0103IParam param = new LINV0103IParam();
            LINV0103IAllocationParam allocation = param.getAllocation();
            LINV0103ISourceParam source = param.getSource();
            BuyerForcastDeliverDetailEntity forecastEntity = result.getBuyerForcastDeliverDetailEntity();
            BuyerForcastDeliverDetailAttachedEntity forecastAttachedEntity = result.getBuyerForcastDeliverDetailAttachedEntity();


            source.setLogicAreaId(orderResult.getLogisticsZoneId());
            source.setOwnerId(forecastEntity.getSellerId());
            source.setOwnerCode(forecastAttachedEntity.getSellerCode());
            source.setOwnerType(LinvOwnerType.Seller.getCode());
            source.setSalePlatform(SalePlatform.YDP_PLATFORM.getCode());
            source.setSkuCode(forecastEntity.getSku());
            source.setLotNo(forecastAttachedEntity.getBatchCode());
            source.setIvType(InvType.Normal.getCode());
            source.setSaleStatusId(forecastEntity.getSaleLabelId());
            source.setUom(LinvUom.Box.getCode());

            allocation.setRefNo(orderResult.getBuyerOrderCode());
            allocation.setTransactionId(orderResult.getBuyerOrderId());
            allocation.setTransactionNo(orderResult.getBuyerOrderCode());
            allocation.setTransactionSource("ORDR");
            allocation.setTransactionDetailId(forecastEntity.getBuyerForcastDeliverDetailId());
            allocation.setTransactionSequence(NumberUtils.INTEGER_ONE);
            allocation.setTargetId(orderResult.getBuyerId());
            allocation.setTargetCode(orderResult.getBuyerCode());
            allocation.setTargetType(LinvOwnerType.Buyer.getCode());
            allocation.setAlocQty(forecastEntity.getPlanSendQuantity());
            if (forecastEntity.getSellSideType().equals(SellSideType.PLATFORM_TYPE.getCode())) {
                allocation.setBizType(BizType.SellerSale.getCode());
            } else  {
                allocation.setBizType(BizType.AgentSale.getCode());
            }
            param.setAllocation(allocation);
            param.setSource(source);
            params.add(param);
        }
        baseRestClientUtil.addAllocateInv(params);
    }

    /**
     * 发送邮件
     */
    @Override
    public void sendEmail() {
        this.sendWaitConfirmEmail();
        this.sendSplitFailEmail();
    }

    /**
     * 发送分拆失败提醒邮件
     */
    public void sendSplitFailEmail() {
        logger.debug("查询需要发邮件的订单");
        // 查询需要发邮件的订单
        List<BuyerOrderEntity> orderResults = ordr0201BDao.getSplitFailedResults();
        if (CollectionUtils.isEmpty(orderResults)){
            return;
        }
        List<OrderBatchEmailResult> emailResults = new ArrayList<>();
        for (BuyerOrderEntity entity : orderResults){
            OrderBatchEmailResult result = new OrderBatchEmailResult();
            result.setBatchNo("ORDR0201B");
            result.setErrorMessage("库存不足，分拆失败");
            result.setOrderId(entity.getBuyerOrderId());
            result.setOrderCode(entity.getBuyerOrderCode());
            emailResults.add(result);
        }
        baseRestClientUtil.sendFailMail(emailResults);
    }

    /**
     * 发送分拆待确认邮件
     */
    public void sendWaitConfirmEmail() {
        logger.debug("查询需要发邮件的订单");
        // 查询需要发邮件的订单
        List<BuyerOrderHistoryEntity> orderResults = ordr0201BDao.getOrderEmialResults();
        if (CollectionUtils.isEmpty(orderResults)) {
            return;
        }
        // 查询邮件地址
        logger.debug("查询邮件地址");
        List<String> emailAddress = ordr0201BDao.findEmailAddress();
        if (CollectionUtils.isEmpty(emailAddress)) {
            return;
        }

        // 发送邮件
        logger.debug("发送邮件");
        RestRequest<MailSendRsParam> restRequest = new RestRequest<MailSendRsParam>();
        MailSendRsParam param = new MailSendRsParam();
        // 模板邮件内容
        List<ORDR0201BOrderEmailResult> emailResults = new ArrayList<>();
        for (BuyerOrderEntity entity : orderResults) {
            ORDR0201BOrderEmailResult emailResult = new ORDR0201BOrderEmailResult();
            emailResult.setOrderId(entity.getBuyerOrderId());
            emailResult.setOrderCode(entity.getBuyerOrderCode());
            emailResults.add(emailResult);
        }
        Map<String, Object> templateData = new HashMap<>();
        templateData.put("orders", emailResults);
        param.setTemplateData(templateData);
        // 模板邮件地址
        String[] arr = emailAddress.toArray(new String[0]);
        param.setMailTo(arr);
        // 模板邮件主题
        param.setSubject("买家订单审核通知");
        // 模板名称
        param.setTemplateName("BuyerOrderAuditNotice.vm");
        restRequest.setParam(param);
        RestResponse<String> restResponse = baseRestClientUtil.sendMail(restRequest);
        if (null != restResponse && "S".equals(restResponse.getStatus())) {
            //插入订单履历表
            Long maxId = baseRedisDao.getTablePrimaryKey("ORDR_BUYER_ORDER_HISTORY", orderResults.size());
            for (BuyerOrderHistoryEntity orderHistoryEntity : orderResults) {
                orderHistoryEntity.setHistoryId(maxId--);
            }
            ordr0201BDao.batchInsert(orderResults);
            // 修改邮件flg
            logger.debug("修改邮件flg");
            ordr0201BDao.modifyMailedFlg(orderResults);
        }
    }

    @Override
    public BaseDao getBaseDao() {
        return ordr0201BDao;
    }
}
