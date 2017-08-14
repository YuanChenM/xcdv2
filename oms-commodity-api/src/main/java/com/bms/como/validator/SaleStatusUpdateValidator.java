package com.bms.como.validator;

import com.bms.como.bean.param.BaseBean;
import com.bms.como.bean.param.SaleStatusRsParam;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by yuan_zhifei on 2017/3/27.
 */
public class SaleStatusUpdateValidator extends DefaultCustomValidator<BaseBean<SaleStatusRsParam, SaleStatusRsParam>> {
    @Override
    public void validator(BaseBean<SaleStatusRsParam, SaleStatusRsParam> baseBean) {
        if (baseBean != null) {
            this.validatorRequired("COMO.L01000", baseBean.getFilter().getSaleStatusId());
            this.validatorRequired("COMO.L01006", baseBean.getTarget().getVersion());
            if (StringUtils.isNotEmpty(baseBean.getTarget().getSaleStatusName())) {
                this.validatorMaxLength("COMO.L01002", baseBean.getTarget().getSaleStatusName(), true, 64);
            }
        } else {
            this.validatorRequired("COMO.L01005", null);
        }
    }
}
