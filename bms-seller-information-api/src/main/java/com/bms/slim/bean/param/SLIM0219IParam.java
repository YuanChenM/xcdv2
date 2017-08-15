package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0219IsoManagementSystemCertificationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0219IParam", description = "新增生产商生产资质-管理体系认证证书接口入参")
public class SLIM0219IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "生产商生产资质-管理体系认证证书集合")
    private List<SLIM0219IsoManagementSystemCertificationParam> slim0219IsoManagementSystemCertificationParams;

    public List<SLIM0219IsoManagementSystemCertificationParam> getSlim0219IsoManagementSystemCertificationParams() {
        return slim0219IsoManagementSystemCertificationParams;
    }

    public void setSlim0219IsoManagementSystemCertificationParams(List<SLIM0219IsoManagementSystemCertificationParam> slim0219IsoManagementSystemCertificationParams) {
        this.slim0219IsoManagementSystemCertificationParams = slim0219IsoManagementSystemCertificationParams;
    }
}

