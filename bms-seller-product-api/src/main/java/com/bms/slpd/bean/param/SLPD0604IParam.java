package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0601IFedStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0604IParam",description = "新增饲养标准指标集合入参")
public class SLPD0604IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "饲养标准指标集合")
    List<SLPD0601IFedStdParam> fedStdParams;

    public List<SLPD0601IFedStdParam> getFedStdParams() {
        return fedStdParams;
    }

    public void setFedStdParams(List<SLPD0601IFedStdParam> fedStdParams) {
        this.fedStdParams = fedStdParams;
    }
}
