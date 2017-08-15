package com.bms.order.external.bean.result;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/23.
 */ // 卖家
public class SLPD0805ISeller implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -1426646298319131792L;
    // 卖家单品品牌(规格)生产商ID
    private Long sellerCommodityId;
    // 卖家单品品牌(规格)生产商编码
    private String sellerCommodityCode;
    // 卖家单品品牌(规格)生产商SKU
    private String sellerCommoditySku;
    // 货号
    private String articleNo;
    // 商品ID
    private String commodityId;
    // 销售类型，1：集中定价， 2：独立定价
    private String saleType;
    private String saleTypeStr;
    // 商品标题
    private String saleTitle;
    // 卖家ID
    private String sellerId;
    // 卖家编码
    private String sellerCode;
    // 实体卖家ID
    private Long entitySellerId;
    // 卖家名称
    private String sellerName;

    public Long getSellerCommodityId() {
        return sellerCommodityId;
    }

    public void setSellerCommodityId(Long sellerCommodityId) {
        this.sellerCommodityId = sellerCommodityId;
    }

    public String getSellerCommodityCode() {
        return sellerCommodityCode;
    }

    public void setSellerCommodityCode(String sellerCommodityCode) {
        this.sellerCommodityCode = sellerCommodityCode;
    }

    public String getSellerCommoditySku() {
        return sellerCommoditySku;
    }

    public void setSellerCommoditySku(String sellerCommoditySku) {
        this.sellerCommoditySku = sellerCommoditySku;
    }

    public String getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(String articleNo) {
        this.articleNo = articleNo;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }

    public String getSaleTypeStr() {
        return saleTypeStr;
    }

    public void setSaleTypeStr(String saleTypeStr) {
        this.saleTypeStr = saleTypeStr;
    }

    public String getSaleTitle() {
        return saleTitle;
    }

    public void setSaleTitle(String saleTitle) {
        this.saleTitle = saleTitle;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    public Long getEntitySellerId() {
        return entitySellerId;
    }

    public void setEntitySellerId(Long entitySellerId) {
        this.entitySellerId = entitySellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

}
