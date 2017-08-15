package com.bms.order.external.bean.entity;

import java.math.BigDecimal;

/**
 * Created by nishaotang on 2017/3/2.
 */
public class StockEntity {
    // 商品ID
    private String goodsId;
    // 物流区Id
    private Long logisticsZoneId;
    // 可用数量
    private BigDecimal availableQty;

    private String ownerId;

    private String ownerCode;

    private String ownerName;

    //库存区分（实物、货权）
    private String comoIvType;

    //库存类型（正常...）
    private String ivType;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Long getLogisticsZoneId() {
        return logisticsZoneId;
    }

    public void setLogisticsZoneId(Long logisticsZoneId) {
        this.logisticsZoneId = logisticsZoneId;
    }

    public BigDecimal getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(BigDecimal availableQty) {
        this.availableQty = availableQty;
    }

    /**
     * @return the ownerId
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * @param ownerId
     *            the ownerId to set
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getComoIvType() {
        return comoIvType;
    }

    public void setComoIvType(String comoIvType) {
        this.comoIvType = comoIvType;
    }

    public String getIvType() {
        return ivType;
    }

    public void setIvType(String ivType) {
        this.ivType = ivType;
    }
}
