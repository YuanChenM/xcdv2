package com.batch.prce.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;

/**
 * 商品同步
 *
 * @author sunjiaju
 * @version 1.0
 * @Time 2017/2/17
 */
public class GoodSyncBParam extends BaseRestPaginationParam {

    private String[] commodityId;


    public String[] getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String[] commodityId) {
        this.commodityId = commodityId;
    }
}
