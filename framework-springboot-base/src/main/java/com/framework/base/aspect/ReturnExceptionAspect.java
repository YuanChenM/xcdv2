package com.framework.base.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.framework.base.bean.RestResponse;

/**
 * @deprecated
 * <p>切面处理，用于处理异常。</p>
 * @author zhangjian3
 * @version 1.0
 * @CreateDate 2016/10/26
 */
//@Aspect
//@Component
@Deprecated
public class ReturnExceptionAspect {

    private static Logger logger = LoggerFactory.getLogger(ReturnExceptionAspect.class);

    @Pointcut("execution(com.framework.base.bean.RestResponse com.msk.*.rest.*RestController.*(..))")
    public void returnException() {}

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void controllerAspect() {}

    /**
     * 对restController异常处理
     *
     * @param pjp
     * @return Object
     */
    @Around("returnException() && controllerAspect()")
    public Object doAfterThrowing(ProceedingJoinPoint pjp) throws Throwable {
        if (logger.isInfoEnabled()) {
            logger.info("rest接口 处理开始[{}]", pjp.toString());
        }
        Object result = null;
        try {
            Object target = pjp.getTarget();
            long startTime = System.currentTimeMillis();
            result = pjp.proceed();
            long endTime = System.currentTimeMillis();
            logger.info("方法:" + target.getClass().getName() + "." + pjp.getSignature().getName() + "花费时间:"
                    + (endTime - startTime));
        } catch (Exception e) {
            RestResponse response = new RestResponse();
            if (logger.isErrorEnabled()) {
                logger.error("参数发生错误:{}", e);
            }
            result = this.ex2msg(e, response);
        }

        return result;
    }

    /**
     * 异常信息转消息
     *
     * @param ex 异常对象
     * @param response 结果对象
     * @return 结果对象
     */
    protected RestResponse ex2msg(Throwable ex, RestResponse response) {
        response.setMessage(ex.getMessage());
        return response;
    }
}
