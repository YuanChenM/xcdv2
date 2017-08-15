package com.bms.slpd.bean.result;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0625IResult",description = "新增原种种源标准指标差异接口出参")
public class SLPD0625IResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增数量")
    private Integer count;
    @ApiModelProperty(value = "新增原种种源标准指标差异Id列表")
    private List<Long> orgDifStdIds;
    @ApiModelProperty(value = "返回消息")
    private String[] message;


    public List<Long> getOrgDifStdIds() {
        return orgDifStdIds;
    }

    public void setOrgDifStdIds(List<Long> orgDifStdIds) {
        this.orgDifStdIds = orgDifStdIds;
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
