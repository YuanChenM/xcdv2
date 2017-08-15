package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestFilter;

/**
 * 商品
 * Created by ni_shaotang on 2017/3/29.
 */
public class ORDR0107ICommodityParam extends RestFilter {
    //商品ID
    private String commodityId;

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }
}
