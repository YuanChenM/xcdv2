package com.bms.slim.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0101IResult", description = "批量新增卖家API的返回对象")
public class SLIM0101IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "提示信息")
    private String[] messages;
    @ApiModelProperty(value = "新增成功条数")
    private int count;
    @ApiModelProperty(value = "实体卖家ID集合")
    private List<Long> entitySellerIds;

    public String[] getMessages() {
        return messages;
    }

    public void setMessages(String[] messages) {
        this.messages = messages;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Long> getEntitySellerIds() {
        return entitySellerIds;
    }

    public void setEntitySellerIds(List<Long> entitySellerIds) {
        this.entitySellerIds = entitySellerIds;
    }
}
