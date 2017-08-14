/*
 * 2017/01/10 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.bypo.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表BYPO_PRODUCT_RESEARCH对应的实体BypoProductResearch</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class BypoProductResearch extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** RESEARCH_PRODUCT_ID */
    private java.lang.Long researchProductId;
    /** RESEARCH_ID */
    private java.lang.Long researchId;
    /** CLASSES_CODE */
    private java.lang.String classesCode;
    /** CLASSES_NAME */
    private java.lang.String classesName;
    /** MACHINING_CODE */
    private java.lang.String machiningCode;
    /** MACHINING_NAME */
    private java.lang.String machiningName;
    /** 品种编码 */
    private java.lang.String breedCode;
    /** 品种标准市场销售名 */
    private java.lang.String breedSalesName;
    /** 品种学名 */
    private java.lang.String breedScientificName;
    /** 品种俗名 */
    private java.lang.String breedLocalName;
    /** 单品特征编码 */
    private java.lang.String featureCode;
    /** 单品特征名称 */
    private java.lang.String featureName;
    /** 品牌编码 */
    private java.lang.String brandCode;
    /** 品牌名称 */
    private java.lang.String brandName;
    /** 品牌所有人编码 */
    private java.lang.String brandOwnerCode;
    /** 品牌所有人名称（版权人） */
    private java.lang.String ownerName;
    /** 生产商编码 */
    private java.lang.String producerCode;
    /** 生产商名称 */
    private java.lang.String producerName;
    /** PACKAGE_SPECIFICATION */
    private java.lang.String packageSpecification;
    /** PACKAGE_QUANTITY */
    private java.lang.Integer packageQuantity;
    /** NET_WEIGHT */
    private java.math.BigDecimal netWeight;
    /** GROSS_WEIGHT */
    private java.math.BigDecimal grossWeight;
    /** CARTON_DIMENSION */
    private java.lang.String cartonDimension;
    /** PRODUCT_LEVEL */
    private java.lang.String productLevel;
    /** PALLET_STACKING_LIMIT */
    private java.lang.Integer palletStackingLimit;
    /** DEMAND_LEVEL */
    private java.lang.String demandLevel;
    /** IS_STANDARD_FLG */
    private java.lang.Boolean isStandardFlg;

    /**
     * <p>默认构造函数</p>
     */
    public BypoProductResearch() {
    }

    /**
     * <p>RESEARCH_PRODUCT_ID</p>
     *
     * @return RESEARCH_PRODUCT_ID
     */
    public java.lang.Long getResearchProductId() {
        return researchProductId;
    }

    /**
     * <p>RESEARCH_PRODUCT_ID</p>
     *
     * @param researchProductId RESEARCH_PRODUCT_ID
     */
    public void setResearchProductId(java.lang.Long researchProductId) {
        this.researchProductId = researchProductId;
    }
    /**
     * <p>RESEARCH_ID</p>
     *
     * @return RESEARCH_ID
     */
    public java.lang.Long getResearchId() {
        return researchId;
    }

    /**
     * <p>RESEARCH_ID</p>
     *
     * @param researchId RESEARCH_ID
     */
    public void setResearchId(java.lang.Long researchId) {
        this.researchId = researchId;
    }
    /**
     * <p>CLASSES_CODE</p>
     *
     * @return CLASSES_CODE
     */
    public java.lang.String getClassesCode() {
        return classesCode;
    }

    /**
     * <p>CLASSES_CODE</p>
     *
     * @param classesCode CLASSES_CODE
     */
    public void setClassesCode(java.lang.String classesCode) {
        this.classesCode = classesCode;
    }
    /**
     * <p>CLASSES_NAME</p>
     *
     * @return CLASSES_NAME
     */
    public java.lang.String getClassesName() {
        return classesName;
    }

    /**
     * <p>CLASSES_NAME</p>
     *
     * @param classesName CLASSES_NAME
     */
    public void setClassesName(java.lang.String classesName) {
        this.classesName = classesName;
    }
    /**
     * <p>MACHINING_CODE</p>
     *
     * @return MACHINING_CODE
     */
    public java.lang.String getMachiningCode() {
        return machiningCode;
    }

    /**
     * <p>MACHINING_CODE</p>
     *
     * @param machiningCode MACHINING_CODE
     */
    public void setMachiningCode(java.lang.String machiningCode) {
        this.machiningCode = machiningCode;
    }
    /**
     * <p>MACHINING_NAME</p>
     *
     * @return MACHINING_NAME
     */
    public java.lang.String getMachiningName() {
        return machiningName;
    }

    /**
     * <p>MACHINING_NAME</p>
     *
     * @param machiningName MACHINING_NAME
     */
    public void setMachiningName(java.lang.String machiningName) {
        this.machiningName = machiningName;
    }
    /**
     * <p>品种编码</p>
     *
     * @return 品种编码
     */
    public java.lang.String getBreedCode() {
        return breedCode;
    }

    /**
     * <p>品种编码</p>
     *
     * @param breedCode 品种编码
     */
    public void setBreedCode(java.lang.String breedCode) {
        this.breedCode = breedCode;
    }
    /**
     * <p>品种标准市场销售名</p>
     *
     * @return 品种标准市场销售名
     */
    public java.lang.String getBreedSalesName() {
        return breedSalesName;
    }

    /**
     * <p>品种标准市场销售名</p>
     *
     * @param breedSalesName 品种标准市场销售名
     */
    public void setBreedSalesName(java.lang.String breedSalesName) {
        this.breedSalesName = breedSalesName;
    }
    /**
     * <p>品种学名</p>
     *
     * @return 品种学名
     */
    public java.lang.String getBreedScientificName() {
        return breedScientificName;
    }

    /**
     * <p>品种学名</p>
     *
     * @param breedScientificName 品种学名
     */
    public void setBreedScientificName(java.lang.String breedScientificName) {
        this.breedScientificName = breedScientificName;
    }
    /**
     * <p>品种俗名</p>
     *
     * @return 品种俗名
     */
    public java.lang.String getBreedLocalName() {
        return breedLocalName;
    }

    /**
     * <p>品种俗名</p>
     *
     * @param breedLocalName 品种俗名
     */
    public void setBreedLocalName(java.lang.String breedLocalName) {
        this.breedLocalName = breedLocalName;
    }
    /**
     * <p>单品特征编码</p>
     *
     * @return 单品特征编码
     */
    public java.lang.String getFeatureCode() {
        return featureCode;
    }

    /**
     * <p>单品特征编码</p>
     *
     * @param featureCode 单品特征编码
     */
    public void setFeatureCode(java.lang.String featureCode) {
        this.featureCode = featureCode;
    }
    /**
     * <p>单品特征名称</p>
     *
     * @return 单品特征名称
     */
    public java.lang.String getFeatureName() {
        return featureName;
    }

    /**
     * <p>单品特征名称</p>
     *
     * @param featureName 单品特征名称
     */
    public void setFeatureName(java.lang.String featureName) {
        this.featureName = featureName;
    }
    /**
     * <p>品牌编码</p>
     *
     * @return 品牌编码
     */
    public java.lang.String getBrandCode() {
        return brandCode;
    }

    /**
     * <p>品牌编码</p>
     *
     * @param brandCode 品牌编码
     */
    public void setBrandCode(java.lang.String brandCode) {
        this.brandCode = brandCode;
    }
    /**
     * <p>品牌名称</p>
     *
     * @return 品牌名称
     */
    public java.lang.String getBrandName() {
        return brandName;
    }

    /**
     * <p>品牌名称</p>
     *
     * @param brandName 品牌名称
     */
    public void setBrandName(java.lang.String brandName) {
        this.brandName = brandName;
    }
    /**
     * <p>品牌所有人编码</p>
     *
     * @return 品牌所有人编码
     */
    public java.lang.String getBrandOwnerCode() {
        return brandOwnerCode;
    }

    /**
     * <p>品牌所有人编码</p>
     *
     * @param brandOwnerCode 品牌所有人编码
     */
    public void setBrandOwnerCode(java.lang.String brandOwnerCode) {
        this.brandOwnerCode = brandOwnerCode;
    }
    /**
     * <p>品牌所有人名称（版权人）</p>
     *
     * @return 品牌所有人名称（版权人）
     */
    public java.lang.String getOwnerName() {
        return ownerName;
    }

    /**
     * <p>品牌所有人名称（版权人）</p>
     *
     * @param ownerName 品牌所有人名称（版权人）
     */
    public void setOwnerName(java.lang.String ownerName) {
        this.ownerName = ownerName;
    }
    /**
     * <p>生产商编码</p>
     *
     * @return 生产商编码
     */
    public java.lang.String getProducerCode() {
        return producerCode;
    }

    /**
     * <p>生产商编码</p>
     *
     * @param producerCode 生产商编码
     */
    public void setProducerCode(java.lang.String producerCode) {
        this.producerCode = producerCode;
    }
    /**
     * <p>生产商名称</p>
     *
     * @return 生产商名称
     */
    public java.lang.String getProducerName() {
        return producerName;
    }

    /**
     * <p>生产商名称</p>
     *
     * @param producerName 生产商名称
     */
    public void setProducerName(java.lang.String producerName) {
        this.producerName = producerName;
    }
    /**
     * <p>PACKAGE_SPECIFICATION</p>
     *
     * @return PACKAGE_SPECIFICATION
     */
    public java.lang.String getPackageSpecification() {
        return packageSpecification;
    }

    /**
     * <p>PACKAGE_SPECIFICATION</p>
     *
     * @param packageSpecification PACKAGE_SPECIFICATION
     */
    public void setPackageSpecification(java.lang.String packageSpecification) {
        this.packageSpecification = packageSpecification;
    }
    /**
     * <p>PACKAGE_QUANTITY</p>
     *
     * @return PACKAGE_QUANTITY
     */
    public java.lang.Integer getPackageQuantity() {
        return packageQuantity;
    }

    /**
     * <p>PACKAGE_QUANTITY</p>
     *
     * @param packageQuantity PACKAGE_QUANTITY
     */
    public void setPackageQuantity(java.lang.Integer packageQuantity) {
        this.packageQuantity = packageQuantity;
    }
    /**
     * <p>NET_WEIGHT</p>
     *
     * @return NET_WEIGHT
     */
    public java.math.BigDecimal getNetWeight() {
        return netWeight;
    }

    /**
     * <p>NET_WEIGHT</p>
     *
     * @param netWeight NET_WEIGHT
     */
    public void setNetWeight(java.math.BigDecimal netWeight) {
        this.netWeight = netWeight;
    }
    /**
     * <p>GROSS_WEIGHT</p>
     *
     * @return GROSS_WEIGHT
     */
    public java.math.BigDecimal getGrossWeight() {
        return grossWeight;
    }

    /**
     * <p>GROSS_WEIGHT</p>
     *
     * @param grossWeight GROSS_WEIGHT
     */
    public void setGrossWeight(java.math.BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }
    /**
     * <p>CARTON_DIMENSION</p>
     *
     * @return CARTON_DIMENSION
     */
    public java.lang.String getCartonDimension() {
        return cartonDimension;
    }

    /**
     * <p>CARTON_DIMENSION</p>
     *
     * @param cartonDimension CARTON_DIMENSION
     */
    public void setCartonDimension(java.lang.String cartonDimension) {
        this.cartonDimension = cartonDimension;
    }
    /**
     * <p>PRODUCT_LEVEL</p>
     *
     * @return PRODUCT_LEVEL
     */
    public java.lang.String getProductLevel() {
        return productLevel;
    }

    /**
     * <p>PRODUCT_LEVEL</p>
     *
     * @param productLevel PRODUCT_LEVEL
     */
    public void setProductLevel(java.lang.String productLevel) {
        this.productLevel = productLevel;
    }
    /**
     * <p>PALLET_STACKING_LIMIT</p>
     *
     * @return PALLET_STACKING_LIMIT
     */
    public java.lang.Integer getPalletStackingLimit() {
        return palletStackingLimit;
    }

    /**
     * <p>PALLET_STACKING_LIMIT</p>
     *
     * @param palletStackingLimit PALLET_STACKING_LIMIT
     */
    public void setPalletStackingLimit(java.lang.Integer palletStackingLimit) {
        this.palletStackingLimit = palletStackingLimit;
    }
    /**
     * <p>DEMAND_LEVEL</p>
     *
     * @return DEMAND_LEVEL
     */
    public java.lang.String getDemandLevel() {
        return demandLevel;
    }

    /**
     * <p>DEMAND_LEVEL</p>
     *
     * @param demandLevel DEMAND_LEVEL
     */
    public void setDemandLevel(java.lang.String demandLevel) {
        this.demandLevel = demandLevel;
    }
    /**
     * <p>IS_STANDARD_FLG</p>
     *
     * @return IS_STANDARD_FLG
     */
    public java.lang.Boolean getIsStandardFlg() {
        return isStandardFlg;
    }

    /**
     * <p>IS_STANDARD_FLG</p>
     *
     * @param isStandardFlg IS_STANDARD_FLG
     */
    public void setIsStandardFlg(java.lang.Boolean isStandardFlg) {
        this.isStandardFlg = isStandardFlg;
    }

}
