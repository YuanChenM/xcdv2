package com.framework.resource.validator;

import com.framework.resource.bean.entity.ActionResourceDoc;
import com.framework.validator.DefaultCustomValidator;

public class ValidatorActionResourceUpdate extends DefaultCustomValidator<ActionResourceDoc> {
    @Override
    public void validator(ActionResourceDoc request) {
        this.validatorRequired("res.E00024", request);
        if (null != request) {
            this.validatorRequired("res.E00009", request.getActionId());
        }
    }
}
