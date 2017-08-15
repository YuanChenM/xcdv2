package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0640ISftDifStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0642IParam",
        description = "修改安全标准指标差异集合入参")
public class SLPD0642IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "安全标准指标差异卡集合")
    List<SLPD0640ISftDifStdParam> sftDifStdParams;
    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    public List<SLPD0640ISftDifStdParam> getSftDifStdParams() {
        return sftDifStdParams;
    }

    public void setSftDifStdParams(List<SLPD0640ISftDifStdParam> sftDifStdParams) {
        this.sftDifStdParams = sftDifStdParams;
    }

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }
}
