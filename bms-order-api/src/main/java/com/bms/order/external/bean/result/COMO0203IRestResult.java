package com.bms.order.external.bean.result;

import com.bms.order.common.rest.result.RestSearchData;

import java.math.BigDecimal;
import java.util.List;

/**
 * 产品信息
 */
public class COMO0203IRestResult extends RestSearchData {

    private static final long serialVersionUID = 4966684673548754807L;

    // 品牌编码
    private String brandCode;

    // 品牌ID
    private String brandId;

     // 单品品牌规格编码
    private String brandItemPropertySku;

     // 品牌名称
    private String brandName;

     // 品种编码
    private String breedCode;

     // 品种名称
    private String breedName;

     // 包装尺寸
    private String cartonDimension;

     // 一级分类编码
    private String classesCode;

     // 一级分类名称
    private  String classesName;

     // 商品编码
    private  String commodityCode;

     // 商品ID
    private Long commodityId;

     // 商品名称
    private String commodityName;

     // 创建者ID
    private String crtId;

     // 创建日时
    private String crtTime;

     // 毛重
    private String grossWeight;

     // 是否为默认商品
    private Boolean isDefault;

     // 是否开放给买手
    private Boolean isOpenToAgent;

     // 商品有效状态
    private Boolean isValid;

     // 单品编码
    private String itemCode;

     // 单品ID
    private String itemId;

     // 单品名称
    private String itemName;

     // 规格编码，对应产品系统中单品规格编码
    private String itemPropertyCode;

     // 二级分类编码
    private String machiningCode;

     // 二级分类名称
    private String machiningName;

     // 净重
    private String netWeight;

     // 包装数量
    private String packageQuantity;

     // 包装规格
    private String packageSpecification;

     // 托盘堆码数
    private String palletStackingLimit;

     // 产品ID
    private String productId;

     // 产品主键ID
    private Long productPid;

     // 质量等级
    private String qualityGradeType;

     // 质量等级名称
    private String qualityGradeTypeName;

     // 销售状态编码
    private String saleStatusCode;

     // 销售状态描述
    private String saleStatusDesc;

     // 销售状态ID
    private Long saleStatusId;

     // 销售状态名称
    private String saleStatusName;

    // 销售单位
//     private List<ComoCommodityUom> uomList;

     // 更新者ID
    private String updId;

     // 更新日时
    private String updTime;

     // 版本号
    private Long version;

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandItemPropertySku() {
        return brandItemPropertySku;
    }

    public void setBrandItemPropertySku(String brandItemPropertySku) {
        this.brandItemPropertySku = brandItemPropertySku;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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

    public String getCartonDimension() {
        return cartonDimension;
    }

    public void setCartonDimension(String cartonDimension) {
        this.cartonDimension = cartonDimension;
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

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public String getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(String crtTime) {
        this.crtTime = crtTime;
    }

    public String getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(String grossWeight) {
        this.grossWeight = grossWeight;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Boolean getIsOpenToAgent() {
        return isOpenToAgent;
    }

    public void setIsOpenToAgent(Boolean isOpenToAgent) {
        this.isOpenToAgent = isOpenToAgent;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPropertyCode() {
        return itemPropertyCode;
    }

    public void setItemPropertyCode(String itemPropertyCode) {
        this.itemPropertyCode = itemPropertyCode;
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

    public String getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(String netWeight) {
        this.netWeight = netWeight;
    }

    public String getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(String packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    public String getPackageSpecification() {
        return packageSpecification;
    }

    public void setPackageSpecification(String packageSpecification) {
        this.packageSpecification = packageSpecification;
    }

    public String getPalletStackingLimit() {
        return palletStackingLimit;
    }

    public void setPalletStackingLimit(String palletStackingLimit) {
        this.palletStackingLimit = palletStackingLimit;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Long getProductPid() {
        return productPid;
    }

    public void setProductPid(Long productPid) {
        this.productPid = productPid;
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

    public String getSaleStatusCode() {
        return saleStatusCode;
    }

    public void setSaleStatusCode(String saleStatusCode) {
        this.saleStatusCode = saleStatusCode;
    }

    public String getSaleStatusDesc() {
        return saleStatusDesc;
    }

    public void setSaleStatusDesc(String saleStatusDesc) {
        this.saleStatusDesc = saleStatusDesc;
    }

    public Long getSaleStatusId() {
        return saleStatusId;
    }

    public void setSaleStatusId(Long saleStatusId) {
        this.saleStatusId = saleStatusId;
    }

    public String getSaleStatusName() {
        return saleStatusName;
    }

    public void setSaleStatusName(String saleStatusName) {
        this.saleStatusName = saleStatusName;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public String getUpdTime() {
        return updTime;
    }

    public void setUpdTime(String updTime) {
        this.updTime = updTime;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
