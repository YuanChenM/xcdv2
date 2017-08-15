/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_BREED对应的实体SlpdBreed</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdBreed extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 品种ID */
    private Long breedId;
    /** 一级分类ID */
    private Long classesId;
    /** 二级分类ID */
    private Long machiningId;
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
    /** 审核状态，0：待审核，1：正式 */
    private Boolean auditStu;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdBreed() {
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
     * <p>审核状态，0：待审核，1：正式</p>
     *
     * @return 审核状态，0：待审核，1：正式
     */
    public Boolean getAuditStu() {
        return auditStu;
    }

    /**
     * <p>审核状态，0：待审核，1：正式</p>
     *
     * @param auditStu 审核状态，0：待审核，1：正式
     */
    public void setAuditStu(Boolean auditStu) {
        this.auditStu = auditStu;
    }

}
