package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0113ManufacturerSupplyQualificationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0113IParam", description = "新增卖家制造商供应资质接口入参")
public class SLIM0113IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "卖家制造商供应资质集合")
    private List<SLIM0113ManufacturerSupplyQualificationParam> slim0113ManufacturerSupplyQualificationParams;

    public List<SLIM0113ManufacturerSupplyQualificationParam> getSlim0113ManufacturerSupplyQualificationParams() {
        return slim0113ManufacturerSupplyQualificationParams;
    }

    public void setSlim0113ManufacturerSupplyQualificationParams(List<SLIM0113ManufacturerSupplyQualificationParam> slim0113ManufacturerSupplyQualificationParams) {
        this.slim0113ManufacturerSupplyQualificationParams = slim0113ManufacturerSupplyQualificationParams;
    }
}
