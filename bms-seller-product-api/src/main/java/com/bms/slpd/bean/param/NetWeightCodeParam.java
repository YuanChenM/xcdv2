package com.bms.slpd.bean.param;

import java.io.Serializable;
import java.math.BigDecimal;

public class NetWeightCodeParam implements Serializable {
    private static final Long serialVersionUId = 1L;

    private Long itemId;
    private BigDecimal netWeight;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }
}
