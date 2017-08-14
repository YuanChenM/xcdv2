package com.framework.core.utils;

import java.lang.reflect.Method;

/**
 * <p>反射方法工具类。</p>
 *
 * @Author xia_xiaojie
 * @CreateDate 2016/10/21
 * @Version 1.0
 */
public final class MethodUtils extends org.apache.commons.lang3.reflect.MethodUtils {

    public static Method getDeclaredMethod(Class<?> clazz, String methodName){
        Method[] methodList = clazz.getDeclaredMethods();
        Method method = null;
        for (Method declaredMethod : methodList) {
            String declaredMethodName = declaredMethod.getName();
            if (declaredMethodName.equals(methodName)) {
                method = declaredMethod;
                break;
            }
        }
        return method;
    }

}
