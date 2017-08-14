package com.bms.bymt.validator;

import com.bms.bymt.bean.param.TermGradeInfoParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by yuan_zhifei on 2016/12/16.
 */
public class TermGradeInfoSearchValidator extends DefaultCustomValidator<TermGradeInfoParam> {
    @Override
    public void validator(TermGradeInfoParam paramSearchRestRequest) {
        TermGradeInfoParam param = paramSearchRestRequest;
        if (param != null) {
            this.validatorRequired("BYMT.L00019", param.getTermMarketId());
        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
