package com.bms.order.fms.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by yuan_chen on 2017/4/28
 * <p>
 * Fms估货订单Bean
 */
public class FmsShortSellOrderBean implements Serializable {
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
    private String orderedDate;
    private Date orderPlaceDate;
    //买方名称
    private String soldTo;
    //买方ID
    private String customerOrgNumber;
    //买方编码
    private String customerNumber;
    //卖方名称
    private String sourceName;
    //卖方编码
    private String sourceAccount;
    //卖方ID
    private String sourceId;
    //币种
    private String transactionalCurrCode;
    //订单原始来源
    private String orderOrgSource;
    //订单传输来源
    private String orderSource;
    //竞价占用贷款金额
    private BigDecimal loanAmount;
    //竞价占用资金账户金额
    private BigDecimal capitalAmount;
    //Fms估货订单明细（产品信息）
    private List<FmsShortSellOrderDetail> line;

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

    public String getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(String orderedDate) {
        this.orderedDate = orderedDate;
    }

    public Date getOrderPlaceDate() {
        return orderPlaceDate;
    }

    public void setOrderPlaceDate(Date orderPlaceDate) {
        this.orderPlaceDate = orderPlaceDate;
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

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getTransactionalCurrCode() {
        return transactionalCurrCode;
    }

    public void setTransactionalCurrCode(String transactionalCurrCode) {
        this.transactionalCurrCode = transactionalCurrCode;
    }

    public String getOrderOrgSource() {
        return orderOrgSource;
    }

    public void setOrderOrgSource(String orderOrgSource) {
        this.orderOrgSource = orderOrgSource;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getCapitalAmount() {
        return capitalAmount;
    }

    public void setCapitalAmount(BigDecimal capitalAmount) {
        this.capitalAmount = capitalAmount;
    }

    public List<FmsShortSellOrderDetail> getLine() {
        return line;
    }

    public void setLine(List<FmsShortSellOrderDetail> line) {
        this.line = line;
    }
}

