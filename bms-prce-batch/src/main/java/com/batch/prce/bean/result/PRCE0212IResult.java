package com.batch.prce.bean.result;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PRCE0212IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 商品ID */
    private String commodityId;
    /** 商品code */
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
    private BigDecimal grossWeight;
    /** 净重（克） */
    private BigDecimal netWeight;
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
     * Getter method for property <tt>commodityId</tt>.
     *
     * @return property value of commodityId
     */
    public String getCommodityId() {
        return commodityId;
    }

    /**
     * Setter method for property <tt>commodityId</tt>.
     *
     * @param commodityId value to be assigned to property commodityId
     */
    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    /**
     * Getter method for property <tt>commodityCode</tt>.
     *
     * @return property value of commodityCode
     */
    public String getCommodityCode() {
        return commodityCode;
    }

    /**
     * Setter method for property <tt>commodityCode</tt>.
     *
     * @param commodityCode value to be assigned to property commodityCode
     */
    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    /**
     * Getter method for property <tt>commodityName</tt>.
     *
     * @return property value of commodityName
     */
    public String getCommodityName() {
        return commodityName;
    }

    /**
     * Setter method for property <tt>commodityName</tt>.
     *
     * @param commodityName value to be assigned to property commodityName
     */
    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    /**
     * Getter method for property <tt>lgcsAreaCode</tt>.
     *
     * @return property value of lgcsAreaCode
     */
    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    /**
     * Setter method for property <tt>lgcsAreaCode</tt>.
     *
     * @param lgcsAreaCode value to be assigned to property lgcsAreaCode
     */
    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    /**
     * Getter method for property <tt>lgcsAreaName</tt>.
     *
     * @return property value of lgcsAreaName
     */
    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    /**
     * Setter method for property <tt>lgcsAreaName</tt>.
     *
     * @param lgcsAreaName value to be assigned to property lgcsAreaName
     */
    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }

    /**
     * Getter method for property <tt>saleStatusId</tt>.
     *
     * @return property value of saleStatusId
     */
    public Long getSaleStatusId() {
        return saleStatusId;
    }

    /**
     * Setter method for property <tt>saleStatusId</tt>.
     *
     * @param saleStatusId value to be assigned to property saleStatusId
     */
    public void setSaleStatusId(Long saleStatusId) {
        this.saleStatusId = saleStatusId;
    }

    /**
     * Getter method for property <tt>saleStatusCode</tt>.
     *
     * @return property value of saleStatusCode
     */
    public String getSaleStatusCode() {
        return saleStatusCode;
    }

    /**
     * Setter method for property <tt>saleStatusCode</tt>.
     *
     * @param saleStatusCode value to be assigned to property saleStatusCode
     */
    public void setSaleStatusCode(String saleStatusCode) {
        this.saleStatusCode = saleStatusCode;
    }

    /**
     * Getter method for property <tt>saleStatusName</tt>.
     *
     * @return property value of saleStatusName
     */
    public String getSaleStatusName() {
        return saleStatusName;
    }

    /**
     * Setter method for property <tt>saleStatusName</tt>.
     *
     * @param saleStatusName value to be assigned to property saleStatusName
     */
    public void setSaleStatusName(String saleStatusName) {
        this.saleStatusName = saleStatusName;
    }

    /**
     * Getter method for property <tt>productId</tt>.
     *
     * @return property value of productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Setter method for property <tt>productId</tt>.
     *
     * @param productId value to be assigned to property productId
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * Getter method for property <tt>classesCode</tt>.
     *
     * @return property value of classesCode
     */
    public String getClassesCode() {
        return classesCode;
    }

    /**
     * Setter method for property <tt>classesCode</tt>.
     *
     * @param classesCode value to be assigned to property classesCode
     */
    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode;
    }

    /**
     * Getter method for property <tt>classesName</tt>.
     *
     * @return property value of classesName
     */
    public String getClassesName() {
        return classesName;
    }

    /**
     * Setter method for property <tt>classesName</tt>.
     *
     * @param classesName value to be assigned to property classesName
     */
    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    /**
     * Getter method for property <tt>machiningCode</tt>.
     *
     * @return property value of machiningCode
     */
    public String getMachiningCode() {
        return machiningCode;
    }

    /**
     * Setter method for property <tt>machiningCode</tt>.
     *
     * @param machiningCode value to be assigned to property machiningCode
     */
    public void setMachiningCode(String machiningCode) {
        this.machiningCode = machiningCode;
    }

    /**
     * Getter method for property <tt>machiningName</tt>.
     *
     * @return property value of machiningName
     */
    public String getMachiningName() {
        return machiningName;
    }

    /**
     * Setter method for property <tt>machiningName</tt>.
     *
     * @param machiningName value to be assigned to property machiningName
     */
    public void setMachiningName(String machiningName) {
        this.machiningName = machiningName;
    }

    /**
     * Getter method for property <tt>breedCode</tt>.
     *
     * @return property value of breedCode
     */
    public String getBreedCode() {
        return breedCode;
    }

    /**
     * Setter method for property <tt>breedCode</tt>.
     *
     * @param breedCode value to be assigned to property breedCode
     */
    public void setBreedCode(String breedCode) {
        this.breedCode = breedCode;
    }

    /**
     * Getter method for property <tt>breedName</tt>.
     *
     * @return property value of breedName
     */
    public String getBreedName() {
        return breedName;
    }

    /**
     * Setter method for property <tt>breedName</tt>.
     *
     * @param breedName value to be assigned to property breedName
     */
    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    /**
     * Getter method for property <tt>itemCode</tt>.
     *
     * @return property value of itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * Setter method for property <tt>itemCode</tt>.
     *
     * @param itemCode value to be assigned to property itemCode
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * Getter method for property <tt>itemName</tt>.
     *
     * @return property value of itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Setter method for property <tt>itemName</tt>.
     *
     * @param itemName value to be assigned to property itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Getter method for property <tt>brandCode</tt>.
     *
     * @return property value of brandCode
     */
    public String getBrandCode() {
        return brandCode;
    }

    /**
     * Setter method for property <tt>brandCode</tt>.
     *
     * @param brandCode value to be assigned to property brandCode
     */
    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    /**
     * Getter method for property <tt>brandName</tt>.
     *
     * @return property value of brandName
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * Setter method for property <tt>brandName</tt>.
     *
     * @param brandName value to be assigned to property brandName
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * Getter method for property <tt>qualityGradeTypeCode</tt>.
     *
     * @return property value of qualityGradeTypeCode
     */
    public String getQualityGradeTypeCode() {
        return qualityGradeTypeCode;
    }

    /**
     * Setter method for property <tt>qualityGradeTypeCode</tt>.
     *
     * @param qualityGradeTypeCode value to be assigned to property qualityGradeTypeCode
     */
    public void setQualityGradeTypeCode(String qualityGradeTypeCode) {
        this.qualityGradeTypeCode = qualityGradeTypeCode;
    }

    /**
     * Getter method for property <tt>qualityGradeTypeName</tt>.
     *
     * @return property value of qualityGradeTypeName
     */
    public String getQualityGradeTypeName() {
        return qualityGradeTypeName;
    }

    /**
     * Setter method for property <tt>qualityGradeTypeName</tt>.
     *
     * @param qualityGradeTypeName value to be assigned to property qualityGradeTypeName
     */
    public void setQualityGradeTypeName(String qualityGradeTypeName) {
        this.qualityGradeTypeName = qualityGradeTypeName;
    }

    /**
     * Getter method for property <tt>grossWeight</tt>.
     *
     * @return property value of grossWeight
     */
    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    /**
     * Setter method for property <tt>grossWeight</tt>.
     *
     * @param grossWeight value to be assigned to property grossWeight
     */
    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }

    /**
     * Getter method for property <tt>netWeight</tt>.
     *
     * @return property value of netWeight
     */
    public BigDecimal getNetWeight() {
        return netWeight;
    }

    /**
     * Setter method for property <tt>netWeight</tt>.
     *
     * @param netWeight value to be assigned to property netWeight
     */
    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    /**
     * Getter method for property <tt>packageSpecification</tt>.
     *
     * @return property value of packageSpecification
     */
    public String getPackageSpecification() {
        return packageSpecification;
    }

    /**
     * Setter method for property <tt>packageSpecification</tt>.
     *
     * @param packageSpecification value to be assigned to property packageSpecification
     */
    public void setPackageSpecification(String packageSpecification) {
        this.packageSpecification = packageSpecification;
    }

    /**
     * Getter method for property <tt>packageQuantity</tt>.
     *
     * @return property value of packageQuantity
     */
    public Integer getPackageQuantity() {
        return packageQuantity;
    }

    /**
     * Setter method for property <tt>packageQuantity</tt>.
     *
     * @param packageQuantity value to be assigned to property packageQuantity
     */
    public void setPackageQuantity(Integer packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    /**
     * Getter method for property <tt>cartonDimension</tt>.
     *
     * @return property value of cartonDimension
     */
    public String getCartonDimension() {
        return cartonDimension;
    }

    /**
     * Setter method for property <tt>cartonDimension</tt>.
     *
     * @param cartonDimension value to be assigned to property cartonDimension
     */
    public void setCartonDimension(String cartonDimension) {
        this.cartonDimension = cartonDimension;
    }

    /**
     * Getter method for property <tt>brandItemPropertySku</tt>.
     *
     * @return property value of brandItemPropertySku
     */
    public String getBrandItemPropertySku() {
        return brandItemPropertySku;
    }

    /**
     * Setter method for property <tt>brandItemPropertySku</tt>.
     *
     * @param brandItemPropertySku value to be assigned to property brandItemPropertySku
     */
    public void setBrandItemPropertySku(String brandItemPropertySku) {
        this.brandItemPropertySku = brandItemPropertySku;
    }

    /**
     * Getter method for property <tt>shelfStu</tt>.
     *
     * @return property value of shelfStu
     */
    public String getShelfStu() {
        return shelfStu;
    }

    /**
     * Setter method for property <tt>shelfStu</tt>.
     *
     * @param shelfStu value to be assigned to property shelfStu
     */
    public void setShelfStu(String shelfStu) {
        this.shelfStu = shelfStu;
    }
}
