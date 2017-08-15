package com.bms.order.external.bean.result;

import java.io.Serializable;

/**
 * Created by ni_shaotang on 2017/3/15.
 */
public class AGIF0212IRestResult implements Serializable {
    //角色ID
    private String agentId;
    //角色编码
    private String agentcode;
    //角色名称
    private String agentname;
    //角色
    private String roleType;

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getAgentcode() {
        return agentcode;
    }

    public void setAgentcode(String agentcode) {
        this.agentcode = agentcode;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
}
