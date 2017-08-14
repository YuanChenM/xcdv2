package com.framework.authority.validator;

import com.framework.authority.bean.entity.TreeNodeDoc;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by zhang_jian3 on 2016/11/21.
 */
public class SaveTreeNodeValidator extends DefaultCustomValidator<TreeNodeDoc> {
    @Override
    public void validator(TreeNodeDoc request) {
        this.validatorRequired("auth.E00024", request);
        if (null != request) {
            this.validatorRequired("auth.E00023", request.getNodeId());
            this.validatorRequired("auth.E00010", request.getTreeId());
            this.validatorRequired("auth.E00011", request.getNodeName());
            this.validatorRequired("auth.E00012", request.getNodeCode());
            this.validatorRequired("auth.E00013", request.getNodeSort());
            this.validatorRequired("auth.E00014", request.getFullPath());
        }
    }
}
