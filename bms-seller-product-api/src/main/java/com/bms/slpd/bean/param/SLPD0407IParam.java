package com.bms.slpd.bean.param;

import com.bms.slpd.bean.entity.SlpdBrandOwnerRelation;
import com.framework.base.rest.param.BaseRestParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0407IParam", description = "新增品牌与所有人关系信息入参")
public class SLPD0407IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "品牌与所有人关系信息IDList")
    List<SlpdBrandOwnerRelation> beans;

    public List<SlpdBrandOwnerRelation> getBeans() {
        return beans;
    }

    public void setBeans(List<SlpdBrandOwnerRelation> beans) {
        this.beans = beans;
    }
}
