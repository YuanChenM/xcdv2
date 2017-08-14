package com.bms.byim.validator;

import com.bms.byim.bean.param.GradeRsParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by yuan_zhifei on 2017/3/22.
 */
public class GradeAddValidator extends DefaultCustomValidator<GradeRsParam> {
    @Override
    public void validator(GradeRsParam gradeRsParam) {
        if (gradeRsParam != null) {
            this.validatorRequired("BYIM.L00051", gradeRsParam.getBuyerId());
        } else {
            this.validatorRequired("BYIM.L00009", null);
        }
    }
}
