package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0613IGnqStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0615IParam",
        description = "修改通用质量标准信息集合入参")
public class SLPD0615IParam implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "通用指标标准指标信息")
    private List<SLPD0613IGnqStdParam> gnqStdParams;
    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    public List<SLPD0613IGnqStdParam> getGnqStdParams() {
        return gnqStdParams;
    }

    public void setGnqStdParams(List<SLPD0613IGnqStdParam> gnqStdParams) {
        this.gnqStdParams = gnqStdParams;
    }

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }
}
