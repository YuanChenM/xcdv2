package com.batch.bybatch.bean.param;

import com.batch.bybatch.bean.result.StandardGradeResult;
import com.framework.base.rest.param.BaseRestPaginationParam;

/**
 * Created by guan_zhongheng on 2017/2/23.
 */
public class OrderSearchRestParam<T extends BuyerOrderParam> extends BaseRestPaginationParam {

    /**
     * 操作者
     */
    private RestOperatorParam operator;

    /**
     * 检索条件
     */
    private T filter;

    public RestOperatorParam getOperator() {
        return operator;
    }

    public void setOperator(RestOperatorParam operator) {
        this.operator = operator;
    }

    public T getFilter() {
        return filter;
    }

    public void setFilter(T filter) {
        this.filter = filter;
    }
}
