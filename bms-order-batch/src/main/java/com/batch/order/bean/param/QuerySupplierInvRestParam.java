package com.batch.order.bean.param;

import java.io.Serializable;


public class QuerySupplierInvRestParam implements Serializable {


    private String[] logisticsId;
    private String[] ownerId;
    private String[] ownerType;
    private String[] partId;
    private String[] brandId;
    private String[] pdId;
    private String[] producerId;
    private String[] supplierId;
    private String[] commodityId;
    private String[] ivType;


    public String[] getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String[] logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String[] getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String[] ownerId) {
        this.ownerId = ownerId;
    }

    public String[] getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String[] ownerType) {
        this.ownerType = ownerType;
    }

    public String[] getPartId() {
        return partId;
    }

    public void setPartId(String[] partId) {
        this.partId = partId;
    }

    public String[] getBrandId() {
        return brandId;
    }

    public void setBrandId(String[] brandId) {
        this.brandId = brandId;
    }

    public String[] getPdId() {
        return pdId;
    }

    public void setPdId(String[] pdId) {
        this.pdId = pdId;
    }

    public String[] getProducerId() {
        return producerId;
    }

    public void setProducerId(String[] producerId) {
        this.producerId = producerId;
    }

    public String[] getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String[] supplierId) {
        this.supplierId = supplierId;
    }

    public String[] getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String[] commodityId) {
        this.commodityId = commodityId;
    }

    public String[] getIvType() {
        return ivType;
    }

    public void setIvType(String[] ivType) {
        this.ivType = ivType;
    }
}
