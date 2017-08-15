package com.bms.slpd.bean.param;

import com.bms.slpd.bean.param.wrapper.SlpdBrandItemParam;
import com.framework.base.rest.param.BaseRestParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel(value = "SLPD0502IParam", description = "新增品牌单品接口入参")
public class SLPD0502IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "单品品牌集合")
    private List<SlpdBrandItemParam> itemBrandList;

    public List<SlpdBrandItemParam> getItemBrandList() {
        return itemBrandList;
    }

    public void setItemBrandList(List<SlpdBrandItemParam> itemBrandList) {
        this.itemBrandList = itemBrandList;
    }
}
