package com.bms.order.bean.param;

import java.math.BigDecimal;
import java.util.List;

import com.bms.order.archive.impl.BuyerBatchOrder;
import com.bms.order.archive.impl.BuyerOrder;
import com.bms.order.bean.entity.BuyerBatchOrderAttachedEntity;
import com.bms.order.bean.entity.BuyerBatchOrderEntity;
import com.bms.order.common.rest.param.RestBean;
import com.framework.core.utils.DateUtils;

/**
 * Created by ni_shaotang on 2017/1/6.
 */
public class ORDR0102IBatchBean extends RestBean {

    /**
     * 
     */
    private static final long serialVersionUID = -4820099159710602065L;

    private List<ORDR0102IProductBean> products;

    /** 分批订单ID */
    private Long buyerBatchOrderId;
    /** 期望配送日 */
    private String requiredDistributionDate;
    /** 预计发货时间 */
    private String expectedSendDateTime;
    /** 预计到货时间 */
    private String expectedArrivalDateTime;
    /** 优惠金额 */
    private BigDecimal preferentialAmount;
    /** 收货人名称 */
    private String receiverName;
    /** 收货人电话 */
    private String receiverPhone;
    /** 收货人QQ */
    private String receiverQQ;
    /** 收货人微信 */
    private String receiverWechat;
    /** 收货人邮箱 */
    private String receiverMail;
    /** 收货地址省 */
    private String receiverProvince;
    /** 收货地址市 */
    private String receiverCity;
    /** 收货地址区 */
    private String receiverDistrict;
    /** 收货地址详细地址 */
    private String receiverAddress;
    /** 辅助地址项目 */
    private String receiverAssistAddress;
    /** 订单配送区域 */
    private String deliveryArea;
    /** 准入通行车型 */
    private String passTrafficModel;
    /** 收货时间段 */
    private String receivePeriod;
    /** 最早时间要求 */
    private String receiveEarliest;
    /** 最晚时间要求 */
    private String receiveLatest;
    /** 收货等待时间 */
    private String receiveWaitHour;
    /** 提前通知时间 */
    private String advanceNotificationHour;
    /** 动检证要求 */
    private Boolean animalQuarantineCertificationFlg;
    /** 装卸要求 */
    private String stevedoreRequirement;
    /** 包装要求 */
    private String packageRequirement;
    /** 距离门店最近停车距离（米） */
    private Integer nearestParkingDistance;
    /** 备注 */
    private String remark;
    /** 版本号 */
    private Integer ver;

    public List<ORDR0102IProductBean> getProducts() {
        return products;
    }

    public void setProducts(List<ORDR0102IProductBean> products) {
        this.products = products;
    }

    public Long getBuyerBatchOrderId() {
        return buyerBatchOrderId;
    }

    public void setBuyerBatchOrderId(Long buyerBatchOrderId) {
        this.buyerBatchOrderId = buyerBatchOrderId;
    }

    public String getRequiredDistributionDate() {
        return requiredDistributionDate;
    }

    public void setRequiredDistributionDate(String requiredDistributionDate) {
        this.requiredDistributionDate = requiredDistributionDate;
    }

    public String getExpectedSendDateTime() {
        return expectedSendDateTime;
    }

    public void setExpectedSendDateTime(String expectedSendDateTime) {
        this.expectedSendDateTime = expectedSendDateTime;
    }

    public String getExpectedArrivalDateTime() {
        return expectedArrivalDateTime;
    }

    public void setExpectedArrivalDateTime(String expectedArrivalDateTime) {
        this.expectedArrivalDateTime = expectedArrivalDateTime;
    }

    public BigDecimal getPreferentialAmount() {
        return preferentialAmount;
    }

    public void setPreferentialAmount(BigDecimal preferentialAmount) {
        this.preferentialAmount = preferentialAmount;
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

    public String getReceiveWaitHour() {
        return receiveWaitHour;
    }

    public void setReceiveWaitHour(String receiveWaitHour) {
        this.receiveWaitHour = receiveWaitHour;
    }

    public String getAdvanceNotificationHour() {
        return advanceNotificationHour;
    }

    public void setAdvanceNotificationHour(String advanceNotificationHour) {
        this.advanceNotificationHour = advanceNotificationHour;
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

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    public BuyerBatchOrder modifiedBuyerBatchOrder(BuyerOrder buyerOrder) {
        BuyerBatchOrderEntity entity = new BuyerBatchOrderEntity();
        BuyerBatchOrderAttachedEntity attachedEntity = new BuyerBatchOrderAttachedEntity();
        entity.setBuyerBatchOrderId(buyerBatchOrderId);
        attachedEntity.setBuyerBatchOrderId(buyerBatchOrderId);
        entity.setBuyerOrderId(buyerOrder.getEntity().getBuyerOrderId());
        entity.setRequiredDistributionDate(DateUtils.parseDate(requiredDistributionDate));
        entity.setExpectedSendDatetime(DateUtils.parseDateTime(expectedSendDateTime));
        entity.setExpectedArrivalDatetime(DateUtils.parseDateTime(expectedArrivalDateTime));
        entity.setPreferentialAmount(preferentialAmount);
        attachedEntity.setReceiverName(receiverName);
        attachedEntity.setReceiverPhone(receiverPhone);
        attachedEntity.setReceiverQq(receiverQQ);
        attachedEntity.setReceiverWechat(receiverWechat);
        attachedEntity.setReceiverMail(receiverMail);
        attachedEntity.setReceiverProvince(receiverProvince);
        attachedEntity.setReceiverCity(receiverCity);
        attachedEntity.setReceiverDistrict(receiverDistrict);
        attachedEntity.setReceiverAddress(receiverAddress);
        attachedEntity.setReceiverAssistAddress(receiverAssistAddress);
        attachedEntity.setDeliveryArea(deliveryArea);
        attachedEntity.setPassTrafficModel(passTrafficModel);
        attachedEntity.setReceivePeriod(receivePeriod);
        attachedEntity.setReceiveEarliest(receiveEarliest);
        attachedEntity.setReceiveLatest(receiveLatest);
        attachedEntity.setReceiveWaitHour(receiveWaitHour);
        attachedEntity.setAdvancedNotificationHour(advanceNotificationHour);
        attachedEntity.setAnimalQuarantineCertificationFlg(animalQuarantineCertificationFlg);
        attachedEntity.setStevedoreRequirement(stevedoreRequirement);
        attachedEntity.setPackageRequirement(packageRequirement);
        attachedEntity.setNearestParkingDistance(nearestParkingDistance);
        attachedEntity.setRemark(remark);
        entity.setVersion(ver);
        attachedEntity.setVersion(ver);
        BuyerBatchOrder buyerBatchOrder = BuyerBatchOrder.build(null).forCreate(entity, attachedEntity);
        buyerOrder.link(buyerBatchOrder);

        if (products != null) {
            for (ORDR0102IProductBean detailParam : products) {
                detailParam.modifiedBuyerBatchOrderDetail(buyerOrder, buyerBatchOrder);
            }
        }
        buyerBatchOrder.buyerBatchOrderDetailsLinked();

        return buyerBatchOrder;
    }
}
