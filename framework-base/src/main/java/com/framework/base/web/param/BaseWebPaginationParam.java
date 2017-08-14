package com.framework.base.web.param;

import com.framework.base.bean.Pagination;
import com.framework.base.bean.Sort;

import java.io.Serializable;

/**
 * 页面分页param
 *
 * @author mao_yejun
 * @version 1.0
 */
public class BaseWebPaginationParam implements Serializable {
    private static final long serialVersionUID = 1L;
    private Pagination pagination = new Pagination();
    /**
     * 排序设置
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
}


