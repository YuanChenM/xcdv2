/*
 * 2017/02/22 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.byim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表BYIM_STANDARD_FREQUENTER_LEVEL对应的实体ByimStandardFrequenterLevel</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ByimStandardFrequenterLevel extends BaseEntity {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
    /**
     * LEVEL_STANDARD_ID
     */
    private Long levelStandardId;
    /**
     * LEVEL_STANDARD
     */
    private String levelStandard;
    /**
     * 单位：单
     */
    private Integer minFrequency;
    /**
     * 单位：单
     */
    private Integer maxFrequency;
    /**
     * 单位：箱
     */
    private Integer minAmount;
    /**
     * 单位：箱
     */
    private Integer maxAmount;

    /**
     * <p>默认构造函数</p>
     */
    public ByimStandardFrequenterLevel() {
    }

    /**
     * <p>LEVEL_STANDARD_ID</p>
     *
     * @return LEVEL_STANDARD_ID
     */
    public Long getLevelStandardId() {
        return levelStandardId;
    }

    /**
     * <p>LEVEL_STANDARD_ID</p>
     *
     * @param levelStandardId LEVEL_STANDARD_ID
     */
    public void setLevelStandardId(Long levelStandardId) {
        this.levelStandardId = levelStandardId;
    }

    /**
     * <p>LEVEL_STANDARD</p>
     *
     * @return LEVEL_STANDARD
     */
    public String getLevelStandard() {
        return levelStandard;
    }

    /**
     * <p>LEVEL_STANDARD</p>
     *
     * @param levelStandard LEVEL_STANDARD
     */
    public void setLevelStandard(String levelStandard) {
        this.levelStandard = levelStandard;
    }

    /**
     * <p>单位：单</p>
     *
     * @return 单位：单
     */
    public Integer getMinFrequency() {
        return minFrequency;
    }

    /**
     * <p>单位：单</p>
     *
     * @param minFrequency 单位：单
     */
    public void setMinFrequency(Integer minFrequency) {
        this.minFrequency = minFrequency;
    }

    /**
     * <p>单位：单</p>
     *
     * @return 单位：单
     */
    public Integer getMaxFrequency() {
        return maxFrequency;
    }

    /**
     * <p>单位：单</p>
     *
     * @param maxFrequency 单位：单
     */
    public void setMaxFrequency(Integer maxFrequency) {
        this.maxFrequency = maxFrequency;
    }

    /**
     * <p>单位：箱</p>
     *
     * @return 单位：箱
     */
    public Integer getMinAmount() {
        return minAmount;
    }

    /**
     * <p>单位：箱</p>
     *
     * @param minAmount 单位：箱
     */
    public void setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
    }

    /**
     * <p>单位：箱</p>
     *
     * @return 单位：箱
     */
    public Integer getMaxAmount() {
        return maxAmount;
    }

    /**
     * <p>单位：箱</p>
     *
     * @param maxAmount 单位：箱
     */
    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
    }


}
