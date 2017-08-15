package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0610ITncStdParam;
import com.framework.base.rest.param.BaseRestParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0612IParam",
        description = "修改加工质量标准接口入参")
public class SLPD0612IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "加工质量标准指标信息")
    private List<SLPD0610ITncStdParam> tncStdParams;
    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    public List<SLPD0610ITncStdParam> getTncStdParams() {
        return tncStdParams;
    }

    public void setTncStdParams(List<SLPD0610ITncStdParam> tncStdParams) {
        this.tncStdParams = tncStdParams;
    }

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }
}
