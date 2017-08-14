package com.msk.mail.services.impl;

import com.framework.exception.SystemException;
import com.msk.mail.bean.MailParam;
import com.msk.mail.services.SimpleMailService;
import com.msk.mail.util.MailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liu_tao2
 * @version 1.0
 */
@Service
public class SimpleMailServiceImpl implements SimpleMailService {

    private static Logger logger = LoggerFactory.getLogger(SimpleMailServiceImpl.class);
    @Autowired
    private JavaMailSender mailSender;
    @Resource
    private Environment environment;

    /**
     * 发送简单邮件
     *
     * @param mailParam
     * @return
     */
    @Override
    public String sendSimpleMail(MailParam mailParam) {
        try {
            String mailFrom = environment.getProperty("spring.mail.from");
            SimpleMailMessage mailMessage = this.createSimpleMailMessage(mailFrom, mailParam);
            String[] to = mailParam.getMailTo();
            String[] cc = mailParam.getMailCC();
            this.setMailAddressee(mailMessage, to, cc);
            this.mailSender.send(mailMessage);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return "F";
        }
        return "S";
    }

    /**
     * 设置mail地址
     *
     * @param mailMessages
     * @param to
     * @param cc
     */
    private void setMailAddressee(SimpleMailMessage mailMessages, String[] to, String[] cc) {
        mailMessages.setTo(to);
        String appendMailCc = environment.getProperty("append.mail.cc");
        String[] mailCcAddresseeList = MailUtil.getMailCcAddressee(cc, appendMailCc);

        if (mailCcAddresseeList == null || mailCcAddresseeList.length == 0) {
            return;
        }
        mailMessages.setCc(mailCcAddresseeList);
    }

    /**
     * 创建简单发送邮件必要信息
     *
     * @param mailFrom
     * @param textContent
     * @return
     */
    private SimpleMailMessage createSimpleMailMessage(String mailFrom, MailParam textContent) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(mailFrom);
        mailMessage.setSubject(textContent.getSubject());
        mailMessage.setText(textContent.getContent());
        return mailMessage;
    }
}
