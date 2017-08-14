package com.batch.order.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * Created by wu_honglei on 2017/1/10.
 * 配送通知单明细表
 */
public class OrderDistributionDetailIResultEntity extends BaseEntity {
    private Long distributionNotificationDetailId;//配送单明细ID
    private Long buyerForcastDeliverDetailId;//预配送明细ID
    private String goodsId;//商品ID
    private String  sku;//商品SKU
    private String batchCode;//批次编码
    private BigDecimal distributionQuantity;//配送数量
    private String goodsUnit;// 商品单位
    private BigDecimal distributionQty;// 销售数量

    public Long getDistributionNotificationDetailId() {
        return distributionNotificationDetailId;
    }

    public void setDistributionNotificationDetailId(Long distributionNotificationDetailId) {
        this.distributionNotificationDetailId = distributionNotificationDetailId;
    }

    public Long getBuyerForcastDeliverDetailId() {
        return buyerForcastDeliverDetailId;
    }

    public void setBuyerForcastDeliverDetailId(Long buyerForcastDeliverDetailId) {
        this.buyerForcastDeliverDetailId = buyerForcastDeliverDetailId;
    }

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

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public BigDecimal getDistributionQuantity() {
        return distributionQuantity;
    }

    public void setDistributionQuantity(BigDecimal distributionQuantity) {
        this.distributionQuantity = distributionQuantity;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public BigDecimal getDistributionQty() {
        return distributionQty;
    }

    public void setDistributionQty(BigDecimal distributionQty) {
        this.distributionQty = distributionQty;
    }
}
