package com.bms.slim.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0233IResult",description = "修改生产商库容接口出参")
public class SLIM0233IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "返回消息")
    private String[] message;
    @ApiModelProperty(value = "修改生产商库容数量")
    private Integer count;
    @ApiModelProperty(value = "修改生产商库容ID结果集")
    private List<Long> storageCapacityIds;

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Long> getStorageCapacityIds() {
        return storageCapacityIds;
    }

    public void setStorageCapacityIds(List<Long> storageCapacityIds) {
        this.storageCapacityIds = storageCapacityIds;
    }
}
