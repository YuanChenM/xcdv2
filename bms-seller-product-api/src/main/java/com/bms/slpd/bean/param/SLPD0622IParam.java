package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0622IPkgStdParam;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0619IParam",description = "新增包装标准指标接口入参")
public class SLPD0622IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    List<SLPD0622IPkgStdParam> pkgStdParams;

    public List<SLPD0622IPkgStdParam> getPkgStdParams() {
        return pkgStdParams;
    }

    public void setPkgStdParams(List<SLPD0622IPkgStdParam> pkgStdParams) {
        this.pkgStdParams = pkgStdParams;
    }
}
