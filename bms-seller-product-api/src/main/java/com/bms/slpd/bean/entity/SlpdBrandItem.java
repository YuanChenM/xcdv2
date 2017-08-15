/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_BRAND_ITEM对应的实体SlpdBrandItem</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdBrandItem extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 单品品牌ID */
    private Long brandItemId;
    /** 单品品牌SKU */
    private String brandItemSku;
    /** 单品ID */
    private Long itemId;
    /** 品牌ID */
    private Long brandId;
    /** 审核状态，0：待审核，1：正式 */
    private Boolean auditStu;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdBrandItem() {
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
