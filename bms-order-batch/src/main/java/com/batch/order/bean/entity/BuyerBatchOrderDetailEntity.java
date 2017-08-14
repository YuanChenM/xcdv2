package com.batch.order.bean.entity;
import com.framework.base.rest.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;
public class BuyerBatchOrderDetailEntity extends BaseEntity {
private static final long serialVersionUID = 1L;
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
/** 明细：买家订单ID */
private Long buyerOrderId;
/**
* 获取明细：买家订单ID
* @return 明细：买家订单ID
*/
public Long getBuyerOrderId() {
return this.buyerOrderId;
}
/**
* 设置明细：买家订单ID
* @param buyerOrderId
*/
public void setBuyerOrderId(Long buyerOrderId) {
this.buyerOrderId=buyerOrderId;
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
/** 明细：商品单位 [CodeMaster   KG/箱] */
private String goodsUnit;
/**
* 获取明细：商品单位 [CodeMaster   KG/箱]
* @return 明细：商品单位 [CodeMaster   KG/箱]
*/
public String getGoodsUnit() {
return this.goodsUnit;
}
/**
* 设置明细：商品单位 [CodeMaster   KG/箱]
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
/** 价盘：下单时单位价格 */
private BigDecimal orderCreateUnitPrice;
/**
* 获取价盘：下单时单位价格
* @return 价盘：下单时单位价格
*/
public BigDecimal getOrderCreateUnitPrice() {
return this.orderCreateUnitPrice;
}
/**
* 设置价盘：下单时单位价格
* @param orderCreateUnitPrice
*/
public void setOrderCreateUnitPrice(BigDecimal orderCreateUnitPrice) {
this.orderCreateUnitPrice=orderCreateUnitPrice;
}
/** 价盘：下单时千克价格 */
private BigDecimal orderCreateKgPrice;
/**
* 获取价盘：下单时千克价格
* @return 价盘：下单时千克价格
*/
public BigDecimal getOrderCreateKgPrice() {
return this.orderCreateKgPrice;
}
/**
* 设置价盘：下单时千克价格
* @param orderCreateKgPrice
*/
public void setOrderCreateKgPrice(BigDecimal orderCreateKgPrice) {
this.orderCreateKgPrice=orderCreateKgPrice;
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
/** 分批订单：是否分拆完成 */
private Boolean splitFlg;
/**
* 获取分批订单：是否分拆完成
* @return 分批订单：是否分拆完成
*/
public Boolean getSplitFlg() {
return this.splitFlg;
}
/**
* 设置分批订单：是否分拆完成
* @param splitFlg
*/
public void setSplitFlg(Boolean splitFlg) {
this.splitFlg=splitFlg;
}
/** 分批订单：是否手动分拆 */
private Boolean manualSplitFlg;
/**
* 获取分批订单：是否手动分拆
* @return 分批订单：是否手动分拆
*/
public Boolean getManualSplitFlg() {
return this.manualSplitFlg;
}
/**
* 设置分批订单：是否手动分拆
* @param manualSplitFlg
*/
public void setManualSplitFlg(Boolean manualSplitFlg) {
this.manualSplitFlg=manualSplitFlg;
}
/** 库存：库存变更Sequence [库存：库存变更Sequence] */
private Integer transactionSequence;
/**
* 获取库存：库存变更Sequence [库存：库存变更Sequence]
* @return 库存：库存变更Sequence [库存：库存变更Sequence]
*/
public Integer getTransactionSequence() {
return this.transactionSequence;
}
/**
* 设置库存：库存变更Sequence [库存：库存变更Sequence]
* @param transactionSequence
*/
public void setTransactionSequence(Integer transactionSequence) {
this.transactionSequence=transactionSequence;
}
}
