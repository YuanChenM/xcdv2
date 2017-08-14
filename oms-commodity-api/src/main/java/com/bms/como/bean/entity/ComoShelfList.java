/*
 * 2017/03/23 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.como.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表como_shelf_list对应的实体ComoShelfList</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ComoShelfList extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 上下架明细ID */
    private Long shelfDetailId;
    /** 物流区域ID */
    private Long lgcsAreaId;
    /** 物流区域编码 */
    private String lgcsAreaCode;
    /** 物流区域名称 */
    private String lgcsAreaName;
    /** 商品ID */
    private Long commodityId;
    /** 销售上架日期 */
    private java.util.Date addShelfTime;
    /** 销售下架日期 */
    private java.util.Date offShelfTime;

    /**
     * <p>默认构造函数</p>
     */
    public ComoShelfList() {
    }

    /**
     * <p>上下架明细ID</p>
     *
     * @return 上下架明细ID
     */
    public Long getShelfDetailId() {
        return shelfDetailId;
    }

    /**
     * <p>上下架明细ID</p>
     *
     * @param shelfDetailId 上下架明细ID
     */
    public void setShelfDetailId(Long shelfDetailId) {
        this.shelfDetailId = shelfDetailId;
    }
    /**
     * <p>物流区域ID</p>
     *
     * @return 物流区域ID
     */
    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    /**
     * <p>物流区域ID</p>
     *
     * @param lgcsAreaId 物流区域ID
     */
    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }
    /**
     * <p>物流区域编码</p>
     *
     * @return 物流区域编码
     */
    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    /**
     * <p>物流区域编码</p>
     *
     * @param lgcsAreaCode 物流区域编码
     */
    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }
    /**
     * <p>物流区域名称</p>
     *
     * @return 物流区域名称
     */
    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    /**
     * <p>物流区域名称</p>
     *
     * @param lgcsAreaName 物流区域名称
     */
    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }
    /**
     * <p>商品ID</p>
     *
     * @return 商品ID
     */
    public Long getCommodityId() {
        return commodityId;
    }

    /**
     * <p>商品ID</p>
     *
     * @param commodityId 商品ID
     */
    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }
    /**
     * <p>销售上架日期</p>
     *
     * @return 销售上架日期
     */
    public java.util.Date getAddShelfTime() {
        return addShelfTime;
    }

    /**
     * <p>销售上架日期</p>
     *
     * @param addShelfTime 销售上架日期
     */
    public void setAddShelfTime(java.util.Date addShelfTime) {
        this.addShelfTime = addShelfTime;
    }
    /**
     * <p>销售下架日期</p>
     *
     * @return 销售下架日期
     */
    public java.util.Date getOffShelfTime() {
        return offShelfTime;
    }

    /**
     * <p>销售下架日期</p>
     *
     * @param offShelfTime 销售下架日期
     */
    public void setOffShelfTime(java.util.Date offShelfTime) {
        this.offShelfTime = offShelfTime;
    }

}
