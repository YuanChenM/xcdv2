package com.bms.agif.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by yuan_zhifei on 2017/4/10.
 */
@ApiModel(value = "AgentRelationResult", description = "买家买手上级角色查询返回参数")
public class AgentRelationRsResult implements Serializable {
    @ApiModelProperty(value = "买手（合伙人，管家）ID")
    private String agentId;
    @ApiModelProperty(value = "买手（合伙人，管家）编码")
    private String agentCode;
    @ApiModelProperty(value = "买手（合伙人，管家）名称")
    private String agentName;
    @ApiModelProperty(value = "买手：agent，合伙人：partner,管家：butler，买家：buyer")
    private String roleType;

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
}
