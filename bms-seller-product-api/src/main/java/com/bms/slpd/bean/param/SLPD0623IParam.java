package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0622IPkgStdParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0623IParam",description = "修改包装标准指标接口入参")
public class SLPD0623IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "包装标准指标信息")
    private List<SLPD0622IPkgStdParam> pkgStdParams;
    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;


    public List<SLPD0622IPkgStdParam> getPkgStdParams() {
        return pkgStdParams;
    }

    public void setPkgStdParams(List<SLPD0622IPkgStdParam> pkgStdParams) {
        this.pkgStdParams = pkgStdParams;
    }

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }
}
