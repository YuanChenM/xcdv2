package com.batch.bybatch.bean.param;

import java.io.Serializable;

/**
 * Created by yuan_zhifei on 2017/5/26.
 */
public class BuyerProductParam implements Serializable {
    //产品ID
    private String[] productIds;

    public String[] getProductIds() {
        return productIds;
    }

    public void setProductIds(String[] productIds) {
        this.productIds = productIds;
    }
}
