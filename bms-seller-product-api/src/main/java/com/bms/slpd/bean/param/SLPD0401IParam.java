package com.bms.slpd.bean.param;

import com.bms.slpd.bean.entity.SlpdBrand;
import com.framework.base.rest.param.BaseRestParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0401IParam", description = "新增品牌信息入参")
public class SLPD0401IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "品牌信息列表")
    List<SlpdBrand> beans;

    public List<SlpdBrand> getBeans() {
        return beans;
    }

    public void setBeans(List<SlpdBrand> beans) {
        this.beans = beans;
    }
}
