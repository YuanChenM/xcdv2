package com.bms.order.external.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang_jian4 on 2017/4/17.
 */
public class LINV0114IParam extends BaseRestPaginationParam {
    private List<Long> logisticsId;
    private List<Long> whId;
    private List<String> whCode = new ArrayList<>();

    public List<Long> getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(List<Long> logisticsId) {
        this.logisticsId = logisticsId;
    }

    public List<Long> getWhId() {
        return whId;
    }

    public void setWhId(List<Long> whId) {
        this.whId = whId;
    }

    public List<String> getWhCode() {
        return whCode;
    }

    public void setWhCode(List<String> whCode) {
        this.whCode = whCode;
    }
}