package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0225ProducerFactoryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0225IParam", description = "新增生产商工厂表接口入参")
public class SLIM0225IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "生产商工厂表集合")
    private List<SLIM0225ProducerFactoryParam> producerFactoryParams;

    public List<SLIM0225ProducerFactoryParam> getProducerFactoryParams() {
        return producerFactoryParams;
    }

    public void setProducerFactoryParams(List<SLIM0225ProducerFactoryParam> producerFactoryParams) {
        this.producerFactoryParams = producerFactoryParams;
    }
}
