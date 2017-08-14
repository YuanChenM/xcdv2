package com.bms.dictionary.validator;

import com.bms.dictionary.bean.param.FindNodeParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by dai_youcheng on 2016-11-15.
 */
public class FindNodeValidator extends DefaultCustomValidator<FindNodeParam> {
    @Override
    public void validator(FindNodeParam findNodeParam) {
        this.validatorRequired("dictionary.Validator.E005", findNodeParam.getDictCode());
        this.validatorRequired("dictionary.Validator.E003", findNodeParam.getRootCode());
    }
}
