package com.bms.order.validator;

import java.util.List;

import com.bms.order.bean.param.ORDR0607IFilterParam;
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
 * 买手订单囤货接口Validator
 *
 * @author li_huiqian
 */
public class ORDR0607IRestValidator extends OrderCustomValidator<BusinessRestParam<ORDR0607IFilterParam>> {

    @Override
    public void validator(BusinessRestParam<ORDR0607IFilterParam> request) {
        // 验证Operator
        RestOperator operator = request.getOperator();
        this.validateOperator(operator);

        List<ORDR0607IFilterParam> params = request.getBeans();
        if (null == params || params.size() == 0) {
            getExceptionMessageList().add(new ValidatorExceptionMessage(ValidatorCode.VALIDATOR_MESSAGE_CODE, null,
                    null, FieldCode.BS_ORDER_ID));
        }
        for (int i = 0; i < params.size(); i++) {
            ORDR0607IFilterParam param = params.get(i);
            Long bsOrderId = param.getBsOrderId();
            this.validatorLong(i, FieldCode.BS_ORDER_ID, bsOrderId, true, OrderConst.MAX_VALUE_BIGINT_ID,
                    OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);
        }
    }

}
