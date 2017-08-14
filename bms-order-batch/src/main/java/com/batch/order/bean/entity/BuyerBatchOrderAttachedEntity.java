package com.batch.order.bean.entity;
import com.framework.base.rest.entity.BaseEntity;

public class BuyerBatchOrderAttachedEntity extends BaseEntity {
private static final long serialVersionUID = 1L;
/** 分批订单：买家分批订单ID */
private Long buyerBatchOrderId;
/**
* 获取分批订单：买家分批订单ID
* @return 分批订单：买家分批订单ID
*/
public Long getBuyerBatchOrderId() {
return this.buyerBatchOrderId;
}
/**
* 设置分批订单：买家分批订单ID
* @param buyerBatchOrderId
*/
public void setBuyerBatchOrderId(Long buyerBatchOrderId) {
this.buyerBatchOrderId=buyerBatchOrderId;
}
/** 收货人：收货人名称 */
private String receiverName;
/**
* 获取收货人：收货人名称
* @return 收货人：收货人名称
*/
public String getReceiverName() {
return this.receiverName;
}
/**
* 设置收货人：收货人名称
* @param receiverName
*/
public void setReceiverName(String receiverName) {
this.receiverName=receiverName;
}
/** 收货人：收货人电话 */
private String receiverPhone;
/**
* 获取收货人：收货人电话
* @return 收货人：收货人电话
*/
public String getReceiverPhone() {
return this.receiverPhone;
}
/**
* 设置收货人：收货人电话
* @param receiverPhone
*/
public void setReceiverPhone(String receiverPhone) {
this.receiverPhone=receiverPhone;
}
/** 收货人：收货人QQ */
private String receiverQq;
/**
* 获取收货人：收货人QQ
* @return 收货人：收货人QQ
*/
public String getReceiverQq() {
return this.receiverQq;
}
/**
* 设置收货人：收货人QQ
* @param receiverQq
*/
public void setReceiverQq(String receiverQq) {
this.receiverQq=receiverQq;
}
/** 收货人：收货人微信 */
private String receiverWechat;
/**
* 获取收货人：收货人微信
* @return 收货人：收货人微信
*/
public String getReceiverWechat() {
return this.receiverWechat;
}
/**
* 设置收货人：收货人微信
* @param receiverWechat
*/
public void setReceiverWechat(String receiverWechat) {
this.receiverWechat=receiverWechat;
}
/** 收货人：收货人邮箱 */
private String receiverMail;
/**
* 获取收货人：收货人邮箱
* @return 收货人：收货人邮箱
*/
public String getReceiverMail() {
return this.receiverMail;
}
/**
* 设置收货人：收货人邮箱
* @param receiverMail
*/
public void setReceiverMail(String receiverMail) {
this.receiverMail=receiverMail;
}
/** 收货地址：收货地址省 */
private String receiverProvince;
/**
* 获取收货地址：收货地址省
* @return 收货地址：收货地址省
*/
public String getReceiverProvince() {
return this.receiverProvince;
}
/**
* 设置收货地址：收货地址省
* @param receiverProvince
*/
public void setReceiverProvince(String receiverProvince) {
this.receiverProvince=receiverProvince;
}
/** 收货地址：收货地址市 */
private String receiverCity;
/**
* 获取收货地址：收货地址市
* @return 收货地址：收货地址市
*/
public String getReceiverCity() {
return this.receiverCity;
}
/**
* 设置收货地址：收货地址市
* @param receiverCity
*/
public void setReceiverCity(String receiverCity) {
this.receiverCity=receiverCity;
}
/** 收货地址：收货地址区 */
private String receiverDistrict;
/**
* 获取收货地址：收货地址区
* @return 收货地址：收货地址区
*/
public String getReceiverDistrict() {
return this.receiverDistrict;
}
/**
* 设置收货地址：收货地址区
* @param receiverDistrict
*/
public void setReceiverDistrict(String receiverDistrict) {
this.receiverDistrict=receiverDistrict;
}
/** 收货地址：收货地址详细地址 */
private String receiverAddress;
/**
* 获取收货地址：收货地址详细地址
* @return 收货地址：收货地址详细地址
*/
public String getReceiverAddress() {
return this.receiverAddress;
}
/**
* 设置收货地址：收货地址详细地址
* @param receiverAddress
*/
public void setReceiverAddress(String receiverAddress) {
this.receiverAddress=receiverAddress;
}
/** 收货地址：辅助地址项目 [收货人详细地址管理Key] */
private String receiverAssistAddress;
/**
* 获取收货地址：辅助地址项目 [收货人详细地址管理Key]
* @return 收货地址：辅助地址项目 [收货人详细地址管理Key]
*/
public String getReceiverAssistAddress() {
return this.receiverAssistAddress;
}
/**
* 设置收货地址：辅助地址项目 [收货人详细地址管理Key]
* @param receiverAssistAddress
*/
public void setReceiverAssistAddress(String receiverAssistAddress) {
this.receiverAssistAddress=receiverAssistAddress;
}
/** 收货地址：订单配送区域 */
private String deliveryArea;
/**
* 获取收货地址：订单配送区域
* @return 收货地址：订单配送区域
*/
public String getDeliveryArea() {
return this.deliveryArea;
}
/**
* 设置收货地址：订单配送区域
* @param deliveryArea
*/
public void setDeliveryArea(String deliveryArea) {
this.deliveryArea=deliveryArea;
}
/** 收货地址：准入通行车型 */
private String passTrafficModel;
/**
* 获取收货地址：准入通行车型
* @return 收货地址：准入通行车型
*/
public String getPassTrafficModel() {
return this.passTrafficModel;
}
/**
* 设置收货地址：准入通行车型
* @param passTrafficModel
*/
public void setPassTrafficModel(String passTrafficModel) {
this.passTrafficModel=passTrafficModel;
}
/** 收货要求：配送方式 [CodeMaster  海陆空  （预留字段，目前都是陆运）] */
private String distributionType;
/**
* 获取收货要求：配送方式 [CodeMaster  海陆空  （预留字段，目前都是陆运）]
* @return 收货要求：配送方式 [CodeMaster  海陆空  （预留字段，目前都是陆运）]
*/
public String getDistributionType() {
return this.distributionType;
}
/**
* 设置收货要求：配送方式 [CodeMaster  海陆空  （预留字段，目前都是陆运）]
* @param distributionType
*/
public void setDistributionType(String distributionType) {
this.distributionType=distributionType;
}
/** 收货要求：收货时间段 [CodeMaster] */
private String receivePeriod;
/**
* 获取收货要求：收货时间段 [CodeMaster]
* @return 收货要求：收货时间段 [CodeMaster]
*/
public String getReceivePeriod() {
return this.receivePeriod;
}
/**
* 设置收货要求：收货时间段 [CodeMaster]
* @param receivePeriod
*/
public void setReceivePeriod(String receivePeriod) {
this.receivePeriod=receivePeriod;
}
/** 收货要求：最早时间要求 */
private String receiveEarliest;
/**
* 获取收货要求：最早时间要求
* @return 收货要求：最早时间要求
*/
public String getReceiveEarliest() {
return this.receiveEarliest;
}
/**
* 设置收货要求：最早时间要求
* @param receiveEarliest
*/
public void setReceiveEarliest(String receiveEarliest) {
this.receiveEarliest=receiveEarliest;
}
/** 收货要求：最晚时间要求 */
private String receiveLatest;
/**
* 获取收货要求：最晚时间要求
* @return 收货要求：最晚时间要求
*/
public String getReceiveLatest() {
return this.receiveLatest;
}
/**
* 设置收货要求：最晚时间要求
* @param receiveLatest
*/
public void setReceiveLatest(String receiveLatest) {
this.receiveLatest=receiveLatest;
}
/** 收货要求：收货等待时间 */
private String receiveWaitHour;
/**
* 获取收货要求：收货等待时间
* @return 收货要求：收货等待时间
*/
public String getReceiveWaitHour() {
return this.receiveWaitHour;
}
/**
* 设置收货要求：收货等待时间
* @param receiveWaitHour
*/
public void setReceiveWaitHour(String receiveWaitHour) {
this.receiveWaitHour=receiveWaitHour;
}
/** 收货要求：提前通知时间 */
private String advancedNotificationHour;
/**
* 获取收货要求：提前通知时间
* @return 收货要求：提前通知时间
*/
public String getAdvancedNotificationHour() {
return this.advancedNotificationHour;
}
/**
* 设置收货要求：提前通知时间
* @param advancedNotificationHour
*/
public void setAdvancedNotificationHour(String advancedNotificationHour) {
this.advancedNotificationHour=advancedNotificationHour;
}
/** 收货要求：动检证要求 */
private Boolean animalQuarantineCertificationFlg;
/**
* 获取收货要求：动检证要求
* @return 收货要求：动检证要求
*/
public Boolean getAnimalQuarantineCertificationFlg() {
return this.animalQuarantineCertificationFlg;
}
/**
* 设置收货要求：动检证要求
* @param animalQuarantineCertificationFlg
*/
public void setAnimalQuarantineCertificationFlg(Boolean animalQuarantineCertificationFlg) {
this.animalQuarantineCertificationFlg=animalQuarantineCertificationFlg;
}
/** 收货要求：装卸要求 */
private String stevedoreRequirement;
/**
* 获取收货要求：装卸要求
* @return 收货要求：装卸要求
*/
public String getStevedoreRequirement() {
return this.stevedoreRequirement;
}
/**
* 设置收货要求：装卸要求
* @param stevedoreRequirement
*/
public void setStevedoreRequirement(String stevedoreRequirement) {
this.stevedoreRequirement=stevedoreRequirement;
}
/** 收货要求：包装要求 */
private String packageRequirement;
/**
* 获取收货要求：包装要求
* @return 收货要求：包装要求
*/
public String getPackageRequirement() {
return this.packageRequirement;
}
/**
* 设置收货要求：包装要求
* @param packageRequirement
*/
public void setPackageRequirement(String packageRequirement) {
this.packageRequirement=packageRequirement;
}
/** 收货要求：距离门店最近停车距离（米） */
private Integer nearestParkingDistance;
/**
* 获取收货要求：距离门店最近停车距离（米）
* @return 收货要求：距离门店最近停车距离（米）
*/
public Integer getNearestParkingDistance() {
return this.nearestParkingDistance;
}
/**
* 设置收货要求：距离门店最近停车距离（米）
* @param nearestParkingDistance
*/
public void setNearestParkingDistance(Integer nearestParkingDistance) {
this.nearestParkingDistance=nearestParkingDistance;
}
/** 收货要求：备注 */
private String remark;
/**
* 获取收货要求：备注
* @return 收货要求：备注
*/
public String getRemark() {
return this.remark;
}
/**
* 设置收货要求：备注
* @param remark
*/
public void setRemark(String remark) {
this.remark=remark;
}
}
