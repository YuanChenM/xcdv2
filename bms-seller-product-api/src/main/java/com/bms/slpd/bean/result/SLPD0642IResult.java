package com.bms.slpd.bean.result;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0642IResult",
        description = "修改安全指标差异接口出参")
public class SLPD0642IResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "修改的Id列表")
    private List<Long> sftDifStdIds;
    @ApiModelProperty(value = "修改数量")
    private Integer count;
    @ApiModelProperty(value = "返回消息")
    private String[] message;

    public List<Long> getSftDifStdIds() {
        return sftDifStdIds;
    }

    public void setSftDifStdIds(List<Long> sftDifStdIds) {
        this.sftDifStdIds = sftDifStdIds;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
