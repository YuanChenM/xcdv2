package com.msk.mail.services.impl;

import com.msk.mail.bean.MailParam;
import com.msk.mail.services.HtmlMailService;
import com.msk.mail.util.MailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.InputStream;
import java.util.Map;

/**
 * @author liu_tao2
 * @version 1.0
 */
@Service
public class HtmlMailServiceImpl implements HtmlMailService {
    private static Logger logger = LoggerFactory.getLogger(HtmlMailServiceImpl.class);
    @Autowired
    private JavaMailSender mailSender;
    @Resource
    private Environment environment;

    /**
     * html格式邮件发送
     *
     * @param mailParam
     * @return
     */
    @Override
    public String sentHtmlMail(MailParam mailParam) {
        MimeMessage message = null;
        try {
            String mailFrom = environment.getProperty("spring.mail.from");
            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(mailFrom);
            String appendMailCc = environment.getProperty("append.mail.cc");
            String[] mailCcAddresseeList = MailUtil.getMailCcAddressee(mailParam.getMailCC(), appendMailCc);

            if (mailCcAddresseeList != null || mailCcAddresseeList.length >= 0) {
                helper.setCc(mailCcAddresseeList);
            }
            helper.setTo(mailParam.getMailTo());
            helper.setSubject(mailParam.getSubject());
            helper.setText(mailParam.getContent(), true);
            addAttachment(mailParam.getAttachment(), helper);
            mailSender.send(message);
        } catch (MessagingException e) {
            logger.error(e.getMessage());
            return "F";
        }
        return "S";
    }

    /**
     * 得到需要的附件
     *
     * @param attachment
     * @param helper
     */
    public void addAttachment(Map<String, InputStream> attachment, MimeMessageHelper helper) {
        Map<String, FileSystemResource> fileSystemResourceMap = MailUtil.getAttachments(attachment);
        if (null == fileSystemResourceMap || fileSystemResourceMap.size() == 0) {
            return;
        }
        try {
            for (String key : fileSystemResourceMap.keySet()) {
                helper.addAttachment(key, fileSystemResourceMap.get(key));
            }
        } catch (Exception e) {
           logger.error(e.getMessage());
        }

    }
}
