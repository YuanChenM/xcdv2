package com.bms.order.bean.entity;
import com.framework.base.rest.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;
public class SendNotificationEntity extends BaseEntity {
private static final long serialVersionUID = 1L;
/** 通知：发货通知单ID */
private Long sendNotificationId;
/**
* 获取通知：发货通知单ID
* @return 通知：发货通知单ID
*/
public Long getSendNotificationId() {
return this.sendNotificationId;
}
/**
* 设置通知：发货通知单ID
* @param sendNotificationId
*/
public void setSendNotificationId(Long sendNotificationId) {
this.sendNotificationId=sendNotificationId;
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
/** 配送人：配送人姓名 */
private String distributionPersonName;
/**
* 获取配送人：配送人姓名
* @return 配送人：配送人姓名
*/
public String getDistributionPersonName() {
return this.distributionPersonName;
}
/**
* 设置配送人：配送人姓名
* @param distributionPersonName
*/
public void setDistributionPersonName(String distributionPersonName) {
this.distributionPersonName=distributionPersonName;
}
/** 配送人：配送人电话 */
private String distributionPersonPhone;
/**
* 获取配送人：配送人电话
* @return 配送人：配送人电话
*/
public String getDistributionPersonPhone() {
return this.distributionPersonPhone;
}
/**
* 设置配送人：配送人电话
* @param distributionPersonPhone
*/
public void setDistributionPersonPhone(String distributionPersonPhone) {
this.distributionPersonPhone=distributionPersonPhone;
}
/** 配送：配送方式 */
private String distributionType;
/**
* 获取配送：配送方式
* @return 配送：配送方式
*/
public String getDistributionType() {
return this.distributionType;
}
/**
* 设置配送：配送方式
* @param distributionType
*/
public void setDistributionType(String distributionType) {
this.distributionType=distributionType;
}
/** 配送：配送车辆 [配送工具，暂无法获取，页面不显示] */
private String distributionVehicle;
/**
* 获取配送：配送车辆 [配送工具，暂无法获取，页面不显示]
* @return 配送：配送车辆 [配送工具，暂无法获取，页面不显示]
*/
public String getDistributionVehicle() {
return this.distributionVehicle;
}
/**
* 设置配送：配送车辆 [配送工具，暂无法获取，页面不显示]
* @param distributionVehicle
*/
public void setDistributionVehicle(String distributionVehicle) {
this.distributionVehicle=distributionVehicle;
}
/** 配送：实际发车时间 */
private Date realDepartDatetime;
/**
* 获取配送：实际发车时间
* @return 配送：实际发车时间
*/
public Date getRealDepartDatetime() {
return this.realDepartDatetime;
}
/**
* 设置配送：实际发车时间
* @param realDepartDatetime
*/
public void setRealDepartDatetime(Date realDepartDatetime) {
this.realDepartDatetime=realDepartDatetime;
}
/** 配送：预计到达时间 */
private Date expectedArrivalDatetime;
/**
* 获取配送：预计到达时间
* @return 配送：预计到达时间
*/
public Date getExpectedArrivalDatetime() {
return this.expectedArrivalDatetime;
}
/**
* 设置配送：预计到达时间
* @param expectedArrivalDatetime
*/
public void setExpectedArrivalDatetime(Date expectedArrivalDatetime) {
this.expectedArrivalDatetime=expectedArrivalDatetime;
}
/** 发货通知：备注 */
private String remarks;
/**
* 获取发货通知：备注
* @return 发货通知：备注
*/
public String getRemarks() {
return this.remarks;
}
/**
* 设置发货通知：备注
* @param remarks
*/
public void setRemarks(String remarks) {
this.remarks=remarks;
}
}
