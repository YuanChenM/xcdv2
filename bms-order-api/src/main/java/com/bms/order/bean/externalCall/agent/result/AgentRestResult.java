package com.bms.order.bean.externalCall.agent.result;

import java.io.Serializable;

/**
 * 查询买手信息 出参
 * Created by zhang_qiang1 on 2017/1/4.
 */
public class AgentRestResult  implements Serializable{

    /**
     * 买手Id
     */
    private String agentId;

    /**
     * 买手编码
     */
    private String agentCode;



    private  String  name;




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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
