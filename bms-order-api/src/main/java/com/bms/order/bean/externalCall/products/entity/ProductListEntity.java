package com.bms.order.bean.externalCall.products.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhang_qiang1 on 2017/1/7.
 */
public class ProductListEntity  implements Serializable{

    private static final long serialVersionUID = 1L;
    private List<ProductEntity> productEntityList;

    public List<ProductEntity> getProductEntityList() {
        return productEntityList;
    }

    public void setProductEntityList(List<ProductEntity> productEntityList) {
        this.productEntityList = productEntityList;
    }

    @Override
    public String toString() {
        return "ProductListEntity{" +
                "productEntityList=" + productEntityList +
                '}';
    }
}
