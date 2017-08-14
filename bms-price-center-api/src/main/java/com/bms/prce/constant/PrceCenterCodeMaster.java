package com.bms.prce.constant;

/**
 * Created by sun_jiaju on 2017/01/12.
 */
public class PrceCenterCodeMaster {

    /** 所有人类型 */
    public static class OWNER_TYPE {
        public static final String PLATFORM = "0";
        public static final String SELLER = "1";
    }

    /** 用户类型 */
    public static class USER_TYPE {
        public static final String STANDARD_BUYER = "0";
        public static final String ACCOUNT_BUYER = "1";
        public static final String SA = "2";
    }

    /** 买家类型 */
    public static class BUYER_LEVEL {
        public static final String STANDARD_LEVEL = "0";
        public static final String FIRST_LEVEL = "1";
        public static final String SECOND_LEVEL = "2";
        public static final String THIRD_LEVEL = "3";
    }
}
