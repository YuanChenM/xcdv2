package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0206AnimalEpidemicPreventionConditionCertificateParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0206IParam", description = "批量修改生产商生产资质-动物防疫条件合格证API的入参")
public class SLIM0206IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    @ApiModelProperty(value = "生产商生产资质-动物防疫条件合格证参数集合")
    private List<SLIM0206AnimalEpidemicPreventionConditionCertificateParam> animalEpidemicPreventionConditionCertificateParams;

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    public List<SLIM0206AnimalEpidemicPreventionConditionCertificateParam> getAnimalEpidemicPreventionConditionCertificateParams() {
        return animalEpidemicPreventionConditionCertificateParams;
    }

    public void setAnimalEpidemicPreventionConditionCertificateParams(List<SLIM0206AnimalEpidemicPreventionConditionCertificateParam> animalEpidemicPreventionConditionCertificateParams) {
        this.animalEpidemicPreventionConditionCertificateParams = animalEpidemicPreventionConditionCertificateParams;
    }
}
