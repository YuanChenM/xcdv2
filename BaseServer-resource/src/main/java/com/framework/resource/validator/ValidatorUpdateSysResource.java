package com.framework.resource.validator;

import com.framework.resource.bean.param.SysResourceParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by dai_youcheng on 2016-11-25.
 */
public class ValidatorUpdateSysResource extends DefaultCustomValidator<SysResourceParam> {
    @Override
    public void validator(SysResourceParam restRequest) {
        this.validatorRequired("res.E00024", restRequest);
        if (null != restRequest) {
            this.validatorRequired("res.E00009", restRequest.getSysId());
        }
    }
}
