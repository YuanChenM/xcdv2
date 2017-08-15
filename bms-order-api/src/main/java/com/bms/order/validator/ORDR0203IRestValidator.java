package com.bms.order.validator;

import java.util.List;

import com.bms.order.bean.param.ORDR0203IBeanParam;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.param.RestOperator;
import com.bms.order.constant.OrderConst;
import com.bms.order.constant.enumeration.OperatorType;
import com.bms.order.constant.i18n.FieldCode;
import com.bms.order.constant.i18n.ValidatorCode;
import com.framework.exception.bean.ValidatorExceptionMessage;
import com.framework.validator.DefaultCustomValidator;
import com.framework.validator.utils.NumberValidator;

/**
 * 订单分拆结果确认接口Validator
 *
 * @author li_huiqian
 */
public class ORDR0203IRestValidator extends OrderCustomValidator<BusinessRestParam<ORDR0203IBeanParam>> {

    @Override
    public void validator(BusinessRestParam<ORDR0203IBeanParam> param) {
        // 验证Operator
        RestOperator operator = param.getOperator();
        this.validateOperator(operator);

        List<ORDR0203IBeanParam> beans = param.getBeans();
        // beans必填
        validatorRequired(FieldCode.BEANS, beans);
        if (beans == null || beans.size() == 0)
            return;
        for (int i = 0; i < beans.size(); i++) {
            ORDR0203IBeanParam bean = beans.get(i);
            // 买家分批订单ID，必填
            this.validatorLong(FieldCode.BUYER_BATCH_ORDER_ID, bean.getBatchOrderId(), true,
                    OrderConst.MAX_VALUE_BIGINT_ID, OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);
        }

    }

}
