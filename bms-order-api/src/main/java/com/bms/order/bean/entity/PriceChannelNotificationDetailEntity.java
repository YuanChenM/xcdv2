package com.bms.order.bean.entity;
import com.framework.base.rest.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;
public class PriceChannelNotificationDetailEntity extends BaseEntity {
private static final long serialVersionUID = 1L;
/** 明细：商品价盘通知单明细ID */
private Long priceChannelNotificationDetailId;
/**
* 获取明细：商品价盘通知单明细ID
* @return 明细：商品价盘通知单明细ID
*/
public Long getPriceChannelNotificationDetailId() {
return this.priceChannelNotificationDetailId;
}
/**
* 设置明细：商品价盘通知单明细ID
* @param priceChannelNotificationDetailId
*/
public void setPriceChannelNotificationDetailId(Long priceChannelNotificationDetailId) {
this.priceChannelNotificationDetailId=priceChannelNotificationDetailId;
}
/** 明细：价盘通道通知单ID */
private Long priceChannelNotificationId;
/**
* 获取明细：价盘通道通知单ID
* @return 明细：价盘通道通知单ID
*/
public Long getPriceChannelNotificationId() {
return this.priceChannelNotificationId;
}
/**
* 设置明细：价盘通道通知单ID
* @param priceChannelNotificationId
*/
public void setPriceChannelNotificationId(Long priceChannelNotificationId) {
this.priceChannelNotificationId=priceChannelNotificationId;
}
/** 商品：商品ID */
private String goodsId;
/**
* 获取商品：商品ID
* @return 商品：商品ID
*/
public String getGoodsId() {
return this.goodsId;
}
/**
* 设置商品：商品ID
* @param goodsId
*/
public void setGoodsId(String goodsId) {
this.goodsId=goodsId;
}
/** 商品：商品数量 */
private BigDecimal goodsQuantity;
/**
* 获取商品：商品数量
* @return 商品：商品数量
*/
public BigDecimal getGoodsQuantity() {
return this.goodsQuantity;
}
/**
* 设置商品：商品数量
* @param goodsQuantity
*/
public void setGoodsQuantity(BigDecimal goodsQuantity) {
this.goodsQuantity=goodsQuantity;
}
/** 价盘：通道分类ID */
private Long wayTypeId;
/**
* 获取价盘：通道分类ID
* @return 价盘：通道分类ID
*/
public Long getWayTypeId() {
return this.wayTypeId;
}
/**
* 设置价盘：通道分类ID
* @param wayTypeId
*/
public void setWayTypeId(Long wayTypeId) {
this.wayTypeId=wayTypeId;
}
/** 价盘：通道分类名称 */
private String wayTypeName;
/**
* 获取价盘：通道分类名称
* @return 价盘：通道分类名称
*/
public String getWayTypeName() {
return this.wayTypeName;
}
/**
* 设置价盘：通道分类名称
* @param wayTypeName
*/
public void setWayTypeName(String wayTypeName) {
this.wayTypeName=wayTypeName;
}
/** 价盘：通道配置ID */
private Long wayConfigId;
/**
* 获取价盘：通道配置ID
* @return 价盘：通道配置ID
*/
public Long getWayConfigId() {
return this.wayConfigId;
}
/**
* 设置价盘：通道配置ID
* @param wayConfigId
*/
public void setWayConfigId(Long wayConfigId) {
this.wayConfigId=wayConfigId;
}
/** 价盘：通道描述 */
private String wayDesc;
/**
* 获取价盘：通道描述
* @return 价盘：通道描述
*/
public String getWayDesc() {
return this.wayDesc;
}
/**
* 设置价盘：通道描述
* @param wayDesc
*/
public void setWayDesc(String wayDesc) {
this.wayDesc=wayDesc;
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
/** 价盘：价格通道公斤价 */
private BigDecimal priceChannelKgPrice;
/**
* 获取价盘：价格通道公斤价
* @return 价盘：价格通道公斤价
*/
public BigDecimal getPriceChannelKgPrice() {
return this.priceChannelKgPrice;
}
/**
* 设置价盘：价格通道公斤价
* @param priceChannelKgPrice
*/
public void setPriceChannelKgPrice(BigDecimal priceChannelKgPrice) {
this.priceChannelKgPrice=priceChannelKgPrice;
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
