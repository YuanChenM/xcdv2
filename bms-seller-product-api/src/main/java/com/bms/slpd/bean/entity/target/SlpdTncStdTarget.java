package com.bms.slpd.bean.entity.target;

import com.bms.slpd.bean.BaseTarget;

public class SlpdTncStdTarget extends BaseTarget {

    private boolean tncStdValAFlg;
    private boolean tncStdValBFlg;
    private boolean tncStdValCFlg;
    private boolean remarkFlg;

    public boolean isTncStdValAFlg() {
        return tncStdValAFlg;
    }

    public void setTncStdValAFlg(boolean tncStdValAFlg) {
        this.tncStdValAFlg = tncStdValAFlg;
    }

    public boolean isTncStdValBFlg() {
        return tncStdValBFlg;
    }

    public void setTncStdValBFlg(boolean tncStdValBFlg) {
        this.tncStdValBFlg = tncStdValBFlg;
    }

    public boolean isTncStdValCFlg() {
        return tncStdValCFlg;
    }

    public void setTncStdValCFlg(boolean tncStdValCFlg) {
        this.tncStdValCFlg = tncStdValCFlg;
    }

    public boolean isRemarkFlg() {
        return remarkFlg;
    }

    public void setRemarkFlg(boolean remarkFlg) {
        this.remarkFlg = remarkFlg;
    }

}
