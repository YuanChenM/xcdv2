package com.framework.base.listener;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;

import com.framework.base.listener.Impl.ApplicationEnvironmentPreparedEventImpl;
import com.framework.base.listener.Impl.ApplicationFailedEventImpl;
import com.framework.base.listener.Impl.ApplicationPreparedEventImpl;
import com.framework.base.listener.Impl.ApplicationReadyEventImpl;

public class ApplicationEventFactory {
    public IApplicationEvent createApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof ApplicationReadyEvent) {
            return new ApplicationReadyEventImpl();
        } else if (applicationEvent instanceof ApplicationPreparedEvent) {
            return new ApplicationPreparedEventImpl();
        } else if (applicationEvent instanceof ApplicationFailedEvent) {
            return new ApplicationFailedEventImpl();
        } else if (applicationEvent instanceof ApplicationEnvironmentPreparedEvent) {
            return new ApplicationEnvironmentPreparedEventImpl();
        }
        return null;
    }
}
