package com.bms.dictionary.validator;

import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by zhu_kai1 on 2016/12/16.
 */
public class DeleteNodeValidator extends DefaultCustomValidator<ArrayList<String>> {
    @Override
    public void validator(ArrayList<String> param) {
        this.validatorRequired("dictionary.Validator.E001",param);
    }
}
