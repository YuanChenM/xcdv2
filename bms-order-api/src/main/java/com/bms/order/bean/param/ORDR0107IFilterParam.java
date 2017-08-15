package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestFilter;
import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * 商品销量查询接口
 * Created by ni_shaotang on 2017/3/29.
 */
@ApiModel(value = "ORDR0107IFilterParam", description = "商品销量查询接口")
public class ORDR0107IFilterParam extends RestFilter {
    private List<ORDR0107ICommodityParam> commodityList;

    public List<ORDR0107ICommodityParam> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(List<ORDR0107ICommodityParam> commodityList) {
        this.commodityList = commodityList;
    }
}
