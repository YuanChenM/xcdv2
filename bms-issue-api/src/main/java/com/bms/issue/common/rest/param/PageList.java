package com.bms.issue.common.rest.param;

import java.util.ArrayList;

/**
 * 分页list
 * 
 * @author li_huiqian
 *
 * @param <E>
 */
public class PageList<E> extends ArrayList<E> {

    /**
     * 
     */
    private static final long serialVersionUID = 1430366699365139251L;

    /**
     * 总数量
     */
    private Long total;

    public PageList(Long total) {
        this.total = total;
    }

    /**
     * @return the total
     */
    public Long getTotal() {
        return total;
    }

    /**
     * @param total
     *            the total to set
     */
    public void setTotal(Long total) {
        this.total = total;
    }

}
