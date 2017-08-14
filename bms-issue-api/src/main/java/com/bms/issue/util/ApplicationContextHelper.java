package com.bms.issue.util;

import org.springframework.context.ApplicationContext;

public class ApplicationContextHelper {

    private static ApplicationContext _applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        _applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        T object = _applicationContext.getBean(clazz);
		return object;
	}

}
