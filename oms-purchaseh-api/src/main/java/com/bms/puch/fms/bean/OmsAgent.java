package com.bms.puch.fms.bean;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by yuan_zhifei on 2017/5/4.
 */
public class OmsAgent implements Serializable {
    private static final long serialVersionUID = 7890593822262089054L;
    @ApiModelProperty(value = "买手ID")
    private String agentId;
    @ApiModelProperty(value = "买手编码")
    private String agentCode;

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
}
