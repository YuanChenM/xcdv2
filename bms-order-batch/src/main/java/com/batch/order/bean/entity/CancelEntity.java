package com.batch.order.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

import java.util.Date;

public class CancelEntity extends BaseEntity {
private static final long serialVersionUID = 1L;
/** 取消：取消ID */
private Long cancelId;
/**
* 获取取消：取消ID
* @return 取消：取消ID
*/
public Long getCancelId() {
return this.cancelId;
}
/**
* 设置取消：取消ID
* @param cancelId
*/
public void setCancelId(Long cancelId) {
this.cancelId=cancelId;
}
/** 取消：取消对象类型 [取消来源和种类（订单/分批订单/分批订单明细/分拆单明细等）] */
private String cancelModelType;
/**
* 获取取消：取消对象类型 [取消来源和种类（订单/分批订单/分批订单明细/分拆单明细等）]
* @return 取消：取消对象类型 [取消来源和种类（订单/分批订单/分批订单明细/分拆单明细等）]
*/
public String getCancelModelType() {
return this.cancelModelType;
}
/**
* 设置取消：取消对象类型 [取消来源和种类（订单/分批订单/分批订单明细/分拆单明细等）]
* @param cancelModelType
*/
public void setCancelModelType(String cancelModelType) {
this.cancelModelType=cancelModelType;
}
/** 取消：取消对象ID [对应表的主键ID] */
private Long cancelModelId;
/**
* 获取取消：取消对象ID [对应表的主键ID]
* @return 取消：取消对象ID [对应表的主键ID]
*/
public Long getCancelModelId() {
return this.cancelModelId;
}
/**
* 设置取消：取消对象ID [对应表的主键ID]
* @param cancelModelId
*/
public void setCancelModelId(Long cancelModelId) {
this.cancelModelId=cancelModelId;
}
/** 取消：取消模式 [全部取消/部分取消] */
private String cancelType;
/**
* 获取取消：取消模式 [全部取消/部分取消]
* @return 取消：取消模式 [全部取消/部分取消]
*/
public String getCancelType() {
return this.cancelType;
}
/**
* 设置取消：取消模式 [全部取消/部分取消]
* @param cancelType
*/
public void setCancelType(String cancelType) {
this.cancelType=cancelType;
}
/** 取消：取消人类型 */
private String cancelPersonType;
/**
* 获取取消：取消人类型
* @return 取消：取消人类型
*/
public String getCancelPersonType() {
return this.cancelPersonType;
}
/**
* 设置取消：取消人类型
* @param cancelPersonType
*/
public void setCancelPersonType(String cancelPersonType) {
this.cancelPersonType=cancelPersonType;
}
/** 取消：取消人ID */
private Long cancelPersonId;
/**
* 获取取消：取消人ID
* @return 取消：取消人ID
*/
public Long getCancelPersonId() {
return this.cancelPersonId;
}
/**
* 设置取消：取消人ID
* @param cancelPersonId
*/
public void setCancelPersonId(Long cancelPersonId) {
this.cancelPersonId=cancelPersonId;
}
/** 取消：取消人编码 [【需要与买家 买手 管家 平台人员确认】] */
private String cancelPersonCode;
/**
* 获取取消：取消人编码 [【需要与买家 买手 管家 平台人员确认】]
* @return 取消：取消人编码 [【需要与买家 买手 管家 平台人员确认】]
*/
public String getCancelPersonCode() {
return this.cancelPersonCode;
}
/**
* 设置取消：取消人编码 [【需要与买家 买手 管家 平台人员确认】]
* @param cancelPersonCode
*/
public void setCancelPersonCode(String cancelPersonCode) {
this.cancelPersonCode=cancelPersonCode;
}
/** 取消：取消人名称 [【需要与买家 买手 管家 平台人员确认】] */
private String cancelPersonName;
/**
* 获取取消：取消人名称 [【需要与买家 买手 管家 平台人员确认】]
* @return 取消：取消人名称 [【需要与买家 买手 管家 平台人员确认】]
*/
public String getCancelPersonName() {
return this.cancelPersonName;
}
/**
* 设置取消：取消人名称 [【需要与买家 买手 管家 平台人员确认】]
* @param cancelPersonName
*/
public void setCancelPersonName(String cancelPersonName) {
this.cancelPersonName=cancelPersonName;
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
}
