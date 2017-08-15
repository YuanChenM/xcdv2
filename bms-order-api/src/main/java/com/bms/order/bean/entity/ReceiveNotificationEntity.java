package com.bms.order.bean.entity;
import com.framework.base.rest.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;
public class ReceiveNotificationEntity extends BaseEntity {
private static final long serialVersionUID = 1L;
/** 通知：收货通知单ID */
private Long receiveNotificationId;
/**
* 获取通知：收货通知单ID
* @return 通知：收货通知单ID
*/
public Long getReceiveNotificationId() {
return this.receiveNotificationId;
}
/**
* 设置通知：收货通知单ID
* @param receiveNotificationId
*/
public void setReceiveNotificationId(Long receiveNotificationId) {
this.receiveNotificationId=receiveNotificationId;
}
/** 通知：发货通知单号 [美迪福传过来的唯一编号] */
private String sendNotificationCode;
/**
* 获取通知：发货通知单号 [美迪福传过来的唯一编号]
* @return 通知：发货通知单号 [美迪福传过来的唯一编号]
*/
public String getSendNotificationCode() {
return this.sendNotificationCode;
}
/**
* 设置通知：发货通知单号 [美迪福传过来的唯一编号]
* @param sendNotificationCode
*/
public void setSendNotificationCode(String sendNotificationCode) {
this.sendNotificationCode=sendNotificationCode;
}
/** 通知：发货单通知ID */
private Long sendNotificationId;
/**
* 获取通知：发货单通知ID
* @return 通知：发货单通知ID
*/
public Long getSendNotificationId() {
return this.sendNotificationId;
}
/**
* 设置通知：发货单通知ID
* @param sendNotificationId
*/
public void setSendNotificationId(Long sendNotificationId) {
this.sendNotificationId=sendNotificationId;
}
/** 通知：配送单ID */
private Long distributionNotificationId;
/**
* 获取通知：配送单ID
* @return 通知：配送单ID
*/
public Long getDistributionNotificationId() {
return this.distributionNotificationId;
}
/**
* 设置通知：配送单ID
* @param distributionNotificationId
*/
public void setDistributionNotificationId(Long distributionNotificationId) {
this.distributionNotificationId=distributionNotificationId;
}
/** 通知：配送单号 */
private String distributionNotificationCode;
/**
* 获取通知：配送单号
* @return 通知：配送单号
*/
public String getDistributionNotificationCode() {
return this.distributionNotificationCode;
}
/**
* 设置通知：配送单号
* @param distributionNotificationCode
*/
public void setDistributionNotificationCode(String distributionNotificationCode) {
this.distributionNotificationCode=distributionNotificationCode;
}
/** 支付：支付金额 [支付金额] */
private BigDecimal paymentMoney;
/**
* 获取支付：支付金额 [支付金额]
* @return 支付：支付金额 [支付金额]
*/
public BigDecimal getPaymentMoney() {
return this.paymentMoney;
}
/**
* 设置支付：支付金额 [支付金额]
* @param paymentMoney
*/
public void setPaymentMoney(BigDecimal paymentMoney) {
this.paymentMoney=paymentMoney;
}
/** 收货：签收人 */
private String signatory;
/**
* 获取收货：签收人
* @return 收货：签收人
*/
public String getSignatory() {
return this.signatory;
}
/**
* 设置收货：签收人
* @param signatory
*/
public void setSignatory(String signatory) {
this.signatory=signatory;
}
/** 收货：签收时间 */
private Date receiveTime;
/**
* 获取收货：签收时间
* @return 收货：签收时间
*/
public Date getReceiveTime() {
return this.receiveTime;
}
/**
* 设置收货：签收时间
* @param receiveTime
*/
public void setReceiveTime(Date receiveTime) {
this.receiveTime=receiveTime;
}
/** 收货：签收备注 */
private String receiveRemark;
/**
* 获取收货：签收备注
* @return 收货：签收备注
*/
public String getReceiveRemark() {
return this.receiveRemark;
}
/**
* 设置收货：签收备注
* @param receiveRemark
*/
public void setReceiveRemark(String receiveRemark) {
this.receiveRemark=receiveRemark;
}
}
