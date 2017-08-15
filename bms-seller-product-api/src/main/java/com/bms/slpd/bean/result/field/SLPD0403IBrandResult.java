package com.bms.slpd.bean.result.field;


import com.bms.slpd.bean.entity.SlpdBrandOwner;
import com.framework.base.rest.result.BaseRestResult;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by ding_guangjian on 2016/12/12.
 */
public class SLPD0403IBrandResult extends BaseRestResult {
    @ApiModelProperty(value = "品牌ID")
    private Long brandId;
    @ApiModelProperty(value = "品牌所有人信息列表")
    List<SlpdBrandOwner> slpdBrandOwnerList;
    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public List<SlpdBrandOwner> getSlpdBrandOwnerList() {
        return slpdBrandOwnerList;
    }

    public void setSlpdBrandOwnerList(List<SlpdBrandOwner> slpdBrandOwnerList) {
        this.slpdBrandOwnerList = slpdBrandOwnerList;
    }
}
