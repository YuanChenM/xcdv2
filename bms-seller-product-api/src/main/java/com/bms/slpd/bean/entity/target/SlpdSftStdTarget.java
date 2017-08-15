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
public class SlpdSftStdTarget extends BaseTarget {
    /** GNQ_OK_VAL */
    private boolean sftOkValFlg;
    /** GNQ_NG_VAL */
    private boolean sftNgValFlg;
    /** REMARK */
    private boolean remarkFlg;

    public boolean isSftOkValFlg() {
        return sftOkValFlg;
    }

    public void setSftOkValFlg(boolean sftOkValFlg) {
        this.sftOkValFlg = sftOkValFlg;
    }

    public boolean isSftNgValFlg() {
        return sftNgValFlg;
    }

    public void setSftNgValFlg(boolean sftNgValFlg) {
        this.sftNgValFlg = sftNgValFlg;
    }

    public boolean isRemarkFlg() {
        return remarkFlg;
    }

    public void setRemarkFlg(boolean remarkFlg) {
        this.remarkFlg = remarkFlg;
    }
}
