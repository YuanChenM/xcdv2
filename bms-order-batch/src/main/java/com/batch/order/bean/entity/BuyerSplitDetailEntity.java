package com.batch.order.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class BuyerSplitDetailEntity extends BaseEntity {
private static final long serialVersionUID = 1L;/** 明细：买家分拆单明细ID */
private Long buyerSplitDetailId;
/**
* 获取明细：买家分拆单明细ID
* @return 明细：买家分拆单明细ID
*/
public Long getBuyerSplitDetailId() {
return this.buyerSplitDetailId;
}
/**
* 设置明细：买家分拆单明细ID
* @param buyerSplitDetailId
*/
public void setBuyerSplitDetailId(Long buyerSplitDetailId) {
this.buyerSplitDetailId=buyerSplitDetailId;
}
/** 明细：买家分批订单ID */
private Long buyerBatchOrderId;
/**
* 获取明细：买家分批订单ID
* @return 明细：买家分批订单ID
*/
public Long getBuyerBatchOrderId() {
return this.buyerBatchOrderId;
}
/**
* 设置明细：买家分批订单ID
* @param buyerBatchOrderId
*/
public void setBuyerBatchOrderId(Long buyerBatchOrderId) {
this.buyerBatchOrderId=buyerBatchOrderId;
}
/** 明细：买家分批订单明细ID */
private Long buyerBatchOrderDetailId;
/**
* 获取明细：买家分批订单明细ID
* @return 明细：买家分批订单明细ID
*/
public Long getBuyerBatchOrderDetailId() {
return this.buyerBatchOrderDetailId;
}
/**
* 设置明细：买家分批订单明细ID
* @param buyerBatchOrderDetailId
*/
public void setBuyerBatchOrderDetailId(Long buyerBatchOrderDetailId) {
this.buyerBatchOrderDetailId=buyerBatchOrderDetailId;
}
/** 销售方：供货主体 [CodeMaster 平台，买手] */
private String sellSideType;
/**
* 获取销售方：供货主体 [CodeMaster 平台，买手]
* @return 销售方：供货主体 [CodeMaster 平台，买手]
*/
public String getSellSideType() {
return this.sellSideType;
}
/**
* 设置销售方：供货主体 [CodeMaster 平台，买手]
* @param sellSideType
*/
public void setSellSideType(String sellSideType) {
this.sellSideType=sellSideType;
}
/** 销售方：销售方ID [实际的销售方(平台，买手等)
云冻品为平台，
B2B第三方就是第三方卖家，
若为买手销售订单则为买手ID] */
private String sellSideId;
/**
* 获取销售方：销售方ID [实际的销售方(平台，买手等)
云冻品为平台，
B2B第三方就是第三方卖家，
若为买手销售订单则为买手ID]
* @return 销售方：销售方ID [实际的销售方(平台，买手等)
云冻品为平台，
B2B第三方就是第三方卖家，
若为买手销售订单则为买手ID]
*/
public String getSellSideId() {
return this.sellSideId;
}
/**
* 设置销售方：销售方ID [实际的销售方(平台，买手等)
云冻品为平台，
B2B第三方就是第三方卖家，
若为买手销售订单则为买手ID]
* @param sellSideId
*/
public void setSellSideId(String sellSideId) {
this.sellSideId=sellSideId;
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
/** 商品：商品SKU [【精确到生产商和卖家的SKU】] */
private String sku;
/**
* 获取商品：商品SKU [【精确到生产商和卖家的SKU】]
* @return 商品：商品SKU [【精确到生产商和卖家的SKU】]
*/
public String getSku() {
return this.sku;
}
/**
* 设置商品：商品SKU [【精确到生产商和卖家的SKU】]
* @param sku
*/
public void setSku(String sku) {
this.sku=sku;
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
/** 配送：应该发货数量 */
private BigDecimal planSendQuantity;
/**
* 获取配送：应该发货数量
* @return 配送：应该发货数量
*/
public BigDecimal getPlanSendQuantity() {
return this.planSendQuantity;
}
/**
* 设置配送：应该发货数量
* @param planSendQuantity
*/
public void setPlanSendQuantity(BigDecimal planSendQuantity) {
this.planSendQuantity=planSendQuantity;
}
/** 配送：实际发货数量 */
private BigDecimal realSendQuantity;
/**
* 获取配送：实际发货数量
* @return 配送：实际发货数量
*/
public BigDecimal getRealSendQuantity() {
return this.realSendQuantity;
}
/**
* 设置配送：实际发货数量
* @param realSendQuantity
*/
public void setRealSendQuantity(BigDecimal realSendQuantity) {
this.realSendQuantity=realSendQuantity;
}
/** 配送：收货数量 */
private BigDecimal receiveQuantity;
/**
* 获取配送：收货数量
* @return 配送：收货数量
*/
public BigDecimal getReceiveQuantity() {
return this.receiveQuantity;
}
/**
* 设置配送：收货数量
* @param receiveQuantity
*/
public void setReceiveQuantity(BigDecimal receiveQuantity) {
this.receiveQuantity=receiveQuantity;
}
/** 配送：拒收退货数量 */
private BigDecimal rejectQuantity;
/**
* 获取配送：拒收退货数量
* @return 配送：拒收退货数量
*/
public BigDecimal getRejectQuantity() {
return this.rejectQuantity;
}
/**
* 设置配送：拒收退货数量
* @param rejectQuantity
*/
public void setRejectQuantity(BigDecimal rejectQuantity) {
this.rejectQuantity=rejectQuantity;
}
/** 配送：迟收退货数量 */
private BigDecimal delayQuantity;
/**
* 获取配送：迟收退货数量
* @return 配送：迟收退货数量
*/
public BigDecimal getDelayQuantity() {
return this.delayQuantity;
}
/**
* 设置配送：迟收退货数量
* @param delayQuantity
*/
public void setDelayQuantity(BigDecimal delayQuantity) {
this.delayQuantity=delayQuantity;
}
/** 配送：迟收再配送日 */
private Date redistributionDate;
/**
* 获取配送：迟收再配送日
* @return 配送：迟收再配送日
*/
public Date getRedistributionDate() {
return this.redistributionDate;
}
/**
* 设置配送：迟收再配送日
* @param redistributionDate
*/
public void setRedistributionDate(Date redistributionDate) {
this.redistributionDate=redistributionDate;
}
/** 售后：退货数量 */
private BigDecimal returnQuantity;
/**
* 获取售后：退货数量
* @return 售后：退货数量
*/
public BigDecimal getReturnQuantity() {
return this.returnQuantity;
}
/**
* 设置售后：退货数量
* @param returnQuantity
*/
public void setReturnQuantity(BigDecimal returnQuantity) {
this.returnQuantity=returnQuantity;
}
}
