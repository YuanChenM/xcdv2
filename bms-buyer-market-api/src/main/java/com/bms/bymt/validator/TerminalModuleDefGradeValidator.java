package com.bms.bymt.validator;

import com.bms.bymt.bean.BaseRequest;
import com.bms.bymt.bean.param.TermGradeInfoParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by guan_zhongheng on 2016/12/16.
 */
public class TerminalModuleDefGradeValidator extends DefaultCustomValidator<BaseRequest<TermGradeInfoParam>> {
    @Override
    public void validator(BaseRequest<TermGradeInfoParam> termGradeInfoParamBaseRequest) {
        if (termGradeInfoParamBaseRequest.getBean() != null) {

        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
