package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0634ITncDifStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0636IParam",
        description = "修改加工质量标准差异接口入参")
public class SLPD0636IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "加工质量标准指标差异卡集合")
    List<SLPD0634ITncDifStdParam> tncDifStdParams;
    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    public List<SLPD0634ITncDifStdParam> getTncDifStdParams() {
        return tncDifStdParams;
    }

    public void setTncDifStdParams(List<SLPD0634ITncDifStdParam> tncDifStdParams) {
        this.tncDifStdParams = tncDifStdParams;
    }

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }
}
