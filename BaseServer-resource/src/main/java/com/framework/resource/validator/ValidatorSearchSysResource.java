package com.framework.resource.validator;

import com.framework.resource.bean.entity.SysResourceDoc;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by dai_youcheng on 2016-11-25.
 */
public class ValidatorSearchSysResource extends DefaultCustomValidator<SysResourceDoc> {
    @Override
    public void validator(SysResourceDoc restRequest) {
        this.validatorRequired("res.E00024", restRequest);
    }
}
