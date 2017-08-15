package com.bms.slpd.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD1808IResult", description = "删除制造商产品生产商接口出参")
public class SLPD1808IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "返回消息")
    private String[] message;
    @ApiModelProperty(value = "删除制造商产品生产商数量")
    private int count;
    @ApiModelProperty(value = "删除制造商产品生产商Id列表")
    private List<Long> manufacturerProductIds;

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

    public List<Long> getManufacturerProductIds() {
        return manufacturerProductIds;
    }

    public void setManufacturerProductIds(List<Long> manufacturerProductIds) {
        this.manufacturerProductIds = manufacturerProductIds;
    }
}
