package com.bms.slpd.bean.result;

import com.bms.slpd.bean.entity.SlpdClasses;
import com.framework.base.rest.result.BaseRestResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0101IResult", description = "查询一级分类接口出参")
public class SLPD0101IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "返回消息")
    private String [] message;
    @ApiModelProperty(value = "查询产品一级分类返回结果")
    private List<SlpdClasses> classesList;

    public List<SlpdClasses> getClassesList() {
        return classesList;
    }

    public void setClassesList(List<SlpdClasses> classesList) {
        this.classesList = classesList;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
