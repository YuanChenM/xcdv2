package com.bms.como.bean.result;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class ProductInfoResult implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "产品主键ID ")
    private Long productPid;
    @ApiModelProperty(value = "产品ID ")
    private String productId;
    @ApiModelProperty(value = "一级分类ID ")
    private Long classesId;
    @ApiModelProperty(value = "一级分类编码 ")
    private String classesCode;
    @ApiModelProperty(value = "一级分类名称 ")
    private String classesName;
    @ApiModelProperty(value = "二级分类ID ")
    private Long machiningId;
    @ApiModelProperty(value = "二级分类编码 ")
    private String machiningCode;
    @ApiModelProperty(value = "二级分类名称 ")
    private String machiningName;
    @ApiModelProperty(value = "品种ID ")
    private Long breedId;
    @ApiModelProperty(value = "品种编码 ")
    private String breedCode;
    @ApiModelProperty(value = "品种标准市场销售名 ")
    private String breedSalesName;
    @ApiModelProperty(value = "单品ID ")
    private Long itemId;
    @ApiModelProperty(value = "单品Code ")
    private String itemCode;
    @ApiModelProperty(value = "单品名称 ")
    private String itemName;
    @ApiModelProperty(value = "单品SKU ")
    private String itemSku;
    @ApiModelProperty(value = "品牌ID ")
    private Long brandId;
    @ApiModelProperty(value = "品牌编码 ")
    private String brandCode;
    @ApiModelProperty(value = "品牌名称 ")
    private String brandName;
    @ApiModelProperty(value = "质量等级编码 ")
    private String qualityGradeTypeCode;
    @ApiModelProperty(value = "质量等级，1：A1，2：A2，3：A3 ")
    private String qualityGradeType;
    @ApiModelProperty(value = "质量等级名称")
    private String qualityGradeTypeName;
    @ApiModelProperty(value = "毛重（克） ")
    private java.math.BigDecimal grossWeight;
    @ApiModelProperty(value = "净重编码 ")
    private String netWeightCode;
    @ApiModelProperty(value = "净重（克） ")
    private java.math.BigDecimal netWeight;
    @ApiModelProperty(value = "包装规格，小包装特征 ")
    private String packageSpecification;
    @ApiModelProperty(value = "包装数量，小包装数量 ")
    private Integer packageQuantity;
    @ApiModelProperty(value = "纸箱尺寸（cm），长*宽*高 ")
    private String cartonDimension;
    @ApiModelProperty(value = "托盘堆码数（箱） ")
    private Integer palletStackingLimit;
    @ApiModelProperty(value = "单品品牌规格SKU ")
    private String brandItemPropertySku;
    @ApiModelProperty(value = "规格编码，对应产品系统中单品规格编码")
    private String itemPropertyCode;

    @ApiModelProperty(value = "创建者ID")
    private String crtId;
    @ApiModelProperty(value = "更新者ID")
    private String updId;
    @ApiModelProperty(value = "创建日时")
    private Date crtTime;
    @ApiModelProperty(value = "更新日时")
    private Date updTime;
    @ApiModelProperty(value = "版本号")
    private Integer version;

    public Long getProductPid() {
        return productPid;
    }

    public void setProductPid(Long productPid) {
        this.productPid = productPid;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Long getClassesId() {
        return classesId;
    }

    public void setClassesId(Long classesId) {
        this.classesId = classesId;
    }

    public String getClassesCode() {
        return classesCode;
    }

    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    public Long getMachiningId() {
        return machiningId;
    }

    public void setMachiningId(Long machiningId) {
        this.machiningId = machiningId;
    }

    public String getMachiningCode() {
        return machiningCode;
    }

    public void setMachiningCode(String machiningCode) {
        this.machiningCode = machiningCode;
    }

    public String getMachiningName() {
        return machiningName;
    }

    public void setMachiningName(String machiningName) {
        this.machiningName = machiningName;
    }

    public Long getBreedId() {
        return breedId;
    }

    public void setBreedId(Long breedId) {
        this.breedId = breedId;
    }

    public String getBreedCode() {
        return breedCode;
    }

    public void setBreedCode(String breedCode) {
        this.breedCode = breedCode;
    }

    public String getBreedSalesName() {
        return breedSalesName;
    }

    public void setBreedSalesName(String breedSalesName) {
        this.breedSalesName = breedSalesName;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemSku() {
        return itemSku;
    }

    public void setItemSku(String itemSku) {
        this.itemSku = itemSku;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getQualityGradeTypeCode() {
        return qualityGradeTypeCode;
    }

    public void setQualityGradeTypeCode(String qualityGradeTypeCode) {
        this.qualityGradeTypeCode = qualityGradeTypeCode;
    }

    public String getQualityGradeType() {
        return qualityGradeType;
    }

    public void setQualityGradeType(String qualityGradeType) {
        this.qualityGradeType = qualityGradeType;
    }

    public String getQualityGradeTypeName() {
        return qualityGradeTypeName;
    }

    public void setQualityGradeTypeName(String qualityGradeTypeName) {
        this.qualityGradeTypeName = qualityGradeTypeName;
    }

    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getNetWeightCode() {
        return netWeightCode;
    }

    public void setNetWeightCode(String netWeightCode) {
        this.netWeightCode = netWeightCode;
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

    public Integer getPalletStackingLimit() {
        return palletStackingLimit;
    }

    public void setPalletStackingLimit(Integer palletStackingLimit) {
        this.palletStackingLimit = palletStackingLimit;
    }

    public String getBrandItemPropertySku() {
        return brandItemPropertySku;
    }

    public void setBrandItemPropertySku(String brandItemPropertySku) {
        this.brandItemPropertySku = brandItemPropertySku;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getItemPropertyCode() {
        return itemPropertyCode;
    }

    public void setItemPropertyCode(String itemPropertyCode) {
        this.itemPropertyCode = itemPropertyCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}
