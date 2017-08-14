package com.framework.resource.validator;

import com.framework.resource.bean.entity.ActionResourceDoc;
import com.framework.validator.DefaultCustomValidator;

public class ValidatorActionResourceSave extends DefaultCustomValidator<ActionResourceDoc> {
    @Override
    public void validator(ActionResourceDoc request) {
        this.validatorRequired("res.E00024", request);
        if (null != request) {
            this.validatorRequired("res.E00001", request.getActionName());
            this.validatorRequired("res.E00002", request.getActionCode());
            this.validatorRequired("res.E00003", request.getActionType());
            this.validatorRequired("res.E00004", request.getActionDesc());
        }
    }
}
