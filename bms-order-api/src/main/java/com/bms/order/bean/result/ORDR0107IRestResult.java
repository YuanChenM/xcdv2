package com.bms.order.bean.result;

import com.bms.order.common.rest.result.RestSearchData;

import java.math.BigDecimal;

/**
 * Created by ni_shaotang on 2017/3/29.
 */
public class ORDR0107IRestResult extends RestSearchData {
    //商品ID
    private String commodityId;
    //销量
    private BigDecimal salesVolumn;

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public BigDecimal getSalesVolumn() {
        return salesVolumn;
    }

    public void setSalesVolumn(BigDecimal salesVolumn) {
        this.salesVolumn = salesVolumn;
    }
}
