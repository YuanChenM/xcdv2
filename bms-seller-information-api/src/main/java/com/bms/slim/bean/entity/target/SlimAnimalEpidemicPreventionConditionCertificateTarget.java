package com.bms.slim.bean.entity.target;

import com.bms.slim.bean.BaseTarget;

/**
 * <p>SLIM0230I批量修改生产商生产资质-动物防疫条件合格证指定更新的字段，true：更新，false：不更新。</p>
 */
public class SlimAnimalEpidemicPreventionConditionCertificateTarget extends BaseTarget {

    /** 卖家角色ID */
    private boolean sellerRoleIdFlg;
    /** 证号 */
    private boolean certNoFlg;
    /** 有效期 */
    private boolean validPeriodFlg;
    /** 动物防疫条件合格证URL */
    private boolean aniEpiPrevContCertUrlFlg;

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

    public boolean isValidPeriodFlg() {
        return validPeriodFlg;
    }

    public void setValidPeriodFlg(boolean validPeriodFlg) {
        this.validPeriodFlg = validPeriodFlg;
    }

    public boolean isAniEpiPrevContCertUrlFlg() {
        return aniEpiPrevContCertUrlFlg;
    }

    public void setAniEpiPrevContCertUrlFlg(boolean aniEpiPrevContCertUrlFlg) {
        this.aniEpiPrevContCertUrlFlg = aniEpiPrevContCertUrlFlg;
    }
}
