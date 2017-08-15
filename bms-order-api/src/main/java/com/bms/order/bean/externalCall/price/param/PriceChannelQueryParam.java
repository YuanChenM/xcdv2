package com.bms.order.bean.externalCall.price.param;

import java.io.Serializable;
import java.math.BigDecimal;

public class PriceChannelQueryParam implements Serializable {
    private  String  goodsId;


    private  BigDecimal goodsQuantity;


    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(BigDecimal goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    @Override
    public String toString() {
        return "PriceChannelQueryParam{" +
                "goodsId='" + goodsId + '\'' +
                ", goodsQuantity=" + goodsQuantity +
                '}';
    }
}
