package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestFilter;

import java.util.Date;

/**
 * Created by wang_jianzhou on 2017/1/17.
 */
public class ORDR0403IFilterParam extends RestFilter {

    private Long logisticsZoneId;

    private String buyerCode;

    private String buyerName;

    private String buyerOrderCode;

    private String distributionNotificationCode;

    private String sendNotifictionId;

    private String sendNotifictionCode;

    private Date expectedSendDateTimeFrom;

    private Date expectedSendDateTimeTo;

    private Date realDepartDatetimeFrom;

    private Date realDepartDatetimeTo;


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

    /**
     * Getter method for property <tt>sendNotifictionId</tt>.
     *
     * @return property value of sendNotifictionId
     */
    public String getSendNotifictionId() {
        return sendNotifictionId;
    }

    /**
     * Setter method for property <tt>sendNotifictionId</tt>.
     *
     * @param sendNotifictionId value to be assigned to property sendNotifictionId
     */
    public void setSendNotifictionId(String sendNotifictionId) {
        this.sendNotifictionId = sendNotifictionId;
    }

    public String getSendNotifictionCode() {
        return sendNotifictionCode;
    }

    public void setSendNotifictionCode(String sendNotifictionCode) {
        this.sendNotifictionCode = sendNotifictionCode;
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

    public Date getRealDepartDatetimeFrom() {
        return realDepartDatetimeFrom;
    }

    public void setRealDepartDatetimeFrom(Date realDepartDatetimeFrom) {
        this.realDepartDatetimeFrom = realDepartDatetimeFrom;
    }

    public Date getRealDepartDatetimeTo() {
        return realDepartDatetimeTo;
    }

    public void setRealDepartDatetimeTo(Date realDepartDatetimeTo) {
        this.realDepartDatetimeTo = realDepartDatetimeTo;
    }
}
