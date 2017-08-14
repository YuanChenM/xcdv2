package com.msk.mail.services;

import com.msk.mail.bean.MailParam;

/**
 * @author liu_tao2
 * @version 1.0
 */
public interface SimpleMailService {
    /**
     * 发送简单邮件
     *
     * @param mailParam
     * @return
     */
    String sendSimpleMail(MailParam mailParam);
}
