package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestFilter;

import java.util.Date;

/**
 * Created by wang_jianzhou on 2017/1/17.
 */
public class ORDR0502IFilterParam extends RestFilter {

    private Long logisticsZoneId;

    private String buyerCode;

    private String buyerName;

    private String buyerOrderCode;

    private String distributionNotificationCode;

    private Date expectedSendDateTimeFrom;

    private Date expectedSendDateTimeTo;

    private Date receiveTimeFrom;

    private Date receiveTimeTo;

    private String distributionNotificationStu;

    public Long getLogisticsZoneId() {
        return logisticsZoneId;
    }

    public void setLogisticsZoneId(Long logisticsZoneId) {
        this.logisticsZoneId = logisticsZoneId;
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

    public String getBuyerOrderCode() {
        return buyerOrderCode;
    }

    public void setBuyerOrderCode(String buyerOrderCode) {
        this.buyerOrderCode = buyerOrderCode;
    }

    public String getDistributionNotificationCode() {
        return distributionNotificationCode;
    }

    public void setDistributionNotificationCode(String distributionNotificationCode) {
        this.distributionNotificationCode = distributionNotificationCode;
    }

    public Date getExpectedSendDateTimeFrom() {
        return expectedSendDateTimeFrom;
    }

    public void setExpectedSendDateTimeFrom(Date expectedSendDateTimeFrom) {
        this.expectedSendDateTimeFrom = expectedSendDateTimeFrom;
    }

    public Date getExpectedSendDateTimeTo() {
        return expectedSendDateTimeTo;
    }

    public void setExpectedSendDateTimeTo(Date expectedSendDateTimeTo) {
        this.expectedSendDateTimeTo = expectedSendDateTimeTo;
    }

    public Date getReceiveTimeFrom() {
        return receiveTimeFrom;
    }

    public void setReceiveTimeFrom(Date receiveTimeFrom) {
        this.receiveTimeFrom = receiveTimeFrom;
    }

    public Date getReceiveTimeTo() {
        return receiveTimeTo;
    }

    public void setReceiveTimeTo(Date receiveTimeTo) {
        this.receiveTimeTo = receiveTimeTo;
    }

    public String getDistributionNotificationStu() {
        return distributionNotificationStu;
    }

    public void setDistributionNotificationStu(String distributionNotificationStu) {
        this.distributionNotificationStu = distributionNotificationStu;
    }
}
