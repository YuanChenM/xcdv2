package com.bms.agif.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by guan_zhongheng on 2017/3/13.
 */
@ApiModel(value = "ButlerDemesneParam",
        description = "管家领地信息类")
public class ButlerDemesneParam implements Serializable{

    @ApiModelProperty(value = "管家领地ID")
    private Long butlerDemesneId;
    /** BUTLER_ID */
    @ApiModelProperty(value = "管家ID")
    private String butlerId;
    @ApiModelProperty(value = "管家编码")
    private String butlerCode;
    /** AGENT_DEMESNE_ID */
    @ApiModelProperty(value = "买手领地ID")
    private Long agentDemesneId;

    public Long getButlerDemesneId() {
        return butlerDemesneId;
    }

    public void setButlerDemesneId(Long butlerDemesneId) {
        this.butlerDemesneId = butlerDemesneId;
    }

    public String getButlerId() {
        return butlerId;
    }

    public String getButlerCode() {
        return butlerCode;
    }

    public void setButlerCode(String butlerCode) {
        this.butlerCode = butlerCode;
    }

    public void setButlerId(String butlerId) {
        this.butlerId = butlerId;
    }

    public Long getAgentDemesneId() {
        return agentDemesneId;
    }

    public void setAgentDemesneId(Long agentDemesneId) {
        this.agentDemesneId = agentDemesneId;
    }
}
