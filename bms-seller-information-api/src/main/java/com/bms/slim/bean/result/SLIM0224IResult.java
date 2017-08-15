package com.bms.slim.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0224IResult",description = "修改生产商荣誉证书接口出参")
public class SLIM0224IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "返回消息")
    private String[] message;
    @ApiModelProperty(value = "修改生产商荣誉证书数量")
    private Integer count;
    @ApiModelProperty(value = "修改生产商荣誉证书ID结果集")
    private List<Long> honorCertIds;

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

    public List<Long> getHonorCertIds() {
        return honorCertIds;
    }

    public void setHonorCertIds(List<Long> honorCertIds) {
        this.honorCertIds = honorCertIds;
    }
}
