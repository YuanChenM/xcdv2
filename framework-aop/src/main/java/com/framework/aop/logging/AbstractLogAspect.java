package com.framework.aop.logging;

import com.framework.aop.BaseAspectAround;
import com.framework.aop.BaseAspectBefore;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * <p>AOP抽象类，提供获得方法、参数等的公共方法。</p>
 *
 * @Author xia_xiaojie
 * @CreateDate 2016/10/31
 * @Version 1.0
 */
public abstract class AbstractLogAspect implements BaseAspectAround, BaseAspectBefore {
    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(AbstractLogAspect.class);

    /**
     * 日志格式，JSON、XML和文本
     */
    protected enum LogType {
        JSON,
        XML,
        PLAIN
    }

    /**
     * <p>获得目标方法的完整方法名。</p>
     *
     * @param joinPoint 切入点
     * @return 类名.方法名
     */
    protected String getMethodName(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        return className + "." + methodName;
    }

    /**
     * <p>获得目标方法。</p>
     *
     * @param joinPoint 切入点
     * @return 目标方法
     */
    protected Method getMethod(JoinPoint joinPoint) {
        try {
            String methodName = joinPoint.getSignature().getName();
            Object[] args = joinPoint.getArgs();
            String className = joinPoint.getTarget().getClass().getName();
            Class clazz = Class.forName(className);
            Method[] methods = clazz.getDeclaredMethods();

            Method target = null;
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    Class[] classes = method.getParameterTypes();
                    if (classes.length == args.length) {
                        target = method;
                        break;
                    }
                }
            }
            return target;
        } catch (Exception e) {
            logger.debug("AbstractBaseAspect getMethod Exception: {}", e.toString());
            return null;
        }
    }

    /**
     * <p>获得参数类型的Class对象。</p>
     *
     * @param method 目标方法
     * @return 参数类型的Class对象数组
     */
    protected Class[] getParameterClasses(Method method) {
        if (null == method) {
            return new Class[] {};
        }
        Class[] classes = method.getParameterTypes();
        return (null == classes) ? new Class[] {} : classes;
    }

    /**
     * <p>获得参数类型的名称。</p>
     *
     * @param method 目标方法
     * @return 参数类型的名称数组
     */
    protected String[] getParameterTypes(Method method) {
        Class[] classes = this.getParameterClasses(method);
        int length = classes.length;
        String[] names = new String[length];
        for (int i = 0; i < length; ++i) {
            names[i] = classes[i].getName();
        }
        return names;
    }

    /**
     * <p>获得参数值。</p>
     *
     * @param joinPoint 切入点
     * @return 参数值数组
     */
    protected Object[] getParameters(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        return (null == args) ? new Object[] {} : args;
    }

}
