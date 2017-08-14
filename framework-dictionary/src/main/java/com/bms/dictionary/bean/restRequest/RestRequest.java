package com.bms.dictionary.bean.restRequest;

/**
 * Created by zhu_kai1 on 2016/12/8.
 */
public class RestRequest<T> extends com.framework.base.rest.RestRequest {
    private T filter;

    public T getFilter() {
        return filter;
    }

    public void setFilter(T filter) {
        this.filter = filter;
    }
}
