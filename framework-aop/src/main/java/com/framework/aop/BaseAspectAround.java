package com.framework.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 * @author jiang_nan
 * @version 1.0
 */
public interface BaseAspectAround extends BaseAspect{
    Object around(ProceedingJoinPoint pjp);
}
