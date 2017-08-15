package com.bms.slpd.bean.param.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value = "SLPD0505IBrandItemPropertyParam", description = "品牌单品规格参数")
public class SLPD0505IBrandItemPropertyParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "单品品牌规格ID")
    private Long brandItemPropertyId;
    @ApiModelProperty(value = "质量等级")
    private String qualityGradeType;
    @ApiModelProperty(value = "单品品牌ID")
    private Long brandItemId;
    @ApiModelProperty(value = "货源，1：国产，2：进口")
    private String sourceType;
    @ApiModelProperty(value = "毛重（克）")
    private BigDecimal grossWeight;
    @ApiModelProperty(value = "净重（克）")
    private BigDecimal netWeight;
    @ApiModelProperty(value = "包装规格")
    private String packageSpecification;
    @ApiModelProperty(value = "包装数量")
    private Integer packageQuantity;
    @ApiModelProperty(value = "纸箱尺寸（cm），长*宽*高")
    private String cartonDimension;
    @ApiModelProperty(value = "纸箱长度（cm）")
    private Integer cartonLength;
    @ApiModelProperty(value = "纸箱宽度（cm）")
    private Integer cartonWidth;
    @ApiModelProperty(value = "纸箱高度（cm）")
    private Integer cartonHeight;
    @ApiModelProperty(value = "托盘堆码数（箱）")
    private Integer palletStackingLimit;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;

    public Long getBrandItemPropertyId() {
        return brandItemPropertyId;
    }

    public void setBrandItemPropertyId(Long brandItemPropertyId) {
        this.brandItemPropertyId = brandItemPropertyId;
    }

    public String getQualityGradeType() {
        return qualityGradeType;
    }

    public void setQualityGradeType(String qualityGradeType) {
        this.qualityGradeType = qualityGradeType;
    }

    public Long getBrandItemId() {
        return brandItemId;
    }

    public void setBrandItemId(Long brandItemId) {
        this.brandItemId = brandItemId;
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

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
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

    public Integer getCartonLength() {
        return cartonLength;
    }

    public void setCartonLength(Integer cartonLength) {
        this.cartonLength = cartonLength;
    }

    public Integer getCartonWidth() {
        return cartonWidth;
    }

    public void setCartonWidth(Integer cartonWidth) {
        this.cartonWidth = cartonWidth;
    }

    public Integer getCartonHeight() {
        return cartonHeight;
    }

    public void setCartonHeight(Integer cartonHeight) {
        this.cartonHeight = cartonHeight;
    }

    public Integer getPalletStackingLimit() {
        return palletStackingLimit;
    }

    public void setPalletStackingLimit(Integer palletStackingLimit) {
        this.palletStackingLimit = palletStackingLimit;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
