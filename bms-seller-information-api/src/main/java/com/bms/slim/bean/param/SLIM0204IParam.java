package com.bms.slim.bean.param;

import com.bms.slim.bean.entity.SlimAnimalEpidemicPreventionConditionCertificate;
import com.bms.slim.bean.entity.SlimSellerProducer;
import com.bms.slim.bean.param.field.SLIM0204AnimalEpidemicPreventionConditionCertificateParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0204IParam", description = "新增生产商生产资质-动物防疫条件合格证接口入参")
public class SLIM0204IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "生产商生产资质-动物防疫条件合格证集合")
    private List<SLIM0204AnimalEpidemicPreventionConditionCertificateParam> slim0204AnimalEpidemicPreventionConditionCertificateParams;

    public List<SLIM0204AnimalEpidemicPreventionConditionCertificateParam> getSlim0204AnimalEpidemicPreventionConditionCertificateParams() {
        return slim0204AnimalEpidemicPreventionConditionCertificateParams;
    }

    public void setSlim0204AnimalEpidemicPreventionConditionCertificateParams(List<SLIM0204AnimalEpidemicPreventionConditionCertificateParam> slim0204AnimalEpidemicPreventionConditionCertificateParams) {
        this.slim0204AnimalEpidemicPreventionConditionCertificateParams = slim0204AnimalEpidemicPreventionConditionCertificateParams;
    }
}
