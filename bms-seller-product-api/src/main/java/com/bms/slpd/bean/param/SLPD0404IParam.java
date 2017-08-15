package com.bms.slpd.bean.param;

import com.bms.slpd.bean.entity.SlpdBrandOwner;
import com.framework.base.rest.param.BaseRestParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0404IParam", description = "新增品牌所有人信息入参")
public class SLPD0404IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "品牌所有人信息IDList")
    List<SlpdBrandOwner> beans;

    public List<SlpdBrandOwner> getBeans() {
        return beans;
    }

    public void setBeans(List<SlpdBrandOwner> beans) {
        this.beans = beans;
    }
}
