package com.batch.order.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

import java.math.BigDecimal;

public class PriceChannelDetailEntity extends BaseEntity {
private static final long serialVersionUID = 1L;/** 明细：价格通道组ID */
private Long priceChannelGroupId;
/**
* 获取明细：价格通道组ID
* @return 明细：价格通道组ID
*/
public Long getPriceChannelGroupId() {
return this.priceChannelGroupId;
}
/**
* 设置明细：价格通道组ID
* @param priceChannelGroupId
*/
public void setPriceChannelGroupId(Long priceChannelGroupId) {
this.priceChannelGroupId=priceChannelGroupId;
}
/** 价盘：价格通道ID */
private Long pricePlateChannelId;
/**
* 获取价盘：价格通道ID
* @return 价盘：价格通道ID
*/
public Long getPricePlateChannelId() {
return this.pricePlateChannelId;
}
/**
* 设置价盘：价格通道ID
* @param pricePlateChannelId
*/
public void setPricePlateChannelId(Long pricePlateChannelId) {
this.pricePlateChannelId=pricePlateChannelId;
}
/** 价盘：通道等级 [【需要和价盘确认类型】] */
private Integer priceChannelLevel;
/**
* 获取价盘：通道等级 [【需要和价盘确认类型】]
* @return 价盘：通道等级 [【需要和价盘确认类型】]
*/
public Integer getPriceChannelLevel() {
return this.priceChannelLevel;
}
/**
* 设置价盘：通道等级 [【需要和价盘确认类型】]
* @param priceChannelLevel
*/
public void setPriceChannelLevel(Integer priceChannelLevel) {
this.priceChannelLevel=priceChannelLevel;
}
/** 价盘：通道开始数量 */
private BigDecimal priceChannelStartQuantity;
/**
* 获取价盘：通道开始数量
* @return 价盘：通道开始数量
*/
public BigDecimal getPriceChannelStartQuantity() {
return this.priceChannelStartQuantity;
}
/**
* 设置价盘：通道开始数量
* @param priceChannelStartQuantity
*/
public void setPriceChannelStartQuantity(BigDecimal priceChannelStartQuantity) {
this.priceChannelStartQuantity=priceChannelStartQuantity;
}
/** 价盘：通道结束数量 */
private BigDecimal priceChannelEndQuantity;
/**
* 获取价盘：通道结束数量
* @return 价盘：通道结束数量
*/
public BigDecimal getPriceChannelEndQuantity() {
return this.priceChannelEndQuantity;
}
/**
* 设置价盘：通道结束数量
* @param priceChannelEndQuantity
*/
public void setPriceChannelEndQuantity(BigDecimal priceChannelEndQuantity) {
this.priceChannelEndQuantity=priceChannelEndQuantity;
}
/** 价盘：价格通道单价 */
private BigDecimal priceChannelUnitPrice;
/**
* 获取价盘：价格通道单价
* @return 价盘：价格通道单价
*/
public BigDecimal getPriceChannelUnitPrice() {
return this.priceChannelUnitPrice;
}
/**
* 设置价盘：价格通道单价
* @param priceChannelUnitPrice
*/
public void setPriceChannelUnitPrice(BigDecimal priceChannelUnitPrice) {
this.priceChannelUnitPrice=priceChannelUnitPrice;
}
}
