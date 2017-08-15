package com.bms.slpd.bean.param.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class SLPD1816IProductParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "质量等级，1：A1，2：A2，3：A3")
    private String qualityGradeType;
    @ApiModelProperty(value = "净重")
    private BigDecimal netWeight;
    @ApiModelProperty(value = "单品规格ID")
    private Long itemPropertyId;
    @ApiModelProperty(value = "单品ID")
    private Long itemId;
    @ApiModelProperty(value = "品牌ID")
    private Long brandId;

    public String getQualityGradeType() {
        return qualityGradeType;
    }

    public void setQualityGradeType(String qualityGradeType) {
        this.qualityGradeType = qualityGradeType;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

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

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
}
