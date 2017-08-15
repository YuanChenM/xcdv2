package com.bms.order.bean.entity;
import com.framework.base.rest.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;
public class DistributionNotificationDetailEntity extends BaseEntity {
private static final long serialVersionUID = 1L;
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
/** 明细：配送单ID */
private Long distributionNotificationId;
/**
* 获取明细：配送单ID
* @return 明细：配送单ID
*/
public Long getDistributionNotificationId() {
return this.distributionNotificationId;
}
/**
* 设置明细：配送单ID
* @param distributionNotificationId
*/
public void setDistributionNotificationId(Long distributionNotificationId) {
this.distributionNotificationId=distributionNotificationId;
}
/** 明细：买家订单预配送明细ID */
private Long buyerForcastDeliverDetailId;
/**
* 获取明细：买家订单预配送明细ID
* @return 明细：买家订单预配送明细ID
*/
public Long getBuyerForcastDeliverDetailId() {
return this.buyerForcastDeliverDetailId;
}
/**
* 设置明细：买家订单预配送明细ID
* @param buyerForcastDeliverDetailId
*/
public void setBuyerForcastDeliverDetailId(Long buyerForcastDeliverDetailId) {
this.buyerForcastDeliverDetailId=buyerForcastDeliverDetailId;
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
/** 商品：批次编码 [【产品处无批次】] */
private String batchCode;
/**
* 获取商品：批次编码 [【产品处无批次】]
* @return 商品：批次编码 [【产品处无批次】]
*/
public String getBatchCode() {
return this.batchCode;
}
/**
* 设置商品：批次编码 [【产品处无批次】]
* @param batchCode
*/
public void setBatchCode(String batchCode) {
this.batchCode=batchCode;
}
/** 商品：商品单位 */
private String goodsUnit;
/**
* 获取商品：商品单位
* @return 商品：商品单位
*/
public String getGoodsUnit() {
return this.goodsUnit;
}
/**
* 设置商品：商品单位
* @param goodsUnit
*/
public void setGoodsUnit(String goodsUnit) {
this.goodsUnit=goodsUnit;
}
/** 商品：卖家编码 */
private String sellerCode;
/**
* 获取商品：卖家编码
* @return 商品：卖家编码
*/
public String getSellerCode() {
return this.sellerCode;
}
/**
* 设置商品：卖家编码
* @param sellerCode
*/
public void setSellerCode(String sellerCode) {
this.sellerCode=sellerCode;
}
/** 配送：配送数量 [需发货数量] */
private BigDecimal distributionQuantity;
/**
* 获取配送：配送数量 [需发货数量]
* @return 配送：配送数量 [需发货数量]
*/
public BigDecimal getDistributionQuantity() {
return this.distributionQuantity;
}
/**
* 设置配送：配送数量 [需发货数量]
* @param distributionQuantity
*/
public void setDistributionQuantity(BigDecimal distributionQuantity) {
this.distributionQuantity=distributionQuantity;
}
/** 配送：取消数量 [取消数量] */
private BigDecimal cancelQuantity;
/**
* 获取配送：取消数量 [取消数量]
* @return 配送：取消数量 [取消数量]
*/
public BigDecimal getCancelQuantity() {
return this.cancelQuantity;
}
/**
* 设置配送：取消数量 [取消数量]
* @param cancelQuantity
*/
public void setCancelQuantity(BigDecimal cancelQuantity) {
this.cancelQuantity=cancelQuantity;
}
/** 销售方：销售方编码 */
private String sellSideCode;
/**
* 获取销售方：销售方编码
* @return 销售方：销售方编码
*/
public String getSellSideCode() {
return this.sellSideCode;
}
/**
* 设置销售方：销售方编码
* @param sellSideCode
*/
public void setSellSideCode(String sellSideCode) {
this.sellSideCode=sellSideCode;
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
}
