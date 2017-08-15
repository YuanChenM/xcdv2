package com.bms.order.bean.entity;
import com.framework.base.rest.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;
public class BsVirtualPerformEntity extends BaseEntity {
private static final long serialVersionUID = 1L;
/** 行权ID [行权ID] */
private Long performId;
/**
* 获取行权ID [行权ID]
* @return 行权ID [行权ID]
*/
public Long getPerformId() {
return this.performId;
}
/**
* 设置行权ID [行权ID]
* @param performId
*/
public void setPerformId(Long performId) {
this.performId=performId;
}
/** 行权单号 [行权单号] */
private String performCode;
/**
* 获取行权单号 [行权单号]
* @return 行权单号 [行权单号]
*/
public String getPerformCode() {
return this.performCode;
}
/**
* 设置行权单号 [行权单号]
* @param performCode
*/
public void setPerformCode(String performCode) {
this.performCode=performCode;
}
/** 行权时间 [行权时间] */
private Date performTime;
/**
* 获取行权时间 [行权时间]
* @return 行权时间 [行权时间]
*/
public Date getPerformTime() {
return this.performTime;
}
/**
* 设置行权时间 [行权时间]
* @param performTime
*/
public void setPerformTime(Date performTime) {
this.performTime=performTime;
}
/** 行权方ID [行权方ID，买手/合伙人ID] */
private String performerId;
/**
* 获取行权方ID [行权方ID，买手/合伙人ID]
* @return 行权方ID [行权方ID，买手/合伙人ID]
*/
public String getPerformerId() {
return this.performerId;
}
/**
* 设置行权方ID [行权方ID，买手/合伙人ID]
* @param performerId
*/
public void setPerformerId(String performerId) {
this.performerId=performerId;
}
/** 行权方编码 [行权方编码，买手/合伙人编码] */
private String performerCode;
/**
* 获取行权方编码 [行权方编码，买手/合伙人编码]
* @return 行权方编码 [行权方编码，买手/合伙人编码]
*/
public String getPerformerCode() {
return this.performerCode;
}
/**
* 设置行权方编码 [行权方编码，买手/合伙人编码]
* @param performerCode
*/
public void setPerformerCode(String performerCode) {
this.performerCode=performerCode;
}
/** 行权单状态 [行权单状态] */
private String performStu;
/**
* 获取行权单状态 [行权单状态]
* @return 行权单状态 [行权单状态]
*/
public String getPerformStu() {
return this.performStu;
}
/**
* 设置行权单状态 [行权单状态]
* @param performStu
*/
public void setPerformStu(String performStu) {
this.performStu=performStu;
}
}
