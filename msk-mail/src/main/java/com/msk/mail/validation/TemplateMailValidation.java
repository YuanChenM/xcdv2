package com.msk.mail.validation;

import com.framework.validator.DefaultCustomValidator;
import com.msk.mail.bean.MailParam;

/**
 * @author zhou_yajun
 * @version 1.0
 */
public class TemplateMailValidation extends DefaultCustomValidator<MailParam> {
    @Override
    public void validator(MailParam param) {
        String[] mailTo = param.getMailTo();
        for (String to : mailTo){
            this.validatorEmail("",to,true);
        }
        this.validatorRequired("",param.getSubject());
        this.validatorRequired("",param.getContent());
        this.validatorRequired("",param.getTemplateData());
    }
}
