package com.framework.resource.validator;

import java.util.ArrayList;

import com.framework.validator.DefaultCustomValidator;

/**
 * Created by dai_youcheng on 2016-11-25.
 */
public class ValidatorDeleteSysResource extends DefaultCustomValidator<ArrayList<String>> {
    @Override
    public void validator(ArrayList<String> Request) {

        this.validatorRequired("res.E00009", Request);

    }
}
