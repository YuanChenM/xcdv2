package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0504IItemPropertyParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0504IParam", description = "新增单品规格集合入参")
public class SLPD0504IParam implements Serializable {

    @ApiModelProperty(value = "单品规格集合")
    private List<SLPD0504IItemPropertyParam> itemProperties;

    public List<SLPD0504IItemPropertyParam> getItemProperties() {
        return itemProperties;
    }

    public void setItemProperties(List<SLPD0504IItemPropertyParam> itemProperties) {
        this.itemProperties = itemProperties;
    }
}
