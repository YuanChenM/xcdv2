package com.bms.slpd.bean.entity.target;

import com.bms.slpd.bean.BaseTarget;

public class SlpdDifFedStdTarget extends BaseTarget {

    private boolean fedGoodDifValFlg;
    private boolean fedNormalDifValFlg;
    private boolean fedOkDifValFlg;
    private boolean remarkFlg;

    public boolean isFedGoodDifValFlg() {
        return fedGoodDifValFlg;
    }

    public void setFedGoodDifValFlg(boolean fedGoodDifValFlg) {
        this.fedGoodDifValFlg = fedGoodDifValFlg;
    }

    public boolean isFedNormalDifValFlg() {
        return fedNormalDifValFlg;
    }

    public void setFedNormalDifValFlg(boolean fedNormalDifValFlg) {
        this.fedNormalDifValFlg = fedNormalDifValFlg;
    }

    public boolean isFedOkDifValFlg() {
        return fedOkDifValFlg;
    }

    public void setFedOkDifValFlg(boolean fedOkDifValFlg) {
        this.fedOkDifValFlg = fedOkDifValFlg;
    }

    public boolean isRemarkFlg() {
        return remarkFlg;
    }

    public void setRemarkFlg(boolean remarkFlg) {
        this.remarkFlg = remarkFlg;
    }

}
