package com.msk.mail.validation;

import com.framework.validator.DefaultCustomValidator;
import com.msk.mail.bean.MailParam;


/**
 * @author liu_tao2
 * @version 1.0
 */
public class MailValidation extends DefaultCustomValidator<MailParam> {
    @Override
    public void validator(MailParam param) {
        String[] mailTo = param.getMailTo();
        for (String to : mailTo){
            this.validatorEmail("",to,true);
        }
        this.validatorRequired("",param.getSubject());
        this.validatorRequired("",param.getContent());
    }
}
