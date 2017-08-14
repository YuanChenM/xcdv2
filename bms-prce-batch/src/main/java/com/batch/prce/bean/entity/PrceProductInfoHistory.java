/*
 * 2017/03/30 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.batch.prce.bean.entity;


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
    private Long syncGoodId;
    /** 商品ID */
    private String goodId;
    /** 商品ID */
    private String commodityCode;
    /** 商品名称 */
    private String commodityName;
    /** 物流区编码 */
    private String lgcsAreaCode;
    /** 物流区 */
    private String lgcsAreaName;
    /** 销售状态ID */
    private Long saleStatusId;
    /** 销售状态编码 */
    private String saleStatusCode;
    /** 销售状态名称 */
    private String saleStatusName;
    /** 产品ID */
    private String productId;
    /** 一级分类编码 */
    private String classesCode;
    /** 一级分类名称 */
    private String classesName;
    /** 二级分类编码 */
    private String machiningCode;
    /** 二级分类名称 */
    private String machiningName;
    /** 品种编码 */
    private String breedCode;
    /** 品种学名 */
    private String breedName;
    /** 单品特征编码 */
    private String itemCode;
    /** 单品名称 */
    private String itemName;
    /** 品牌编码 */
    private String brandCode;
    /** 品牌名称 */
    private String brandName;
    /** 质量等级，1：A1，2：A2，3：A3 */
    private String qualityGradeTypeCode;
    /** 质量等级，1：A1，2：A2，3：A3 */
    private String qualityGradeTypeName;
    /** 毛重（克） */
    private java.math.BigDecimal grossWeight;
    /** 净重（克） */
    private java.math.BigDecimal netWeight;
    /** 包装规格 */
    private String packageSpecification;
    /** 包装数量 */
    private Integer packageQuantity;
    /** 包装数量 */
    private String cartonDimension;
    /** 单品品牌SKU */
    private String brandItemPropertySku;
    /** 上下架状态，1：上架，2：下架 */
    private String shelfStu;

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
    public Long getSyncGoodId() {
        return syncGoodId;
    }

    /**
     * <p>商品同步ID</p>
     *
     * @param syncGoodId 商品同步ID
     */
    public void setSyncGoodId(Long syncGoodId) {
        this.syncGoodId = syncGoodId;
    }
    /**
     * <p>商品ID</p>
     *
     * @return 商品ID
     */
    public String getGoodId() {
        return goodId;
    }

    /**
     * <p>商品ID</p>
     *
     * @param goodId 商品ID
     */
    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }
    /**
     * <p>商品ID</p>
     *
     * @return 商品ID
     */
    public String getCommodityCode() {
        return commodityCode;
    }

    /**
     * <p>商品ID</p>
     *
     * @param commodityCode 商品ID
     */
    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }
    /**
     * <p>商品名称</p>
     *
     * @return 商品名称
     */
    public String getCommodityName() {
        return commodityName;
    }

    /**
     * <p>商品名称</p>
     *
     * @param commodityName 商品名称
     */
    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }
    /**
     * <p>物流区编码</p>
     *
     * @return 物流区编码
     */
    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    /**
     * <p>物流区编码</p>
     *
     * @param lgcsAreaCode 物流区编码
     */
    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }
    /**
     * <p>物流区</p>
     *
     * @return 物流区
     */
    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    /**
     * <p>物流区</p>
     *
     * @param lgcsAreaName 物流区
     */
    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }
    /**
     * <p>销售状态ID</p>
     *
     * @return 销售状态ID
     */
    public Long getSaleStatusId() {
        return saleStatusId;
    }

    /**
     * <p>销售状态ID</p>
     *
     * @param saleStatusId 销售状态ID
     */
    public void setSaleStatusId(Long saleStatusId) {
        this.saleStatusId = saleStatusId;
    }
    /**
     * <p>销售状态编码</p>
     *
     * @return 销售状态编码
     */
    public String getSaleStatusCode() {
        return saleStatusCode;
    }

    /**
     * <p>销售状态编码</p>
     *
     * @param saleStatusCode 销售状态编码
     */
    public void setSaleStatusCode(String saleStatusCode) {
        this.saleStatusCode = saleStatusCode;
    }
    /**
     * <p>销售状态名称</p>
     *
     * @return 销售状态名称
     */
    public String getSaleStatusName() {
        return saleStatusName;
    }

    /**
     * <p>销售状态名称</p>
     *
     * @param saleStatusName 销售状态名称
     */
    public void setSaleStatusName(String saleStatusName) {
        this.saleStatusName = saleStatusName;
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
     * <p>品种学名</p>
     *
     * @return 品种学名
     */
    public String getBreedName() {
        return breedName;
    }

    /**
     * <p>品种学名</p>
     *
     * @param breedName 品种学名
     */
    public void setBreedName(String breedName) {
        this.breedName = breedName;
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
     * <p>质量等级，1：A1，2：A2，3：A3</p>
     *
     * @return 质量等级，1：A1，2：A2，3：A3
     */
    public String getQualityGradeTypeCode() {
        return qualityGradeTypeCode;
    }

    /**
     * <p>质量等级，1：A1，2：A2，3：A3</p>
     *
     * @param qualityGradeTypeCode 质量等级，1：A1，2：A2，3：A3
     */
    public void setQualityGradeTypeCode(String qualityGradeTypeCode) {
        this.qualityGradeTypeCode = qualityGradeTypeCode;
    }
    /**
     * <p>质量等级，1：A1，2：A2，3：A3</p>
     *
     * @return 质量等级，1：A1，2：A2，3：A3
     */
    public String getQualityGradeTypeName() {
        return qualityGradeTypeName;
    }

    /**
     * <p>质量等级，1：A1，2：A2，3：A3</p>
     *
     * @param qualityGradeTypeName 质量等级，1：A1，2：A2，3：A3
     */
    public void setQualityGradeTypeName(String qualityGradeTypeName) {
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
    public String getPackageSpecification() {
        return packageSpecification;
    }

    /**
     * <p>包装规格</p>
     *
     * @param packageSpecification 包装规格
     */
    public void setPackageSpecification(String packageSpecification) {
        this.packageSpecification = packageSpecification;
    }
    /**
     * <p>包装数量</p>
     *
     * @return 包装数量
     */
    public Integer getPackageQuantity() {
        return packageQuantity;
    }

    /**
     * <p>包装数量</p>
     *
     * @param packageQuantity 包装数量
     */
    public void setPackageQuantity(Integer packageQuantity) {
        this.packageQuantity = packageQuantity;
    }
    /**
     * <p>包装数量</p>
     *
     * @return 包装数量
     */
    public String getCartonDimension() {
        return cartonDimension;
    }

    /**
     * <p>包装数量</p>
     *
     * @param cartonDimension 包装数量
     */
    public void setCartonDimension(String cartonDimension) {
        this.cartonDimension = cartonDimension;
    }
    /**
     * <p>单品品牌SKU</p>
     *
     * @return 单品品牌SKU
     */
    public String getBrandItemPropertySku() {
        return brandItemPropertySku;
    }

    /**
     * <p>单品品牌SKU</p>
     *
     * @param brandItemPropertySku 单品品牌SKU
     */
    public void setBrandItemPropertySku(String brandItemPropertySku) {
        this.brandItemPropertySku = brandItemPropertySku;
    }
    /**
     * <p>上下架状态，1：上架，2：下架</p>
     *
     * @return 上下架状态，1：上架，2：下架
     */
    public String getShelfStu() {
        return shelfStu;
    }

    /**
     * <p>上下架状态，1：上架，2：下架</p>
     *
     * @param shelfStu 上下架状态，1：上架，2：下架
     */
    public void setShelfStu(String shelfStu) {
        this.shelfStu = shelfStu;
    }

}
