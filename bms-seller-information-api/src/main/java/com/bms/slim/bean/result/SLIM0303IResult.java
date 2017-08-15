package com.bms.slim.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wang_haichun on 2017/1/12.
 */
@ApiModel(value = "SLIM0303IResult",
        description = "修改卖家品牌接口出参")
public class SLIM0303IResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "修改Id列表")
    private List<Long> sellerBrandIds;
    @ApiModelProperty(value = "修改数量")
    private Integer count;
    @ApiModelProperty(value = "提示信息")
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
