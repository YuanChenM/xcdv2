package com.framework.authority.validator;

import com.framework.authority.bean.param.TreeNodeParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by zhang_jian3 on 2017/1/10.
 */
public class SearchTreeNodeValidator extends DefaultCustomValidator<TreeNodeParam> {
    @Override
    public void validator(TreeNodeParam request) {
        this.validatorRequired("auth.E00024", request);
    }
}
