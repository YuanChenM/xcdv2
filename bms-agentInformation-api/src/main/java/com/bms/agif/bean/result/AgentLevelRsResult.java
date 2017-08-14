package com.bms.agif.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yuan_zhifei on 2017/5/12.
 */
@ApiModel(value = "AgentLevelRsResult", description = "买手等级信息返回结果")
public class AgentLevelRsResult implements Serializable {
    @ApiModelProperty(value = "等级信息ID")
    private Long id;
    @ApiModelProperty(value = "买手ID")
    private String agentId;
    @ApiModelProperty(value = "常客买手等级（频次）")
    private String frequenterAgentF;
    @ApiModelProperty(value = "常客买手等级（量级）")
    private String frequenterAgentA;
    @ApiModelProperty(value = "定级时间")
    private Date levelTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgentId() {
        return agentId;
    }

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

    public Date getLevelTime() {
        return levelTime;
    }

    public void setLevelTime(Date levelTime) {
        this.levelTime = levelTime;
    }
}
