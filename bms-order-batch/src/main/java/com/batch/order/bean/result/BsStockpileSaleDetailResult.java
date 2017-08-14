package com.batch.order.bean.result;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by liutao on 2017/3/8.
 */
public class BsStockpileSaleDetailResult implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 销售明细：囤货销售明细ID
     */
    private Long stockpileSaleDetailId;

    /**
     * 销售明细：囤货分拆明细ID
     */
    private Long bsStockpileSplitDetailId;

    /**
     * 销售明细：买家分拆明细ID
     */
    private Long buyerForcastDeliverDetailId;

    /**
     * 销售：销售数量
     */
    private BigDecimal saleQuantity;

    public Long getStockpileSaleDetailId() {
        return stockpileSaleDetailId;
    }

    public void setStockpileSaleDetailId(Long stockpileSaleDetailId) {
        this.stockpileSaleDetailId = stockpileSaleDetailId;
    }

    public Long getBsStockpileSplitDetailId() {
        return bsStockpileSplitDetailId;
    }

    public void setBsStockpileSplitDetailId(Long bsStockpileSplitDetailId) {
        this.bsStockpileSplitDetailId = bsStockpileSplitDetailId;
    }

    public Long getBuyerForcastDeliverDetailId() {
        return buyerForcastDeliverDetailId;
    }

    public void setBuyerForcastDeliverDetailId(Long buyerForcastDeliverDetailId) {
        this.buyerForcastDeliverDetailId = buyerForcastDeliverDetailId;
    }

    public BigDecimal getSaleQuantity() {
        return saleQuantity;
    }

    public void setSaleQuantity(BigDecimal saleQuantity) {
        this.saleQuantity = saleQuantity;
    }
}
