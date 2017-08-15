package com.bms.order.fms.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by yuan_chen on 2017/4/12 0012.
 * <p>
 * Fms买家订单Bean
 */
public class FmsBuyerOrderBean implements Serializable {
    private static final long serialVersionUID = 6692396309843774135L;

    //云冻品前台订单号
    private String orgsystemId;
    //OMS订单编码
    private String omsOrderNumber;
    //OMS订单ID
    private Long omsOrderId;
    //订单类型（买家销售）
    private String orderType;
    //订单日期
    private String orderedDateMir;
    private Date orderPlaceDate;
    //默认人民币
    private String transactionalCurrCode;
    //买家付款金额
    private BigDecimal buyAmount;
    //买家名称
    private String soldTo;
    //状态
    private String omsStatus;
    //买家ID
    private String customerOrgNumber;
    //买家账号
    private String customerNumber;
    //买手ID
    private String agentId;
    private String salesNumber;
    //买手配送站编号
    private String stationNumber;
    //买手垫付占用会员金额
    private BigDecimal memberPerPayfor;
    //下单类型(001;A类,002:B类)
    private String orderPlaceType;
    //支付状态
    private String orderPaymentStu;
    //云冻品/买家APP/微商城等 OMS Master数据
    private String orderOrgsource;
    //OMS固定 固定值-OMS
    private String orderSource;
    //买家订单明细（产品信息）
    private List<FmsBuyerOrderDetail> line;

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

    public String getOrderedDateMir() {
        return orderedDateMir;
    }

    public void setOrderedDateMir(String orderedDateMir) {
        this.orderedDateMir = orderedDateMir;
    }

    public Date getOrderPlaceDate() {
        return orderPlaceDate;
    }

    public void setOrderPlaceDate(Date orderPlaceDate) {
        this.orderPlaceDate = orderPlaceDate;
    }

    public String getTransactionalCurrCode() {
        return transactionalCurrCode;
    }

    public void setTransactionalCurrCode(String transactionalCurrCode) {
        this.transactionalCurrCode = transactionalCurrCode;
    }

    public BigDecimal getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(BigDecimal buyAmount) {
        this.buyAmount = buyAmount;
    }

    public String getSoldTo() {
        return soldTo;
    }

    public void setSoldTo(String soldTo) {
        this.soldTo = soldTo;
    }

    public String getOmsStatus() {
        return omsStatus;
    }

    public void setOmsStatus(String omsStatus) {
        this.omsStatus = omsStatus;
    }

    public String getCustomerOrgNumber() {
        return customerOrgNumber;
    }

    public void setCustomerOrgNumber(String customerOrgNumber) {
        this.customerOrgNumber = customerOrgNumber;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getSalesNumber() {
        return salesNumber;
    }

    public void setSalesNumber(String salesNumber) {
        this.salesNumber = salesNumber;
    }

    public String getStationNumber() {
        return stationNumber;
    }

    public void setStationNumber(String stationNumber) {
        this.stationNumber = stationNumber;
    }

    public BigDecimal getMemberPerPayfor() {
        return memberPerPayfor;
    }

    public void setMemberPerPayfor(BigDecimal memberPerPayfor) {
        this.memberPerPayfor = memberPerPayfor;
    }

    public String getOrderPlaceType() {
        return orderPlaceType;
    }

    public void setOrderPlaceType(String orderPlaceType) {
        this.orderPlaceType = orderPlaceType;
    }

    public String getOrderPaymentStu() {
        return orderPaymentStu;
    }

    public void setOrderPaymentStu(String orderPaymentStu) {
        this.orderPaymentStu = orderPaymentStu;
    }

    public String getOrderOrgsource() {
        return orderOrgsource;
    }

    public void setOrderOrgsource(String orderOrgsource) {
        this.orderOrgsource = orderOrgsource;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public List<FmsBuyerOrderDetail> getLine() {
        return line;
    }

    public void setLine(List<FmsBuyerOrderDetail> line) {
        this.line = line;
    }
}

