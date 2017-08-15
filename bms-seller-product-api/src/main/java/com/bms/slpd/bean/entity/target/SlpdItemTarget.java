package com.bms.slpd.bean.entity.target;

import com.bms.slpd.bean.BaseTarget;

/**
 * Created by li_kai1 on 2016/12/20.
 */
public class SlpdItemTarget extends BaseTarget {
    private boolean itemNameFlg;
    private boolean specificationFlg;
    private boolean processingMethodFlg;
    private boolean tasteFlg;

    public boolean isItemNameFlg() {
        return itemNameFlg;
    }

    public void setItemNameFlg(boolean itemNameFlg) {
        this.itemNameFlg = itemNameFlg;
    }

    public boolean isSpecificationFlg() {
        return specificationFlg;
    }

    public void setSpecificationFlg(boolean specificationFlg) {
        this.specificationFlg = specificationFlg;
    }

    public boolean isProcessingMethodFlg() {
        return processingMethodFlg;
    }

    public void setProcessingMethodFlg(boolean processingMethodFlg) {
        this.processingMethodFlg = processingMethodFlg;
    }

    public boolean isTasteFlg() {
        return tasteFlg;
    }

    public void setTasteFlg(boolean tasteFlg) {
        this.tasteFlg = tasteFlg;
    }
}
