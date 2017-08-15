package com.bms.order.bean.result;

import com.bms.order.common.rest.result.RestSearchData;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by wang_jianzhou on 2017/1/17.
 */
public class ORDR0502IDetailsRestResult extends RestSearchData {

    private Long receiveNotificationDetailId;
    private Long distributionNotificationDetailId;

    private String goodsId;

    private String sku;

    private String batch;

    private Long buyerForcastDeliverDetailId;

    private BigDecimal receiveQuantity;

    private BigDecimal rejectQuantity;

    private BigDecimal delayQuantity;

    private BigDecimal returnQuantity;

    private Date redistributionDate;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Long getBuyerForcastDeliverDetailId() {
        return buyerForcastDeliverDetailId;
    }

    public void setBuyerForcastDeliverDetailId(Long buyerForcastDeliverDetailId) {
        this.buyerForcastDeliverDetailId = buyerForcastDeliverDetailId;
    }

    public BigDecimal getReceiveQuantity() {
        return receiveQuantity;
    }

    public void setReceiveQuantity(BigDecimal receiveQuantity) {
        this.receiveQuantity = receiveQuantity;
    }

    public BigDecimal getRejectQuantity() {
        return rejectQuantity;
    }

    public void setRejectQuantity(BigDecimal rejectQuantity) {
        this.rejectQuantity = rejectQuantity;
    }

    public BigDecimal getDelayQuantity() {
        return delayQuantity;
    }

    public void setDelayQuantity(BigDecimal delayQuantity) {
        this.delayQuantity = delayQuantity;
    }

    public BigDecimal getReturnQuantity() {
        return returnQuantity;
    }

    public void setReturnQuantity(BigDecimal returnQuantity) {
        this.returnQuantity = returnQuantity;
    }

    public Date getRedistributionDate() {
        return redistributionDate;
    }

    public void setRedistributionDate(Date redistributionDate) {
        this.redistributionDate = redistributionDate;
    }

    public Long getReceiveNotificationDetailId() {
        return receiveNotificationDetailId;
    }

    public void setReceiveNotificationDetailId(Long receiveNotificationDetailId) {
        this.receiveNotificationDetailId = receiveNotificationDetailId;
    }

    public Long getDistributionNotificationDetailId() {
        return distributionNotificationDetailId;
    }

    public void setDistributionNotificationDetailId(Long distributionNotificationDetailId) {
        this.distributionNotificationDetailId = distributionNotificationDetailId;
    }
}


