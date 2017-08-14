package com.bms.como.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by wang_haichun on 2017/3/28.
 */
public class UomRsParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "销售单位")
    private String uom;
    @ApiModelProperty(value = "是否默认，有多个销售单位时，只能默认一个")
    private Boolean isDefault;

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean aDefault) {
        isDefault = aDefault;
    }


}
