package com.framework.base.listener.Impl;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import com.framework.base.listener.IApplicationEvent;

public class ApplicationEnvironmentPreparedEventImpl implements IApplicationEvent<ApplicationEnvironmentPreparedEvent> {
    private static Logger logger = LoggerFactory.getLogger(ApplicationEnvironmentPreparedEventImpl.class);

    @Override
    public void init(ApplicationEnvironmentPreparedEvent applicationEvent) {
        ConfigurableEnvironment envi = applicationEvent.getEnvironment();
        MutablePropertySources mps = envi.getPropertySources();
        if (mps != null) {
            Iterator<PropertySource<?>> iter = mps.iterator();
            while (iter.hasNext()) {
                PropertySource<?> ps = iter.next();
                logger.info("ps.getName:{};ps.getSource:{};ps.getClass:{}", ps.getName(), ps.getSource(),
                    ps.getClass());
            }
        }
    }
}
