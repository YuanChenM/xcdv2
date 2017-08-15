package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0107SellerManagementTeamParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0107IParam", description = "新增卖家经营团队接口入参")
public class SLIM0107IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "卖家经营团队集合")
    private List<SLIM0107SellerManagementTeamParam> managementTeams;

    public List<SLIM0107SellerManagementTeamParam> getManagementTeams() {
        return managementTeams;
    }

    public void setManagementTeams(List<SLIM0107SellerManagementTeamParam> managementTeams) {
        this.managementTeams = managementTeams;
    }
}
