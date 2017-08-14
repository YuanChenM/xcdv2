package com.framework.base.web.result;

import java.io.Serializable;
import java.util.List;

/**
 * 页面分页result
 *
 * @author mao_yejun
 * @version 1.0
 */
public class BaseWebPaginationResult<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 总记录数
     */
    private long total;
    /**
     * 分页数据
     */
    private List<T> data;

    public BaseWebPaginationResult() {
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
