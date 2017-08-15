package com.bms.slim.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0219IResult", description = "新增生产商生产资质-管理体系认证证书接口出参")
public class SLIM0219IResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "返回消息")
    private String[] message;
    @ApiModelProperty(value = "新增生产商生产资质-管理体系认证证书数量")
    private Integer count;
    @ApiModelProperty(value = "新增生产商生产资质-管理体系认证证书ID结果集")
    private List<Long> isoMscIds;

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

    public List<Long> getIsoMscIds() {
        return isoMscIds;
    }

    public void setIsoMscIds(List<Long> isoMscIds) {
        this.isoMscIds = isoMscIds;
    }
}
