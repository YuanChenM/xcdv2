package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0628IFedDifStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0630IParam",description = "修改饲养标准指标差异接口入参")
public class SLPD0630IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "修改饲养标准指标集合")
    private List<SLPD0628IFedDifStdParam> fedDifStdParams;
    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    public List<SLPD0628IFedDifStdParam> getFedDifStdParams() {
        return fedDifStdParams;
    }

    public void setFedDifStdParams(List<SLPD0628IFedDifStdParam> fedDifStdParams) {
        this.fedDifStdParams = fedDifStdParams;
    }

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }
}
