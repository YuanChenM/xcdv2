package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0808IBean;
import com.bms.order.common.rest.BusinessRestParam;

/**
 * Created by Administrator on 2017/3/6.
 */
public class ORDR0808IRestValidator extends OrderValidator<BusinessRestParam<ORDR0808IBean>> {

    @Override
    public void validator(BusinessRestParam<ORDR0808IBean> param) {
        this.validateOperator(param.getOperator());
        this.validateBeans(param.getBeans());
        for (ORDR0808IBean bean : param.getBeans()) {

            this.validateReturnId(bean.getReturnId(), true);
            this.validateBuyerConfirmUserType(bean.getConfirmUserType(), true);
            this.validateConfirmUid(bean.getConfirmUid(), false);
            this.validateConfirmUname(bean.getConfirmUname(), true);
            this.validateConfirmTime(bean.getConfirmTime(), true);
            this.validateConfirmRemark(bean.getConfirmRemark(),false);
            this.validateVersion(bean.getVer(),true);
            this.validateConfirmType(bean.getConfirmType(),true);
        }
    }
}
