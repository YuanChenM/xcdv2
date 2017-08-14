package com.bms.dictionary.validator;

import com.bms.dictionary.bean.param.FindSubNodeParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by dai_youcheng on 2016-11-15.
 */
public class FindSubNodeValidator extends DefaultCustomValidator<FindSubNodeParam> {
    @Override
    public void validator(FindSubNodeParam findSubNodeParam) {
        this.validatorRequired("dictionary.Validator.E003", findSubNodeParam.getRootCode());
        this.validatorRequired("dictionary.Validator.E004", findSubNodeParam.getParentCode());
    }
}
