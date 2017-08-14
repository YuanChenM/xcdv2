/*
 * 2017/03/21 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.batch.bybatch.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表byim_frequenter_level对应的实体ByimFrequenterLevel</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ByimFrequenterLevel extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** LEVEL_ID */
    private Long levelId;
    /** BUYER_ID */
    private String buyerId;
    /** BUYER_ID */
    private String frequenterLevelCode;
    /** FREQUENTER_LEVEL_F */
    private String frequenterLevelF;
    /** FREQUENTER_LEVEL_A */
    private String frequenterLevelA;
    /** 单位：单 */
    private String frequency;
    /** 单位：箱 */
    private String amount;

    /**
     * <p>默认构造函数</p>
     */
    public ByimFrequenterLevel() {
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
     * <p>BUYER_ID</p>
     *
     * @return BUYER_ID
     */
    public String getBuyerId() {
        return buyerId;
    }

    /**
     * <p>BUYER_ID</p>
     *
     * @param buyerId BUYER_ID
     */
    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }
    /**
     * <p>FREQUENTER_LEVEL_F</p>
     *
     * @return FREQUENTER_LEVEL_F
     */
    public String getFrequenterLevelF() {
        return frequenterLevelF;
    }

    /**
     * <p>FREQUENTER_LEVEL_F</p>
     *
     * @param frequenterLevelF FREQUENTER_LEVEL_F
     */
    public void setFrequenterLevelF(String frequenterLevelF) {
        this.frequenterLevelF = frequenterLevelF;
    }
    /**
     * <p>FREQUENTER_LEVEL_A</p>
     *
     * @return FREQUENTER_LEVEL_A
     */
    public String getFrequenterLevelA() {
        return frequenterLevelA;
    }

    /**
     * <p>FREQUENTER_LEVEL_A</p>
     *
     * @param frequenterLevelA FREQUENTER_LEVEL_A
     */
    public void setFrequenterLevelA(String frequenterLevelA) {
        this.frequenterLevelA = frequenterLevelA;
    }
    /**
     * <p>单位：单</p>
     *
     * @return 单位：单
     */
    public String getFrequency() {
        return frequency;
    }

    /**
     * <p>单位：单</p>
     *
     * @param frequency 单位：单
     */
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
    /**
     * <p>单位：箱</p>
     *
     * @return 单位：箱
     */
    public String getAmount() {
        return amount;
    }

    /**
     * <p>单位：箱</p>
     *
     * @param amount 单位：箱
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getFrequenterLevelCode() {
        return frequenterLevelCode;
    }

    public void setFrequenterLevelCode(String frequenterLevelCode) {
        this.frequenterLevelCode = frequenterLevelCode;
    }
}
