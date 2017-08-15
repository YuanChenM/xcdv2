package com.bms.slpd.bean.param.wrapper;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class SlpdSellerCommodityParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "卖家单品品牌(规格)生产商ID")
    private Long sellerCommodityId;
    @ApiModelProperty(value = "卖家单品品牌(规格)生产商编码")
    private String sellerCommodityCode;
    @ApiModelProperty(value = "卖家单品品牌(规格)生产商SKU")
    private String sellerCommoditySku;
    @ApiModelProperty(value = "卖家ID")
    private Long sellerId;
    @ApiModelProperty(value = "卖家编码")
    private String sellerCode;
    @ApiModelProperty(value = "实体卖家ID")
    private Long entitySellerId;
    @ApiModelProperty(value = "卖家名称")
    private String sellerName;
    @ApiModelProperty(value = "单品品牌(规格)生产商ID")
    private Long producerProductId;
    @ApiModelProperty(value = "产品ID")
    private String productId;
    @ApiModelProperty(value = "销售类型，1：集中定价， 2：独立定价")
    private String saleType;
    @ApiModelProperty(value = "货号")
    private String articleNo;
    @ApiModelProperty(value = "商品ID")
    private String commodityId;
    @ApiModelProperty(value = "商品标题")
    private String saleTitle;
    @ApiModelProperty(value = "审核状态，0：待审核，1：审核中，2：准入，3：禁止准入，4 ：黑名单")
    private String auditStu;
    @ApiModelProperty(value = "审核备注")
    private String auditRemark;
    @ApiModelProperty(value = "审核履历")
    private String auditHistory;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;
    @ApiModelProperty(value = "版本号")
    private Integer version;

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

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
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

    public Long getProducerProductId() {
        return producerProductId;
    }

    public void setProducerProductId(Long producerProductId) {
        this.producerProductId = producerProductId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
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

    public String getSaleTitle() {
        return saleTitle;
    }

    public void setSaleTitle(String saleTitle) {
        this.saleTitle = saleTitle;
    }

    public String getAuditStu() {
        return auditStu;
    }

    public void setAuditStu(String auditStu) {
        this.auditStu = auditStu;
    }

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }

    public String getAuditHistory() {
        return auditHistory;
    }

    public void setAuditHistory(String auditHistory) {
        this.auditHistory = auditHistory;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
