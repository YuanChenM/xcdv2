/*
 * 2017/04/14 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.linv.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表invm_sku_info对应的实体InvmSkuInfo</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class InvmSkuInfo extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** SKU编码 */
    private String skuCode;
    /** 产品ID */
    private String pdId;
    /** 生产商ID */
    private Long pdrsId;
    /** 生产商编码 */
    private String pdrsCode;
    /** 生产商名称 */
    private String pdrsName;
    /** 制造商ID */
    private Long mfrsId;
    /** 制造商编码 */
    private String mfrsCode;
    /** 制造商名称 */
    private String mfrsName;

    /**
     * <p>默认构造函数</p>
     */
    public InvmSkuInfo() {
    }

    /**
     * <p>SKU编码</p>
     *
     * @return SKU编码
     */
    public String getSkuCode() {
        return skuCode;
    }

    /**
     * <p>SKU编码</p>
     *
     * @param skuCode SKU编码
     */
    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }
    /**
     * <p>产品ID</p>
     *
     * @return 产品ID
     */
    public String getPdId() {
        return pdId;
    }

    /**
     * <p>产品ID</p>
     *
     * @param pdId 产品ID
     */
    public void setPdId(String pdId) {
        this.pdId = pdId;
    }
    /**
     * <p>生产商ID</p>
     *
     * @return 生产商ID
     */
    public Long getPdrsId() {
        return pdrsId;
    }

    /**
     * <p>生产商ID</p>
     *
     * @param pdrsId 生产商ID
     */
    public void setPdrsId(Long pdrsId) {
        this.pdrsId = pdrsId;
    }
    /**
     * <p>生产商编码</p>
     *
     * @return 生产商编码
     */
    public String getPdrsCode() {
        return pdrsCode;
    }

    /**
     * <p>生产商编码</p>
     *
     * @param pdrsCode 生产商编码
     */
    public void setPdrsCode(String pdrsCode) {
        this.pdrsCode = pdrsCode;
    }
    /**
     * <p>生产商名称</p>
     *
     * @return 生产商名称
     */
    public String getPdrsName() {
        return pdrsName;
    }

    /**
     * <p>生产商名称</p>
     *
     * @param pdrsName 生产商名称
     */
    public void setPdrsName(String pdrsName) {
        this.pdrsName = pdrsName;
    }
    /**
     * <p>制造商ID</p>
     *
     * @return 制造商ID
     */
    public Long getMfrsId() {
        return mfrsId;
    }

    /**
     * <p>制造商ID</p>
     *
     * @param mfrsId 制造商ID
     */
    public void setMfrsId(Long mfrsId) {
        this.mfrsId = mfrsId;
    }
    /**
     * <p>制造商编码</p>
     *
     * @return 制造商编码
     */
    public String getMfrsCode() {
        return mfrsCode;
    }

    /**
     * <p>制造商编码</p>
     *
     * @param mfrsCode 制造商编码
     */
    public void setMfrsCode(String mfrsCode) {
        this.mfrsCode = mfrsCode;
    }
    /**
     * <p>制造商名称</p>
     *
     * @return 制造商名称
     */
    public String getMfrsName() {
        return mfrsName;
    }

    /**
     * <p>制造商名称</p>
     *
     * @param mfrsName 制造商名称
     */
    public void setMfrsName(String mfrsName) {
        this.mfrsName = mfrsName;
    }

}
