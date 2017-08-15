/*
 * 2017/03/22 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表slpd_producer_product对应的实体SlpdProducerProduct</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdProducerProduct extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 单品品牌(规格)生产商ID */
    private Long producerProductId;
    /** 单品品牌规格生产商编码 */
    private String producerProductCode;
    /** 单品品牌(规格)生产商SKU */
    private String producerProductSku;
    /** 产品ID */
    private String productId;
    /** 实体卖家ID */
    private Long entitySellerId;
    /** 审核状态，0：未注册，1：审核中，2：准入，3：禁止准入，4 ：黑名单 */
    private String auditStu;
    /** 审核备注 */
    private String auditRemark;
    /** 审核履历，格式：0,未注册,admin,2017-01-25; */
    private String auditHistory;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdProducerProduct() {
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
     * <p>单品品牌规格生产商编码</p>
     *
     * @return 单品品牌规格生产商编码
     */
    public String getProducerProductCode() {
        return producerProductCode;
    }

    /**
     * <p>单品品牌规格生产商编码</p>
     *
     * @param producerProductCode 单品品牌规格生产商编码
     */
    public void setProducerProductCode(String producerProductCode) {
        this.producerProductCode = producerProductCode;
    }
    /**
     * <p>单品品牌(规格)生产商SKU</p>
     *
     * @return 单品品牌(规格)生产商SKU
     */
    public String getProducerProductSku() {
        return producerProductSku;
    }

    /**
     * <p>单品品牌(规格)生产商SKU</p>
     *
     * @param producerProductSku 单品品牌(规格)生产商SKU
     */
    public void setProducerProductSku(String producerProductSku) {
        this.producerProductSku = producerProductSku;
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
