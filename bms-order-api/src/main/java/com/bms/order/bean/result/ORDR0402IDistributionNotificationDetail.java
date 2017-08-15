package com.bms.order.bean.result;

import com.framework.base.rest.result.BaseRestResult;

import java.math.BigDecimal;
import java.util.List;

/**
 * 配送信息Result
 *
 * @author peng_hao
 */
public class ORDR0402IDistributionNotificationDetail extends BaseRestResult {

    private static final long serialVersionUID = 1L;

    /**
     * 买家分拆订单明细Id
     */
   private Long  buyerSplitDetailId;

    /**
     * 商品Id
     */
    private String goodsId;
    /**
     * 商品SKU
     */
    private String sku;
    /**
     * 生产批次名称
     */
    private String  batchName;
    /**
     * 配送数量
     */
    private BigDecimal distributionQuantity;

    private List<ORDR0402IPrice> priceList;

    public List<ORDR0402IPrice> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<ORDR0402IPrice> priceList) {
        this.priceList = priceList;
    }

    public Long getBuyerSplitDetailId() {
        return buyerSplitDetailId;
    }

    public void setBuyerSplitDetailId(Long buyerSplitDetailId) {
        this.buyerSplitDetailId = buyerSplitDetailId;
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

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public BigDecimal getDistributionQuantity() {
        return distributionQuantity;
    }

    public void setDistributionQuantity(BigDecimal distributionQuantity) {
        this.distributionQuantity = distributionQuantity;
    }
}
