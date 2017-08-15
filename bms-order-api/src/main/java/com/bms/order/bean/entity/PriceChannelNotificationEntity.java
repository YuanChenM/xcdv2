package com.bms.order.bean.entity;
import com.framework.base.rest.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;
public class PriceChannelNotificationEntity extends BaseEntity {
private static final long serialVersionUID = 1L;
/** 通知单：价格通道通知单ID */
private Long priceChannelNotificationId;
/**
* 获取通知单：价格通道通知单ID
* @return 通知单：价格通道通知单ID
*/
public Long getPriceChannelNotificationId() {
return this.priceChannelNotificationId;
}
/**
* 设置通知单：价格通道通知单ID
* @param priceChannelNotificationId
*/
public void setPriceChannelNotificationId(Long priceChannelNotificationId) {
this.priceChannelNotificationId=priceChannelNotificationId;
}
/** 通知单：价格通道通知单号 */
private String priceChannelNotificationCode;
/**
* 获取通知单：价格通道通知单号
* @return 通知单：价格通道通知单号
*/
public String getPriceChannelNotificationCode() {
return this.priceChannelNotificationCode;
}
/**
* 设置通知单：价格通道通知单号
* @param priceChannelNotificationCode
*/
public void setPriceChannelNotificationCode(String priceChannelNotificationCode) {
this.priceChannelNotificationCode=priceChannelNotificationCode;
}
/** 通知单：买家订单ID */
private Long buyerOrderId;
/**
* 获取通知单：买家订单ID
* @return 通知单：买家订单ID
*/
public Long getBuyerOrderId() {
return this.buyerOrderId;
}
/**
* 设置通知单：买家订单ID
* @param buyerOrderId
*/
public void setBuyerOrderId(Long buyerOrderId) {
this.buyerOrderId=buyerOrderId;
}
/** 通知单：买家订单编码 */
private String buyerOrderCode;
/**
* 获取通知单：买家订单编码
* @return 通知单：买家订单编码
*/
public String getBuyerOrderCode() {
return this.buyerOrderCode;
}
/**
* 设置通知单：买家订单编码
* @param buyerOrderCode
*/
public void setBuyerOrderCode(String buyerOrderCode) {
this.buyerOrderCode=buyerOrderCode;
}
/** 状态：通知单发送状态 */
private Boolean sendFlg;
/**
* 获取状态：通知单发送状态
* @return 状态：通知单发送状态
*/
public Boolean getSendFlg() {
return this.sendFlg;
}
/**
* 设置状态：通知单发送状态
* @param sendFlg
*/
public void setSendFlg(Boolean sendFlg) {
this.sendFlg=sendFlg;
}
}
