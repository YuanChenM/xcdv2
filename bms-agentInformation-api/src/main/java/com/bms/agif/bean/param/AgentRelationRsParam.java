package com.bms.agif.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by yuan_zhifei on 2017/4/10.
 */
@ApiModel(value = "AgentRelationRsParam", description = "买家买手上级角色查询传入参数")
public class AgentRelationRsParam implements Serializable {
    @ApiModelProperty(value = "买家，管家或买手的系统主键")
    private String agentId;

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
}
