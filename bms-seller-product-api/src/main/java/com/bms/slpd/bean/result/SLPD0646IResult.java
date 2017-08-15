package com.bms.slpd.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0646IResult",
        description = "新增包装标准指标差异接口出参")
public class SLPD0646IResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "插入数量")
    private int count;
    @ApiModelProperty(value = "包装标准指标差异ID列表")
    private List<Long> pkgDifStdIds;
    @ApiModelProperty(value = "返回消息")
    private String[] message;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Long> getPkgDifStdIds() {
        return pkgDifStdIds;
    }

    public void setPkgDifStdIds(List<Long> pkgDifStdIds) {
        this.pkgDifStdIds = pkgDifStdIds;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
