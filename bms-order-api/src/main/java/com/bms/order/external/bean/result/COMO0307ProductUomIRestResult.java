package com.bms.order.external.bean.result;

import com.bms.order.common.rest.result.RestSearchData;

/**
 * 产品单位
 */
public class COMO0307ProductUomIRestResult extends RestSearchData {

    /**
     * 销售单位
     */
    private String uom;
    /**
     * 是否默认
     */
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

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }
}
