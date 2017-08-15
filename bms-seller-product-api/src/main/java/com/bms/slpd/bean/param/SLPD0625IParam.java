package com.bms.slpd.bean.param;


import com.bms.slpd.bean.param.field.SLPD0625IOrgDifStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0625IParam",description = "新增原种种源标准指标差异接口入参")
public class SLPD0625IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "新增原种种源标准指标集合")
    private List<SLPD0625IOrgDifStdParam> orgDifStdParams;


    public List<SLPD0625IOrgDifStdParam> getOrgDifStdParams() {
        return orgDifStdParams;
    }

    public void setOrgDifStdParams(List<SLPD0625IOrgDifStdParam> orgDifStdParams) {
        this.orgDifStdParams = orgDifStdParams;
    }
}
