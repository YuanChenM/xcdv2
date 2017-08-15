package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0806IFilter;
import com.bms.order.common.rest.BaseSearchRestParam;

/**
 * 买家退货原因查询接口Validator
 * 
 * @author li_huiqian
 */
public class ORDR0806IRestValidator extends OrderValidator<BaseSearchRestParam<ORDR0806IFilter>> {
    @Override
    public void validator(BaseSearchRestParam<ORDR0806IFilter> param) {
        this.validateOperator(param.getOperator());
        ORDR0806IFilter filter = param.getFilter();
        if(null != filter){
            this.validateReasonId(filter.getReasonId(),false);
            this.validateReasonName(filter.getReasonName(),false);
            this.validateApplyType(filter.getApplyType(),false);
            this.validateSort(filter.getSort());
        }
    }
}
