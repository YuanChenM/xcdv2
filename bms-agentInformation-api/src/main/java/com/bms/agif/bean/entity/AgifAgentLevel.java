/*
 * 2017/03/02 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.agif.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表AGIF_AGENT_LEVEL对应的实体AgifAgentLevel</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class AgifAgentLevel extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** ID */
    private Long id;
    /** AGENT_ID */
    private String agentId;
    /** FREQUENTER_AGENT_F */
    private String frequenterAgentF;
    /** FREQUENTER_AGENT_A  */
    private String frequenterAgentA ;
    /** LEVEL_TIME */
    private java.util.Date levelTime;

    /**
     * <p>默认构造函数</p>
     */
    public AgifAgentLevel() {
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
     * <p>AGENT_ID</p>
     *
     * @return AGENT_ID
     */
    public String getAgentId() {
        return agentId;
    }

    /**
     * <p>AGENT_ID</p>
     *
     * @param agentId AGENT_ID
     */
    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getFrequenterAgentF() {
        return frequenterAgentF;
    }

    public void setFrequenterAgentF(String frequenterAgentF) {
        this.frequenterAgentF = frequenterAgentF;
    }

    public String getFrequenterAgentA() {
        return frequenterAgentA;
    }

    public void setFrequenterAgentA(String frequenterAgentA) {
        this.frequenterAgentA = frequenterAgentA;
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
