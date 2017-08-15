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
public class SlpdMctStdTarget extends BaseTarget {

    /** MCT_OK_VAL */
    private boolean mctOkValFlg;
    /** MCT_NG_VAL */
    private boolean mctNgValFlg;
    /** REMARK */
    private boolean remarkFlg;


    public boolean isMctOkValFlg() {
        return mctOkValFlg;
    }

    public void setMctOkValFlg(boolean mctOkValFlg) {
        this.mctOkValFlg = mctOkValFlg;
    }

    public boolean isMctNgValFlg() {
        return mctNgValFlg;
    }

    public void setMctNgValFlg(boolean mctNgValFlg) {
        this.mctNgValFlg = mctNgValFlg;
    }

    public boolean isRemarkFlg() {
        return remarkFlg;
    }

    public void setRemarkFlg(boolean remarkFlg) {
        this.remarkFlg = remarkFlg;
    }

}
