package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0103IBeanParam;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.param.RestOperator;
import com.bms.order.constant.OrderConst;
import com.bms.order.constant.i18n.FieldCode;
import com.framework.validator.utils.NumberValidator;

import java.util.List;

/**
 * 买家订单取消接口Validator
 *
 * @author li_huiqian
 */
public class ORDR0103IRestValidator extends OrderCustomValidator<BusinessRestParam<ORDR0103IBeanParam>> {
    @Override
    public void validator(BusinessRestParam<ORDR0103IBeanParam> param) {

        RestOperator operator = param.getOperator();
       this.validateOperator(operator);
        List<ORDR0103IBeanParam> beans = param.getBeans();
        // beans必填
        validatorRequired(FieldCode.BEANS, beans);
        if (beans == null || beans.size() == 0)
            return;

        for(ORDR0103IBeanParam bean : beans){

            //buyerOrderId
            this.validatorLong(FieldCode.BUYER_ORDER_ID, bean.getBuyerOrderId(), false,
                    OrderConst.MAX_VALUE_BIGINT_ID, OrderConst.MIN_VALUE_BIGINT_ID, NumberValidator.POSITIVE);
            //backNo
            this.validatorMaxLength(FieldCode.BACK_NO, bean.getBackNo(), false,
                    OrderConst.MAX_LENGTH_BACK_NO);

            //cancelType
            this.validatorMaxLength(FieldCode.CANCEL_TYPE, bean.getCancelType(), true,
                    OrderConst.MAX_LENGTH_CANCEL_TYPE);

            //cancelPersonType
            this.validatorMaxLength(FieldCode.CANCEL_PERSON_TYPE, bean.getCancelPersonType(), true,
                    OrderConst.MAX_LENGTH_CANCEL_PERSON_TYPE);

            //cancelPersonId
            this.validatorMaxLength(FieldCode.CANCEL_PERSON_ID, bean.getCancelPersonId(), true,
                    OrderConst.MAX_LENGTH_BS_ORDER_CODE);

            //cancelPersonCode
            this.validatorMaxLength(FieldCode.CANCEL_PERSON_CODE, bean.getCancelPersonCode(), true,
                    OrderConst.MAX_LENGTH_CANCEL_PERSON_CODE);

            //cancelPersonName
            this.validatorMaxLength(FieldCode.CANCEL_PERSON_NAME, bean.getCancelPersonName(), true,
                    OrderConst.MAX_LENGTH_CANCEL_PERSON_NAME);

            //cancelReason
            this.validatorMaxLength(FieldCode.CANCEL_REASON, bean.getCancelReason(), true,
                    OrderConst.MAX_LENGTH_CANCEL_REASON);

            //cancelDateTime
            this.validatorDate(FieldCode.CANCEL_DATETIME,bean.getCancelDateTime(),true);

            //ver
            this.validatorInteger(FieldCode.VER,bean.getVer(),
                    true,OrderConst.MAX_VALUE_VERSION,OrderConst.MIN_VALUE_VERSION,NumberValidator.POSITIVE);
        }
    }

}
