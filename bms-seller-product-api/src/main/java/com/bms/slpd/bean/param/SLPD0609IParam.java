package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0607IMctStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0609IParam",description = "修改加工技术标准指标接口入参")
public class SLPD0609IParam implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "加工技术标准指标信息")
    private List<SLPD0607IMctStdParam> mctStdParams;
    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    public List<SLPD0607IMctStdParam> getMctStdParams() {
        return mctStdParams;
    }

    public void setMctStdParams(List<SLPD0607IMctStdParam> mctStdParams) {
        this.mctStdParams = mctStdParams;
    }

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }
}
