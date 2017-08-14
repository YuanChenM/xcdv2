package com.msk.mail.services;

import com.msk.mail.bean.MailParam;

/**
 * @author liu_tao2
 * @version 1.0
 */
public interface HtmlMailService {
    /**
     * html格式邮件发送
     *
     * @param mailParam
     * @return
     */
    String sentHtmlMail(MailParam mailParam);
}
