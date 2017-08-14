package com.bms.como.validator;

import com.bms.como.bean.param.SaleStatusRsParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by yuan_zhifei on 2017/3/27.
 */
public class SaleStatusAddValidator extends DefaultCustomValidator<SaleStatusRsParam> {
    @Override
    public void validator(SaleStatusRsParam saleStatusRsParam) {
        if (saleStatusRsParam != null) {
            this.validatorRequired("COMO.L01001", saleStatusRsParam.getSaleStatusCode());
            this.validatorMaxLength("COMO.L01001", saleStatusRsParam.getSaleStatusCode(), true, 8);
            this.validatorRequired("COMO.L01002", saleStatusRsParam.getSaleStatusName());
            this.validatorMaxLength("COMO.L01002", saleStatusRsParam.getSaleStatusName(), true, 64);
            this.validatorRequired("COMO.L01003", saleStatusRsParam.getIsDefault());
            this.validatorRequired("COMO.L01004", saleStatusRsParam.getIsValid());
        } else {
            this.validatorRequired("COMO.L01005", null);
        }
    }
}
