package com.bms.order.fms.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by yuan_chen on 2017/4/19 0019.
 * <p>
 * Fms买家退货订单Bean
 */
public class FmsBuyerReturnOrderBean implements Serializable {
    private static final long serialVersionUID = -3454627595412290119L;
    //云冻品前台订单号
    private String orgsystemId;
    //OMS退货订单编号
    private String omsOrderNumber;
    //OMS退货订单ID
    private Long omsOrderId;
    //订单类型
    private String orderType;
    //OMS订单编码
    private String buyerOrderNumber;
    //OMS订单ID
    private Long buyerOrderId;
    //订单日期
    private String orderPlaceDatetime;
    private Date orderPlaceDate;

    //买家首次付款金额
    private BigDecimal paymentAmount;
    //买家名称
    private String buyerName;
    //买家ID
    private String buyerId;
    //买家账号
    private String accountNo;
    //买手ID
    private String agentId;
    private String bsId;
    //买手配送站编码
    private String whCode;
    //云冻品/买家APP/微商城等
    private String orderSourceType;
    //OMS 固定值-OMS
    private String orderSource;
    //支付类型
    private String paymentType;
    //币种
    private String transactionalCurrCode;
    //line
    private List<FmsBuyerReturnOrderDetail> line;

    public String getOrgsystemId() {
        return orgsystemId;
    }

    public void setOrgsystemId(String orgsystemId) {
        this.orgsystemId = orgsystemId;
    }

    public String getOmsOrderNumber() {
        return omsOrderNumber;
    }

    public void setOmsOrderNumber(String omsOrderNumber) {
        this.omsOrderNumber = omsOrderNumber;
    }

    public Long getOmsOrderId() {
        return omsOrderId;
    }

    public void setOmsOrderId(Long omsOrderId) {
        this.omsOrderId = omsOrderId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getBuyerOrderNumber() {
        return buyerOrderNumber;
    }

    public void setBuyerOrderNumber(String buyerOrderNumber) {
        this.buyerOrderNumber = buyerOrderNumber;
    }

    public Long getBuyerOrderId() {
        return buyerOrderId;
    }

    public void setBuyerOrderId(Long buyerOrderId) {
        this.buyerOrderId = buyerOrderId;
    }

    public String getOrderPlaceDatetime() {
        return orderPlaceDatetime;
    }

    public void setOrderPlaceDatetime(String orderPlaceDatetime) {
        this.orderPlaceDatetime = orderPlaceDatetime;
    }

    public Date getOrderPlaceDate() {
        return orderPlaceDate;
    }

    public void setOrderPlaceDate(Date orderPlaceDate) {
        this.orderPlaceDate = orderPlaceDate;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getBsId() {
        return bsId;
    }

    public void setBsId(String bsId) {
        this.bsId = bsId;
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getOrderSourceType() {
        return orderSourceType;
    }

    public void setOrderSourceType(String orderSourceType) {
        this.orderSourceType = orderSourceType;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getTransactionalCurrCode() {
        return transactionalCurrCode;
    }

    public void setTransactionalCurrCode(String transactionalCurrCode) {
        this.transactionalCurrCode = transactionalCurrCode;
    }

    public List<FmsBuyerReturnOrderDetail> getLine() {
        return line;
    }

    public void setLine(List<FmsBuyerReturnOrderDetail> line) {
        this.line = line;
    }
}
