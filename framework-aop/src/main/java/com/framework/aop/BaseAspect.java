package com.framework.aop;

/**
 * AOP接口,所有实现Spring AOP的时候必须实现该接口.<p/>
 * 实现的类,必须在pointcut上面添加@Pointcut注解.<p/>
 * 实现的类上面必须添加@Aspect注解.
 * @author jiang_nan
 * @author rong_ting
 * @version 1.0
 */
public interface BaseAspect {
    /**
     * AOP规则.<br/>
     * 使用@Pointcut注解.
     */
    void pointcut();
}
