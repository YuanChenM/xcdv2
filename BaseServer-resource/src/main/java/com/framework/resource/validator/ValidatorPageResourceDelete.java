package com.framework.resource.validator;

import java.util.ArrayList;

import com.framework.validator.DefaultCustomValidator;

/**
 * Created by zhu_kai1 on 2016/11/25.
 */
public class ValidatorPageResourceDelete extends DefaultCustomValidator<ArrayList<String>> {
    @Override
    public void validator(ArrayList<String> request) {
        this.validatorRequired("res.E00009", request);
    }
}
