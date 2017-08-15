package com.bms.order.validator;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.bms.order.bean.param.ORDR0104IBeanParam;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.param.RestOperator;

/**
 * 买家订单确认接口Validator
 *
 * @author li_huiqian
 */
public class ORDR0104IRestValidator extends OrderCustomValidator<BusinessRestParam<ORDR0104IBeanParam>> {
    @Override
    public void validator(BusinessRestParam<ORDR0104IBeanParam> param) {
        RestOperator operator = param.getOperator();
        this.validateOperator(operator);

        List<ORDR0104IBeanParam> beans = param.getBeans();
        if (CollectionUtils.isEmpty(beans)) {
            this.validatorRequired("beans", null);
        } else {
            int index = 1;
            for (ORDR0104IBeanParam bean : beans) {
                Long buyerOrderId = bean.getBuyerOrderId();
                this.validatorRequired(index, "buyerOrderId", buyerOrderId);
                index++;
            }
        }
    }
}
