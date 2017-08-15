package com.bms.order.external.bean.result;

import com.bms.order.common.rest.param.RestFilter;
import com.bms.order.common.rest.result.RestSearchData;

import java.io.Serializable;

/**
 * Created by ni_shaotang on 2017/2/23.
 */
public class SLPD0805IRestResult extends RestSearchData {

    /* 商品ID */
    private String commodityId;
    /* 商品标题 */
    private String saleTitle;

    private SLPD0805IProduct product;

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getSaleTitle() {
        return saleTitle;
    }

    public void setSaleTitle(String saleTitle) {
        this.saleTitle = saleTitle;
    }

    public SLPD0805IProduct getProduct() {
        return product;
    }

    public void setProduct(SLPD0805IProduct product) {
        this.product = product;
    }
}
