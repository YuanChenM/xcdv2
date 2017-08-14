package com.framework.base.bean;

import java.io.Serializable;

/**
 * Created by mao_yejun on 2016/12/27.
 */
public class Pagination implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 每页显示的行数
     */
    private int pageSize = 10;

    /**
     * 开始页数
     */
    private int startPos = 1;


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }
}
