/*
 * 2017/03/22 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表slpd_manufacturer_product对应的实体SlpdManufacturerProduct</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdManufacturerProduct extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 单品品牌规格制造商ID */
    private Long manufacturerProductId;
    /** 单品品牌规格制造商编码 */
    private String manufacturerProductCode;
    /** 单品品牌规格制造商SKU */
    private String manufacturerProductSku;
    /** 单品品牌规格制造商BarCode:15位,93开头（2位）+供应商编码（8位）+货号（5位） */
    private String manufacturerProductBarCode;
    /** 单品品牌规格生产商ID */
    private Long producerProductId;
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
    public SlpdManufacturerProduct() {
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
     * <p>单品品牌规格制造商编码</p>
     *
     * @return 单品品牌规格制造商编码
     */
    public String getManufacturerProductCode() {
        return manufacturerProductCode;
    }

    /**
     * <p>单品品牌规格制造商编码</p>
     *
     * @param manufacturerProductCode 单品品牌规格制造商编码
     */
    public void setManufacturerProductCode(String manufacturerProductCode) {
        this.manufacturerProductCode = manufacturerProductCode;
    }
    /**
     * <p>单品品牌规格制造商SKU</p>
     *
     * @return 单品品牌规格制造商SKU
     */
    public String getManufacturerProductSku() {
        return manufacturerProductSku;
    }

    /**
     * <p>单品品牌规格制造商SKU</p>
     *
     * @param manufacturerProductSku 单品品牌规格制造商SKU
     */
    public void setManufacturerProductSku(String manufacturerProductSku) {
        this.manufacturerProductSku = manufacturerProductSku;
    }
    /**
     * <p>单品品牌规格制造商BarCode:15位,93开头（2位）+供应商编码（8位）+货号（5位）</p>
     *
     * @return 单品品牌规格制造商BarCode:15位,93开头（2位）+供应商编码（8位）+货号（5位）
     */
    public String getManufacturerProductBarCode() {
        return manufacturerProductBarCode;
    }

    /**
     * <p>单品品牌规格制造商BarCode:15位,93开头（2位）+供应商编码（8位）+货号（5位）</p>
     *
     * @param manufacturerProductBarCode 单品品牌规格制造商BarCode:15位,93开头（2位）+供应商编码（8位）+货号（5位）
     */
    public void setManufacturerProductBarCode(String manufacturerProductBarCode) {
        this.manufacturerProductBarCode = manufacturerProductBarCode;
    }
    /**
     * <p>单品品牌规格生产商ID</p>
     *
     * @return 单品品牌规格生产商ID
     */
    public Long getProducerProductId() {
        return producerProductId;
    }

    /**
     * <p>单品品牌规格生产商ID</p>
     *
     * @param producerProductId 单品品牌规格生产商ID
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
