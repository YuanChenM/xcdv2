package com.bms.order.bean.entity;
import com.framework.base.rest.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;
public class BsReturnDetailEntity extends BaseEntity {
private static final long serialVersionUID = 1L;
/** 退货明细ID [退货明细ID] */
private Long detailId;
/**
* 获取退货明细ID [退货明细ID]
* @return 退货明细ID [退货明细ID]
*/
public Long getDetailId() {
return this.detailId;
}
/**
* 设置退货明细ID [退货明细ID]
* @param detailId
*/
public void setDetailId(Long detailId) {
this.detailId=detailId;
}
/** 退货单ID [退货单ID] */
private Long returnId;
/**
* 获取退货单ID [退货单ID]
* @return 退货单ID [退货单ID]
*/
public Long getReturnId() {
return this.returnId;
}
/**
* 设置退货单ID [退货单ID]
* @param returnId
*/
public void setReturnId(Long returnId) {
this.returnId=returnId;
}
/** 买手囤货分拆单明细ID [买手囤货分拆单明细ID] */
private Long bsStockpileSplitDetailId;
/**
* 获取买手囤货分拆单明细ID [买手囤货分拆单明细ID]
* @return 买手囤货分拆单明细ID [买手囤货分拆单明细ID]
*/
public Long getBsStockpileSplitDetailId() {
return this.bsStockpileSplitDetailId;
}
/**
* 设置买手囤货分拆单明细ID [买手囤货分拆单明细ID]
* @param bsStockpileSplitDetailId
*/
public void setBsStockpileSplitDetailId(Long bsStockpileSplitDetailId) {
this.bsStockpileSplitDetailId=bsStockpileSplitDetailId;
}
/** 商品ID [商品ID] */
private String goodsId;
/**
* 获取商品ID [商品ID]
* @return 商品ID [商品ID]
*/
public String getGoodsId() {
return this.goodsId;
}
/**
* 设置商品ID [商品ID]
* @param goodsId
*/
public void setGoodsId(String goodsId) {
this.goodsId=goodsId;
}
/** 销售单位 [销售单位] */
private String salesUnit;
/**
* 获取销售单位 [销售单位]
* @return 销售单位 [销售单位]
*/
public String getSalesUnit() {
return this.salesUnit;
}
/**
* 设置销售单位 [销售单位]
* @param salesUnit
*/
public void setSalesUnit(String salesUnit) {
this.salesUnit=salesUnit;
}
/** 退货数量 [退货申请数量] */
private BigDecimal returnQty;
/**
* 获取退货数量 [退货申请数量]
* @return 退货数量 [退货申请数量]
*/
public BigDecimal getReturnQty() {
return this.returnQty;
}
/**
* 设置退货数量 [退货申请数量]
* @param returnQty
*/
public void setReturnQty(BigDecimal returnQty) {
this.returnQty=returnQty;
}
/** 退货原因ID [退货原因ID] */
private Long reasonId;
/**
* 获取退货原因ID [退货原因ID]
* @return 退货原因ID [退货原因ID]
*/
public Long getReasonId() {
return this.reasonId;
}
/**
* 设置退货原因ID [退货原因ID]
* @param reasonId
*/
public void setReasonId(Long reasonId) {
this.reasonId=reasonId;
}
/** 退货入库数量 [退货入库数量] */
private BigDecimal inboundQty;
/**
* 获取退货入库数量 [退货入库数量]
* @return 退货入库数量 [退货入库数量]
*/
public BigDecimal getInboundQty() {
return this.inboundQty;
}
/**
* 设置退货入库数量 [退货入库数量]
* @param inboundQty
*/
public void setInboundQty(BigDecimal inboundQty) {
this.inboundQty=inboundQty;
}
}
