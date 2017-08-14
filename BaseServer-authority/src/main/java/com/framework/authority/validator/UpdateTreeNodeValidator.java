package com.framework.authority.validator;

import com.framework.authority.bean.entity.TreeNodeDoc;
import com.framework.validator.DefaultCustomValidator;

public class UpdateTreeNodeValidator extends DefaultCustomValidator<TreeNodeDoc> {
    @Override
    public void validator(TreeNodeDoc request) {
        this.validatorRequired("auth.E00024", request);
        if (null != request) {
            this.validatorRequired("auth.E00023", request.getNodeId());
        }
    }
}
