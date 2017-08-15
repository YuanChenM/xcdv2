package com.bms.slim.bean.param.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class SLIM0233ProducerStorageCapacityParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "库容ID")
    private Long storageCapacityId;
    @ApiModelProperty(value = "卖家角色ID")
    private Long sellerRoleId;
    @ApiModelProperty(value = "原料库容")
    private Integer materialCapacity;
    @ApiModelProperty(value = "成品库容")
    private Integer productCapacity;
    @ApiModelProperty(value = "仓库照URL")
    private String warehousePicUrl;
    @ApiModelProperty(value = "版本")
    private Integer version;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public Long getStorageCapacityId() {
        return storageCapacityId;
    }

    public void setStorageCapacityId(Long storageCapacityId) {
        this.storageCapacityId = storageCapacityId;
    }

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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
