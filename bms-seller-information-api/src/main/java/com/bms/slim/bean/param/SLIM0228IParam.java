package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0228ProducerWorkShopParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0228IParam", description = "新增生产商车间接口入参")
public class SLIM0228IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "生产商车间集合")
    private List<SLIM0228ProducerWorkShopParam> producerWorkShops;

    public List<SLIM0228ProducerWorkShopParam> getProducerWorkShops() {
        return producerWorkShops;
    }

    public void setProducerWorkShops(List<SLIM0228ProducerWorkShopParam> producerWorkShops) {
        this.producerWorkShops = producerWorkShops;
    }
}
