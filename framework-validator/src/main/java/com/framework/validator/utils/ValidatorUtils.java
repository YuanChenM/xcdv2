package com.framework.validator.utils;


import com.framework.core.utils.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * validator公共方法类
 *
 * @author liu_tao2
 * @version 1.0
 */
public class ValidatorUtils {

    /**
     * 校验邮件的正则表达式
     */
    private static final String MAIL_REGEX = "^([a-z0-9A-Z]+[-_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    /**
     * 校验整数的正则表达式
     */
    private static final String NUMBER_REGEX = "^-?[1-9]\\d*$";
    /**
     * 校验数字的正则表达式
     */
    private static final String DECIMAL_REGEX = "^-?([1-9]+[0-9]*|0)(\\.[\\d]+)?$";
    /**
     * 校验电话的正则表达式
     */
    private static final String PHONE_REGEX = "^(\\d{3,4}-?)?\\d{7,9}$";

    /**
     * 校验手机号的正则表达式
     */
    private static final String MOBILE_REGEX = "^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\\d{8})$";

    /**
     * 校验整数的正则表达式
     */
    private static final String INTEGER_REGEX = "^(\\+|-)?\\d+$";

    /**
     * 用正则表达式校验邮件格式
     *
     * @param mailAddress 需要校验的值
     * @return
     */
    public static boolean checkMail(String mailAddress) {
        return checkPattern(mailAddress, MAIL_REGEX);
    }

    /**
     * 用正则表达式校验数字
     *
     * @param decimal 需要校验的值
     * @return
     */
    public static boolean checkDecimal(String decimal) {
        return checkPattern(decimal, DECIMAL_REGEX);
    }

    /**
     * 用正则表达式校验整数
     *
     * @param number 需要校验的值
     * @return
     */
    public static boolean checkNumber(String number) {
        return checkPattern(number, NUMBER_REGEX);
    }

    /**
     * 校验正整数
     *
     * @param number 需要校验的值
     * @return
     */
    public static boolean checkInteger(String number) {
        return checkPattern(number, INTEGER_REGEX);
    }

    /**
     * 检查数据的时间格式是否正确
     *
     * @param value  验证的数据
     * @param format 时间转换格式
     * @return check result (true is check ok)
     */
    public static boolean checkDateStr(String value, String format) {
        if (null == DateUtils.parse(format, value)) {
            return false;
        }
        return true;
    }

    /**
     * 限制必须是一个将来的日期
     *
     * @param value  验证的数据
     * @param format 时间转换格式
     * @return
     */
    public static boolean checkFutureDate(String value, String format) {
        if (!checkDateStr(value, format)) {
            return false;
        }

        if (!DateUtils.parse(format, value).after(DateUtils.getCurrent())) {
            return false;
        }
        return true;
    }

    /**
     * 限制必须为一个不大于指定值的数字
     *
     * @param value    验证的数据
     * @param maxValue 最大值
     * @return
     */
    public static boolean checkDecimalMax(BigDecimal value, BigDecimal maxValue) {
        if (isNull(value) || isNull(maxValue)) {
            return false;
        }
        if (value.compareTo(maxValue) >= 0) {
            return false;
        }
        return true;
    }

    /**
     * 限制必须为一个不小于指定值的数字
     *
     * @param value    验证的数据
     * @param minValue 最小值
     * @return
     */
    public static boolean checkDecimalMin(BigDecimal value, BigDecimal minValue) {
        if (isNull(value) || isNull(minValue)) {
            return false;
        }
        if (value.compareTo(minValue) <= 0) {
            return false;
        }
        return true;
    }

    /**
     * 正则表达式检验
     *
     * @param value 验证的数据
     * @param regex 正则表达式
     * @return
     */
    public static boolean checkPattern(String value, String regex) {
        if (isNull(value) || isNull(regex)) {
            return false;
        }
        return RegexUtils.matchs(regex, value);
    }

    /**
     * 限制字符长度必须不大于最大值
     *
     * @param value     验证的数据
     * @param maxLength 最大长度
     * @return
     */
    public static boolean checkMaxSize(String value, int maxLength) {
        if (isNull(value)) {
            return false;
        }
        if (value.length() >= maxLength) {
            return false;
        }
        return true;
    }

    /**
     * 限制字符长度必须不小于最小值
     *
     * @param value     验证的数据
     * @param minLength 最短长度
     * @return
     */
    public static boolean checkMinSize(String value, int minLength) {
        if (isNull(value)) {
            return false;
        }

        if (value.length() <= minLength) {
            return false;
        }
        return true;
    }

    /**
     * 检查数据是否在最大值和最小值之间
     *
     * @param value    验证的数据
     * @param maxValue 最大值
     * @param minValue 最小值
     * @return
     */
    public static boolean checkBetween(BigDecimal value, BigDecimal maxValue, BigDecimal minValue) {
        if (DecimalUtils.ge(value, maxValue) || DecimalUtils.ge(minValue, value)) {
            return false;
        }
        return true;
    }

    /**
     * 联系电话(手机/电话皆可)验证
     *
     * @param value
     * @return
     */
    public final static boolean isTel(String value) {
        if (isMobile(value) || isPhone(value)) {
            return true;
        }
        return false;
    }

    /**
     * 电话号码验证
     *
     * @param value
     * @return
     */
    public final static boolean isPhone(String value) {
        return checkPattern(value, PHONE_REGEX);
    }

    /**
     * 手机号码验证
     *
     * @param value
     * @return
     */
    public final static boolean isMobile(String value) {
        if (value.length() != 11) {
            return false;
        }
        return checkPattern(value, MOBILE_REGEX);
    }

    /**
     * 判断数据是否为空
     *
     * @param value 验证的数据
     * @return
     */
    public static boolean isNull(Object value) {
        boolean isEmpty = false;
        if (value == null) {
            isEmpty = true;
        } else if (value.getClass().isArray() && ArrayUtils.isEmpty((Object[]) value)) {
            isEmpty = true;
        } else if (value instanceof String && StringUtils.isEmpty((String) value)) {
            isEmpty = true;
        } else if (value instanceof List && CollectionUtils.isEmpty((List) value)) {
            isEmpty = true;
        } else if (value instanceof Map && ((Map) value).size() == 0) {
            isEmpty = true;
        }
        return isEmpty;
    }

    /**
     * 得到两个Integer类型的区间数组
     *
     * @param maxNum 最大值
     * @param minNum 最小值
     * @return
     */
    public static String[] getIntegerBetween(Integer maxNum, Integer minNum) {
        if (null == maxNum) {
            maxNum = Integer.MAX_VALUE;
        }

        if (null == minNum) {
            minNum = Integer.MIN_VALUE;
        }
        return new String[]{String.valueOf(minNum), String.valueOf(maxNum)};
    }

    /**
     * 得到两个Long类型的区间数组
     *
     * @param maxNum 最大值
     * @param minNum 最小值
     * @return
     */
    public static String[] getLongBetween(Long maxNum, Long minNum) {
        if (null == maxNum) {
            maxNum = Long.MAX_VALUE;
        }

        if (null == minNum) {
            minNum = Long.MIN_VALUE;
        }
        return new String[]{String.valueOf(minNum), String.valueOf(maxNum)};
    }
}
