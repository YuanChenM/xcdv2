package com.bms.como.bean.param;

import com.bms.como.bean.entity.ComoProductInfo;

import java.io.Serializable;
import java.util.List;

public class ProductInfoCreateRsParam implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = 1L;

    private List<ComoProductInfo> productInfos;

    public List<ComoProductInfo> getProductInfos() {
        return productInfos;
    }

    public void setProductInfos(List<ComoProductInfo> productInfos) {
        this.productInfos = productInfos;
    }
}
