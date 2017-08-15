package com.bms.slpd.bean.entity.target;

import com.bms.slpd.bean.BaseTarget;

public class SlpdTspStdTarget extends BaseTarget {

    private boolean tspOkValFlg;
    private boolean tspNgValFlg;
    private boolean remarkFlg;

    public boolean isTspOkValFlg() {
        return tspOkValFlg;
    }

    public void setTspOkValFlg(boolean tspOkValFlg) {
        this.tspOkValFlg = tspOkValFlg;
    }

    public boolean isTspNgValFlg() {
        return tspNgValFlg;
    }

    public void setTspNgValFlg(boolean tspNgValFlg) {
        this.tspNgValFlg = tspNgValFlg;
    }

    public boolean isRemarkFlg() {
        return remarkFlg;
    }

    public void setRemarkFlg(boolean remarkFlg) {
        this.remarkFlg = remarkFlg;
    }

}
