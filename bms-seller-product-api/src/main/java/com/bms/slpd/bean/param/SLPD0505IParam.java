package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.field.SLPD0505IItemPropertyParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0505IParam",
        description = "修改单品规格集合入参")
public class SLPD0505IParam implements Serializable {

    @ApiModelProperty(value = "对象列表")
    private List<SLPD0505IItemPropertyParam> itemProperties;
    @ApiModelProperty(value = "目标字段")
    private String[] targets;

    public List<SLPD0505IItemPropertyParam> getItemProperties() {
        return itemProperties;
    }

    public void setItemProperties(List<SLPD0505IItemPropertyParam> itemProperties) {
        this.itemProperties = itemProperties;
    }

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }
}
