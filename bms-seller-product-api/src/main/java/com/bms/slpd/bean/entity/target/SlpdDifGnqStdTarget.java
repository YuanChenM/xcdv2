package com.bms.slpd.bean.entity.target;

import com.bms.slpd.bean.BaseTarget;

public class SlpdDifGnqStdTarget extends BaseTarget {

    private boolean gnqOkDifValFlg;
    private boolean gnqNgDifValFlg;
    private boolean remarkFlg;

    public boolean isGnqOkDifValFlg() {
        return gnqOkDifValFlg;
    }

    public void setGnqOkDifValFlg(boolean gnqOkDifValFlg) {
        this.gnqOkDifValFlg = gnqOkDifValFlg;
    }

    public boolean isGnqNgDifValFlg() {
        return gnqNgDifValFlg;
    }

    public void setGnqNgDifValFlg(boolean gnqNgDifValFlg) {
        this.gnqNgDifValFlg = gnqNgDifValFlg;
    }

    public boolean isRemarkFlg() {
        return remarkFlg;
    }

    public void setRemarkFlg(boolean remarkFlg) {
        this.remarkFlg = remarkFlg;
    }

}
