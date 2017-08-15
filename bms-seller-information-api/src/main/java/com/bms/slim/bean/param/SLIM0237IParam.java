package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0237ProducerTestEquipmentParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0237IParam", description = "新增生产商检测设备接口入参")
public class SLIM0237IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "生产商检测设备集合")
    private List<SLIM0237ProducerTestEquipmentParam> producerTestEquipments;

    public List<SLIM0237ProducerTestEquipmentParam> getProducerTestEquipments() {
        return producerTestEquipments;
    }

    public void setProducerTestEquipments(List<SLIM0237ProducerTestEquipmentParam> producerTestEquipments) {
        this.producerTestEquipments = producerTestEquipments;
    }
}
