package com.bms.order.common.rest;

import com.bms.order.common.rest.param.RestBean;
import com.bms.order.common.rest.param.RestOperator;

import java.io.Serializable;

/**
 * Created by liutao on 2017/1/16.
 */
public class MeiDefoeRestParam<T extends RestBean> extends RestBean {
    /**
     * 操作者
     */
    private RestOperator operator;

    /**
     * 业务对象
     */
    private T beans;

    public RestOperator getOperator() {
        return operator;
    }

    public void setOperator(RestOperator operator) {
        this.operator = operator;
    }

    public T getBeans() {
        return beans;
    }

    public void setBeans(T beans) {
        this.beans = beans;
    }
}
