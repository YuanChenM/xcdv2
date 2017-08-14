package com.bms.puch.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by guan_zhongheng on 2017/3/20.
 */
@ApiModel(value = "PuchDetailRestResult", description = "采购入库单详情返回结果类")
public class PuchDetailRestResult implements Serializable{
    @ApiModelProperty(value = "序列号")
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "入库明细ID")
    private Long deliverDetailId;
    @ApiModelProperty(value = "入库ID")
    private Long deliverId;
    @ApiModelProperty(value = "采购单号")
    private String orderCode;
    @ApiModelProperty(value = "采购类型,CodeMaster")
    private String orderType;
    @ApiModelProperty(value = "计划入库单号")
    private String scheduleCode;
    @ApiModelProperty(value = "计划入库时间")
    private java.util.Date scheduleDate;
    @ApiModelProperty(value = "仓库ID")
    private Long whId;
    @ApiModelProperty(value = "仓库编码")
    private String whCode;
    @ApiModelProperty(value = "仓库名称")
    private String whName;
    @ApiModelProperty(value = "与仓库实物产品SKU一致")
    private String materialCode;
    @ApiModelProperty(value = "与仓库实物产品名称一致")
    private String materialName;
    @ApiModelProperty(value = "商品ID")
    private Long commodityId;
    @ApiModelProperty(value = "商品编码")
    private String commodityCode;
    @ApiModelProperty(value = "商品名称")
    private String commodityName;
    @ApiModelProperty(value = "入库产品单位")
    private String unit;
    @ApiModelProperty(value = "入库批次")
    private String lotNo;
    @ApiModelProperty(value = "销售标签,默认值可考虑设常量，与商品管理中一致")
    private String salesLabel;
    @ApiModelProperty(value = "入库仓库状态,默认值可考虑设常量，与库存管理中保持一致")
    private String inventoryStatus;
    @ApiModelProperty(value = "入库数量")
    private java.math.BigDecimal receiveQty;
    @ApiModelProperty(value = "入库价格")
    private java.math.BigDecimal receivePrice;
    @ApiModelProperty(value = "入库时间")
    private java.util.Date inboundDate;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getDeliverDetailId() {
        return deliverDetailId;
    }

    public void setDeliverDetailId(Long deliverDetailId) {
        this.deliverDetailId = deliverDetailId;
    }

    public Long getDeliverId() {
        return deliverId;
    }

    public void setDeliverId(Long deliverId) {
        this.deliverId = deliverId;
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

    public String getScheduleCode() {
        return scheduleCode;
    }

    public void setScheduleCode(String scheduleCode) {
        this.scheduleCode = scheduleCode;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Long getWhId() {
        return whId;
    }

    public void setWhId(Long whId) {
        this.whId = whId;
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public String getSalesLabel() {
        return salesLabel;
    }

    public void setSalesLabel(String salesLabel) {
        this.salesLabel = salesLabel;
    }

    public String getInventoryStatus() {
        return inventoryStatus;
    }

    public void setInventoryStatus(String inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
    }

    public BigDecimal getReceiveQty() {
        return receiveQty;
    }

    public void setReceiveQty(BigDecimal receiveQty) {
        this.receiveQty = receiveQty;
    }

    public BigDecimal getReceivePrice() {
        return receivePrice;
    }

    public void setReceivePrice(BigDecimal receivePrice) {
        this.receivePrice = receivePrice;
    }

    public Date getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(Date inboundDate) {
        this.inboundDate = inboundDate;
    }
}
