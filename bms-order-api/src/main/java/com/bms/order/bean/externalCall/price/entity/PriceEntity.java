package com.bms.order.bean.externalCall.price.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by zhang_qiang1 on 2017/1/4.
 */
public class PriceEntity  implements Serializable{


    /**
     * 商品 数量范围
     */
    private String goodsRange;

    /**
     *商品id
     */
    private String goodsId;
    /**
     * 商品价格
     */
    private BigDecimal goodsPrice;

    /**
     * 价盘id
     */
    private String priceWayId;


    public String getGoodsRange() {
        return goodsRange;
    }

    public void setGoodsRange(String goodsRange) {
        this.goodsRange = goodsRange;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getPriceWayId() {
        return priceWayId;
    }

    public void setPriceWayId(String priceWayId) {
        this.priceWayId = priceWayId;
    }

    @Override
    public String toString() {
        return "PriceEntity{" +
                "goodsRange='" + goodsRange + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", priceWayId='" + priceWayId + '\'' +
                '}';
    }
}
