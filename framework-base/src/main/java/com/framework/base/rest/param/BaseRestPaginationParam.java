package com.framework.base.rest.param;


import com.framework.base.bean.Pagination;
import com.framework.base.bean.Sort;

import java.io.Serializable;

/**
 * 分页参数
 *
 * @author mao_yejun
 * @version 1.0
 */
public class BaseRestPaginationParam implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 分页参数
     */
    private Pagination pagination = new Pagination();
    /**
     * 排序
     */
    private Sort[] sort;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Sort[] getSort() {
        return sort;
    }

    public void setSort(Sort[] sort) {
        this.sort = sort;
    }

    public BaseRestPaginationParam() {
    }
}
