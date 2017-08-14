/*
 * 2016/12/14 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.bymt.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表BYMT_MARKET_STATION_RELATION对应的实体BymtMarketStationRelation</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class BymtMarketStationRelation extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 配送关系主键 */
    private Long distributionMarketId;
    /** 配送站ID */
    private Long stationId;
    /** 配送站名称 */
    private String stationName;
    /** 配送站编码 */
    private String stationCode;
    /** 市场ID */
    private String termMarketId;


    /**
     * <p>默认构造函数</p>
     */
    public BymtMarketStationRelation() {
    }

    /**
     * <p>配送关系主键</p>
     *
     * @return 配送关系主键
     */
    public Long getDistributionMarketId() {
        return distributionMarketId;
    }

    /**
     * <p>配送关系主键</p>
     *
     * @param distributionMarketId 配送关系主键
     */
    public void setDistributionMarketId(Long distributionMarketId) {
        this.distributionMarketId = distributionMarketId;
    }
    /**
     * <p>配送站ID</p>
     *
     * @return 配送站ID
     */
    public Long getStationId() {
        return stationId;
    }

    /**
     * <p>配送站ID</p>
     *
     * @param stationId 配送站ID
     */
    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }
    /**
     * <p>配送站名称</p>
     *
     * @return 配送站名称
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * <p>配送站名称</p>
     *
     * @param stationName 配送站名称
     */
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
    /**
     * <p>配送站编码</p>
     *
     * @return 配送站编码
     */
    public String getStationCode() {
        return stationCode;
    }

    /**
     * <p>配送站编码</p>
     *
     * @param stationCode 配送站编码
     */
    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }
    /**
     * <p>市场ID</p>
     *
     * @return 市场ID
     */
    public String getTermMarketId() {
        return termMarketId;
    }

    /**
     * <p>市场ID</p>
     *
     * @param termMarketId 市场ID
     */
    public void setTermMarketId(String termMarketId) {
        this.termMarketId = termMarketId;
    }

}
