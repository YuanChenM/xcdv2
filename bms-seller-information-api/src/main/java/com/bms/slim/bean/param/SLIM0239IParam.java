package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0239ProducerTestEquipmentParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0239IParam", description = "批量修改生产商检测设备API的入参")
public class SLIM0239IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    @ApiModelProperty(value = "生产商检测设备参数集合")
    private List<SLIM0239ProducerTestEquipmentParam> producerTestEquipments;

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    public List<SLIM0239ProducerTestEquipmentParam> getProducerTestEquipments() {
        return producerTestEquipments;
    }

    public void setProducerTestEquipments(List<SLIM0239ProducerTestEquipmentParam> producerTestEquipments) {
        this.producerTestEquipments = producerTestEquipments;
    }
}
