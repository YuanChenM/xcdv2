package com.bms.slpd.bean.entity.target;

import com.bms.slpd.bean.BaseTarget;

/**
 * Created by li_kai1 on 2016/12/19.
 */
public class SlpdBreedTarget extends BaseTarget {

    private boolean breedCodeFlg;
    private boolean breedSalesNameFlg;
    private boolean breedScientificNameFlg;
    private boolean breedLocalNameFlg;

    public boolean isBreedSalesNameFlg() {
        return breedSalesNameFlg;
    }

    public void setBreedSalesNameFlg(boolean breedSalesNameFlg) {
        this.breedSalesNameFlg = breedSalesNameFlg;
    }

    public boolean isBreedScientificNameFlg() {
        return breedScientificNameFlg;
    }

    public void setBreedScientificNameFlg(boolean breedScientificNameFlg) {
        this.breedScientificNameFlg = breedScientificNameFlg;
    }

    public boolean isBreedLocalNameFlg() {
        return breedLocalNameFlg;
    }

    public void setBreedLocalNameFlg(boolean breedLocalNameFlg) {
        this.breedLocalNameFlg = breedLocalNameFlg;
    }

    public boolean isBreedCodeFlg() {
        return breedCodeFlg;
    }

    public void setBreedCodeFlg(boolean breedCodeFlg) {
        this.breedCodeFlg = breedCodeFlg;
    }
}
