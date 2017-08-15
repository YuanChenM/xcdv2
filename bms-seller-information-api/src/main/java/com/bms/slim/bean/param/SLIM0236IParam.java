package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0236ProducerLaboratoryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0236IParam", description = "批量修改生产商实验室API的入参")
public class SLIM0236IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    @ApiModelProperty(value = "生产商实验室参数集合")
    private List<SLIM0236ProducerLaboratoryParam> producerLaboratories;

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    public List<SLIM0236ProducerLaboratoryParam> getProducerLaboratories() {
        return producerLaboratories;
    }

    public void setProducerLaboratories(List<SLIM0236ProducerLaboratoryParam> producerLaboratories) {
        this.producerLaboratories = producerLaboratories;
    }
}
