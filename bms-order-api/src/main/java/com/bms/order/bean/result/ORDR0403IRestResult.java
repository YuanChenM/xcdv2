package com.bms.order.bean.result;

import java.util.Date;
import java.util.List;

import com.bms.order.common.rest.result.RestSearchData;

/**
 * Created by wang_jianzhou on 2017/1/17.
 */
public class ORDR0403IRestResult extends RestSearchData {

    /**
     * 
     */
    private static final long serialVersionUID = 8019640181695593850L;

    private String disBatchCode;

    private Long buyerOrderId;

    private String buyerOrderCode;

    private String logisticsZoneName;

    private String buyerCode;

    private String buyerName;

    private Long sendNotifictionID;

    private String sendNotifictionCode;

    private Date realDepartDateTime;

    private String distributionPersonName;

    private String distributionPersonPhone;

    private String distributionType;

    private String distributionVehicle;

    private Date expectedArrivalDateTime;

    private String distributionNotificationCode;

    private Date expectedSendDateTime;

    private Long distributionNotificationId;

    private String distributionNotificationStu;

    private Date distributionNotificationTime;

    private String receiverName;

    private String receiverPhone;

    private String receiverWechat;

    private String receiverProvince;

    private String receiverCity;

    private String receiverDistrict;

    private String receiverAddress;

    private String receiverAssistAddress;

    private String deliveryArea;

    private String passTrafficModel;

    private String receivePeriod;

    private String receiveEarliest;

    private String receiveLatest;

    private String receiveWaitHour;

    private String advancedNotificationHour;

    private Boolean animalQuarantineCertificationFlg;

    private String stevedoreRequirement;

    private String packageRequirement;

    private Integer nearestParkingDistance;

    private String remark;

    private Date receiveTime;

    private List<ORDR0403IDetailsRestResult> details;

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getDisBatchCode() {
        return disBatchCode;
    }

    public void setDisBatchCode(String disBatchCode) {
        this.disBatchCode = disBatchCode;
    }

    public Long getBuyerOrderId() {
        return buyerOrderId;
    }

    public void setBuyerOrderId(Long buyerOrderId) {
        this.buyerOrderId = buyerOrderId;
    }

    public String getBuyerOrderCode() {
        return buyerOrderCode;
    }

    public void setBuyerOrderCode(String buyerOrderCode) {
        this.buyerOrderCode = buyerOrderCode;
    }

    public String getLogisticsZoneName() {
        return logisticsZoneName;
    }

    public void setLogisticsZoneName(String logisticsZoneName) {
        this.logisticsZoneName = logisticsZoneName;
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

    public Long getSendNotifictionID() {
        return sendNotifictionID;
    }

    public void setSendNotifictionID(Long sendNotifictionID) {
        this.sendNotifictionID = sendNotifictionID;
    }

    public String getSendNotifictionCode() {
        return sendNotifictionCode;
    }

    public void setSendNotifictionCode(String sendNotifictionCode) {
        this.sendNotifictionCode = sendNotifictionCode;
    }

    public Date getRealDepartDateTime() {
        return realDepartDateTime;
    }

    public void setRealDepartDateTime(Date realDepartDateTime) {
        this.realDepartDateTime = realDepartDateTime;
    }

    public String getDistributionPersonName() {
        return distributionPersonName;
    }

    public void setDistributionPersonName(String distributionPersonName) {
        this.distributionPersonName = distributionPersonName;
    }

    public String getDistributionPersonPhone() {
        return distributionPersonPhone;
    }

    public void setDistributionPersonPhone(String distributionPersonPhone) {
        this.distributionPersonPhone = distributionPersonPhone;
    }

    public String getDistributionType() {
        return distributionType;
    }

    public void setDistributionType(String distributionType) {
        this.distributionType = distributionType;
    }

    public String getDistributionVehicle() {
        return distributionVehicle;
    }

    public void setDistributionVehicle(String distributionVehicle) {
        this.distributionVehicle = distributionVehicle;
    }

    public Date getExpectedArrivalDateTime() {
        return expectedArrivalDateTime;
    }

    public void setExpectedArrivalDateTime(Date expectedArrivalDateTime) {
        this.expectedArrivalDateTime = expectedArrivalDateTime;
    }

    public String getDistributionNotificationCode() {
        return distributionNotificationCode;
    }

    public void setDistributionNotificationCode(String distributionNotificationCode) {
        this.distributionNotificationCode = distributionNotificationCode;
    }

    public Date getExpectedSendDateTime() {
        return expectedSendDateTime;
    }

    public void setExpectedSendDateTime(Date expectedSendDateTime) {
        this.expectedSendDateTime = expectedSendDateTime;
    }

    public Long getDistributionNotificationId() {
        return distributionNotificationId;
    }

    public void setDistributionNotificationId(Long distributionNotificationId) {
        this.distributionNotificationId = distributionNotificationId;
    }

    public String getDistributionNotificationStu() {
        return distributionNotificationStu;
    }

    public void setDistributionNotificationStu(String distributionNotificationStu) {
        this.distributionNotificationStu = distributionNotificationStu;
    }

    public Date getDistributionNotificationTime() {
        return distributionNotificationTime;
    }

    public void setDistributionNotificationTime(Date distributionNotificationTime) {
        this.distributionNotificationTime = distributionNotificationTime;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverWechat() {
        return receiverWechat;
    }

    public void setReceiverWechat(String receiverWechat) {
        this.receiverWechat = receiverWechat;
    }

    public String getReceiverProvince() {
        return receiverProvince;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverDistrict() {
        return receiverDistrict;
    }

    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverAssistAddress() {
        return receiverAssistAddress;
    }

    public void setReceiverAssistAddress(String receiverAssistAddress) {
        this.receiverAssistAddress = receiverAssistAddress;
    }

    public String getDeliveryArea() {
        return deliveryArea;
    }

    public void setDeliveryArea(String deliveryArea) {
        this.deliveryArea = deliveryArea;
    }

    public String getPassTrafficModel() {
        return passTrafficModel;
    }

    public void setPassTrafficModel(String passTrafficModel) {
        this.passTrafficModel = passTrafficModel;
    }

    public String getReceivePeriod() {
        return receivePeriod;
    }

    public void setReceivePeriod(String receivePeriod) {
        this.receivePeriod = receivePeriod;
    }

    public String getReceiveEarliest() {
        return receiveEarliest;
    }

    public void setReceiveEarliest(String receiveEarliest) {
        this.receiveEarliest = receiveEarliest;
    }

    public String getReceiveLatest() {
        return receiveLatest;
    }

    public void setReceiveLatest(String receiveLatest) {
        this.receiveLatest = receiveLatest;
    }

    public String getReceiveWaitHour() {
        return receiveWaitHour;
    }

    public void setReceiveWaitHour(String receiveWaitHour) {
        this.receiveWaitHour = receiveWaitHour;
    }

    public String getAdvancedNotificationHour() {
        return advancedNotificationHour;
    }

    public void setAdvancedNotificationHour(String advancedNotificationHour) {
        this.advancedNotificationHour = advancedNotificationHour;
    }

    public Boolean getAnimalQuarantineCertificationFlg() {
        return animalQuarantineCertificationFlg;
    }

    public void setAnimalQuarantineCertificationFlg(Boolean animalQuarantineCertificationFlg) {
        this.animalQuarantineCertificationFlg = animalQuarantineCertificationFlg;
    }

    public String getStevedoreRequirement() {
        return stevedoreRequirement;
    }

    public void setStevedoreRequirement(String stevedoreRequirement) {
        this.stevedoreRequirement = stevedoreRequirement;
    }

    public String getPackageRequirement() {
        return packageRequirement;
    }

    public void setPackageRequirement(String packageRequirement) {
        this.packageRequirement = packageRequirement;
    }

    public Integer getNearestParkingDistance() {
        return nearestParkingDistance;
    }

    public void setNearestParkingDistance(Integer nearestParkingDistance) {
        this.nearestParkingDistance = nearestParkingDistance;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<ORDR0403IDetailsRestResult> getDetails() {
        return details;
    }

    public void setDetails(List<ORDR0403IDetailsRestResult> details) {
        this.details = details;
    }
}
