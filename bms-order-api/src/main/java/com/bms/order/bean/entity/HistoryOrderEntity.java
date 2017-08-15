package com.bms.order.bean.entity;
import com.framework.base.rest.entity.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;
public class HistoryOrderEntity extends BaseEntity {
private static final long serialVersionUID = 1L;
/** 历史ID */
private Long historyId;
/**
* 获取历史ID
* @return 历史ID
*/
public Long getHistoryId() {
return this.historyId;
}
/**
* 设置历史ID
* @param historyId
*/
public void setHistoryId(Long historyId) {
this.historyId=historyId;
}
/** 订单ID */
private Long orderId;
/**
* 获取订单ID
* @return 订单ID
*/
public Long getOrderId() {
return this.orderId;
}
/**
* 设置订单ID
* @param orderId
*/
public void setOrderId(Long orderId) {
this.orderId=orderId;
}
/** 发货单ID */
private Long shipId;
/**
* 获取发货单ID
* @return 发货单ID
*/
public Long getShipId() {
return this.shipId;
}
/**
* 设置发货单ID
* @param shipId
*/
public void setShipId(Long shipId) {
this.shipId=shipId;
}
/** 订单编码 */
private String orderCode;
/**
* 获取订单编码
* @return 订单编码
*/
public String getOrderCode() {
return this.orderCode;
}
/**
* 设置订单编码
* @param orderCode
*/
public void setOrderCode(String orderCode) {
this.orderCode=orderCode;
}
/** 订单类型 */
private String orderType;
/**
* 获取订单类型
* @return 订单类型
*/
public String getOrderType() {
return this.orderType;
}
/**
* 设置订单类型
* @param orderType
*/
public void setOrderType(String orderType) {
this.orderType=orderType;
}
/** 订单创建时间 */
private Date orderTime;

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /** 订单状态 */
private String orderStatus;
/**
* 获取订单状态
* @return 订单状态
*/
public String getOrderStatus() {
return this.orderStatus;
}
/**
* 设置订单状态
* @param orderStatus
*/
public void setOrderStatus(String orderStatus) {
this.orderStatus=orderStatus;
}
/** 买家编码 */
private String buyerCode;
/**
* 获取买家编码
* @return 买家编码
*/
public String getBuyerCode() {
return this.buyerCode;
}
/**
* 设置买家编码
* @param buyerCode
*/
public void setBuyerCode(String buyerCode) {
this.buyerCode=buyerCode;
}
/** 买家名称 */
private String buyerName;
/**
* 获取买家名称
* @return 买家名称
*/
public String getBuyerName() {
return this.buyerName;
}
/**
* 设置买家名称
* @param buyerName
*/
public void setBuyerName(String buyerName) {
this.buyerName=buyerName;
}
/** 买家类型 */
private String buyerType;
/**
* 获取买家类型
* @return 买家类型
*/
public String getBuyerType() {
return this.buyerType;
}
/**
* 设置买家类型
* @param buyerType
*/
public void setBuyerType(String buyerType) {
this.buyerType=buyerType;
}
/** 市场 */
private String market;
/**
* 获取市场
* @return 市场
*/
public String getMarket() {
return this.market;
}
/**
* 设置市场
* @param market
*/
public void setMarket(String market) {
this.market=market;
}
/** 收货地址 */
private String receiverAddress;
/**
* 获取收货地址
* @return 收货地址
*/
public String getReceiverAddress() {
return this.receiverAddress;
}
/**
* 设置收货地址
* @param receiverAddress
*/
public void setReceiverAddress(String receiverAddress) {
this.receiverAddress=receiverAddress;
}
/** 电话 */
private String receiverTel;
/**
* 获取电话
* @return 电话
*/
public String getReceiverTel() {
return this.receiverTel;
}
/**
* 设置电话
* @param receiverTel
*/
public void setReceiverTel(String receiverTel) {
this.receiverTel=receiverTel;
}
/** 冻品管家 */
private String frozenGoodsHouseKeep;
/**
* 获取冻品管家
* @return 冻品管家
*/
public String getFrozenGoodsHouseKeep() {
return this.frozenGoodsHouseKeep;
}
/**
* 设置冻品管家
* @param frozenGoodsHouseKeep
*/
public void setFrozenGoodsHouseKeep(String frozenGoodsHouseKeep) {
this.frozenGoodsHouseKeep=frozenGoodsHouseKeep;
}
/** 订单总金额 */
private BigDecimal orderAmount;
/**
* 获取订单总金额
* @return 订单总金额
*/
public BigDecimal getOrderAmount() {
return this.orderAmount;
}
/**
* 设置订单总金额
* @param orderAmount
*/
public void setOrderAmount(BigDecimal orderAmount) {
this.orderAmount=orderAmount;
}
/** 订单明细ID */
private Long orderDetailId;
/**
* 获取订单明细ID
* @return 订单明细ID
*/
public Long getOrderDetailId() {
return this.orderDetailId;
}
/**
* 设置订单明细ID
* @param orderDetailId
*/
public void setOrderDetailId(Long orderDetailId) {
this.orderDetailId=orderDetailId;
}
/** 产品类型 */
private String classCode;
/**
* 获取产品类型
* @return 产品类型
*/
public String getClassCode() {
return this.classCode;
}
/**
* 设置产品类型
* @param classCode
*/
public void setClassCode(String classCode) {
this.classCode=classCode;
}
/** 产品类型名称 */
private String className;
/**
* 获取产品类型名称
* @return 产品类型名称
*/
public String getClassName() {
return this.className;
}
/**
* 设置产品类型名称
* @param className
*/
public void setClassName(String className) {
this.className=className;
}
/** 产品品种 */
private String breedCode;
/**
* 获取产品品种
* @return 产品品种
*/
public String getBreedCode() {
return this.breedCode;
}
/**
* 设置产品品种
* @param breedCode
*/
public void setBreedCode(String breedCode) {
this.breedCode=breedCode;
}
/** 产品品种名称 */
private String breedName;
/**
* 获取产品品种名称
* @return 产品品种名称
*/
public String getBreedName() {
return this.breedName;
}
/**
* 设置产品品种名称
* @param breedName
*/
public void setBreedName(String breedName) {
this.breedName=breedName;
}
/** 特征编码 */
private String featureCode;
/**
* 获取特征编码
* @return 特征编码
*/
public String getFeatureCode() {
return this.featureCode;
}
/**
* 设置特征编码
* @param featureCode
*/
public void setFeatureCode(String featureCode) {
this.featureCode=featureCode;
}
/** 特征名称 */
private String featureName;
/**
* 获取特征名称
* @return 特征名称
*/
public String getFeatureName() {
return this.featureName;
}
/**
* 设置特征名称
* @param featureName
*/
public void setFeatureName(String featureName) {
this.featureName=featureName;
}
/** 产品包装名称 */
private String normsName;
/**
* 获取产品包装名称
* @return 产品包装名称
*/
public String getNormsName() {
return this.normsName;
}
/**
* 设置产品包装名称
* @param normsName
*/
public void setNormsName(String normsName) {
this.normsName=normsName;
}
/** 产品编码 */
private String pdCode;
/**
* 获取产品编码
* @return 产品编码
*/
public String getPdCode() {
return this.pdCode;
}
/**
* 设置产品编码
* @param pdCode
*/
public void setPdCode(String pdCode) {
this.pdCode=pdCode;
}
/** 产品名称 */
private String pdName;
/**
* 获取产品名称
* @return 产品名称
*/
public String getPdName() {
return this.pdName;
}
/**
* 设置产品名称
* @param pdName
*/
public void setPdName(String pdName) {
this.pdName=pdName;
}
/** 产品等级名称 */
private String pdGradeName;
/**
* 获取产品等级名称
* @return 产品等级名称
*/
public String getPdGradeName() {
return this.pdGradeName;
}
/**
* 设置产品等级名称
* @param pdGradeName
*/
public void setPdGradeName(String pdGradeName) {
this.pdGradeName=pdGradeName;
}
/** 产品单价 */
private BigDecimal price;
/**
* 获取产品单价
* @return 产品单价
*/
public BigDecimal getPrice() {
return this.price;
}
/**
* 设置产品单价
* @param price
*/
public void setPrice(BigDecimal price) {
this.price=price;
}
/** 订单数量 */
private BigDecimal orderQty;
/**
* 获取订单数量
* @return 订单数量
*/
public BigDecimal getOrderQty() {
return this.orderQty;
}
/**
* 设置订单数量
* @param orderQty
*/
public void setOrderQty(BigDecimal orderQty) {
this.orderQty=orderQty;
}
/** 订单明细金额 */
private BigDecimal orderDetailAmount;
/**
* 获取订单明细金额
* @return 订单明细金额
*/
public BigDecimal getOrderDetailAmount() {
return this.orderDetailAmount;
}
/**
* 设置订单明细金额
* @param orderDetailAmount
*/
public void setOrderDetailAmount(BigDecimal orderDetailAmount) {
this.orderDetailAmount=orderDetailAmount;
}
/** 供应商名称 */
private String supplierName;
/**
* 获取供应商名称
* @return 供应商名称
*/
public String getSupplierName() {
return this.supplierName;
}
/**
* 设置供应商名称
* @param supplierName
*/
public void setSupplierName(String supplierName) {
this.supplierName=supplierName;
}
/** 供货数量 */
private BigDecimal suppQty;
/**
* 获取供货数量
* @return 供货数量
*/
public BigDecimal getSuppQty() {
return this.suppQty;
}
/**
* 设置供货数量
* @param suppQty
*/
public void setSuppQty(BigDecimal suppQty) {
this.suppQty=suppQty;
}
/** 发货数量 */
private BigDecimal sendQty;
/**
* 获取发货数量
* @return 发货数量
*/
public BigDecimal getSendQty() {
return this.sendQty;
}
/**
* 设置发货数量
* @param sendQty
*/
public void setSendQty(BigDecimal sendQty) {
this.sendQty=sendQty;
}
/** 收货数量 */
private BigDecimal receiveQty;
/**
* 获取收货数量
* @return 收货数量
*/
public BigDecimal getReceiveQty() {
return this.receiveQty;
}
/**
* 设置收货数量
* @param receiveQty
*/
public void setReceiveQty(BigDecimal receiveQty) {
this.receiveQty=receiveQty;
}
/** 取消数量 */
private BigDecimal cancelQty;
/**
* 获取取消数量
* @return 取消数量
*/
public BigDecimal getCancelQty() {
return this.cancelQty;
}
/**
* 设置取消数量
* @param cancelQty
*/
public void setCancelQty(BigDecimal cancelQty) {
this.cancelQty=cancelQty;
}
/** 退货数量 */
private BigDecimal returnQty;
/**
* 获取退货数量
* @return 退货数量
*/
public BigDecimal getReturnQty() {
return this.returnQty;
}
/**
* 设置退货数量
* @param returnQty
*/
public void setReturnQty(BigDecimal returnQty) {
this.returnQty=returnQty;
}
/** 拒收数量 */
private BigDecimal rejectionQty;
/**
* 获取拒收数量
* @return 拒收数量
*/
public BigDecimal getRejectionQty() {
return this.rejectionQty;
}
/**
* 设置拒收数量
* @param rejectionQty
*/
public void setRejectionQty(BigDecimal rejectionQty) {
this.rejectionQty=rejectionQty;
}
/** 发货时间 */
private Date sendTime;
/**
* 获取发货时间
* @return 发货时间
*/
public Date getSendTime() {
return this.sendTime;
}
/**
* 设置发货时间
* @param sendTime
*/
public void setSendTime(Date sendTime) {
this.sendTime=sendTime;
}
/** 收货时间 */
private Date receivedTime;
/**
* 获取收货时间
* @return 收货时间
*/
public Date getReceivedTime() {
return this.receivedTime;
}
/**
* 设置收货时间
* @param receivedTime
*/
public void setReceivedTime(Date receivedTime) {
this.receivedTime=receivedTime;
}
/** 销售人 */
private String salesParty;
/**
* 获取销售人
* @return 销售人
*/
public String getSalesParty() {
return this.salesParty;
}
/**
* 设置销售人
* @param salesParty
*/
public void setSalesParty(String salesParty) {
this.salesParty=salesParty;
}
/** 订单来源 */
private String orderSource;
/**
* 获取订单来源
* @return 订单来源
*/
public String getOrderSource() {
return this.orderSource;
}
/**
* 设置订单来源
* @param orderSource
*/
public void setOrderSource(String orderSource) {
this.orderSource=orderSource;
}
}
