package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0637IGnqDifStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0637IParam",
        description = "新增通用质量标准指标差异接口入参")
public class SLPD0637IParam implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "通用质量标准指标差异卡集合")
    List<SLPD0637IGnqDifStdParam> gnqDifStdParams;

    public List<SLPD0637IGnqDifStdParam> getGnqDifStdParams() {
        return gnqDifStdParams;
    }

    public void setGnqDifStdParams(List<SLPD0637IGnqDifStdParam> gnqDifStdParams) {
        this.gnqDifStdParams = gnqDifStdParams;
    }
}
