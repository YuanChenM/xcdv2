package com.bms.order.bean.param;

import java.util.Date;

import com.bms.order.common.rest.param.RestFilter;

import io.swagger.annotations.ApiModelProperty;

/**
 * 买手订单查询接口Param
 * 
 * @author li_huiqian
 */
public class ORDR0605IFilterParam extends RestFilter {

    private static final long serialVersionUID = 1L;
    private Long[] bsOrderId;// 买手订单ID
    private String bsOrderCode; // 买手订单编码
    private String backNo;// 订单：参考号
    private String[] orderType; // 买手订单类型
    private String[] salePlatformType; // 销售平台
    private String[] orderSourceType; // 订单来源
    private Long[] logisticsZoneId; // 物流区ID
    private String logisticsZoneCode; // 物流区编码
    private String logisticsZoneName; // 物流区名称
    private String[] bsId; // 买手ID
    private String bsCode; // 买手编码
    private String bsName; // 买手名称
    private String[] bsType; // 买手类型
    private Long[] orderPlacerId; // 下单员ID
    private String orderPlacerCode; // 下单员编码
    private String orderPlacerName; // 下单员名称
    private String[] orderPlacerType; // 下单员类型
    private Boolean invoiceFlg; // 是否开发票
    private String[] bsOrderStatus; // 买手订单状态
    private String[] paymentStatus; // 支付状态
    private Date orderPlaceDateTimeFrom; // 下单时间开始
    private Date orderPlaceDateTimeTo; // 下单时间结束
    private Long[] goodsId; // 商品ID
    private String goodsCode; // 商品编码
    private String goodsName; // 商品名称
    private Long[] saleLabelId; // 销售标签ID
    private String saleLabelCode; // 销售标签编码
    private String saleLabelName; // 销售标签名称
    private String sku; // 商品SKU
    private Long[] manufacturerId; // 生产商Id
    private String manufacturerCode; // 生产商编码
    private String manufacturerName; // 生产商名称
    private Long[] sellerId; // 卖家Id
    private String sellerCode; // 卖家编码
    private String sellerName; // 卖家名称
    private String[] sellSideId; // 销售方ID
    private String sellSideCode; // 销售方编码
    private String sellSideName; // 销售方名称
    // 管家ID
    @ApiModelProperty(hidden = true)
    private String[] saId;

    /**
     * @return the saId
     */
    public String[] getSaId() {
        return saId;
    }

    /**
     * @param saId
     *            the saId to set
     */
    public void setSaId(String[] saId) {
        this.saId = saId;
    }

    public Long[] getBsOrderId() {
        return bsOrderId;
    }

    public void setBsOrderId(Long[] bsOrderId) {
        this.bsOrderId = bsOrderId;
    }

    public String getBsOrderCode() {
        return bsOrderCode;
    }

    public void setBsOrderCode(String bsOrderCode) {
        this.bsOrderCode = bsOrderCode;
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

    public String[] getSalePlatformType() {
        return salePlatformType;
    }

    public void setSalePlatformType(String[] salePlatformType) {
        this.salePlatformType = salePlatformType;
    }

    public String[] getOrderSourceType() {
        return orderSourceType;
    }

    public void setOrderSourceType(String[] orderSourceType) {
        this.orderSourceType = orderSourceType;
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

    public String[] getBsId() {
        return bsId;
    }

    public void setBsId(String[] bsId) {
        this.bsId = bsId;
    }

    public String getBsCode() {
        return bsCode;
    }

    public void setBsCode(String bsCode) {
        this.bsCode = bsCode;
    }

    public String getBsName() {
        return bsName;
    }

    public void setBsName(String bsName) {
        this.bsName = bsName;
    }

    public String[] getBsType() {
        return bsType;
    }

    public void setBsType(String[] bsType) {
        this.bsType = bsType;
    }

    public Long[] getOrderPlacerId() {
        return orderPlacerId;
    }

    public void setOrderPlacerId(Long[] orderPlacerId) {
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

    public String[] getOrderPlacerType() {
        return orderPlacerType;
    }

    public void setOrderPlacerType(String[] orderPlacerType) {
        this.orderPlacerType = orderPlacerType;
    }

    public Boolean getInvoiceFlg() {
        return invoiceFlg;
    }

    public void setInvoiceFlg(Boolean invoiceFlg) {
        this.invoiceFlg = invoiceFlg;
    }

    public String[] getBsOrderStatus() {
        return bsOrderStatus;
    }

    public void setBsOrderStatus(String[] bsOrderStatus) {
        this.bsOrderStatus = bsOrderStatus;
    }

    public String[] getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String[] paymentStatus) {
        this.paymentStatus = paymentStatus;
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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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

}
