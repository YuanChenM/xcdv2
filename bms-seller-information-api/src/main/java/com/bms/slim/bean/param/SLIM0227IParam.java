package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0227ProducerFactoryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0227IParam", description = "批量修改生产商工厂API的入参")
public class SLIM0227IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    @ApiModelProperty(value = "生产商工厂参数集合")
    private List<SLIM0227ProducerFactoryParam> producerFactoryParams;

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    public List<SLIM0227ProducerFactoryParam> getProducerFactoryParams() {
        return producerFactoryParams;
    }

    public void setProducerFactoryParams(List<SLIM0227ProducerFactoryParam> producerFactoryParams) {
        this.producerFactoryParams = producerFactoryParams;
    }
}
