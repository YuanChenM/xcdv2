package com.bms.agif.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by yuan_chen on 2017/4/10.
 *
 * 买家买手关系查询Param
 */
@ApiModel(value = "AgentRelationParam",
    description = "买家买手关系查询条件")
public class AgentRelationParam implements Serializable {
    @ApiModelProperty(value = "买手ID")
    private String agentId;

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
}
