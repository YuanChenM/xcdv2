package com.framework.validator.utils;

/**
 * 字符串类型的验证工具类
 *
 * @author liu_tao2
 * @version 1.0
 */
public final class StringValidator {

    /**
     * 验证指定的字段值是否为空
     *
     * @param value 验证的数据
     * @return
     */
    public static boolean validatorRequired(Object value) {
        boolean isNull = false;
        if (ValidatorUtils.isNull(value)) {
            isNull = true;
        }
        return isNull;
    }

    /**
     * 验证指定的字段值是否超过最大长度
     *
     * @param value     验证的数据
     * @param maxLength 最大长度
     */
    public static boolean validatorMaxLength(String value, int maxLength) {
        if (validatorRequired(value)) {
            return false;
        }
        return ValidatorUtils.checkMaxSize(value, maxLength);
    }

    /**
     * 验证指定的字段值是否小于最小长度
     *
     * @param value     验证的数据
     * @param minLength 最小长度
     */
    public static boolean validatorMinLength(String value, int minLength) {
        if (validatorRequired(value)) {
            return false;
        }
        return ValidatorUtils.checkMinSize(value, minLength);
    }

    /**
     * 验证指定的字段值是否合法Email地址
     *
     * @param value 验证的数据
     */
    public static boolean validatorEmail(String value) {
        if (validatorRequired(value)) {
            return false;
        }
        return ValidatorUtils.checkMail(value);
    }

    /**
     * 验证指定的字段值是否合法电话
     *
     * @param value 验证的数据
     */
    public static boolean validatorPhone(String value) {
        if (validatorRequired(value)) {
            return false;
        }
        return ValidatorUtils.isTel(value);
    }

    /**
     * 验证值的正则表达式
     *
     * @param value 需要验证的值
     * @param regex 正则表达式
     */
    public static boolean validatorPattern(String value, String regex) {
        if (validatorRequired(value)) {
            return false;
        }
        if (ValidatorUtils.isNull(regex)) {
            return false;
        }
        return ValidatorUtils.checkPattern(value, regex);
    }


}
