package com.msk.mail.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Map;

@ApiModel(value = "MailParam", description = "发送邮件参数")
public class MailParam<T> implements Serializable {
    @ApiModelProperty(name = "mailContent", notes = "邮件类型")
    private T mailContent;
    @ApiModelProperty(name = "mailTo", notes = "发送给谁")
    private String[] mailTo;
    @ApiModelProperty(name = "mailCC", notes = "CC给谁")
    private String[] mailCC;

    @ApiModelProperty(name = "subject", notes = "标题")
    private String subject;
    @ApiModelProperty(name = "content", notes = "内容")
    private String content;

    @ApiModelProperty(name = "attachment",notes = "附件流")
    private Map<String ,InputStream> attachment;
    @ApiModelProperty(name = "templateData", notes = "模板数据")
    private Map<String,Object> templateData;
    @ApiModelProperty(name = "templateName", notes = "对应模板名称")
    private String templateName;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public T getMailContent() {
        return mailContent;
    }

    public void setMailContent(T mailContent) {
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
