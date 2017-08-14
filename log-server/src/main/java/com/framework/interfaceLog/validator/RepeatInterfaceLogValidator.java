package com.framework.interfaceLog.validator;

import com.framework.interfaceLog.bean.entity.LogInterfaceDoc;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by 健 on 2017/5/9.
 */
public class RepeatInterfaceLogValidator extends DefaultCustomValidator<LogInterfaceDoc> {
    @Override
    public void validator(LogInterfaceDoc request) {
        this.validatorRequired("log.E00024", request);
        if (null != request) {
            this.validatorRequired("log.E00006", request.getLogId());
            this.validatorRequired("log.E00001", request.getSystemName());
            this.validatorRequired("log.E00008", request.getRequestBody());
            this.validatorRequired("log.E00002", request.getUrl());
        }
    }
}
