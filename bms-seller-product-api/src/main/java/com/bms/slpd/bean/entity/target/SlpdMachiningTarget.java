package com.bms.slpd.bean.entity.target;

import com.bms.slpd.bean.BaseTarget;

/**
 * Created by li_kai1 on 2016/12/19.
 */
public class SlpdMachiningTarget extends BaseTarget {

    private boolean machiningNameFlg;
    private boolean machiningCodeFlg;


    public boolean isMachiningNameFlg() {
        return machiningNameFlg;
    }

    public void setMachiningNameFlg(boolean machiningNameFlg) {
        this.machiningNameFlg = machiningNameFlg;
    }

    public boolean isMachiningCodeFlg() {
        return machiningCodeFlg;
    }

    public void setMachiningCodeFlg(boolean machiningCodeFlg) {
        this.machiningCodeFlg = machiningCodeFlg;
    }
}
