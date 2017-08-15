package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0234ProducerLaboratoryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0234IParam", description = "新增生产商实验室接口入参")
public class SLIM0234IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "生产商实验室集合")
    private List<SLIM0234ProducerLaboratoryParam> producerLaboratories;

    public List<SLIM0234ProducerLaboratoryParam> getProducerLaboratories() {
        return producerLaboratories;
    }

    public void setProducerLaboratories(List<SLIM0234ProducerLaboratoryParam> producerLaboratories) {
        this.producerLaboratories = producerLaboratories;
    }
}
