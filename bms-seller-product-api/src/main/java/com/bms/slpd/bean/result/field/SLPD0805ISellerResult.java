package com.bms.slpd.bean.result.field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "SLPD0805ISellerResult", description = "卖家信息")
public class SLPD0805ISellerResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "卖家单品品牌(规格)生产商ID")
    private Long sellerCommodityId;
    @ApiModelProperty(value = "卖家单品品牌(规格)生产商编码")
    private String sellerCommodityCode;
    @ApiModelProperty(value = "卖家单品品牌(规格)生产商SKU")
    private String sellerCommoditySku;

    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;
    @ApiModelProperty(value = "新建人ID")
    private String crtId;
    @ApiModelProperty(value = "新建时间")
    private Date crtTime;
    @ApiModelProperty(value = "修改人ID")
    private String updId;
    @ApiModelProperty(value = "修改时间")
    private Date updTime;
    @ApiModelProperty(value = "版本")
    private Integer version;

    @ApiModelProperty(value = "货号")
    private String articleNo;
    @ApiModelProperty(value = "商品ID")
    private String commodityId;
    @ApiModelProperty(value = "销售类型，1：集中定价， 2：独立定价")
    private String saleType;
    @ApiModelProperty(value = "销售类型")
    private String saleTypeStr;
    @ApiModelProperty(value = "商品标题")
    private String saleTitle;

    @ApiModelProperty(value = "卖家ID")
    private Long sellerId;
    @ApiModelProperty(value = "卖家编码")
    private String sellerCode;
    @ApiModelProperty(value = "实体卖家ID")
    private Long entitySellerId;
    @ApiModelProperty(value = "卖家名称")
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

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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
}
