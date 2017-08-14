package com.framework.validator.process;

import com.framework.exception.SystemException;
import com.framework.validator.BaseValidator;

/**
 * @author liu_tao2
 * @version 1.0
 */
public abstract class BaseValidatorProcess {
    public BaseValidator createValidator(Class validatorClazz) {
        try {
            return (BaseValidator) validatorClazz.newInstance();
        } catch (InstantiationException e) {
            throw new SystemException(e);
        } catch (IllegalAccessException e) {
            throw new SystemException(e);
        }
    }
}
