package com.bms.order.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

import java.util.Date;
import java.math.BigDecimal;

public class DistributionNotificationEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 通知单：配送单ID
     */
    private Long distributionNotificationId;

    /**
     * 获取通知单：配送单ID
     *
     * @return 通知单：配送单ID
     */
    public Long getDistributionNotificationId() {
        return this.distributionNotificationId;
    }

    /**
     * 设置通知单：配送单ID
     *
     * @param distributionNotificationId
     */
    public void setDistributionNotificationId(Long distributionNotificationId) {
        this.distributionNotificationId = distributionNotificationId;
    }

    /**
     * 通知单：配送单号 [传给美迪福的唯一编号]
     */
    private String distributionNotificationCode;

    /**
     * 获取通知单：配送单号 [传给美迪福的唯一编号]
     *
     * @return 通知单：配送单号 [传给美迪福的唯一编号]
     */
    public String getDistributionNotificationCode() {
        return this.distributionNotificationCode;
    }

    /**
     * 设置通知单：配送单号 [传给美迪福的唯一编号]
     *
     * @param distributionNotificationCode
     */
    public void setDistributionNotificationCode(String distributionNotificationCode) {
        this.distributionNotificationCode = distributionNotificationCode;
    }

    /**
     * 通知单：买家订单ID
     */
    private Long buyerOrderId;

    /**
     * 获取通知单：买家订单ID
     *
     * @return 通知单：买家订单ID
     */
    public Long getBuyerOrderId() {
        return this.buyerOrderId;
    }

    /**
     * 设置通知单：买家订单ID
     *
     * @param buyerOrderId
     */
    public void setBuyerOrderId(Long buyerOrderId) {
        this.buyerOrderId = buyerOrderId;
    }

    /**
     * 通知单：买家订单编码
     */
    private String buyerOrderCode;

    /**
     * 获取通知单：买家订单编码
     *
     * @return 通知单：买家订单编码
     */
    public String getBuyerOrderCode() {
        return this.buyerOrderCode;
    }

    /**
     * 设置通知单：买家订单编码
     *
     * @param buyerOrderCode
     */
    public void setBuyerOrderCode(String buyerOrderCode) {
        this.buyerOrderCode = buyerOrderCode;
    }

    /**
     * 通知单：买家订单类型
     */
    private String orderType;

    /**
     * 获取通知单：买家订单类型
     *
     * @return 通知单：买家订单类型
     */
    public String getOrderType() {
        return this.orderType;
    }

    /**
     * 设置通知单：买家订单类型
     *
     * @param orderType
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    /**
     * 买家：买家ID
     */
    private String buyerId;

    /**
     * 获取买家：买家ID
     *
     * @return 买家：买家ID
     */
    public String getBuyerId() {
        return this.buyerId;
    }

    /**
     * 设置买家：买家ID
     *
     * @param buyerId
     */
    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    /**
     * 买家：买家类型编码
     */
    private String buyerType;

    /**
     * 获取买家：买家类型编码
     *
     * @return 买家：买家类型编码
     */
    public String getBuyerType() {
        return this.buyerType;
    }

    /**
     * 设置买家：买家类型编码
     *
     * @param buyerType
     */
    public void setBuyerType(String buyerType) {
        this.buyerType = buyerType;
    }

    /**
     * 买家：买家类型名称
     */
    private String buyerTypeName;

    /**
     * 获取买家：买家类型名称
     *
     * @return 买家：买家类型名称
     */
    public String getBuyerTypeName() {
        return this.buyerTypeName;
    }

    /**
     * 设置买家：买家类型名称
     *
     * @param buyerTypeName
     */
    public void setBuyerTypeName(String buyerTypeName) {
        this.buyerTypeName = buyerTypeName;
    }

    /**
     * 买家：买家编码
     */
    private String buyerCode;

    /**
     * 获取买家：买家编码
     *
     * @return 买家：买家编码
     */
    public String getBuyerCode() {
        return this.buyerCode;
    }

    /**
     * 设置买家：买家编码
     *
     * @param buyerCode
     */
    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    /**
     * 买家：买家名称
     */
    private String buyerName;

    /**
     * 获取买家：买家名称
     *
     * @return 买家：买家名称
     */
    public String getBuyerName() {
        return this.buyerName;
    }

    /**
     * 设置买家：买家名称
     *
     * @param buyerName
     */
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    /**
     * 支付：付款类型 [CodeMaster]
     */
    private String paymentType;

    /**
     * 获取支付：付款类型 [CodeMaster]
     *
     * @return 支付：付款类型 [CodeMaster]
     */
    public String getPaymentType() {
        return this.paymentType;
    }

    /**
     * 设置支付：付款类型 [CodeMaster]
     *
     * @param paymentType
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * 收货人：收货人名称
     */
    private String receiverName;

    /**
     * 获取收货人：收货人名称
     *
     * @return 收货人：收货人名称
     */
    public String getReceiverName() {
        return this.receiverName;
    }

    /**
     * 设置收货人：收货人名称
     *
     * @param receiverName
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    /**
     * 收货人：收货人电话
     */
    private String receiverPhone;

    /**
     * 获取收货人：收货人电话
     *
     * @return 收货人：收货人电话
     */
    public String getReceiverPhone() {
        return this.receiverPhone;
    }

    /**
     * 设置收货人：收货人电话
     *
     * @param receiverPhone
     */
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    /**
     * 收货人：收货人QQ
     */
    private String receiverQq;

    /**
     * 获取收货人：收货人QQ
     *
     * @return 收货人：收货人QQ
     */
    public String getReceiverQq() {
        return this.receiverQq;
    }

    /**
     * 设置收货人：收货人QQ
     *
     * @param receiverQq
     */
    public void setReceiverQq(String receiverQq) {
        this.receiverQq = receiverQq;
    }

    /**
     * 收货人：收货人微信
     */
    private String receiverWechat;

    /**
     * 获取收货人：收货人微信
     *
     * @return 收货人：收货人微信
     */
    public String getReceiverWechat() {
        return this.receiverWechat;
    }

    /**
     * 设置收货人：收货人微信
     *
     * @param receiverWechat
     */
    public void setReceiverWechat(String receiverWechat) {
        this.receiverWechat = receiverWechat;
    }

    /**
     * 收货人：收货人邮箱
     */
    private String receiverMail;

    /**
     * 获取收货人：收货人邮箱
     *
     * @return 收货人：收货人邮箱
     */
    public String getReceiverMail() {
        return this.receiverMail;
    }

    /**
     * 设置收货人：收货人邮箱
     *
     * @param receiverMail
     */
    public void setReceiverMail(String receiverMail) {
        this.receiverMail = receiverMail;
    }

    /**
     * 收货地址：收货地址省
     */
    private String receiverProvince;

    /**
     * 获取收货地址：收货地址省
     *
     * @return 收货地址：收货地址省
     */
    public String getReceiverProvince() {
        return this.receiverProvince;
    }

    /**
     * 设置收货地址：收货地址省
     *
     * @param receiverProvince
     */
    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    /**
     * 收货地址：收货地址市
     */
    private String receiverCity;

    /**
     * 获取收货地址：收货地址市
     *
     * @return 收货地址：收货地址市
     */
    public String getReceiverCity() {
        return this.receiverCity;
    }

    /**
     * 设置收货地址：收货地址市
     *
     * @param receiverCity
     */
    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    /**
     * 收货地址：收货地址区
     */
    private String receiverDistrict;

    /**
     * 获取收货地址：收货地址区
     *
     * @return 收货地址：收货地址区
     */
    public String getReceiverDistrict() {
        return this.receiverDistrict;
    }

    /**
     * 设置收货地址：收货地址区
     *
     * @param receiverDistrict
     */
    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict;
    }

    /**
     * 收货地址：收货地址详细地址
     */
    private String receiverAddress;

    /**
     * 获取收货地址：收货地址详细地址
     *
     * @return 收货地址：收货地址详细地址
     */
    public String getReceiverAddress() {
        return this.receiverAddress;
    }

    /**
     * 设置收货地址：收货地址详细地址
     *
     * @param receiverAddress
     */
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    /**
     * 收货地址：辅助地址项目
     */
    private String receiverAssistAddress;

    /**
     * 获取收货地址：辅助地址项目
     *
     * @return 收货地址：辅助地址项目
     */
    public String getReceiverAssistAddress() {
        return this.receiverAssistAddress;
    }

    /**
     * 设置收货地址：辅助地址项目
     *
     * @param receiverAssistAddress
     */
    public void setReceiverAssistAddress(String receiverAssistAddress) {
        this.receiverAssistAddress = receiverAssistAddress;
    }

    /**
     * 收货地址：订单配送区域
     */
    private String deliveryArea;

    /**
     * 获取收货地址：订单配送区域
     *
     * @return 收货地址：订单配送区域
     */
    public String getDeliveryArea() {
        return this.deliveryArea;
    }

    /**
     * 设置收货地址：订单配送区域
     *
     * @param deliveryArea
     */
    public void setDeliveryArea(String deliveryArea) {
        this.deliveryArea = deliveryArea;
    }

    /**
     * 收货地址：准入通行车型
     */
    private String passTrafficModel;

    /**
     * 获取收货地址：准入通行车型
     *
     * @return 收货地址：准入通行车型
     */
    public String getPassTrafficModel() {
        return this.passTrafficModel;
    }

    /**
     * 设置收货地址：准入通行车型
     *
     * @param passTrafficModel
     */
    public void setPassTrafficModel(String passTrafficModel) {
        this.passTrafficModel = passTrafficModel;
    }

    /**
     * 收货要求：配送方式
     */
    private String distributionType;

    /**
     * 获取收货要求：配送方式
     *
     * @return 收货要求：配送方式
     */
    public String getDistributionType() {
        return this.distributionType;
    }

    /**
     * 设置收货要求：配送方式
     *
     * @param distributionType
     */
    public void setDistributionType(String distributionType) {
        this.distributionType = distributionType;
    }

    /**
     * 收货要求：收货时间段
     */
    private String receivePeriod;

    /**
     * 获取收货要求：收货时间段
     *
     * @return 收货要求：收货时间段
     */
    public String getReceivePeriod() {
        return this.receivePeriod;
    }

    /**
     * 设置收货要求：收货时间段
     *
     * @param receivePeriod
     */
    public void setReceivePeriod(String receivePeriod) {
        this.receivePeriod = receivePeriod;
    }

    /**
     * 收货要求：最早时间要求
     */
    private String receiveEarliest;

    /**
     * 获取收货要求：最早时间要求
     *
     * @return 收货要求：最早时间要求
     */
    public String getReceiveEarliest() {
        return this.receiveEarliest;
    }

    /**
     * 设置收货要求：最早时间要求
     *
     * @param receiveEarliest
     */
    public void setReceiveEarliest(String receiveEarliest) {
        this.receiveEarliest = receiveEarliest;
    }

    /**
     * 收货要求：最晚时间要求
     */
    private String receiveLatest;

    /**
     * 获取收货要求：最晚时间要求
     *
     * @return 收货要求：最晚时间要求
     */
    public String getReceiveLatest() {
        return this.receiveLatest;
    }

    /**
     * 设置收货要求：最晚时间要求
     *
     * @param receiveLatest
     */
    public void setReceiveLatest(String receiveLatest) {
        this.receiveLatest = receiveLatest;
    }

    /**
     * 收货要求：收货等待时间
     */
    private String receiveWaitHour;

    /**
     * 获取收货要求：收货等待时间
     *
     * @return 收货要求：收货等待时间
     */
    public String getReceiveWaitHour() {
        return this.receiveWaitHour;
    }

    /**
     * 设置收货要求：收货等待时间
     *
     * @param receiveWaitHour
     */
    public void setReceiveWaitHour(String receiveWaitHour) {
        this.receiveWaitHour = receiveWaitHour;
    }

    /**
     * 收货要求：提前通知时间
     */
    private String advancedNotificationHour;

    /**
     * 获取收货要求：提前通知时间
     *
     * @return 收货要求：提前通知时间
     */
    public String getAdvancedNotificationHour() {
        return this.advancedNotificationHour;
    }

    /**
     * 设置收货要求：提前通知时间
     *
     * @param advancedNotificationHour
     */
    public void setAdvancedNotificationHour(String advancedNotificationHour) {
        this.advancedNotificationHour = advancedNotificationHour;
    }

    /**
     * 收货要求：动检证要求
     */
    private Boolean animalQuarantineCertificationFlg;

    /**
     * 获取收货要求：动检证要求
     *
     * @return 收货要求：动检证要求
     */
    public Boolean getAnimalQuarantineCertificationFlg() {
        return this.animalQuarantineCertificationFlg;
    }

    /**
     * 设置收货要求：动检证要求
     *
     * @param animalQuarantineCertificationFlg
     */
    public void setAnimalQuarantineCertificationFlg(Boolean animalQuarantineCertificationFlg) {
        this.animalQuarantineCertificationFlg = animalQuarantineCertificationFlg;
    }

    /**
     * 收货要求：装卸要求
     */
    private String stevedoreRequirement;

    /**
     * 获取收货要求：装卸要求
     *
     * @return 收货要求：装卸要求
     */
    public String getStevedoreRequirement() {
        return this.stevedoreRequirement;
    }

    /**
     * 设置收货要求：装卸要求
     *
     * @param stevedoreRequirement
     */
    public void setStevedoreRequirement(String stevedoreRequirement) {
        this.stevedoreRequirement = stevedoreRequirement;
    }

    /**
     * 收货要求：包装要求
     */
    private String packageRequirement;

    /**
     * 获取收货要求：包装要求
     *
     * @return 收货要求：包装要求
     */
    public String getPackageRequirement() {
        return this.packageRequirement;
    }

    /**
     * 设置收货要求：包装要求
     *
     * @param packageRequirement
     */
    public void setPackageRequirement(String packageRequirement) {
        this.packageRequirement = packageRequirement;
    }

    /**
     * 收货要求：距离门店最近停车距离（米）
     */
    private Integer nearestParkingDistance;

    /**
     * 获取收货要求：距离门店最近停车距离（米）
     *
     * @return 收货要求：距离门店最近停车距离（米）
     */
    public Integer getNearestParkingDistance() {
        return this.nearestParkingDistance;
    }

    /**
     * 设置收货要求：距离门店最近停车距离（米）
     *
     * @param nearestParkingDistance
     */
    public void setNearestParkingDistance(Integer nearestParkingDistance) {
        this.nearestParkingDistance = nearestParkingDistance;
    }

    /**
     * 收货要求：备注
     */
    private String remark;

    /**
     * 获取收货要求：备注
     *
     * @return 收货要求：备注
     */
    public String getRemark() {
        return this.remark;
    }

    /**
     * 设置收货要求：备注
     *
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 收货要求：预期发货时间
     */
    private Date expectedSendDatetime;

    /**
     * 获取收货要求：预期发货时间
     *
     * @return 收货要求：预期发货时间
     */
    public Date getExpectedSendDatetime() {
        return this.expectedSendDatetime;
    }

    /**
     * 设置收货要求：预期发货时间
     *
     * @param expectedSendDatetime
     */
    public void setExpectedSendDatetime(Date expectedSendDatetime) {
        this.expectedSendDatetime = expectedSendDatetime;
    }

    /**
     * 收货要求：预期到货时间
     */
    private Date expectedArrivalDatetime;

    /**
     * 获取收货要求：预期到货时间
     *
     * @return 收货要求：预期到货时间
     */
    public Date getExpectedArrivalDatetime() {
        return this.expectedArrivalDatetime;
    }

    /**
     * 设置收货要求：预期到货时间
     *
     * @param expectedArrivalDatetime
     */
    public void setExpectedArrivalDatetime(Date expectedArrivalDatetime) {
        this.expectedArrivalDatetime = expectedArrivalDatetime;
    }

    /**
     * 状态：配送通知单状态
     */
    private String distributionNotificationStu;

    /**
     * 获取状态：配送通知单状态
     *
     * @return 状态：配送通知单状态
     */
    public String getDistributionNotificationStu() {
        return this.distributionNotificationStu;
    }

    /**
     * 设置状态：配送通知单状态
     *
     * @param distributionNotificationStu
     */
    public void setDistributionNotificationStu(String distributionNotificationStu) {
        this.distributionNotificationStu = distributionNotificationStu;
    }

    /**
     * 状态：通知单是否发送
     */
    private Boolean sendFlg;

    /**
     * 获取状态：通知单是否发送
     *
     * @return 状态：通知单是否发送
     */
    public Boolean getSendFlg() {
        return this.sendFlg;
    }

    /**
     * 设置状态：通知单是否发送
     *
     * @param sendFlg
     */
    public void setSendFlg(Boolean sendFlg) {
        this.sendFlg = sendFlg;
    }

    private String whCode;

    private String whName;

    private String factWhCode;

    private String factWhName;

    private Long whId;

    private Long factWhId;

    public Long getFactWhId() {
        return factWhId;
    }

    public void setFactWhId(Long factWhId) {
        this.factWhId = factWhId;
    }

    public Long getWhId() {
        return whId;
    }

    public void setWhId(Long whId) {
        this.whId = whId;
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public String getFactWhCode() {
        return factWhCode;
    }

    public void setFactWhCode(String factWhCode) {
        this.factWhCode = factWhCode;
    }

    public String getFactWhName() {
        return factWhName;
    }

    public void setFactWhName(String factWhName) {
        this.factWhName = factWhName;
    }

    private Date requiredDistributionDate;

    public Date getRequiredDistributionDate() {
        return requiredDistributionDate;
    }

    public void setRequiredDistributionDate(Date requiredDistributionDate) {
        this.requiredDistributionDate = requiredDistributionDate;
    }
}
