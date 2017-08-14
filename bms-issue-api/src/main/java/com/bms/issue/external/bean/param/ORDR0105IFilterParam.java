package com.bms.issue.external.bean.param;

import java.util.Date;

import com.bms.issue.common.rest.param.RestFilter;


/**
 * 买家订单查询接口Param
 *
 * @author li_huiqian
 */
public class ORDR0105IFilterParam extends RestFilter {

    private static final long serialVersionUID = 1632901366207081059L;

    /** 订单ID */
    private Long[] buyerOrderId;
    /** 订单编码 */
    private String buyerOrderCode;
    /** 订单类型 */
    private String[] orderType;
    /** 是否分批 */
    private Boolean batchFlg;
    /** 订单来源 */
    private String[] orderSourceType;
    /** 销售平台 */
    private String[] salePlatformType;
    /** 订单状态 */
    private String[] buyerOrderStu;
    /** 下单类型 */
    private String[] orderPlaceType;
    /** 下单员类型 */
    private String[] orderPlacerType;
    /** 下单员ID */
    private String[] orderPlacerId;
    /** 下单员编码 */
    private String orderPlacerCode;
    /** 下单员名称 */
    private String orderPlacerName;
    /** 下单时间开始 */
    private Date orderPlaceDateTimeFrom;
    /** 下单时间结束 */
    private Date orderPlaceDateTimeTo;
    /** 付款类型 */
    private String[] paymentType;
    /** 是否开发票 */
    private Boolean invoiceFlg;
    /** 是否使用账期 */
    private Boolean useNetFlg;
    /** 物流区ID */
    private Long[] logisticsZoneId;
    /** 物流区编码 */
    private String logisticsZoneCode;
    /** 物流区名称 */
    private String logisticsZoneName;
    /** 分批订单ID */
    private Long[] batchOrderId;
    /** 分批订单编码 */
    private String batchOrderCode;
    /** 期望配送日开始 */
    private Date requiredDistributionDateFrom;
    /** 期望配送日结束 */
    private Date requiredDistributionDateTo;
    /** 分批订单状态 */
    private String[] buyerBatchOrderStu;

    /** 分批订单明细Id */
    private Long[] buyerBatchOrderDetailId;

    /** 买家ID */
    private String[] buyerId;
    /** 买家编码 */
    private String buyerCode;
    /** 买家名称 */
    private String buyerName;
    /** 买家类型编码 */
    private String buyerType;
    /** 是否是账期买家 */
    private Boolean netBuyerFlg;
    /** 买手类型 */
    private String[] bsType;
    /** 买手ID */
    private String[] bsId;
    /** 买手名称 */
    private String bsName;
    /** 管家ID */
    private String[] saId;
    /** 管家名称 */
    private String saName;
    /** 管家编码 */
    private String saCode;
    /** 预配送类型 */
    private String forcastType;
    /** 供货主体（当操作人角色是买手时必输） */
    private String[] sellSideType;
    /** 销售方ID */
    private String[] sellSideId;
    /** 销售方编码 */
    private String sellSideCode;
    /** 销售方名称 */
    private String sellSideName;
    /** 商品ID */
    private String[] goodsId;
    /** 商品编码 */
    private String goodsCode;
    /** 商品名称 */
    private String goodsName;
    /** 销售标签ID */
    private Long[] saleLabelId;
    /** 销售标签编码 */
    private String saleLabelCode;
    /** 销售标签名称 */
    private String saleLabelName;

    /** 生产商Id */
    private Long[] manufacturerId;
    /** 生产商编码 */
    private String manufacturerCode;
    /** 生产商名称 */
    private String manufacturerName;
    /** 卖家Id */
    private String[] sellerId;
    /** 卖家编码 */
    private String sellerCode;
    /** 卖家名称 */
    private String sellerName;
    /** 区域配送站ID */
    private Long[] regionalDistributionStation;
    /** 区域配送站编码 */
    private String regionalDistributionStationCode;
    /** 区域配送站名称 */
    private String regionalDistributionStationName;

    public Long[] getBuyerOrderId() {
        return buyerOrderId;
    }

    public void setBuyerOrderId(Long[] buyerOrderId) {
        this.buyerOrderId = buyerOrderId;
    }

    public String getBuyerOrderCode() {
        return buyerOrderCode;
    }

    public void setBuyerOrderCode(String buyerOrderCode) {
        this.buyerOrderCode = buyerOrderCode;
    }

    public String[] getOrderType() {
        return orderType;
    }

    public void setOrderType(String[] orderType) {
        this.orderType = orderType;
    }

    public Boolean getBatchFlg() {
        return batchFlg;
    }

    public void setBatchFlg(Boolean batchFlg) {
        this.batchFlg = batchFlg;
    }

    public String[] getOrderSourceType() {
        return orderSourceType;
    }

    public void setOrderSourceType(String[] orderSourceType) {
        this.orderSourceType = orderSourceType;
    }

    public String[] getSalePlatformType() {
        return salePlatformType;
    }

    public void setSalePlatformType(String[] salePlatformType) {
        this.salePlatformType = salePlatformType;
    }

    public String[] getBuyerOrderStu() {
        return buyerOrderStu;
    }

    public void setBuyerOrderStu(String[] buyerOrderStu) {
        this.buyerOrderStu = buyerOrderStu;
    }

    public String[] getOrderPlaceType() {
        return orderPlaceType;
    }

    public void setOrderPlaceType(String[] orderPlaceType) {
        this.orderPlaceType = orderPlaceType;
    }

    public String[] getOrderPlacerType() {
        return orderPlacerType;
    }

    public void setOrderPlacerType(String[] orderPlacerType) {
        this.orderPlacerType = orderPlacerType;
    }

    public String[] getOrderPlacerId() {
        return orderPlacerId;
    }

    public void setOrderPlacerId(String[] orderPlacerId) {
        this.orderPlacerId = orderPlacerId;
    }

    public String getOrderPlacerCode() {
        return orderPlacerCode;
    }

    public void setOrderPlacerCode(String orderPlacerCode) {
        this.orderPlacerCode = orderPlacerCode;
    }

    public String getOrderPlacerName() {
        return orderPlacerName;
    }

    public void setOrderPlacerName(String orderPlacerName) {
        this.orderPlacerName = orderPlacerName;
    }

    public Date getOrderPlaceDateTimeFrom() {
        return orderPlaceDateTimeFrom;
    }

    public void setOrderPlaceDateTimeFrom(Date orderPlaceDateTimeFrom) {
        this.orderPlaceDateTimeFrom = orderPlaceDateTimeFrom;
    }

    public Date getOrderPlaceDateTimeTo() {
        return orderPlaceDateTimeTo;
    }

    public void setOrderPlaceDateTimeTo(Date orderPlaceDateTimeTo) {
        this.orderPlaceDateTimeTo = orderPlaceDateTimeTo;
    }

    public String[] getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String[] paymentType) {
        this.paymentType = paymentType;
    }

    public Boolean getInvoiceFlg() {
        return invoiceFlg;
    }

    public void setInvoiceFlg(Boolean invoiceFlg) {
        this.invoiceFlg = invoiceFlg;
    }

    public Boolean getUseNetFlg() {
        return useNetFlg;
    }

    public void setUseNetFlg(Boolean useNetFlg) {
        this.useNetFlg = useNetFlg;
    }

    public Long[] getLogisticsZoneId() {
        return logisticsZoneId;
    }

    public void setLogisticsZoneId(Long[] logisticsZoneId) {
        this.logisticsZoneId = logisticsZoneId;
    }

    public String getLogisticsZoneCode() {
        return logisticsZoneCode;
    }

    public void setLogisticsZoneCode(String logisticsZoneCode) {
        this.logisticsZoneCode = logisticsZoneCode;
    }

    public String getLogisticsZoneName() {
        return logisticsZoneName;
    }

    public void setLogisticsZoneName(String logisticsZoneName) {
        this.logisticsZoneName = logisticsZoneName;
    }

    public Long[] getBatchOrderId() {
        return batchOrderId;
    }

    public void setBatchOrderId(Long[] batchOrderId) {
        this.batchOrderId = batchOrderId;
    }

    public String getBatchOrderCode() {
        return batchOrderCode;
    }

    public void setBatchOrderCode(String batchOrderCode) {
        this.batchOrderCode = batchOrderCode;
    }

    public Date getRequiredDistributionDateFrom() {
        return requiredDistributionDateFrom;
    }

    public void setRequiredDistributionDateFrom(Date requiredDistributionDateFrom) {
        this.requiredDistributionDateFrom = requiredDistributionDateFrom;
    }

    public Date getRequiredDistributionDateTo() {
        return requiredDistributionDateTo;
    }

    public void setRequiredDistributionDateTo(Date requiredDistributionDateTo) {
        this.requiredDistributionDateTo = requiredDistributionDateTo;
    }

    public String[] getBuyerBatchOrderStu() {
        return buyerBatchOrderStu;
    }

    public void setBuyerBatchOrderStu(String[] buyerBatchOrderStu) {
        this.buyerBatchOrderStu = buyerBatchOrderStu;
    }

    public Long[] getBuyerBatchOrderDetailId() {
        return buyerBatchOrderDetailId;
    }

    public void setBuyerBatchOrderDetailId(Long[] buyerBatchOrderDetailId) {
        this.buyerBatchOrderDetailId = buyerBatchOrderDetailId;
    }

    public String[] getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String[] buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerCode() {
        return buyerCode;
    }

    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerType() {
        return buyerType;
    }

    public void setBuyerType(String buyerType) {
        this.buyerType = buyerType;
    }

    public Boolean getNetBuyerFlg() {
        return netBuyerFlg;
    }

    public void setNetBuyerFlg(Boolean netBuyerFlg) {
        this.netBuyerFlg = netBuyerFlg;
    }

    public String[] getBsType() {
        return bsType;
    }

    public void setBsType(String[] bsType) {
        this.bsType = bsType;
    }

    public String[] getBsId() {
        return bsId;
    }

    public void setBsId(String[] bsId) {
        this.bsId = bsId;
    }

    public String getBsName() {
        return bsName;
    }

    public void setBsName(String bsName) {
        this.bsName = bsName;
    }

    public String[] getSaId() {
        return saId;
    }

    public void setSaId(String[] saId) {
        this.saId = saId;
    }

    public String getSaName() {
        return saName;
    }

    public void setSaName(String saName) {
        this.saName = saName;
    }

    public String getSaCode() {
        return saCode;
    }

    public void setSaCode(String saCode) {
        this.saCode = saCode;
    }

    public String getForcastType() {
        return forcastType;
    }

    public void setForcastType(String forcastType) {
        this.forcastType = forcastType;
    }

    public String[] getSellSideType() {
        return sellSideType;
    }

    public void setSellSideType(String[] sellSideType) {
        this.sellSideType = sellSideType;
    }

    public String[] getSellSideId() {
        return sellSideId;
    }

    public void setSellSideId(String[] sellSideId) {
        this.sellSideId = sellSideId;
    }

    public String getSellSideCode() {
        return sellSideCode;
    }

    public void setSellSideCode(String sellSideCode) {
        this.sellSideCode = sellSideCode;
    }

    public String getSellSideName() {
        return sellSideName;
    }

    public void setSellSideName(String sellSideName) {
        this.sellSideName = sellSideName;
    }

    public String[] getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String[] goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long[] getSaleLabelId() {
        return saleLabelId;
    }

    public void setSaleLabelId(Long[] saleLabelId) {
        this.saleLabelId = saleLabelId;
    }

    public String getSaleLabelCode() {
        return saleLabelCode;
    }

    public void setSaleLabelCode(String saleLabelCode) {
        this.saleLabelCode = saleLabelCode;
    }

    public String getSaleLabelName() {
        return saleLabelName;
    }

    public void setSaleLabelName(String saleLabelName) {
        this.saleLabelName = saleLabelName;
    }

    public Long[] getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long[] manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerCode() {
        return manufacturerCode;
    }

    public void setManufacturerCode(String manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String[] getSellerId() {
        return sellerId;
    }

    public void setSellerId(String[] sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Long[] getRegionalDistributionStation() {
        return regionalDistributionStation;
    }

    public void setRegionalDistributionStation(Long[] regionalDistributionStation) {
        this.regionalDistributionStation = regionalDistributionStation;
    }

    public String getRegionalDistributionStationCode() {
        return regionalDistributionStationCode;
    }

    public void setRegionalDistributionStationCode(String regionalDistributionStationCode) {
        this.regionalDistributionStationCode = regionalDistributionStationCode;
    }

    public String getRegionalDistributionStationName() {
        return regionalDistributionStationName;
    }

    public void setRegionalDistributionStationName(String regionalDistributionStationName) {
        this.regionalDistributionStationName = regionalDistributionStationName;
    }

}
