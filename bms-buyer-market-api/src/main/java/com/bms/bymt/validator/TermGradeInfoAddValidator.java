package com.bms.bymt.validator;

import com.bms.bymt.bean.param.TermGradeInfoParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by guan_zhongheng on 2016/12/16.
 */
public class TermGradeInfoAddValidator extends DefaultCustomValidator<TermGradeInfoParam> {
    @Override
    public void validator(TermGradeInfoParam termGradeInfoParamBaseRequest) {
        TermGradeInfoParam param = termGradeInfoParamBaseRequest;
        if (param != null) {
            this.validatorRequired("BYMT.L00019", param.getTermMarketId());
        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
