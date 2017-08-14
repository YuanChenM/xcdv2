package com.framework.authority.validator;

import com.framework.authority.bean.entity.GroupDoc;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by zhang_jian3 on 2016/11/21.
 */
public class SaveGroupValidator extends DefaultCustomValidator<GroupDoc> {
    @Override
    public void validator(GroupDoc request) {
        this.validatorRequired("auth.E00024", request);
        if (null != request) {
            this.validatorRequired("auth.E00007", request.getGroupCode());
            this.validatorRequired("auth.E00008", request.getGroupName());
            this.validatorRequired("auth.E00009", request.getGroupDesc());
        }
    }
}
