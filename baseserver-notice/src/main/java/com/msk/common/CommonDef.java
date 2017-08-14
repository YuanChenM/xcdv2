package com.msk.common;

/**
 * Created by mao_yejun on 2016/10/13.
 */
public interface CommonDef {
    /**
     * 消息状态
     */
    public interface NoticeStatusDef {
        /**
         * 新建未读
         */
        public static final String CREATE = "0";
        /**
         * 已读
         */
        public static final String READ = "1";
        /**
         * 作废*
         */
        public static final String CANCEL = "2";
    }

    /**
     * 消息类型
     */
    public interface NoticeTypeDef {
        /**
         * 系统消息
         */
        public static final String SYSTEM = "0";

    }

}
