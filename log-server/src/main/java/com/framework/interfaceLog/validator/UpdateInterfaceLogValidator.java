package com.framework.interfaceLog.validator;

import com.framework.interfaceLog.bean.entity.LogInterfaceDoc;
import com.framework.validator.DefaultCustomValidator;

public class UpdateInterfaceLogValidator extends DefaultCustomValidator<LogInterfaceDoc> {
    @Override
    public void validator(LogInterfaceDoc request) {
        this.validatorRequired("log.E00024", request);
        if (null != request) {
            this.validatorRequired("log.E00006", request.getLogId());
        }
    }
}
