/*
 * 2017/03/30 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.prce.bean.entity;


import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表prce_product_info_history对应的实体PrceProductInfoHistory</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class PrceProductInfoHistory extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 商品同步ID */
    private java.lang.Long syncGoodId;
    /** 商品ID */
    private java.lang.String goodId;
    /** 商品ID */
    private java.lang.String commodityCode;
    /** 商品名称 */
    private java.lang.String commodityName;
    /** 物流区编码 */
    private java.lang.String lgcsAreaCode;
    /** 物流区 */
    private java.lang.String lgcsAreaName;
    /** 销售状态ID */
    private java.lang.Long saleStatusId;
    /** 销售状态编码 */
    private java.lang.String saleStatusCode;
    /** 销售状态名称 */
    private java.lang.String saleStatusName;
    /** 产品ID */
    private java.lang.String productId;
    /** 一级分类编码 */
    private java.lang.String classesCode;
    /** 一级分类名称 */
    private java.lang.String classesName;
    /** 二级分类编码 */
    private java.lang.String machiningCode;
    /** 二级分类名称 */
    private java.lang.String machiningName;
    /** 品种编码 */
    private java.lang.String breedCode;
    /** 品种学名 */
    private java.lang.String breedName;
    /** 单品特征编码 */
    private java.lang.String itemCode;
    /** 单品名称 */
    private java.lang.String itemName;
    /** 品牌编码 */
    private java.lang.String brandCode;
    /** 品牌名称 */
    private java.lang.String brandName;
    /** 质量等级，1：A1，2：A2，3：A3 */
    private java.lang.String qualityGradeTypeCode;
    /** 质量等级，1：A1，2：A2，3：A3 */
    private java.lang.String qualityGradeTypeName;
    /** 毛重（克） */
    private java.math.BigDecimal grossWeight;
    /** 净重（克） */
    private java.math.BigDecimal netWeight;
    /** 包装规格 */
    private java.lang.String packageSpecification;
    /** 包装数量 */
    private java.lang.Integer packageQuantity;
    /** 包装数量 */
    private java.lang.String cartonDimension;
    /** 单品品牌SKU */
    private java.lang.String brandItemPropertySku;
    /** 上下架状态，1：上架，2：下架 */
    private java.lang.String shelfStu;

    /**
     * <p>默认构造函数</p>
     */
    public PrceProductInfoHistory() {
    }

    /**
     * <p>商品同步ID</p>
     *
     * @return 商品同步ID
     */
    public java.lang.Long getSyncGoodId() {
        return syncGoodId;
    }

    /**
     * <p>商品同步ID</p>
     *
     * @param syncGoodId 商品同步ID
     */
    public void setSyncGoodId(java.lang.Long syncGoodId) {
        this.syncGoodId = syncGoodId;
    }
    /**
     * <p>商品ID</p>
     *
     * @return 商品ID
     */
    public java.lang.String getGoodId() {
        return goodId;
    }

    /**
     * <p>商品ID</p>
     *
     * @param goodId 商品ID
     */
    public void setGoodId(java.lang.String goodId) {
        this.goodId = goodId;
    }
    /**
     * <p>商品ID</p>
     *
     * @return 商品ID
     */
    public java.lang.String getCommodityCode() {
        return commodityCode;
    }

    /**
     * <p>商品ID</p>
     *
     * @param commodityCode 商品ID
     */
    public void setCommodityCode(java.lang.String commodityCode) {
        this.commodityCode = commodityCode;
    }
    /**
     * <p>商品名称</p>
     *
     * @return 商品名称
     */
    public java.lang.String getCommodityName() {
        return commodityName;
    }

    /**
     * <p>商品名称</p>
     *
     * @param commodityName 商品名称
     */
    public void setCommodityName(java.lang.String commodityName) {
        this.commodityName = commodityName;
    }
    /**
     * <p>物流区编码</p>
     *
     * @return 物流区编码
     */
    public java.lang.String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    /**
     * <p>物流区编码</p>
     *
     * @param lgcsAreaCode 物流区编码
     */
    public void setLgcsAreaCode(java.lang.String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }
    /**
     * <p>物流区</p>
     *
     * @return 物流区
     */
    public java.lang.String getLgcsAreaName() {
        return lgcsAreaName;
    }

    /**
     * <p>物流区</p>
     *
     * @param lgcsAreaName 物流区
     */
    public void setLgcsAreaName(java.lang.String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }
    /**
     * <p>销售状态ID</p>
     *
     * @return 销售状态ID
     */
    public java.lang.Long getSaleStatusId() {
        return saleStatusId;
    }

    /**
     * <p>销售状态ID</p>
     *
     * @param saleStatusId 销售状态ID
     */
    public void setSaleStatusId(java.lang.Long saleStatusId) {
        this.saleStatusId = saleStatusId;
    }
    /**
     * <p>销售状态编码</p>
     *
     * @return 销售状态编码
     */
    public java.lang.String getSaleStatusCode() {
        return saleStatusCode;
    }

    /**
     * <p>销售状态编码</p>
     *
     * @param saleStatusCode 销售状态编码
     */
    public void setSaleStatusCode(java.lang.String saleStatusCode) {
        this.saleStatusCode = saleStatusCode;
    }
    /**
     * <p>销售状态名称</p>
     *
     * @return 销售状态名称
     */
    public java.lang.String getSaleStatusName() {
        return saleStatusName;
    }

    /**
     * <p>销售状态名称</p>
     *
     * @param saleStatusName 销售状态名称
     */
    public void setSaleStatusName(java.lang.String saleStatusName) {
        this.saleStatusName = saleStatusName;
    }
    /**
     * <p>产品ID</p>
     *
     * @return 产品ID
     */
    public java.lang.String getProductId() {
        return productId;
    }

    /**
     * <p>产品ID</p>
     *
     * @param productId 产品ID
     */
    public void setProductId(java.lang.String productId) {
        this.productId = productId;
    }
    /**
     * <p>一级分类编码</p>
     *
     * @return 一级分类编码
     */
    public java.lang.String getClassesCode() {
        return classesCode;
    }

    /**
     * <p>一级分类编码</p>
     *
     * @param classesCode 一级分类编码
     */
    public void setClassesCode(java.lang.String classesCode) {
        this.classesCode = classesCode;
    }
    /**
     * <p>一级分类名称</p>
     *
     * @return 一级分类名称
     */
    public java.lang.String getClassesName() {
        return classesName;
    }

    /**
     * <p>一级分类名称</p>
     *
     * @param classesName 一级分类名称
     */
    public void setClassesName(java.lang.String classesName) {
        this.classesName = classesName;
    }
    /**
     * <p>二级分类编码</p>
     *
     * @return 二级分类编码
     */
    public java.lang.String getMachiningCode() {
        return machiningCode;
    }

    /**
     * <p>二级分类编码</p>
     *
     * @param machiningCode 二级分类编码
     */
    public void setMachiningCode(java.lang.String machiningCode) {
        this.machiningCode = machiningCode;
    }
    /**
     * <p>二级分类名称</p>
     *
     * @return 二级分类名称
     */
    public java.lang.String getMachiningName() {
        return machiningName;
    }

    /**
     * <p>二级分类名称</p>
     *
     * @param machiningName 二级分类名称
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
     * <p>品种学名</p>
     *
     * @return 品种学名
     */
    public java.lang.String getBreedName() {
        return breedName;
    }

    /**
     * <p>品种学名</p>
     *
     * @param breedName 品种学名
     */
    public void setBreedName(java.lang.String breedName) {
        this.breedName = breedName;
    }
    /**
     * <p>单品特征编码</p>
     *
     * @return 单品特征编码
     */
    public java.lang.String getItemCode() {
        return itemCode;
    }

    /**
     * <p>单品特征编码</p>
     *
     * @param itemCode 单品特征编码
     */
    public void setItemCode(java.lang.String itemCode) {
        this.itemCode = itemCode;
    }
    /**
     * <p>单品名称</p>
     *
     * @return 单品名称
     */
    public java.lang.String getItemName() {
        return itemName;
    }

    /**
     * <p>单品名称</p>
     *
     * @param itemName 单品名称
     */
    public void setItemName(java.lang.String itemName) {
        this.itemName = itemName;
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
     * <p>质量等级，1：A1，2：A2，3：A3</p>
     *
     * @return 质量等级，1：A1，2：A2，3：A3
     */
    public java.lang.String getQualityGradeTypeCode() {
        return qualityGradeTypeCode;
    }

    /**
     * <p>质量等级，1：A1，2：A2，3：A3</p>
     *
     * @param qualityGradeTypeCode 质量等级，1：A1，2：A2，3：A3
     */
    public void setQualityGradeTypeCode(java.lang.String qualityGradeTypeCode) {
        this.qualityGradeTypeCode = qualityGradeTypeCode;
    }
    /**
     * <p>质量等级，1：A1，2：A2，3：A3</p>
     *
     * @return 质量等级，1：A1，2：A2，3：A3
     */
    public java.lang.String getQualityGradeTypeName() {
        return qualityGradeTypeName;
    }

    /**
     * <p>质量等级，1：A1，2：A2，3：A3</p>
     *
     * @param qualityGradeTypeName 质量等级，1：A1，2：A2，3：A3
     */
    public void setQualityGradeTypeName(java.lang.String qualityGradeTypeName) {
        this.qualityGradeTypeName = qualityGradeTypeName;
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
     * <p>包装规格</p>
     *
     * @return 包装规格
     */
    public java.lang.String getPackageSpecification() {
        return packageSpecification;
    }

    /**
     * <p>包装规格</p>
     *
     * @param packageSpecification 包装规格
     */
    public void setPackageSpecification(java.lang.String packageSpecification) {
        this.packageSpecification = packageSpecification;
    }
    /**
     * <p>包装数量</p>
     *
     * @return 包装数量
     */
    public java.lang.Integer getPackageQuantity() {
        return packageQuantity;
    }

    /**
     * <p>包装数量</p>
     *
     * @param packageQuantity 包装数量
     */
    public void setPackageQuantity(java.lang.Integer packageQuantity) {
        this.packageQuantity = packageQuantity;
    }
    /**
     * <p>包装数量</p>
     *
     * @return 包装数量
     */
    public java.lang.String getCartonDimension() {
        return cartonDimension;
    }

    /**
     * <p>包装数量</p>
     *
     * @param cartonDimension 包装数量
     */
    public void setCartonDimension(java.lang.String cartonDimension) {
        this.cartonDimension = cartonDimension;
    }
    /**
     * <p>单品品牌SKU</p>
     *
     * @return 单品品牌SKU
     */
    public java.lang.String getBrandItemPropertySku() {
        return brandItemPropertySku;
    }

    /**
     * <p>单品品牌SKU</p>
     *
     * @param brandItemPropertySku 单品品牌SKU
     */
    public void setBrandItemPropertySku(java.lang.String brandItemPropertySku) {
        this.brandItemPropertySku = brandItemPropertySku;
    }
    /**
     * <p>上下架状态，1：上架，2：下架</p>
     *
     * @return 上下架状态，1：上架，2：下架
     */
    public java.lang.String getShelfStu() {
        return shelfStu;
    }

    /**
     * <p>上下架状态，1：上架，2：下架</p>
     *
     * @param shelfStu 上下架状态，1：上架，2：下架
     */
    public void setShelfStu(java.lang.String shelfStu) {
        this.shelfStu = shelfStu;
    }

}
