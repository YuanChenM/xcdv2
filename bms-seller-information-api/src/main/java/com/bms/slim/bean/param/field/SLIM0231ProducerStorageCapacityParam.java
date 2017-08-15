package com.bms.slim.bean.param.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class SLIM0231ProducerStorageCapacityParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "卖家角色ID")
    private Long sellerRoleId;
    @ApiModelProperty(value = "原料库容")
    private Integer materialCapacity;
    @ApiModelProperty(value = "成品库容")
    private Integer productCapacity;
    @ApiModelProperty(value = "仓库照URL")
    private String warehousePicUrl;

    public Long getSellerRoleId() {
        return sellerRoleId;
    }

    public void setSellerRoleId(Long sellerRoleId) {
        this.sellerRoleId = sellerRoleId;
    }

    public Integer getMaterialCapacity() {
        return materialCapacity;
    }

    public void setMaterialCapacity(Integer materialCapacity) {
        this.materialCapacity = materialCapacity;
    }

    public Integer getProductCapacity() {
        return productCapacity;
    }

    public void setProductCapacity(Integer productCapacity) {
        this.productCapacity = productCapacity;
    }

    public String getWarehousePicUrl() {
        return warehousePicUrl;
    }

    public void setWarehousePicUrl(String warehousePicUrl) {
        this.warehousePicUrl = warehousePicUrl;
    }
}
