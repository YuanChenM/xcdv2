package com.bms.order.bean.externalCall.price.result;

import java.math.BigDecimal;

/**
 * Created by zhang_qiang1 on 2017/1/4.
 */
public class PriceRestResult {

    /**
     * 商品id
     */
    private String goodsId;


    /**
     * 价盘通道组id
     */
    private String priceWayId;

    /**
     * 商品价格
     */
    private BigDecimal goodsPrice;


    private Integer countRange;//０　　１


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

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getCountRange() {
        return countRange;
    }

    public void setCountRange(Integer countRange) {
        this.countRange = countRange;
    }

    @Override
    public String toString() {
        return "PriceRestResult{" +
                "goodsId='" + goodsId + '\'' +
                ", priceWayId='" + priceWayId + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", countRange=" + countRange +
                '}';
    }
}
