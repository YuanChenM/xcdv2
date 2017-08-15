package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0121SellerBusinessTeamParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0121IParam", description = "批量修改卖家电商经营团队API的入参")
public class SLIM0121IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    @ApiModelProperty(value = "卖家电商经营团队参数集合")
    private List<SLIM0121SellerBusinessTeamParam> businessTeams;

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    public List<SLIM0121SellerBusinessTeamParam> getBusinessTeams() {
        return businessTeams;
    }

    public void setBusinessTeams(List<SLIM0121SellerBusinessTeamParam> businessTeams) {
        this.businessTeams = businessTeams;
    }
}
