package com.bms.order.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * 历史订单查询接口Param
 *
 * @author sun_jiaju
 */
@ApiModel(value = "ORDR1201IRestParam", description = "历史订单查询接口条件")
public class ORDR1201IRestParam extends BaseRestPaginationParam {
    @ApiModelProperty(value = "订单ID")
    private Long orderId;
    @ApiModelProperty(value = "发货单ID")
    private Long shipId;
    @ApiModelProperty(value = "订单编码")
    private String orderCode;
    @ApiModelProperty(value = "订单类型")
    private String orderType;
    @ApiModelProperty(value = "订单创建开始时间")
    private String orderTimeStart;
    @ApiModelProperty(value = "订单创建结束时间")
    private String orderTimeEnd;
    @ApiModelProperty(value = "订单状态")
    private String orderStatus;
    @ApiModelProperty(value = "买家编码")
    private String buyerCode;
    @ApiModelProperty(value = "买家名称")
    private String buyerName;
    @ApiModelProperty(value = "买家类型")
    private String buyerType;
    @ApiModelProperty(value = "市场")
    private String market;
    @ApiModelProperty(value = "收货地址")
    private String receiverAddress;
    @ApiModelProperty(value = "电话")
    private String receiverTel;
    @ApiModelProperty(value = "冻品管家")
    private String frozenGoodsHouseKeep;
    @ApiModelProperty(value = "订单明细ID")
    private Long orderDetailId;
    @ApiModelProperty(value = "产品类型")
    private String classCode;
    @ApiModelProperty(value = "产品类型名称")
    private String className;
    @ApiModelProperty(value = "产品品种")
    private String breedCode;
    @ApiModelProperty(value = "产品品种名称")
    private String breedName;
    @ApiModelProperty(value = "特征编码")
    private String featureCode;
    @ApiModelProperty(value = "特征名称")
    private String featureName;
    @ApiModelProperty(value = "产品包装名称")
    private String normsName;
    @ApiModelProperty(value = "产品编码")
    private String pdCode;
    @ApiModelProperty(value = "产品名称")
    private String pdName;
    @ApiModelProperty(value = "产品等级名称")
    private String pdGradeName;
    @ApiModelProperty(value = "供应商名称")
    private String supplierName;
    @ApiModelProperty(value = "发货开始时间")
    private String sendTimeStart;
    @ApiModelProperty(value = "发货结束时间")
    private String sendTimeEnd;
    @ApiModelProperty(value = "收货开始时间")
    private String receivedTimeStart;
    @ApiModelProperty(value = "收货结束时间")
    private String receivedTimeEnd;
    @ApiModelProperty(value = "销售人")
    private String salesParty;
    @ApiModelProperty(value = "订单来源")
    private String orderSource;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getBuyerCode() {
        return buyerCode;
    }

    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerType() {
        return buyerType;
    }

    public void setBuyerType(String buyerType) {
        this.buyerType = buyerType;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverTel() {
        return receiverTel;
    }

    public void setReceiverTel(String receiverTel) {
        this.receiverTel = receiverTel;
    }

    public String getFrozenGoodsHouseKeep() {
        return frozenGoodsHouseKeep;
    }

    public void setFrozenGoodsHouseKeep(String frozenGoodsHouseKeep) {
        this.frozenGoodsHouseKeep = frozenGoodsHouseKeep;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getBreedCode() {
        return breedCode;
    }

    public void setBreedCode(String breedCode) {
        this.breedCode = breedCode;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getNormsName() {
        return normsName;
    }

    public void setNormsName(String normsName) {
        this.normsName = normsName;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public String getPdGradeName() {
        return pdGradeName;
    }

    public void setPdGradeName(String pdGradeName) {
        this.pdGradeName = pdGradeName;
    }
    
    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSalesParty() {
        return salesParty;
    }

    public void setSalesParty(String salesParty) {
        this.salesParty = salesParty;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public String getOrderTimeStart() {
        return orderTimeStart;
    }

    public void setOrderTimeStart(String orderTimeStart) {
        this.orderTimeStart = orderTimeStart;
    }

    public String getOrderTimeEnd() {
        return orderTimeEnd;
    }

    public void setOrderTimeEnd(String orderTimeEnd) {
        this.orderTimeEnd = orderTimeEnd;
    }

    public String getSendTimeStart() {
        return sendTimeStart;
    }

    public void setSendTimeStart(String sendTimeStart) {
        this.sendTimeStart = sendTimeStart;
    }

    public String getSendTimeEnd() {
        return sendTimeEnd;
    }

    public void setSendTimeEnd(String sendTimeEnd) {
        this.sendTimeEnd = sendTimeEnd;
    }

    public String getReceivedTimeStart() {
        return receivedTimeStart;
    }

    public void setReceivedTimeStart(String receivedTimeStart) {
        this.receivedTimeStart = receivedTimeStart;
    }

    public String getReceivedTimeEnd() {
        return receivedTimeEnd;
    }

    public void setReceivedTimeEnd(String receivedTimeEnd) {
        this.receivedTimeEnd = receivedTimeEnd;
    }
}
