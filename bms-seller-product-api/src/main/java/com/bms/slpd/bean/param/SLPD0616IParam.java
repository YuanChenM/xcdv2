package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0616ISftStdParam;
import com.framework.base.rest.param.BaseRestParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0616IParam",
        description = "新增安全标准指标接口入参")
public class SLPD0616IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "安全标准指标")
    List<SLPD0616ISftStdParam> sftStdParams;

    public List<SLPD0616ISftStdParam> getSftStdParams() {
        return sftStdParams;
    }

    public void setSftStdParams(List<SLPD0616ISftStdParam> sftStdParams) {
        this.sftStdParams = sftStdParams;
    }
}
