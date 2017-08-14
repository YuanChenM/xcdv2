package com.framework.authority.validator;

import com.framework.authority.bean.param.TreeParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by zhang_jian3 on 2017/1/10.
 */
public class SearchTreeValidator extends DefaultCustomValidator<TreeParam> {
    @Override
    public void validator(TreeParam request) {
        this.validatorRequired("auth.E00024", request);
    }
}
