package com.framework.base.listener.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationFailedEvent;

import com.framework.base.listener.IApplicationEvent;

public class ApplicationFailedEventImpl implements IApplicationEvent<ApplicationFailedEvent> {
    private static Logger logger = LoggerFactory.getLogger(ApplicationFailedEventImpl.class);

    @Override
    public void init(ApplicationFailedEvent applicationEvent) {
        logger.info("**********************************");
        logger.info("*****哈哈哈，配置有错，跪了吧*****");
        logger.info("**********************************");
        Throwable throwable = applicationEvent.getException();
        handleThrowable(throwable);
    }

    /* 处理异常 */
    private void handleThrowable(Throwable throwable) {}
}
