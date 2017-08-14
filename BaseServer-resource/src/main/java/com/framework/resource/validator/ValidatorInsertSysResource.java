package com.framework.resource.validator;

import com.framework.resource.bean.entity.SysResourceDoc;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by dai_youcheng on 2016-11-25.
 */
public class ValidatorInsertSysResource extends DefaultCustomValidator<SysResourceDoc> {
    @Override
    public void validator(SysResourceDoc restRequest) {
        this.validatorRequired("res.E00024", restRequest);
        if (null != restRequest) {
            this.validatorRequired("res.E00010", restRequest.getSysCode());
            this.validatorRequired("res.E00011", restRequest.getSysName());
            this.validatorRequired("res.E00012", restRequest.getSysUrl());
            this.validatorRequired("res.E00013", restRequest.getSysSort());
            this.validatorRequired("res.E00014", restRequest.getImagePath());
        }
    }
}
