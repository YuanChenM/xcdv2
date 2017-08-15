package com.bms.slpd.bean.result;


import com.framework.base.rest.result.BaseRestResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0404IResult",
        description = "新增品牌所有人接口出参")
public class SLPD0404IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "新增品牌所有人Id列表")
    private List<Long> brandOwnerIds;
    @ApiModelProperty(value = "新增品牌所有人数量")
    private Integer count;
    @ApiModelProperty(value = "提示信息")
    private String[] message;

    public List<Long> getBrandOwnerIds() {
        return brandOwnerIds;
    }

    public void setBrandOwnerIds(List<Long> brandOwnerIds) {
        this.brandOwnerIds = brandOwnerIds;
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
