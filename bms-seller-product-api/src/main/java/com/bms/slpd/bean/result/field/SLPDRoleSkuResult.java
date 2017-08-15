package com.bms.slpd.bean.result.field;

import java.io.Serializable;

/**
 * <p>产品生产商、制造商、代理商最大SKU。</p>
 */
public class SLPDRoleSkuResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private String sku;
    private Long entitySellerId;


    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Long getEntitySellerId() {
        return entitySellerId;
    }

    public void setEntitySellerId(Long entitySellerId) {
        this.entitySellerId = entitySellerId;
    }
}
