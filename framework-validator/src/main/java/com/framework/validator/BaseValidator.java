package com.framework.validator;

import com.framework.exception.bean.ValidatorExceptionMessage;

import java.util.List;

/**
 * validator接口类
 *
 * @author liu_tao2
 * @version 1.0
 */
public interface BaseValidator {
    /**
     * 验证Controller和RestController的Param
     *
     * @param param 验证参数
     */
    void validatorParam(Object param);

    /**
     * 获得异常信息
     *
     * @return 异常信息
     */
    List<ValidatorExceptionMessage> getExceptionMessageList();

    /**
     * @return
     */
    List<ValidatorExceptionMessage> getWarnMessageList();

}
