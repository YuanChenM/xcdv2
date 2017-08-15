/*
 * 2017/03/30 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表slpd_product对应的实体SlpdProduct</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdProduct extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键ID */
    private Long id;
    /** 产品ID */
    private String productId;
    /** 质量等级，1：A1，2：A2，3：A3 */
    private String qualityGradeType;
    /** 净重 */
    private java.math.BigDecimal netWeight;
    /** 净重编码 */
    private String netWeightCode;
    /** 审核状态，0：未注册，1：审核中，2：试销，3：正式，4：禁止准入，5：黑名单 */
    private String auditStu;
    /** 审核备注 */
    private String auditRemark;
    /** 审核履历，格式：0,未注册,admin,2017-01-25; */
    private String auditHistory;
    /** 单品规格ID */
    private Long itemPropertyId;
    /** 单品品牌规格SKU */
    private String brandItemPropertySku;
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
    /** 品牌类型，1：一线品牌，2：二线品牌，3：一二线外品牌 */
    private String brandType;
    /** 单品ID */
    private Long itemId;
    /** 单品特征编码 */
    private String itemCode;
    /** 单品SKU */
    private String itemSku;
    /** 单品名称 */
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

    /**
     * <p>默认构造函数</p>
     */
    public SlpdProduct() {
    }

    /**
     * <p>主键ID</p>
     *
     * @return 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * <p>主键ID</p>
     *
     * @param id 主键ID
     */
    public void setId(Long id) {
        this.id = id;
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
     * <p>净重</p>
     *
     * @return 净重
     */
    public java.math.BigDecimal getNetWeight() {
        return netWeight;
    }

    /**
     * <p>净重</p>
     *
     * @param netWeight 净重
     */
    public void setNetWeight(java.math.BigDecimal netWeight) {
        this.netWeight = netWeight;
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
     * <p>审核状态，0：未注册，1：审核中，2：试销，3：正式，4：禁止准入，5：黑名单</p>
     *
     * @return 审核状态，0：未注册，1：审核中，2：试销，3：正式，4：禁止准入，5：黑名单
     */
    public String getAuditStu() {
        return auditStu;
    }

    /**
     * <p>审核状态，0：未注册，1：审核中，2：试销，3：正式，4：禁止准入，5：黑名单</p>
     *
     * @param auditStu 审核状态，0：未注册，1：审核中，2：试销，3：正式，4：禁止准入，5：黑名单
     */
    public void setAuditStu(String auditStu) {
        this.auditStu = auditStu;
    }
    /**
     * <p>审核备注</p>
     *
     * @return 审核备注
     */
    public String getAuditRemark() {
        return auditRemark;
    }

    /**
     * <p>审核备注</p>
     *
     * @param auditRemark 审核备注
     */
    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }
    /**
     * <p>审核履历，格式：0,未注册,admin,2017-01-25;</p>
     *
     * @return 审核履历，格式：0,未注册,admin,2017-01-25;
     */
    public String getAuditHistory() {
        return auditHistory;
    }

    /**
     * <p>审核履历，格式：0,未注册,admin,2017-01-25;</p>
     *
     * @param auditHistory 审核履历，格式：0,未注册,admin,2017-01-25;
     */
    public void setAuditHistory(String auditHistory) {
        this.auditHistory = auditHistory;
    }
    /**
     * <p>单品规格ID</p>
     *
     * @return 单品规格ID
     */
    public Long getItemPropertyId() {
        return itemPropertyId;
    }

    /**
     * <p>单品规格ID</p>
     *
     * @param itemPropertyId 单品规格ID
     */
    public void setItemPropertyId(Long itemPropertyId) {
        this.itemPropertyId = itemPropertyId;
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
     * <p>单品品牌ID</p>
     *
     * @return 单品品牌ID
     */
    public Long getBrandItemId() {
        return brandItemId;
    }

    /**
     * <p>单品品牌ID</p>
     *
     * @param brandItemId 单品品牌ID
     */
    public void setBrandItemId(Long brandItemId) {
        this.brandItemId = brandItemId;
    }
    /**
     * <p>单品品牌SKU</p>
     *
     * @return 单品品牌SKU
     */
    public String getBrandItemSku() {
        return brandItemSku;
    }

    /**
     * <p>单品品牌SKU</p>
     *
     * @param brandItemSku 单品品牌SKU
     */
    public void setBrandItemSku(String brandItemSku) {
        this.brandItemSku = brandItemSku;
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
     * <p>品牌类型，1：一线品牌，2：二线品牌，3：一二线外品牌</p>
     *
     * @return 品牌类型，1：一线品牌，2：二线品牌，3：一二线外品牌
     */
    public String getBrandType() {
        return brandType;
    }

    /**
     * <p>品牌类型，1：一线品牌，2：二线品牌，3：一二线外品牌</p>
     *
     * @param brandType 品牌类型，1：一线品牌，2：二线品牌，3：一二线外品牌
     */
    public void setBrandType(String brandType) {
        this.brandType = brandType;
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
     * <p>规格</p>
     *
     * @return 规格
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * <p>规格</p>
     *
     * @param specification 规格
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }
    /**
     * <p>加工方式</p>
     *
     * @return 加工方式
     */
    public String getProcessingMethod() {
        return processingMethod;
    }

    /**
     * <p>加工方式</p>
     *
     * @param processingMethod 加工方式
     */
    public void setProcessingMethod(String processingMethod) {
        this.processingMethod = processingMethod;
    }
    /**
     * <p>口味</p>
     *
     * @return 口味
     */
    public String getTaste() {
        return taste;
    }

    /**
     * <p>口味</p>
     *
     * @param taste 口味
     */
    public void setTaste(String taste) {
        this.taste = taste;
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
     * <p>品种SKU</p>
     *
     * @return 品种SKU
     */
    public String getBreedSku() {
        return breedSku;
    }

    /**
     * <p>品种SKU</p>
     *
     * @param breedSku 品种SKU
     */
    public void setBreedSku(String breedSku) {
        this.breedSku = breedSku;
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
     * <p>品种学名</p>
     *
     * @return 品种学名
     */
    public String getBreedScientificName() {
        return breedScientificName;
    }

    /**
     * <p>品种学名</p>
     *
     * @param breedScientificName 品种学名
     */
    public void setBreedScientificName(String breedScientificName) {
        this.breedScientificName = breedScientificName;
    }
    /**
     * <p>品种俗名</p>
     *
     * @return 品种俗名
     */
    public String getBreedLocalName() {
        return breedLocalName;
    }

    /**
     * <p>品种俗名</p>
     *
     * @param breedLocalName 品种俗名
     */
    public void setBreedLocalName(String breedLocalName) {
        this.breedLocalName = breedLocalName;
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

}
