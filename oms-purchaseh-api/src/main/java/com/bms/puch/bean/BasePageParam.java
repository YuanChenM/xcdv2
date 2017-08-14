package com.bms.puch.bean;

import com.framework.base.rest.param.BaseRestPaginationParam;

/**
 * Created by guan_zhongheng on 2017/3/16.
 */
public class BasePageParam extends BaseRestPaginationParam{

    /**
     * 分页层级
     */
    private Integer pagingLevel;

    public Integer getPagingLevel() {
        return pagingLevel;
    }

    public void setPagingLevel(Integer pagingLevel) {
        this.pagingLevel = pagingLevel;
    }


}
