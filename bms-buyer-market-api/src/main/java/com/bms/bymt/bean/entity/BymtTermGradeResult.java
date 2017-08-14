/*
 * 2016/12/14 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.bymt.bean.entity;

import com.framework.base.rest.entity.BaseEntity;
/**
 * <p>表BYMT_TERM_GRADE_RESULT对应的实体BymtTermGradeResult</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class BymtTermGradeResult extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 定级结果主键 */
    private Long gradeResultId;
    /** 定级详情ID */
    private Long gradeInfoId;
    /** 批发市场级别 */
    private String termMarketLevel;
    /** 辐射范围 */
    private String marketRange;
    /** 服务对象级别 */
    private String serveType;

    /**
     * <p>默认构造函数</p>
     */
    public BymtTermGradeResult() {
    }

    /**
     * <p>定级结果主键</p>
     *
     * @return 定级结果主键
     */
    public Long getGradeResultId() {
        return gradeResultId;
    }

    /**
     * <p>定级结果主键</p>
     *
     * @param gradeResultId 定级结果主键
     */
    public void setGradeResultId(Long gradeResultId) {
        this.gradeResultId = gradeResultId;
    }
    /**
     * <p>定级详情ID</p>
     *
     * @return 定级详情ID
     */
    public Long getGradeInfoId() {
        return gradeInfoId;
    }

    /**
     * <p>定级详情ID</p>
     *
     * @param gradeInfoId 定级详情ID
     */
    public void setGradeInfoId(Long gradeInfoId) {
        this.gradeInfoId = gradeInfoId;
    }
    /**
     * <p>批发市场级别</p>
     *
     * @return 批发市场级别
     */
    public String getTermMarketLevel() {
        return termMarketLevel;
    }

    /**
     * <p>批发市场级别</p>
     *
     * @param termMarketLevel 批发市场级别
     */
    public void setTermMarketLevel(String termMarketLevel) {
        this.termMarketLevel = termMarketLevel;
    }
    /**
     * <p>辐射范围</p>
     *
     * @return 辐射范围
     */
    public String getMarketRange() {
        return marketRange;
    }

    /**
     * <p>辐射范围</p>
     *
     * @param marketRange 辐射范围
     */
    public void setMarketRange(String marketRange) {
        this.marketRange = marketRange;
    }
    /**
     * <p>服务对象级别</p>
     *
     * @return 服务对象级别
     */
    public String getServeType() {
        return serveType;
    }

    /**
     * <p>服务对象级别</p>
     *
     * @param serveType 服务对象级别
     */
    public void setServeType(String serveType) {
        this.serveType = serveType;
    }

}
