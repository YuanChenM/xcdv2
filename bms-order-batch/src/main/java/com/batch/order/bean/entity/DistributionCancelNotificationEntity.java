package com.batch.order.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

import java.util.Date;

public class DistributionCancelNotificationEntity extends BaseEntity {
private static final long serialVersionUID = 1L;
/** 通知：配送取消通知单ID */
private Long distributionCancelNotificationId;
/**
* 获取通知：配送取消通知单ID
* @return 通知：配送取消通知单ID
*/
public Long getDistributionCancelNotificationId() {
return this.distributionCancelNotificationId;
}
/**
* 设置通知：配送取消通知单ID
* @param distributionCancelNotificationId
*/
public void setDistributionCancelNotificationId(Long distributionCancelNotificationId) {
this.distributionCancelNotificationId=distributionCancelNotificationId;
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
/** 取消：取消类型 */
private String cancelType;
/**
* 获取取消：取消类型
* @return 取消：取消类型
*/
public String getCancelType() {
return this.cancelType;
}
/**
* 设置取消：取消类型
* @param cancelType
*/
public void setCancelType(String cancelType) {
this.cancelType=cancelType;
}
/** 取消：取消原因 */
private String cancelReason;
/**
* 获取取消：取消原因
* @return 取消：取消原因
*/
public String getCancelReason() {
return this.cancelReason;
}
/**
* 设置取消：取消原因
* @param cancelReason
*/
public void setCancelReason(String cancelReason) {
this.cancelReason=cancelReason;
}
/** 取消：取消人ID */
private String cancelPersonId;
/**
* 获取取消：取消人ID
* @return 取消：取消人ID
*/
public String getCancelPersonId() {
return this.cancelPersonId;
}
/**
* 设置取消：取消人ID
* @param cancelPersonId
*/
public void setCancelPersonId(String cancelPersonId) {
this.cancelPersonId=cancelPersonId;
}
/** 取消：取消人名称 */
private String cancelPersonName;
/**
* 获取取消：取消人名称
* @return 取消：取消人名称
*/
public String getCancelPersonName() {
return this.cancelPersonName;
}
/**
* 设置取消：取消人名称
* @param cancelPersonName
*/
public void setCancelPersonName(String cancelPersonName) {
this.cancelPersonName=cancelPersonName;
}
/** 取消：取消人类型 [CodeMaster] */
private String cancelPersonType;
/**
* 获取取消：取消人类型 [CodeMaster]
* @return 取消：取消人类型 [CodeMaster]
*/
public String getCancelPersonType() {
return this.cancelPersonType;
}
/**
* 设置取消：取消人类型 [CodeMaster]
* @param cancelPersonType
*/
public void setCancelPersonType(String cancelPersonType) {
this.cancelPersonType=cancelPersonType;
}
/** 取消：取消时间 */
private Date cancelDatetime;
/**
* 获取取消：取消时间
* @return 取消：取消时间
*/
public Date getCancelDatetime() {
return this.cancelDatetime;
}
/**
* 设置取消：取消时间
* @param cancelDatetime
*/
public void setCancelDatetime(Date cancelDatetime) {
this.cancelDatetime=cancelDatetime;
}
/** 取消：实际取消时间 [由美迪福回传] */
private Date wmsCancelDatetime;
/**
* 获取取消：实际取消时间 [由美迪福回传]
* @return 取消：实际取消时间 [由美迪福回传]
*/
public Date getWmsCancelDatetime() {
return this.wmsCancelDatetime;
}
/**
* 设置取消：实际取消时间 [由美迪福回传]
* @param wmsCancelDatetime
*/
public void setWmsCancelDatetime(Date wmsCancelDatetime) {
this.wmsCancelDatetime=wmsCancelDatetime;
}
/** 状态：通知单是否发送 */
private Boolean sendFlg;
/**
* 获取状态：通知单是否发送
* @return 状态：通知单是否发送
*/
public Boolean getSendFlg() {
return this.sendFlg;
}
/**
* 设置状态：通知单是否发送
* @param sendFlg
*/
public void setSendFlg(Boolean sendFlg) {
this.sendFlg=sendFlg;
}
/** 结果：是否取消成功 */
private Boolean successFlg;
/**
* 获取结果：是否取消成功
* @return 结果：是否取消成功
*/
public Boolean getSuccessFlg() {
return this.successFlg;
}
/**
* 设置结果：是否取消成功
* @param successFlg
*/
public void setSuccessFlg(Boolean successFlg) {
this.successFlg=successFlg;
}
/** 取消：备注 */
private String remark;
/**
* 获取取消：备注
* @return 取消：备注
*/
public String getRemark() {
return this.remark;
}
/**
* 设置取消：备注
* @param remark
*/
public void setRemark(String remark) {
this.remark=remark;
}
}
