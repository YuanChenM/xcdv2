package com.batch.order.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class BsOrderDetailEntity extends BaseEntity {
private static final long serialVersionUID = 1L;
/** 明细：买手订单明细ID */
private Long bsOrderDetailId;
/**
* 获取明细：买手订单明细ID
* @return 明细：买手订单明细ID
*/
public Long getBsOrderDetailId() {
return this.bsOrderDetailId;
}
/**
* 设置明细：买手订单明细ID
* @param bsOrderDetailId
*/
public void setBsOrderDetailId(Long bsOrderDetailId) {
this.bsOrderDetailId=bsOrderDetailId;
}
/** 明细：买手订单ID */
private Long bsOrderId;
/**
* 获取明细：买手订单ID
* @return 明细：买手订单ID
*/
public Long getBsOrderId() {
return this.bsOrderId;
}
/**
* 设置明细：买手订单ID
* @param bsOrderId
*/
public void setBsOrderId(Long bsOrderId) {
this.bsOrderId=bsOrderId;
}
/** 明细：销售单位 */
private String goodsUnit;
/**
* 获取明细：销售单位
* @return 明细：销售单位
*/
public String getGoodsUnit() {
return this.goodsUnit;
}
/**
* 设置明细：销售单位
* @param goodsUnit
*/
public void setGoodsUnit(String goodsUnit) {
this.goodsUnit=goodsUnit;
}
/** 明细：商品数量 */
private BigDecimal goodsQuantity;
/**
* 获取明细：商品数量
* @return 明细：商品数量
*/
public BigDecimal getGoodsQuantity() {
return this.goodsQuantity;
}
/**
* 设置明细：商品数量
* @param goodsQuantity
*/
public void setGoodsQuantity(BigDecimal goodsQuantity) {
this.goodsQuantity=goodsQuantity;
}
/** 明细：取消数量 */
private BigDecimal cancelQuantity;
/**
* 获取明细：取消数量
* @return 明细：取消数量
*/
public BigDecimal getCancelQuantity() {
return this.cancelQuantity;
}
/**
* 设置明细：取消数量
* @param cancelQuantity
*/
public void setCancelQuantity(BigDecimal cancelQuantity) {
this.cancelQuantity=cancelQuantity;
}
/** 价盘：实际单价 */
private BigDecimal realUnitPrice;
/**
* 获取价盘：实际单价
* @return 价盘：实际单价
*/
public BigDecimal getRealUnitPrice() {
return this.realUnitPrice;
}
/**
* 设置价盘：实际单价
* @param realUnitPrice
*/
public void setRealUnitPrice(BigDecimal realUnitPrice) {
this.realUnitPrice=realUnitPrice;
}
/** 价盘：实际千克价格 */
private BigDecimal realKgPrice;
/**
* 获取价盘：实际千克价格
* @return 价盘：实际千克价格
*/
public BigDecimal getRealKgPrice() {
return this.realKgPrice;
}
/**
* 设置价盘：实际千克价格
* @param realKgPrice
*/
public void setRealKgPrice(BigDecimal realKgPrice) {
this.realKgPrice=realKgPrice;
}
/** 价盘：首次价盘获取时间 */
private Date priceCreateTime;
/**
* 获取价盘：首次价盘获取时间
* @return 价盘：首次价盘获取时间
*/
public Date getPriceCreateTime() {
return this.priceCreateTime;
}
/**
* 设置价盘：首次价盘获取时间
* @param priceCreateTime
*/
public void setPriceCreateTime(Date priceCreateTime) {
this.priceCreateTime=priceCreateTime;
}
/** 价盘：价格通道 */
private String priceWay;
/**
* 获取价盘：价格通道
* @return 价盘：价格通道
*/
public String getPriceWay() {
return this.priceWay;
}
/**
* 设置价盘：价格通道
* @param priceWay
*/
public void setPriceWay(String priceWay) {
this.priceWay=priceWay;
}
/** 商品：商品ID [任意一级可销售层级+销售标签] */
private String goodsId;
/**
* 获取商品：商品ID [任意一级可销售层级+销售标签]
* @return 商品：商品ID [任意一级可销售层级+销售标签]
*/
public String getGoodsId() {
return this.goodsId;
}
/**
* 设置商品：商品ID [任意一级可销售层级+销售标签]
* @param goodsId
*/
public void setGoodsId(String goodsId) {
this.goodsId=goodsId;
}
/** 商品：产品ID [【需要确认类型】] */
private String productId;
/**
* 获取商品：产品ID [【需要确认类型】]
* @return 商品：产品ID [【需要确认类型】]
*/
public String getProductId() {
return this.productId;
}
/**
* 设置商品：产品ID [【需要确认类型】]
* @param productId
*/
public void setProductId(String productId) {
this.productId=productId;
}
/** 商品：生产商ID */
private Long manufacturerId;
/**
* 获取商品：生产商ID
* @return 商品：生产商ID
*/
public Long getManufacturerId() {
return this.manufacturerId;
}
/**
* 设置商品：生产商ID
* @param manufacturerId
*/
public void setManufacturerId(Long manufacturerId) {
this.manufacturerId=manufacturerId;
}
/** 商品：卖家ID */
private String sellerId;
/**
* 获取商品：卖家ID
* @return 商品：卖家ID
*/
public String getSellerId() {
return this.sellerId;
}
/**
* 设置商品：卖家ID
* @param sellerId
*/
public void setSellerId(String sellerId) {
this.sellerId=sellerId;
}
/** 商品：批次ID [【产品处无批次】] */
private Long batchId;
/**
* 获取商品：批次ID [【产品处无批次】]
* @return 商品：批次ID [【产品处无批次】]
*/
public Long getBatchId() {
return this.batchId;
}
/**
* 设置商品：批次ID [【产品处无批次】]
* @param batchId
*/
public void setBatchId(Long batchId) {
this.batchId=batchId;
}
/** 商品：销售标签ID [【需要和产品确认】] */
private Long saleLabelId;
/**
* 获取商品：销售标签ID [【需要和产品确认】]
* @return 商品：销售标签ID [【需要和产品确认】]
*/
public Long getSaleLabelId() {
return this.saleLabelId;
}
/**
* 设置商品：销售标签ID [【需要和产品确认】]
* @param saleLabelId
*/
public void setSaleLabelId(Long saleLabelId) {
this.saleLabelId=saleLabelId;
}
}
