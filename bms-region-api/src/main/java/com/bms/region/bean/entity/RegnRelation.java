/*
 * 2017/02/16 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.region.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表REGN_RELATION对应的实体RegnRelation</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class RegnRelation extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 关联关系主键 */
    private Long relaId;
    /** 物流区划主键 */
    private String lgcsKey;
    /** 行政区划主键 */
    private String regnKey;
    /** 关联层级（1：物流城市与行政城市 2：配送站与区县 3：领地与街道） */
    private String relaType;

    /**
     * <p>默认构造函数</p>
     */
    public RegnRelation() {
    }

    /**
     * <p>关联关系主键</p>
     *
     * @return 关联关系主键
     */
    public Long getRelaId() {
        return relaId;
    }

    /**
     * <p>关联关系主键</p>
     *
     * @param relaId 关联关系主键
     */
    public void setRelaId(Long relaId) {
        this.relaId = relaId;
    }
    /**
     * <p>物流区划主键</p>
     *
     * @return 物流区划主键
     */
    public String getLgcsKey() {
        return lgcsKey;
    }

    /**
     * <p>物流区划主键</p>
     *
     * @param lgcsKey 物流区划主键
     */
    public void setLgcsKey(String lgcsKey) {
        this.lgcsKey = lgcsKey;
    }
    /**
     * <p>行政区划主键</p>
     *
     * @return 行政区划主键
     */
    public String getRegnKey() {
        return regnKey;
    }

    /**
     * <p>行政区划主键</p>
     *
     * @param regnKey 行政区划主键
     */
    public void setRegnKey(String regnKey) {
        this.regnKey = regnKey;
    }
    /**
     * <p>关联层级（1：物流城市与行政城市 2：配送站与区县 3：领地与街道）</p>
     *
     * @return 关联层级（1：物流城市与行政城市 2：配送站与区县 3：领地与街道）
     */
    public String getRelaType() {
        return relaType;
    }

    /**
     * <p>关联层级（1：物流城市与行政城市 2：配送站与区县 3：领地与街道）</p>
     *
     * @param relaType 关联层级（1：物流城市与行政城市 2：配送站与区县 3：领地与街道）
     */
    public void setRelaType(String relaType) {
        this.relaType = relaType;
    }

}
