package com.bms.slpd.bean.param.field;

import java.io.Serializable;
import java.util.List;

public class SLPD1816ISearchProductParam implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Long> itemPropertyIds;
    private List<Long> itemIds;
    private List<Long> brandIds;

    public List<Long> getItemPropertyIds() {
        return itemPropertyIds;
    }

    public void setItemPropertyIds(List<Long> itemPropertyIds) {
        this.itemPropertyIds = itemPropertyIds;
    }

    public List<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }

    public List<Long> getBrandIds() {
        return brandIds;
    }

    public void setBrandIds(List<Long> brandIds) {
        this.brandIds = brandIds;
    }
}
