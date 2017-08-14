package com.batch.order.bean.inv.param;

import com.framework.base.rest.param.BaseRestPaginationParam;

/**
 * Created by guan_zhongheng on 2017/4/17.
 */
public class LINV0110IParam extends BaseRestPaginationParam{
    private String[] logisticsId;

    private String[] salePlatform;

    private String[] ownerId;

    private String[] ownerType;

    private String[] producerId;

    private String[] commodityId;

    private String[] productId;

    private String[] skuCode;

    private String[] lotNo;

    private String[] saleStatusId;

    private String[] uom;

    private String[] ivType;


    public String[] getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String[] logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String[] getSalePlatform() {
        return salePlatform;
    }

    public void setSalePlatform(String[] salePlatform) {
        this.salePlatform = salePlatform;
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

    public String[] getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String[] commodityId) {
        this.commodityId = commodityId;
    }

    public String[] getProductId() {
        return productId;
    }

    public void setProductId(String[] productId) {
        this.productId = productId;
    }

    public String[] getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String[] skuCode) {
        this.skuCode = skuCode;
    }

    public String[] getLotNo() {
        return lotNo;
    }

    public void setLotNo(String[] lotNo) {
        this.lotNo = lotNo;
    }

    public String[] getSaleStatusId() {
        return saleStatusId;
    }

    public void setSaleStatusId(String[] saleStatusId) {
        this.saleStatusId = saleStatusId;
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
