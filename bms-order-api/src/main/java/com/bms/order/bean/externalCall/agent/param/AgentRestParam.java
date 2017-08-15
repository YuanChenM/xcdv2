package com.bms.order.bean.externalCall.agent.param;

import java.io.Serializable;

/**
 * 查询买手信息 入参
 * Created by zhang_qiang1 on 2017/1/4.
 */
public class AgentRestParam implements Serializable {


    /**
     * 买手Id
     */
    private String agentId;

    /**
     * 买手编码
     */
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
