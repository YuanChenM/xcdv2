package com.framework.authority.validator;

import com.framework.authority.bean.entity.TreeDoc;
import com.framework.validator.DefaultCustomValidator;

public class UpdateTreeValidator extends DefaultCustomValidator<TreeDoc> {
    @Override
    public void validator(TreeDoc request) {
        this.validatorRequired("auth.E00024", request);
        if (null != request) {
            this.validatorRequired("auth.E00010", request.getTreeId());
        }
    }
}
