/*
 * 2017/03/08 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.agif.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表agif_butler_demesne对应的实体AgifButlerDemesne</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class AgifButlerDemesne extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** BUTLER_DEMESNE_ID */
    private Long butlerDemesneId;
    /** BUTLER_ID */
    private String butlerId;
    /** AGENT_DEMESNE_ID */
    private Long agentDemesneId;

    /**
     * <p>默认构造函数</p>
     */
    public AgifButlerDemesne() {
    }

    /**
     * <p>BUTLER_DEMESNE_ID</p>
     *
     * @return BUTLER_DEMESNE_ID
     */
    public Long getButlerDemesneId() {
        return butlerDemesneId;
    }

    /**
     * <p>BUTLER_DEMESNE_ID</p>
     *
     * @param butlerDemesneId BUTLER_DEMESNE_ID
     */
    public void setButlerDemesneId(Long butlerDemesneId) {
        this.butlerDemesneId = butlerDemesneId;
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
     * <p>AGENT_DEMESNE_ID</p>
     *
     * @return AGENT_DEMESNE_ID
     */
    public Long getAgentDemesneId() {
        return agentDemesneId;
    }

    /**
     * <p>AGENT_DEMESNE_ID</p>
     *
     * @param agentDemesneId AGENT_DEMESNE_ID
     */
    public void setAgentDemesneId(Long agentDemesneId) {
        this.agentDemesneId = agentDemesneId;
    }

}
