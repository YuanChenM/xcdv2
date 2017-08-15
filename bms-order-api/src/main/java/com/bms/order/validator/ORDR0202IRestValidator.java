package com.bms.order.validator;

import java.util.List;

import com.bms.order.bean.param.ORDR0202IBeanParam;
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
 * 订单分拆结果取消接口Validator
 *
 * @author li_huiqian
 */
public class ORDR0202IRestValidator extends OrderCustomValidator<BusinessRestParam<ORDR0202IBeanParam>> {
    @Override
    public void validator(BusinessRestParam<ORDR0202IBeanParam> param) {
        // 验证Operator
        RestOperator operator = param.getOperator();
        this.validateOperator(operator);

        List<ORDR0202IBeanParam> beans = param.getBeans();
        // beans必填
        validatorRequired(FieldCode.BEANS, beans);
        if (beans == null || beans.size() == 0)
            return;

        for (ORDR0202IBeanParam bean : beans) {
            // 买家分批订单明细ID，必填
            this.validatorLong(FieldCode.BUYER_BATCH_ORDER_DETAIL_ID, bean.getBuyerBatchOrderDetailId(), true,
                    OrderConst.MAX_VALUE_BIGINT_ID, OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);
        }
    }

}
