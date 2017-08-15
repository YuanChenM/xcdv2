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
public class SlpdDifTspStdTarget extends BaseTarget {
    /** TSP_OK_DIF_VAL */
    private boolean tspOkDifValFlg;
    /** TSP_NG_DIF_VAL */
    private boolean tspNgDifValFlg;
    /** REMARK */
    private boolean remarkFlg;

    public boolean isTspOkDifValFlg() {
        return tspOkDifValFlg;
    }

    public void setTspOkDifValFlg(boolean tspOkDifValFlg) {
        this.tspOkDifValFlg = tspOkDifValFlg;
    }

    public boolean isTspNgDifValFlg() {
        return tspNgDifValFlg;
    }

    public void setTspNgDifValFlg(boolean tspNgDifValFlg) {
        this.tspNgDifValFlg = tspNgDifValFlg;
    }

    public boolean isRemarkFlg() {
        return remarkFlg;
    }

    public void setRemarkFlg(boolean remarkFlg) {
        this.remarkFlg = remarkFlg;
    }
}
