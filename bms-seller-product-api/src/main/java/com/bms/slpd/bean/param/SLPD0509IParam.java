package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0509IAgentProductParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0509IParam", description = "批量审核代理商制造商生产商产品API的入参")
public class SLPD0509IParam implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "参数集合")
	private List<SLPD0509IAgentProductParam> agentProductParams;

	public List<SLPD0509IAgentProductParam> getAgentProductParams() {
		return agentProductParams;
	}

	public void setAgentProductParams(List<SLPD0509IAgentProductParam> agentProductParams) {
		this.agentProductParams = agentProductParams;
	}
}
