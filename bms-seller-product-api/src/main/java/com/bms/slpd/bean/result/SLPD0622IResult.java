package com.bms.slpd.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0622IResult",description = "新增包装标准指标接口出参")
public class SLPD0622IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "插入数量")
    private int count;
    @ApiModelProperty(value = "包装标准指标ID列表")
    private List<Long> pkgStdIds;
    @ApiModelProperty(value = "返回消息")
    private String[] message;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Long> getPkgStdIds() {
        return pkgStdIds;
    }

    public void setPkgStdIds(List<Long> pkgStdIds) {
        this.pkgStdIds = pkgStdIds;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
