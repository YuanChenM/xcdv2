/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_SELLER_COMMODITY对应的实体SlpdSellerCommodity</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdSellerCommodity extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 卖家单品品牌(规格)生产商ID */
    private Long sellerCommodityId;
    /** 卖家单品品牌(规格)生产商编码 */
    private String sellerCommodityCode;
    /** 卖家单品品牌(规格)生产商SKU */
    private String sellerCommoditySku;
    /** 卖家ID */
    private Long sellerId;
    /** 卖家编码 */
    private String sellerCode;
    /** 实体卖家ID */
    private Long entitySellerId;
    /** 卖家名称 */
    private String sellerName;
    /** 单品品牌(规格)生产商ID */
    private Long producerProductId;
    /** 产品ID */
    private String productId;
    /** 货号 */
    private String articleNo;
    /** 销售类型，1：集中定价， 2：独立定价 */
    private String saleType;
    /** 商品ID */
    private String commodityId;
    /** 商品标题 */
    private String saleTitle;
    /** 审核状态，0：未注册，1：审核中，2：准入，3：禁止准入，4 ：黑名单 */
    private String auditStu;
    /** 审核备注 */
    private String auditRemark;
    /** 审核履历，格式：0,未注册,admin,2017-01-25; */
    private String auditHistory;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdSellerCommodity() {
    }

    /**
     * <p>卖家单品品牌(规格)生产商ID</p>
     *
     * @return 卖家单品品牌(规格)生产商ID
     */
    public Long getSellerCommodityId() {
        return sellerCommodityId;
    }

    /**
     * <p>卖家单品品牌(规格)生产商ID</p>
     *
     * @param sellerCommodityId 卖家单品品牌(规格)生产商ID
     */
    public void setSellerCommodityId(Long sellerCommodityId) {
        this.sellerCommodityId = sellerCommodityId;
    }
    /**
     * <p>卖家单品品牌(规格)生产商编码</p>
     *
     * @return 卖家单品品牌(规格)生产商编码
     */
    public String getSellerCommodityCode() {
        return sellerCommodityCode;
    }

    /**
     * <p>卖家单品品牌(规格)生产商编码</p>
     *
     * @param sellerCommodityCode 卖家单品品牌(规格)生产商编码
     */
    public void setSellerCommodityCode(String sellerCommodityCode) {
        this.sellerCommodityCode = sellerCommodityCode;
    }
    /**
     * <p>卖家单品品牌(规格)生产商SKU</p>
     *
     * @return 卖家单品品牌(规格)生产商SKU
     */
    public String getSellerCommoditySku() {
        return sellerCommoditySku;
    }

    /**
     * <p>卖家单品品牌(规格)生产商SKU</p>
     *
     * @param sellerCommoditySku 卖家单品品牌(规格)生产商SKU
     */
    public void setSellerCommoditySku(String sellerCommoditySku) {
        this.sellerCommoditySku = sellerCommoditySku;
    }
    /**
     * <p>卖家ID</p>
     *
     * @return 卖家ID
     */
    public Long getSellerId() {
        return sellerId;
    }

    /**
     * <p>卖家ID</p>
     *
     * @param sellerId 卖家ID
     */
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
    /**
     * <p>卖家编码</p>
     *
     * @return 卖家编码
     */
    public String getSellerCode() {
        return sellerCode;
    }

    /**
     * <p>卖家编码</p>
     *
     * @param sellerCode 卖家编码
     */
    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }
    /**
     * <p>实体卖家ID</p>
     *
     * @return 实体卖家ID
     */
    public Long getEntitySellerId() {
        return entitySellerId;
    }

    /**
     * <p>实体卖家ID</p>
     *
     * @param entitySellerId 实体卖家ID
     */
    public void setEntitySellerId(Long entitySellerId) {
        this.entitySellerId = entitySellerId;
    }
    /**
     * <p>卖家名称</p>
     *
     * @return 卖家名称
     */
    public String getSellerName() {
        return sellerName;
    }

    /**
     * <p>卖家名称</p>
     *
     * @param sellerName 卖家名称
     */
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
    /**
     * <p>单品品牌(规格)生产商ID</p>
     *
     * @return 单品品牌(规格)生产商ID
     */
    public Long getProducerProductId() {
        return producerProductId;
    }

    /**
     * <p>单品品牌(规格)生产商ID</p>
     *
     * @param producerProductId 单品品牌(规格)生产商ID
     */
    public void setProducerProductId(Long producerProductId) {
        this.producerProductId = producerProductId;
    }
    /**
     * <p>产品ID</p>
     *
     * @return 产品ID
     */
    public String getProductId() {
        return productId;
    }

    /**
     * <p>产品ID</p>
     *
     * @param productId 产品ID
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }
    /**
     * <p>货号</p>
     *
     * @return 货号
     */
    public String getArticleNo() {
        return articleNo;
    }

    /**
     * <p>货号</p>
     *
     * @param articleNo 货号
     */
    public void setArticleNo(String articleNo) {
        this.articleNo = articleNo;
    }
    /**
     * <p>销售类型，1：集中定价， 2：独立定价</p>
     *
     * @return 销售类型，1：集中定价， 2：独立定价
     */
    public String getSaleType() {
        return saleType;
    }

    /**
     * <p>销售类型，1：集中定价， 2：独立定价</p>
     *
     * @param saleType 销售类型，1：集中定价， 2：独立定价
     */
    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }
    /**
     * <p>商品ID</p>
     *
     * @return 商品ID
     */
    public String getCommodityId() {
        return commodityId;
    }

    /**
     * <p>商品ID</p>
     *
     * @param commodityId 商品ID
     */
    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }
    /**
     * <p>商品标题</p>
     *
     * @return 商品标题
     */
    public String getSaleTitle() {
        return saleTitle;
    }

    /**
     * <p>商品标题</p>
     *
     * @param saleTitle 商品标题
     */
    public void setSaleTitle(String saleTitle) {
        this.saleTitle = saleTitle;
    }
    /**
     * <p>审核状态，0：未注册，1：审核中，2：准入，3：禁止准入，4 ：黑名单</p>
     *
     * @return 审核状态，0：未注册，1：审核中，2：准入，3：禁止准入，4 ：黑名单
     */
    public String getAuditStu() {
        return auditStu;
    }

    /**
     * <p>审核状态，0：未注册，1：审核中，2：准入，3：禁止准入，4 ：黑名单</p>
     *
     * @param auditStu 审核状态，0：未注册，1：审核中，2：准入，3：禁止准入，4 ：黑名单
     */
    public void setAuditStu(String auditStu) {
        this.auditStu = auditStu;
    }
    /**
     * <p>审核备注</p>
     *
     * @return 审核备注
     */
    public String getAuditRemark() {
        return auditRemark;
    }

    /**
     * <p>审核备注</p>
     *
     * @param auditRemark 审核备注
     */
    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }
    /**
     * <p>审核履历，格式：0,未注册,admin,2017-01-25;</p>
     *
     * @return 审核履历，格式：0,未注册,admin,2017-01-25;
     */
    public String getAuditHistory() {
        return auditHistory;
    }

    /**
     * <p>审核履历，格式：0,未注册,admin,2017-01-25;</p>
     *
     * @param auditHistory 审核履历，格式：0,未注册,admin,2017-01-25;
     */
    public void setAuditHistory(String auditHistory) {
        this.auditHistory = auditHistory;
    }

}
