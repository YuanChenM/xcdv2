package com.bms.linv.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value = "LINV0113IResult", description = "批量查询货权人商品库存的出参")
public class LINV0113IResult implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "物流区域ID")
    private String logisticsId;
    @ApiModelProperty(value = "物流区域CODE")
    private String logisticsCode;
    @ApiModelProperty(value = "物流区域NAME")
    private String logisticsName;
    @ApiModelProperty(value = "销售平台")
    private String salePlatform;
    @ApiModelProperty(value = "货主ID")
    private String ownerId;
    @ApiModelProperty(value = "货主编码")
    private String ownerCode;
    @ApiModelProperty(value = "货主名称")
    private String ownerName;
    @ApiModelProperty(value = "货主类型")
    private String ownerType;
    @ApiModelProperty(value = "商品Id")
    private String commodityId;
    @ApiModelProperty(value = "库存类型")
    private String ivType;
    @ApiModelProperty(value = "商品库存类型")
    private String comoIvType;
    @ApiModelProperty(value = "商品名称")
    private String commodityName;
    @ApiModelProperty(value = "产品ID")
    private String pdId;
    @ApiModelProperty(value = "销售状态ID")
    private Long saleStatusId;
    @ApiModelProperty(value = "销售状态编码")
    private String saleStatusCode;
    @ApiModelProperty(value = "销售状态名称")
    private String saleStatusName;
    @ApiModelProperty(value = "单位")
    private String uom;
    @ApiModelProperty(value = "总数量")
    private BigDecimal totalQty;
    @ApiModelProperty(value = "在库数量")
    private BigDecimal onhandQty;
    @ApiModelProperty(value = "虚拟数量")
    private BigDecimal bufferQty;
    @ApiModelProperty(value = "占用数量")
    private BigDecimal allocatedQty;
    @ApiModelProperty(value = "可用数量")
    private BigDecimal availableQty;


    public String getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getSalePlatform() {
        return salePlatform;
    }

    public void setSalePlatform(String salePlatform) {
        this.salePlatform = salePlatform;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getIvType() {
        return ivType;
    }

    public void setIvType(String ivType) {
        this.ivType = ivType;
    }

    public Long getSaleStatusId() {
        return saleStatusId;
    }

    public void setSaleStatusId(Long saleStatusId) {
        this.saleStatusId = saleStatusId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSaleStatusCode() {
        return saleStatusCode;
    }

    public void setSaleStatusCode(String saleStatusCode) {
        this.saleStatusCode = saleStatusCode;
    }

    public String getSaleStatusName() {
        return saleStatusName;
    }

    public void setSaleStatusName(String saleStatusName) {
        this.saleStatusName = saleStatusName;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public BigDecimal getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(BigDecimal totalQty) {
        this.totalQty = totalQty;
    }

    public BigDecimal getOnhandQty() {
        return onhandQty;
    }

    public void setOnhandQty(BigDecimal onhandQty) {
        this.onhandQty = onhandQty;
    }

    public BigDecimal getBufferQty() {
        return bufferQty;
    }

    public void setBufferQty(BigDecimal bufferQty) {
        this.bufferQty = bufferQty;
    }

    public BigDecimal getAllocatedQty() {
        return allocatedQty;
    }

    public void setAllocatedQty(BigDecimal allocatedQty) {
        this.allocatedQty = allocatedQty;
    }

    public BigDecimal getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(BigDecimal availableQty) {
        this.availableQty = availableQty;
    }

    public String getComoIvType() {
        return comoIvType;
    }

    public void setComoIvType(String comoIvType) {
        this.comoIvType = comoIvType;
    }

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getPdId() {
        return pdId;
    }

    public void setPdId(String pdId) {
        this.pdId = pdId;
    }
}
