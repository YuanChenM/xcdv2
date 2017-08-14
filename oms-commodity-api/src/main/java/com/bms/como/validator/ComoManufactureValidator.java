package com.bms.como.validator;

import com.bms.como.bean.param.ComoManufactureRsParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by yuan_zhifei on 2017/3/27.
 */
public class ComoManufactureValidator extends DefaultCustomValidator<ComoManufactureRsParam> {
    @Override
    public void validator(ComoManufactureRsParam comoManufactureRsParam) {
        if (comoManufactureRsParam != null) {
            this.validatorRequired("commodityId", comoManufactureRsParam.getCommodityId());
        }
    }



}
