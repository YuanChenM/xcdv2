package com.framework.aop.validator;

import com.framework.aop.BaseAspectBefore;
import com.framework.exception.ValidatorException;
import com.framework.exception.bean.ExceptionMessage;
import com.framework.exception.bean.ValidatorExceptionMessage;
import com.framework.validator.BaseValidator;
import com.framework.validator.annotation.Validator;
import com.framework.validator.enums.ValidatorLevel;
import com.framework.validator.enums.ValidatorMethod;
import com.framework.validator.process.BaseValidatorProcess;
import com.framework.validator.process.ValidatorProcessFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liu_tao2
 * @version 1.0
 */
@Aspect
@Component
public class ValidatorAspect implements BaseAspectBefore {

    @Pointcut("@annotation(com.framework.validator.annotation.Validator)")
    public void pointcut() {

    }


    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Object[] args = joinPoint.getArgs();
        Validator validatorAnnotation = method.getAnnotation(Validator.class);
        if (validatorAnnotation != null) {

            //获得Validation Class
            Class<?> validatorClass = validatorAnnotation.validatorClass();

            ValidatorMethod validatorMethod = validatorAnnotation.validatorMethod();
            ValidatorProcessFactory validatorProcessFactory = new ValidatorProcessFactory(validatorMethod);
            //获得Validation Process类
            BaseValidatorProcess validatorProcess = validatorProcessFactory.createValidatorProcess();
            //获得Validator Class
            BaseValidator validator = validatorProcess.createValidator(validatorClass);
            //验证Param
            Object param = args[0];
            validator.validatorParam(param);

            //判断验证级别
            ValidatorLevel validatorLevel = validatorAnnotation.level();
            List<ExceptionMessage> messages =null;
            if (ValidatorLevel.EXCEPTION.equals(validatorLevel)) {
                messages = new ArrayList<>();
                List<ValidatorExceptionMessage> validatorExceptionMessages = validator.getExceptionMessageList();
                for (ValidatorExceptionMessage vem : validatorExceptionMessages) {
                    messages.add((ExceptionMessage) vem);
                }
                if (!CollectionUtils.isEmpty(validatorExceptionMessages)) {
                    throw new ValidatorException(messages);
                }
            } else {
                messages = new ArrayList<>();
                List<ValidatorExceptionMessage> validatorExceptionMessages = validator.getWarnMessageList();
                for (ValidatorExceptionMessage vem : validatorExceptionMessages) {
                    messages.add((ExceptionMessage) vem);
                }
                if (!CollectionUtils.isEmpty(validatorExceptionMessages)) {
                    throw new ValidatorException(messages);
                }
            }
        }
    }
}
