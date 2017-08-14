/*
 * 2017/03/02 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.agif.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表AGIF_BUTLER_LEVEL对应的实体AgifButlerLevel</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class AgifButlerLevel extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** ID */
    private Long id;
    /** BUTLER_ID */
    private String butlerId;
    /** LEVEL_ID */
    private Long levelId;
    /** LEVEL_NAME */
    private String levelName;
    /** LEVEL_VALUE */
    private java.math.BigDecimal levelValue;
    /** LEVEL_TIME */
    private java.util.Date levelTime;

    /**
     * <p>默认构造函数</p>
     */
    public AgifButlerLevel() {
    }

    /**
     * <p>ID</p>
     *
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * <p>ID</p>
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * <p>BUTLER_ID</p>
     *
     * @return BUTLER_ID
     */
    public String getButlerId() {
        return butlerId;
    }

    /**
     * <p>BUTLER_ID</p>
     *
     * @param butlerId BUTLER_ID
     */
    public void setButlerId(String butlerId) {
        this.butlerId = butlerId;
    }
    /**
     * <p>LEVEL_ID</p>
     *
     * @return LEVEL_ID
     */
    public Long getLevelId() {
        return levelId;
    }

    /**
     * <p>LEVEL_ID</p>
     *
     * @param levelId LEVEL_ID
     */
    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }
    /**
     * <p>LEVEL_NAME</p>
     *
     * @return LEVEL_NAME
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * <p>LEVEL_NAME</p>
     *
     * @param levelName LEVEL_NAME
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
    /**
     * <p>LEVEL_VALUE</p>
     *
     * @return LEVEL_VALUE
     */
    public java.math.BigDecimal getLevelValue() {
        return levelValue;
    }

    /**
     * <p>LEVEL_VALUE</p>
     *
     * @param levelValue LEVEL_VALUE
     */
    public void setLevelValue(java.math.BigDecimal levelValue) {
        this.levelValue = levelValue;
    }
    /**
     * <p>LEVEL_TIME</p>
     *
     * @return LEVEL_TIME
     */
    public java.util.Date getLevelTime() {
        return levelTime;
    }

    /**
     * <p>LEVEL_TIME</p>
     *
     * @param levelTime LEVEL_TIME
     */
    public void setLevelTime(java.util.Date levelTime) {
        this.levelTime = levelTime;
    }

}
