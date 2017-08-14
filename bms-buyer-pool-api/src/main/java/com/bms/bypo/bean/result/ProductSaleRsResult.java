package com.bms.bypo.bean.result;

import com.bms.bypo.bean.entity.BypoProductSale;
import com.framework.base.rest.result.BaseRestResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by zhang_jian4 on 2017/01/06.
 */
@ApiModel(value = "ProductSaleRsResult", description = "返回对象")
public class ProductSaleRsResult extends BaseRestResult {
    @ApiModelProperty(value = "变更条数")
    private int result;
    @ApiModelProperty(value = "返回集合")
    private BypoProductSale productSaleList;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public BypoProductSale getProductSaleList() {
        return productSaleList;
    }

    public void setProductSaleList(BypoProductSale productSaleList) {
        this.productSaleList = productSaleList;
    }
}
