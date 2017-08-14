package com.batch.order.bean.entity;
import com.framework.base.rest.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;
public class SendNotificationDetailEntity extends BaseEntity {
private static final long serialVersionUID = 1L;
/** 明细：发货通知单明细ID */
private Long sendNotificationDetailId;
/**
* 获取明细：发货通知单明细ID
* @return 明细：发货通知单明细ID
*/
public Long getSendNotificationDetailId() {
return this.sendNotificationDetailId;
}
/**
* 设置明细：发货通知单明细ID
* @param sendNotificationDetailId
*/
public void setSendNotificationDetailId(Long sendNotificationDetailId) {
this.sendNotificationDetailId=sendNotificationDetailId;
}
/** 明细：发货通知单ID */
private Long sendNotificationId;
/**
* 获取明细：发货通知单ID
* @return 明细：发货通知单ID
*/
public Long getSendNotificationId() {
return this.sendNotificationId;
}
/**
* 设置明细：发货通知单ID
* @param sendNotificationId
*/
public void setSendNotificationId(Long sendNotificationId) {
this.sendNotificationId=sendNotificationId;
}
/** 明细：配送明细ID */
private Long distributionNotificationDetailId;
/**
* 获取明细：配送明细ID
* @return 明细：配送明细ID
*/
public Long getDistributionNotificationDetailId() {
return this.distributionNotificationDetailId;
}
/**
* 设置明细：配送明细ID
* @param distributionNotificationDetailId
*/
public void setDistributionNotificationDetailId(Long distributionNotificationDetailId) {
this.distributionNotificationDetailId=distributionNotificationDetailId;
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
/** 商品：批次 [【产品处无批次】] */
private String batch;
/**
* 获取商品：批次 [【产品处无批次】]
* @return 商品：批次 [【产品处无批次】]
*/
public String getBatch() {
return this.batch;
}
/**
* 设置商品：批次 [【产品处无批次】]
* @param batch
*/
public void setBatch(String batch) {
this.batch=batch;
}
/** 商品：实际发货数量 */
private BigDecimal realSendQuantity;
/**
* 获取商品：实际发货数量
* @return 商品：实际发货数量
*/
public BigDecimal getRealSendQuantity() {
return this.realSendQuantity;
}
/**
* 设置商品：实际发货数量
* @param realSendQuantity
*/
public void setRealSendQuantity(BigDecimal realSendQuantity) {
this.realSendQuantity=realSendQuantity;
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
