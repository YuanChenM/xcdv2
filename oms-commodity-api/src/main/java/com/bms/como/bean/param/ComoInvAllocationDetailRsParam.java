package com.bms.como.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by yuan_zhifei on 2017/4/1.
 */
@ApiModel(value = "ComoInvAllocationDetailRsParam", description = "库存划拨单明细接口入参")
public class ComoInvAllocationDetailRsParam implements Serializable {
    @ApiModelProperty(value = "划拨单ID")
    private Long allocationId;
    @ApiModelProperty(value = "目标商品ID")
    private Long targetCommodityId;
    @ApiModelProperty(value = "原商品ID")
    private Long originalCommodityId;
    @ApiModelProperty(value = "货主类型")
    private String ownerType;
    @ApiModelProperty(value = "货主ID")
    private String ownerId;
    @ApiModelProperty(value = "货主编码")
    private String ownerCode;
    @ApiModelProperty(value = "货主名称")
    private String ownerName;
    @ApiModelProperty(value = "SKU编码")
    private String skuCode;
    @ApiModelProperty(value = "采购批次")
    private String lotNo;
    @ApiModelProperty(value = "单位")
    private String uom;
    @ApiModelProperty(value = "库存状态")
    private String inventoryStu;
    @ApiModelProperty(value = "库存数量")
    private java.math.BigDecimal inventoryQty;
    @ApiModelProperty(value = "计划数量")
    private java.math.BigDecimal planQty;
    @ApiModelProperty(value = "实际执行数量")
    private java.math.BigDecimal factQty;
    @ApiModelProperty(value = "目标商品ID集合")
    private Long[] targetCommodityIds;

    public Long getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(Long allocationId) {
        this.allocationId = allocationId;
    }

    public Long getTargetCommodityId() {
        return targetCommodityId;
    }

    public void setTargetCommodityId(Long targetCommodityId) {
        this.targetCommodityId = targetCommodityId;
    }

    public Long getOriginalCommodityId() {
        return originalCommodityId;
    }

    public void setOriginalCommodityId(Long originalCommodityId) {
        this.originalCommodityId = originalCommodityId;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
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

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getInventoryStu() {
        return inventoryStu;
    }

    public void setInventoryStu(String inventoryStu) {
        this.inventoryStu = inventoryStu;
    }

    public BigDecimal getInventoryQty() {
        return inventoryQty;
    }

    public void setInventoryQty(BigDecimal inventoryQty) {
        this.inventoryQty = inventoryQty;
    }

    public BigDecimal getPlanQty() {
        return planQty;
    }

    public void setPlanQty(BigDecimal planQty) {
        this.planQty = planQty;
    }

    public BigDecimal getFactQty() {
        return factQty;
    }

    public void setFactQty(BigDecimal factQty) {
        this.factQty = factQty;
    }

    public Long[] getTargetCommodityIds() {
        return targetCommodityIds;
    }

    public void setTargetCommodityIds(Long[] targetCommodityIds) {
        this.targetCommodityIds = targetCommodityIds;
    }
}
