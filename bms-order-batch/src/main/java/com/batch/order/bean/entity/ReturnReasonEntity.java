package com.batch.order.bean.entity;
import com.framework.base.rest.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;
public class ReturnReasonEntity extends BaseEntity {
private static final long serialVersionUID = 1L;
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
/** 退货原因名称 [退货原因名称] */
private String reasonName;
/**
* 获取退货原因名称 [退货原因名称]
* @return 退货原因名称 [退货原因名称]
*/
public String getReasonName() {
return this.reasonName;
}
/**
* 设置退货原因名称 [退货原因名称]
* @param reasonName
*/
public void setReasonName(String reasonName) {
this.reasonName=reasonName;
}
/** 适用类型 [以逗号分隔的退货类型] */
private String applyType;
/**
* 获取适用类型 [以逗号分隔的退货类型]
* @return 适用类型 [以逗号分隔的退货类型]
*/
public String getApplyType() {
return this.applyType;
}
/**
* 设置适用类型 [以逗号分隔的退货类型]
* @param applyType
*/
public void setApplyType(String applyType) {
this.applyType=applyType;
}
/** 适用对象 [使用对象,001-买家，002-买手] */
private String applyObject;
/**
* 获取适用对象 [使用对象,001-买家，002-买手]
* @return 适用对象 [使用对象,001-买家，002-买手]
*/
public String getApplyObject() {
return this.applyObject;
}
/**
* 设置适用对象 [使用对象,001-买家，002-买手]
* @param applyObject
*/
public void setApplyObject(String applyObject) {
this.applyObject=applyObject;
}
}
