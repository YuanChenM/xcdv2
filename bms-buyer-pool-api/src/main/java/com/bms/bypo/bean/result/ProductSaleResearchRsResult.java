package com.bms.bypo.bean.result;

import com.bms.bypo.bean.entity.BypoProductSaleResearch;
import com.framework.base.rest.result.BaseRestResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by zhang_jian4 on 2016/12/21.
 */
@ApiModel(value = "ProductSaleResearchRsResult", description = "返回对象")
public class ProductSaleResearchRsResult extends BaseRestResult {
    @ApiModelProperty(value = "变更条数")
    private int result;
    @ApiModelProperty(value = "返回集合")
    private List<BypoProductSaleResearch> productSaleResearchList;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public List<BypoProductSaleResearch> getProductSaleResearchList() {
        return productSaleResearchList;
    }

    public void setProductSaleResearchList(List<BypoProductSaleResearch> productSaleResearchList) {
        this.productSaleResearchList = productSaleResearchList;
    }
}
