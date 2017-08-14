package com.zuul.bean;

import java.io.Serializable;

/**
 * Created by mao_yejun on 2017/2/28.
 */
public class Pagination implements Serializable {
    private static final long serialVersionUID = 1L;
    private int pageSize ;
    private int startPos ;

    public Pagination() {
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartPos() {
        return this.startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }
}