package com.bms.como.validator;

import com.bms.como.bean.param.ComoInfoRsParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by yuan_zhifei on 2017/3/27.
 */
public class ComoInfoAddValidator extends DefaultCustomValidator<ComoInfoRsParam> {
    @Override
    public void validator(ComoInfoRsParam comoInfoRsParam) {
        if (comoInfoRsParam != null) {
//            this.validatorRequired("productPid", comoInfoRsParam.getProductPid());
            this.validatorRequired("uomList",comoInfoRsParam.getUomList());
        }else {
            return ;
        }

    }



}
