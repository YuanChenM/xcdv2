package com.framework.core.file.mail;

import com.framework.exception.SystemException;
import org.apache.commons.mail.*;

/**
 * 邮件工厂类
 *
 * @author liu_tao2
 * @version 1.0
 */
public class MailFactory {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    private String hostName;
    private int smtpPort;
    private String fromMail;
    private String authPwd;
    private String authUserName;
    private int socketConnectionTimeout;
    private int socketTimeout;
    /**
     * 邮件发送人名称
     */
    private String sender;

    /**
     * The Constructors Method.
     *
     * @author jiang_nan
     */
    public MailFactory(String hostName, int smtpPort, String fromMail, String authPwd, String authUserName,
                       String sender) {
        this.hostName = hostName;
        this.smtpPort = smtpPort;
        this.fromMail = fromMail;
        this.authPwd = authPwd;
        this.authUserName = authUserName;
        this.sender = sender;
    }

    /**
     * The Constructors Method.
     *
     * @author jiang_nan
     */
    public MailFactory() {

    }

    /**
     * 创建普通的Mail,只支持普通简单的邮件发送
     *
     * @return simpleEmail
     * @throws EmailException the EmailException
     * @author jiang_nan
     */
    public Email createSimpleEmail() throws EmailException {
        Email simpleEmail = new SimpleEmail();
        this.initMailParam(simpleEmail);
        return simpleEmail;
    }

    /**
     * 创建包含附件的Mail
     *
     * @return MultiPartEmail
     * @throws EmailException the EmailException
     * @author jiang_nan
     */
    public Email createMultiPartEmail() throws EmailException {
        Email multiPartEmail = new MultiPartEmail();
        this.initMailParam(multiPartEmail);
        return multiPartEmail;
    }

    /**
     * 创建HTML格式的邮件
     *
     * @return HtmlEmail
     * @throws EmailException the EmailException
     * @author jiang_nan
     */
    public Email createHtmlEmail() throws EmailException {
        Email htmlEmail = new HtmlEmail();
        this.initMailParam(htmlEmail);
        return htmlEmail;
    }

    /**
     * 初始化Mail参数
     *
     * @param mail Mail对象
     * @throws EmailException the EmailException
     * @author jiang_nan
     */
    private void initMailParam(Email mail) throws EmailException {
        if (mail == null) {
            throw new SystemException("system.error.mailNull");
        }
        mail.setHostName(this.hostName);
        mail.setSmtpPort(this.smtpPort);
        mail.setAuthentication(this.authUserName, this.authPwd);// 邮件服务器验证：用户名/密码
        mail.setCharset("UTF-8");// 必须放在前面，否则乱码
        mail.setFrom(this.fromMail, this.sender);
        mail.setSocketConnectionTimeout(socketConnectionTimeout);
        mail.setSocketTimeout(socketTimeout);
    }
}
