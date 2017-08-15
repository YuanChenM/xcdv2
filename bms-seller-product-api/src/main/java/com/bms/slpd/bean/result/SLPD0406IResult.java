package com.bms.slpd.bean.result;


import com.framework.base.rest.result.BaseRestResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLPD0406IResult",
        description = "修改品牌所有人接口出参")
public class SLPD0406IResult extends BaseRestResult {

    @ApiModelProperty(value = "修改品牌所有人Id列表")
    private List<Long> ids;
    @ApiModelProperty(value = "修改数量")
    private Integer count;
    @ApiModelProperty(value = "提示信息")
    private String[] message;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
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
