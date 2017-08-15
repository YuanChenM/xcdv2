package com.bms.order.external.bean.param;

import java.io.Serializable;

/**
 * Created by ni_shaotang on 2017/3/2.
 */
public class LINV0007ISource implements Serializable {
    //单品Id
    private Long partId;
    //物流区域Id
    private Long logicAreaId;
    //货主Id
    private String ownerId;
    //货主类型
    private String ownerType;
    //货主细分类
    private String ownerdType;
    //销售平台
    private String salePlatform;
    //品牌Id
    private Long brandId;
    //生产商Id
    private Long producerId;
    //供应商Id
    private Long supplierId;
    //商品Id
    private String commodityId;
    //产品Id
    private String productId;
    //库存类型
    private String ivType;

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    public Long getLogicAreaId() {
        return logicAreaId;
    }

    public void setLogicAreaId(Long logicAreaId) {
        this.logicAreaId = logicAreaId;
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

    public String getOwnerdType() {
        return ownerdType;
    }

    public void setOwnerdType(String ownerdType) {
        this.ownerdType = ownerdType;
    }

    public String getSalePlatform() {
        return salePlatform;
    }

    public void setSalePlatform(String salePlatform) {
        this.salePlatform = salePlatform;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getProducerId() {
        return producerId;
    }

    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getIvType() {
        return ivType;
    }

    public void setIvType(String ivType) {
        this.ivType = ivType;
    }
}
