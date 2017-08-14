package com.framework.aop;

import org.aspectj.lang.JoinPoint;

/**
 * AOP After接口.<p>
 *
 * @author jiang_nan
 * @version 1.0
 */
public interface BaseAspectAfter extends BaseAspect{
    void after(JoinPoint joinPoint);
}
