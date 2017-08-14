package com.bms.issue.external.archive;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

import com.alibaba.fastjson.TypeReference;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.common.rest.SearchRestParam;
import com.bms.issue.common.rest.SearchRestResult;
import com.bms.issue.common.rest.param.PageList;
import com.bms.issue.common.rest.param.RestOperator;
import com.bms.issue.constant.UrlConst;
import com.bms.issue.constant.i18n.ErrorCode;
import com.bms.issue.constant.i18n.ModuleCode;
import com.bms.issue.external.bean.entity.BuyerBatchOrderDetailEntity;
import com.bms.issue.external.bean.entity.BuyerBatchOrderEntity;
import com.bms.issue.external.bean.entity.BuyerForcastDeliverDetailEntity;
import com.bms.issue.external.bean.entity.BuyerOrderEntity;
import com.bms.issue.external.bean.param.BuyerOrderSearchFilter;
import com.bms.issue.external.bean.param.ORDR0105IFilterParam;
import com.bms.issue.external.bean.result.ORDR0105IL1RestResult;
import com.bms.issue.external.bean.result.ORDR0105IL2RestResult;
import com.bms.issue.external.bean.result.ORDR0105IL3RestResult;
import com.bms.issue.external.bean.result.ORDR0105IL4RestResult;
import com.framework.base.bean.Pagination;
import com.framework.base.bean.Sort;
import com.framework.exception.BusinessException;

/**
 * 买家
 * 
 * @author li_huiqian
 *
 */
public class BuyerOrder extends AbstractExternalArchive {

    /**
     * 买家订单Entity
     */
    private BuyerOrderEntity entity;

    /**
     * 获取买家Entity
     * 
     * @return
     */
    public BuyerOrderEntity getEntity() {
        return this.entity;
    }

    private BuyerOrder() {
    }

    /**
     * 通过买家订单ID查询买家订单
     * 
     * @param buyerOrderId
     * @return
     */
    public static BuyerOrder findById(Operator operator, long buyerOrderId) {
        Assert.isTrue(buyerOrderId > 0);

        // 获取URL
        String url = UrlConst.API_ORDR_URL + UrlConst.ACTION_ORDR0105I;

        // 构造入参
        SearchRestParam<ORDR0105IFilterParam> param = new SearchRestParam<>();
        ORDR0105IFilterParam filter = new ORDR0105IFilterParam();
        filter.setBuyerOrderId(new Long[] { buyerOrderId });
        param.setFilter(filter);
        RestOperator restOperator = new RestOperator();
        restOperator.setOperatorId(operator.getOperatorId());
        restOperator.setOperatorType(operator.getOperatorType());
        param.setOperator(restOperator);

        // 返回值类型
        TypeReference<SearchRestResult<ORDR0105IL1RestResult>> typeReference = new TypeReference<SearchRestResult<ORDR0105IL1RestResult>>() {
        };

        // 构造对象
        BuyerOrder buyerOrder = new BuyerOrder();
        // 调用接口
        SearchRestResult<ORDR0105IL1RestResult> searchRestResult = buyerOrder.getRestClient().post(url, param,
                typeReference);

        // 判断检索结果
        if (searchRestResult.getTotal() > 1)
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E000002, "通过一个买家订单ID查找到多个买家订单");

        if (searchRestResult.getTotal() == 0)
            return null;

        // 获取买家订单信息
        ORDR0105IL1RestResult result = searchRestResult.getData().get(0);
        BuyerOrderEntity entity = buyerOrder.convert(result);

        buyerOrder.entity = entity;
        buyerOrder.setDataSynced(true);

        return buyerOrder;
    }

    /**
     * 查询买家订单列表
     * 
     * @param filter
     * @param pageSize
     * @param startPos
     * @param pagingLevel
     * @return
     */
    public static PageList<BuyerOrder> findList(Operator operator, BuyerOrderSearchFilter filter, int pageSize,
            int startPos,
            int pagingLevel) {
        Assert.notNull(filter);
        Assert.isTrue(pageSize > 0);
        Assert.isTrue(startPos > 0);
        Assert.isTrue(1 <= pagingLevel && pagingLevel <= 4);

        // 获取URL
        String url = UrlConst.API_ORDR_URL + UrlConst.ACTION_ORDR0105I;

        // 构造对象
        BuyerOrder temp = new BuyerOrder();
        // 构造入参
        SearchRestParam<ORDR0105IFilterParam> param = new SearchRestParam<>();
        ORDR0105IFilterParam restFilter = temp.convert(filter);
        param.setFilter(restFilter);
        RestOperator restOperator = new RestOperator();
        restOperator.setOperatorId(operator.getOperatorId());
        restOperator.setOperatorType(operator.getOperatorType());
        param.setOperator(restOperator);
        Sort sort = new Sort();
        sort.setDescFlag(true);
        sort.setSortField("buyerOrderId");
        param.setSort(new Sort[] { sort });
        Pagination pagination = new Pagination();
        pagination.setPageSize(pageSize);
        pagination.setStartPos(startPos);
        param.setPagination(pagination);
        param.setPagingLevel(pagingLevel);

        // 返回值类型
        TypeReference<SearchRestResult<ORDR0105IL1RestResult>> typeReference = new TypeReference<SearchRestResult<ORDR0105IL1RestResult>>() {
        };

        // 调用接口
        SearchRestResult<ORDR0105IL1RestResult> searchRestResult = temp.getRestClient().post(url, param, typeReference);

        PageList<BuyerOrder> buyerOrders = new PageList<>(searchRestResult.getTotal());

        // 获取买家订单信息
        if (searchRestResult.getTotal() != 0) {
            for (ORDR0105IL1RestResult result : searchRestResult.getData()) {
                BuyerOrder buyerOrder = new BuyerOrder();
                BuyerOrderEntity entity = temp.convert(result);
                buyerOrder.entity = entity;
                buyerOrder.setDataSynced(true);
                buyerOrders.add(buyerOrder);
            }
        }

        return buyerOrders;
    }

    /**
     * 类型转换
     * 
     * @param filter
     * @return
     */
    private ORDR0105IFilterParam convert(BuyerOrderSearchFilter filter) {
        ORDR0105IFilterParam restFilter = new ORDR0105IFilterParam();
        restFilter.setBuyerOrderId(filter.getBuyerOrderId());
        restFilter.setBuyerOrderCode(filter.getBuyerOrderCode());
        restFilter.setOrderType(filter.getOrderType());
        restFilter.setBatchFlg(filter.getBatchFlg());
        restFilter.setOrderSourceType(filter.getOrderSourceType());
        restFilter.setSalePlatformType(filter.getSalePlatformType());
        restFilter.setBuyerOrderStu(filter.getBuyerOrderStu());
        restFilter.setOrderPlaceType(filter.getOrderPlaceType());
        restFilter.setOrderPlacerType(filter.getOrderPlacerType());
        restFilter.setOrderPlacerId(filter.getOrderPlacerId());
        restFilter.setOrderPlacerCode(filter.getOrderPlacerCode());
        restFilter.setOrderPlacerName(filter.getOrderPlacerName());
        restFilter.setOrderPlaceDateTimeFrom(filter.getOrderPlaceDateTimeFrom());
        restFilter.setOrderPlaceDateTimeTo(filter.getOrderPlaceDateTimeTo());
        restFilter.setPaymentType(filter.getPaymentType());
        restFilter.setInvoiceFlg(filter.getInvoiceFlg());
        restFilter.setUseNetFlg(filter.getUseNetFlg());
        restFilter.setLogisticsZoneId(filter.getLogisticsZoneId());
        restFilter.setLogisticsZoneCode(filter.getLogisticsZoneCode());
        restFilter.setLogisticsZoneName(filter.getLogisticsZoneName());
        restFilter.setBatchOrderId(filter.getBatchOrderId());
        restFilter.setBatchOrderCode(filter.getBatchOrderCode());
        restFilter.setRequiredDistributionDateFrom(filter.getRequiredDistributionDateFrom());
        restFilter.setRequiredDistributionDateTo(filter.getRequiredDistributionDateTo());
        restFilter.setBuyerBatchOrderStu(filter.getBuyerBatchOrderStu());
        restFilter.setBuyerBatchOrderDetailId(filter.getBuyerBatchOrderDetailId());
        restFilter.setBuyerId(filter.getBuyerId());
        restFilter.setBuyerCode(filter.getBuyerCode());
        restFilter.setBuyerName(filter.getBuyerName());
        restFilter.setBuyerType(filter.getBuyerType());
        restFilter.setNetBuyerFlg(filter.getNetBuyerFlg());
        restFilter.setBsType(filter.getBsType());
        restFilter.setBsId(filter.getBsId());
        restFilter.setBsName(filter.getBsName());
        restFilter.setSaId(filter.getSaId());
        restFilter.setSaName(filter.getSaName());
        restFilter.setSaCode(filter.getSaCode());
        restFilter.setForcastType(filter.getForcastType());
        restFilter.setSellSideType(filter.getSellSideType());
        restFilter.setSellSideId(filter.getSellSideId());
        restFilter.setSellSideCode(filter.getSellSideCode());
        restFilter.setSellSideName(filter.getSellSideName());
        restFilter.setGoodsId(filter.getGoodsId());
        restFilter.setGoodsCode(filter.getGoodsCode());
        restFilter.setGoodsName(filter.getGoodsName());
        restFilter.setSaleLabelId(filter.getSaleLabelId());
        restFilter.setSaleLabelCode(filter.getSaleLabelCode());
        restFilter.setSaleLabelName(filter.getSaleLabelName());
        restFilter.setManufacturerId(filter.getManufacturerId());
        restFilter.setManufacturerCode(filter.getManufacturerCode());
        restFilter.setManufacturerName(filter.getManufacturerName());
        restFilter.setSellerId(filter.getSellerId());
        restFilter.setSellerCode(filter.getSellerCode());
        restFilter.setSellerName(filter.getSellerName());
        restFilter.setRegionalDistributionStation(filter.getRegionalDistributionStation());
        restFilter.setRegionalDistributionStationCode(filter.getRegionalDistributionStationCode());
        restFilter.setRegionalDistributionStationName(filter.getRegionalDistributionStationName());
        return restFilter;
    }

    /**
     * 类型转换
     * 
     * @param result
     * @return
     */
    private BuyerOrderEntity convert(ORDR0105IL1RestResult result) {
        if (result == null)
            return null;

        BuyerOrderEntity l1Entity = new BuyerOrderEntity();
        l1Entity.setBuyerOrderId(result.getBuyerOrderId());
        l1Entity.setBuyerOrderCode(result.getBuyerOrderCode());
        l1Entity.setOrderType(result.getOrderType());
        l1Entity.setSalePlatformType(result.getSalePlatformType());
        l1Entity.setOrderSourceType(result.getOrderSourceType());
        l1Entity.setBatchFlg(result.getBatchFlg());
        l1Entity.setOrderSplitType(result.getOrderSplitType());
        l1Entity.setOrderPlacerId(result.getOrderPlacerId());
        l1Entity.setOrderPlacerType(result.getOrderPlacerType());
        l1Entity.setOrderPlaceDatetime(result.getOrderPlaceDatetime());
        l1Entity.setOrderPlaceType(result.getOrderPlaceType());
        l1Entity.setLogisticsZoneId(result.getLogisticsZoneId());
        l1Entity.setBuyerType(result.getBuyerType());
        l1Entity.setBuyerTypeName(result.getBuyerTypeName());
        l1Entity.setBuyerId(result.getBuyerId());
        l1Entity.setBsType(result.getBsType());
        l1Entity.setBsId(result.getBsId());
        l1Entity.setInvoiceFlg(result.getInvoiceFlg());
        l1Entity.setNetBuyerFlg(result.getNetBuyerFlg());
        l1Entity.setUseNetFlg(result.getUseNetFlg());
        l1Entity.setPaymentType(result.getPaymentType());
        l1Entity.setPaymentStu(result.getPaymentStu());
        l1Entity.setOrderAmount(result.getOrderAmount());
        l1Entity.setFreight(result.getFreight());
        l1Entity.setPreferentialAmount(result.getPreferentialAmount());
        l1Entity.setReceiveAmount(result.getReceiveAmount());
        l1Entity.setEarnestPercent(result.getEarnestPercent());
        l1Entity.setEarnestAmount(result.getEarnestAmount());
        l1Entity.setAdvancePaymentPercent(result.getAdvancePaymentPercent());
        l1Entity.setAdvancePaymentAmount(result.getAdvancePaymentAmount());
        l1Entity.setBuyerOrderStu(result.getBuyerOrderStu());
        l1Entity.setOrderPlacerCode(result.getOrderPlacerCode());
        l1Entity.setOrderPlacerName(result.getOrderPlacerName());
        l1Entity.setLogisticsZoneCode(result.getLogisticsZoneCode());
        l1Entity.setLogisticsZoneName(result.getLogisticsZoneName());
        l1Entity.setCityId(result.getCityId());
        l1Entity.setCityCode(result.getCityCode());
        l1Entity.setCityName(result.getCityName());
        l1Entity.setCountryId(result.getCountryId());
        l1Entity.setCountryCode(result.getCountryCode());
        l1Entity.setCountryName(result.getCountryName());
        l1Entity.setRegionalDistributionStation(result.getRegionalDistributionStation());
        l1Entity.setRegionalDistributionStationCode(result.getRegionalDistributionStationCode());
        l1Entity.setRegionalDistributionStationName(result.getRegionalDistributionStationName());
        l1Entity.setBuyerCode(result.getBuyerCode());
        l1Entity.setBuyerName(result.getBuyerName());
        l1Entity.setBuyerPhone(result.getBuyerPhone());
        l1Entity.setBuyerWechat(result.getBuyerWechat());
        l1Entity.setBuyerQq(result.getBuyerQq());
        l1Entity.setBuyerMail(result.getBuyerMail());
        l1Entity.setRegionalBsId(result.getRegionalBsId());
        l1Entity.setRegionalBsCode(result.getRegionalBsCode());
        l1Entity.setRegionalBsName(result.getRegionalBsName());
        l1Entity.setNonRegionalBsId(result.getNonRegionalBsId());
        l1Entity.setNonRegionalBsCode(result.getNonRegionalBsCode());
        l1Entity.setNonRegionalBsName(result.getNonRegionalBsName());
        l1Entity.setRegionalDistributionBsId(result.getRegionalDistributionBsId());
        l1Entity.setRegionalDistributionBsCode(result.getRegionalDistributionBsCode());
        l1Entity.setRegionalDistributionBsName(result.getRegionalDistributionBsName());
        l1Entity.setNetUserBsId(result.getNetUserBsId());
        l1Entity.setNetUserBsCode(result.getNetUserBsCode());
        l1Entity.setNetUserBsName(result.getNetUserBsName());
        l1Entity.setSaId(result.getSaId());
        l1Entity.setSaCode(result.getSaCode());
        l1Entity.setSaName(result.getSaName());
        l1Entity.setCancelType(result.getCancelType());
        l1Entity.setCancelPersonType(result.getCancelPersonType());
        l1Entity.setCancelPersonId(result.getCancelPersonId());
        l1Entity.setCancelPersonCode(result.getCancelPersonCode());
        l1Entity.setCancelPersonName(result.getCancelPersonName());
        l1Entity.setCancelDatetime(result.getCancelDatetime());
        l1Entity.setCancelReason(result.getCancelReason());
        l1Entity.setSortSeq(result.getSortSeq());
        l1Entity.setVersion(result.getVersion());

        if (result.getBatchOrders() != null && !result.getBatchOrders().isEmpty()) {
            List<BuyerBatchOrderEntity> l2Entities = new ArrayList<>();
            for (ORDR0105IL2RestResult l2Result : result.getBatchOrders()) {
                l2Entities.add(convert(l2Result));
            }
            l1Entity.setBatchOrders(l2Entities);
        }

        return l1Entity;
    }

    /**
     * 类型转换
     * 
     * @param result
     * @return
     */
    private BuyerBatchOrderEntity convert(ORDR0105IL2RestResult result) {
        if (result == null)
            return null;

        BuyerBatchOrderEntity l2Entity = new BuyerBatchOrderEntity();
        l2Entity.setBuyerBatchOrderId(result.getBuyerBatchOrderId());
        l2Entity.setBuyerBatchOrderCode(result.getBuyerBatchOrderCode());
        l2Entity.setBuyerOrderId(result.getBuyerOrderId());
        l2Entity.setRequiredDistributionDate(result.getRequiredDistributionDate());
        l2Entity.setExpectedSendDatetime(result.getExpectedSendDatetime());
        l2Entity.setExpectedArrivalDatetime(result.getExpectedArrivalDatetime());
        l2Entity.setOrderAmount(result.getOrderAmount());
        l2Entity.setFreight(result.getFreight());
        l2Entity.setPreferentialAmount(result.getPreferentialAmount());
        l2Entity.setReceiveAmount(result.getReceiveAmount());
        l2Entity.setEarnestPercent(result.getEarnestPercent());
        l2Entity.setEarnestAmount(result.getEarnestAmount());
        l2Entity.setAdvancePaymentPercent(result.getAdvancePaymentPercent());
        l2Entity.setAdvancePaymentAmount(result.getAdvancePaymentAmount());
        l2Entity.setBuyerBatchOrderStu(result.getBuyerBatchOrderStu());
        l2Entity.setReceiverName(result.getReceiverName());
        l2Entity.setReceiverPhone(result.getReceiverPhone());
        l2Entity.setReceiverQq(result.getReceiverQq());
        l2Entity.setReceiverWechat(result.getReceiverWechat());
        l2Entity.setReceiverMail(result.getReceiverMail());
        l2Entity.setReceiverProvince(result.getReceiverProvince());
        l2Entity.setReceiverCity(result.getReceiverCity());
        l2Entity.setReceiverDistrict(result.getReceiverDistrict());
        l2Entity.setReceiverAddress(result.getReceiverAddress());
        l2Entity.setReceiverAssistAddress(result.getReceiverAssistAddress());
        l2Entity.setDeliveryArea(result.getDeliveryArea());
        l2Entity.setPassTrafficModel(result.getPassTrafficModel());
        l2Entity.setDistributionType(result.getDistributionType());
        l2Entity.setReceivePeriod(result.getReceivePeriod());
        l2Entity.setReceiveEarliest(result.getReceiveEarliest());
        l2Entity.setReceiveLatest(result.getReceiveLatest());
        l2Entity.setReceiveWaitHour(result.getReceiveWaitHour());
        l2Entity.setAdvancedNotificationHour(result.getAdvancedNotificationHour());
        l2Entity.setAnimalQuarantineCertificationFlg(result.getAnimalQuarantineCertificationFlg());
        l2Entity.setStevedoreRequirement(result.getStevedoreRequirement());
        l2Entity.setPackageRequirement(result.getPackageRequirement());
        l2Entity.setNearestParkingDistance(result.getNearestParkingDistance());
        l2Entity.setRemark(result.getRemark());
        l2Entity.setSortSeq(result.getSortSeq());
        l2Entity.setVersion(result.getVersion());

        if (result.getBatchOrderDetails() != null && !result.getBatchOrderDetails().isEmpty()) {
            List<BuyerBatchOrderDetailEntity> l3Entities = new ArrayList<>();
            for (ORDR0105IL3RestResult l3Result : result.getBatchOrderDetails()) {
                l3Entities.add(convert(l3Result));
            }
            l2Entity.setBatchOrderDetails(l3Entities);
        }

        return l2Entity;
    }

    /**
     * 类型转换
     * 
     * @param result
     * @return
     */
    private BuyerBatchOrderDetailEntity convert(ORDR0105IL3RestResult result) {
        if (result == null)
            return null;

        BuyerBatchOrderDetailEntity l3Entity = new BuyerBatchOrderDetailEntity();
        l3Entity.setBuyerBatchOrderDetailId(result.getBuyerBatchOrderDetailId());
        l3Entity.setBuyerOrderId(result.getBuyerOrderId());
        l3Entity.setBuyerBatchOrderId(result.getBuyerBatchOrderId());
        l3Entity.setGoodsUnit(result.getGoodsUnit());
        l3Entity.setGoodsQuantity(result.getGoodsQuantity());
        l3Entity.setCancelQuantity(result.getCancelQuantity());
        l3Entity.setRealUnitPrice(result.getRealUnitPrice());
        l3Entity.setRealKgPrice(result.getRealKgPrice());
        l3Entity.setPriceWay(result.getPriceWay());
        l3Entity.setPriceCreateTime(result.getPriceCreateTime());
        l3Entity.setGoodsId(result.getGoodsId());
        l3Entity.setProductId(result.getProductId());
        l3Entity.setManufacturerId(result.getManufacturerId());
        l3Entity.setSellerId(result.getSellerId());
        l3Entity.setBatchId(result.getBatchId());
        l3Entity.setSaleLabelId(result.getSaleLabelId());
        l3Entity.setSplitFlg(result.getSplitFlg());
        l3Entity.setManualSplitFlg(result.getManualSplitFlg());
        l3Entity.setItemCode(result.getItemCode());
        l3Entity.setItemName(result.getItemName());
        l3Entity.setBrandCode(result.getBrandCode());
        l3Entity.setBrandName(result.getBrandName());
        l3Entity.setItemBrandCode(result.getItemBrandCode());
        l3Entity.setManufacturerCode(result.getManufacturerCode());
        l3Entity.setManufacturerName(result.getManufacturerName());
        l3Entity.setSellerCode(result.getSellerCode());
        l3Entity.setSellerName(result.getSellerName());
        l3Entity.setBatchCode(result.getBatchCode());
        l3Entity.setSaleLabelCode(result.getSaleLabelCode());
        l3Entity.setSaleLabelName(result.getSaleLabelName());
        l3Entity.setSmallPackageFeature(result.getSmallPackageFeature());
        l3Entity.setQuantityPerPackage(result.getQuantityPerPackage());
        l3Entity.setNetWeight(result.getNetWeight());
        l3Entity.setGrossWeight(result.getGrossWeight());
        l3Entity.setCartonSize(result.getCartonSize());
        l3Entity.setProductLevel(result.getProductLevel());
        l3Entity.setPalletStandardStackQuantity(result.getPalletStandardStackQuantity());
        l3Entity.setSortSeq(result.getSortSeq());
        l3Entity.setVersion(result.getVersion());

        if (result.getOrdrBuyerForcastDeliverDetails() != null
                && !result.getOrdrBuyerForcastDeliverDetails().isEmpty()) {
            List<BuyerForcastDeliverDetailEntity> l4Entities = new ArrayList<>();
            for (ORDR0105IL4RestResult l4Result : result.getOrdrBuyerForcastDeliverDetails()) {
                l4Entities.add(convert(l4Result));
            }
            l3Entity.setOrdrBuyerForcastDeliverDetails(l4Entities);
        }

        return l3Entity;
    }

    /**
     * 类型转换
     * 
     * @param result
     * @return
     */
    private BuyerForcastDeliverDetailEntity convert(ORDR0105IL4RestResult result) {
        if (result == null)
            return null;

        BuyerForcastDeliverDetailEntity l4Entity = new BuyerForcastDeliverDetailEntity();
        l4Entity.setBuyerForcastDeliverDetailId(result.getBuyerForcastDeliverDetailId());
        l4Entity.setBuyerBatchOrderId(result.getBuyerBatchOrderId());
        l4Entity.setBuyerBatchOrderDetailId(result.getBuyerBatchOrderDetailId());
        l4Entity.setForcastType(result.getForcastType());
        l4Entity.setSellSideType(result.getSellSideType());
        l4Entity.setSellSideId(result.getSellSideId());
        l4Entity.setGoodsId(result.getGoodsId());
        l4Entity.setProductId(result.getProductId());
        l4Entity.setManufacturerId(result.getManufacturerId());
        l4Entity.setSellerId(result.getSellerId());
        l4Entity.setSku(result.getSku());
        l4Entity.setBatchId(result.getBatchId());
        l4Entity.setSaleLabelId(result.getSaleLabelId());
        l4Entity.setPlanSendQuantity(result.getPlanSendQuantity());
        l4Entity.setRealSendQuantity(result.getRealSendQuantity());
        l4Entity.setReceiveQuantity(result.getReceiveQuantity());
        l4Entity.setRejectQuantity(result.getRejectQuantity());
        l4Entity.setDelayQuantity(result.getDelayQuantity());
        l4Entity.setRedistributionDate(result.getRedistributionDate());
        l4Entity.setReturnQuantity(result.getReturnQuantity());
        l4Entity.setSellSideCode(result.getSellSideCode());
        l4Entity.setSellSideName(result.getSellSideName());
        l4Entity.setItemCode(result.getItemCode());
        l4Entity.setItemName(result.getItemName());
        l4Entity.setBrandCode(result.getBrandCode());
        l4Entity.setBrandName(result.getBrandName());
        l4Entity.setItemBrandCode(result.getItemBrandCode());
        l4Entity.setManufacturerCode(result.getManufacturerCode());
        l4Entity.setManufacturerName(result.getManufacturerName());
        l4Entity.setSellerCode(result.getSellerCode());
        l4Entity.setSellerName(result.getSellerName());
        l4Entity.setBatchCode(result.getBatchCode());
        l4Entity.setSaleLabelCode(result.getSaleLabelCode());
        l4Entity.setSaleLabelName(result.getSaleLabelName());
        l4Entity.setSmallPackageFeature(result.getSmallPackageFeature());
        l4Entity.setQuantityPerPackage(result.getQuantityPerPackage());
        l4Entity.setNetWeight(result.getNetWeight());
        l4Entity.setGrossWeight(result.getGrossWeight());
        l4Entity.setCartonSize(result.getCartonSize());
        l4Entity.setProductLevel(result.getProductLevel());
        l4Entity.setPalletStandardStackQuantity(result.getPalletStandardStackQuantity());
        l4Entity.setSortSeq(result.getSortSeq());
        l4Entity.setVersion(result.getVersion());

        return l4Entity;
    }

}
