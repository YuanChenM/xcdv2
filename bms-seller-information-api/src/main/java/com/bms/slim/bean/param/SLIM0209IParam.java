package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0209DesignatSlaughterPermitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0209IParam", description = "批量修改生产商生产资质-定点屠宰许可证API的入参")
public class SLIM0209IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    @ApiModelProperty(value = "生产商生产资质-定点屠宰许可证参数集合")
    private List<SLIM0209DesignatSlaughterPermitParam> designatSlaughterPermitParams;

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    public List<SLIM0209DesignatSlaughterPermitParam> getDesignatSlaughterPermitParams() {
        return designatSlaughterPermitParams;
    }

    public void setDesignatSlaughterPermitParams(List<SLIM0209DesignatSlaughterPermitParam> designatSlaughterPermitParams) {
        this.designatSlaughterPermitParams = designatSlaughterPermitParams;
    }
}
