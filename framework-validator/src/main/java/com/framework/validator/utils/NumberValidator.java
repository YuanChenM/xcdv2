package com.framework.validator.utils;

import com.framework.base.consts.NumberConst;
import com.framework.base.consts.StringConst;
import com.framework.core.utils.DecimalUtils;

import java.math.BigDecimal;

/**
 * 数字类型验证的工具类
 *
 * @author liu_tao2
 * @version 1.0
 */
public final class NumberValidator {

    /**
     * sign输入4表示可以为正数
     */
    public static final int POSITIVE = 4; // 1 0 0
    /**
     * sign输入2表示可以为负数
     */
    public static final int NEGATIVE = 2; // 0 1 0
    /**
     * sign输入1表示可以为0
     */
    public static final int ZERO = 1; // 0 0 1
    /**
     * sign输入3表示是非正数
     */
    public static final int NOT_POSITIVE = 3; // 0 1 1

    /**
     * sign输入5表示是非负数
     */
    public static final int NOT_NEGATIVE = 5; // 1 0 1
    /**
     * sign输入6表示不能为0
     */
    public static final int NOT_ZERO = 6; // 1 1 0

    /**
     * sign输入7表示可以为所有数
     */
    public static final int ALL = 7; // 1 1 1

    /**
     * 验证指定的字段值是否为整数
     *
     * @param value 验证的数据
     */
    public static boolean validatorNumber(String value) {
        if (ValidatorUtils.isNull(value)) {
            return false;
        }

        return ValidatorUtils.checkNumber(value);
    }

    /**
     * 验证指定的字段值是否为数字
     *
     * @param value 验证的数据
     */
    public static boolean validatorDecimal(String value) {
        if (ValidatorUtils.isNull(value)) {
            return false;
        }

        return ValidatorUtils.checkDecimal(value);
    }

    /**
     * 验证指定的字段值是否超过最大值
     *
     * @param value    验证的数据
     * @param maxValue 最大值
     */
    public static boolean validatorMax(BigDecimal value, BigDecimal maxValue) {
        return ValidatorUtils.checkDecimalMax(value, maxValue);
    }

    /**
     * 验证指定的字段值是小于最小值
     *
     * @param value    验证的数据
     * @param minValue 最小值
     */
    public static boolean validatorMin(BigDecimal value, BigDecimal minValue) {
        return ValidatorUtils.checkDecimalMin(value, minValue);
    }

    /**
     * 检查数值区间
     *
     * @param value    当前值
     * @param maxValue 最大值
     * @param minValue 最小值
     */
    public static boolean validatorBetween(BigDecimal value, BigDecimal maxValue, BigDecimal minValue) {
        return ValidatorUtils.checkBetween(value, maxValue, minValue);
    }

    /**
     * 检查数值区间(Integer类型)
     *
     * @param value    当前值
     * @param maxValue 最大值
     * @param minValue 最小值
     */
    public static boolean validatorIntegerBetween(String value, Integer maxValue, Integer minValue) {
        if (ValidatorUtils.isNull(value)) {
            return false;
        }
        if (DecimalUtils.toBigDecimal(value).compareTo(DecimalUtils.toBigDecimal(Integer.MAX_VALUE)) >= NumberConst.IntDef.INT_ZERO
                || DecimalUtils.toBigDecimal(value).compareTo(DecimalUtils.toBigDecimal(Integer.MIN_VALUE)) <= NumberConst.IntDef.INT_ZERO) {
            return false;
        }
        if (null != maxValue) {
            return !(Integer.valueOf(value) >= maxValue);
        }

        if (null != minValue) {
            return !(Integer.valueOf(value) <= minValue);
        }
        return true;
    }

    /**
     * 检查数值区间
     *
     * @param value    当前值
     * @param maxValue 最大值
     * @param minValue 最小值
     */
    public static boolean validatorLongBetween(String value, Long maxValue, Long minValue) {
        if (ValidatorUtils.isNull(value)) {
            return false;
        }
        if (DecimalUtils.toBigDecimal(value).compareTo(DecimalUtils.toBigDecimal(Long.MAX_VALUE)) >= NumberConst.IntDef.INT_ZERO
                || DecimalUtils.toBigDecimal(value).compareTo(DecimalUtils.toBigDecimal(Long.MIN_VALUE)) <= NumberConst.IntDef.INT_ZERO) {
            return false;
        }
        if (null != maxValue) {
            return !(Long.valueOf(value) >= maxValue);
        }

        if (null != minValue) {
            return !(Long.valueOf(value) <= minValue);
        }
        return true;
    }

    /**
     * 检查数值区间
     *
     * @param value 当前值
     * @param maxM  最大长度
     * @param maxD  小数位最大长度
     */
    public static boolean validatorDecimalBetween(String value, Integer maxM, Integer maxD) {
        if (ValidatorUtils.isNull(value)) {
            return false;
        }
        BigDecimal digitValue = new BigDecimal(value);
        value = digitValue.abs().toPlainString();
        String[] splitValue = value.split("\\.");
        String beforeDot = splitValue[NumberConst.IntDef.INT_ZERO];
        String afterDot = splitValue.length == NumberConst.IntDef.INT_TWO ? splitValue[NumberConst.IntDef.INT_ONE] : "";
        if (!validatorDecimalLength(beforeDot, maxM - maxD) || !validatorDecimalLength(afterDot, maxD)) {
            return false;
        }
        return true;
    }

    /**
     * 验证数字类型的最大长度
     *
     * @param value     需要验证的字符串数字
     * @param maxLength 最大长度
     * @return
     */
    public static boolean validatorDecimalLength(String value, Integer maxLength) {
        if (value != null && maxLength != null && value.length() > maxLength) {
            return false;
        }
        return true;
    }

    /**
     * 检验是否为需要的整数类型
     *
     * @param value 整数类型的字符串
     * @param sign  你需要的整数
     * @return
     */
    public static boolean checkInteger(String value, int sign) {
        return checkInteger(value, (sign & POSITIVE) > NumberConst.IntDef.INT_ZERO,
                (sign & NEGATIVE) > NumberConst.IntDef.INT_ZERO, (sign & ZERO) > NumberConst.IntDef.INT_ZERO);
    }

    /**
     * 检验证书
     *
     * @param value       需要验证的整数类型字符串
     * @param canPositive 是否可以为正整数
     * @param canNegative 是否可以为负整数
     * @param canZero     是否可以为0
     * @return
     */
    public static boolean checkInteger(String value, boolean canPositive, boolean canNegative, boolean canZero) {
        if (ValidatorUtils.isNull(value)) {
            return false;
        }
        value = value.replaceAll(StringConst.COMMA, StringConst.EMPTY);
        if (!ValidatorUtils.checkInteger(value)) {
            return false;
        }
        // sign check
        BigDecimal digitValue = new BigDecimal(value);
        if (DecimalUtils.gt(digitValue, BigDecimal.ZERO) && !canPositive) {
            return false;
        }
        if (DecimalUtils.lt(digitValue, BigDecimal.ZERO) && !canNegative) {
            return false;
        }
        if (DecimalUtils.eq(digitValue, BigDecimal.ZERO) && !canZero) {
            return false;
        }
        return true;
    }

    /**
     * 检验数字类型的字符串是否满足你需要的
     *
     * @param value 需要验证的数字类型字符串
     * @param sign  你需要的数字类型
     * @return
     */
    public static boolean checkDecimal(String value, int sign) {
        return checkDecimal(value, (sign & POSITIVE) > NumberConst.IntDef.INT_ZERO,
                (sign & NEGATIVE) > NumberConst.IntDef.INT_ZERO, (sign & ZERO) > NumberConst.IntDef.INT_ZERO);
    }

    /**
     * 检验数字类型的字符串是否满足要求
     *
     * @param value       需要验证的数字类型字符串
     * @param canPositive 是否可以为正整数
     * @param canNegative 是否可以为负整数
     * @param canZero     是否可以为0
     * @return
     */
    public static boolean checkDecimal(String value, boolean canPositive, boolean canNegative, boolean canZero) {
        // null check
        if (value == null) {
            return false;
        }
        // remove comma
        value = value.replaceAll(StringConst.COMMA, StringConst.EMPTY);
        if (!ValidatorUtils.checkDecimal(value)) {
            return false;
        }
        // sign check
        BigDecimal digitValue = new BigDecimal(value);
        if (DecimalUtils.gt(digitValue, BigDecimal.ZERO) && !canPositive) {
            return false;
        }
        if (DecimalUtils.lt(digitValue, BigDecimal.ZERO) && !canNegative) {
            return false;
        }
        if (DecimalUtils.eq(digitValue, BigDecimal.ZERO) && !canZero) {
            return false;
        }
        return true;
    }
}
