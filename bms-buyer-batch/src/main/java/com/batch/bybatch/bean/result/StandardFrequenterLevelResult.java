package com.batch.bybatch.bean.result;

import java.io.Serializable;

/**
 * Created by guan_zhongheng on 2017/2/23.
 */
public class StandardFrequenterLevelResult implements Serializable{

    /**
     * 常客等级标准ID
     */
    private Long levelStandardId;

    /**
     * 常客等级
     */
    private String levelStandard;

    /**
     * 最小频率
     */
    private Integer minFrequency;

    /**
     * 最大频率
     */
    private Integer maxFrequency;

    /**
     * 最小量级
     */
    private Integer minAmount;

    /**
     * 最大量级
     */
    private Integer maxAmount;

    public Long getLevelStandardId() {
        return levelStandardId;
    }

    public void setLevelStandardId(Long levelStandardId) {
        this.levelStandardId = levelStandardId;
    }

    public String getLevelStandard() {
        return levelStandard;
    }

    public void setLevelStandard(String levelStandard) {
        this.levelStandard = levelStandard;
    }

    public Integer getMinFrequency() {
        return minFrequency;
    }

    public void setMinFrequency(Integer minFrequency) {
        this.minFrequency = minFrequency;
    }

    public Integer getMaxFrequency() {
        return maxFrequency;
    }

    public void setMaxFrequency(Integer maxFrequency) {
        this.maxFrequency = maxFrequency;
    }

    public Integer getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
    }

    public Integer getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
    }
}
