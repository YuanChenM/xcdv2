package com.framework.validator.utils;

import com.framework.core.utils.DateUtils;

import java.util.Date;

/**
 * 日期类型验证的工具类
 *
 * @author liu_tao2
 * @version 1.0
 */
public final class DateValidator {

    /**
     * 验证指定的字段值日期类型输入的是否正确
     *
     * @param value  验证的数据
     * @param format 需要验证的时间格式
     */
    public static boolean validatorStrDate(String value, String format) {
        if (ValidatorUtils.isNull(value)) {
            return false;
        }
        return ValidatorUtils.checkDateStr(value, format);
    }

    /**
     * 验证指定字段值是否为日期类型
     *
     * @param date 验证的日期
     * @return
     */
    public static boolean validatorDate(Date date) {
        if (null == date) {
            return false;
        }
        return DateUtils.isValid(date);
    }
}
