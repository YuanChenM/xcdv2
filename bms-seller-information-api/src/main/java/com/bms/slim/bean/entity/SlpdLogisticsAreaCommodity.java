/*
 * 2017/02/17 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_LOGISTICS_AREA_COMMODITY对应的实体SlpdLogisticsAreaCommodity</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdLogisticsAreaCommodity extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 物流区商品ID */
    private Long lacId;
    /** 物流区编码 */
    private String lgcsAreaCode;
    /** 物流区 */
    private String lgcsAreaName;
    /** 卖家单品品牌(规格)生产商ID */
    private String commodityId;
    /** 上下架状态，1：上架，2：下架 */
    private String shelfStu;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdLogisticsAreaCommodity() {
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
     * <p>卖家单品品牌(规格)生产商ID</p>
     *
     * @return 卖家单品品牌(规格)生产商ID
     */
    public String getCommodityId() {
        return commodityId;
    }

    /**
     * <p>卖家单品品牌(规格)生产商ID</p>
     *
     * @param commodityId 卖家单品品牌(规格)生产商ID
     */
    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
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
