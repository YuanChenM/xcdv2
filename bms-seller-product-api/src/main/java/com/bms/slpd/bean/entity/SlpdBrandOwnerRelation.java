/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_BRAND_OWNER_RELATION对应的实体SlpdBrandOwnerRelation</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdBrandOwnerRelation extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 品牌与所有人关联ID */
    private Long boRelationId;
    /** 品牌ID */
    private Long brandId;
    /** 品牌所有人ID */
    private Long brandOwnerId;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdBrandOwnerRelation() {
    }

    /**
     * <p>品牌与所有人关联ID</p>
     *
     * @return 品牌与所有人关联ID
     */
    public Long getBoRelationId() {
        return boRelationId;
    }

    /**
     * <p>品牌与所有人关联ID</p>
     *
     * @param boRelationId 品牌与所有人关联ID
     */
    public void setBoRelationId(Long boRelationId) {
        this.boRelationId = boRelationId;
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
     * <p>品牌所有人ID</p>
     *
     * @return 品牌所有人ID
     */
    public Long getBrandOwnerId() {
        return brandOwnerId;
    }

    /**
     * <p>品牌所有人ID</p>
     *
     * @param brandOwnerId 品牌所有人ID
     */
    public void setBrandOwnerId(Long brandOwnerId) {
        this.brandOwnerId = brandOwnerId;
    }

}
