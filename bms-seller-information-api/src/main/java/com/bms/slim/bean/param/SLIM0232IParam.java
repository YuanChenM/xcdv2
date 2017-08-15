package com.bms.slim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLIM0232IParam",
        description = "查询生产商库容接口入参")
public class SLIM0232IParam extends BaseRestPaginationParam {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "生产商库容Id集合")
    private List<Long> storageCapacityIds;
    @ApiModelProperty(value = "卖家角色ID集合")
    private List<Long> sellerRoleIds;
    @ApiModelProperty(value = "原料库容")
    private Integer materialCapacity;
    @ApiModelProperty(value = "成品库容")
    private Integer productCapacity;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public List<Long> getStorageCapacityIds() {
        return storageCapacityIds;
    }

    public void setStorageCapacityIds(List<Long> storageCapacityIds) {
        this.storageCapacityIds = storageCapacityIds;
    }

    public List<Long> getSellerRoleIds() {
        return sellerRoleIds;
    }

    public void setSellerRoleIds(List<Long> sellerRoleIds) {
        this.sellerRoleIds = sellerRoleIds;
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

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
