package com.bms.slpd.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLPD0624IParam",description = "查询包装标准指标接口入参")
public class SLPD0624IParam extends BaseRestPaginationParam {

    @ApiModelProperty(value = "通过查询itemId查询全部差异卡标志,等于1时查询itemId下所有差异卡,其它查询标准卡")
    private int findAllFlag;
    @ApiModelProperty(value = "itemId集合")
    private List<Long> itemIds;
    @ApiModelProperty(value = "productId集合")
    private List<String> productIds;

    public int getFindAllFlag() {
        return findAllFlag;
    }

    public void setFindAllFlag(int findAllFlag) {
        this.findAllFlag = findAllFlag;
    }

    public List<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }
}
