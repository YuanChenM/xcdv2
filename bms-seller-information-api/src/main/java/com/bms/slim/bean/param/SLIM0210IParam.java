package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0210HalalFoodProductionOperationLicenseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0210IParam", description = "新增生产商生产资质-清真食品生产经营许可证接口入参")
public class SLIM0210IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "生产商生产资质-清真食品生产经营许可证集合")
    private List<SLIM0210HalalFoodProductionOperationLicenseParam> slim0210HalalFoodProductionOperationLicenseParams;

    public List<SLIM0210HalalFoodProductionOperationLicenseParam> getSlim0210HalalFoodProductionOperationLicenseParams() {
        return slim0210HalalFoodProductionOperationLicenseParams;
    }

    public void setSlim0210HalalFoodProductionOperationLicenseParams(List<SLIM0210HalalFoodProductionOperationLicenseParam> slim0210HalalFoodProductionOperationLicenseParams) {
        this.slim0210HalalFoodProductionOperationLicenseParams = slim0210HalalFoodProductionOperationLicenseParams;
    }
}

