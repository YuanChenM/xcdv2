package com.framework.interfaceLog.validator;

import java.util.ArrayList;

import com.framework.validator.DefaultCustomValidator;

public class DelInterfaceLogValidator extends DefaultCustomValidator<ArrayList<String>> {
    @Override
    public void validator(ArrayList<String> request) {
        this.validatorRequired("log.E00006", request);
    }
}
