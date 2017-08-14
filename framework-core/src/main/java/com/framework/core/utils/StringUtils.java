package com.framework.core.utils;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.MessageFormat;

/**
 * <p>字符串工具类，提供了各种处理字符串，将对象转化成字符串的方法。</p>
 * <p>名词解释，null：空指针，""：空字符串，" "：空格。</p>
 *
 * @Author xia_xiaojie
 * @CreateDate 2016/10/20
 * @Version 1.0
 */
public final class StringUtils extends org.apache.commons.lang3.StringUtils {
    /** #,##0 */
    private static final DecimalFormat DECIMAL0_FORMAT = new DecimalFormat("#,##0");
    /** #,##0.0 */
    private static final DecimalFormat DECIMAL1_FORMAT = new DecimalFormat("#,##0.0");
    /** #,##0.00 */
    private static final DecimalFormat DECIMAL2_FORMAT = new DecimalFormat("#,##0.00");
    /** #,##0.000 */
    private static final DecimalFormat DECIMAL3_FORMAT = new DecimalFormat("#,##0.000");
    /** #,##0.0000 */
    private static final DecimalFormat DECIMAL4_FORMAT = new DecimalFormat("#,##0.0000");
    /** #,##0.00000 */
    private static final DecimalFormat DECIMAL5_FORMAT = new DecimalFormat("#,##0.00000");
    /** #,##0.000000 */
    private static final DecimalFormat DECIMAL6_FORMAT = new DecimalFormat("#,##0.000000");

    /**
     * <p>保留0到任意位小数，四舍五入，整数位加千位分隔符。</p>
     * <pre>
     * StringUtils.formatNumber(-1, 123456.789) = "123,457"
     * StringUtils.formatNumber(0, 123456.789)  = "123,457"
     * StringUtils.formatNumber(2, null)        = ""
     * StringUtils.formatNumber(2, 123456.789)  = "123,456.79"
     * StringUtils.formatNumber(10, 123456.789) = "123,456.7890000000"
     * </pre>
     *
     * @param decimalDigit 保留位数
     * @param number Byte、Integer、BigDecimal等数字类型的对象
     * @return 若参数{@code number}是{@code null}，则返回{@code ""}，否则返回格式化数字后的字符串
     */
    public static String formatNumber(int decimalDigit, Object number) {
        if (null == number) {
            return "";
        }

        StringBuilder decimal = new StringBuilder();
        if (decimalDigit > 0) {
            decimal.append(".");
            for (int i = 0; i < decimalDigit; ++i) {
                decimal.append("0");
            }
        }

        DecimalFormat df = new DecimalFormat("#,##0" + decimal.toString());
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(number);
    }

    /**
     * <p>保留0到任意位小数，四舍五入，整数位加千位分隔符。</p>
     * <pre>
     * StringUtils.formatFigure(-1, 123456.789) = "123,457"
     * StringUtils.formatFigure(0, 123456.789)  = "123,457"
     * StringUtils.formatFigure(2, null)        = "0.00"
     * StringUtils.formatFigure(2, 123456.789)  = "123,456.79"
     * StringUtils.formatFigure(10, 123456.789) = "123,456.7890000000"
     * </pre>
     *
     * @param decimalDigit 保留位数
     * @param number Byte、Integer、BigDecimal等数字类型的对象
     * @return 返回格式化数字后的字符串
     */
    public static String formatFigure(int decimalDigit, Object number) {
        number = (null == number) ? 0 : number;
        return formatNumber(decimalDigit, number);
    }

    /**
     * <p>小数位数保持不变，不舍入，只在整数位加千位分隔符。</p>
     * <pre>
     * StringUtils.formatOnly(null)       = ""
     * StringUtils.formatOnly("3.4E-5")   = "3.4E-5"
     * StringUtils.formatOnly(123456)     = "123,456"
     * StringUtils.formatOnly(123456.789) = "123,456.789"
     * StringUtils.formatOnly(10.0)       = "10.0"
     * </pre>
     *
     * @param number Byte、Integer、BigDecimal等数字类型的对象
     * @return 若参数{@code number}是{@code null}，则返回{@code ""}，否则返回格式化数字后的字符串
     */
    public static String formatOnly(Object number) {
        if (null == number) {
            return "";
        }
        String[] strs = number.toString().split("\\.");
        String integerPlace = DECIMAL0_FORMAT.format(new BigDecimal(strs[0]));  //整数位
        String decimalPlace = (strs.length < 2) ? "" : "." + strs[1];           //小数位
        return integerPlace + decimalPlace;
    }

    /**
     * <p>保留0~6位小数，四舍五入，整数位加千位分隔符。</p>
     * <pre>
     * StringUtils.formatDecimal(-1, new BigDecimal(123456.789)) = "123,457"
     * StringUtils.formatDecimal(0, new BigDecimal(123456.789))  = "123,457"
     * StringUtils.formatDecimal(2, null)                        = ""
     * StringUtils.formatDecimal(2, new BigDecimal(123456.789))  = "123,456.79"
     * StringUtils.formatDecimal(10, new BigDecimal(123456.789)) = "123,456.789000"
     * </pre>
     *
     * @param decimalDigit 保留位数
     * @param decimal BigDecimal类型的数字
     * @return 若参数{@code decimal}是{@code null}，则返回{@code ""}，否则返回格式化数字后的字符串
     */
    public static String formatDecimal(int decimalDigit, BigDecimal decimal) {
        if (null == decimal) {
            return "";
        }

        DecimalFormat df;
        if (decimalDigit <= 0) {
            df = DECIMAL0_FORMAT;
        } else if (decimalDigit == 1) {
            df = DECIMAL1_FORMAT;
        } else if (decimalDigit == 2) {
            df = DECIMAL2_FORMAT;
        } else if (decimalDigit == 3) {
            df = DECIMAL3_FORMAT;
        } else if (decimalDigit == 4) {
            df = DECIMAL4_FORMAT;
        } else if (decimalDigit == 5) {
            df = DECIMAL5_FORMAT;
        } else {
            df = DECIMAL6_FORMAT;
        }

        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(decimal);
    }

    /**
     * <p>保留0位小数，四舍五入，整数位加千位分隔符。</p>
     * <pre>
     * StringUtils.formatInteger(null)                       = ""
     * StringUtils.formatInteger(new BigDecimal(123456))     = "123,456"
     * StringUtils.formatInteger(new BigDecimal(123456.789)) = "123,457"
     * </pre>
     *
     * @param decimal BigDecimal类型的数字
     * @return 若参数{@code decimal}是{@code null}，则返回{@code ""}，否则返回格式化数字后的字符串
     */
    public static String formatInteger(BigDecimal decimal) {
        return formatDecimal(0, decimal);
    }

    /**
     * <p>保留2位小数，四舍五入，整数位加千位分隔符。</p>
     * <pre>
     * StringUtils.formatMoney(null)                       = ""
     * StringUtils.formatMoney(new BigDecimal(123456))     = "123,456.00"
     * StringUtils.formatMoney(new BigDecimal(123456.789)) = "123,456.79"
     * </pre>
     *
     * @param amount BigDecimal类型的数字
     * @return 若参数{@code amount}是{@code null}，则返回{@code ""}，否则返回格式化数字后的字符串
     */
    public static String formatMoney(BigDecimal amount) {
        return formatDecimal(2, amount);
    }

    /**
     * <p>保留3位小数，四舍五入，整数位加千位分隔符。</p>
     * <pre>
     * StringUtils.formatWeight(null)                       = ""
     * StringUtils.formatWeight(new BigDecimal(123456))     = "123,456.000"
     * StringUtils.formatWeight(new BigDecimal(123456.789)) = "123,456.789"
     * </pre>
     *
     * @param weight BigDecimal类型的数字
     * @return 若参数{@code weight}是{@code null}，则返回{@code ""}，否则返回格式化数字后的字符串
     */
    public static String formatWeight(BigDecimal weight) {
        return formatDecimal(3, weight);
    }

    /**
     * <p>将字符串中的占位符替换成对应的参数。</p>
     * <pre>
     * StringUtils.formatMessage("id:{0} name:{1} count:{2} flag:{3}", 1, "test", BigDecimal.TEN, true) = "id:1 name:test count:10 flag:true"
     * StringUtils.formatMessage("id:{0} name:{1} count:{2} flag:{3}", 1, "test", BigDecimal.TEN)       = "id:1 name:test count:10 flag:{3}"
     * StringUtils.formatMessage("''{0}''", "test")   = "'test'"
     * StringUtils.formatMessage("'{'{0}'}'", "test") = "{test}"
     * </pre>
     *
     * @param pattern 含占位符的字符串
     * @param arguments 替换占位符的对象
     * @return 若参数{@code pattern}是{@code null}，则抛出异常，若参数{@code arguments}是{@code null}，则返回原字符串，否则返回替换后的字符串
     */
    public static String formatMessage(String pattern, Object... arguments) {
        String message = "";
        if (arguments instanceof Object[]) {
            for (int i = 0; i < arguments.length; i++) {
                if (arguments[i] == null) {
                    arguments[i] = "";
                }
            }
        }

        try {
            message = MessageFormat.format(pattern.replaceAll("(?<!('|\\{|\\}))'(?!('|\\{|\\}))", "''"), arguments);
        } catch (Exception ex) {
            throw new RuntimeException(MessageFormat.format("Format message[{0}] is fail.", pattern), ex);
        }
        return message;
    }

    /**
     * <p>将字符串中的结束符（\n，\r，\0），替换为空格。</p>
     *
     * @param str 含结束符的字符串
     * @return 若参数{@code str}是{@code null}，则返回{@code ""}，否则返回替换后的字符串
     */
    public static String replaceReturn(String str) {
        if (null == str) {
            return "";
        }
        return str.replace("\n", " ").replace("\r", " ").replace("\0", " ");
    }

    /**
     * <p>将空指针转化为空字符串。</p>
     * <pre>
     * StringUtils.nullToEmpty(null) = ""
     * StringUtils.nullToEmpty("")   = ""
     * StringUtils.nullToEmpty("a ") = "a "
     * </pre>
     *
     * @param str 任意字符串
     * @return 若参数{@code str}是{@code null}，则返回{@code ""}，否则返回原字符串
     */
    public static String nullToEmpty(String str) {
        return (null == str) ? "" : str;
    }

    /**
     * <p>将空字符串转化为空指针。</p>
     * <pre>
     * StringUtils.emptyToNull(null) = null
     * StringUtils.emptyToNull("")   = null
     * StringUtils.emptyToNull(" ")  = null
     * StringUtils.emptyToNull("a ") = "a "
     * </pre>
     *
     * @param str 任意字符串
     * @return 若参数{@code str}是{@code ""}，则返回{@code null}，否则返回原字符串
     */
    public static String emptyToNull(String str) {
        return isBlank(str) ? null : str;
    }

    /**
     * <p>将对象转换成字符串形式。</p>
     * <pre>
     * StringUtils.toString(null) = ""
     * StringUtils.toString("")   = ""
     * StringUtils.toString(" a") = " a"
     * StringUtils.toString(123)  = "123"
     * </pre>
     *
     * @param obj 任意对象
     * @return 若参数{@code obj}是{@code null}，则返回{@code ""}，否则返回对象的字符串形式
     */
    public static String toString(Object obj) {
        String str = "";
        if (null != obj) {
            str = obj.toString();
        }
        return str;
    }

    /**
     * <p>将对象转换成字符串形式。</p>
     * <pre>
     * StringUtils.toStr(null)  = null
     * StringUtils.toStr("")    = ""
     * StringUtils.toStr(" a")  = " a"
     * StringUtils.toStr(123)   = "123"
     * </pre>
     *
     * @param obj 任意对象
     * @return 若参数{@code obj}是{@code null}，则返回{@code null}，否则返回对象的字符串形式
     */
    public static String toStr(Object obj) {
        String str = null;
        if (null != obj) {
            str = obj.toString();
        }
        return str;
    }

    /**
     * <p>将字符串中的所有英文字母变成大写</p>
     * <pre>
     * StringUtils.toUpper(null) = null
     * StringUtils.toUpper("")   = ""
     * StringUtils.toUpper(" ")  = " "
     * StringUtils.toUpper(abc)  = "ABC"
     * </pre>
     *
     * @param str 任意字符串
     * @return 若参数{@code str}为空，则返回原字符串，否则返回字母大写的字符串
     */
    public static String toUpper(String str) {
        if (isBlank(str)) {
            return str;
        }
        return str.toUpperCase();
    }

    /**
     * <p>将字符串中的所有英文字母变成小写</p>
     * <pre>
     * StringUtils.toLower(null) = null
     * StringUtils.toLower("")   = ""
     * StringUtils.toLower(" ")  = " "
     * StringUtils.toLower(ABC)  = "abc"
     * </pre>
     *
     * @param str 任意字符串
     * @return 若参数{@code str}为空，则返回原字符串，否则返回字母小写的字符串
     */
    public static String toLower(String str) {
        if (isBlank(str)) {
            return str;
        }
        return str.toLowerCase();
    }

}