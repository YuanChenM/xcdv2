package com.bms.slpd.bean.result.field;

import com.framework.base.rest.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class SLPD1815IItemPropertyResult extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "单品规格ID")
    private Long itemPropertyId;
    @ApiModelProperty(value = "单品规格编码")
    private String itemPropertyCode;
    @ApiModelProperty(value = "单品ID")
    private Long itemId;
    @ApiModelProperty(value = "货源，1：国产，2：进口")
    private String sourceType;
    @ApiModelProperty(value = "货源")
    private String sourceTypeStr;
    @ApiModelProperty(value = "毛重（克）")
    private java.math.BigDecimal grossWeight;
    @ApiModelProperty(value = "包装规格")
    private String packageSpecification;
    @ApiModelProperty(value = "包装数量")
    private Integer packageQuantity;
    @ApiModelProperty(value = "纸箱尺寸（cm），长*宽*高")
    private String cartonDimension;
    @ApiModelProperty(value = "纸箱长度（cm）")
    private java.math.BigDecimal cartonLength;
    @ApiModelProperty(value = "纸箱宽度（cm）")
    private java.math.BigDecimal cartonWidth;
    @ApiModelProperty(value = "纸箱高度（cm）")
    private java.math.BigDecimal cartonHeight;
    @ApiModelProperty(value = "托盘堆码数（箱）")
    private Integer palletStackingLimit;
    @ApiModelProperty(value = "审核状态，0：待审核，1：正式")
    private String auditStu;
    @ApiModelProperty(value = "审核状态")
    private String auditStuStr;

    public Long getItemPropertyId() {
        return itemPropertyId;
    }

    public void setItemPropertyId(Long itemPropertyId) {
        this.itemPropertyId = itemPropertyId;
    }

    public String getItemPropertyCode() {
        return itemPropertyCode;
    }

    public void setItemPropertyCode(String itemPropertyCode) {
        this.itemPropertyCode = itemPropertyCode;
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

    public String getSourceTypeStr() {
        return sourceTypeStr;
    }

    public void setSourceTypeStr(String sourceTypeStr) {
        this.sourceTypeStr = sourceTypeStr;
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

    public String getAuditStu() {
        return auditStu;
    }

    public void setAuditStu(String auditStu) {
        this.auditStu = auditStu;
    }

    public String getAuditStuStr() {
        return auditStuStr;
    }

    public void setAuditStuStr(String auditStuStr) {
        this.auditStuStr = auditStuStr;
    }
}
