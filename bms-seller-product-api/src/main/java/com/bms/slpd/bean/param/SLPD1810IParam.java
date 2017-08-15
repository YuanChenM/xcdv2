package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD1810IAgentSupplyProductParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD1810IParam", description = "批量新增单品品牌规格代理商接口入参")
public class SLPD1810IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "单品品牌规格代理商集合")
    private List<SLPD1810IAgentSupplyProductParam> agentSupplyProductParams;

    public List<SLPD1810IAgentSupplyProductParam> getAgentSupplyProductParams() {
        return agentSupplyProductParams;
    }

    public void setAgentSupplyProductParams(List<SLPD1810IAgentSupplyProductParam> agentSupplyProductParams) {
        this.agentSupplyProductParams = agentSupplyProductParams;
    }
}
