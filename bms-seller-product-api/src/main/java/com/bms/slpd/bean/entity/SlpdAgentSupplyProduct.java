/*
 * 2017/03/22 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表slpd_agent_supply_product对应的实体SlpdAgentSupplyProduct</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdAgentSupplyProduct extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 单品品牌规格代理商ID */
    private Long asProductId;
    /** 单品品牌规格代理商CODE */
    private String asProductCode;
    /** 单品品牌规格代理商SKU */
    private String asProductSku;
    /** 单品品牌规格制造商ID */
    private Long manufacturerProductId;
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
    public SlpdAgentSupplyProduct() {
    }

    /**
     * <p>单品品牌规格代理商ID</p>
     *
     * @return 单品品牌规格代理商ID
     */
    public Long getAsProductId() {
        return asProductId;
    }

    /**
     * <p>单品品牌规格代理商ID</p>
     *
     * @param asProductId 单品品牌规格代理商ID
     */
    public void setAsProductId(Long asProductId) {
        this.asProductId = asProductId;
    }
    /**
     * <p>单品品牌规格代理商CODE</p>
     *
     * @return 单品品牌规格代理商CODE
     */
    public String getAsProductCode() {
        return asProductCode;
    }

    /**
     * <p>单品品牌规格代理商CODE</p>
     *
     * @param asProductCode 单品品牌规格代理商CODE
     */
    public void setAsProductCode(String asProductCode) {
        this.asProductCode = asProductCode;
    }
    /**
     * <p>单品品牌规格代理商SKU</p>
     *
     * @return 单品品牌规格代理商SKU
     */
    public String getAsProductSku() {
        return asProductSku;
    }

    /**
     * <p>单品品牌规格代理商SKU</p>
     *
     * @param asProductSku 单品品牌规格代理商SKU
     */
    public void setAsProductSku(String asProductSku) {
        this.asProductSku = asProductSku;
    }
    /**
     * <p>单品品牌规格制造商ID</p>
     *
     * @return 单品品牌规格制造商ID
     */
    public Long getManufacturerProductId() {
        return manufacturerProductId;
    }

    /**
     * <p>单品品牌规格制造商ID</p>
     *
     * @param manufacturerProductId 单品品牌规格制造商ID
     */
    public void setManufacturerProductId(Long manufacturerProductId) {
        this.manufacturerProductId = manufacturerProductId;
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
