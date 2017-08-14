package com.batch.order.bean.inv.param;

import com.framework.base.rest.param.BaseRestPaginationParam;

import java.util.List;

/**
 * Created by liutao on 2017/3/7.
 */
public class LINV0016IParam extends BaseRestPaginationParam {

    private List<String> logisticsId;

    private List<String> salePlatform;

    private List<String> ownerId;

    private List<String> ownerType;

    private List<String> commodityId;

    private List<String> uom;

    private List<String> ivType;

    public List<String> getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(List<String> logisticsId) {
        this.logisticsId = logisticsId;
    }

    public List<String> getSalePlatform() {
        return salePlatform;
    }

    public void setSalePlatform(List<String> salePlatform) {
        this.salePlatform = salePlatform;
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

    public List<String> getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(List<String> commodityId) {
        this.commodityId = commodityId;
    }

    public List<String> getUom() {
        return uom;
    }

    public void setUom(List<String> uom) {
        this.uom = uom;
    }

    public List<String> getIvType() {
        return ivType;
    }

    public void setIvType(List<String> ivType) {
        this.ivType = ivType;
    }
}
