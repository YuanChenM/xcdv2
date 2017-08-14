package com.msk.mail.config;

import com.framework.core.utils.NumberUtils;
import com.framework.core.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.util.Properties;

/**
 * Created by zhu_kai1 on 2017/2/14.
 */
@Configuration
public class MailSenderConfig {
    private static Logger logger = LoggerFactory.getLogger(MailSenderConfig.class);
    @Autowired
    private Environment env;

    @Bean(name = "JavaMailSender")
    public JavaMailSender getSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        final String userName = env.getProperty("spring.mail.username");
        final String host = env.getProperty("spring.mail.host");
        final String port = env.getProperty("spring.mail.port");
        final String auth = env.getProperty("spring.mail.properties.mail.smtp.auth");
        final String passWord = env.getProperty("spring.mail.password");
        // 是否启用ssl
        final String sslEnable = env.getProperty("spring.mail.properties.mail.ssl.enable");
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        // 是否启用proxy
        final String proxyEnable = env.getProperty("spring.mail.proxy.enable");
        final String proxyHost = env.getProperty("spring.mail.proxy.proxyHost");
        final String proxyPort = env.getProperty("spring.mail.proxy.proxyPort");

        javaMailSender.setUsername(userName);
        javaMailSender.setHost(host);
        javaMailSender.setPort(NumberUtils.toInt(port));
        javaMailSender.setDefaultEncoding("UTF-8");
        logger.info("JavaMailSender的userName:{},host:{},port:{},defaultEncoding:{}",
                javaMailSender.getUsername(), javaMailSender.getHost(), javaMailSender.getPort(), javaMailSender.getDefaultEncoding());
        Properties props = System.getProperties();
        // ssl
        props.setProperty("mail.smtp.auth", auth);
        if(StringUtils.isNotEmpty(sslEnable) && Boolean.valueOf(sslEnable)){
            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.ssl.enable", sslEnable);
        }
        logger.info("是否需要验证：{}是否启用ssl:{},socketFactory的class为：{}",auth,sslEnable,SSL_FACTORY);
        // proxy
        if(StringUtils.isNotEmpty(proxyEnable) && Boolean.valueOf(proxyEnable)){
            props.setProperty("proxySet",proxyEnable);
            props.setProperty("socksProxyHost",proxyHost);
            props.setProperty("socksProxyPort",proxyPort);
            logger.info("代理服务器：是否需要代理：{}，proxyHost:{},proxyPort:{}",proxyEnable,proxyHost,proxyPort);
        }

        javax.mail.Session session = javax.mail.Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, passWord);
            }
        });
        javaMailSender.setSession(session);
        return javaMailSender;
    }

}
