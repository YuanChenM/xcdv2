package com.bms.order.bean.param;

import java.util.Date;
import java.util.List;

import com.bms.order.archive.impl.BuyerForcastDeliverDetail;
import com.bms.order.archive.impl.BuyerOrder;
import com.bms.order.archive.impl.DistributionNotificationDetail;
import com.bms.order.bean.entity.BuyerForcastDeliverDetailAttachedEntity;
import com.bms.order.bean.entity.BuyerForcastDeliverDetailEntity;
import com.bms.order.bean.entity.BuyerOrderAttachedEntity;
import com.bms.order.bean.entity.BuyerOrderEntity;
import com.bms.order.bean.entity.DistributionNotificationDetailEntity;
import com.bms.order.common.rest.param.RestBean;
import com.bms.order.constant.enumeration.BuyerOrderStu;

/**
 * 配送通知单创建接口Param
 *
 * @author li_huiqian
 */
public class ORDR0301IBeanParam extends RestBean {

    /**
     * 
     */
    private static final long serialVersionUID = -2430249905880405001L;

    private Long buyerOrderId;

    private List<ORDR0301IDetail> details;

    private Integer paymentType;

    private String receiverName;

    private String receiverPhone;

    private String receiverQQ;

    private String receiverWechat;

    private String receiverMail;

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

    private Date receiveWaitHour;

    private Date advancedNotificationHour;

    private Boolean animalQuarantineCertificationFlg;

    private String stevedoreRequirement;

    private String packageRequirement;

    private Integer nearestParkingDistance;

    private String remark;

    private Date expectedSendDatetime;

    private Date expectedArrivalDatetime;

    public Long getBuyerOrderId() {
        return buyerOrderId;
    }

    public void setBuyerOrderId(Long buyerOrderId) {
        this.buyerOrderId = buyerOrderId;
    }

    public List<ORDR0301IDetail> getDetails() {
        return details;
    }

    public void setDetails(List<ORDR0301IDetail> details) {
        this.details = details;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
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

    public String getReceiverQQ() {
        return receiverQQ;
    }

    public void setReceiverQQ(String receiverQQ) {
        this.receiverQQ = receiverQQ;
    }

    public String getReceiverWechat() {
        return receiverWechat;
    }

    public void setReceiverWechat(String receiverWechat) {
        this.receiverWechat = receiverWechat;
    }

    public String getReceiverMail() {
        return receiverMail;
    }

    public void setReceiverMail(String receiverMail) {
        this.receiverMail = receiverMail;
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

    public Date getReceiveWaitHour() {
        return receiveWaitHour;
    }

    public void setReceiveWaitHour(Date receiveWaitHour) {
        this.receiveWaitHour = receiveWaitHour;
    }

    public Date getAdvancedNotificationHour() {
        return advancedNotificationHour;
    }

    public void setAdvancedNotificationHour(Date advancedNotificationHour) {
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

    public Date getExpectedSendDatetime() {
        return expectedSendDatetime;
    }

    public void setExpectedSendDatetime(Date expectedSendDatetime) {
        this.expectedSendDatetime = expectedSendDatetime;
    }

    public Date getExpectedArrivalDatetime() {
        return expectedArrivalDatetime;
    }

    public void setExpectedArrivalDatetime(Date expectedArrivalDatetime) {
        this.expectedArrivalDatetime = expectedArrivalDatetime;
    }

    public static class ORDR0301IDetail {

        private Long buyerForcastDeliverDetailId;

        public Long getBuyerForcastDeliverDetailId() {
            return buyerForcastDeliverDetailId;
        }

        public void setBuyerForcastDeliverDetailId(Long buyerForcastDeliverDetailId) {
            this.buyerForcastDeliverDetailId = buyerForcastDeliverDetailId;
        }

        public BuyerForcastDeliverDetail generateBuyerForcastDeliverDetail() {
            BuyerForcastDeliverDetailEntity entity = new BuyerForcastDeliverDetailEntity();
            BuyerForcastDeliverDetailAttachedEntity attachedEntity = new BuyerForcastDeliverDetailAttachedEntity();
            entity.setBuyerForcastDeliverDetailId(buyerForcastDeliverDetailId);
            BuyerForcastDeliverDetail buyerForcastDeliverDetail = new BuyerForcastDeliverDetail(entity, attachedEntity);
            return buyerForcastDeliverDetail;
        }

        public DistributionNotificationDetail generateDistributionNotification() {
            DistributionNotificationDetailEntity entity = new DistributionNotificationDetailEntity();
            entity.setBuyerForcastDeliverDetailId(buyerForcastDeliverDetailId);
            DistributionNotificationDetail distributionNotificationDetail = new DistributionNotificationDetail(entity);
            return distributionNotificationDetail;
        }
    }

    public BuyerOrder generateBuyerOrder() {
        BuyerOrderEntity buyerOrderEntity = new BuyerOrderEntity();
        BuyerOrderAttachedEntity attachedEntity = new BuyerOrderAttachedEntity();
        buyerOrderEntity.setBuyerOrderId(buyerOrderId);
        buyerOrderEntity.setBuyerOrderStu(BuyerOrderStu.NOT_COMPLETED.getCode());
        BuyerOrder buyerOrder = new BuyerOrder(buyerOrderEntity, attachedEntity);
        return buyerOrder;
    }

}
