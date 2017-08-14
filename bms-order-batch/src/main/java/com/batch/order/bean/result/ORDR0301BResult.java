package com.batch.order.bean.result;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

/**
 * Created by liutao on 2017/3/10.
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"orderId","orderCode","originalorderId","orderType","buyerId","buyerType","buyerName","requestedDate","scheduledDate","ver","paymentType","receiver","distributionResults"})
public class ORDR0301BResult {

    private Long orderId;

    private String orderCode;

    private Long originalorderId;

    private String orderType;

    private String buyerId;

    private String buyerType;

    private String buyerName;

    private Date requestedDate;

    private Date scheduledDate;

    private Integer ver;

    private String paymentType;

    private ORDR0301BReceiverResult receiver;

    private List<ORDR0301BDistributionResult> distributionResults;

    @XmlElement(name = "ORDERID",defaultValue = "")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @XmlElement(name = "ORDERCODE",defaultValue = "")
    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    @XmlElement(name = "ORIGINALORDERID",defaultValue = "")
    public Long getOriginalorderId() {
        return originalorderId;
    }

    public void setOriginalorderId(Long originalorderId) {
        this.originalorderId = originalorderId;
    }

    @XmlElement(name = "ORDERTYPE",defaultValue = "")
    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @XmlElement(name = "TARGETCOMPANY",defaultValue = "")
    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    @XmlElement(name = "COMPANYTYPE",defaultValue = "")
    public String getBuyerType() {
        return buyerType;
    }

    public void setBuyerType(String buyerType) {
        this.buyerType = buyerType;
    }

    @XmlElement(name = "COMPANYNAME",defaultValue = "")
    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    @XmlElement(name = "REQUESTEDDATE",defaultValue = "")
    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    @XmlElement(name = "SCHEDULEDDATE",defaultValue = "")
    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    @XmlElement(name = "VER",defaultValue = "")
    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    @XmlElement(name = "PAYMENTTYPE",defaultValue = "")
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @XmlElement(name = "RECEIVER",defaultValue = "")
    public ORDR0301BReceiverResult getReceiver() {
        return receiver;
    }

    public void setReceiver(ORDR0301BReceiverResult receiver) {
        this.receiver = receiver;
    }

    @XmlElementWrapper(name="LINES")
    @XmlElement(name="LINE")
    public List<ORDR0301BDistributionResult> getDistributionResults() {
        return distributionResults;
    }

    public void setDistributionResults(List<ORDR0301BDistributionResult> distributionResults) {
        this.distributionResults = distributionResults;
    }
}
