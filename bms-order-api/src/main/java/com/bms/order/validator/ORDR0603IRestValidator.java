package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0603IBeanParam;
import com.bms.order.common.rest.BusinessRestParam;
import com.framework.core.utils.CollectionUtils;

/**
 * 买手订单取消接口Validator
 *
 * @author li_huiqian
 */
public class ORDR0603IRestValidator extends OrderValidator<BusinessRestParam<ORDR0603IBeanParam>> {
    @Override
    public void validator(BusinessRestParam<ORDR0603IBeanParam> param) {

        this.validateOperator(param.getOperator());
        this.validateBeans(param.getBeans());
        if (CollectionUtils.isEmpty(param.getBeans()))
            return;

        for (ORDR0603IBeanParam bean : param.getBeans()) {
            this.validateBsOrderId(bean.getBsOrderId(), false);
            this.validateBackNo(bean.getBackNo(),false);
            this.validateCancelType(bean.getCancelType(), true);
            this.validateCancelPersonType(bean.getCancelPersonType(), true);
            this.validateCancelPersonId(bean.getCancelPersonId(), true);
            this.validateCancelPersonName(bean.getCancelPersonCode(), true);
            this.validateCancelDatetime(bean.getCancelDateTime(), true);
            this.validateCancelReason(bean.getCancelReason(), true);
            this.validateVer(bean.getVer(), true);

        }
    }
}
