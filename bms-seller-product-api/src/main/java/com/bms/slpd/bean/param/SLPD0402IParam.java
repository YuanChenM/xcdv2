package com.bms.slpd.bean.param;


import com.bms.slpd.bean.param.field.SLPD0402IBrandParam;
import com.framework.base.rest.param.BaseRestParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel(value = "SLPD0402IParam", description = "修改品牌信息入参")
public class SLPD0402IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "品牌信息")
    private List<SLPD0402IBrandParam> beans;
    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    public List<SLPD0402IBrandParam> getBeans() {
        return beans;
    }

    public void setBeans(List<SLPD0402IBrandParam> beans) {
        this.beans = beans;
    }

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }
}
