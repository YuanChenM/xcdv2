package com.bms.slim.bean.entity.target;

import com.bms.slim.bean.BaseTarget;

/**
 * <p>SLIM0230I批量修改生产商生产资质-进沪(京、津)登记信息指定更新的字段，true：更新，false：不更新。</p>
 */
public class SlimShBjTjRegistrationTarget extends BaseTarget {
    /** 生产商ID */
    private boolean sellerRoleIdFlg;
    /** 单位名称 */
    private boolean workunitNameFlg;
    /** 产品品类名称 */
    private boolean productCategoryNameFlg;
    /** 登记日期 */
    private boolean regDateFlg;
    /** 进沪(京、津)登记URL */
    private boolean sbtRegUrlFlg;

    public boolean isSellerRoleIdFlg() {
        return sellerRoleIdFlg;
    }

    public void setSellerRoleIdFlg(boolean sellerRoleIdFlg) {
        this.sellerRoleIdFlg = sellerRoleIdFlg;
    }

    public boolean isWorkunitNameFlg() {
        return workunitNameFlg;
    }

    public void setWorkunitNameFlg(boolean workunitNameFlg) {
        this.workunitNameFlg = workunitNameFlg;
    }

    public boolean isProductCategoryNameFlg() {
        return productCategoryNameFlg;
    }

    public void setProductCategoryNameFlg(boolean productCategoryNameFlg) {
        this.productCategoryNameFlg = productCategoryNameFlg;
    }

    public boolean isRegDateFlg() {
        return regDateFlg;
    }

    public void setRegDateFlg(boolean regDateFlg) {
        this.regDateFlg = regDateFlg;
    }

    public boolean isSbtRegUrlFlg() {
        return sbtRegUrlFlg;
    }

    public void setSbtRegUrlFlg(boolean sbtRegUrlFlg) {
        this.sbtRegUrlFlg = sbtRegUrlFlg;
    }
}
