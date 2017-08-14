package com.framework.validator.annotation;


import com.framework.validator.enums.ValidatorLevel;
import com.framework.validator.enums.ValidatorMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liu_tao2
 * @version 1.0
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Validator {
    Class validatorClass();

    ValidatorMethod validatorMethod() default ValidatorMethod.CUSTOM;

    ValidatorLevel level() default ValidatorLevel.EXCEPTION;
}
