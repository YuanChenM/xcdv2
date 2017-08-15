package com.bms.order.validator;

import java.util.List;

import com.bms.order.bean.param.ORDR0302IBeanParam;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.param.RestOperator;
import com.framework.validator.DefaultCustomValidator;

/**
 * 配送通知单取消接口Validator
 *
 * @author li_huiqian
 */
public class ORDR0302IRestValidator extends OrderCustomValidator<BusinessRestParam<ORDR0302IBeanParam>> {
    @Override
    public void validator(BusinessRestParam<ORDR0302IBeanParam> request) {

        RestOperator operator = request.getOperator();
        this.validateOperator(operator);

        List<ORDR0302IBeanParam> beans = request.getBeans();
        int index = 1;
        for (ORDR0302IBeanParam bean : beans) {
            this.validatorRequired(index, "distributionNotificationId", bean.getDistributionNotificationId());
            this.validatorRequired(index, "cancelPersonId", bean.getCancelPersonId());
            this.validatorRequired(index, "cancelReason", bean.getCancelReason());
            this.validatorRequired(index, "cancelPersonType", bean.getCancelPersonType());
            this.validatorRequired(index, "cancelPersonName", bean.getCancelPersonName());
            this.validatorRequired(index, "cancelDatetime", bean.getCancelDatetime());
            index++;
        }
    }
}
