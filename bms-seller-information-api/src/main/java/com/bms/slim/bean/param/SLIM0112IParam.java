package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0112AgentSupplyQualificationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0112IParam", description = "批量修改卖家代理商供应资质API的入参")
public class SLIM0112IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    @ApiModelProperty(value = "卖家代理商供应资质参数集合")
    private List<SLIM0112AgentSupplyQualificationParam> agentSupplyQualificationParams;

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    public List<SLIM0112AgentSupplyQualificationParam> getAgentSupplyQualificationParams() {
        return agentSupplyQualificationParams;
    }

    public void setAgentSupplyQualificationParams(List<SLIM0112AgentSupplyQualificationParam> agentSupplyQualificationParams) {
        this.agentSupplyQualificationParams = agentSupplyQualificationParams;
    }
}
