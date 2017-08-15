package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0406IBrandOwnerParam;
import com.framework.base.rest.param.BaseRestParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel(value = "SLPD0406IParam", description = "修改品牌所有人信息入参")
public class SLPD0406IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "修改品牌所有人信息入参")
    private List<SLPD0406IBrandOwnerParam> brandOwnerParams;
    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;


    public List<SLPD0406IBrandOwnerParam> getBrandOwnerParams() {
        return brandOwnerParams;
    }

    public void setBrandOwnerParams(List<SLPD0406IBrandOwnerParam> brandOwnerParams) {
        this.brandOwnerParams = brandOwnerParams;
    }

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }
}
