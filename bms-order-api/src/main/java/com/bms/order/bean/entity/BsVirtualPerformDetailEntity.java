package com.bms.order.bean.entity;
import com.framework.base.rest.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;
public class BsVirtualPerformDetailEntity extends BaseEntity {
private static final long serialVersionUID = 1L;
/** 行权明细ID [行权明细ID] */
private Long performDetailId;
/**
* 获取行权明细ID [行权明细ID]
* @return 行权明细ID [行权明细ID]
*/
public Long getPerformDetailId() {
return this.performDetailId;
}
/**
* 设置行权明细ID [行权明细ID]
* @param performDetailId
*/
public void setPerformDetailId(Long performDetailId) {
this.performDetailId=performDetailId;
}
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
/** 原囤货订单ID [原囤货订单ID] */
private Long bsOrderId;
/**
* 获取原囤货订单ID [原囤货订单ID]
* @return 原囤货订单ID [原囤货订单ID]
*/
public Long getBsOrderId() {
return this.bsOrderId;
}
/**
* 设置原囤货订单ID [原囤货订单ID]
* @param bsOrderId
*/
public void setBsOrderId(Long bsOrderId) {
this.bsOrderId=bsOrderId;
}
/** 原囤货分拆单明细ID [原囤货分拆单明细ID] */
private Long bsStockpileSplitDetailId;
/**
* 获取原囤货分拆单明细ID [原囤货分拆单明细ID]
* @return 原囤货分拆单明细ID [原囤货分拆单明细ID]
*/
public Long getBsStockpileSplitDetailId() {
return this.bsStockpileSplitDetailId;
}
/**
* 设置原囤货分拆单明细ID [原囤货分拆单明细ID]
* @param bsStockpileSplitDetailId
*/
public void setBsStockpileSplitDetailId(Long bsStockpileSplitDetailId) {
this.bsStockpileSplitDetailId=bsStockpileSplitDetailId;
}
/** 原商品ID [原囤货商品ID] */
private Long oldGoodsId;
/**
* 获取原商品ID [原囤货商品ID]
* @return 原商品ID [原囤货商品ID]
*/
public Long getOldGoodsId() {
return this.oldGoodsId;
}
/**
* 设置原商品ID [原囤货商品ID]
* @param oldGoodsId
*/
public void setOldGoodsId(Long oldGoodsId) {
this.oldGoodsId=oldGoodsId;
}
/** 新商品ID [行权后的商品ID] */
private Long newGoodsId;
/**
* 获取新商品ID [行权后的商品ID]
* @return 新商品ID [行权后的商品ID]
*/
public Long getNewGoodsId() {
return this.newGoodsId;
}
/**
* 设置新商品ID [行权后的商品ID]
* @param newGoodsId
*/
public void setNewGoodsId(Long newGoodsId) {
this.newGoodsId=newGoodsId;
}
/** 行权数量 [行权数量] */
private BigDecimal performQty;
/**
* 获取行权数量 [行权数量]
* @return 行权数量 [行权数量]
*/
public BigDecimal getPerformQty() {
return this.performQty;
}
/**
* 设置行权数量 [行权数量]
* @param performQty
*/
public void setPerformQty(BigDecimal performQty) {
this.performQty=performQty;
}
/** 行权价格通道 [行权价格通道] */
private String performPriceWay;
/**
* 获取行权价格通道 [行权价格通道]
* @return 行权价格通道 [行权价格通道]
*/
public String getPerformPriceWay() {
return this.performPriceWay;
}
/**
* 设置行权价格通道 [行权价格通道]
* @param performPriceWay
*/
public void setPerformPriceWay(String performPriceWay) {
this.performPriceWay=performPriceWay;
}
/** 行权价格 [行权价格] */
private BigDecimal performPrice;
/**
* 获取行权价格 [行权价格]
* @return 行权价格 [行权价格]
*/
public BigDecimal getPerformPrice() {
return this.performPrice;
}
/**
* 设置行权价格 [行权价格]
* @param performPrice
*/
public void setPerformPrice(BigDecimal performPrice) {
this.performPrice=performPrice;
}
}
