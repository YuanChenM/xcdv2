package com.framework.authority.validator;

import com.framework.authority.bean.param.UserParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by zhang_jian3 on 2017/1/10.
 */
public class SearchUserValidator extends DefaultCustomValidator<UserParam> {
    @Override
    public void validator(UserParam request) {
        this.validatorRequired("auth.E00024", request);
    }
}
