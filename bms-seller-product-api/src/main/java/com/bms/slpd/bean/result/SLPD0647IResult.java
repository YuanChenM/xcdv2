package com.bms.slpd.bean.result;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0647IResult",
        description = "修改包装标准指标差异接口出参")
public class SLPD0647IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "修改的Id列表")
    private List<Long> pkgDifStdIds;
    @ApiModelProperty(value = "修改数量")
    private Integer count;
    @ApiModelProperty(value = "返回消息")
    private String[] message;

    public List<Long> getPkgDifStdIds() {
        return pkgDifStdIds;
    }

    public void setPkgDifStdIds(List<Long> pkgDifStdIds) {
        this.pkgDifStdIds = pkgDifStdIds;
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
