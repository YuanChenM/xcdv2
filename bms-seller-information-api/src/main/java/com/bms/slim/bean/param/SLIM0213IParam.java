package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0213ShBjTjRegistrationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0213IParam", description = "新增生产商生产资质-进沪(京、津)登记信息接口入参")
public class SLIM0213IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "生产商生产资质-进沪(京、津)登记信息集合")
    private List<SLIM0213ShBjTjRegistrationParam> slim0213ShBjTjRegistrationParams;

    public List<SLIM0213ShBjTjRegistrationParam> getSlim0213ShBjTjRegistrationParams() {
        return slim0213ShBjTjRegistrationParams;
    }

    public void setSlim0213ShBjTjRegistrationParams(List<SLIM0213ShBjTjRegistrationParam> slim0213ShBjTjRegistrationParams) {
        this.slim0213ShBjTjRegistrationParams = slim0213ShBjTjRegistrationParams;
    }
}

