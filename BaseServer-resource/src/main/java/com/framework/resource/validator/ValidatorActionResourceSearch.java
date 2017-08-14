package com.framework.resource.validator;

import com.framework.resource.bean.param.ActionResourceParam;
import com.framework.validator.DefaultCustomValidator;

public class ValidatorActionResourceSearch extends DefaultCustomValidator<ActionResourceParam> {
    @Override
    public void validator(ActionResourceParam request) {
        this.validatorRequired("res.E00024", request);
    }
}
