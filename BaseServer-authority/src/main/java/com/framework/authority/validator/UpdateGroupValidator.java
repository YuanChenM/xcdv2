package com.framework.authority.validator;

import com.framework.authority.bean.entity.GroupDoc;
import com.framework.validator.DefaultCustomValidator;

public class UpdateGroupValidator extends DefaultCustomValidator<GroupDoc> {
    @Override
    public void validator(GroupDoc request) {
        this.validatorRequired("auth.E00024", request);
        if (null != request) {
            this.validatorRequired("auth.E00006", request.getGroupId());
            // this.validatorRequired("auth.E00007", request.getGroupCode());
            this.validatorRequired("auth.E00008", request.getGroupName());
        }
    }
}
