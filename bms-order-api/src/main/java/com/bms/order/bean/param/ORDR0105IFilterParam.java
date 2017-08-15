package com.bms.order.bean.param;

import java.util.Date;

import com.bms.order.common.rest.param.RestFilter;
import com.framework.core.utils.DateUtils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 买家订单查询接口Param
 *
 * @author li_huiqian
 */
@ApiModel(value = "ORDR0105IRestParam", description = "买家订单查询接口条件")
public class ORDR0105IFilterParam extends RestFilter {
    private static final long serialVersionUID = -2546879931082733317L;
    @ApiModelProperty(value = "订单ID")
    private Long[] buyerOrderId;
    @ApiModelProperty(value = "订单编码")
    private String buyerOrderCode;
    @ApiModelProperty(value = "参考号")
    private String backNo;
    @ApiModelProperty(value = "订单类型")
    private String[] orderType;
    @ApiModelProperty(value = "是否分批")
    private Boolean batchFlg;
    @ApiModelProperty(value = "订单来源")
    private String[] orderSourceType;
    @ApiModelProperty(value = "销售平台")
    private String[] salePlatformType;
    @ApiModelProperty(value = "订单状态")
    private String[] buyerOrderStu;
    @ApiModelProperty(value = "下单类型")
    private String[] orderPlaceType;
    @ApiModelProperty(value = "下单员类型")
    private String[] orderPlacerType;
    @ApiModelProperty(value = "下单员ID")
    private String[] orderPlacerId;
    @ApiModelProperty(value = "下单员编码")
    private String orderPlacerCode;
    @ApiModelProperty(value = "下单员名称")
    private String orderPlacerName;
    @ApiModelProperty(value = "下单时间开始")
    private Date orderPlaceDateTimeFrom;
    @ApiModelProperty(value = "下单时间结束")
    private Date orderPlaceDateTimeTo;
    @ApiModelProperty(value = "付款类型")
    private String[] paymentType;
    @ApiModelProperty(value = "是否开发票")
    private Boolean invoiceFlg;
    @ApiModelProperty(value = "是否使用账期")
    private Boolean useNetFlg;
    @ApiModelProperty(value = "物流区ID")
    private Long[] logisticsZoneId;
    @ApiModelProperty(value = "物流区编码")
    private String logisticsZoneCode;
    @ApiModelProperty(value = "物流区名称")
    private String logisticsZoneName;
    @ApiModelProperty(value = "分批订单ID")
    private Long[] batchOrderId;
    @ApiModelProperty(value = "分批订单编码")
    private String batchOrderCode;
    @ApiModelProperty(value = "期望配送日开始")
    private Date requiredDistributionDateFrom;
    @ApiModelProperty(value = "期望配送日结束")
    private Date requiredDistributionDateTo;
    @ApiModelProperty(value = "分批订单状态")
    private String[] buyerBatchOrderStu;

    @ApiModelProperty(value = "分批订单明细Id")
    private Long[] buyerBatchOrderDetailId;

    @ApiModelProperty(value = "买家ID")
    private String[] buyerId;
    @ApiModelProperty(value = "买家编码")
    private String buyerCode;
    @ApiModelProperty(value = "买家名称")
    private String buyerName;
    @ApiModelProperty(value = "买家类型编码")
    private String [] buyerType;
    @ApiModelProperty(value = "买家类型名称")
    private String buyerTypeName;
    @ApiModelProperty(value = "是否是账期买家")
    private Boolean netBuyerFlg;
    @ApiModelProperty(value = "买手类型")
    private String[] bsType;
    @ApiModelProperty(value = "买手名称")
    private String bsName;
    @ApiModelProperty(value = "买手ID")
    private String[] bsId;
    @ApiModelProperty(value = "管家ID")
    private String[] saId;
    @ApiModelProperty(value = "管家名称")
    private String saName;
    @ApiModelProperty(value = "管家编码")
    private String saCode;
    @ApiModelProperty(value = "预配送类型")
    private String forcastType;
    @ApiModelProperty(value = "供货主体（当操作人角色是买手时必输）")
    private String[] sellSideType;
    @ApiModelProperty(value = "销售方ID")
    private String[] sellSideId;
    @ApiModelProperty(value = "销售方编码")
    private String sellSideCode;
    @ApiModelProperty(value = "销售方名称")
    private String sellSideName;
    @ApiModelProperty(value = "商品ID")
    private Long[] goodsId;
    @ApiModelProperty(value = "商品编码")
    private String goodsCode;
    @ApiModelProperty(value = "商品名称")
    private String goodsName;
    @ApiModelProperty(value = "销售标签ID")
    private Long[] saleLabelId;
    @ApiModelProperty(value = "销售标签编码")
    private String saleLabelCode;
    @ApiModelProperty(value = "销售标签名称")
    private String saleLabelName;

    @ApiModelProperty(value = "生产商Id")
    private Long[] manufacturerId;
    @ApiModelProperty(value = "生产商编码")
    private String manufacturerCode;
    @ApiModelProperty(value = "生产商名称")
    private String manufacturerName;
    @ApiModelProperty(value = "卖家Id")
    private Long[] sellerId;
    @ApiModelProperty(value = "卖家编码")
    private String sellerCode;
    @ApiModelProperty(value = "卖家名称")
    private String sellerName;
    @ApiModelProperty(value = "区域配送站ID")
    private Long[] regionalDistributionStation;
    @ApiModelProperty(value = "区域配送站编码")
    private String regionalDistributionStationCode;
    @ApiModelProperty(value = "区域配送站名称")
    private String regionalDistributionStationName;
    @ApiModelProperty(value = "更新时间开始")
    private Date updTimeFrom;
    @ApiModelProperty(value = "更新时间结束")
    private Date updTimeTo;

    public Date getOrderPlaceDateTimeFrom() {
        if (null != orderPlaceDateTimeFrom) {
            String endTime = DateUtils.format(DateUtils.FORMAT_YYYY_MM_DD, orderPlaceDateTimeFrom);
            return DateUtils.parse(DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS, endTime + " 00:00:00");
        } else {
            return orderPlaceDateTimeFrom;
        }
    }

    public void setOrderPlaceDateTimeFrom(Date orderPlaceDateTimeFrom) {
        this.orderPlaceDateTimeFrom = orderPlaceDateTimeFrom;
    }

    public Date getOrderPlaceDateTimeTo() {
        if (null != orderPlaceDateTimeTo) {
            String endTime = DateUtils.format(DateUtils.FORMAT_YYYY_MM_DD, orderPlaceDateTimeTo);
            return DateUtils.parse(DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS, endTime + " 23:59:59");
        } else {
            return orderPlaceDateTimeTo;
        }
    }

    public void setOrderPlaceDateTimeTo(Date orderPlaceDateTimeTo) {
        this.orderPlaceDateTimeTo = orderPlaceDateTimeTo;
    }

    public Date getRequiredDistributionDateFrom() {
        if (null != requiredDistributionDateFrom) {
            String endTime = DateUtils.format(DateUtils.FORMAT_YYYY_MM_DD, requiredDistributionDateFrom);
            return DateUtils.parse(DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS, endTime + " 00:00:00");
        } else {
            return requiredDistributionDateFrom;
        }
    }

    public void setRequiredDistributionDateFrom(Date requiredDistributionDateFrom) {
        this.requiredDistributionDateFrom = requiredDistributionDateFrom;
    }

    public Date getRequiredDistributionDateTo() {
        if (null != requiredDistributionDateTo) {
            String endTime = DateUtils.format(DateUtils.FORMAT_YYYY_MM_DD, requiredDistributionDateTo);
            return DateUtils.parse(DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS, endTime + " 23:59:59");
        } else {
            return requiredDistributionDateTo;
        }
    }

    public void setRequiredDistributionDateTo(Date requiredDistributionDateTo) {
        this.requiredDistributionDateTo = requiredDistributionDateTo;
    }

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

    public String getBackNo() {
        return backNo;
    }

    public void setBackNo(String backNo) {
        this.backNo = backNo;
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

    public String[] getBuyerType() {
        return buyerType;
    }

    public void setBuyerType(String[] buyerType) {
        this.buyerType = buyerType;
    }

    public String getBuyerTypeName() {
        return buyerTypeName;
    }

    public void setBuyerTypeName(String buyerTypeName) {
        this.buyerTypeName = buyerTypeName;
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

    /**
     * @return the bsName
     */
    public String getBsName() {
        return bsName;
    }

    /**
     * @param bsName
     *            the bsName to set
     */
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

    public Long[] getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long[] goodsId) {
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

    public String getForcastType() {
        return forcastType;
    }

    public void setForcastType(String forcastType) {
        this.forcastType = forcastType;
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

    public Long[] getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long[] sellerId) {
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

    public Date getUpdTimeFrom() {
        return updTimeFrom;
    }

    public void setUpdTimeFrom(Date updTimeFrom) {
        this.updTimeFrom = updTimeFrom;
    }

    public Date getUpdTimeTo() {
        return updTimeTo;
    }

    public void setUpdTimeTo(Date updTimeTo) {
        this.updTimeTo = updTimeTo;
    }
}
