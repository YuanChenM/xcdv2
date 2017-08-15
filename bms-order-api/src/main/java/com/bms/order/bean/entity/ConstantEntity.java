package com.bms.order.bean.entity;
import com.framework.base.rest.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;
public class ConstantEntity extends BaseEntity {
private static final long serialVersionUID = 1L;
/** 顺序号ID [顺序号ID] */
private Long id;
/**
* 获取顺序号ID [顺序号ID]
* @return 顺序号ID [顺序号ID]
*/
public Long getId() {
return this.id;
}
/**
* 设置顺序号ID [顺序号ID]
* @param id
*/
public void setId(Long id) {
this.id=id;
}
/** 常量类型 [常量类型] */
private String constantType;
/**
* 获取常量类型 [常量类型]
* @return 常量类型 [常量类型]
*/
public String getConstantType() {
return this.constantType;
}
/**
* 设置常量类型 [常量类型]
* @param constantType
*/
public void setConstantType(String constantType) {
this.constantType=constantType;
}
/** 常量值名称 [常量值名称] */
private String constantName;
/**
* 获取常量值名称 [常量值名称]
* @return 常量值名称 [常量值名称]
*/
public String getConstantName() {
return this.constantName;
}
/**
* 设置常量值名称 [常量值名称]
* @param constantName
*/
public void setConstantName(String constantName) {
this.constantName=constantName;
}
/** 常量值 [常量值] */
private String constantValue;
/**
* 获取常量值 [常量值]
* @return 常量值 [常量值]
*/
public String getConstantValue() {
return this.constantValue;
}
/**
* 设置常量值 [常量值]
* @param constantValue
*/
public void setConstantValue(String constantValue) {
this.constantValue=constantValue;
}
/** 生效者ID [生效者ID] */
private String actId;
/**
* 获取生效者ID [生效者ID]
* @return 生效者ID [生效者ID]
*/
public String getActId() {
return this.actId;
}
/**
* 设置生效者ID [生效者ID]
* @param actId
*/
public void setActId(String actId) {
this.actId=actId;
}
/** 生效日时 [生效日时] */
private Date actTime;
/**
* 获取生效日时 [生效日时]
* @return 生效日时 [生效日时]
*/
public Date getActTime() {
return this.actTime;
}
/**
* 设置生效日时 [生效日时]
* @param actTime
*/
public void setActTime(Date actTime) {
this.actTime=actTime;
}
/** 版本号 [版本号] */
private Integer ver;
/**
* 获取版本号 [版本号]
* @return 版本号 [版本号]
*/
public Integer getVer() {
return this.ver;
}
/**
* 设置版本号 [版本号]
* @param ver
*/
public void setVer(Integer ver) {
this.ver=ver;
}
}
