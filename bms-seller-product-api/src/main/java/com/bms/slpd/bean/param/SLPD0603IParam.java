package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0601IOrgStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0603IParam",
        description = "修改原种种源标准指标接口入参")
public class SLPD0603IParam implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "原种种源标准指标信息")
    private List<SLPD0601IOrgStdParam> orgStdParams;
    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    public List<SLPD0601IOrgStdParam> getOrgStdParams() {
        return orgStdParams;
    }

    public void setOrgStdParams(List<SLPD0601IOrgStdParam> orgStdParams) {
        this.orgStdParams = orgStdParams;
    }

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }
}
