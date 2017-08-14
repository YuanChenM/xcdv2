package com.framework.base.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationEventListener implements ApplicationListener {
    private static Logger logger = LoggerFactory.getLogger(ApplicationEventListener.class);

    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        ApplicationEventInitialize applicationEventInitialize = new ApplicationEventInitialize(applicationEvent);
        applicationEventInitialize.initialize();
    }
}
