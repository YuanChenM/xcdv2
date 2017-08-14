package com.framework.base.listener.Impl;

import com.framework.base.utils.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;

import com.framework.base.listener.IApplicationEvent;

public class ApplicationReadyEventImpl implements IApplicationEvent<ApplicationReadyEvent> {
    private static Logger logger = LoggerFactory.getLogger(ApplicationReadyEventImpl.class);

    public void init(ApplicationReadyEvent applicationEvent) {
        SpringContextUtil springContextUtil = new SpringContextUtil();
        springContextUtil.setApplicationContext(applicationEvent.getApplicationContext());
    }

}
