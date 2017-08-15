package com.bms.order.bean.result;

import com.bms.order.bean.entity.OrdrShortsellDetail;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by wang_haichun on 2017/4/27.
 */
public class ORDR1102IRestResult implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 沽货订单ID */
    private Long orderId;
    /** 沽货订单编号 */
    private String orderCode;
    /** 冻期所沽货订单单号 */
    private String backNo;
    /** CodeMaster,003-沽货订单 */
    private String orderType;
    /** CodeMaster,001-冻期所 */
    private String orderSourceType;
    /** 物流区ID */
    private Long logisticsId;
    /** 物流区编码 */
    private String logisticsCode;
    /** 物流区名称 */
    private String logisticsName;
    /** 卖方ID */
    private String sellerId;
    /** 卖方编码 */
    private String sellerCode;
    /** 卖方名称 */
    private String sellerName;
    /** 卖方类型 */
    private String sellerType;
    /** 买方ID */
    private String buyerId;
    /** 买方编码 */
    private String buyerCode;
    /** 买方名称 */
    private String buyerName;
    /** 买方类型 */
    private String buyerType;
    /** 订单总额 */
    private java.math.BigDecimal totalAmount;
    /** 已收金额 */
    private java.math.BigDecimal receiveAmount;
    /** codemaster */
    private String paymentStu;
    /** 税率 */
    private java.math.BigDecimal taxRate;
    /** 币种 */
    private String currency;
    /** 卖家交易手续费 */
    private java.math.BigDecimal sellerFeeMoney;
    /** 卖家交易保证金 */
    private java.math.BigDecimal sellerDepositMoney;
    /** 卖家交收手续费 */
    private java.math.BigDecimal sellerDelMoney;
    /** 买家交易手续费 */
    private java.math.BigDecimal buyerFeeMoney;
    /** 买家交易保证金 */
    private java.math.BigDecimal buyerDepositMoney;
    /** 买家交收手续费 */
    private java.math.BigDecimal buyerDelMoney;
    /** 下单员编码 */
    private String placeCode;
    /** 下单员名称 */
    private String placeName;
    /** 下单时间 */
    private java.util.Date placeTime;
    /** 交易时间，即交割完成时间 */
    private java.util.Date tradeTime;
    /** 订单状态 */
    private String orderStu;

    private String crtId;
    private Date crtTime;
    private String updId;
    private Date updTime;
    private Integer ver;

    private List<OrdrShortsellDetail> details;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
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

    public Long getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(Long logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
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

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getReceiveAmount() {
        return receiveAmount;
    }

    public void setReceiveAmount(BigDecimal receiveAmount) {
        this.receiveAmount = receiveAmount;
    }

    public String getPaymentStu() {
        return paymentStu;
    }

    public void setPaymentStu(String paymentStu) {
        this.paymentStu = paymentStu;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getSellerFeeMoney() {
        return sellerFeeMoney;
    }

    public void setSellerFeeMoney(BigDecimal sellerFeeMoney) {
        this.sellerFeeMoney = sellerFeeMoney;
    }

    public BigDecimal getSellerDepositMoney() {
        return sellerDepositMoney;
    }

    public void setSellerDepositMoney(BigDecimal sellerDepositMoney) {
        this.sellerDepositMoney = sellerDepositMoney;
    }

    public BigDecimal getSellerDelMoney() {
        return sellerDelMoney;
    }

    public void setSellerDelMoney(BigDecimal sellerDelMoney) {
        this.sellerDelMoney = sellerDelMoney;
    }

    public BigDecimal getBuyerFeeMoney() {
        return buyerFeeMoney;
    }

    public void setBuyerFeeMoney(BigDecimal buyerFeeMoney) {
        this.buyerFeeMoney = buyerFeeMoney;
    }

    public BigDecimal getBuyerDepositMoney() {
        return buyerDepositMoney;
    }

    public void setBuyerDepositMoney(BigDecimal buyerDepositMoney) {
        this.buyerDepositMoney = buyerDepositMoney;
    }

    public BigDecimal getBuyerDelMoney() {
        return buyerDelMoney;
    }

    public void setBuyerDelMoney(BigDecimal buyerDelMoney) {
        this.buyerDelMoney = buyerDelMoney;
    }

    public String getPlaceCode() {
        return placeCode;
    }

    public void setPlaceCode(String placeCode) {
        this.placeCode = placeCode;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Date getPlaceTime() {
        return placeTime;
    }

    public void setPlaceTime(Date placeTime) {
        this.placeTime = placeTime;
    }

    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getOrderStu() {
        return orderStu;
    }

    public void setOrderStu(String orderStu) {
        this.orderStu = orderStu;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    public List<OrdrShortsellDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrdrShortsellDetail> details) {
        this.details = details;
    }
}
