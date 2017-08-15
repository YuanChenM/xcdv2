package com.bms.order.external.bean.param;

import com.bms.order.common.rest.param.RestBean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 */
public class COMO0203IRestParam extends RestBean {
    /**
     *
     */
    private static final long serialVersionUID = 4966684673548754807L;

    /* 单品ID集合 */
    private List<String> itemIds;

    public List<String> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<String> itemIds) {
        this.itemIds = itemIds;
    }
}
