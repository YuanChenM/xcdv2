package com.bms.order.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * Created by wang_haichun on 2017/4/26.
 */
public class ORDR1102IRestParam extends BaseRestPaginationParam {

    @ApiModelProperty(value = "1:查询订单信息 2:查询订单明细")
    private String pagingLevel;
    @ApiModelProperty(value = "沽货订单ID")
    private List<Long> orderId;
    @ApiModelProperty(value = "沽货订单单号，模糊查询")
    private String orderCode;
    @ApiModelProperty(value = "参考单号")
    private String backNo;
    @ApiModelProperty(value = "订单类型")
    private String orderType;
    @ApiModelProperty(value = "订单来源")
    private String orderSourceType;
    @ApiModelProperty(value = "物流区ID")
    private String logisticsId;
    @ApiModelProperty(value = "物流区编码")
    private String logisticsCode;
    @ApiModelProperty(value = "卖方ID")
    private String sellerId;
    @ApiModelProperty(value = "卖方编码")
    private String sellerCode;
    @ApiModelProperty(value = "卖方名称")
    private String sellerName;
    @ApiModelProperty(value = "卖方类型")
    private String sellerType;
    @ApiModelProperty(value = "买方ID")
    private String buyerId;
    @ApiModelProperty(value = "买方编码")
    private String buyerCode;
    @ApiModelProperty(value = "买方名称")
    private String buyerName;
    @ApiModelProperty(value = "买方类型")
    private String buyerType;
    @ApiModelProperty(value = "支付状态")
    private String paymentStu;
    @ApiModelProperty(value = "订单状态")
    private String orderStu;
    @ApiModelProperty(value = "下单开始时间（yyyy-MM-dd）")
    private Date placeTimeFrom;
    @ApiModelProperty(value = "下单截止时间（yyyy-MM-dd）")
    private Date placeTimeTo;
    @ApiModelProperty(value = "交易开始时间（yyyy-MM-dd）")
    private Date tradeTimeFrom;
    @ApiModelProperty(value = "交易截止时间（yyyy-MM-dd）")
    private Date tradeTimeTo;


    public String getPagingLevel() {
        return pagingLevel;
    }

    public void setPagingLevel(String pagingLevel) {
        this.pagingLevel = pagingLevel;
    }

    public List<Long> getOrderId() {
        return orderId;
    }

    public void setOrderId(List<Long> orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getBackNo() {
        return backNo;
    }

    public void setBackNo(String backNo) {
        this.backNo = backNo;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderSourceType() {
        return orderSourceType;
    }

    public void setOrderSourceType(String orderSourceType) {
        this.orderSourceType = orderSourceType;
    }

    public String getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
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

    public String getSellerType() {
        return sellerType;
    }

    public void setSellerType(String sellerType) {
        this.sellerType = sellerType;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
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

    public String getPaymentStu() {
        return paymentStu;
    }

    public void setPaymentStu(String paymentStu) {
        this.paymentStu = paymentStu;
    }

    public String getOrderStu() {
        return orderStu;
    }

    public void setOrderStu(String orderStu) {
        this.orderStu = orderStu;
    }

    public Date getPlaceTimeFrom() {
        return placeTimeFrom;
    }

    public void setPlaceTimeFrom(Date placeTimeFrom) {
        this.placeTimeFrom = placeTimeFrom;
    }

    public Date getPlaceTimeTo() {
        return placeTimeTo;
    }

    public void setPlaceTimeTo(Date placeTimeTo) {
        this.placeTimeTo = placeTimeTo;
    }

    public Date getTradeTimeFrom() {
        return tradeTimeFrom;
    }

    public void setTradeTimeFrom(Date tradeTimeFrom) {
        this.tradeTimeFrom = tradeTimeFrom;
    }

    public Date getTradeTimeTo() {
        return tradeTimeTo;
    }

    public void setTradeTimeTo(Date tradeTimeTo) {
        this.tradeTimeTo = tradeTimeTo;
    }
}
