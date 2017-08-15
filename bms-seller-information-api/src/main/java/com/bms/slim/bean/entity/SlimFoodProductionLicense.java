/*
 * 2017/03/15 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表slim_food_production_license对应的实体SlimFoodProductionLicense</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimFoodProductionLicense extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键ID */
    private Long fplId;
    /** 卖家角色ID */
    private Long sellerRoleId;
    /** 证书编号 */
    private String certNo;
    /** 品类范围 */
    private String categoryRange;
    /** 有效期 */
    private String validPeriod;
    /** 食品生产许可证URL */
    private String foodProdLicUrl;

    /**
     * <p>默认构造函数</p>
     */
    public SlimFoodProductionLicense() {
    }

    /**
     * <p>主键ID</p>
     *
     * @return 主键ID
     */
    public Long getFplId() {
        return fplId;
    }

    /**
     * <p>主键ID</p>
     *
     * @param fplId 主键ID
     */
    public void setFplId(Long fplId) {
        this.fplId = fplId;
    }
    /**
     * <p>卖家角色ID</p>
     *
     * @return 卖家角色ID
     */
    public Long getSellerRoleId() {
        return sellerRoleId;
    }

    /**
     * <p>卖家角色ID</p>
     *
     * @param sellerRoleId 卖家角色ID
     */
    public void setSellerRoleId(Long sellerRoleId) {
        this.sellerRoleId = sellerRoleId;
    }
    /**
     * <p>证书编号</p>
     *
     * @return 证书编号
     */
    public String getCertNo() {
        return certNo;
    }

    /**
     * <p>证书编号</p>
     *
     * @param certNo 证书编号
     */
    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }
    /**
     * <p>品类范围</p>
     *
     * @return 品类范围
     */
    public String getCategoryRange() {
        return categoryRange;
    }

    /**
     * <p>品类范围</p>
     *
     * @param categoryRange 品类范围
     */
    public void setCategoryRange(String categoryRange) {
        this.categoryRange = categoryRange;
    }
    /**
     * <p>有效期</p>
     *
     * @return 有效期
     */
    public String getValidPeriod() {
        return validPeriod;
    }

    /**
     * <p>有效期</p>
     *
     * @param validPeriod 有效期
     */
    public void setValidPeriod(String validPeriod) {
        this.validPeriod = validPeriod;
    }
    /**
     * <p>食品生产许可证URL</p>
     *
     * @return 食品生产许可证URL
     */
    public String getFoodProdLicUrl() {
        return foodProdLicUrl;
    }

    /**
     * <p>食品生产许可证URL</p>
     *
     * @param foodProdLicUrl 食品生产许可证URL
     */
    public void setFoodProdLicUrl(String foodProdLicUrl) {
        this.foodProdLicUrl = foodProdLicUrl;
    }

}
