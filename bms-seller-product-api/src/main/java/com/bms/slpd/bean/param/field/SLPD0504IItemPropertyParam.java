package com.bms.slpd.bean.param.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value = "SLPD0504IItemPropertyParam", description = "单品规格参数")
public class SLPD0504IItemPropertyParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "单品规格ID")
    private Long itemPropertyId;
    @ApiModelProperty(value = "单品ID")
    private Long itemId;
    @ApiModelProperty(value = "货源，1：国产，2：进口")
    private String sourceType;
    @ApiModelProperty(value = "毛重（克）")
    private BigDecimal grossWeight;
    @ApiModelProperty(value = "包装规格")
    private String packageSpecification;
    @ApiModelProperty(value = "包装数量")
    private Integer packageQuantity;
    @ApiModelProperty(value = "纸箱尺寸（cm），长*宽*高")
    private String cartonDimension;
    @ApiModelProperty(value = "纸箱长度（cm）")
    private BigDecimal cartonLength;
    @ApiModelProperty(value = "纸箱宽度（cm）")
    private BigDecimal cartonWidth;
    @ApiModelProperty(value = "纸箱高度（cm）")
    private BigDecimal cartonHeight;
    @ApiModelProperty(value = "托盘堆码数（箱）")
    private Integer palletStackingLimit;

    public Long getItemPropertyId() {
        return itemPropertyId;
    }

    public void setItemPropertyId(Long itemPropertyId) {
        this.itemPropertyId = itemPropertyId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getPackageSpecification() {
        return packageSpecification;
    }

    public void setPackageSpecification(String packageSpecification) {
        this.packageSpecification = packageSpecification;
    }

    public Integer getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(Integer packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    public String getCartonDimension() {
        return cartonDimension;
    }

    public void setCartonDimension(String cartonDimension) {
        this.cartonDimension = cartonDimension;
    }

    public BigDecimal getCartonLength() {
        return cartonLength;
    }

    public void setCartonLength(BigDecimal cartonLength) {
        this.cartonLength = cartonLength;
    }

    public BigDecimal getCartonWidth() {
        return cartonWidth;
    }

    public void setCartonWidth(BigDecimal cartonWidth) {
        this.cartonWidth = cartonWidth;
    }

    public BigDecimal getCartonHeight() {
        return cartonHeight;
    }

    public void setCartonHeight(BigDecimal cartonHeight) {
        this.cartonHeight = cartonHeight;
    }

    public Integer getPalletStackingLimit() {
        return palletStackingLimit;
    }

    public void setPalletStackingLimit(Integer palletStackingLimit) {
        this.palletStackingLimit = palletStackingLimit;
    }
}
