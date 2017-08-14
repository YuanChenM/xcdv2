package com.batch.order.bean.result;

import java.io.Serializable;

/**
 * Created by liutao on 2017/1/5.
 */
public class ORDR0201BOrderResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long buyerOrderId;

    private String buyerOrderCode;

    private String buyerId;

    private String buyerType;

    private Long logisticsZoneId;

    private String logisticsZoneCode;

    private String bsId;

    private String bsType;

    private String buyerOrderStu;

    private Boolean netBuyerFlg;

    private String buyerCode;

    public String getLogisticsZoneCode() {
        return logisticsZoneCode;
    }

    public void setLogisticsZoneCode(String logisticsZoneCode) {
        this.logisticsZoneCode = logisticsZoneCode;
    }

    public String getBuyerCode() {
        return buyerCode;
    }

    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    public String getBuyerOrderCode() {
        return buyerOrderCode;
    }

    public void setBuyerOrderCode(String buyerOrderCode) {
        this.buyerOrderCode = buyerOrderCode;
    }

    public Boolean getNetBuyerFlg() {
        return netBuyerFlg;
    }

    public void setNetBuyerFlg(Boolean netBuyerFlg) {
        this.netBuyerFlg = netBuyerFlg;
    }

    public String getBuyerOrderStu() {
        return buyerOrderStu;
    }

    public void setBuyerOrderStu(String buyerOrderStu) {
        this.buyerOrderStu = buyerOrderStu;
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
}
