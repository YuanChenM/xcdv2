package com.bms.slpd.bean.param;


import com.bms.slpd.bean.param.field.SLPD0408IBrandOwnerRelationParam;
import com.framework.base.rest.param.BaseRestParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel(value = "SLPD0408IParam", description = "修改品牌与所有人关系信息入参")
public class SLPD0408IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "实体品牌与所有人参数集合")
    private List<SLPD0408IBrandOwnerRelationParam> brandOwnerRelationParams;
    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    public List<SLPD0408IBrandOwnerRelationParam> getBrandOwnerRelationParams() {
        return brandOwnerRelationParams;
    }

    public void setBrandOwnerRelationParams(List<SLPD0408IBrandOwnerRelationParam> brandOwnerRelationParams) {
        this.brandOwnerRelationParams = brandOwnerRelationParams;
    }

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }
}
