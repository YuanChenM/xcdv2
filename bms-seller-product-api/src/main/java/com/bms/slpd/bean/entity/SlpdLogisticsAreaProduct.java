/*
 * 2017/03/28 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表slpd_logistics_area_product对应的实体SlpdLogisticsAreaProduct</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdLogisticsAreaProduct extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 物流区商品ID */
    private Long lacId;
    /** 物流区Id */
    private Long lgcsAreaId;
    /** 物流区编码 */
    private String lgcsAreaCode;
    /** 物流区 */
    private String lgcsAreaName;
    /** 产品需求等级 */
    private String productDemandGrade;
    /** 产品ID */
    private String productId;
    /** 上下架状态，1：上架，2：下架 */
    private String shelfStu;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdLogisticsAreaProduct() {
    }

    /**
     * <p>物流区商品ID</p>
     *
     * @return 物流区商品ID
     */
    public Long getLacId() {
        return lacId;
    }

    /**
     * <p>物流区商品ID</p>
     *
     * @param lacId 物流区商品ID
     */
    public void setLacId(Long lacId) {
        this.lacId = lacId;
    }
    /**
     * <p>物流区Id</p>
     *
     * @return 物流区Id
     */
    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    /**
     * <p>物流区Id</p>
     *
     * @param lgcsAreaId 物流区Id
     */
    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }
    /**
     * <p>物流区编码</p>
     *
     * @return 物流区编码
     */
    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    /**
     * <p>物流区编码</p>
     *
     * @param lgcsAreaCode 物流区编码
     */
    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }
    /**
     * <p>物流区</p>
     *
     * @return 物流区
     */
    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    /**
     * <p>物流区</p>
     *
     * @param lgcsAreaName 物流区
     */
    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }
    /**
     * <p>产品需求等级</p>
     *
     * @return 产品需求等级
     */
    public String getProductDemandGrade() {
        return productDemandGrade;
    }

    /**
     * <p>产品需求等级</p>
     *
     * @param productDemandGrade 产品需求等级
     */
    public void setProductDemandGrade(String productDemandGrade) {
        this.productDemandGrade = productDemandGrade;
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
     * <p>上下架状态，1：上架，2：下架</p>
     *
     * @return 上下架状态，1：上架，2：下架
     */
    public String getShelfStu() {
        return shelfStu;
    }

    /**
     * <p>上下架状态，1：上架，2：下架</p>
     *
     * @param shelfStu 上下架状态，1：上架，2：下架
     */
    public void setShelfStu(String shelfStu) {
        this.shelfStu = shelfStu;
    }

}
