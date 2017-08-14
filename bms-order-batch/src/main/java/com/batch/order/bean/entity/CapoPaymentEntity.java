package com.batch.order.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class CapoPaymentEntity extends BaseEntity {
private static final long serialVersionUID = 1L;/** 支付：支付ID */
private Long paymentId;
/**
* 获取支付：支付ID
* @return 支付：支付ID
*/
public Long getPaymentId() {
return this.paymentId;
}
/**
* 设置支付：支付ID
* @param paymentId
*/
public void setPaymentId(Long paymentId) {
this.paymentId=paymentId;
}
/** 支付：订单ID */
private Long orderId;
/**
* 获取支付：订单ID
* @return 支付：订单ID
*/
public Long getOrderId() {
return this.orderId;
}
/**
* 设置支付：订单ID
* @param orderId
*/
public void setOrderId(Long orderId) {
this.orderId=orderId;
}
/** 支付：分批订单ID */
private Long batchOrderId;
/**
* 获取支付：分批订单ID
* @return 支付：分批订单ID
*/
public Long getBatchOrderId() {
return this.batchOrderId;
}
/**
* 设置支付：分批订单ID
* @param batchOrderId
*/
public void setBatchOrderId(Long batchOrderId) {
this.batchOrderId=batchOrderId;
}
/** 支付：支付方式 */
private String paymentWay;
/**
* 获取支付：支付方式
* @return 支付：支付方式
*/
public String getPaymentWay() {
return this.paymentWay;
}
/**
* 设置支付：支付方式
* @param paymentWay
*/
public void setPaymentWay(String paymentWay) {
this.paymentWay=paymentWay;
}
/** 支付：支付科目 */
private String paymentSubject;
/**
* 获取支付：支付科目
* @return 支付：支付科目
*/
public String getPaymentSubject() {
return this.paymentSubject;
}
/**
* 设置支付：支付科目
* @param paymentSubject
*/
public void setPaymentSubject(String paymentSubject) {
this.paymentSubject=paymentSubject;
}
/** 支付：支付金额 */
private BigDecimal paymentAmount;
/**
* 获取支付：支付金额
* @return 支付：支付金额
*/
public BigDecimal getPaymentAmount() {
return this.paymentAmount;
}
/**
* 设置支付：支付金额
* @param paymentAmount
*/
public void setPaymentAmount(BigDecimal paymentAmount) {
this.paymentAmount=paymentAmount;
}
/** 支付：支付时间 */
private Date paymentDatetime;
/**
* 获取支付：支付时间
* @return 支付：支付时间
*/
public Date getPaymentDatetime() {
return this.paymentDatetime;
}
/**
* 设置支付：支付时间
* @param paymentDatetime
*/
public void setPaymentDatetime(Date paymentDatetime) {
this.paymentDatetime=paymentDatetime;
}
}
