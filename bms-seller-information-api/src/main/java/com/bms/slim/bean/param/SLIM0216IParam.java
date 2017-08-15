package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0216FoodProductionLicenseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0216IParam", description = "新增生产商生产资质-食品生产许可证接口入参")
public class SLIM0216IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "生产商生产资质-食品生产许可证集合")
    private List<SLIM0216FoodProductionLicenseParam> slim0216FoodProductionLicenseParams;

    public List<SLIM0216FoodProductionLicenseParam> getSlim0216FoodProductionLicenseParams() {
        return slim0216FoodProductionLicenseParams;
    }

    public void setSlim0216FoodProductionLicenseParams(List<SLIM0216FoodProductionLicenseParam> slim0216FoodProductionLicenseParams) {
        this.slim0216FoodProductionLicenseParams = slim0216FoodProductionLicenseParams;
    }
}

