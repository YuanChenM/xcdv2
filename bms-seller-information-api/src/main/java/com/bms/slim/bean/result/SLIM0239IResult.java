package com.bms.slim.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0239IResult",description = "修改生产商检测设备接口出参")
public class SLIM0239IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "返回消息")
    private String[] message;
    @ApiModelProperty(value = "修改生产商检测设备数量")
    private Integer count;
    @ApiModelProperty(value = "修改生产商检测设备ID结果集")
    private List<Long> testEqpIds;

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

    public List<Long> getTestEqpIds() {
        return testEqpIds;
    }

    public void setTestEqpIds(List<Long> testEqpIds) {
        this.testEqpIds = testEqpIds;
    }
}
