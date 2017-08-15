package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0619ITspStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0620IParam",
        description = "修改储存运输标准指标接口入参")
public class SLPD0620IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "通用指标标准指标信息")
    private List<SLPD0619ITspStdParam> tspStdParams;
    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    public List<SLPD0619ITspStdParam> getTspStdParams() {
        return tspStdParams;
    }

    public void setTspStdParams(List<SLPD0619ITspStdParam> tspStdParams) {
        this.tspStdParams = tspStdParams;
    }

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }
}
