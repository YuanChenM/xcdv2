package com.bms.slim.bean.result;

import com.bms.slim.bean.entity.SlimSellerBusinessQualification;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0105IResult", description = "查询卖家经营资质API的返回对象")
public class SLIM0105IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "提示信息")
    private String[] messages;
    @ApiModelProperty(value = "查询结果")
    private SlimSellerBusinessQualification data;

    public String[] getMessages() {
        return messages;
    }

    public void setMessages(String[] messages) {
        this.messages = messages;
    }

    public SlimSellerBusinessQualification getData() {
        return data;
    }

    public void setData(SlimSellerBusinessQualification data) {
        this.data = data;
    }
}
