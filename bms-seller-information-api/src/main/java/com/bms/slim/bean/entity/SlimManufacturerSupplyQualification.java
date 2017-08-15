/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLIM_MANUFACTURER_SUPPLY_QUALIFICATION对应的实体SlimManufacturerSupplyQualification</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimManufacturerSupplyQualification extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 制造商供应资质ID */
    private Long msqId;
    /** 实体卖家ID */
    private Long entitySellerId;
    /** 受托生产商名称 */
    private String entrustedProducerName;
    /** OEM生产商名称 */
    private String oemProducerName;
    /** OEM有效期限 */
    private String oemValidPeriod;
    /** 生产商OEM协议URL */
    private String oemProtocolUrl;
    /** 食品经营许可证编号 */
    private String foodBizLicNo;
    /** 食品经营许可证有效期限 */
    private String fblValidPeriod;
    /** 食品经营许可证URL */
    private String foodBizLicUrl;

    /**
     * <p>默认构造函数</p>
     */
    public SlimManufacturerSupplyQualification() {
    }

    /**
     * <p>制造商供应资质ID</p>
     *
     * @return 制造商供应资质ID
     */
    public Long getMsqId() {
        return msqId;
    }

    /**
     * <p>制造商供应资质ID</p>
     *
     * @param msqId 制造商供应资质ID
     */
    public void setMsqId(Long msqId) {
        this.msqId = msqId;
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
     * <p>受托生产商名称</p>
     *
     * @return 受托生产商名称
     */
    public String getEntrustedProducerName() {
        return entrustedProducerName;
    }

    /**
     * <p>受托生产商名称</p>
     *
     * @param entrustedProducerName 受托生产商名称
     */
    public void setEntrustedProducerName(String entrustedProducerName) {
        this.entrustedProducerName = entrustedProducerName;
    }
    /**
     * <p>OEM生产商名称</p>
     *
     * @return OEM生产商名称
     */
    public String getOemProducerName() {
        return oemProducerName;
    }

    /**
     * <p>OEM生产商名称</p>
     *
     * @param oemProducerName OEM生产商名称
     */
    public void setOemProducerName(String oemProducerName) {
        this.oemProducerName = oemProducerName;
    }
    /**
     * <p>OEM有效期限</p>
     *
     * @return OEM有效期限
     */
    public String getOemValidPeriod() {
        return oemValidPeriod;
    }

    /**
     * <p>OEM有效期限</p>
     *
     * @param oemValidPeriod OEM有效期限
     */
    public void setOemValidPeriod(String oemValidPeriod) {
        this.oemValidPeriod = oemValidPeriod;
    }
    /**
     * <p>生产商OEM协议URL</p>
     *
     * @return 生产商OEM协议URL
     */
    public String getOemProtocolUrl() {
        return oemProtocolUrl;
    }

    /**
     * <p>生产商OEM协议URL</p>
     *
     * @param oemProtocolUrl 生产商OEM协议URL
     */
    public void setOemProtocolUrl(String oemProtocolUrl) {
        this.oemProtocolUrl = oemProtocolUrl;
    }
    /**
     * <p>食品经营许可证编号</p>
     *
     * @return 食品经营许可证编号
     */
    public String getFoodBizLicNo() {
        return foodBizLicNo;
    }

    /**
     * <p>食品经营许可证编号</p>
     *
     * @param foodBizLicNo 食品经营许可证编号
     */
    public void setFoodBizLicNo(String foodBizLicNo) {
        this.foodBizLicNo = foodBizLicNo;
    }
    /**
     * <p>食品经营许可证有效期限</p>
     *
     * @return 食品经营许可证有效期限
     */
    public String getFblValidPeriod() {
        return fblValidPeriod;
    }

    /**
     * <p>食品经营许可证有效期限</p>
     *
     * @param fblValidPeriod 食品经营许可证有效期限
     */
    public void setFblValidPeriod(String fblValidPeriod) {
        this.fblValidPeriod = fblValidPeriod;
    }
    /**
     * <p>食品经营许可证URL</p>
     *
     * @return 食品经营许可证URL
     */
    public String getFoodBizLicUrl() {
        return foodBizLicUrl;
    }

    /**
     * <p>食品经营许可证URL</p>
     *
     * @param foodBizLicUrl 食品经营许可证URL
     */
    public void setFoodBizLicUrl(String foodBizLicUrl) {
        this.foodBizLicUrl = foodBizLicUrl;
    }

}
