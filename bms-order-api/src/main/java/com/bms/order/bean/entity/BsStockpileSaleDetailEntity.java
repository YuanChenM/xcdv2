package com.bms.order.bean.entity;
import com.framework.base.rest.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;
public class BsStockpileSaleDetailEntity extends BaseEntity {
private static final long serialVersionUID = 1L;
/** 销售明细：囤货销售明细ID */
private Long stockpileSaleDetailId;
/**
* 获取销售明细：囤货销售明细ID
* @return 销售明细：囤货销售明细ID
*/
public Long getStockpileSaleDetailId() {
return this.stockpileSaleDetailId;
}
/**
* 设置销售明细：囤货销售明细ID
* @param stockpileSaleDetailId
*/
public void setStockpileSaleDetailId(Long stockpileSaleDetailId) {
this.stockpileSaleDetailId=stockpileSaleDetailId;
}
/** 销售明细：囤货分拆明细ID */
private Long bsStockpileSplitDetailId;
/**
* 获取销售明细：囤货分拆明细ID
* @return 销售明细：囤货分拆明细ID
*/
public Long getBsStockpileSplitDetailId() {
return this.bsStockpileSplitDetailId;
}
/**
* 设置销售明细：囤货分拆明细ID
* @param bsStockpileSplitDetailId
*/
public void setBsStockpileSplitDetailId(Long bsStockpileSplitDetailId) {
this.bsStockpileSplitDetailId=bsStockpileSplitDetailId;
}
/** 销售明细：买家分拆明细ID */
private Long buyerForcastDeliverDetailId;
/**
* 获取销售明细：买家分拆明细ID
* @return 销售明细：买家分拆明细ID
*/
public Long getBuyerForcastDeliverDetailId() {
return this.buyerForcastDeliverDetailId;
}
/**
* 设置销售明细：买家分拆明细ID
* @param buyerForcastDeliverDetailId
*/
public void setBuyerForcastDeliverDetailId(Long buyerForcastDeliverDetailId) {
this.buyerForcastDeliverDetailId=buyerForcastDeliverDetailId;
}
/** 销售：销售数量 */
private BigDecimal saleQuantity;
/**
* 获取销售：销售数量
* @return 销售：销售数量
*/
public BigDecimal getSaleQuantity() {
return this.saleQuantity;
}
/**
* 设置销售：销售数量
* @param saleQuantity
*/
public void setSaleQuantity(BigDecimal saleQuantity) {
this.saleQuantity=saleQuantity;
}
}
