package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0604IBeanParam;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.param.RestOperator;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * 买手订单确认接口Validator
 *
 * @author li_huiqian
 */
public class ORDR0604IRestValidator extends OrderValidator<BusinessRestParam<ORDR0604IBeanParam>> {
    @Override
    public void validator(BusinessRestParam<ORDR0604IBeanParam> param) {

        RestOperator operator = param.getOperator();
        this.validateOperator(operator);
        this.validateBeans(param.getBeans());
        if (CollectionUtils.isEmpty(param.getBeans()))
            return;
        List<ORDR0604IBeanParam> beans = param.getBeans();
        for(ORDR0604IBeanParam bean : beans){
            this.validateBsOrderId(bean.getBsOrderId(), true);
        }
    }
}
