package com.bms.puch.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by guan_zhongheng on 2017/3/16.
 */
@ApiModel(value = "PuchDetailParam",
        description = "入库单明细")
@XmlRootElement(name = "detail")
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class PuchDetailParam implements Serializable{

    @ApiModelProperty(value = "明细行ID")
    @XmlElement(name = "itemNo")
    private String itemNo;

    @ApiModelProperty(value = "入库明细ID")
    @XmlElement(name = "deliverDetailId")
    private Long deliverDetailId;

    @ApiModelProperty(value = "入库ID")
    @XmlElement(name = "deliverId")
    private Long deliverId;

    @ApiModelProperty(value = "采购单号")
    @XmlElement(name = "orderCode")
    private String orderCode;

    @ApiModelProperty(value = "采购类型,CodeMaster")
    @XmlElement(name = "orderType")
    private String orderType;

    @ApiModelProperty(value = "仓库ID")
    @XmlElement(name = "whId")
    private Long whId;

    @ApiModelProperty(value = "仓库编码")
    @XmlElement(name = "whCode")
    private String whCode;

    @ApiModelProperty(value = "仓库名称")
    @XmlElement(name = "whName")
    private String whName;

    @ApiModelProperty(value = "与仓库实物产品SKU一致")
    @XmlElement(name = "materialCode")
    private String materialCode;

    @ApiModelProperty(value = "与仓库实物产品名称一致")
    @XmlElement(name = "materialName")
    private String materialName;

    @ApiModelProperty(value = "商品ID")
    @XmlElement(name = "commodityId")
    private Long commodityId;

    @ApiModelProperty(value = "商品编码")
    @XmlElement(name = "commodityCode")
    private String commodityCode;

    @ApiModelProperty(value = "商品名称")
    @XmlElement(name = "commodityName")
    private String commodityName;

    @ApiModelProperty(value = "入库产品单位")
    @XmlElement(name = "unit")
    private String unit;

    @ApiModelProperty(value = "入库批次")
    @XmlElement(name = "lotNo")
    private String lotNo;

    @ApiModelProperty(value = "销售标签,默认值可考虑设常量，与商品管理中一致")
    @XmlElement(name = "salesLabel")
    private String salesLabel;

    @ApiModelProperty(value = "入库仓库状态,默认值可考虑设常量，与库存管理中保持一致")
    @XmlElement(name = "inventoryStatus")
    private String inventoryStatus;

    @ApiModelProperty(value = "入库数量")
    @XmlElement(name = "receiveQty")
    private BigDecimal receiveQty;

    @ApiModelProperty(value = "入库价格")
    @XmlElement(name = "receivePrice")
    private BigDecimal receivePrice;

    @ApiModelProperty(value = "入库时间")
    @XmlElement(name = "inboundDate")
    private Date inboundDate;

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
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
