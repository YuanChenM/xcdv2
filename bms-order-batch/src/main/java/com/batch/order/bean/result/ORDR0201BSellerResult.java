package com.batch.order.bean.result;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by liutao on 2017/1/6.
 */
public class ORDR0201BSellerResult implements Serializable {

    private BigDecimal availableQty;

    private String ownerId;

    private String sku;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public BigDecimal getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(BigDecimal availableQty) {
        this.availableQty = availableQty;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
