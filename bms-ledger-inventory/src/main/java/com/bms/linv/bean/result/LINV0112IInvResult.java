package com.bms.linv.bean.result;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by guan_zhongheng on 2017/4/18.
 */
public class LINV0112IInvResult implements Serializable {

    private String logisticsId;

    private String salePlatform;

    private String commodityId;

    private String uom;

    private String ivType;

    private BigDecimal totalQty;

    private BigDecimal onhandQty;

    private BigDecimal bufferQty;

    private BigDecimal allocatedQty;

    private BigDecimal availableQty;

    public String getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getSalePlatform() {
        return salePlatform;
    }

    public void setSalePlatform(String salePlatform) {
        this.salePlatform = salePlatform;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public BigDecimal getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(BigDecimal totalQty) {
        this.totalQty = totalQty;
    }

    public BigDecimal getOnhandQty() {
        return onhandQty;
    }

    public void setOnhandQty(BigDecimal onhandQty) {
        this.onhandQty = onhandQty;
    }

    public BigDecimal getBufferQty() {
        return bufferQty;
    }

    public void setBufferQty(BigDecimal bufferQty) {
        this.bufferQty = bufferQty;
    }

    public BigDecimal getAllocatedQty() {
        return allocatedQty;
    }

    public void setAllocatedQty(BigDecimal allocatedQty) {
        this.allocatedQty = allocatedQty;
    }

    public BigDecimal getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(BigDecimal availableQty) {
        this.availableQty = availableQty;
    }

    public String getIvType() {
        return ivType;
    }

    public void setIvType(String ivType) {
        this.ivType = ivType;
    }
}
