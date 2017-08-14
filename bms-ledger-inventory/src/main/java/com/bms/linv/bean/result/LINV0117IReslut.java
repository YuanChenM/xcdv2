package com.bms.linv.bean.result;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;

/**
 * Created by wang_fan on 2017/4/14.
 */
@ApiModel(value = "LINV0117IResult",
    description = "OMS指定产品参数")
public class LINV0117IReslut implements Serializable {

    private List<LINV0117IResultParam> productList;

    public List<LINV0117IResultParam> getProductList() {
        return productList;
    }

    public void setProductList(List<LINV0117IResultParam> productList) {
        this.productList = productList;
    }
}