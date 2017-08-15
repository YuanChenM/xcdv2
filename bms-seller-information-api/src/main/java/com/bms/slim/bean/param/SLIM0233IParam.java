package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0233ProducerStorageCapacityParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0233IParam", description = "批量修改生产商库容API的入参")
public class SLIM0233IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    @ApiModelProperty(value = "生产商库容参数集合")
    private List<SLIM0233ProducerStorageCapacityParam> producerStorageCapacitys;

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    public List<SLIM0233ProducerStorageCapacityParam> getProducerStorageCapacitys() {
        return producerStorageCapacitys;
    }

    public void setProducerStorageCapacitys(List<SLIM0233ProducerStorageCapacityParam> producerStorageCapacitys) {
        this.producerStorageCapacitys = producerStorageCapacitys;
    }
}
