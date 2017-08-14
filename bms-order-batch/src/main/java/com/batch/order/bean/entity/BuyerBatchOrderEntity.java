package com.batch.order.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class BuyerBatchOrderEntity extends BaseEntity {
private static final long serialVersionUID = 1L;
/** 分批订单：买家分批订单ID */
private Long buyerBatchOrderId;
/**
* 获取分批订单：买家分批订单ID
* @return 分批订单：买家分批订单ID
*/
public Long getBuyerBatchOrderId() {
return this.buyerBatchOrderId;
}
/**
* 设置分批订单：买家分批订单ID
* @param buyerBatchOrderId
*/
public void setBuyerBatchOrderId(Long buyerBatchOrderId) {
this.buyerBatchOrderId=buyerBatchOrderId;
}
/** 分批订单：买家分批订单编号 */
private String buyerBatchOrderCode;
/**
* 获取分批订单：买家分批订单编号
* @return 分批订单：买家分批订单编号
*/
public String getBuyerBatchOrderCode() {
return this.buyerBatchOrderCode;
}
/**
* 设置分批订单：买家分批订单编号
* @param buyerBatchOrderCode
*/
public void setBuyerBatchOrderCode(String buyerBatchOrderCode) {
this.buyerBatchOrderCode=buyerBatchOrderCode;
}
/** 分批订单：买家订单ID */
private Long buyerOrderId;
/**
* 获取分批订单：买家订单ID
* @return 分批订单：买家订单ID
*/
public Long getBuyerOrderId() {
return this.buyerOrderId;
}
/**
* 设置分批订单：买家订单ID
* @param buyerOrderId
*/
public void setBuyerOrderId(Long buyerOrderId) {
this.buyerOrderId=buyerOrderId;
}
/** 分批订单：期望配送日 */
private Date requiredDistributionDate;
/**
* 获取分批订单：期望配送日
* @return 分批订单：期望配送日
*/
public Date getRequiredDistributionDate() {
return this.requiredDistributionDate;
}
/**
* 设置分批订单：期望配送日
* @param requiredDistributionDate
*/
public void setRequiredDistributionDate(Date requiredDistributionDate) {
this.requiredDistributionDate=requiredDistributionDate;
}
/** 收货要求：预计发货时间 */
private Date expectedSendDatetime;
/**
* 获取收货要求：预计发货时间
* @return 收货要求：预计发货时间
*/
public Date getExpectedSendDatetime() {
return this.expectedSendDatetime;
}
/**
* 设置收货要求：预计发货时间
* @param expectedSendDatetime
*/
public void setExpectedSendDatetime(Date expectedSendDatetime) {
this.expectedSendDatetime=expectedSendDatetime;
}
/** 收货要求：预计到货时间 */
private Date expectedArrivalDatetime;
/**
* 获取收货要求：预计到货时间
* @return 收货要求：预计到货时间
*/
public Date getExpectedArrivalDatetime() {
return this.expectedArrivalDatetime;
}
/**
* 设置收货要求：预计到货时间
* @param expectedArrivalDatetime
*/
public void setExpectedArrivalDatetime(Date expectedArrivalDatetime) {
this.expectedArrivalDatetime=expectedArrivalDatetime;
}
/** 支付：订单金额 [订单金额+运费金额-优惠金额=订单总额] */
private BigDecimal orderAmount;
/**
* 获取支付：订单金额 [订单金额+运费金额-优惠金额=订单总额]
* @return 支付：订单金额 [订单金额+运费金额-优惠金额=订单总额]
*/
public BigDecimal getOrderAmount() {
return this.orderAmount;
}
/**
* 设置支付：订单金额 [订单金额+运费金额-优惠金额=订单总额]
* @param orderAmount
*/
public void setOrderAmount(BigDecimal orderAmount) {
this.orderAmount=orderAmount;
}
/** 支付：运费金额（预留字段） */
private BigDecimal freight;
/**
* 获取支付：运费金额（预留字段）
* @return 支付：运费金额（预留字段）
*/
public BigDecimal getFreight() {
return this.freight;
}
/**
* 设置支付：运费金额（预留字段）
* @param freight
*/
public void setFreight(BigDecimal freight) {
this.freight=freight;
}
/** 支付：优惠金额（预留字段） */
private BigDecimal preferentialAmount;
/**
* 获取支付：优惠金额（预留字段）
* @return 支付：优惠金额（预留字段）
*/
public BigDecimal getPreferentialAmount() {
return this.preferentialAmount;
}
/**
* 设置支付：优惠金额（预留字段）
* @param preferentialAmount
*/
public void setPreferentialAmount(BigDecimal preferentialAmount) {
this.preferentialAmount=preferentialAmount;
}
/** 支付：已收金额（预留字段） [订单总额-已收金额=尾款金额] */
private BigDecimal receiveAmount;
/**
* 获取支付：已收金额（预留字段） [订单总额-已收金额=尾款金额]
* @return 支付：已收金额（预留字段） [订单总额-已收金额=尾款金额]
*/
public BigDecimal getReceiveAmount() {
return this.receiveAmount;
}
/**
* 设置支付：已收金额（预留字段） [订单总额-已收金额=尾款金额]
* @param receiveAmount
*/
public void setReceiveAmount(BigDecimal receiveAmount) {
this.receiveAmount=receiveAmount;
}
/** 支付：定金应付比例（预留字段） */
private BigDecimal earnestPercent;
/**
* 获取支付：定金应付比例（预留字段）
* @return 支付：定金应付比例（预留字段）
*/
public BigDecimal getEarnestPercent() {
return this.earnestPercent;
}
/**
* 设置支付：定金应付比例（预留字段）
* @param earnestPercent
*/
public void setEarnestPercent(BigDecimal earnestPercent) {
this.earnestPercent=earnestPercent;
}
/** 支付：定金应付金额（预留字段） */
private BigDecimal earnestAmount;
/**
* 获取支付：定金应付金额（预留字段）
* @return 支付：定金应付金额（预留字段）
*/
public BigDecimal getEarnestAmount() {
return this.earnestAmount;
}
/**
* 设置支付：定金应付金额（预留字段）
* @param earnestAmount
*/
public void setEarnestAmount(BigDecimal earnestAmount) {
this.earnestAmount=earnestAmount;
}
/** 支付：应预付比例（预留字段） */
private BigDecimal advancePaymentPercent;
/**
* 获取支付：应预付比例（预留字段）
* @return 支付：应预付比例（预留字段）
*/
public BigDecimal getAdvancePaymentPercent() {
return this.advancePaymentPercent;
}
/**
* 设置支付：应预付比例（预留字段）
* @param advancePaymentPercent
*/
public void setAdvancePaymentPercent(BigDecimal advancePaymentPercent) {
this.advancePaymentPercent=advancePaymentPercent;
}
/** 支付：应预付金额（预留字段） */
private BigDecimal advancePaymentAmount;
/**
* 获取支付：应预付金额（预留字段）
* @return 支付：应预付金额（预留字段）
*/
public BigDecimal getAdvancePaymentAmount() {
return this.advancePaymentAmount;
}
/**
* 设置支付：应预付金额（预留字段）
* @param advancePaymentAmount
*/
public void setAdvancePaymentAmount(BigDecimal advancePaymentAmount) {
this.advancePaymentAmount=advancePaymentAmount;
}
/** 状态：买家分批单状态 [CodeMaster] */
private String buyerBatchOrderStu;
/**
* 获取状态：买家分批单状态 [CodeMaster]
* @return 状态：买家分批单状态 [CodeMaster]
*/
public String getBuyerBatchOrderStu() {
return this.buyerBatchOrderStu;
}
/**
* 设置状态：买家分批单状态 [CodeMaster]
* @param buyerBatchOrderStu
*/
public void setBuyerBatchOrderStu(String buyerBatchOrderStu) {
this.buyerBatchOrderStu=buyerBatchOrderStu;
}
}
