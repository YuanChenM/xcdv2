/*
 * 2016/12/12 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity.target;


import com.bms.slpd.bean.BaseTarget;


/**
 * <p>表SLPD_BRAND_ITEM_PROPERTY对应的实体SlpdBrandItemProperty</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdDifOrgStdTarget extends BaseTarget {

    /** MCT_STD_ID */
    private boolean orgGoodDifValFlg;
    /** MCT_STD_TYPE_ID */
    private boolean orgNormalDifValFlg;
    /** BREED_ID */
    private boolean orgOkDifValFlg;
    /** REMARK */
    private boolean remarkFlg;

    public boolean isOrgGoodDifValFlg() {
        return orgGoodDifValFlg;
    }

    public void setOrgGoodDifValFlg(boolean orgGoodDifValFlg) {
        this.orgGoodDifValFlg = orgGoodDifValFlg;
    }

    public boolean isOrgNormalDifValFlg() {
        return orgNormalDifValFlg;
    }

    public void setOrgNormalDifValFlg(boolean orgNormalDifValFlg) {
        this.orgNormalDifValFlg = orgNormalDifValFlg;
    }

    public boolean isOrgOkDifValFlg() {
        return orgOkDifValFlg;
    }

    public void setOrgOkDifValFlg(boolean orgOkDifValFlg) {
        this.orgOkDifValFlg = orgOkDifValFlg;
    }

    public boolean isRemarkFlg() {
        return remarkFlg;
    }

    public void setRemarkFlg(boolean remarkFlg) {
        this.remarkFlg = remarkFlg;
    }
}
