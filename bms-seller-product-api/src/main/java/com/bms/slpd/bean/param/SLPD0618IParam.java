package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0616ISftStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0618IParam",description = "修改安全标准指标接口入参")
public class SLPD0618IParam implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "通用指标标准指标信息")
    private List<SLPD0616ISftStdParam> sftStdParams;
    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    public List<SLPD0616ISftStdParam> getSftStdParams() {
        return sftStdParams;
    }

    public void setSftStdParams(List<SLPD0616ISftStdParam> sftStdParams) {
        this.sftStdParams = sftStdParams;
    }

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }
}
