package com.bms.order.external.bean.result;

import java.io.Serializable;

/**
 * 问题订单查询接口Result
 *
 * @author li_huiqian
 */
public class ISSU0105IRestResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 问题订单ID
     */
    private Long issueId;
    /**
     * 问题订单编码
     */
    private String issueCode;
    /**
     * 原订单ID
     */
    private Long orderId;
    /**
     * 原订单编码
     */
    private String orderCode;
    /**
     * 原订单类型
     */
    private String orderType;
    /**
     * 物流区编码
     */
    private String logisticsZoneCode;
    /**
     * 物流区名称
     */
    private String logisticsZoneName;
    /**
     * 物流区ID
     */
    private Long logisticsZoneId;
    /**
     * 买家ID
     */
    private String buyerId;
    /**
     * 买家编码
     */
    private String buyerCode;
    /**
     * 买家名称
     */
    private String buyerName;
    /**
     * 发起人类型
     */
    private String initiatorType;
    /**
     * 发起人ID
     */
    private String initiatorId;
    /**
     * 发起人名称
     */
    private String initiatorName;
    /**
     * 发起时间（yyyy-MM-dd HH:mm:ss）
     */
    private String initiateTime;
    /**
     * 问题概述
     */
    private String issueDesc;
    /**
     * 问题订单处理结果
     */
    private String issueResult;
    /**
     * 问题订单处理结论
     */
    private String issueDecision;
    /**
     * 结案人ID
     */
    private String closeUid;
    /**
     * 结案人名称
     */
    private String closeUname;
    /**
     * 结案时间(yyyy-MM-dd HH:mm:ss)
     */
    private String closeTime;
    /**
     * 问题订单状态
     */
    private String issueStatus;
    /**
     * 删除标记
     */
    private Boolean delFlg;
    /**
     * 创建者ID
     */
    private String crtId;
    /**
     * 创建时间(yyyy-MM-dd HH:mm:ss)
     */
    private String crtTime;
    /**
     * 更新者ID
     */
    private String updId;
    /**
     * 更新时间(yyyy-MM-dd HH:mm:ss)
     */
    private String updTime;
    /**
     * 版本
     */
    private Integer ver;


    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public String getIssueCode() {
        return issueCode;
    }

    public void setIssueCode(String issueCode) {
        this.issueCode = issueCode;
    }

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

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
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

    public Long getLogisticsZoneId() {
        return logisticsZoneId;
    }

    public void setLogisticsZoneId(Long logisticsZoneId) {
        this.logisticsZoneId = logisticsZoneId;
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

    public String getInitiatorType() {
        return initiatorType;
    }

    public void setInitiatorType(String initiatorType) {
        this.initiatorType = initiatorType;
    }

    public String getInitiatorId() {
        return initiatorId;
    }

    public void setInitiatorId(String initiatorId) {
        this.initiatorId = initiatorId;
    }

    public String getInitiatorName() {
        return initiatorName;
    }

    public void setInitiatorName(String initiatorName) {
        this.initiatorName = initiatorName;
    }

    public String getInitiateTime() {
        return initiateTime;
    }

    public void setInitiateTime(String initiateTime) {
        this.initiateTime = initiateTime;
    }

    public String getIssueDesc() {
        return issueDesc;
    }

    public void setIssueDesc(String issueDesc) {
        this.issueDesc = issueDesc;
    }

    public String getIssueResult() {
        return issueResult;
    }

    public void setIssueResult(String issueResult) {
        this.issueResult = issueResult;
    }

    public String getIssueDecision() {
        return issueDecision;
    }

    public void setIssueDecision(String issueDecision) {
        this.issueDecision = issueDecision;
    }

    public String getCloseUid() {
        return closeUid;
    }

    public void setCloseUid(String closeUid) {
        this.closeUid = closeUid;
    }

    public String getCloseUname() {
        return closeUname;
    }

    public void setCloseUname(String closeUname) {
        this.closeUname = closeUname;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(String issueStatus) {
        this.issueStatus = issueStatus;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public String getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(String crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public String getUpdTime() {
        return updTime;
    }

    public void setUpdTime(String updTime) {
        this.updTime = updTime;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }
}
