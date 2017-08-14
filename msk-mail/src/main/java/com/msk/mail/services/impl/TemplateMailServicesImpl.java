package com.msk.mail.services.impl;

import com.msk.mail.bean.MailParam;
import com.msk.mail.services.TemplateMailService;
import com.msk.mail.util.MailUtil;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @author zhou_yajun
 * @version 1.0
 */
@Service
public class TemplateMailServicesImpl implements TemplateMailService {

    private static Logger logger = LoggerFactory.getLogger(TemplateMailServicesImpl.class);
    @Autowired
    private JavaMailSender javaMailSender;
    @Resource
    private Environment environment;
    @Autowired
    private VelocityEngine velocityEngine;

    /**
     * 模板邮件发送
     * @param param
     * @return
     */
    @Override
    public String templateMailSend(MailParam param) {
        try {
            String mailFrom = environment.getProperty("spring.mail.from");
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            //发送邮件的邮箱
            helper.setFrom(mailFrom);
            //接收邮件的邮箱
            helper.setTo(param.getMailTo());
            //抄送的邮箱
            String[] cc = param.getMailCC();
            String appendMailCc = environment.getProperty("append.mail.cc");
            String[] mailCcAddresseeList = MailUtil.getMailCcAddressee(cc, appendMailCc);
            if (mailCcAddresseeList != null && mailCcAddresseeList.length > 0) {
                helper.setCc(mailCcAddresseeList);
            }
            //邮件主题
            helper.setSubject(param.getSubject());
            //如果存在附件
            if (param.getAttachment() != null && param.getAttachment().size() > 0) {
                addAttachments(helper,param.getAttachment());
            }
            //如果存在模板数据
            if(param.getTemplateData() != null && param.getTemplateData().size() > 0){
                String text = VelocityEngineUtils.mergeTemplateIntoString(
                        velocityEngine, param.getTemplateName(), "UTF-8", param.getTemplateData());
                helper.setText(text, true);
            }else{
                helper.setText(param.getContent(), true);
            }
            javaMailSender.send(mimeMessage);
            return "S";
        } catch (Exception me) {
            logger.error(me.getMessage());
            return "F";
        }
    }

    public void addAttachments(MimeMessageHelper helper, Map<String, InputStream> attachmentMap) {
        Map<String, FileSystemResource> attachments = MailUtil.getAttachments(attachmentMap);
        try {
            for (String key : attachments.keySet()) {
                helper.addAttachment(MimeUtility.encodeWord(key), attachments.get(key));
            }
        }catch (MessagingException me){
            logger.error(me.getMessage());
        }catch (UnsupportedEncodingException e){
            logger.error(e.getMessage());
        }
    }
}
