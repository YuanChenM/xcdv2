package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0221IsoManagementSystemCertificationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0221IParam", description = "批量修改生产商生产资质-管理体系认证证书API的入参")
public class SLIM0221IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    @ApiModelProperty(value = "生产商生产资质-管理体系认证证书参数集合")
    private List<SLIM0221IsoManagementSystemCertificationParam> isoManagementSystemCertificationParams;

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    public List<SLIM0221IsoManagementSystemCertificationParam> getIsoManagementSystemCertificationParams() {
        return isoManagementSystemCertificationParams;
    }

    public void setIsoManagementSystemCertificationParams(List<SLIM0221IsoManagementSystemCertificationParam> isoManagementSystemCertificationParams) {
        this.isoManagementSystemCertificationParams = isoManagementSystemCertificationParams;
    }
}
