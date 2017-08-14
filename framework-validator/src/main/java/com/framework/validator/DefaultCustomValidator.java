package com.framework.validator;

import com.framework.exception.bean.ValidatorExceptionMessage;
import com.framework.validator.utils.DateValidator;
import com.framework.validator.utils.NumberValidator;
import com.framework.validator.utils.StringValidator;
import com.framework.validator.utils.ValidatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 默认的验证方式的validator
 *
 * @author liu_tao2
 * @version 1.0
 */
public abstract class DefaultCustomValidator<T extends Serializable> implements BaseValidator {

    /**
     * logger 日志
     */
    private static Logger logger = LoggerFactory.getLogger(BaseValidator.class);

    /**
     * Exception Message List
     */
    private List<ValidatorExceptionMessage> exceptionMessageList = new ArrayList<ValidatorExceptionMessage>();

    /**
     * Warn Message List
     */
    private List<ValidatorExceptionMessage> warnMessageList = new ArrayList<ValidatorExceptionMessage>();

    public List<ValidatorExceptionMessage> getExceptionMessageList() {
        return this.exceptionMessageList;
    }

    public List<ValidatorExceptionMessage> getWarnMessageList() {
        return this.warnMessageList;
    }

    public void validatorParam(Object param) {
        this.validator((T) param);
    }

    /**
     * 每个validator实现类都需要实现的方法
     *
     * @param param
     */
    public abstract void validator(T param);

    /**
     * Validator Message Code定义
     *
     * @author jiang_nan
     */
    public interface Validator {
        /**
         * MESSAGE_BETWEEN:应在{0}到{1}之间
         */
        public String MESSAGE_BETWEEN = "validator.message.between";
        /**
         * MESSAGE_EMPTY:该项目不能为空！
         */
        public String MESSAGE_EMPTY = "validator.message.empty";
        /**
         * MESSAGE_NUMBER:该项目必须是整数。
         */
        public String MESSAGE_NUMBER = "validator.message.number";
        /**
         * MESSAGE_DECIMAL:该项目必须是数值。
         */
        public String MESSAGE_DECIMAL = "validator.message.decimal";
        /**
         * MESSAGE_REQUIREDNUMBER:当前输入必须是数字类型
         */
        public String MESSAGE_REQUIREDNUMBER = "validator.message.requiredNumber";
        /**
         * MESSAGE_DATE:该项目必须是有效的日期!
         */
        public String MESSAGE_DATE = "validator.message.date";
        /**
         * MESSAGE_PHONE:该项目的电话格式不正确!
         */
        public String MESSAGE_PHONE = "validator.message.phone";
        /**
         * MESSAGE_MAIL:邮件格式不正确！
         */
        public String MESSAGE_MAIL = "validator.message.mail";
        /**
         * MESSAGE_MAXLENGTH:该项目不能超过{0}位！
         */
        public String MESSAGE_MAXLENGTH = "validator.message.maxlength";

        /**
         * MESSAGE_MINLENGTH:该项目不能小于{0}位！
         */
        public String MESSAGE_MINLENGTH = "validator.message.minlength";
        /**
         * MESSAGE_MINLENGTH:该项目不能小于{0}位！
         */
        public String MESSAGE_REGEX = "validator.message.regex";
    }

    /**
     * 验证指定的字段值是否为空
     *
     * @param sheetName Excel Sheet 名称
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     验证的数据
     */
    protected void validatorRequired(String sheetName, Integer rowNum, String fieldName, Object value) {
        boolean isNull = false;
        if (StringValidator.validatorRequired(value)) {
            isNull = true;
        }
        if (isNull) {
            if (rowNum != null) {
                this.addErrorMessage(rowNum, fieldName, Validator.MESSAGE_EMPTY, null, sheetName);
            } else {
                this.addErrorMessage(fieldName, Validator.MESSAGE_EMPTY, null, sheetName);
            }
        }
    }

    /**
     * 验证指定的字段值是否为空
     *
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     验证的数据
     */
    protected void validatorRequired(Integer rowNum, String fieldName, Object value) {
        validatorRequired(null, rowNum, fieldName, value);
    }


    /**
     * 验证指定的字段值是否为空
     *
     * @param fieldName 字段名称
     * @param value     验证的数据
     */
    protected void validatorRequired(String fieldName, Object value) {
        validatorRequired(null, fieldName, value);
    }


    /**
     * 验证指定的字段值是否超过最大长度
     *
     * @param sheetName Excel Sheet 名称
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     验证的数据
     * @param required  是否必须
     * @param maxLength 最大长度
     */
    protected void validatorMaxLength(String sheetName, Integer rowNum, String fieldName, String value, boolean required, Integer maxLength) {
        if (this.validatorInit(rowNum, value, fieldName, required)) {
            return;
        }

        if (!StringValidator.validatorMaxLength(value, maxLength)) {
            this.addErrorMessage(rowNum, fieldName, Validator.MESSAGE_MAXLENGTH,
                    new String[]{String.valueOf(maxLength)}, sheetName);
        }
    }

    /**
     * 验证指定的字段值是否超过最大长度
     *
     * @param rowNum    行号
     * @param value     验证的数据
     * @param maxLength 最大长度
     * @param fieldName 字段名称
     * @param required  是否必须
     */
    protected void validatorMaxLength(Integer rowNum, String fieldName, String value, boolean required, Integer maxLength) {
        validatorMaxLength(null, rowNum, fieldName, value, required, maxLength);
    }

    /**
     * 验证指定的字段值是否超过最大长度
     *
     * @param maxLength 最大长度
     * @param fieldName 字段名称
     * @param value     验证的数据
     * @param required  是否必须
     */
    protected void validatorMaxLength(String fieldName, String value, boolean required, Integer maxLength) {
        validatorMaxLength(null, fieldName, value, required, maxLength);
    }

    /**
     * 验证指定的字段值是否小于最小长度
     *
     * @param sheetName Excel Sheet 名称
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     验证的数据
     * @param required  是否必须
     * @param minLength 最小长度
     */
    protected void validatorMinLength(String sheetName, Integer rowNum, String fieldName, String value, boolean required, int minLength) {
        if (this.validatorInit(rowNum, value, fieldName, required)) {
            return;
        }
        if (!StringValidator.validatorMinLength(value, minLength)) {
            this.addErrorMessage(rowNum, fieldName, Validator.MESSAGE_MINLENGTH,
                    new String[]{String.valueOf(minLength)}, sheetName);
        }
    }

    /**
     * 验证指定的字段值是否小于最小长度
     *
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     验证的数据
     * @param required  是否必须
     * @param minLength 最小长度
     */
    protected void validatorMinLength(Integer rowNum, String fieldName, String value, boolean required, int minLength) {
        validatorMinLength(null, rowNum, fieldName, value, required, minLength);
    }

    /**
     * 验证指定的字段值是否小于最小长度
     *
     * @param fieldName 字段名称
     * @param value     验证的数据
     * @param required  是否必须
     * @param minLength 最小长度
     */
    protected void validatorMinLength(String fieldName, String value, boolean required, int minLength) {
        validatorMinLength(null, fieldName, value, required, minLength);
    }

    /**
     * 验证指定的字段值日期类型输入的是否正确(Sting类型的参数)
     *
     * @param sheetName Excel Sheet 名称
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     验证的数据
     * @param required  是否必须
     * @param format    需要验证的时间格式
     */
    protected void validatorStrDate(String sheetName, Integer rowNum, String fieldName, String value, boolean required, String format) {
        if (this.validatorInit(rowNum, value, fieldName, required)) {
            return;
        }

        if (!DateValidator.validatorStrDate(value, format)) {
            this.addErrorMessage(rowNum, fieldName, Validator.MESSAGE_DATE,
                    null, sheetName);
        }
    }

    /**
     * 验证指定的字段值日期类型输入的是否正确(Sting类型的参数)
     *
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     验证的数据
     * @param required  是否必须
     * @param format    需要验证的时间格式
     */
    protected void validatorStrDate(Integer rowNum, String fieldName, String value, boolean required, String format) {
        validatorStrDate(null, rowNum, fieldName, value, required, format);
    }

    /**
     * 验证指定的字段值日期类型输入的是否正确(Sting类型的参数)
     *
     * @param fieldName 字段名称
     * @param value     验证的数据
     * @param required  是否必须
     * @param format    需要验证的时间格式
     */
    protected void validatorStrDate(String fieldName, String value, boolean required, String format) {
        validatorStrDate(null, fieldName, value, required, format);
    }

    /**
     * 验证指定的字段值日期类型输入的是否正确(Date类型的参数)
     *
     * @param sheetName Excel Sheet 名称
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     验证的数据
     * @param required  是否必须
     */
    protected void validatorDate(String sheetName, Integer rowNum, String fieldName, Date value, boolean required) {
        if (this.validatorInit(rowNum, value, fieldName, required)) {
            return;
        }

        if (!DateValidator.validatorDate(value)) {
            this.addErrorMessage(rowNum, fieldName, Validator.MESSAGE_DATE,
                    null, sheetName);
        }
    }

    /**
     * 验证指定的字段值日期类型输入的是否正确(Date类型的参数)
     *
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     验证的数据
     * @param required  是否必须
     */
    protected void validatorDate(Integer rowNum, String fieldName, Date value, boolean required) {
        validatorDate(null, rowNum, fieldName, value, required);
    }

    /**
     * 验证指定的字段值日期类型输入的是否正确(Date类型的参数)
     *
     * @param fieldName 字段名称
     * @param value     验证的数据
     * @param required  是否必须
     */
    protected void validatorDate(String fieldName, Date value, boolean required) {
        validatorDate(null, fieldName, value, required);
    }

    /**
     * 验证指定的字段值是否合法Email地址
     *
     * @param sheetName Excel Sheet 名称
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     验证的数据
     * @param required  是否必须
     */
    protected void validatorEmail(String sheetName, Integer rowNum, String fieldName, String value, boolean required) {
        if (validatorInit(rowNum, value, fieldName, required)) {
            return;
        }
        if (!StringValidator.validatorEmail(value)) {
            this.addErrorMessage(rowNum, fieldName, Validator.MESSAGE_MAIL, null, sheetName);
        }
    }

    /**
     * 验证指定的字段值是否合法Email地址
     *
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     验证的数据
     * @param required  是否必须
     */
    protected void validatorEmail(Integer rowNum, String fieldName, String value, boolean required) {
        validatorEmail(null, rowNum, fieldName, value, required);
    }

    /**
     * 验证指定的字段值是否合法Email地址
     *
     * @param fieldName 字段名称
     * @param value     验证的数据
     * @param required  是否必须
     */
    protected void validatorEmail(String fieldName, String value, boolean required) {
        validatorEmail(null, fieldName, value, required);
    }

    /**
     * 验证指定的字段值是否合法电话
     *
     * @param sheetName Excel Sheet 名称
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     验证的数据
     * @param required  是否必须
     */
    protected void validatorPhone(String sheetName, Integer rowNum, String fieldName, String value, boolean required) {
        if (validatorInit(rowNum, value, fieldName, required)) {
            return;
        }
        if (!StringValidator.validatorPhone(value)) {
            this.addErrorMessage(rowNum, fieldName, Validator.MESSAGE_PHONE, null, sheetName);
        }
    }

    /**
     * 验证指定的字段值是否合法电话
     *
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     验证的数据
     * @param required  是否必须
     */
    protected void validatorPhone(Integer rowNum, String fieldName, String value, boolean required) {
        validatorPhone(null, rowNum, fieldName, value, required);
    }

    /**
     * 验证指定的字段值是否合法电话
     *
     * @param fieldName 字段名称
     * @param value     验证的数据
     * @param required  是否必须
     */
    protected void validatorPhone(String fieldName, String value, boolean required) {
        validatorPhone(null, fieldName, value, required);
    }

    /**
     * 验证值的正则表达式
     *
     * @param sheetName Excel Sheet 名称
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     需要验证的值
     * @param required  是否必须
     * @param regex     正则表达式
     */
    protected void validatorPattern(String sheetName, Integer rowNum, String fieldName, String value, boolean required, String regex) {
        if (validatorInit(rowNum, value, fieldName, required)) {
            return;
        }
        if (!StringValidator.validatorPattern(value, regex)) {
            this.addErrorMessage(rowNum, fieldName, Validator.MESSAGE_REGEX, new String[]{regex}, sheetName);
        }
    }

    /**
     * 验证值的正则表达式
     *
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     需要验证的值
     * @param required  是否必须
     * @param regex     正则表达式
     */
    protected void validatorPattern(Integer rowNum, String fieldName, String value, boolean required, String regex) {
        validatorPattern(null, rowNum, fieldName, value, required, regex);
    }

    /**
     * 验证值的正则表达式
     *
     * @param fieldName 字段名称
     * @param value     需要验证的值
     * @param required  是否必须
     * @param regex     正则表达式
     */
    protected void validatorPattern(String fieldName, String value, boolean required, String regex) {
        validatorPattern(null, fieldName, value, required, regex);
    }

    /**
     * 校验整数（String类型）<br/>
     * sign ：1 表示可以为0;2 表示可以为负数;3 表示是非正数;4 表示可以为正数;5 表示是非负数;6 表示不能为0;7 表示可以为所有数
     *
     * @param sheetName Excel Sheet 名称
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     需要验证的值
     * @param required  是否必须
     * @param maxNum    需要的最大值
     * @param minNum    需要的最小值
     * @param sign      类型标志
     */
    protected void validatorStrInteger(String sheetName, Integer rowNum, String fieldName, String value, boolean required, Integer maxNum, Integer minNum, int sign) {
        if (validatorInit(rowNum, value, fieldName, required)) {
            return;
        }
        if (!NumberValidator.checkInteger(value, sign)) {
            this.addErrorMessage(rowNum, fieldName, Validator.MESSAGE_NUMBER, null, sheetName);
        }
        if (!NumberValidator.validatorIntegerBetween(value, maxNum, minNum)) {
            this.addErrorMessage(rowNum, fieldName, Validator.MESSAGE_BETWEEN, ValidatorUtils.getIntegerBetween(maxNum, minNum), sheetName);
        }
    }

    /**
     * 校验整数（String类型）<br/>
     * sign ：1 表示可以为0;2 表示可以为负数;3 表示是非正数;4 表示可以为正数;5 表示是非负数;6 表示不能为0;7 表示可以为所有数
     *
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     需要验证的值
     * @param required  是否必须
     * @param maxNum    需要的最大值
     * @param minNum    需要的最小值
     * @param sign      类型标志
     */
    protected void validatorStrInteger(Integer rowNum, String fieldName, String value, boolean required, Integer maxNum, Integer minNum, int sign) {
        validatorStrInteger(null, rowNum, fieldName, value, required, maxNum, minNum, sign);
    }

    /**
     * 校验整数（String类型）<br/>
     * sign ：1 表示可以为0;2 表示可以为负数;3 表示是非正数;4 表示可以为正数;5 表示是非负数;6 表示不能为0;7 表示可以为所有数
     *
     * @param fieldName 字段名称
     * @param value     需要验证的值
     * @param required  是否必须
     * @param maxNum    需要的最大值
     * @param minNum    需要的最小值
     * @param sign      类型标志
     */
    protected void validatorStrInteger(String fieldName, String value, boolean required, Integer maxNum, Integer minNum, int sign) {
        validatorStrInteger(null, fieldName, value, required, maxNum, minNum, sign);
    }

    /**
     * 校验整数（Integer类型）<br/>
     * sign ：1 表示可以为0;2 表示可以为负数;3 表示是非正数;4 表示可以为正数;5 表示是非负数;6 表示不能为0;7 表示可以为所有数
     *
     * @param sheetName Excel Sheet 名称
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     需要验证的值
     * @param required  是否必须
     * @param maxNum    需要的最大值
     * @param minNum    需要的最小值
     * @param sign      类型标志
     */
    protected void validatorInteger(String sheetName, Integer rowNum, String fieldName, Integer value, boolean required, Integer maxNum, Integer minNum, int sign) {
        if (validatorInit(rowNum, value, fieldName, required)) {
            return;
        }
        if (null == value) {
            this.addErrorMessage(rowNum, fieldName, Validator.MESSAGE_NUMBER, null, sheetName);
        }
        if (!NumberValidator.checkInteger(String.valueOf(value), sign)) {
            this.addErrorMessage(rowNum, fieldName, Validator.MESSAGE_NUMBER, null, sheetName);
        }
        if (!NumberValidator.validatorIntegerBetween(String.valueOf(value), maxNum, minNum)) {
            this.addErrorMessage(rowNum, fieldName, Validator.MESSAGE_BETWEEN, ValidatorUtils.getIntegerBetween(maxNum, minNum), sheetName);
        }
    }

    /**
     * 校验整数（Integer类型）<br/>
     * sign ：1 表示可以为0;2 表示可以为负数;3 表示是非正数;4 表示可以为正数;5 表示是非负数;6 表示不能为0;7 表示可以为所有数
     *
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     需要验证的值
     * @param required  是否必须
     * @param maxNum    需要的最大值
     * @param minNum    需要的最小值
     * @param sign      类型标志
     */
    protected void validatorInteger(Integer rowNum, String fieldName, Integer value, boolean required, Integer maxNum, Integer minNum, int sign) {
        validatorInteger(null, rowNum, fieldName, value, required, maxNum, minNum, sign);
    }

    /**
     * 校验整数（Integer类型）<br/>
     * sign ：1 表示可以为0;2 表示可以为负数;3 表示是非正数;4 表示可以为正数;5 表示是非负数;6 表示不能为0;7 表示可以为所有数
     *
     * @param fieldName 字段名称
     * @param value     需要验证的值
     * @param required  是否必须
     * @param maxNum    需要的最大值
     * @param minNum    需要的最小值
     * @param sign      类型标志
     */
    protected void validatorInteger(String fieldName, Integer value, boolean required, Integer maxNum, Integer minNum, int sign) {
        validatorInteger(null, fieldName, value, required, maxNum, minNum, sign);
    }

    /**
     * 校验Long整数（String类型）<br/>
     * sign ：1 表示可以为0;2 表示可以为负数;3 表示是非正数;4 表示可以为正数;5 表示是非负数;6 表示不能为0;7 表示可以为所有数
     *
     * @param sheetName Excel Sheet 名称
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     需要验证的值
     * @param required  是否必须
     * @param maxNum    需要的最大值
     * @param minNum    需要的最小值
     * @param sign      类型标志
     */
    protected void validatorStrLong(String sheetName, Integer rowNum, String fieldName, String value, boolean required, Long maxNum, Long minNum, int sign) {
        if (validatorInit(rowNum, value, fieldName, required)) {
            return;
        }
        if (!NumberValidator.checkInteger(value, sign)) {
            this.addErrorMessage(rowNum, fieldName, Validator.MESSAGE_NUMBER, null, sheetName);
        }
        if (!NumberValidator.validatorLongBetween(value, maxNum, minNum)) {
            this.addErrorMessage(rowNum, fieldName, Validator.MESSAGE_BETWEEN, ValidatorUtils.getLongBetween(maxNum, minNum), sheetName);
        }
    }

    /**
     * 校验Long整数（String类型）<br/>
     * sign ：1 表示可以为0;2 表示可以为负数;3 表示是非正数;4 表示可以为正数;5 表示是非负数;6 表示不能为0;7 表示可以为所有数
     *
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     需要验证的值
     * @param required  是否必须
     * @param maxNum    需要的最大值
     * @param minNum    需要的最小值
     * @param sign      类型标志
     */
    protected void validatorStrLong(Integer rowNum, String fieldName, String value, boolean required, Long maxNum, Long minNum, int sign) {
        validatorStrLong(null, rowNum, fieldName, value, required, maxNum, minNum, sign);
    }

    /**
     * 校验Long整数（String类型）<br/>
     * sign ：1 表示可以为0;2 表示可以为负数;3 表示是非正数;4 表示可以为正数;5 表示是非负数;6 表示不能为0;7 表示可以为所有数
     *
     * @param fieldName 字段名称
     * @param value     需要验证的值
     * @param required  是否必须
     * @param maxNum    需要的最大值
     * @param minNum    需要的最小值
     * @param sign      类型标志
     */
    protected void validatorStrLong(String fieldName, String value, boolean required, Long maxNum, Long minNum, int sign) {
        validatorStrLong(null, fieldName, value, required, maxNum, minNum, sign);
    }

    /**
     * 校验Long整数（String类型）<br/>
     * sign ：1 表示可以为0;2 表示可以为负数;3 表示是非正数;4 表示可以为正数;5 表示是非负数;6 表示不能为0;7 表示可以为所有数
     *
     * @param sheetName Excel Sheet 名称
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     需要验证的值
     * @param required  是否必须
     * @param maxNum    需要的最大值
     * @param minNum    需要的最小值
     * @param sign      类型标志
     */
    protected void validatorLong(String sheetName, Integer rowNum, String fieldName, Long value, boolean required, Long maxNum, Long minNum, int sign) {
        if (validatorInit(rowNum, value, fieldName, required)) {
            return;
        }
        if (ValidatorUtils.isNull(value)) {
            this.addErrorMessage(rowNum, fieldName, Validator.MESSAGE_REQUIREDNUMBER, null, sheetName);
        }

        if (!NumberValidator.checkInteger(String.valueOf(value), sign)) {
            this.addErrorMessage(rowNum, fieldName, Validator.MESSAGE_NUMBER, null, sheetName);
        }
        if (!NumberValidator.validatorLongBetween(String.valueOf(value), maxNum, minNum)) {
            this.addErrorMessage(rowNum, fieldName, Validator.MESSAGE_BETWEEN, ValidatorUtils.getLongBetween(maxNum, minNum), sheetName);
        }
    }

    /**
     * 校验Long整数（String类型）<br/>
     * sign ：1 表示可以为0;2 表示可以为负数;3 表示是非正数;4 表示可以为正数;5 表示是非负数;6 表示不能为0;7 表示可以为所有数
     *
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     需要验证的值
     * @param required  是否必须
     * @param maxNum    需要的最大值
     * @param minNum    需要的最小值
     * @param sign      类型标志
     */
    protected void validatorLong(Integer rowNum, String fieldName, Long value, boolean required, Long maxNum, Long minNum, int sign) {
        validatorLong(null, rowNum, fieldName, value, required, maxNum, minNum, sign);
    }

    /**
     * 校验Long整数（String类型）<br/>
     * sign ：1 表示可以为0;2 表示可以为负数;3 表示是非正数;4 表示可以为正数;5 表示是非负数;6 表示不能为0;7 表示可以为所有数
     *
     * @param fieldName 字段名称
     * @param value     需要验证的值
     * @param required  是否必须
     * @param maxNum    需要的最大值
     * @param minNum    需要的最小值
     * @param sign      类型标志
     */
    protected void validatorLong(String fieldName, Long value, boolean required, Long maxNum, Long minNum, int sign) {
        validatorLong(null, fieldName, value, required, maxNum, minNum, sign);
    }

    /**
     * 校验BigDecimal类型（String类型）<br/>
     * sign ：1 表示可以为0;2 表示可以为负数;3 表示是非正数;4 表示可以为正数;5 表示是非负数;6 表示不能为0;7 表示可以为所有数
     *
     * @param sheetName Excel Sheet 名称
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     需要验证的值
     * @param required  是否必须
     * @param maxM      最大长度
     * @param maxD      小数部分的最大长度
     * @param sign      类型标志
     */
    protected void validatorStrDecimal(String sheetName, Integer rowNum, String fieldName, String value, boolean required, Integer maxM, Integer maxD, int sign) {
        if (validatorInit(rowNum, value, fieldName, required)) {
            return;
        }

        if (!NumberValidator.checkDecimal(value, sign)) {
            this.addErrorMessage(rowNum, fieldName, Validator.MESSAGE_DECIMAL, null, sheetName);
        }
        if (!NumberValidator.validatorDecimalBetween(value, maxM, maxD)) {
            this.addErrorMessage(rowNum, fieldName, Validator.MESSAGE_BETWEEN, null, sheetName);
        }
    }

    /**
     * 校验BigDecimal类型（String类型）<br/>
     * sign ：1 表示可以为0;2 表示可以为负数;3 表示是非正数;4 表示可以为正数;5 表示是非负数;6 表示不能为0;7 表示可以为所有数
     *
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     需要验证的值
     * @param required  是否必须
     * @param maxM      最大长度
     * @param maxD      小数部分的最大长度
     * @param sign      类型标志
     */
    protected void validatorStrDecimal(Integer rowNum, String fieldName, String value, boolean required, Integer maxM, Integer maxD, int sign) {
        validatorStrDecimal(null, rowNum, fieldName, value, required, maxM, maxD, sign);
    }

    /**
     * 校验BigDecimal类型（String类型）<br/>
     * sign ：1 表示可以为0;2 表示可以为负数;3 表示是非正数;4 表示可以为正数;5 表示是非负数;6 表示不能为0;7 表示可以为所有数
     *
     * @param fieldName 字段名称
     * @param value     需要验证的值
     * @param required  是否必须
     * @param maxM      最大长度
     * @param maxD      小数部分的最大长度
     * @param sign      类型标志
     */
    protected void validatorStrDecimal(String fieldName, String value, boolean required, Integer maxM, Integer maxD, int sign) {
        validatorStrDecimal(null, fieldName, value, required, maxM, maxD, sign);
    }

    /**
     * 校验BigDecimal类型（BigDecimal类型）<br/>
     * sign ：1 表示可以为0;2 表示可以为负数;3 表示是非正数;4 表示可以为正数;5 表示是非负数;6 表示不能为0;7 表示可以为所有数
     *
     * @param sheetName Excel Sheet 名称
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     需要验证的值
     * @param required  是否必须
     * @param maxM      最大长度
     * @param maxD      小数部分的最大长度
     * @param sign      类型标志
     */
    protected void validatorDecimal(String sheetName, Integer rowNum, String fieldName, BigDecimal value, boolean required, Integer maxM, Integer maxD, int sign) {
        if (validatorInit(rowNum, value, fieldName, required)) {
            return;
        }
        if (ValidatorUtils.isNull(value)) {
            this.addErrorMessage(rowNum, fieldName, Validator.MESSAGE_REQUIREDNUMBER, null, sheetName);
        }
        if (!NumberValidator.checkDecimal(String.valueOf(value), sign)) {
            this.addErrorMessage(rowNum, fieldName, Validator.MESSAGE_DECIMAL, null, sheetName);
        }
        if (!NumberValidator.validatorDecimalBetween(String.valueOf(value), maxM, maxD)) {
            this.addErrorMessage(rowNum, fieldName, Validator.MESSAGE_BETWEEN, null, sheetName);
        }
    }

    /**
     * 校验BigDecimal类型（BigDecimal类型）<br/>
     * sign ：1 表示可以为0;2 表示可以为负数;3 表示是非正数;4 表示可以为正数;5 表示是非负数;6 表示不能为0;7 表示可以为所有数
     *
     * @param rowNum    行号
     * @param fieldName 字段名称
     * @param value     需要验证的值
     * @param required  是否必须
     * @param maxM      最大长度
     * @param maxD      小数部分的最大长度
     * @param sign      类型标志
     */
    protected void validatorDecimal(Integer rowNum, String fieldName, BigDecimal value, boolean required, Integer maxM, Integer maxD, int sign) {
        validatorDecimal(null, rowNum, fieldName, value, required, maxM, maxD, sign);
    }

    /**
     * 校验BigDecimal类型（BigDecimal类型）<br/>
     * sign ：1 表示可以为0;2 表示可以为负数;3 表示是非正数;4 表示可以为正数;5 表示是非负数;6 表示不能为0;7 表示可以为所有数
     *
     * @param fieldName 字段名称
     * @param value     需要验证的值
     * @param required  是否必须
     * @param maxM      最大长度
     * @param maxD      小数部分的最大长度
     * @param sign      类型标志
     */
    protected void validatorDecimal(String fieldName, BigDecimal value, boolean required, Integer maxM, Integer maxD, int sign) {
        validatorDecimal(null, fieldName, value, required, maxM, maxD, sign);
    }

    /**
     * 验证指定的字段值是否必须
     *
     * @param rowNum    行号
     * @param value     验证的数据
     * @param fieldName 字段名称
     * @param required  是否必须
     * @return 校验结果
     */
    private boolean validatorInit(Integer rowNum, Object value, String fieldName, boolean required) {
        if (!required && null == value) {
            return true;
        }
        int size = this.getExceptionMessageList().size();
        this.validatorRequired(rowNum, fieldName, value);
        int newSize = this.getExceptionMessageList().size();
        return size != newSize;
    }

    /**
     * 保存校验消息
     *
     * @param fieldName   字段名称
     * @param messageCode 消息编码
     * @param args        消息参数
     */
    private void addErrorMessage(String fieldName, String messageCode, String[] args, String sheetName) {
        ValidatorExceptionMessage exceptionMessage = new ValidatorExceptionMessage(messageCode, sheetName, null, fieldName, args);
        this.exceptionMessageList.add(exceptionMessage);
    }

    /**
     * 保存校验消息
     *
     * @param rowNum      行号
     * @param fieldName   字段名称
     * @param messageCode 消息编码
     * @param args        消息参数
     */
    private void addErrorMessage(Integer rowNum, String fieldName, String messageCode, String[] args, String sheetName) {
        ValidatorExceptionMessage exceptionMessage = new ValidatorExceptionMessage(messageCode, sheetName, rowNum, fieldName, args);
        this.exceptionMessageList.add(exceptionMessage);
    }
}
