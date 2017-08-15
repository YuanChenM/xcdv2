package com.bms.slpd.bean.param.wrapper;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "SLPD0502IParam", description = "新增品牌单品接口入参")
public class SlpdBrandItemParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "单品ID")
    private Long itemId;
    @ApiModelProperty(value = "品牌ID")
    private Long brandId;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

}
