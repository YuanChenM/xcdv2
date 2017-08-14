package com.bms.byim.bean.param;


import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;

import java.io.InputStream;
import java.util.Map;

/**
 * Created by zhang_jian4 on 2017/2/10.
 */
@ApiModel(value = "MailRsParam", description = "邮件服务")
public class MailRsParam extends BaseRestPaginationParam {

    /** 邮件类型 */
    private String mailContent;
    /** 发送给谁 */
    private String[] mailTo;
    /** 抄送给谁 */
    private String[] mailCC;
    /** 标题 */
    private String subject;
    /** 内容 */
    private String content;

    private Map<String ,InputStream> attachment;
    private Map<String,String> templateData;
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

    public Map<String, String> getTemplateData() {
        return templateData;
    }

    public void setTemplateData(Map<String, String> templateData) {
        this.templateData = templateData;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
}
