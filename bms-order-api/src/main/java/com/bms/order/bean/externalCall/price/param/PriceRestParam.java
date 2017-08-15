package com.bms.order.bean.externalCall.price.param;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 调用 价盘接口   入参
 * Created by zhang_qiang1 on 2017/1/4.
 */
public class PriceRestParam implements Serializable {


    /***
     *  下单时间
     */
    private  String orderTime;

    /**
     * 物流区
     */
    private String logisticsZoneId;

    /**
     * 商品id
     */
    private String goodsId;


    /**
     * 价盘通道组id
     */
    private String priceWayId;


    /**
     * 买家id
     */
    private String buyerId;


    /**
     * 是否是账期买家
     */
    private boolean netBuyerFlg;

    /**
     * 商品数量
     */
    private BigDecimal goodsQuantity;


    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getPriceWayId() {
        return priceWayId;
    }

    public void setPriceWayId(String priceWayId) {
        this.priceWayId = priceWayId;
    }

    public BigDecimal getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(BigDecimal goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public boolean isNetBuyerFlg() {
        return netBuyerFlg;
    }

    public void setNetBuyerFlg(boolean netBuyerFlg) {
        this.netBuyerFlg = netBuyerFlg;
    }


    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getLogisticsZoneId() {
        return logisticsZoneId;
    }

    public void setLogisticsZoneId(String logisticsZoneId) {
        this.logisticsZoneId = logisticsZoneId;
    }

    @Override
    public String toString() {
        return "PriceRestParam{" +
                "orderTime='" + orderTime + '\'' +
                ", logisticsZoneId='" + logisticsZoneId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", priceWayId='" + priceWayId + '\'' +
                ", buyerId='" + buyerId + '\'' +
                ", netBuyerFlg=" + netBuyerFlg +
                ", goodsQuantity=" + goodsQuantity +
                '}';
    }
}
