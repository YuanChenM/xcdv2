package com.bms.bypo.bean.result;

import com.bms.bypo.bean.entity.BypoProductResearch;
import com.framework.base.rest.result.BaseRestResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by zhang_jian4 on 2017/01/06.
 */
@ApiModel(value = "ProductResearchRsResult", description = "返回对象")
public class ProductResearchRsResult extends BaseRestResult {
    @ApiModelProperty(value = "变更条数")
    private int result;
    @ApiModelProperty(value = "返回集合")
    private BypoProductResearch productList;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public BypoProductResearch getProductList() {
        return productList;
    }

    public void setProductList(BypoProductResearch productList) {
        this.productList = productList;
    }
}
