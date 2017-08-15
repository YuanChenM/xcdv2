package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0212HalalFoodProductionOperationLicenseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0212IParam", description = "批量修改生产商生产资质-清真食品生产经营许可证API的入参")
public class SLIM0212IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    @ApiModelProperty(value = "生产商生产资质-清真食品生产经营许可证参数集合")
    private List<SLIM0212HalalFoodProductionOperationLicenseParam> halalFoodProductionOperationLicenseParams;

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    public List<SLIM0212HalalFoodProductionOperationLicenseParam> getHalalFoodProductionOperationLicenseParams() {
        return halalFoodProductionOperationLicenseParams;
    }

    public void setHalalFoodProductionOperationLicenseParams(List<SLIM0212HalalFoodProductionOperationLicenseParam> halalFoodProductionOperationLicenseParams) {
        this.halalFoodProductionOperationLicenseParams = halalFoodProductionOperationLicenseParams;
    }
}
