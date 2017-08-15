package com.bms.slpd.bean.result;

import com.framework.base.rest.result.BaseRestResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;


@ApiModel(value = "SLPD0407IResult",
        description = "新增品牌与所有人关系接口出参")
public class SLPD0407IResult implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增品牌所有人Id列表")
    private List<Long> boRelationIds;
    @ApiModelProperty(value = "新增品牌所有人数量")
    private Integer count;
    @ApiModelProperty(value = "提示信息")
    private String[] message;

    public List<Long> getBoRelationIds() {
        return boRelationIds;
    }

    public void setBoRelationIds(List<Long> boRelationIds) {
        this.boRelationIds = boRelationIds;
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
