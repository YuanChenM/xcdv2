package com.bms.order.external.bean.result;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by ni_shaotang on 2017/3/2.
 */
public class LINV0013IRestResult implements Serializable {

    private static final long serialVersionUID = 1L;
    //物流区域ID
    private String logisticsId;
    //销售平台
    private String salesPlatform;
    //货主Id
    private String ownerId;
    //货主类型
    private String ownerType;
    //货主细分类
    private String ownerDType;
    //单品Id
    private String partId;
    //品牌Id
    private String brandId;
    //产品Id
    private String pdId;
    //制造商Id
    private String producerId;
    //供应商Id
    private String supplierId;

    //商品Id
    private String commodityId;
    //库存类型
    private String ivType;
    //sku编码
    private String skuCode;

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

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public String getOwnerDType() {
        return ownerDType;
    }

    public void setOwnerDType(String ownerDType) {
        this.ownerDType = ownerDType;
    }

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getPdId() {
        return pdId;
    }

    public void setPdId(String pdId) {
        this.pdId = pdId;
    }

    public String getProducerId() {
        return producerId;
    }

    public void setProducerId(String producerId) {
        this.producerId = producerId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }
}
