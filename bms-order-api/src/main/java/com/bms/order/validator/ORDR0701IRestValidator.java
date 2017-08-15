package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0701IBeanParam;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.param.RestOperator;

import java.util.List;

/**
 * 支付通知回传接口Validator
 *
 * @author li_huiqian
 */
public class ORDR0701IRestValidator extends OrderValidator<BusinessRestParam<ORDR0701IBeanParam>> {
    @Override
    public void validator(BusinessRestParam<ORDR0701IBeanParam> param) {

        RestOperator operator = param.getOperator();
        this.validateOperator(operator);

        List<ORDR0701IBeanParam> beans = param.getBeans();
        int index = 1;
        for (ORDR0701IBeanParam bean : beans) {
            this.validatorLong(index, "orderId", bean.getOrderId(), true, Long.MAX_VALUE, Long.MIN_VALUE, 4);
            this.validateOrderType(bean.getOrderType(), true);
            this.validatorMaxLength(index, "orderType", bean.getOrderType(), true, 3);
            this.validatorDecimal(index, "paymentAmount", bean.getPaymentAmount(), true, 15, 2, 5);
            this.validatorLong(index, "batchOrderId", bean.getBatchOrderId(), false, Long.MAX_VALUE, Long.MIN_VALUE, 4);
            this.validatePaymentWay(bean.getPaymentWay(), true);
            this.validatePaymentSubject(bean.getPaymentSubject(), true);
            index++;
        }

    }
}
