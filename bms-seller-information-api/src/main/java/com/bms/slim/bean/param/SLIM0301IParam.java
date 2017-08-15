package com.bms.slim.bean.param;

import com.bms.slim.bean.param.wrapper.SlimSellerBrandParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wang_haichun on 2017/1/12.
 */
@ApiModel(value = "SLIM0301IParam",
        description = "新增卖家品牌接口入参")
public class SLIM0301IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "批量新增集合")
    private List<SlimSellerBrandParam> sellerBreedList;

    public List<SlimSellerBrandParam> getSellerBreedList() {
        return sellerBreedList;
    }

    public void setSellerBreedList(List<SlimSellerBrandParam> sellerBreedList) {
        this.sellerBreedList = sellerBreedList;
    }
}
