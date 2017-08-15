package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0631IMctDifStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0631IParam",
        description = "新增加工技术标准指标差异卡集合入参")
public class SLPD0631IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "加工技术标准指标差异卡集合")
    List<SLPD0631IMctDifStdParam> mctDifStdParams;

    public List<SLPD0631IMctDifStdParam> getMctDifStdParams() {
        return mctDifStdParams;
    }

    public void setMctDifStdParams(List<SLPD0631IMctDifStdParam> mctDifStdParams) {
        this.mctDifStdParams = mctDifStdParams;
    }
}
