package com.bms.order.external.bean.param;

import java.io.Serializable;

/**
 * Created by ni_shaotang on 2017/3/3.
 */
public class LINV0013IRestParam implements Serializable {
    //物流区域ID
    private String[] logisticsId;
    //销售平台
    private String[] salesPlatform;
    //货主ID
    private String[] ownerId;
    //货主类型
    private String[] ownerType;
    //生产商ID
    private String[] producerId;
    //供应商ID
    private String[] supplierId;
    //商品ID
    private String[] commodityId;
    //单位
    private String[] uom;
    //库存类型
    private String[] ivType;

    public String[] getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String[] logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String[] getSalesPlatform() {
        return salesPlatform;
    }

    public void setSalesPlatform(String[] salesPlatform) {
        this.salesPlatform = salesPlatform;
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

    public String[] getUom() {
        return uom;
    }

    public void setUom(String[] uom) {
        this.uom = uom;
    }

    public String[] getIvType() {
        return ivType;
    }

    public void setIvType(String[] ivType) {
        this.ivType = ivType;
    }
}
