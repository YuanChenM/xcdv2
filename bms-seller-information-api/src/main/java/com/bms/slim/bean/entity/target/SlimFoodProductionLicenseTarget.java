package com.bms.slim.bean.entity.target;

import com.bms.slim.bean.BaseTarget;

/**
 * <p>SLIM0230I批量修改生产商生产资质-食品生产许可证指定更新的字段，true：更新，false：不更新。</p>
 */
public class SlimFoodProductionLicenseTarget extends BaseTarget {
    /** 卖家角色ID */
    private boolean sellerRoleIdFlg;
    /** 证书编号 */
    private boolean certNoFlg;
    /** 品类范围 */
    private boolean categoryRangeFlg;
    /** 有效期 */
    private boolean validPeriodFlg;
    /** 食品生产许可证URL */
    private boolean foodProdLicUrlFlg;

    public boolean isSellerRoleIdFlg() {
        return sellerRoleIdFlg;
    }

    public void setSellerRoleIdFlg(boolean sellerRoleIdFlg) {
        this.sellerRoleIdFlg = sellerRoleIdFlg;
    }

    public boolean isCertNoFlg() {
        return certNoFlg;
    }

    public void setCertNoFlg(boolean certNoFlg) {
        this.certNoFlg = certNoFlg;
    }

    public boolean isCategoryRangeFlg() {
        return categoryRangeFlg;
    }

    public void setCategoryRangeFlg(boolean categoryRangeFlg) {
        this.categoryRangeFlg = categoryRangeFlg;
    }

    public boolean isValidPeriodFlg() {
        return validPeriodFlg;
    }

    public void setValidPeriodFlg(boolean validPeriodFlg) {
        this.validPeriodFlg = validPeriodFlg;
    }

    public boolean isFoodProdLicUrlFlg() {
        return foodProdLicUrlFlg;
    }

    public void setFoodProdLicUrlFlg(boolean foodProdLicUrlFlg) {
        this.foodProdLicUrlFlg = foodProdLicUrlFlg;
    }
}
