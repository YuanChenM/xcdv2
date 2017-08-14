package com.bms.puch.fms.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by yuan_chen on 2017/4/27 0012.
 * <p>
 * Fms买手合伙人竞价订单Bean
 */
public class FmsAgentBidOrderBean implements Serializable {
    private static final long serialVersionUID = -7608697159086399701L;
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
    //状态
    private String status;
    //币种
    private String transactionalCurrCode;
    //客户名称
    private String soldTo;
    //买手/合伙人ID
    private String customerOrgNumber;
    //买手合伙人编码
    private String customerNumber;
    //付款类型
    private String paymentType;
    //付款条件
    private String terms;
    //订单原始来源
    private String orderOrgsource;
    //订单传输来源
    private String orderSource;
    //买手合伙人囤货订单明细
    private List<FmsAgentBidOrderDetail> line;

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

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
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

    public List<FmsAgentBidOrderDetail> getLine() {
        return line;
    }

    public void setLine(List<FmsAgentBidOrderDetail> line) {
        this.line = line;
    }
}

