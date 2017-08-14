package com.bms.byim.bean;


import com.framework.base.rest.RestRequest;

import java.util.List;

/**
 * @author zhou_yajun
 * @version 1.0
 * @param <T>
 */
public class BaseRequest<T> extends RestRequest {
    /**
     * 业务参数对象
     */
    private T bean;

    private List<T> beans;

    public T getBean() {
        return bean;
    }

    public void setBean(T bean) {
        this.bean = bean;
    }

    public List<T> getBeans() {
        return beans;
    }

    public void setBeans(List<T> beans) {
        this.beans = beans;
    }
}
