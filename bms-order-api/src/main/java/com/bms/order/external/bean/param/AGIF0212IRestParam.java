package com.bms.order.external.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import com.framework.base.rest.param.BaseRestParam;

import java.io.Serializable;

/**
 * Created by ni_shaotang on 2017/3/15.
 */
public class AGIF0212IRestParam implements Serializable {

    private static final long serialVersionUID = 1L;

    //角色ID
    private String agentId;

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

}
