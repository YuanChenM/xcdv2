package com.bms.prce.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;

import java.io.Serializable;

/**
 * 商品同步接口
 *
 * @author zhou_ling
 * @version 1.0
 * @Time 2017/01/23
 */
public class PRCE0212IParam extends BaseRestPaginationParam {

    private String[] commodityId;

    /**
     * Getter method for property <tt>commodityId</tt>.
     *
     * @return property value of commodityId
     */
    public String[] getCommodityId() {
        return commodityId;
    }

    /**
     * Setter method for property <tt>commodityId</tt>.
     *
     * @param commodityId value to be assigned to property commodityId
     */
    public void setCommodityId(String[] commodityId) {
        this.commodityId = commodityId;
    }
}
