package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0613IGnqStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0613IParam",
        description = "新增通用质量标准信息集合入参")
public class SLPD0613IParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "通用质量标准信息表")
    List<SLPD0613IGnqStdParam> gnqStdParams;

    public List<SLPD0613IGnqStdParam> getGnqStdParams() {
        return gnqStdParams;
    }

    public void setGnqStdParams(List<SLPD0613IGnqStdParam> gnqStdParams) {
        this.gnqStdParams = gnqStdParams;
    }
}
