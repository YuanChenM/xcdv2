package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0115ManufactureSupplyQualificationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0115IParam", description = "批量修改卖家制造商供应资质API的入参")
public class SLIM0115IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    @ApiModelProperty(value = "卖家制造商供应资质参数集合")
    private List<SLIM0115ManufactureSupplyQualificationParam> manufactureSupplyQualificationParams;

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    public List<SLIM0115ManufactureSupplyQualificationParam> getManufactureSupplyQualificationParams() {
        return manufactureSupplyQualificationParams;
    }

    public void setManufactureSupplyQualificationParams(List<SLIM0115ManufactureSupplyQualificationParam> manufactureSupplyQualificationParams) {
        this.manufactureSupplyQualificationParams = manufactureSupplyQualificationParams;
    }
}
