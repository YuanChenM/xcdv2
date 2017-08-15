package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0207DesignatSlaughterPermitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0207IParam", description = "新增生产商生产资质-定点屠宰许可证接口入参")
public class SLIM0207IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "生产商生产资质-定点屠宰许可证集合")
    private List<SLIM0207DesignatSlaughterPermitParam> slim0207DesignatSlaughterPermitParams;

    public List<SLIM0207DesignatSlaughterPermitParam> getSlim0207DesignatSlaughterPermitParams() {
        return slim0207DesignatSlaughterPermitParams;
    }

    public void setSlim0207DesignatSlaughterPermitParams(List<SLIM0207DesignatSlaughterPermitParam> slim0207DesignatSlaughterPermitParams) {
        this.slim0207DesignatSlaughterPermitParams = slim0207DesignatSlaughterPermitParams;
    }
}
