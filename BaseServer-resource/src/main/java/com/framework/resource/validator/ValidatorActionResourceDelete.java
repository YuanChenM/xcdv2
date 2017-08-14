package com.framework.resource.validator;

import java.util.ArrayList;

import com.framework.validator.DefaultCustomValidator;

public class ValidatorActionResourceDelete extends DefaultCustomValidator<ArrayList<String>> {
    @Override
    public void validator(ArrayList<String> request) {
        this.validatorRequired("res.E00009", request);
    }
}
