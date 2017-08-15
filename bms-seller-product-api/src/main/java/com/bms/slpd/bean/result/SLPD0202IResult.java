package com.bms.slpd.bean.result;

import com.framework.base.rest.result.BaseRestResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0202IResult", description = "新增品种接口出参")
public class SLPD0202IResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增数量")
    private String[] message;
    @ApiModelProperty(value = "新增数量")
    private Integer count;
    @ApiModelProperty(value = "功能一返回值:新增一级分类Id列表")
    private List<Long> classesIds;
    @ApiModelProperty(value = "功能二返回值:新增二级分类Id列表")
    private List<Long> machiningIds;
    @ApiModelProperty(value = "功能三,功能四返回值:新增品种Id列表")
    private List<Long> breedIds;

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Long> getClassesIds() {
        return classesIds;
    }

    public void setClassesIds(List<Long> classesIds) {
        this.classesIds = classesIds;
    }

    public List<Long> getMachiningIds() {
        return machiningIds;
    }

    public void setMachiningIds(List<Long> machiningIds) {
        this.machiningIds = machiningIds;
    }

    public List<Long> getBreedIds() {
        return breedIds;
    }

    public void setBreedIds(List<Long> breedIds) {
        this.breedIds = breedIds;
    }
}
