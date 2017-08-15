package com.bms.order.fms.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by yuan_chen on 2017/4/27 0012.
 * <p>
 * Fms买手合伙人囤货订单Bean
 */
public class FmsAgentOrderBean implements Serializable {
    private static final long serialVersionUID = 3292011594429919779L;
    //原始平台系统订单唯一标识
    private String orgSystemId;
    //OMS系统订单编号
    private String omsOrderNumber;
    //OMS系统订单ID
    private Long omsOrderId;
    //订单类型
    private String orderType;
    //下单日期
    private String orderedDateMir;
    private Date orderPlaceDate;
    //状态
    private String status;
    //币种
    private String transactionalCurrCode;
    //付款使用会员金额
    private BigDecimal memberPer;
    //付款使用贷款金额
    private BigDecimal loanPer;
    //客户名称
    private String soldTo;
    //买手/合伙人ID
    private String customerOrgNumber;
    //客户账号
    private String customerNumber;
    //付款类型
    private String paymentType;
    //订单原始来源
    private String orderOrgsource;
    //订单传输来源
    private String orderSource;
    //买手合伙人囤货订单明细
    private List<FmsAgentOrderDetail> line;

    public String getOrgSystemId() {
        return orgSystemId;
    }

    public void setOrgSystemId(String orgSystemId) {
        this.orgSystemId = orgSystemId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransactionalCurrCode() {
        return transactionalCurrCode;
    }

    public void setTransactionalCurrCode(String transactionalCurrCode) {
        this.transactionalCurrCode = transactionalCurrCode;
    }

    public BigDecimal getMemberPer() {
        return memberPer;
    }

    public void setMemberPer(BigDecimal memberPer) {
        this.memberPer = memberPer;
    }

    public BigDecimal getLoanPer() {
        return loanPer;
    }

    public void setLoanPer(BigDecimal loanPer) {
        this.loanPer = loanPer;
    }

    public String getSoldTo() {
        return soldTo;
    }

    public void setSoldTo(String soldTo) {
        this.soldTo = soldTo;
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

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
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

    public List<FmsAgentOrderDetail> getLine() {
        return line;
    }

    public void setLine(List<FmsAgentOrderDetail> line) {
        this.line = line;
    }
}

