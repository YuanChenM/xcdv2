package com.framework.authority.validator;

import com.framework.authority.bean.entity.UserDoc;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by dai_youcheng on 2016-11-17.
 */
public class UpdateUserValidator extends DefaultCustomValidator<UserDoc> {
    @Override
    public void validator(UserDoc request) {
        this.validatorRequired("auth.E00024", request);
        if (null != request) {
            this.validatorRequired("auth.E00006", request.getUserId());
        }
    }
}
