package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0625IOrgDifStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0627IParam",
        description = "修改原种种源标准指标差异接口入参")
public class SLPD0627IParam implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "原种种源标准指标信息")
    private List<SLPD0625IOrgDifStdParam> orgDifStdParams;
    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    public List<SLPD0625IOrgDifStdParam> getOrgDifStdParams() {
        return orgDifStdParams;
    }

    public void setOrgDifStdParams(List<SLPD0625IOrgDifStdParam> orgDifStdParams) {
        this.orgDifStdParams = orgDifStdParams;
    }

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }
}
