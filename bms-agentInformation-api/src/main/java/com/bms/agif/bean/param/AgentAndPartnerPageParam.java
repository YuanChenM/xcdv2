package com.bms.agif.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by guan_zhongheng on 2017/3/30.
 */
@ApiModel(value = "AgentAndPartnerPageParam",
        description = "买手与销售合伙人联合数据信息类(可分页)")
public class AgentAndPartnerPageParam extends AgentDemesnePageParam{

    @ApiModelProperty(value = "买手类型： 1、纯粹买手  2、销售合伙人")
    private Integer agentType;

    public Integer getAgentType() {
        return agentType;
    }

    public void setAgentType(Integer agentType) {
        this.agentType = agentType;
    }
}
