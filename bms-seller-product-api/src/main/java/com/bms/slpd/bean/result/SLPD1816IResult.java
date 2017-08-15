package com.bms.slpd.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD1816IResult",
        description = "新增产品接口出参")
public class SLPD1816IResult implements Serializable {

    @ApiModelProperty(value = "返回消息")
    private String[] message;
    @ApiModelProperty(value = "插入数量")
    private int count;
    @ApiModelProperty(value = "产品ID列表")
    private List<String> productIds;

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }
}
