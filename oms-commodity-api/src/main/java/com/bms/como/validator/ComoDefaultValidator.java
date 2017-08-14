package com.bms.como.validator;

import com.bms.como.bean.param.ComoDefaultRsParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by yuan_zhifei on 2017/3/27.
 */
public class ComoDefaultValidator extends DefaultCustomValidator<ComoDefaultRsParam> {
    @Override
    public void validator(ComoDefaultRsParam param) {
        this.validatorRequired("productPid", param.getProductPid());
    }


}
