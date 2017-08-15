package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0303ISellerBrandParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wang_haichun on 2017/1/12.
 */
@ApiModel(value = "SLIM0303IParam",
        description = "修改卖家品牌接口入参")
public class SLIM0303IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    @ApiModelProperty(value = "实体卖家参数集合")
    private List<SLIM0303ISellerBrandParam> beans;


    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    public List<SLIM0303ISellerBrandParam> getBeans() {
        return beans;
    }

    public void setBeans(List<SLIM0303ISellerBrandParam> beans) {
        this.beans = beans;
    }
}
