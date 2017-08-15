package com.bms.order.common.rest;

import com.bms.order.common.rest.param.RestFilter;
import com.bms.order.common.rest.param.RestOperator;
import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModelProperty;

/**
 * 检索Param
 * 
 * @author li_huiqian
 *
 */
public class SearchRestParam<T extends RestFilter> extends BaseRestPaginationParam {

    /**
     * 
     */
    private static final long serialVersionUID = 8410484299747217335L;

    /**
     * 操作者
     */
    private RestOperator operator;

    /**
     * 分页层级
     */
    private Integer pagingLevel;

    /**
     * 查询层级
     */
    @ApiModelProperty(hidden = true)
    private Integer searchLevel;

    /**
     * 检索条件
     */
    private T filter;

    /**
     * @return the operator
     */
    public RestOperator getOperator() {
        return operator;
    }

    /**
     * @param operator
     *            the operator to set
     */
    public void setOperator(RestOperator operator) {
        this.operator = operator;
    }

    /**
     * @return the pagingLevel
     */
    public Integer getPagingLevel() {
        return pagingLevel;
    }

    /**
     * @param pagingLevel
     *            the pagingLevel to set
     */
    public void setPagingLevel(Integer pagingLevel) {
        this.pagingLevel = pagingLevel;
    }

    /**
     * @return the searchLevel
     */
    public Integer getSearchLevel() {
        return searchLevel;
    }

    /**
     * @param searchLevel
     *            the searchLevel to set
     */
    public void setSearchLevel(Integer searchLevel) {
        this.searchLevel = searchLevel;
    }

    /**
     * @return the filter
     */
    public T getFilter() {
        return filter;
    }

    /**
     * @param filter
     *            the filter to set
     */
    public void setFilter(T filter) {
        this.filter = filter;
    }

}
