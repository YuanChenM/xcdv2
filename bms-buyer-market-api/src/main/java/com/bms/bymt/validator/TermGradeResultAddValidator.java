package com.bms.bymt.validator;

import com.bms.bymt.bean.param.TermGradeResultParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by guan_zhongheng on 2016/12/16.
 */
public class TermGradeResultAddValidator extends DefaultCustomValidator<TermGradeResultParam> {

    @Override
    public void validator(TermGradeResultParam termGradeResultParamBaseRequest) {
        TermGradeResultParam param = termGradeResultParamBaseRequest;
        if (param != null) {
            this.validatorRequired("BYMT.L00069", param.getGradeInfoId());
           /* this.validatorRequired("BYMT.L00070", param.getTermMarketLevel());
            this.validatorRequired("BYMT.L00071", param.getServeType());
            this.validatorRequired("BYMT.L00072", param.getMarketRange());*/
        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
