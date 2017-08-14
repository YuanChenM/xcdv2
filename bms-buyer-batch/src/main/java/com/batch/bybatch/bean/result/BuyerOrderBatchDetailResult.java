package com.batch.bybatch.bean.result;

import java.math.BigDecimal;

/**
 * Created by guan_zhongheng on 2017/2/23.
 * 分批訂單明細
 */
public class BuyerOrderBatchDetailResult {

    /**
     * 明细：买家分批订单明细ID
     */
    private Long buyerBatchOrderDetailId;

    /**
     * 明细：商品单位 [CodeMaster KG/箱]
     */
    private String goodsUnit;

    /**
     * 明细：商品数量
     */
    private BigDecimal goodsQuantity;

    /**
     * 明细：取消数量
     */
    private BigDecimal cancelQuantity;

    /**
     * 商品：商品ID [任意一级可销售层级+销售标签]
     */
    private Long goodsId;

    /**
     * 商品：产品ID
     */
    private String productId;

    /**
     * 商品：单品编码 [单品SKU]
     */
    private String itemCode;

    public Long getBuyerBatchOrderDetailId() {
        return buyerBatchOrderDetailId;
    }

    public void setBuyerBatchOrderDetailId(Long buyerBatchOrderDetailId) {
        this.buyerBatchOrderDetailId = buyerBatchOrderDetailId;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public BigDecimal getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(BigDecimal goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    public BigDecimal getCancelQuantity() {
        return cancelQuantity;
    }

    public void setCancelQuantity(BigDecimal cancelQuantity) {
        this.cancelQuantity = cancelQuantity;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}
