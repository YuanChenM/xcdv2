package com.batch.order.bean.result;

import com.batch.order.bean.entity.BuyerForcastDeliverDetailAttachedEntity;
import com.batch.order.bean.entity.BuyerForcastDeliverDetailEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by liutao on 2017/1/5.
 */
public class ORDR0201BOrderBatchResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long buyerOrderId;

    private String buyerId;

    private String buyerType;

    private Long logisticsZoneId;

    private String bsId;

    private String bsType;

    private Long buyerBatchOrderId;

    private String buyerBatchOrderSplitFlg;

    private Boolean buyerBatchOrderFlg;

    private String buyerBatchOrderStu;

    private String goodsId;

    public String getBuyerBatchOrderStu() {
        return buyerBatchOrderStu;
    }

    public void setBuyerBatchOrderStu(String buyerBatchOrderStu) {
        this.buyerBatchOrderStu = buyerBatchOrderStu;
    }

    public Long getBuyerOrderId() {
        return buyerOrderId;
    }

    public void setBuyerOrderId(Long buyerOrderId) {
        this.buyerOrderId = buyerOrderId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerType() {
        return buyerType;
    }

    public void setBuyerType(String buyerType) {
        this.buyerType = buyerType;
    }

    public Long getLogisticsZoneId() {
        return logisticsZoneId;
    }

    public void setLogisticsZoneId(Long logisticsZoneId) {
        this.logisticsZoneId = logisticsZoneId;
    }

    public String getBsId() {
        return bsId;
    }

    public void setBsId(String bsId) {
        this.bsId = bsId;
    }

    public String getBsType() {
        return bsType;
    }

    public void setBsType(String bsType) {
        this.bsType = bsType;
    }

    public Long getBuyerBatchOrderId() {
        return buyerBatchOrderId;
    }

    public void setBuyerBatchOrderId(Long buyerBatchOrderId) {
        this.buyerBatchOrderId = buyerBatchOrderId;
    }

    public Boolean getBuyerBatchOrderFlg() {
        return buyerBatchOrderFlg;
    }

    public void setBuyerBatchOrderFlg(Boolean buyerBatchOrderFlg) {
        this.buyerBatchOrderFlg = buyerBatchOrderFlg;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getBuyerBatchOrderSplitFlg() {
        return buyerBatchOrderSplitFlg;
    }

    public void setBuyerBatchOrderSplitFlg(String buyerBatchOrderSplitFlg) {
        this.buyerBatchOrderSplitFlg = buyerBatchOrderSplitFlg;
    }
}
