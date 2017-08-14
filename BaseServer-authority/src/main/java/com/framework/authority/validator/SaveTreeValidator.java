package com.framework.authority.validator;

import com.framework.authority.bean.entity.TreeDoc;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by zhang_jian3 on 2016/11/21.
 */
public class SaveTreeValidator extends DefaultCustomValidator<TreeDoc> {
    @Override
    public void validator(TreeDoc request) {
        this.validatorRequired("auth.E00024", request);
        if (null != request) {
//            this.validatorRequired("auth.E00010", request.getTreeId());
            this.validatorRequired("auth.E00016", request.getTreeCode());
            this.validatorRequired("auth.E00017", request.getTreeName());
            this.validatorRequired("auth.E00018", request.getIsMultiple());
            this.validatorRequired("auth.E00019", request.getIsChildren());
            this.validatorRequired("auth.E00020", request.getIsNotChildren());
            this.validatorRequired("auth.E00021", request.getIsNotParent());
            this.validatorRequired("auth.E00022", request.getIsParent());
        }
    }
}
