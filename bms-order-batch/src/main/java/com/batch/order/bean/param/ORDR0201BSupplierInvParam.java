package com.batch.order.bean.param;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liutao on 2017/1/5.
 */
public class ORDR0201BSupplierInvParam implements Serializable{

    private List<String> logisticsId;

    private List<String> ownerId;

    private List<String> ownerType;

    private List<String> partId;

    private List<String> brandId;

    private List<String> pdId;

    private List<String> producerId;

    private List<String> supplierId;

    private List<String> commodityId;

    private List<String> ivType;

    public List<String> getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(List<String> logisticsId) {
        this.logisticsId = logisticsId;
    }

    public List<String> getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(List<String> ownerId) {
        this.ownerId = ownerId;
    }

    public List<String> getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(List<String> ownerType) {
        this.ownerType = ownerType;
    }

    public List<String> getPartId() {
        return partId;
    }

    public void setPartId(List<String> partId) {
        this.partId = partId;
    }

    public List<String> getBrandId() {
        return brandId;
    }

    public void setBrandId(List<String> brandId) {
        this.brandId = brandId;
    }

    public List<String> getPdId() {
        return pdId;
    }

    public void setPdId(List<String> pdId) {
        this.pdId = pdId;
    }

    public List<String> getProducerId() {
        return producerId;
    }

    public void setProducerId(List<String> producerId) {
        this.producerId = producerId;
    }

    public List<String> getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(List<String> supplierId) {
        this.supplierId = supplierId;
    }

    public List<String> getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(List<String> commodityId) {
        this.commodityId = commodityId;
    }

    public List<String> getIvType() {
        return ivType;
    }

    public void setIvType(List<String> ivType) {
        this.ivType = ivType;
    }
}
