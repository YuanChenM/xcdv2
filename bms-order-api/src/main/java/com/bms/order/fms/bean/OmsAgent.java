package com.bms.order.fms.bean;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by yuan_chen on 2017/4/12 0012.
 *
 * oms内部子系统-买手系统的买手
 */
public class OmsAgent implements Serializable {
    private static final long serialVersionUID = 7890593822262089054L;
    @ApiModelProperty(value = "买手ID")
    private String agentId;
    @ApiModelProperty(value = "买手编码")
    private String agentCode;
    @ApiModelProperty(value = "买手名称")
    private String agentName;

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
}

