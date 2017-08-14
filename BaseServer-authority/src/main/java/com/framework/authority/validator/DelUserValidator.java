package com.framework.authority.validator;

import java.util.ArrayList;

import com.framework.validator.DefaultCustomValidator;

/**
 * Created by dai_youcheng on 2016-11-22.
 */
public class DelUserValidator extends DefaultCustomValidator<ArrayList<String>> {
    @Override
    public void validator(ArrayList<String> request) {
        this.validatorRequired("auth.E00006", request);
    }
}
