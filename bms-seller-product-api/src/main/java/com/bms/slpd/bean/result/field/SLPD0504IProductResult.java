package com.bms.slpd.bean.result.field;

import java.io.Serializable;
import java.util.Date;

public class SLPD0504IProductResult implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;
    /** 产品ID */
    private String productId;
    /** 质量等级 */
    private String qualityGradeType;
    /** 审核状态 */
    private String auditStu;
    /** 审核备注 */
    private String auditRemark;
    /** 审核履历 */
    private String auditHistory;
    /** 单品品牌规格ID */
    private Long brandItemPropertyId;
    /** 单品品牌规格Sku */
    private Long brandItemPropertySku;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getQualityGradeType() {
        return qualityGradeType;
    }

    public void setQualityGradeType(String qualityGradeType) {
        this.qualityGradeType = qualityGradeType;
    }

    public String getAuditStu() {
        return auditStu;
    }

    public void setAuditStu(String auditStu) {
        this.auditStu = auditStu;
    }

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }

    public String getAuditHistory() {
        return auditHistory;
    }

    public void setAuditHistory(String auditHistory) {
        this.auditHistory = auditHistory;
    }

    public Long getBrandItemPropertyId() {
        return brandItemPropertyId;
    }

    public void setBrandItemPropertyId(Long brandItemPropertyId) {
        this.brandItemPropertyId = brandItemPropertyId;
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

    public Long getBrandItemPropertySku() {
        return brandItemPropertySku;
    }

    public void setBrandItemPropertySku(Long brandItemPropertySku) {
        this.brandItemPropertySku = brandItemPropertySku;
    }
}
