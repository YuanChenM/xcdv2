package com.bms.slim.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0241IParam", description = "新增平台生产商接口入参")
public class SLIM0241IParam implements Serializable {
    private static final long serialVersionUID = 1L;
   
    @ApiModelProperty(value = "平台生产商集合")
    private List<SLIM024101IParam> producers;

    public List<SLIM024101IParam> getProducers() {
        return producers;
    }

    public void setProducers(List<SLIM024101IParam> producers) {
        this.producers = producers;
    }
}
