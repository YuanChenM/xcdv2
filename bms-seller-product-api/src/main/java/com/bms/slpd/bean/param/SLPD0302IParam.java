package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.wrapper.SLPD0302IItemParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel(value = "SLPD0302IParam", description = "新增单品接口入参")
public class SLPD0302IParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "单品集合")
    private List<SLPD0302IItemParam> itemParams;

    public List<SLPD0302IItemParam> getItemParams() {
        return itemParams;
    }

    public void setItemParams(List<SLPD0302IItemParam> itemParams) {
        this.itemParams = itemParams;
    }
}
