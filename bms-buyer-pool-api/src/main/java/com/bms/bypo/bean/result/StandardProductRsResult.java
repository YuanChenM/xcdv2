package com.bms.bypo.bean.result;

import com.bms.bypo.bean.entity.BypoStandardProduct;
import com.framework.base.rest.result.BaseRestResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by zhang_jian4 on 2017/01/04.
 */
@ApiModel(value = "StandardProductRsResult", description = "返回对象")
public class StandardProductRsResult extends BaseRestResult {
    @ApiModelProperty(value = "变更条数")
    private int result;
    @ApiModelProperty(value = "返回集合")
    private BypoStandardProduct productList;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public BypoStandardProduct getProductList() {
        return productList;
    }

    public void setProductList(BypoStandardProduct productList) {
        this.productList = productList;
    }
}
