package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0903IFilter;
import com.bms.order.common.rest.BaseSearchRestParam;
import com.bms.order.common.rest.SearchRestParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * 买手退货原因查询接口Validator
 * 
 * @author li_huiqian
 */
public class ORDR0903IRestValidator extends OrderValidator<BaseSearchRestParam<ORDR0903IFilter>> {
    @Override
    public void validator(BaseSearchRestParam<ORDR0903IFilter> param) {

        this.validateOperator(param.getOperator());
        ORDR0903IFilter filter = param.getFilter();
        if(null != filter){
            this.validateReasonId(filter.getReasonId(),false);
            this.validateReasonName(filter.getReasonName(),false);
            this.validateApplyType(filter.getApplyType(),false);
            this.validateSort(filter.getSort());
        }
    }
}
