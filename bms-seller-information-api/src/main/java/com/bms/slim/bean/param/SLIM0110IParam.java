package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0110AgentSupplyQualificationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0110IParam", description = "新增卖家代理商供应资质接口入参")
public class SLIM0110IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "卖家代理商供应资质集合")
    private List<SLIM0110AgentSupplyQualificationParam> slim0110AgentSupplyQualificationParams;

    public List<SLIM0110AgentSupplyQualificationParam> getSlim0110AgentSupplyQualificationParams() {
        return slim0110AgentSupplyQualificationParams;
    }

    public void setSlim0110AgentSupplyQualificationParams(List<SLIM0110AgentSupplyQualificationParam> slim0110AgentSupplyQualificationParams) {
        this.slim0110AgentSupplyQualificationParams = slim0110AgentSupplyQualificationParams;
    }
}
