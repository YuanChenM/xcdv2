package com.bms.slpd.bean.entity.target;

import com.bms.slpd.bean.BaseTarget;

public class SlpdBrandItemTarget extends BaseTarget {

    /** 单品ID */
    private boolean itemIdFlg;
    /** 品牌ID */
    private boolean brandIdFlg;

    public boolean isItemIdFlg() {
        return itemIdFlg;
    }

    public void setItemIdFlg(boolean itemIdFlg) {
        this.itemIdFlg = itemIdFlg;
    }

    public boolean isBrandIdFlg() {
        return brandIdFlg;
    }

    public void setBrandIdFlg(boolean brandIdFlg) {
        this.brandIdFlg = brandIdFlg;
    }

}
