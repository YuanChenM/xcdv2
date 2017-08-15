package com.bms.slpd.bean.param;


import com.bms.slpd.bean.param.field.SLPD0643ITspDifStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0643IParam",
        description = "新增储存运输标准指标差异接口入参")
public class SLPD0643IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "储存运输指标差异集合")
    List<SLPD0643ITspDifStdParam> tspDifStdParams;

    public List<SLPD0643ITspDifStdParam> getTspDifStdParams() {
        return tspDifStdParams;
    }

    public void setTspDifStdParams(List<SLPD0643ITspDifStdParam> tspDifStdParams) {
        this.tspDifStdParams = tspDifStdParams;
    }
}
