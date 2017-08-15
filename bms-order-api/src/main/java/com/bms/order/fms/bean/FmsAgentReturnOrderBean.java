package com.bms.order.fms.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by yuan_chen on 2017/4/27 0012.
 * <p>
 * Fms买手合伙人囤货退货订单Bean
 */
public class FmsAgentReturnOrderBean implements Serializable {
    private static final long serialVersionUID = 7007743856911871689L;
    //原始平台系统订单唯一标识
    private String orgSystemId;
    //OMS系统订单编号
    private String omsOrderNumber;
    //OMS系统订单ID
    private Long omsOrderId;
    //退货订单对应原订单编号
    private String orgOrderNumber;
    //退货订单对应原订单ID
    private Long orgOrderId;
    //订单类型
    private String orderType;
    //下单日期
    private String orderedDateMir;
    private Date orderPlaceDate;
    //状态
    private String status;
    //币种
    private String transactionalCurrCode;
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
    private List<FmsAgentReturnOrderDetail> line;

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

    public String getOrgOrderNumber() {
        return orgOrderNumber;
    }

    public void setOrgOrderNumber(String orgOrderNumber) {
        this.orgOrderNumber = orgOrderNumber;
    }

    public Long getOrgOrderId() {
        return orgOrderId;
    }

    public void setOrgOrderId(Long orgOrderId) {
        this.orgOrderId = orgOrderId;
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

    public List<FmsAgentReturnOrderDetail> getLine() {
        return line;
    }

    public void setLine(List<FmsAgentReturnOrderDetail> line) {
        this.line = line;
    }
}

