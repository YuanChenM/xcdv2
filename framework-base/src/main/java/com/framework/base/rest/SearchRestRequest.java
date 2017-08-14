package com.framework.base.rest;


import com.framework.base.rest.param.BaseRestPaginationParam;
import com.framework.base.rest.param.BaseRestPagingParam;
import com.framework.base.rest.param.BaseRestSortParam;

import java.io.Serializable;

/**
 * Created by mao_yejun on 2016/12/6.
 */
@Deprecated
public class SearchRestRequest<T extends Serializable> extends RestRequest {

    /**
     * 分页参数
     */
    private BaseRestPagingParam pagination;

    /**
     * 业务参数
     */
    private T filter;
    /**
     * 排序设置
     */
    private BaseRestSortParam[] sort;
    /**
     * 指定显示的返回值
     */
    private String[] showField;

    public BaseRestPagingParam getPagination() {
        return pagination;
    }

    public void setPagination(BaseRestPagingParam pagination) {
        this.pagination = pagination;
    }

    public String[] getShowField() {
        return showField;
    }

    public void setShowField(String[] showField) {
        this.showField = showField;
    }

    public BaseRestSortParam[] getSort() {
        return sort;
    }

    public void setSort(BaseRestSortParam[] sort) {
        this.sort = sort;
    }

    public T getFilter() {
        return filter;
    }

    public void setFilter(T filter) {
        this.filter = filter;
    }
}
