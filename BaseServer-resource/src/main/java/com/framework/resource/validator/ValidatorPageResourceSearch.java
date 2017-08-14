package com.framework.resource.validator;

import com.framework.resource.bean.param.PageResourceDocParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by zhu_kai1 on 2016/11/25.
 */
public class ValidatorPageResourceSearch extends DefaultCustomValidator<PageResourceDocParam> {
    @Override
    public void validator(PageResourceDocParam request) {
        this.validatorRequired("res.E00024", request);
    }
}
