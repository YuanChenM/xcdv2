package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0640ISftDifStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0640IParam",
        description = "新增安全标准指标差异集合入参")
public class SLPD0640IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "安全标准指标差异集合")
    List<SLPD0640ISftDifStdParam> sftDifStdParams;

    public List<SLPD0640ISftDifStdParam> getSftDifStdParams() {
        return sftDifStdParams;
    }

    public void setSftDifStdParams(List<SLPD0640ISftDifStdParam> sftDifStdParams) {
        this.sftDifStdParams = sftDifStdParams;
    }
}
