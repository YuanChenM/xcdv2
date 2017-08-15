package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0802IBean;
import com.bms.order.common.rest.BusinessRestParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * 买家退货单确认接口Validator
 *
 * @author li_huiqian
 */
public class ORDR0802IRestValidator extends OrderValidator<BusinessRestParam<ORDR0802IBean>> {
    @Override
    public void validator(BusinessRestParam<ORDR0802IBean> param) {
        this.validateOperator(param.getOperator());
        this.validateBeans(param.getBeans());
        for (ORDR0802IBean bean : param.getBeans()) {

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
