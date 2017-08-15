package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0628IFedDifStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0628IParam",description = "新增饲养标准指标差异接口入参")
public class SLPD0628IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "新增饲养标准指标集合")
    private List<SLPD0628IFedDifStdParam> fedDifStdParams;

    public List<SLPD0628IFedDifStdParam> getFedDifStdParams() {
        return fedDifStdParams;
    }

    public void setFedDifStdParams(List<SLPD0628IFedDifStdParam> fedDifStdParams) {
        this.fedDifStdParams = fedDifStdParams;
    }
}
