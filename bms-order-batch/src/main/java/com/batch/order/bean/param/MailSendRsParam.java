package com.batch.order.bean.param;


import java.io.InputStream;
import java.io.Serializable;
import java.util.Map;


/**
 * Created by sunjiaju on 2017/3/20.
 */
public class MailSendRsParam implements Serializable {

    private String mailContent;

    private String[] mailTo;

    private String[] mailCC;

    private String subject;

    private String content;

    private Map<String, InputStream> attachment;

    private Map<String, Object> templateData;

    private String templateName;

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }

    public String[] getMailTo() {
        return mailTo;
    }

    public void setMailTo(String[] mailTo) {
        this.mailTo = mailTo;
    }

    public String[] getMailCC() {
        return mailCC;
    }

    public void setMailCC(String[] mailCC) {
        this.mailCC = mailCC;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, InputStream> getAttachment() {
        return attachment;
    }

    public void setAttachment(Map<String, InputStream> attachment) {
        this.attachment = attachment;
    }

    public Map<String, Object> getTemplateData() {
        return templateData;
    }

    public void setTemplateData(Map<String, Object> templateData) {
        this.templateData = templateData;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
}
