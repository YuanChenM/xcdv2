package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0601IOrgStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0601IParam",
        description = "新增原种种源标准指标接口入参")
public class SLPD0601IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "新增原种种源标准指标集合")
    private List<SLPD0601IOrgStdParam> orgStdParams;

    public List<SLPD0601IOrgStdParam> getOrgStdParams() {
        return orgStdParams;
    }

    public void setOrgStdParams(List<SLPD0601IOrgStdParam> orgStdParams) {
        this.orgStdParams = orgStdParams;
    }
}
