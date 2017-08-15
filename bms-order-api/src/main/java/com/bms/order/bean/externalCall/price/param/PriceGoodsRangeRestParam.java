package com.bms.order.bean.externalCall.price.param;

import java.io.Serializable;

/**
 * 调用 价盘接口   入参
 * Created by zhang_qiang1 on 2017/1/4.
 */
public class PriceGoodsRangeRestParam implements Serializable {


    /**
     * 物流区
     */
    private String logisticsZoneId;

    /**
     * 商品id
     */
    private String goodsId;


    public String getLogisticsZoneId() {
        return logisticsZoneId;
    }

    public void setLogisticsZoneId(String logisticsZoneId) {
        this.logisticsZoneId = logisticsZoneId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
}
