package com.bms.order.common.rest;

import com.bms.order.common.rest.result.RestSearchData;

import java.io.Serializable;

/**
 * Created by liutao on 2017/1/16.
 */
public class MeiDefoeRestResult<T> implements Serializable {
    private static final long serialVersionUID = 4306034480260592495L;

    private T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
