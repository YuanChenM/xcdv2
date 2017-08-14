package com.batch.order.bean.entity;
import com.framework.base.rest.entity.BaseEntity;

public class BsOrderAttachedEntity extends BaseEntity {
private static final long serialVersionUID = 1L;
/** 订单：买手订单ID */
private Long bsOrderId;
/**
* 获取订单：买手订单ID
* @return 订单：买手订单ID
*/
public Long getBsOrderId() {
return this.bsOrderId;
}
/**
* 设置订单：买手订单ID
* @param bsOrderId
*/
public void setBsOrderId(Long bsOrderId) {
this.bsOrderId=bsOrderId;
}
/** 下单：下单员编码 [【需要和买家 买手 管家 平台订单人员 确认】] */
private String orderPlacerCode;
/**
* 获取下单：下单员编码 [【需要和买家 买手 管家 平台订单人员 确认】]
* @return 下单：下单员编码 [【需要和买家 买手 管家 平台订单人员 确认】]
*/
public String getOrderPlacerCode() {
return this.orderPlacerCode;
}
/**
* 设置下单：下单员编码 [【需要和买家 买手 管家 平台订单人员 确认】]
* @param orderPlacerCode
*/
public void setOrderPlacerCode(String orderPlacerCode) {
this.orderPlacerCode=orderPlacerCode;
}
/** 下单：下单员名称 [【需要和买家 买手 管家 订单人员确认】] */
private String orderPlacerName;
/**
* 获取下单：下单员名称 [【需要和买家 买手 管家 订单人员确认】]
* @return 下单：下单员名称 [【需要和买家 买手 管家 订单人员确认】]
*/
public String getOrderPlacerName() {
return this.orderPlacerName;
}
/**
* 设置下单：下单员名称 [【需要和买家 买手 管家 订单人员确认】]
* @param orderPlacerName
*/
public void setOrderPlacerName(String orderPlacerName) {
this.orderPlacerName=orderPlacerName;
}
/** 区域：物流区编码 [【类型待定】] */
private String logisticsZoneCode;
/**
* 获取区域：物流区编码 [【类型待定】]
* @return 区域：物流区编码 [【类型待定】]
*/
public String getLogisticsZoneCode() {
return this.logisticsZoneCode;
}
/**
* 设置区域：物流区编码 [【类型待定】]
* @param logisticsZoneCode
*/
public void setLogisticsZoneCode(String logisticsZoneCode) {
this.logisticsZoneCode=logisticsZoneCode;
}
/** 区域：物流区名称 [【类型待定】] */
private String logisticsZoneName;
/**
* 获取区域：物流区名称 [【类型待定】]
* @return 区域：物流区名称 [【类型待定】]
*/
public String getLogisticsZoneName() {
return this.logisticsZoneName;
}
/**
* 设置区域：物流区名称 [【类型待定】]
* @param logisticsZoneName
*/
public void setLogisticsZoneName(String logisticsZoneName) {
this.logisticsZoneName=logisticsZoneName;
}
/** 区域：区县ID */
private Long countryId;
/**
* 获取区域：区县ID
* @return 区域：区县ID
*/
public Long getCountryId() {
return this.countryId;
}
/**
* 设置区域：区县ID
* @param countryId
*/
public void setCountryId(Long countryId) {
this.countryId=countryId;
}
/** 区域：区县编码 */
private String countryCode;
/**
* 获取区域：区县编码
* @return 区域：区县编码
*/
public String getCountryCode() {
return this.countryCode;
}
/**
* 设置区域：区县编码
* @param countryCode
*/
public void setCountryCode(String countryCode) {
this.countryCode=countryCode;
}
/** 区域：区县名称 [【类型待定】] */
private String countryName;
/**
* 获取区域：区县名称 [【类型待定】]
* @return 区域：区县名称 [【类型待定】]
*/
public String getCountryName() {
return this.countryName;
}
/**
* 设置区域：区县名称 [【类型待定】]
* @param countryName
*/
public void setCountryName(String countryName) {
this.countryName=countryName;
}
/** 区域：城市ID */
private Long cityId;
/**
* 获取区域：城市ID
* @return 区域：城市ID
*/
public Long getCityId() {
return this.cityId;
}
/**
* 设置区域：城市ID
* @param cityId
*/
public void setCityId(Long cityId) {
this.cityId=cityId;
}
/** 区域：城市编码 */
private String cityCode;
/**
* 获取区域：城市编码
* @return 区域：城市编码
*/
public String getCityCode() {
return this.cityCode;
}
/**
* 设置区域：城市编码
* @param cityCode
*/
public void setCityCode(String cityCode) {
this.cityCode=cityCode;
}
/** 区域：城市名称 [【类型待定】] */
private String cityName;
/**
* 获取区域：城市名称 [【类型待定】]
* @return 区域：城市名称 [【类型待定】]
*/
public String getCityName() {
return this.cityName;
}
/**
* 设置区域：城市名称 [【类型待定】]
* @param cityName
*/
public void setCityName(String cityName) {
this.cityName=cityName;
}
/** 买手：买手编码 [【需要和买手确认】] */
private String bsCode;
/**
* 获取买手：买手编码 [【需要和买手确认】]
* @return 买手：买手编码 [【需要和买手确认】]
*/
public String getBsCode() {
return this.bsCode;
}
/**
* 设置买手：买手编码 [【需要和买手确认】]
* @param bsCode
*/
public void setBsCode(String bsCode) {
this.bsCode=bsCode;
}
/** 买手：买手名称 [【需要和买手确认】] */
private String bsName;
/**
* 获取买手：买手名称 [【需要和买手确认】]
* @return 买手：买手名称 [【需要和买手确认】]
*/
public String getBsName() {
return this.bsName;
}
/**
* 设置买手：买手名称 [【需要和买手确认】]
* @param bsName
*/
public void setBsName(String bsName) {
this.bsName=bsName;
}
/** 买手：买手类型 */
private String bsType;
/**
* 获取买手：买手类型
* @return 买手：买手类型
*/
public String getBsType() {
return this.bsType;
}
/**
* 设置买手：买手类型
* @param bsType
*/
public void setBsType(String bsType) {
this.bsType=bsType;
}
}
