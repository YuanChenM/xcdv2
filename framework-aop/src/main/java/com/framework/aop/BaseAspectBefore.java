package com.framework.aop;

import org.aspectj.lang.JoinPoint;

/**
 *
 * @author jiang_nan
 * @version 1.0
 */
public interface BaseAspectBefore extends BaseAspect{

    void before(JoinPoint jp);
}
