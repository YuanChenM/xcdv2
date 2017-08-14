package com.framework.validator.process;

import com.framework.validator.enums.ValidatorMethod;

import java.io.Serializable;

/**
 * @param <T>
 * @author liu_tao2
 * @version 1.0
 */
public final class ValidatorProcessFactory<T extends Serializable> {

    private ValidatorMethod validatorMethod;

    public ValidatorProcessFactory(ValidatorMethod validatorMethod) {
        this.validatorMethod = validatorMethod;
    }

    public BaseValidatorProcess createValidatorProcess() {
        if (ValidatorMethod.CUSTOM.equals(this.validatorMethod)) {
            return new CustomValidatorProcess<T>();
        } else if (ValidatorMethod.ANNOTATION.equals(this.validatorMethod)) {
            return new AnnotationValidatorProcess();
        }
        return new XmlValidatorProcess();
    }

}
