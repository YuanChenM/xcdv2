package com.bms.slpd.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0601IResult",
        description = "新增原种种源标准指标接口出参")
public class SLPD0601IResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "插入数量")
    private int count;
    @ApiModelProperty(value = "原种种源标准指标Id列表")
    private List<Long> orgStdIds;
    @ApiModelProperty(value = "返回消息")
    private String[] message;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Long> getOrgStdIds() {
        return orgStdIds;
    }

    public void setOrgStdIds(List<Long> orgStdIds) {
        this.orgStdIds = orgStdIds;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
