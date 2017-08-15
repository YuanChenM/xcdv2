package com.bms.order.external.bean.result;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by ni_shaotang on 2017/3/2.
 */
public class LINV0012IRestResult implements Serializable {

    private static final long serialVersionUID = 1L;
    //物流区域ID
    private String logisticsId;
    //销售平台
    private String salesPlatform;
    //商品Id
    private String commodityId;
    //库存类型
    private String ivType;
    //单位
    private String uom;
    //总数量
    private BigDecimal totalQty;
    //在库数量
    private BigDecimal onhandQty;
    //虚拟数量
    private BigDecimal bufferQty;
    //占用数量
    private BigDecimal allocatedQty;
    //可用数量
    private BigDecimal availableQty;

    public String getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getSalesPlatform() {
        return salesPlatform;
    }

    public void setSalesPlatform(String salesPlatform) {
        this.salesPlatform = salesPlatform;
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
}
