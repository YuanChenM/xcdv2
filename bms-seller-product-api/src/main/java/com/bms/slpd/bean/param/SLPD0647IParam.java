package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0646IPkgDifStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0647IParam",
        description = "修改包装标准指标差异入参")
public class SLPD0647IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "包装标准指标差异卡集合")
    List<SLPD0646IPkgDifStdParam> pkgDifStdParams;
    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    public List<SLPD0646IPkgDifStdParam> getPkgDifStdParams() {
        return pkgDifStdParams;
    }

    public void setPkgDifStdParams(List<SLPD0646IPkgDifStdParam> pkgDifStdParams) {
        this.pkgDifStdParams = pkgDifStdParams;
    }

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }
}
