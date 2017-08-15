package com.bms.slim.bean.result.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class SLIM0232ProducerStorageCapacityResult implements Serializable {
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
    @ApiModelProperty(value = "删除标识，true：已删除，false：未删除")
    private Boolean delFlg;
    @ApiModelProperty(value = "新建人ID")
    private String crtId;
    @ApiModelProperty(value = "新建时间")
    private Date crtTime;
    @ApiModelProperty(value = "修改人ID")
    private String updId;
    @ApiModelProperty(value = "修改时间")
    private Date updTime;
    @ApiModelProperty(value = "版本")
    private Integer version;

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

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
