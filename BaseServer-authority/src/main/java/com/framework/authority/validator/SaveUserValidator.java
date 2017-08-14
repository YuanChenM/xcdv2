package com.framework.authority.validator;

import com.framework.authority.bean.entity.UserDoc;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by dai_youcheng on 2016-11-17.
 */
public class SaveUserValidator extends DefaultCustomValidator<UserDoc> {
    @Override
    public void validator(UserDoc request) {
        this.validatorRequired("auth.E00024", request);
        if (null != request) {
            this.validatorRequired("auth.E00001", request.getUserCode());
            this.validatorRequired("auth.E00002", request.getUserName());
            this.validatorRequired("auth.E00003", request.getUserType());
            this.validatorRequired("auth.E00004", request.getUserLogin());
            this.validatorRequired("auth.E00005", request.getUserPwd());
        }
    }
}
