package com.bms.order.bean.param;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.bms.order.archive.impl.BuyerBatchOrder;
import com.bms.order.archive.impl.BuyerOrder;
import com.bms.order.bean.entity.BuyerBatchOrderAttachedEntity;
import com.bms.order.bean.entity.BuyerBatchOrderEntity;
import com.framework.core.utils.DateUtils;

/**
 * 买家订单创建接口(分批订单)Param
 * 
 * @author li_huiqian
 */
public class ORDR010101IRestParam implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -8606599839247156223L;
    // 期望配送日
    private String requiredDistributionDate;
    // 收货人名称
    private String receiverName;
    // 收货人电话
    private String receiverPhone;
    // 收货人QQ
    private String receiverQq;
    // 收货人微信
    private String receiverWechat;
    // 收货人邮箱
    private String receiverMail;
    // 收货地址省
    private String receiverProvince;
    // 收货地址市
    private String receiverCity;
    // 收货地址区
    private String receiverDistrict;
    // 收货详细地址
    private String receiverAddress;
    // 辅助地址项目
    private String receiverAssistAddress;
    // 收货人详细地址管理Key
    private String receiverAddressKey;
    // 订单配送区域
    private String deliveryArea;
    // 准入通行车型
    private String passTrafficModel;
    // 收货时间段
    private String receivePeriod;
    // 最早时间要求
    private String receiveEarliest;
    // 最晚时间要求
    private String receiveLatest;
    // 收货等待时间
    private String receiveWaitHour;
    // 提前通知时间
    private String advancedNotificationHour;
    // 动检证要求
    private Boolean animalQuarantineCertificationFlg;
    // 装卸要求
    private String stevedoreRequirement;
    // 包装要求
    private String packageRequirement;
    // 距离门店最近停车距离(米)
    private Integer nearestParkingDistance;
    // 备注
    private String remark;
    // 预计发货时间
    private String expectedSendDateTime;
    // 预计到货时间
    private String expectedArrivalDateTime;

    // 分批订单明细信息
    private List<ORDR010102IRestParam> products;

    public BuyerBatchOrder generateBuyerBatchOrder(BuyerOrder buyerOrder) {
        // 构建买家分批订单
        BuyerBatchOrderEntity entity = new BuyerBatchOrderEntity();
        BuyerBatchOrderAttachedEntity attachedEntity = new BuyerBatchOrderAttachedEntity();

        // 转换后的日期
        Date transDate = null;
        // 转换期望配送日
        transDate = DateUtils.parseDate(requiredDistributionDate); // yyyy-MM-dd
        if (transDate == null)
            transDate = DateUtils.parse("yyyy/MM/dd", requiredDistributionDate);
        entity.setRequiredDistributionDate(transDate);
        attachedEntity.setReceiverName(receiverName);
        attachedEntity.setReceiverPhone(receiverPhone);
        attachedEntity.setReceiverQq(receiverQq);
        attachedEntity.setReceiverWechat(receiverWechat);
        attachedEntity.setReceiverMail(receiverMail);
        attachedEntity.setReceiverProvince(receiverProvince);
        attachedEntity.setReceiverCity(receiverCity);
        attachedEntity.setReceiverDistrict(receiverDistrict);
        attachedEntity.setReceiverAddress(receiverAddress);
        attachedEntity.setReceiverAssistAddress(receiverAssistAddress);
        attachedEntity.setAddressKey(receiverAddressKey);
        attachedEntity.setDeliveryArea(deliveryArea);
        attachedEntity.setPassTrafficModel(passTrafficModel);
        attachedEntity.setReceivePeriod(receivePeriod);
        attachedEntity.setReceiveEarliest(receiveEarliest);
        attachedEntity.setReceiveLatest(receiveLatest);
        attachedEntity.setReceiveWaitHour(receiveWaitHour);
        attachedEntity.setAdvancedNotificationHour(advancedNotificationHour);
        attachedEntity.setAnimalQuarantineCertificationFlg(animalQuarantineCertificationFlg);
        attachedEntity.setStevedoreRequirement(stevedoreRequirement);
        attachedEntity.setPackageRequirement(packageRequirement);
        attachedEntity.setNearestParkingDistance(nearestParkingDistance);
        attachedEntity.setRemark(remark);
        // 转换预计发货时间
        transDate = null;
        transDate = DateUtils.parseDateTime(expectedSendDateTime); // yyyy-MM-dd HH:mm:ss
        if (transDate == null)
            transDate = DateUtils.parse("yyyy/MM/dd HH:mm:ss", expectedSendDateTime);
        entity.setExpectedSendDatetime(transDate);
        // 转换预计收货时间
        transDate = null;
        transDate = DateUtils.parseDateTime(expectedArrivalDateTime); // yyyy-MM-dd HH:mm:ss
        if (transDate == null)
            transDate = DateUtils.parse("yyyy/MM/dd HH:mm:ss", expectedArrivalDateTime);
        entity.setExpectedArrivalDatetime(transDate);

        BuyerBatchOrder buyerBatchOrder = BuyerBatchOrder.build(null).forCreate(entity, attachedEntity);

        buyerOrder.link(buyerBatchOrder);

        // 绑定分批订单明细
        for (ORDR010102IRestParam product : this.getProducts()) {
            product.generateBuyerBatchOrderDetail(buyerOrder, buyerBatchOrder);
        }
        buyerBatchOrder.buyerBatchOrderDetailsLinked();

        return buyerBatchOrder;
    }

    public String getRequiredDistributionDate() {
        return requiredDistributionDate;
    }

    public void setRequiredDistributionDate(String requiredDistributionDate) {
        this.requiredDistributionDate = requiredDistributionDate;
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

    public String getReceiverQq() {
        return receiverQq;
    }

    public void setReceiverQq(String receiverQq) {
        this.receiverQq = receiverQq;
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

    public List<ORDR010102IRestParam> getProducts() {
        return products;
    }

    public void setProducts(List<ORDR010102IRestParam> products) {
        this.products = products;
    }

    public String getReceiverAddressKey() {
        return receiverAddressKey;
    }

    public void setReceiverAddressKey(String receiverAddressKey) {
        this.receiverAddressKey = receiverAddressKey;
    }
}
