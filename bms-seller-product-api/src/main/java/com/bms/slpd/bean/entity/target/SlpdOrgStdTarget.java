package com.bms.slpd.bean.entity.target;

import com.bms.slpd.bean.BaseTarget;

public class SlpdOrgStdTarget extends BaseTarget {

    private boolean orgGoodValFlg;
    private boolean orgNormalValFlg;
    private boolean orgOkValFlg;
    private boolean remarkFlg;

    public boolean isOrgGoodValFlg() {
        return orgGoodValFlg;
    }

    public void setOrgGoodValFlg(boolean orgGoodValFlg) {
        this.orgGoodValFlg = orgGoodValFlg;
    }

    public boolean isOrgNormalValFlg() {
        return orgNormalValFlg;
    }

    public void setOrgNormalValFlg(boolean orgNormalValFlg) {
        this.orgNormalValFlg = orgNormalValFlg;
    }

    public boolean isOrgOkValFlg() {
        return orgOkValFlg;
    }

    public void setOrgOkValFlg(boolean orgOkValFlg) {
        this.orgOkValFlg = orgOkValFlg;
    }

    public boolean isRemarkFlg() {
        return remarkFlg;
    }

    public void setRemarkFlg(boolean remarkFlg) {
        this.remarkFlg = remarkFlg;
    }

}
