package com.bms.order.bean.entity;
import com.framework.base.rest.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;
public class BuyerReturnEntity extends BaseEntity {
private static final long serialVersionUID = 1L;
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
/** 退货单编码 [退货单编码] */
private String returnCode;
/**
* 获取退货单编码 [退货单编码]
* @return 退货单编码 [退货单编码]
*/
public String getReturnCode() {
return this.returnCode;
}
/**
* 设置退货单编码 [退货单编码]
* @param returnCode
*/
public void setReturnCode(String returnCode) {
this.returnCode=returnCode;
}
/** 订单ID [订单ID] */
private Long orderId;
/**
* 获取订单ID [订单ID]
* @return 订单ID [订单ID]
*/
public Long getOrderId() {
return this.orderId;
}
/**
* 设置订单ID [订单ID]
* @param orderId
*/
public void setOrderId(Long orderId) {
this.orderId=orderId;
}
/** 买家ID [买家ID，冗余] */
private String buyerId;
/**
* 获取买家ID [买家ID，冗余]
* @return 买家ID [买家ID，冗余]
*/
public String getBuyerId() {
return this.buyerId;
}
/**
* 设置买家ID [买家ID，冗余]
* @param buyerId
*/
public void setBuyerId(String buyerId) {
this.buyerId=buyerId;
}
/** 买家编码 [买家编码，冗余] */
private String buyerCode;
/**
* 获取买家编码 [买家编码，冗余]
* @return 买家编码 [买家编码，冗余]
*/
public String getBuyerCode() {
return this.buyerCode;
}
/**
* 设置买家编码 [买家编码，冗余]
* @param buyerCode
*/
public void setBuyerCode(String buyerCode) {
this.buyerCode=buyerCode;
}
/** 买家名称 [买家名称，冗余] */
private String buyerName;
/**
* 获取买家名称 [买家名称，冗余]
* @return 买家名称 [买家名称，冗余]
*/
public String getBuyerName() {
return this.buyerName;
}
/**
* 设置买家名称 [买家名称，冗余]
* @param buyerName
*/
public void setBuyerName(String buyerName) {
this.buyerName=buyerName;
}
/** 买家退货单来源 [退货单系统来源-CodeMaster
1-司机PDA，2-云冻品平台，3-云冻品B2B平台] */
private String buyerReturnSource;
/**
* 获取买家退货单来源 [退货单系统来源-CodeMaster
1-司机PDA，2-云冻品平台，3-云冻品B2B平台]
* @return 买家退货单来源 [退货单系统来源-CodeMaster
1-司机PDA，2-云冻品平台，3-云冻品B2B平台]
*/
public String getBuyerReturnSource() {
return this.buyerReturnSource;
}
/**
* 设置买家退货单来源 [退货单系统来源-CodeMaster
1-司机PDA，2-云冻品平台，3-云冻品B2B平台]
* @param buyerReturnSource
*/
public void setBuyerReturnSource(String buyerReturnSource) {
this.buyerReturnSource=buyerReturnSource;
}
/** 买家退货类型 [买家退货类型-CodeMaster
1-迟收；2-拒收；3-退货] */
private String buyerReturnType;
/**
* 获取买家退货类型 [买家退货类型-CodeMaster
1-迟收；2-拒收；3-退货]
* @return 买家退货类型 [买家退货类型-CodeMaster
1-迟收；2-拒收；3-退货]
*/
public String getBuyerReturnType() {
return this.buyerReturnType;
}
/**
* 设置买家退货类型 [买家退货类型-CodeMaster
1-迟收；2-拒收；3-退货]
* @param buyerReturnType
*/
public void setBuyerReturnType(String buyerReturnType) {
this.buyerReturnType=buyerReturnType;
}
/** 退货总金额 [退货总金额，根据退货明细计算] */
private BigDecimal returnAmount;
/**
* 获取退货总金额 [退货总金额，根据退货明细计算]
* @return 退货总金额 [退货总金额，根据退货明细计算]
*/
public BigDecimal getReturnAmount() {
return this.returnAmount;
}
/**
* 设置退货总金额 [退货总金额，根据退货明细计算]
* @param returnAmount
*/
public void setReturnAmount(BigDecimal returnAmount) {
this.returnAmount=returnAmount;
}
/** 退货原因ID [退货原因ID] */
private Long returnReasonId;
/**
* 获取退货原因ID [退货原因ID]
* @return 退货原因ID [退货原因ID]
*/
public Long getReturnReasonId() {
return this.returnReasonId;
}
/**
* 设置退货原因ID [退货原因ID]
* @param returnReasonId
*/
public void setReturnReasonId(Long returnReasonId) {
this.returnReasonId=returnReasonId;
}
/** 买家退货申请人类型 [退货申请人类型] */
private String buyerApplyUserType;
/**
* 获取买家退货申请人类型 [退货申请人类型]
* @return 买家退货申请人类型 [退货申请人类型]
*/
public String getBuyerApplyUserType() {
return this.buyerApplyUserType;
}
/**
* 设置买家退货申请人类型 [退货申请人类型]
* @param buyerApplyUserType
*/
public void setBuyerApplyUserType(String buyerApplyUserType) {
this.buyerApplyUserType=buyerApplyUserType;
}
/** 退货申请人ID [退货申请人ID] */
private String applyUid;
/**
* 获取退货申请人ID [退货申请人ID]
* @return 退货申请人ID [退货申请人ID]
*/
public String getApplyUid() {
return this.applyUid;
}
/**
* 设置退货申请人ID [退货申请人ID]
* @param applyUid
*/
public void setApplyUid(String applyUid) {
this.applyUid=applyUid;
}
/** 退货申请人名称 [退货申请人名称] */
private String applyUname;
/**
* 获取退货申请人名称 [退货申请人名称]
* @return 退货申请人名称 [退货申请人名称]
*/
public String getApplyUname() {
return this.applyUname;
}
/**
* 设置退货申请人名称 [退货申请人名称]
* @param applyUname
*/
public void setApplyUname(String applyUname) {
this.applyUname=applyUname;
}
/** 退货申请时间 [退货申请时间] */
private Date applyTime;
/**
* 获取退货申请时间 [退货申请时间]
* @return 退货申请时间 [退货申请时间]
*/
public Date getApplyTime() {
return this.applyTime;
}
/**
* 设置退货申请时间 [退货申请时间]
* @param applyTime
*/
public void setApplyTime(Date applyTime) {
this.applyTime=applyTime;
}
/** 退货申请备注 [退货备注] */
private String applyRemark;
/**
* 获取退货申请备注 [退货备注]
* @return 退货申请备注 [退货备注]
*/
public String getApplyRemark() {
return this.applyRemark;
}
/**
* 设置退货申请备注 [退货备注]
* @param applyRemark
*/
public void setApplyRemark(String applyRemark) {
this.applyRemark=applyRemark;
}
/** 买家退货确认人类型 [退货确认人类型] */
private String buyerConfirmUserType;
/**
* 获取买家退货确认人类型 [退货确认人类型]
* @return 买家退货确认人类型 [退货确认人类型]
*/
public String getBuyerConfirmUserType() {
return this.buyerConfirmUserType;
}
/**
* 设置买家退货确认人类型 [退货确认人类型]
* @param buyerConfirmUserType
*/
public void setBuyerConfirmUserType(String buyerConfirmUserType) {
this.buyerConfirmUserType=buyerConfirmUserType;
}
/** 退货确认人ID [退货确认人ID] */
private String confirmUid;
/**
* 获取退货确认人ID [退货确认人ID]
* @return 退货确认人ID [退货确认人ID]
*/
public String getConfirmUid() {
return this.confirmUid;
}
/**
* 设置退货确认人ID [退货确认人ID]
* @param confirmUid
*/
public void setConfirmUid(String confirmUid) {
this.confirmUid=confirmUid;
}
/** 退货确认人名称 [确认人名称] */
private String confirmUname;
/**
* 获取退货确认人名称 [确认人名称]
* @return 退货确认人名称 [确认人名称]
*/
public String getConfirmUname() {
return this.confirmUname;
}
/**
* 设置退货确认人名称 [确认人名称]
* @param confirmUname
*/
public void setConfirmUname(String confirmUname) {
this.confirmUname=confirmUname;
}
/** 退货确认时间 [确认时间] */
private Date confirmTime;
/**
* 获取退货确认时间 [确认时间]
* @return 退货确认时间 [确认时间]
*/
public Date getConfirmTime() {
return this.confirmTime;
}
/**
* 设置退货确认时间 [确认时间]
* @param confirmTime
*/
public void setConfirmTime(Date confirmTime) {
this.confirmTime=confirmTime;
}
/** 退货确认方式 [确认方式,若多个方式，逗号分隔] */
private String confirmType;
/**
* 获取退货确认方式 [确认方式,若多个方式，逗号分隔]
* @return 退货确认方式 [确认方式,若多个方式，逗号分隔]
*/
public String getConfirmType() {
return this.confirmType;
}
/**
* 设置退货确认方式 [确认方式,若多个方式，逗号分隔]
* @param confirmType
*/
public void setConfirmType(String confirmType) {
this.confirmType=confirmType;
}
/** 退货确认备注 [退货确认备注] */
private String confirmRemark;
/**
* 获取退货确认备注 [退货确认备注]
* @return 退货确认备注 [退货确认备注]
*/
public String getConfirmRemark() {
return this.confirmRemark;
}
/**
* 设置退货确认备注 [退货确认备注]
* @param confirmRemark
*/
public void setConfirmRemark(String confirmRemark) {
this.confirmRemark=confirmRemark;
}
/** 入库人ID [入库人ID] */
private String inboundUid;
/**
* 获取入库人ID [入库人ID]
* @return 入库人ID [入库人ID]
*/
public String getInboundUid() {
return this.inboundUid;
}
/**
* 设置入库人ID [入库人ID]
* @param inboundUid
*/
public void setInboundUid(String inboundUid) {
this.inboundUid=inboundUid;
}
/** 入库人名称 [入库人名称] */
private String inboundUname;
/**
* 获取入库人名称 [入库人名称]
* @return 入库人名称 [入库人名称]
*/
public String getInboundUname() {
return this.inboundUname;
}
/**
* 设置入库人名称 [入库人名称]
* @param inboundUname
*/
public void setInboundUname(String inboundUname) {
this.inboundUname=inboundUname;
}
/** 入库时间 [入库时间] */
private Date inboundTime;
/**
* 获取入库时间 [入库时间]
* @return 入库时间 [入库时间]
*/
public Date getInboundTime() {
return this.inboundTime;
}
/**
* 设置入库时间 [入库时间]
* @param inboundTime
*/
public void setInboundTime(Date inboundTime) {
this.inboundTime=inboundTime;
}
/** 买家退货状态 [退货状态，CodeMaster] */
private String buyerReturnStatus;
/**
* 获取买家退货状态 [退货状态，CodeMaster]
* @return 买家退货状态 [退货状态，CodeMaster]
*/
public String getBuyerReturnStatus() {
return this.buyerReturnStatus;
}
/**
* 设置买家退货状态 [退货状态，CodeMaster]
* @param buyerReturnStatus
*/
public void setBuyerReturnStatus(String buyerReturnStatus) {
this.buyerReturnStatus=buyerReturnStatus;
}
/** 退货原因照片1 [退货原因照片1] */
private String image1;
/**
* 获取退货原因照片1 [退货原因照片1]
* @return 退货原因照片1 [退货原因照片1]
*/
public String getImage1() {
return this.image1;
}
/**
* 设置退货原因照片1 [退货原因照片1]
* @param image1
*/
public void setImage1(String image1) {
this.image1=image1;
}
/** 退货原因照片2 [退货原因照片2] */
private String image2;
/**
* 获取退货原因照片2 [退货原因照片2]
* @return 退货原因照片2 [退货原因照片2]
*/
public String getImage2() {
return this.image2;
}
/**
* 设置退货原因照片2 [退货原因照片2]
* @param image2
*/
public void setImage2(String image2) {
this.image2=image2;
}
/** 退货原因照片3 [退货原因照片3] */
private String image3;
/**
* 获取退货原因照片3 [退货原因照片3]
* @return 退货原因照片3 [退货原因照片3]
*/
public String getImage3() {
return this.image3;
}
/**
* 设置退货原因照片3 [退货原因照片3]
* @param image3
*/
public void setImage3(String image3) {
this.image3=image3;
}
/** 退货原因照片4 [退货原因照片4] */
private String image4;
/**
* 获取退货原因照片4 [退货原因照片4]
* @return 退货原因照片4 [退货原因照片4]
*/
public String getImage4() {
return this.image4;
}
/**
* 设置退货原因照片4 [退货原因照片4]
* @param image4
*/
public void setImage4(String image4) {
this.image4=image4;
}
/** 退货原因照片5 [退货原因照片5] */
private String image5;
/**
* 获取退货原因照片5 [退货原因照片5]
* @return 退货原因照片5 [退货原因照片5]
*/
public String getImage5() {
return this.image5;
}
/**
* 设置退货原因照片5 [退货原因照片5]
* @param image5
*/
public void setImage5(String image5) {
this.image5=image5;
}
}
