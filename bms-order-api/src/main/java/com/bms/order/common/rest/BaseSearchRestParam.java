package com.bms.order.common.rest;

import com.bms.order.common.rest.param.RestFilter;
import com.bms.order.common.rest.param.RestOperator;

import java.io.Serializable;

/**
 * Created by liutao on 2017/2/7.
 */
public class BaseSearchRestParam <T extends RestFilter> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4306034480260592495L;

    /**
     * 操作者
     */
    private RestOperator operator;

    /**
     * 业务对象
     */
    private T filter;

    public RestOperator getOperator() {
        return operator;
    }

    public void setOperator(RestOperator operator) {
        this.operator = operator;
    }

    public T getFilter() {
        return filter;
    }

    public void setFilter(T filter) {
        this.filter = filter;
    }
}
