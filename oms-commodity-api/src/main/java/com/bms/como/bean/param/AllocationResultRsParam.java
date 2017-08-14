package com.bms.como.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yuan_zhifei on 2017/4/12.
 */
@ApiModel(value = "AllocationResultRsParam", description = "库存划拨结果入参")
public class AllocationResultRsParam implements Serializable {
    @ApiModelProperty(value = "产品标签设置结果，成功或者失败")
    private String setLabelResult;
    @ApiModelProperty(value = "设置失败原因描述")
    private String failReason;
    @ApiModelProperty(value = "设置销售标签单据编号")
    private String orderId;
    @ApiModelProperty(value = "产品集合")
    private List<ProductParam> productList;

    public String getSetLabelResult() {
        return setLabelResult;
    }

    public void setSetLabelResult(String setLabelResult) {
        this.setLabelResult = setLabelResult;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<ProductParam> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductParam> productList) {
        this.productList = productList;
    }
}
