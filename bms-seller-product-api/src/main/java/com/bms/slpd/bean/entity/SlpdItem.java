/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_ITEM对应的实体SlpdItem</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdItem extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 单品ID */
    private Long itemId;
    /** 一级分类ID */
    private Long classesId;
    /** 二级分类ID */
    private Long machiningId;
    /** 品种ID */
    private Long breedId;
    /** 单品编码 */
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
    /** 审核状态，0：待审核，1：正式 */
    private Boolean auditStu;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdItem() {
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
     * <p>单品编码</p>
     *
     * @return 单品编码
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * <p>单品编码</p>
     *
     * @param itemCode 单品编码
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
