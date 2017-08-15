package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestFilter;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 配送通知单查询接口Param
 * 
 * @author li_huiqian
 */
public class ORDR0303IFilterParam extends RestFilter {

    private static final long serialVersionUID = 4483103637320823108L;

    // 配送单id
    private Long[] distributionNotificationId;
    // 配送单号
    private String distributionNotificationCode;
    // 买家订单id
    private Long[] buyerOrderId;
    // 买家订单编码
    private String buyerOrderCode;
    // 买家ID
    private String[] buyerId;
    // 买家编码
    private String buyerCode;
    // 买家名称
    private String buyerName;
    // 买家类型编码
    private String buyerType;
    // 买家类型名称
    private String buyerTypeName;
    // 配送通知单状态
    private String[] distributionNotificationStu;
    //  物流区
    private  String logisticsZoneCode;


    private Date expectedSendDateTimeFrom;// 预计配送时间

    private  Date expectedSendDateTimeTo;

    private  Date crtTimeFrom;// 配送生成时间

    private  Date crtTimeTo;

    // 管家ID
    @ApiModelProperty(hidden = true)
    private String[] saId;



    public Long[] getDistributionNotificationId() {
        return distributionNotificationId;
    }

    public void setDistributionNotificationId(Long[] distributionNotificationId) {
        this.distributionNotificationId = distributionNotificationId;
    }

    public String getDistributionNotificationCode() {
        return distributionNotificationCode;
    }

    public void setDistributionNotificationCode(String distributionNotificationCode) {
        this.distributionNotificationCode = distributionNotificationCode;
    }

    public Long[] getBuyerOrderId() {
        return buyerOrderId;
    }

    public void setBuyerOrderId(Long[] buyerOrderId) {
        this.buyerOrderId = buyerOrderId;
    }

    public String getBuyerOrderCode() {
        return buyerOrderCode;
    }

    public void setBuyerOrderCode(String buyerOrderCode) {
        this.buyerOrderCode = buyerOrderCode;
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

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerType() {
        return buyerType;
    }

    public void setBuyerType(String buyerType) {
        this.buyerType = buyerType;
    }

    public String getBuyerTypeName() {
        return buyerTypeName;
    }

    public void setBuyerTypeName(String buyerTypeName) {
        this.buyerTypeName = buyerTypeName;
    }

    public String[] getDistributionNotificationStu() {
        return distributionNotificationStu;
    }

    public void setDistributionNotificationStu(String[] distributionNotificationStu) {
        this.distributionNotificationStu = distributionNotificationStu;
    }

    /**
     * @return the saId
     */
    public String[] getSaId() {
        return saId;
    }

    /**
     * @param saId
     *            the saId to set
     */
    public void setSaId(String[] saId) {
        this.saId = saId;
    }


    public String getLogisticsZoneCode() {
        return logisticsZoneCode;
    }

    public void setLogisticsZoneCode(String logisticsZoneCode) {
        this.logisticsZoneCode = logisticsZoneCode;
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

    public Date getCrtTimeFrom() {
        return crtTimeFrom;
    }

    public void setCrtTimeFrom(Date crtTimeFrom) {
        this.crtTimeFrom = crtTimeFrom;
    }

    public Date getCrtTimeTo() {
        return crtTimeTo;
    }

    public void setCrtTimeTo(Date crtTimeTo) {
        this.crtTimeTo = crtTimeTo;
    }
}
