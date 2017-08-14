package com.bms.byim.bean.result;

import com.bms.byim.bean.entity.ByimMarketingStatus;
import com.bms.byim.bean.param.MarketingStatusRsParam;
import com.framework.base.rest.result.BaseRestResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by yuan_zhifei on 2016/12/8.
 */
@ApiModel(value = "MarketingStatusRsResult", description = "返回集合")
public class MarketingStatusRsResult extends BaseRestResult {
    @ApiModelProperty(value = "更新条数")
    private int result;
    @ApiModelProperty(value = "买家上线状态集合")
    private List<MarketingStatusRsParam> marketingStatusList;
    @ApiModelProperty(value = "买家上线状态entity集合")
    private List<ByimMarketingStatus> buyerMarketStatusList;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public List<MarketingStatusRsParam> getMarketingStatusList() {
        return marketingStatusList;
    }

    public void setMarketingStatusList(List<MarketingStatusRsParam> marketingStatusList) {
        this.marketingStatusList = marketingStatusList;
    }

    public List<ByimMarketingStatus> getBuyerMarketStatusList() {
        return buyerMarketStatusList;
    }

    public void setBuyerMarketStatusList(List<ByimMarketingStatus> buyerMarketStatusList) {
        this.buyerMarketStatusList = buyerMarketStatusList;
    }
}
