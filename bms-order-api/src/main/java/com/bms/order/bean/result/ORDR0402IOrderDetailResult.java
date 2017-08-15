package com.bms.order.bean.result;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by liutao on 2017/1/15.
 */
public class ORDR0402IOrderDetailResult implements Serializable {
    private Long detailId;

    private String proDate;

    private String salesLabel;

    private String pdCode;

    private String pdName;

    private String skuCode;

    private BigDecimal orderQty;

    private BigDecimal orderPrice;

    private List<ORDR0402IOrderPriceResult> priceList;

    public List<ORDR0402IOrderPriceResult> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<ORDR0402IOrderPriceResult> priceList) {
        this.priceList = priceList;
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public String getProDate() {
        return proDate;
    }

    public void setProDate(String proDate) {
        this.proDate = proDate;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getSalesLabel() {
        return salesLabel;
    }

    public void setSalesLabel(String salesLabel) {
        this.salesLabel = salesLabel;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public BigDecimal getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(BigDecimal orderQty) {
        this.orderQty = orderQty;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }
}
