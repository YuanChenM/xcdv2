package com.bms.issue.common.rest;

import java.io.Serializable;
import java.util.List;

import com.bms.issue.common.rest.param.RestBean;
import com.bms.issue.common.rest.param.RestOperator;

/**
 * 业务Param
 * 
 * @author li_huiqian
 *
 */
public class BusinessRestParam<T extends RestBean> implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1983857488529271834L;

    /**
     * 操作者
     */
    private RestOperator operator;

    /**
     * 业务对象
     */
    private List<T> beans;

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
     * @return the beans
     */
    public List<T> getBeans() {
        return beans;
    }

    /**
     * @param beans
     *            the beans to set
     */
    public void setBeans(List<T> beans) {
        this.beans = beans;
    }

}
