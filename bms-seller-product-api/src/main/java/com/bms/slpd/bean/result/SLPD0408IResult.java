package com.bms.slpd.bean.result;


import com.framework.base.rest.result.BaseRestResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLPD0408IResult",
        description = "修改品牌与所有人关系接口出参")
public class SLPD0408IResult extends BaseRestResult {

    @ApiModelProperty(value = "修改Id列表")
    private List<Long> brandIds;
    @ApiModelProperty(value = "修改数量")
    private Integer count;
    @ApiModelProperty(value = "提示信息")
    private String[] message;

    public List<Long> getBrandIds() {
        return brandIds;
    }

    public void setBrandIds(List<Long> brandIds) {
        this.brandIds = brandIds;
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
