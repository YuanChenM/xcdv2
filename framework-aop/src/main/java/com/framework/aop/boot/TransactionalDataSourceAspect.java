package com.framework.aop.boot;

import com.framework.aop.BaseAspectAfter;
import com.framework.aop.BaseAspectBefore;
import com.framework.aop.boot.dynamic.datasource.DatabaseContextHolder;
import com.framework.base.consts.StringConst;
import com.framework.exception.SystemException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态数据源
 *
 * @author zhou_yajun
 * @version 1.0
 */
@Aspect
@Component
public class TransactionalDataSourceAspect implements BaseAspectBefore, BaseAspectAfter, Ordered {
    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(TransactionalDataSourceAspect.class);
    private static Map<String, String> DATA_SOURCE_MAP = new HashMap();

    @Pointcut("execution(public * com.bms.*.services.*.*(..))")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void before(JoinPoint jp) {
        String customerType = DatabaseContextHolder.getCustomerType();
        if (!StringUtils.isEmpty(customerType)) {
            return;
        }
        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();
        Class<?> clazz = signature.getDeclaringType();
        String clazzName = clazz.getSimpleName();
        this.setDataSource(method, clazzName);
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        DatabaseContextHolder.clearCustomerType();
    }

    public void setDataSource(Method method, String className) {
        String methodName = method.getName();
        String key = className + StringConst.DOT + methodName;
        logger.info("TransactionalDataSourceAspect get method and class:" + key);
        String dataSourceName = DATA_SOURCE_MAP.get(key);
        if (!StringUtils.isEmpty(dataSourceName)) {
            DatabaseContextHolder.setCustomerType(dataSourceName);
            return;
        }
        Transactional transactional = method.getAnnotation(Transactional.class);
        if (transactional != null) {
            boolean readOnly = transactional.readOnly();
            if (readOnly) {
                dataSourceName = DatabaseContextHolder.SLAVE_DATA_SOURCE;
            } else {
                dataSourceName = DatabaseContextHolder.MASTER_DATA_SOURCE;
            }
        } else {
            logger.error("TransactionalDataSourceAspect have not found transaction.");
            throw new SystemException("兄弟没加事务啊。。");
        }
        logger.info("TransactionalDataSourceAspect get dataSourceName:" + dataSourceName);
        DatabaseContextHolder.setCustomerType(dataSourceName);
        DATA_SOURCE_MAP.put(key, dataSourceName);
    }

    public int getOrder() {
        return 0;
    }
}
