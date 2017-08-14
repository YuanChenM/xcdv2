package com.framework.authority.validator;

import java.util.ArrayList;

import com.framework.validator.DefaultCustomValidator;

/**
 * Created by zhang_jian3 on 2016/11/21.
 */
public class DelGroupValidator extends DefaultCustomValidator<ArrayList<String>> {
    @Override
    public void validator(ArrayList<String> request) {
        this.validatorRequired("auth.E00006", request);
    }
}
