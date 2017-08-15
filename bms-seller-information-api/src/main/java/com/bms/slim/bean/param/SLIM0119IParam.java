package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0119SellerBusinessTeamParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0119IParam", description = "新增卖家电商经营团队接口入参")
public class SLIM0119IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "卖家电商经营团队集合")
    private List<SLIM0119SellerBusinessTeamParam> businessTeams;

    public List<SLIM0119SellerBusinessTeamParam> getBusinessTeams() {
        return businessTeams;
    }

    public void setBusinessTeams(List<SLIM0119SellerBusinessTeamParam> businessTeams) {
        this.businessTeams = businessTeams;
    }
}
