package com.bms.common.constant;

/**
 * Created by mao_yejun on 2016/12/9.
 */
public interface CommonMessage {
    /**
     * validate prefix
     */
    String VALIDATE = "COMMON.VALIDATE.";
    /**
     * error prefix
     */
    String ERROR = "COMMON.ERROR.";
    /**
     * warn prefix
     */
    String WARN = "COMMON.WARN.";
    /**
     * info prefix
     */
    String INFO = "INFO.WARN.";


    /**
     * 校验异常
     */
    interface ValidateMessage {
        /**
         * REQUIRE:必填字段
         */
        String REQUIRE = VALIDATE + "REQUIRE";
        /**
         * REMOTE:请修正此字段
         */
        String REMOTE = VALIDATE + "REMOTE";
        /**
         * EMAIL:请输入有效的电子邮件地址
         */
        String EMAIL = VALIDATE + "EMAIL";
        /**
         * URL:请输入有效的网址
         */
        String URL = VALIDATE + "URL";
        /**
         * DATE:请输入有效的日期
         */
        String DATE = VALIDATE + "DATE";
        /**
         * DATEISO:请输入有效的日期 (YYYY-MM-DD)
         */
        String DATEISO = VALIDATE + "DATEISO";
        /**
         * NUMBER:请输入有效的数字
         */
        String NUMBER = VALIDATE + "NUMBER";
        /**
         * DIGITS:只能输入数字
         */
        String DIGITS = VALIDATE + "DIGITS";
        /**
         * CREDITCARD:请输入有效的信用卡号码
         */
        String CREDITCARD = VALIDATE + "CREDITCARD";
        /**
         * EQUALTO:你的输入不相同
         */
        String EQUALTO = VALIDATE + "EQUALTO";
        /**
         * EXTENSION:请输入有效的后缀
         */
        String EXTENSION = VALIDATE + "EXTENSION";
        /**
         * MAXLENGTH:最多可以输入 {0} 个字符
         */
        String MAXLENGTH = VALIDATE + "MAXLENGTH";
        /**
         * MINLENGTH:最少要输入 {0} 个字符
         */
        String MINLENGTH = VALIDATE + "MINLENGTH";
        /**
         * RANGELENGTH:请输入长度在 {0} 到 {1} 之间的字符串
         */
        String RANGELENGTH = VALIDATE + "RANGELENGTH";
        /**
         * RANGE:请输入范围在 {0} 到 {1} 之间的数值
         */
        String RANGE = VALIDATE + "RANGE";
        /**
         * MAX:请输入不大于 {0} 的数值
         */
        String MAX = VALIDATE + "MAX";
        /**
         * MIN:请输入不小于 {0} 的数值
         */
        String MIN = VALIDATE + "MIN";
    }

    /**
     * 错误信息
     */
    interface ErrorMessage {
        /**
         * SYSTEMEXCEPTION:系统异常,请联系管理员
         */
        String SYSTEMEXCEPTION = ERROR + "SYSTEMEXCEPTION";
        /**
         * NOTFIND:页面找不到
         */
        String NOTFIND = ERROR + "NOTFIND";
        /**
         * TIMEOUT:连接超时，请重新登录
         */
        String TIMEOUT = ERROR + "TIMEOUT";
        /**
         * DOWNLOADEXCEPTION:{0}下载异常
         */
        String DOWNLOADEXCEPTION = ERROR + "DOWNLOADEXCEPTION";
        /**
         * UPLOADEXCEPTION:{0}上传异常
         */
        String UPLOADEXCEPTION = ERROR + "UPLOADEXCEPTION";
    }

    interface WarnMessage {
        /**
         * AUTHORITY:该用户没有访问权限！
         */
        String AUTHORITY = WARN + "AUTHORITY";
    }

    interface InfoMessage {
        /**
         * SAVE:保存成功！
         */
        String SAVE = INFO + "SAVE";
        /**
         * DELETE:删除成功！
         */
        String DELETE = INFO + "DELETE";
        /**
         * EDIT:修改成功！
         */
        String EDIT = INFO + "EDIT";
    }

}
