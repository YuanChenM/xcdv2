package com.bms.order.external.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;

/**
 * Created by ni_shaotang on 2017/3/15.
 */
public class AGIF0401IRestParam extends BaseRestPaginationParam {
    //买家ID
    private String buyerId;
    //是否包含历史信息
    private Boolean includeHistory;

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public Boolean getIncludeHistory() {
        return includeHistory;
    }

    public void setIncludeHistory(Boolean includeHistory) {
        this.includeHistory = includeHistory;
    }
}
