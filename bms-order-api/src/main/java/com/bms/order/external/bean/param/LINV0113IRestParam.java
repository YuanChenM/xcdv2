package com.bms.order.external.bean.param;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/2.
 */
public class LINV0113IRestParam implements Serializable {
    private static final long serialVersionUID = 1L;

    //商品ID
    private String[] commodityId;

    //商品库存类型
    private String[] comoIvType;

    //库存类型
    private String[] ivType;

    //物流区域ID
    private String[] logisticsId;

    //货主ID
    private String[] ownerId;

    //货主类型
    private String[] ownerType;

    //销售平台
    private String[] salePlatform;

    //单位
    private String[] uom;


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

    public String[] getComoIvType() {
        return comoIvType;
    }

    public void setComoIvType(String[] comoIvType) {
        this.comoIvType = comoIvType;
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
}
