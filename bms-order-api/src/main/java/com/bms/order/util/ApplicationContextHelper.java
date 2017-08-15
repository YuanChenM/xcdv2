package com.bms.order.util;

import org.springframework.context.ApplicationContext;

public class ApplicationContextHelper {

    private static ApplicationContext _applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        _applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return _applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        T object = _applicationContext.getBean(clazz);
		return object;
	}

}
