package com.bms.order.fms.bean;

import java.io.Serializable;

/**
 * Created by yuan_chen on 2017/5/9
 *
 * oms内部子系统-卖家制造商查询用参数
 */
public class OmsManufacturerSkuParam implements Serializable {
    private static final long serialVersionUID = 1628959296439692826L;
    //制造商sku
    private String manufacturerProductSku;

    public String getManufacturerProductSku() {
        return manufacturerProductSku;
    }

    public void setManufacturerProductSku(String manufacturerProductSku) {
        this.manufacturerProductSku = manufacturerProductSku;
    }
}

