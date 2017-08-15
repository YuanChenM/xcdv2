package com.bms.order.external.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by yuan_zhifei on 2017/5/4.
 */
@ApiModel(value = "买家配送地址的区域环标码查询返回参数", description = "买家配送地址的区域环标码查询返回参数")
public class BYIM0125IRestResult implements Serializable {
    @ApiModelProperty(value = "订单配送区域环标码")
    private String deliveryAreaCode;

    public String getDeliveryAreaCode() {
        return deliveryAreaCode;
    }

    public void setDeliveryAreaCode(String deliveryAreaCode) {
        this.deliveryAreaCode = deliveryAreaCode;
    }
}
