package com.framework.base.controller;

import com.framework.base.service.MessageService;
import com.framework.base.service.impl.MessageServiceImpl;
import org.springframework.stereotype.Component;

/**
 * 得到固定service的实现类
 *
 * @author liu_tao2
 * @version 1.0
 */
@Component
public class MessageServiceFactory {

    private static MessageServiceFactory messageServiceFactory = null;

    private MessageServiceFactory() {

    }

    public static MessageServiceFactory getInstance() {
        if (null == messageServiceFactory) {
            messageServiceFactory = new MessageServiceFactory();
        }
        return messageServiceFactory;
    }

    /**
     * 得到需要的service实现类
     *
     * @param str
     * @return
     */
    public MessageService getMessageService(String str) {
        if (str.equals("messageservice")) {
            return new MessageServiceImpl();
        }
        return null;
    }

}
