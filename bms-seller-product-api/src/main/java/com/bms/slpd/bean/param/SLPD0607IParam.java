package com.bms.slpd.bean.param;


import com.bms.slpd.bean.param.field.SLPD0607IMctStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0607IParam",description = "新增加工技术标准指标接口入参")
public class SLPD0607IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "加工技术标准指标集合")
    List<SLPD0607IMctStdParam> mctStdParams;

    public List<SLPD0607IMctStdParam> getMctStdParams() {
        return mctStdParams;
    }

    public void setMctStdParams(List<SLPD0607IMctStdParam> mctStdParams) {
        this.mctStdParams = mctStdParams;
    }
}
