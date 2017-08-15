package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0230ProducerWorkShopParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0230IParam", description = "批量修改生产商车间API的入参")
public class SLIM0230IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    @ApiModelProperty(value = "生产商车间参数集合")
    private List<SLIM0230ProducerWorkShopParam> producerWorkShops;

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    public List<SLIM0230ProducerWorkShopParam> getProducerWorkShops() {
        return producerWorkShops;
    }

    public void setProducerWorkShops(List<SLIM0230ProducerWorkShopParam> producerWorkShops) {
        this.producerWorkShops = producerWorkShops;
    }
}
