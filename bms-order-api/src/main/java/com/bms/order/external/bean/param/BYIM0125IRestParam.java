package com.bms.order.external.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by yuan_zhifei on 2017/5/4.
 */
@ApiModel(value = "买家配送地址的区域环标码查询", description = "买家配送地址的区域环标码查询")
public class BYIM0125IRestParam implements Serializable {
    @ApiModelProperty(value = "买家ID")
    private String buyerId;
    @ApiModelProperty(value = "省名称")
    private String provinceName;
    @ApiModelProperty(value = "城市名称")
    private String cityName;
    @ApiModelProperty(value = "区（县）名称")
    private String districtName;
    @ApiModelProperty(value = "配送地址")
    private String deliveryAddr;

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDeliveryAddr() {
        return deliveryAddr;
    }

    public void setDeliveryAddr(String deliveryAddr) {
        this.deliveryAddr = deliveryAddr;
    }
}
