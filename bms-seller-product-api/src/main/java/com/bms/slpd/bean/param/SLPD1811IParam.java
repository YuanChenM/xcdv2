package com.bms.slpd.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD1811IParam", description = "删除代理商单品品牌规格生产商API的入参")
public class SLPD1811IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "删除代理商单品品牌规格生产商集合")
    private List<SLPD1811IAgentProductParam> agentProductParams;

    public List<SLPD1811IAgentProductParam> getAgentProductParams() {
        return agentProductParams;
    }

    public void setAgentProductParams(List<SLPD1811IAgentProductParam> agentProductParams) {
        this.agentProductParams = agentProductParams;
    }
}
