package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0646IPkgDifStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0646IParam",
        description = "新增包装标准指标差异接口入参")
public class SLPD0646IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "包装标准指标差异集合")
    List<SLPD0646IPkgDifStdParam> pkgDifStdParams;

    public List<SLPD0646IPkgDifStdParam> getPkgDifStdParams() {
        return pkgDifStdParams;
    }

    public void setPkgDifStdParams(List<SLPD0646IPkgDifStdParam> pkgDifStdParams) {
        this.pkgDifStdParams = pkgDifStdParams;
    }
}
