/*
 * 2017/03/30 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表slpd_item_property对应的实体SlpdItemProperty</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdItemProperty extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 单品规格ID */
    private Long itemPropertyId;
    /** 单品规格编码 */
    private String itemPropertyCode;
    /** 单品ID */
    private Long itemId;
    /** 货源，1：国产，2：进口 */
    private String sourceType;
    /** 毛重（克） */
    private java.math.BigDecimal grossWeight;
    /** 包装规格 */
    private String packageSpecification;
    /** 包装数量 */
    private Integer packageQuantity;
    /** 纸箱尺寸（cm），长*宽*高 */
    private String cartonDimension;
    /** 纸箱长度（cm） */
    private java.math.BigDecimal cartonLength;
    /** 纸箱宽度（cm） */
    private java.math.BigDecimal cartonWidth;
    /** 纸箱高度（cm） */
    private java.math.BigDecimal cartonHeight;
    /** 托盘堆码数（箱） */
    private Integer palletStackingLimit;
    /** 审核状态，0：待审核，1：正式 */
    private Boolean auditStu;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdItemProperty() {
    }

    /**
     * <p>单品规格ID</p>
     *
     * @return 单品规格ID
     */
    public Long getItemPropertyId() {
        return itemPropertyId;
    }

    /**
     * <p>单品规格ID</p>
     *
     * @param itemPropertyId 单品规格ID
     */
    public void setItemPropertyId(Long itemPropertyId) {
        this.itemPropertyId = itemPropertyId;
    }
    /**
     * <p>单品规格编码</p>
     *
     * @return 单品规格编码
     */
    public String getItemPropertyCode() {
        return itemPropertyCode;
    }

    /**
     * <p>单品规格编码</p>
     *
     * @param itemPropertyCode 单品规格编码
     */
    public void setItemPropertyCode(String itemPropertyCode) {
        this.itemPropertyCode = itemPropertyCode;
    }
    /**
     * <p>单品ID</p>
     *
     * @return 单品ID
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * <p>单品ID</p>
     *
     * @param itemId 单品ID
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
    /**
     * <p>货源，1：国产，2：进口</p>
     *
     * @return 货源，1：国产，2：进口
     */
    public String getSourceType() {
        return sourceType;
    }

    /**
     * <p>货源，1：国产，2：进口</p>
     *
     * @param sourceType 货源，1：国产，2：进口
     */
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }
    /**
     * <p>毛重（克）</p>
     *
     * @return 毛重（克）
     */
    public java.math.BigDecimal getGrossWeight() {
        return grossWeight;
    }

    /**
     * <p>毛重（克）</p>
     *
     * @param grossWeight 毛重（克）
     */
    public void setGrossWeight(java.math.BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }
    /**
     * <p>包装规格</p>
     *
     * @return 包装规格
     */
    public String getPackageSpecification() {
        return packageSpecification;
    }

    /**
     * <p>包装规格</p>
     *
     * @param packageSpecification 包装规格
     */
    public void setPackageSpecification(String packageSpecification) {
        this.packageSpecification = packageSpecification;
    }
    /**
     * <p>包装数量</p>
     *
     * @return 包装数量
     */
    public Integer getPackageQuantity() {
        return packageQuantity;
    }

    /**
     * <p>包装数量</p>
     *
     * @param packageQuantity 包装数量
     */
    public void setPackageQuantity(Integer packageQuantity) {
        this.packageQuantity = packageQuantity;
    }
    /**
     * <p>纸箱尺寸（cm），长*宽*高</p>
     *
     * @return 纸箱尺寸（cm），长*宽*高
     */
    public String getCartonDimension() {
        return cartonDimension;
    }

    /**
     * <p>纸箱尺寸（cm），长*宽*高</p>
     *
     * @param cartonDimension 纸箱尺寸（cm），长*宽*高
     */
    public void setCartonDimension(String cartonDimension) {
        this.cartonDimension = cartonDimension;
    }
    /**
     * <p>纸箱长度（cm）</p>
     *
     * @return 纸箱长度（cm）
     */
    public java.math.BigDecimal getCartonLength() {
        return cartonLength;
    }

    /**
     * <p>纸箱长度（cm）</p>
     *
     * @param cartonLength 纸箱长度（cm）
     */
    public void setCartonLength(java.math.BigDecimal cartonLength) {
        this.cartonLength = cartonLength;
    }
    /**
     * <p>纸箱宽度（cm）</p>
     *
     * @return 纸箱宽度（cm）
     */
    public java.math.BigDecimal getCartonWidth() {
        return cartonWidth;
    }

    /**
     * <p>纸箱宽度（cm）</p>
     *
     * @param cartonWidth 纸箱宽度（cm）
     */
    public void setCartonWidth(java.math.BigDecimal cartonWidth) {
        this.cartonWidth = cartonWidth;
    }
    /**
     * <p>纸箱高度（cm）</p>
     *
     * @return 纸箱高度（cm）
     */
    public java.math.BigDecimal getCartonHeight() {
        return cartonHeight;
    }

    /**
     * <p>纸箱高度（cm）</p>
     *
     * @param cartonHeight 纸箱高度（cm）
     */
    public void setCartonHeight(java.math.BigDecimal cartonHeight) {
        this.cartonHeight = cartonHeight;
    }
    /**
     * <p>托盘堆码数（箱）</p>
     *
     * @return 托盘堆码数（箱）
     */
    public Integer getPalletStackingLimit() {
        return palletStackingLimit;
    }

    /**
     * <p>托盘堆码数（箱）</p>
     *
     * @param palletStackingLimit 托盘堆码数（箱）
     */
    public void setPalletStackingLimit(Integer palletStackingLimit) {
        this.palletStackingLimit = palletStackingLimit;
    }
    /**
     * <p>审核状态，0：待审核，1：正式</p>
     *
     * @return 审核状态，0：待审核，1：正式
     */
    public Boolean getAuditStu() {
        return auditStu;
    }

    /**
     * <p>审核状态，0：待审核，1：正式</p>
     *
     * @param auditStu 审核状态，0：待审核，1：正式
     */
    public void setAuditStu(Boolean auditStu) {
        this.auditStu = auditStu;
    }

}
