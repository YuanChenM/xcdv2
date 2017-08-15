package com.bms.slpd.bean.result.field;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SLPD1816IProductResult implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 单品规格ID */
    private Long itemPropertyId;
    /** 单品规格Sku */
    private String itemPropertyCode;
    /** 毛重（克） */
    private java.math.BigDecimal grossWeight;
    /** 包装规格 */
    private String packageSpecification;
    /** 包装数量 */
    private String packageQuantity;
    /** 纸箱尺寸（cm），长*宽*高 */
    private String cartonDimension;
    /** 纸箱长度（cm） */
    private java.math.BigDecimal cartonLength;
    /** 纸箱宽度（cm） */
    private java.math.BigDecimal cartonWidth;
    /** 纸箱高度（cm） */
    private java.math.BigDecimal cartonHeight;
    /** 托盘堆码数（箱） */
    private Integer palletStackingLimit;
    /** 单品品牌ID */
    private Long brandItemId;
    /** 单品品牌SKU */
    private String brandItemSku;
    /** 品牌ID */
    private Long brandId;
    /** 品牌编码 */
    private String brandCode;
    /** 品牌名称 */
    private String brandName;
    /** 品牌类型 */
    private String brandType;
    /** 单品ID */
    private Long itemId;
    /** 单品SKU */
    private String itemSku;
    /** 单品特征编码 */
    private String itemCode;
    /** 单品特征名称 */
    private String itemName;
    /** 规格 */
    private String specification;
    /** 加工方式 */
    private String processingMethod;
    /** 口味 */
    private String taste;
    /** 品种ID */
    private Long breedId;
    /** 品种编码 */
    private String breedCode;
    /** 品种SKU */
    private String breedSku;
    /** 品种标准市场销售名 */
    private String breedSalesName;
    /** 品种学名 */
    private String breedScientificName;
    /** 品种俗名 */
    private String breedLocalName;
    /** 二级分类ID */
    private Long machiningId;
    /** 二级分类编码 */
    private String machiningCode;
    /** 二级分类名称 */
    private String machiningName;
    /** 一级分类ID */
    private Long classesId;
    /** 一级分类编码 */
    private String classesCode;
    /** 一级分类名称 */
    private String classesName;
    /** 删除标识 */
    private boolean delFlg;
    /** 创建Id */
    private String crtId;
    /** 创建时间 */
    private Date crtTime;
    /** 更新Id */
    private String updId;
    /** 更新时间 */
    private Date updTime;
    /** 版本号 */
    private Integer version;

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

    public Long getBrandItemId() {
        return brandItemId;
    }

    public void setBrandItemId(Long brandItemId) {
        this.brandItemId = brandItemId;
    }

    public String getBrandItemSku() {
        return brandItemSku;
    }

    public void setBrandItemSku(String brandItemSku) {
        this.brandItemSku = brandItemSku;
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

    public String getBrandType() {
        return brandType;
    }

    public void setBrandType(String brandType) {
        this.brandType = brandType;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemSku() {
        return itemSku;
    }

    public void setItemSku(String itemSku) {
        this.itemSku = itemSku;
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

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getProcessingMethod() {
        return processingMethod;
    }

    public void setProcessingMethod(String processingMethod) {
        this.processingMethod = processingMethod;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
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

    public String getBreedSku() {
        return breedSku;
    }

    public void setBreedSku(String breedSku) {
        this.breedSku = breedSku;
    }

    public String getBreedSalesName() {
        return breedSalesName;
    }

    public void setBreedSalesName(String breedSalesName) {
        this.breedSalesName = breedSalesName;
    }

    public String getBreedScientificName() {
        return breedScientificName;
    }

    public void setBreedScientificName(String breedScientificName) {
        this.breedScientificName = breedScientificName;
    }

    public String getBreedLocalName() {
        return breedLocalName;
    }

    public void setBreedLocalName(String breedLocalName) {
        this.breedLocalName = breedLocalName;
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

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
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
}
