package com.bms.byim.validator;

import com.bms.byim.bean.param.MarketingStatusRsParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by yuan_zhifei on 2016/12/9.
 */
public class MarketingStatusSearchValidator extends DefaultCustomValidator<MarketingStatusRsParam> {
    @Override
    public void validator(MarketingStatusRsParam statusRsParam) {
        if (statusRsParam != null) {
            this.validatorRequired("BYIM.L00016", statusRsParam.getNodePath());
        } else {
            this.validatorRequired("BYIM.L00009", null);
        }
    }
}
