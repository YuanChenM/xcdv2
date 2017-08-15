package com.bms.order.external.bean.param;

import com.bms.order.common.rest.param.RestFilter;

/**
 * 问题订单查询接口Param
 * 
 * @author li_huiqian
 */
public class ISSU0105IFilter extends RestFilter {

    private static final long serialVersionUID = 1L;

    /**
     * 问题订单ID
     */
    private Long[] issueId;
    /**
     * 问题订单编码，模糊查询
     */
    private String issueCode;
    /**
     * 发起人类型
     */
    private String[] initiatorType;
    /**
     * 发起人名称，模糊查询
     */
    private String initiatorName;
    /**
     * 发起时间起始
     */
    private String initiatorTimeFrom;
    /**
     * 发起时间截止
     */
    private String initiatorTimeTo;
    /**
     * 结案时间起始
     */
    private String closeTimeFrom;
    /**
     * 结案时间截止
     */
    private String closeTimeTo;
    /**
     * 问题概述，模糊查询
     */
    private String issueDesc;
    /**
     * 问题状态
     */
    private String[] issueStatus;
    /**
     * 订单编码，模糊查询
     */
    private String orderCode;
    /**
     * 订单ID
     */
    private Long[] orderId;
    /**
     * 买家ID
     */
    private String[] buyerId;
    /**
     * 买家编码，模糊查询
     */
    private String buyerCode;

    /**
     * 买家名称，模糊查询
     */
    private String buyerName;

    /**
     * 销售区域ID
     */
    private Long[] logisticsZoneId;

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public Long[] getIssueId() {
        return issueId;
    }

    public void setIssueId(Long[] issueId) {
        this.issueId = issueId;
    }

    public String getIssueCode() {
        return issueCode;
    }

    public void setIssueCode(String issueCode) {
        this.issueCode = issueCode;
    }

    public String[] getInitiatorType() {
        return initiatorType;
    }

    public void setInitiatorType(String[] initiatorType) {
        this.initiatorType = initiatorType;
    }

    public String getInitiatorName() {
        return initiatorName;
    }

    public void setInitiatorName(String initiatorName) {
        this.initiatorName = initiatorName;
    }

    public String getInitiatorTimeFrom() {
        return initiatorTimeFrom;
    }

    public void setInitiatorTimeFrom(String initiatorTimeFrom) {
        this.initiatorTimeFrom = initiatorTimeFrom;
    }

    public String getInitiatorTimeTo() {
        return initiatorTimeTo;
    }

    public void setInitiatorTimeTo(String initiatorTimeTo) {
        this.initiatorTimeTo = initiatorTimeTo;
    }

    public String getCloseTimeFrom() {
        return closeTimeFrom;
    }

    public void setCloseTimeFrom(String closeTimeFrom) {
        this.closeTimeFrom = closeTimeFrom;
    }

    public String getCloseTimeTo() {
        return closeTimeTo;
    }

    public void setCloseTimeTo(String closeTimeTo) {
        this.closeTimeTo = closeTimeTo;
    }

    public String getIssueDesc() {
        return issueDesc;
    }

    public void setIssueDesc(String issueDesc) {
        this.issueDesc = issueDesc;
    }

    public String[] getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(String[] issueStatus) {
        this.issueStatus = issueStatus;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Long[] getOrderId() {
        return orderId;
    }

    public void setOrderId(Long[] orderId) {
        this.orderId = orderId;
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

    public Long[] getLogisticsZoneId() {
        return logisticsZoneId;
    }

    public void setLogisticsZoneId(Long[] logisticsZoneId) {
        this.logisticsZoneId = logisticsZoneId;
    }
}
