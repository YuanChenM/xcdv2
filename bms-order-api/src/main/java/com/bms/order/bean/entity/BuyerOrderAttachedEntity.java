package com.bms.order.bean.entity;
import com.framework.base.rest.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;
public class BuyerOrderAttachedEntity extends BaseEntity {
private static final long serialVersionUID = 1L;
/** 订单：买家订单ID */
private Long buyerOrderId;
/**
* 获取订单：买家订单ID
* @return 订单：买家订单ID
*/
public Long getBuyerOrderId() {
return this.buyerOrderId;
}
/**
* 设置订单：买家订单ID
* @param buyerOrderId
*/
public void setBuyerOrderId(Long buyerOrderId) {
this.buyerOrderId=buyerOrderId;
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
/** 区域：物流区编码 */
private String logisticsZoneCode;
/**
* 获取区域：物流区编码
* @return 区域：物流区编码
*/
public String getLogisticsZoneCode() {
return this.logisticsZoneCode;
}
/**
* 设置区域：物流区编码
* @param logisticsZoneCode
*/
public void setLogisticsZoneCode(String logisticsZoneCode) {
this.logisticsZoneCode=logisticsZoneCode;
}
/** 区域：物流区名称 */
private String logisticsZoneName;
/**
* 获取区域：物流区名称
* @return 区域：物流区名称
*/
public String getLogisticsZoneName() {
return this.logisticsZoneName;
}
/**
* 设置区域：物流区名称
* @param logisticsZoneName
*/
public void setLogisticsZoneName(String logisticsZoneName) {
this.logisticsZoneName=logisticsZoneName;
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
/** 区域：城市名称 */
private String cityName;
/**
* 获取区域：城市名称
* @return 区域：城市名称
*/
public String getCityName() {
return this.cityName;
}
/**
* 设置区域：城市名称
* @param cityName
*/
public void setCityName(String cityName) {
this.cityName=cityName;
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
/** 区域：区县名称 */
private String countryName;
/**
* 获取区域：区县名称
* @return 区域：区县名称
*/
public String getCountryName() {
return this.countryName;
}
/**
* 设置区域：区县名称
* @param countryName
*/
public void setCountryName(String countryName) {
this.countryName=countryName;
}
/** 区域：区域配送站ID */
private Long regionalDistributionStation;
/**
* 获取区域：区域配送站ID
* @return 区域：区域配送站ID
*/
public Long getRegionalDistributionStation() {
return this.regionalDistributionStation;
}
/**
* 设置区域：区域配送站ID
* @param regionalDistributionStation
*/
public void setRegionalDistributionStation(Long regionalDistributionStation) {
this.regionalDistributionStation=regionalDistributionStation;
}
/** 区域：区域配送站编码 */
private String regionalDistributionStationCode;
/**
* 获取区域：区域配送站编码
* @return 区域：区域配送站编码
*/
public String getRegionalDistributionStationCode() {
return this.regionalDistributionStationCode;
}
/**
* 设置区域：区域配送站编码
* @param regionalDistributionStationCode
*/
public void setRegionalDistributionStationCode(String regionalDistributionStationCode) {
this.regionalDistributionStationCode=regionalDistributionStationCode;
}
/** 区域：区域配送站名称 */
private String regionalDistributionStationName;
/**
* 获取区域：区域配送站名称
* @return 区域：区域配送站名称
*/
public String getRegionalDistributionStationName() {
return this.regionalDistributionStationName;
}
/**
* 设置区域：区域配送站名称
* @param regionalDistributionStationName
*/
public void setRegionalDistributionStationName(String regionalDistributionStationName) {
this.regionalDistributionStationName=regionalDistributionStationName;
}
/** 买家：买家编码 */
private String buyerCode;
/**
* 获取买家：买家编码
* @return 买家：买家编码
*/
public String getBuyerCode() {
return this.buyerCode;
}
/**
* 设置买家：买家编码
* @param buyerCode
*/
public void setBuyerCode(String buyerCode) {
this.buyerCode=buyerCode;
}
/** 买家：买家名称 */
private String buyerName;
/**
* 获取买家：买家名称
* @return 买家：买家名称
*/
public String getBuyerName() {
return this.buyerName;
}
/**
* 设置买家：买家名称
* @param buyerName
*/
public void setBuyerName(String buyerName) {
this.buyerName=buyerName;
}
/** 买家：买家联系电话 */
private String buyerPhone;
/**
* 获取买家：买家联系电话
* @return 买家：买家联系电话
*/
public String getBuyerPhone() {
return this.buyerPhone;
}
/**
* 设置买家：买家联系电话
* @param buyerPhone
*/
public void setBuyerPhone(String buyerPhone) {
this.buyerPhone=buyerPhone;
}
/** 买家：买家微信号 */
private String buyerWechat;
/**
* 获取买家：买家微信号
* @return 买家：买家微信号
*/
public String getBuyerWechat() {
return this.buyerWechat;
}
/**
* 设置买家：买家微信号
* @param buyerWechat
*/
public void setBuyerWechat(String buyerWechat) {
this.buyerWechat=buyerWechat;
}
/** 买家：买家QQ */
private String buyerQq;
/**
* 获取买家：买家QQ
* @return 买家：买家QQ
*/
public String getBuyerQq() {
return this.buyerQq;
}
/**
* 设置买家：买家QQ
* @param buyerQq
*/
public void setBuyerQq(String buyerQq) {
this.buyerQq=buyerQq;
}
/** 买家：买家邮箱 */
private String buyerMail;
/**
* 获取买家：买家邮箱
* @return 买家：买家邮箱
*/
public String getBuyerMail() {
return this.buyerMail;
}
/**
* 设置买家：买家邮箱
* @param buyerMail
*/
public void setBuyerMail(String buyerMail) {
this.buyerMail=buyerMail;
}
/** 买家：区域买手ID [【需要和买手确认】] */
private String regionalBsId;
/**
* 获取买家：区域买手ID [【需要和买手确认】]
* @return 买家：区域买手ID [【需要和买手确认】]
*/
public String getRegionalBsId() {
return this.regionalBsId;
}
/**
* 设置买家：区域买手ID [【需要和买手确认】]
* @param regionalBsId
*/
public void setRegionalBsId(String regionalBsId) {
this.regionalBsId=regionalBsId;
}
/** 买家：区域买手编码 [【需要和买手确认】] */
private String regionalBsCode;
/**
* 获取买家：区域买手编码 [【需要和买手确认】]
* @return 买家：区域买手编码 [【需要和买手确认】]
*/
public String getRegionalBsCode() {
return this.regionalBsCode;
}
/**
* 设置买家：区域买手编码 [【需要和买手确认】]
* @param regionalBsCode
*/
public void setRegionalBsCode(String regionalBsCode) {
this.regionalBsCode=regionalBsCode;
}
/** 买家：区域买手名称 [【需要和买手确认】] */
private String regionalBsName;
/**
* 获取买家：区域买手名称 [【需要和买手确认】]
* @return 买家：区域买手名称 [【需要和买手确认】]
*/
public String getRegionalBsName() {
return this.regionalBsName;
}
/**
* 设置买家：区域买手名称 [【需要和买手确认】]
* @param regionalBsName
*/
public void setRegionalBsName(String regionalBsName) {
this.regionalBsName=regionalBsName;
}
/** 买家：非区域买手ID [【需要和买手确认】] */
private String nonRegionalBsId;
/**
* 获取买家：非区域买手ID [【需要和买手确认】]
* @return 买家：非区域买手ID [【需要和买手确认】]
*/
public String getNonRegionalBsId() {
return this.nonRegionalBsId;
}
/**
* 设置买家：非区域买手ID [【需要和买手确认】]
* @param nonRegionalBsId
*/
public void setNonRegionalBsId(String nonRegionalBsId) {
this.nonRegionalBsId=nonRegionalBsId;
}
/** 买家：非区域买手编码 [【需要和买手确认】] */
private String nonRegionalBsCode;
/**
* 获取买家：非区域买手编码 [【需要和买手确认】]
* @return 买家：非区域买手编码 [【需要和买手确认】]
*/
public String getNonRegionalBsCode() {
return this.nonRegionalBsCode;
}
/**
* 设置买家：非区域买手编码 [【需要和买手确认】]
* @param nonRegionalBsCode
*/
public void setNonRegionalBsCode(String nonRegionalBsCode) {
this.nonRegionalBsCode=nonRegionalBsCode;
}
/** 买家：非区域买手名称 [【需要和买手确认】] */
private String nonRegionalBsName;
/**
* 获取买家：非区域买手名称 [【需要和买手确认】]
* @return 买家：非区域买手名称 [【需要和买手确认】]
*/
public String getNonRegionalBsName() {
return this.nonRegionalBsName;
}
/**
* 设置买家：非区域买手名称 [【需要和买手确认】]
* @param nonRegionalBsName
*/
public void setNonRegionalBsName(String nonRegionalBsName) {
this.nonRegionalBsName=nonRegionalBsName;
}
/** 买家：区域分销买手ID [【需要和买手确认】] */
private String regionalDistributionBsId;
/**
* 获取买家：区域分销买手ID [【需要和买手确认】]
* @return 买家：区域分销买手ID [【需要和买手确认】]
*/
public String getRegionalDistributionBsId() {
return this.regionalDistributionBsId;
}
/**
* 设置买家：区域分销买手ID [【需要和买手确认】]
* @param regionalDistributionBsId
*/
public void setRegionalDistributionBsId(String regionalDistributionBsId) {
this.regionalDistributionBsId=regionalDistributionBsId;
}
/** 买家：区域分销买手编码 [【需要和买手确认】] */
private String regionalDistributionBsCode;
/**
* 获取买家：区域分销买手编码 [【需要和买手确认】]
* @return 买家：区域分销买手编码 [【需要和买手确认】]
*/
public String getRegionalDistributionBsCode() {
return this.regionalDistributionBsCode;
}
/**
* 设置买家：区域分销买手编码 [【需要和买手确认】]
* @param regionalDistributionBsCode
*/
public void setRegionalDistributionBsCode(String regionalDistributionBsCode) {
this.regionalDistributionBsCode=regionalDistributionBsCode;
}
/** 买家：区域分销买手名称 [【需要和买手确认】] */
private String regionalDistributionBsName;
/**
* 获取买家：区域分销买手名称 [【需要和买手确认】]
* @return 买家：区域分销买手名称 [【需要和买手确认】]
*/
public String getRegionalDistributionBsName() {
return this.regionalDistributionBsName;
}
/**
* 设置买家：区域分销买手名称 [【需要和买手确认】]
* @param regionalDistributionBsName
*/
public void setRegionalDistributionBsName(String regionalDistributionBsName) {
this.regionalDistributionBsName=regionalDistributionBsName;
}
/** 买家：账期用户买手ID [【需要和买手确认】] */
private String netUserBsId;
/**
* 获取买家：账期用户买手ID [【需要和买手确认】]
* @return 买家：账期用户买手ID [【需要和买手确认】]
*/
public String getNetUserBsId() {
return this.netUserBsId;
}
/**
* 设置买家：账期用户买手ID [【需要和买手确认】]
* @param netUserBsId
*/
public void setNetUserBsId(String netUserBsId) {
this.netUserBsId=netUserBsId;
}
/** 买家：账期用户买手编码 [【需要和买手确认】] */
private String netUserBsCode;
/**
* 获取买家：账期用户买手编码 [【需要和买手确认】]
* @return 买家：账期用户买手编码 [【需要和买手确认】]
*/
public String getNetUserBsCode() {
return this.netUserBsCode;
}
/**
* 设置买家：账期用户买手编码 [【需要和买手确认】]
* @param netUserBsCode
*/
public void setNetUserBsCode(String netUserBsCode) {
this.netUserBsCode=netUserBsCode;
}
/** 买家：账期用户买手名称 [【需要和买手确认】] */
private String netUserBsName;
/**
* 获取买家：账期用户买手名称 [【需要和买手确认】]
* @return 买家：账期用户买手名称 [【需要和买手确认】]
*/
public String getNetUserBsName() {
return this.netUserBsName;
}
/**
* 设置买家：账期用户买手名称 [【需要和买手确认】]
* @param netUserBsName
*/
public void setNetUserBsName(String netUserBsName) {
this.netUserBsName=netUserBsName;
}
/** 买家：冻品管家ID [【需要和买手确认】] */
private String saId;
/**
* 获取买家：冻品管家ID [【需要和买手确认】]
* @return 买家：冻品管家ID [【需要和买手确认】]
*/
public String getSaId() {
return this.saId;
}
/**
* 设置买家：冻品管家ID [【需要和买手确认】]
* @param saId
*/
public void setSaId(String saId) {
this.saId=saId;
}
/** 买家：冻品管家编码 [【需要和买手确认】] */
private String saCode;
/**
* 获取买家：冻品管家编码 [【需要和买手确认】]
* @return 买家：冻品管家编码 [【需要和买手确认】]
*/
public String getSaCode() {
return this.saCode;
}
/**
* 设置买家：冻品管家编码 [【需要和买手确认】]
* @param saCode
*/
public void setSaCode(String saCode) {
this.saCode=saCode;
}
/** 买家：冻品管家名称 [【需要和买手确认】] */
private String saName;
/**
* 获取买家：冻品管家名称 [【需要和买手确认】]
* @return 买家：冻品管家名称 [【需要和买手确认】]
*/
public String getSaName() {
return this.saName;
}
/**
* 设置买家：冻品管家名称 [【需要和买手确认】]
* @param saName
*/
public void setSaName(String saName) {
this.saName=saName;
}
}
