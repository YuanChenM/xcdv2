package com.batch.order.bean.result;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by liutao on 2017/1/5.
 */
public class ORDR0201BSupplierInvResult implements Serializable {

    private String producerId;

    private String commodityId;

    private String ivType;

    private BigDecimal availableQty;

    private List<ORDR0201BSellerResult> sellerResults;

    public String getProducerId() {
        return producerId;
    }

    public void setProducerId(String producerId) {
        this.producerId = producerId;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getIvType() {
        return ivType;
    }

    public void setIvType(String ivType) {
        this.ivType = ivType;
    }

    public BigDecimal getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(BigDecimal availableQty) {
        this.availableQty = availableQty;
    }

    public List<ORDR0201BSellerResult> getSellerResults() {
        return sellerResults;
    }

    public void setSellerResults(List<ORDR0201BSellerResult> sellerResults) {
        this.sellerResults = sellerResults;
    }
}
