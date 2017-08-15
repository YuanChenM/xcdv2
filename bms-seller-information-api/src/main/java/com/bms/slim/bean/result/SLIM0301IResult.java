package com.bms.slim.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wang_haichun on 2017/1/12.
 */
@ApiModel(value = "SLIM0301IResult",
        description = "新增卖家品牌接口出参")
public class SLIM0301IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "新增品牌Id列表")
    private List<Long> sellerBrandIds;
    @ApiModelProperty(value = "新增品牌数量")
    private Integer count;
    @ApiModelProperty(value = "返回消息")
    private String[] message;

    public List<Long> getSellerBrandIds() {
        return sellerBrandIds;
    }

    public void setSellerBrandIds(List<Long> sellerBrandIds) {
        this.sellerBrandIds = sellerBrandIds;
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
