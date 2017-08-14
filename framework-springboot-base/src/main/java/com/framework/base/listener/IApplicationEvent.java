package com.framework.base.listener;

import org.springframework.context.ApplicationEvent;

public interface IApplicationEvent<T extends ApplicationEvent > {
    void init(T applicationEvent);
}
