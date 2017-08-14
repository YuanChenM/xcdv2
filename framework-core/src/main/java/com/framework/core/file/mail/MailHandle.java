package com.framework.core.file.mail;

import com.framework.core.file.FileUtils;
import com.framework.exception.SystemException;
import org.apache.commons.mail.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * mail处理类
 *
 * @author liu_tao2
 * @version 1.0
 */
public class MailHandle {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(MailHandle.class);

    /**
     * 发送普通邮件，没有任何格式的。
     *
     * @param title   标题
     * @param context 内容
     * @param emails  收信人Mail
     * @author Administrator
     */
    public static void sendSimpleEmail(String title, String context, String... emails) {
        logger.info("发送Simple邮件");
        MailFactory mailFactory = new MailFactory();
        try {
            Email mail = mailFactory.createSimpleEmail();
            setToMailParam(mail, title, context, emails);
            mail.send();
        } catch (EmailException e) {
            SystemException systemException = new SystemException("system.mail.sendFail");
            systemException.initCause(e);
            throw systemException;
        }
    }

    /**
     * 发送附件邮件
     *
     * @param title    标题
     * @param context  内容
     * @param fileList 文件列表
     * @param emailCCs 抄送邮件列表
     * @param emails   收信人Mail
     * @author Administrator
     */
    public static void sendMultiPartEmail(String title, String context, File[] fileList, String[] emailCCs,
                                          String... emails) {
        logger.info("发送附件邮件");
        MailFactory mailFactory = new MailFactory();
        try {
            Email mail = mailFactory.createMultiPartEmail();
            setToMailParam(mail, title, context, emailCCs, emails);
            for (File file : fileList) {
                EmailAttachment attachment = new EmailAttachment();
                attachment.setPath(file.getAbsolutePath());// 本地文件
                attachment.setDisposition(EmailAttachment.ATTACHMENT);
                String fileName = FileUtils.getFileName(file);
                attachment.setDescription(fileName);
                attachment.setName(file.getName());
                ((MultiPartEmail) mail).attach(attachment);
            }
            mail.send();
        } catch (EmailException e) {
            SystemException systemException = new SystemException("system.mail.sendFail");
            systemException.initCause(e);
            throw systemException;
        }
    }

    /**
     * 发送HTML格式的邮件
     *
     * @param title       标题
     * @param htmlcontext 内容
     * @param emails      收信人列表
     */
    public static void sendHtmlEmail(String title, String htmlcontext, String... emails) {
        logger.info("发送HTML格式邮件");
        MailFactory mailFactory = new MailFactory();
        try {
            Email mail = mailFactory.createHtmlEmail();
            setToMailParam(mail, title, htmlcontext, emails);
            mail.send();
        } catch (EmailException e) {
            SystemException systemException = new SystemException("system.mail.sendFail");
            systemException.initCause(e);
            throw systemException;
        }
    }

    /**
     * 设置TO Mail的基本参数
     *
     * @param mail     mail
     * @param title    标题
     * @param context  内容
     * @param emailCCs 抄送邮件列表
     * @param emails   接受邮件列表
     * @throws EmailException the EmailException
     * @author Administrator
     */
    private static void setToMailParam(Email mail, String title, String context, String[] emailCCs, String... emails)
            throws EmailException {
        mail.addTo(emails);
        if (null != emailCCs && emailCCs.length != 0) {
            mail.addCc(emailCCs);
        }
        mail.setSubject(title);
        if (mail instanceof HtmlEmail) {
            ((HtmlEmail) mail).setHtmlMsg(context);
        } else {
            mail.setMsg(context);
        }
    }

    /**
     * 设置TO Mail的基本参数
     *
     * @param mail    mail
     * @param title   标题
     * @param context 内容
     * @param emails  接收邮件列表
     * @throws EmailException the EmailException
     */
    private static void setToMailParam(Email mail, String title, String context, String... emails)
            throws EmailException {
        mail.addTo(emails);
        mail.setSubject(title);
        if (mail instanceof HtmlEmail) {
            ((HtmlEmail) mail).setHtmlMsg(context);
        } else {
            mail.setMsg(context);
        }
    }
}
