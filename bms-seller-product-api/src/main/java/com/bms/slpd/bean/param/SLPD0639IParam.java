package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0637IGnqDifStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0639IParam",
        description = "修改通用质量标准指标差异接口入参")
public class SLPD0639IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "通用质量标准指标差异卡集合")
    List<SLPD0637IGnqDifStdParam> gnqDifStdParams;
    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    public List<SLPD0637IGnqDifStdParam> getGnqDifStdParams() {
        return gnqDifStdParams;
    }

    public void setGnqDifStdParams(List<SLPD0637IGnqDifStdParam> gnqDifStdParams) {
        this.gnqDifStdParams = gnqDifStdParams;
    }

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }
}
