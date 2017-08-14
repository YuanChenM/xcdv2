package com.zuul.constant;

/**
 * Created by mao_yejun on 2017/2/24.
 */
public interface ConstantDef {
    /**
     * securityKey 有效时间
     */
    interface TIMELINESSTYPE {
        /**
         * 永久
         */
        int PERMANENT = -1;
        /**
         * 分
         */
        int MINUTE = 0;
        /**
         * 小时
         */
        int HOUR = 1;
        /**
         * 日
         */
        int DAY = 2;
        /**
         * 月
         */
        int MONTH = 4;
        /**
         * 年
         */
        int YEAR = 5;
    }
}
