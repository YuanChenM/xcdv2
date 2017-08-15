package com.bms.slpd.bean.entity.target;

import com.bms.slpd.bean.BaseTarget;

/**
 * Created by li_kai1 on 2016/12/19.
 */
public class SlpdClassesTarget extends BaseTarget {
    private boolean classesNameFlg;
    private boolean classesCodeFlg;


    public boolean isClassesNameFlg() {
        return classesNameFlg;
    }

    public void setClassesNameFlg(boolean classesNameFlg) {
        this.classesNameFlg = classesNameFlg;
    }

    public boolean isClassesCodeFlg() {
        return classesCodeFlg;
    }

    public void setClassesCodeFlg(boolean classesCodeFlg) {
        this.classesCodeFlg = classesCodeFlg;
    }
}
