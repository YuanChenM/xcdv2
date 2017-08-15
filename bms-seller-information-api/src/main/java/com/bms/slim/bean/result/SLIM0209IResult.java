package com.bms.slim.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0209IResult",description = "修改生产商生产资质-定点屠宰许可证接口出参")
public class SLIM0209IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "返回消息")
    private String[] message;
    @ApiModelProperty(value = "修改生产商生产资质-定点屠宰许可证数量")
    private Integer count;
    @ApiModelProperty(value = "修改生产商生产资质-定点屠宰许可证ID结果集")
    private List<Long> dspIds;

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

    public List<Long> getDspIds() {
        return dspIds;
    }

    public void setDspIds(List<Long> dspIds) {
        this.dspIds = dspIds;
    }
}
