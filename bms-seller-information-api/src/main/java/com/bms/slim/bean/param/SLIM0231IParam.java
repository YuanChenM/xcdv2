package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0231ProducerStorageCapacityParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0231IParam", description = "新增生产商库容接口入参")
public class SLIM0231IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "生产商库容集合")
    private List<SLIM0231ProducerStorageCapacityParam> producerStorageCapacitys;

    public List<SLIM0231ProducerStorageCapacityParam> getProducerStorageCapacitys() {
        return producerStorageCapacitys;
    }

    public void setProducerStorageCapacitys(List<SLIM0231ProducerStorageCapacityParam> producerStorageCapacitys) {
        this.producerStorageCapacitys = producerStorageCapacitys;
    }
}
