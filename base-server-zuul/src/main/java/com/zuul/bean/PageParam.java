package com.zuul.bean;

import java.io.Serializable;

/**
 * Created by mao_yejun on 2017/2/28.
 */
public class PageParam implements Serializable {
    private Pagination pagination;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
