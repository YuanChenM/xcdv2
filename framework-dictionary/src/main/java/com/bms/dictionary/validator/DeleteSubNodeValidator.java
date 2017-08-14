package com.bms.dictionary.validator;

import com.bms.dictionary.bean.restRequest.RestRequest;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by zhu_kai1 on 2016/12/16.
 */
public class DeleteSubNodeValidator extends DefaultCustomValidator<ArrayList<String>> {
    @Override
    public void validator(ArrayList<String> param) {
        this.validatorRequired("dictionary.Validator.E002",param);
    }
}
