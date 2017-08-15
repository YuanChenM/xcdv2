package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0215ShBjTjRegistrationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0215IParam", description = "批量修改生产商生产资质-进沪(京、津)登记信息API的入参")
public class SLIM0215IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    @ApiModelProperty(value = "生产商生产资质-进沪(京、津)登记信息参数集合")
    private List<SLIM0215ShBjTjRegistrationParam> shBjTjRegistrationParams;

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    public List<SLIM0215ShBjTjRegistrationParam> getShBjTjRegistrationParams() {
        return shBjTjRegistrationParams;
    }

    public void setShBjTjRegistrationParams(List<SLIM0215ShBjTjRegistrationParam> shBjTjRegistrationParams) {
        this.shBjTjRegistrationParams = shBjTjRegistrationParams;
    }
}
