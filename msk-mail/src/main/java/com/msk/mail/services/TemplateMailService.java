package com.msk.mail.services;

import com.msk.mail.bean.MailParam;

/**
 * @author zhou_yajun
 * @version 1.0
 */
public interface TemplateMailService {

    /**
     * 模板邮件发送
     * @param param
     * @return
     */
    String templateMailSend(MailParam param);
}
