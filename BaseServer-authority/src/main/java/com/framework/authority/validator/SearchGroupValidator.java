package com.framework.authority.validator;

import com.framework.authority.bean.param.GroupParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by zhang_jian3 on 2017/1/10.
 */
public class SearchGroupValidator extends DefaultCustomValidator<GroupParam> {
    @Override
    public void validator(GroupParam request) {
        this.validatorRequired("auth.E00024", request);
    }
}
