package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestBean;
import com.bms.order.common.rest.param.RestOperator;
import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Created by guan_zhongheng on 2017/4/26.
 */
@ApiModel(value = "ORDR110102IBeanParam", description = "沽货主表数据对象")
public class ORDR110102IBeanParam extends RestBean {

    private List<ORDR1101IBeanParam> beans;

    /**
     * 操作者
     */
    private RestOperator operator;

    public List<ORDR1101IBeanParam> getBeans() {
        return beans;
    }

    public void setBeans(List<ORDR1101IBeanParam> beans) {
        this.beans = beans;
    }

    public RestOperator getOperator() {
        return operator;
    }

    public void setOperator(RestOperator operator) {
        this.operator = operator;
    }
}
