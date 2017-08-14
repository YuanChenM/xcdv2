/*
 * 2017/04/05 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.como.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表como_product_info对应的实体ComoProductInfo</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ComoProductInfo extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 产品主键ID */
    private Long productPid;
    /** 产品ID */
    private String productId;
    /** 一级分类ID */
    private Long classesId;
    /** 一级分类编码 */
    private String classesCode;
    /** 一级分类名称 */
    private String classesName;
    /** 二级分类ID */
    private Long machiningId;
    /** 二级分类编码 */
    private String machiningCode;
    /** 二级分类名称 */
    private String machiningName;
    /** 品种ID */
    private Long breedId;
    /** 品种编码 */
    private String breedCode;
    /** 品种标准市场销售名 */
    private String breedSalesName;
    /** 单品ID */
    private Long itemId;
    /** 单品特征编码 */
    private String itemCode;
    /** 单品名称 */
    private String itemName;
    /** 单品SKU */
    private String itemSku;
    /** 品牌ID */
    private Long brandId;
    /** 品牌编码 */
    private String brandCode;
    /** 品牌名称 */
    private String brandName;
    /** 质量等级编码 */
    private String qualityGradeTypeCode;
    /** 质量等级，1：A1，2：A2，3：A3 */
    private String qualityGradeType;
    /** 毛重（克） */
    private java.math.BigDecimal grossWeight;
    /** 净重编码 */
    private String netWeightCode;
    /** 净重（克） */
    private java.math.BigDecimal netWeight;
    /** 包装规格，小包装特征 */
    private String packageSpecification;
    /** 包装数量，小包装数量 */
    private Integer packageQuantity;
    /** 纸箱尺寸（cm），长*宽*高 */
    private String cartonDimension;
    /** 托盘堆码数（箱） */
    private Integer palletStackingLimit;
    /** 单品品牌规格SKU */
    private String brandItemPropertySku;
    /** 规格编码，对应产品系统中单品规格编码 */
    private String itemPropertyCode;

    /**
     * <p>默认构造函数</p>
     */
    public ComoProductInfo() {
    }

    /**
     * <p>产品主键ID</p>
     *
     * @return 产品主键ID
     */
    public Long getProductPid() {
        return productPid;
    }

    /**
     * <p>产品主键ID</p>
     *
     * @param productPid 产品主键ID
     */
    public void setProductPid(Long productPid) {
        this.productPid = productPid;
    }
    /**
     * <p>产品ID</p>
     *
     * @return 产品ID
     */
    public String getProductId() {
        return productId;
    }

    /**
     * <p>产品ID</p>
     *
     * @param productId 产品ID
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }
    /**
     * <p>一级分类ID</p>
     *
     * @return 一级分类ID
     */
    public Long getClassesId() {
        return classesId;
    }

    /**
     * <p>一级分类ID</p>
     *
     * @param classesId 一级分类ID
     */
    public void setClassesId(Long classesId) {
        this.classesId = classesId;
    }
    /**
     * <p>一级分类编码</p>
     *
     * @return 一级分类编码
     */
    public String getClassesCode() {
        return classesCode;
    }

    /**
     * <p>一级分类编码</p>
     *
     * @param classesCode 一级分类编码
     */
    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode;
    }
    /**
     * <p>一级分类名称</p>
     *
     * @return 一级分类名称
     */
    public String getClassesName() {
        return classesName;
    }

    /**
     * <p>一级分类名称</p>
     *
     * @param classesName 一级分类名称
     */
    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }
    /**
     * <p>二级分类ID</p>
     *
     * @return 二级分类ID
     */
    public Long getMachiningId() {
        return machiningId;
    }

    /**
     * <p>二级分类ID</p>
     *
     * @param machiningId 二级分类ID
     */
    public void setMachiningId(Long machiningId) {
        this.machiningId = machiningId;
    }
    /**
     * <p>二级分类编码</p>
     *
     * @return 二级分类编码
     */
    public String getMachiningCode() {
        return machiningCode;
    }

    /**
     * <p>二级分类编码</p>
     *
     * @param machiningCode 二级分类编码
     */
    public void setMachiningCode(String machiningCode) {
        this.machiningCode = machiningCode;
    }
    /**
     * <p>二级分类名称</p>
     *
     * @return 二级分类名称
     */
    public String getMachiningName() {
        return machiningName;
    }

    /**
     * <p>二级分类名称</p>
     *
     * @param machiningName 二级分类名称
     */
    public void setMachiningName(String machiningName) {
        this.machiningName = machiningName;
    }
    /**
     * <p>品种ID</p>
     *
     * @return 品种ID
     */
    public Long getBreedId() {
        return breedId;
    }

    /**
     * <p>品种ID</p>
     *
     * @param breedId 品种ID
     */
    public void setBreedId(Long breedId) {
        this.breedId = breedId;
    }
    /**
     * <p>品种编码</p>
     *
     * @return 品种编码
     */
    public String getBreedCode() {
        return breedCode;
    }

    /**
     * <p>品种编码</p>
     *
     * @param breedCode 品种编码
     */
    public void setBreedCode(String breedCode) {
        this.breedCode = breedCode;
    }
    /**
     * <p>品种标准市场销售名</p>
     *
     * @return 品种标准市场销售名
     */
    public String getBreedSalesName() {
        return breedSalesName;
    }

    /**
     * <p>品种标准市场销售名</p>
     *
     * @param breedSalesName 品种标准市场销售名
     */
    public void setBreedSalesName(String breedSalesName) {
        this.breedSalesName = breedSalesName;
    }
    /**
     * <p>单品ID</p>
     *
     * @return 单品ID
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * <p>单品ID</p>
     *
     * @param itemId 单品ID
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
    /**
     * <p>单品特征编码</p>
     *
     * @return 单品特征编码
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * <p>单品特征编码</p>
     *
     * @param itemCode 单品特征编码
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
    /**
     * <p>单品名称</p>
     *
     * @return 单品名称
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * <p>单品名称</p>
     *
     * @param itemName 单品名称
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    /**
     * <p>单品SKU</p>
     *
     * @return 单品SKU
     */
    public String getItemSku() {
        return itemSku;
    }

    /**
     * <p>单品SKU</p>
     *
     * @param itemSku 单品SKU
     */
    public void setItemSku(String itemSku) {
        this.itemSku = itemSku;
    }
    /**
     * <p>品牌ID</p>
     *
     * @return 品牌ID
     */
    public Long getBrandId() {
        return brandId;
    }

    /**
     * <p>品牌ID</p>
     *
     * @param brandId 品牌ID
     */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
    /**
     * <p>品牌编码</p>
     *
     * @return 品牌编码
     */
    public String getBrandCode() {
        return brandCode;
    }

    /**
     * <p>品牌编码</p>
     *
     * @param brandCode 品牌编码
     */
    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }
    /**
     * <p>品牌名称</p>
     *
     * @return 品牌名称
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * <p>品牌名称</p>
     *
     * @param brandName 品牌名称
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    /**
     * <p>质量等级编码</p>
     *
     * @return 质量等级编码
     */
    public String getQualityGradeTypeCode() {
        return qualityGradeTypeCode;
    }

    /**
     * <p>质量等级编码</p>
     *
     * @param qualityGradeTypeCode 质量等级编码
     */
    public void setQualityGradeTypeCode(String qualityGradeTypeCode) {
        this.qualityGradeTypeCode = qualityGradeTypeCode;
    }
    /**
     * <p>质量等级，1：A1，2：A2，3：A3</p>
     *
     * @return 质量等级，1：A1，2：A2，3：A3
     */
    public String getQualityGradeType() {
        return qualityGradeType;
    }

    /**
     * <p>质量等级，1：A1，2：A2，3：A3</p>
     *
     * @param qualityGradeType 质量等级，1：A1，2：A2，3：A3
     */
    public void setQualityGradeType(String qualityGradeType) {
        this.qualityGradeType = qualityGradeType;
    }
    /**
     * <p>毛重（克）</p>
     *
     * @return 毛重（克）
     */
    public java.math.BigDecimal getGrossWeight() {
        return grossWeight;
    }

    /**
     * <p>毛重（克）</p>
     *
     * @param grossWeight 毛重（克）
     */
    public void setGrossWeight(java.math.BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }
    /**
     * <p>净重编码</p>
     *
     * @return 净重编码
     */
    public String getNetWeightCode() {
        return netWeightCode;
    }

    /**
     * <p>净重编码</p>
     *
     * @param netWeightCode 净重编码
     */
    public void setNetWeightCode(String netWeightCode) {
        this.netWeightCode = netWeightCode;
    }
    /**
     * <p>净重（克）</p>
     *
     * @return 净重（克）
     */
    public java.math.BigDecimal getNetWeight() {
        return netWeight;
    }

    /**
     * <p>净重（克）</p>
     *
     * @param netWeight 净重（克）
     */
    public void setNetWeight(java.math.BigDecimal netWeight) {
        this.netWeight = netWeight;
    }
    /**
     * <p>包装规格，小包装特征</p>
     *
     * @return 包装规格，小包装特征
     */
    public String getPackageSpecification() {
        return packageSpecification;
    }

    /**
     * <p>包装规格，小包装特征</p>
     *
     * @param packageSpecification 包装规格，小包装特征
     */
    public void setPackageSpecification(String packageSpecification) {
        this.packageSpecification = packageSpecification;
    }
    /**
     * <p>包装数量，小包装数量</p>
     *
     * @return 包装数量，小包装数量
     */
    public Integer getPackageQuantity() {
        return packageQuantity;
    }

    /**
     * <p>包装数量，小包装数量</p>
     *
     * @param packageQuantity 包装数量，小包装数量
     */
    public void setPackageQuantity(Integer packageQuantity) {
        this.packageQuantity = packageQuantity;
    }
    /**
     * <p>纸箱尺寸（cm），长*宽*高</p>
     *
     * @return 纸箱尺寸（cm），长*宽*高
     */
    public String getCartonDimension() {
        return cartonDimension;
    }

    /**
     * <p>纸箱尺寸（cm），长*宽*高</p>
     *
     * @param cartonDimension 纸箱尺寸（cm），长*宽*高
     */
    public void setCartonDimension(String cartonDimension) {
        this.cartonDimension = cartonDimension;
    }
    /**
     * <p>托盘堆码数（箱）</p>
     *
     * @return 托盘堆码数（箱）
     */
    public Integer getPalletStackingLimit() {
        return palletStackingLimit;
    }

    /**
     * <p>托盘堆码数（箱）</p>
     *
     * @param palletStackingLimit 托盘堆码数（箱）
     */
    public void setPalletStackingLimit(Integer palletStackingLimit) {
        this.palletStackingLimit = palletStackingLimit;
    }
    /**
     * <p>单品品牌规格SKU</p>
     *
     * @return 单品品牌规格SKU
     */
    public String getBrandItemPropertySku() {
        return brandItemPropertySku;
    }

    /**
     * <p>单品品牌规格SKU</p>
     *
     * @param brandItemPropertySku 单品品牌规格SKU
     */
    public void setBrandItemPropertySku(String brandItemPropertySku) {
        this.brandItemPropertySku = brandItemPropertySku;
    }
    /**
     * <p>规格编码，对应产品系统中单品规格编码</p>
     *
     * @return 规格编码，对应产品系统中单品规格编码
     */
    public String getItemPropertyCode() {
        return itemPropertyCode;
    }

    /**
     * <p>规格编码，对应产品系统中单品规格编码</p>
     *
     * @param itemPropertyCode 规格编码，对应产品系统中单品规格编码
     */
    public void setItemPropertyCode(String itemPropertyCode) {
        this.itemPropertyCode = itemPropertyCode;
    }

}
