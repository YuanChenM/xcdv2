package com.bms.slpd.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0303IParam", description = "修改单品接口入参")
public class SLPD0303IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    @ApiModelProperty(value = "单品修改参数集合")
    private List<SLPD030301IParam> updItemParams;

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    public List<SLPD030301IParam> getUpdItemParams() {
        return updItemParams;
    }

    public void setUpdItemParams(List<SLPD030301IParam> updItemParams) {
        this.updItemParams = updItemParams;
    }
}
