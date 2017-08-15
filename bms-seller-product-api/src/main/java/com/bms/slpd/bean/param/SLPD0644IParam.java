package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0643ITspDifStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0644IParam",
        description = "新增储存运输标准指标差异接口入参")
public class SLPD0644IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "安全标准指标差异卡集合")
    List<SLPD0643ITspDifStdParam> tspDifStdParams;
    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    public List<SLPD0643ITspDifStdParam> getTspDifStdParams() {
        return tspDifStdParams;
    }

    public void setTspDifStdParams(List<SLPD0643ITspDifStdParam> tspDifStdParams) {
        this.tspDifStdParams = tspDifStdParams;
    }

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }
}
