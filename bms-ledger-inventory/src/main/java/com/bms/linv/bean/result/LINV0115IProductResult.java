package com.bms.linv.bean.result;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wang_haichun on 2017/3/28.
 */
public class LINV0115IProductResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品ID")
    private Long commodityId;
    @ApiModelProperty(value = "销售状态ID")
    private Long saleStatusId;
    @ApiModelProperty(value = "销售状态编码")
    private String saleStatusCode;
    @ApiModelProperty(value = "销售状态名称")
    private String saleStatusName;
    @ApiModelProperty(value = "销售状态描述")
    private String saleStatusDesc;
    @ApiModelProperty(value = "商品编码")
    private String commodityCode;
    @ApiModelProperty(value = "商品名称")
    private String commodityName;
    @ApiModelProperty(value = "商品有效状态")
    private Boolean isValid;
    @ApiModelProperty(value = "是否为默认商品")
    private Boolean isDefault;
    @ApiModelProperty(value = "是否开放给买手")
    private Boolean isOpenToAgent;
    @ApiModelProperty(value = "产品主键ID")
    private Long productPid;
    @ApiModelProperty(value = "产品ID")
    private String productId;
    @ApiModelProperty(value = "一级分类编码")
    private String classesCode;
    @ApiModelProperty(value = "一级分类名称")
    private String classesName;
    @ApiModelProperty(value = "二级分类编码")
    private String machiningCode;
    @ApiModelProperty(value = "二级分类名称")
    private String machiningName;
    @ApiModelProperty(value = "品种编码")
    private String breedCode;
    @ApiModelProperty(value = "品种名称")
    private String breedName;
    @ApiModelProperty(value = "单品ID")
    private String itemId;
    @ApiModelProperty(value = "单品编码")
    private String itemCode;
    @ApiModelProperty(value = "单品名称")
    private String itemName;
    @ApiModelProperty(value = "品牌ID")
    private String brandId;
    @ApiModelProperty(value = "品牌编码")
    private String brandCode;
    @ApiModelProperty(value = "品牌名称")
    private String brandName;
    @ApiModelProperty(value = "质量等级")
    private String qualityGradeType;
    @ApiModelProperty(value = "质量等级名称")
    private String qualityGradeTypeName;
    @ApiModelProperty(value = "毛重")
    private String grossWeight;
    @ApiModelProperty(value = "净重")
    private String netWeight;
    @ApiModelProperty(value = "包装规格")
    private String packageSpecification;
    @ApiModelProperty(value = "包装数量")
    private String packageQuantity;

    @ApiModelProperty(value = "包装尺寸")
    private String cartonDimension;
    @ApiModelProperty(value = "托盘堆码数")
    private String palletStackingLimit;

    @ApiModelProperty(value = "单品品牌规格编码")
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
//    @ApiModelProperty(value = "销售单位")
//    private List<ComoCommodityUom> uomList;


    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public Long getSaleStatusId() {
        return saleStatusId;
    }

    public void setSaleStatusId(Long saleStatusId) {
        this.saleStatusId = saleStatusId;
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

    public String getSaleStatusDesc() {
        return saleStatusDesc;
    }

    public void setSaleStatusDesc(String saleStatusDesc) {
        this.saleStatusDesc = saleStatusDesc;
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

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean valid) {
        isValid = valid;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public Boolean getIsOpenToAgent() {
        return isOpenToAgent;
    }

    public void setIsOpenToAgent(Boolean openToAgent) {
        isOpenToAgent = openToAgent;
    }

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

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    public String getQualityGradeType() {
        return qualityGradeType;
    }

    public void setQualityGradeType(String qualityGradeType) {
        this.qualityGradeType = qualityGradeType;
    }

    public String getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(String grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(String netWeight) {
        this.netWeight = netWeight;
    }

    public String getPackageSpecification() {
        return packageSpecification;
    }

    public void setPackageSpecification(String packageSpecification) {
        this.packageSpecification = packageSpecification;
    }

    public String getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(String packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    public String getCartonDimension() {
        return cartonDimension;
    }

    public void setCartonDimension(String cartonDimension) {
        this.cartonDimension = cartonDimension;
    }

    public String getPalletStackingLimit() {
        return palletStackingLimit;
    }

    public void setPalletStackingLimit(String palletStackingLimit) {
        this.palletStackingLimit = palletStackingLimit;
    }

    public String getBrandItemPropertySku() {
        return brandItemPropertySku;
    }

    public void setBrandItemPropertySku(String brandItemPropertySku) {
        this.brandItemPropertySku = brandItemPropertySku;
    }

    public String getItemPropertyCode() {
        return itemPropertyCode;
    }

    public void setItemPropertyCode(String itemPropertyCode) {
        this.itemPropertyCode = itemPropertyCode;
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

//    public List<ComoCommodityUom> getUomList() {
//        return uomList;
//    }
//
//    public void setUomList(List<ComoCommodityUom> uomList) {
//        this.uomList = uomList;
//    }

    public String getQualityGradeTypeName() {
        return qualityGradeTypeName;
    }

    public void setQualityGradeTypeName(String qualityGradeTypeName) {
        this.qualityGradeTypeName = qualityGradeTypeName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }
}
