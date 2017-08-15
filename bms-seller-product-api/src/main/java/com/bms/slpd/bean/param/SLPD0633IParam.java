package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0631IMctDifStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0633IParam",
        description = "修改加工技术标准指标差异卡集合入参")
public class SLPD0633IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "修改加工技术指标集合")
    private List<SLPD0631IMctDifStdParam> mctDifStdParams;
    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    public List<SLPD0631IMctDifStdParam> getMctDifStdParams() {
        return mctDifStdParams;
    }

    public void setMctDifStdParams(List<SLPD0631IMctDifStdParam> mctDifStdParams) {
        this.mctDifStdParams = mctDifStdParams;
    }

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }
}
