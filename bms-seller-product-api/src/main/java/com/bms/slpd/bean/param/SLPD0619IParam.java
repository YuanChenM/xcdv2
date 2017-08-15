package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0619ITspStdParam;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0619IParam",description = "新增储存运输标准指标接口入参")
public class SLPD0619IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    List<SLPD0619ITspStdParam> tspStdParams;

    public List<SLPD0619ITspStdParam> getTspStdParams() {
        return tspStdParams;
    }

    public void setTspStdParams(List<SLPD0619ITspStdParam> tspStdParams) {
        this.tspStdParams = tspStdParams;
    }
}
