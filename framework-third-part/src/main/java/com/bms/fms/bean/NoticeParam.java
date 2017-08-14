package com.bms.fms.bean;

import java.io.Serializable;

/**
 * Created by yuan_chen on 2017/5/10 0010.
 *
 * 通知用Param
 */
public class NoticeParam implements Serializable {
    private static final long serialVersionUID = -3361414885426702660L;

    /**
     * 通知类型
     */
    private String noticeType;
    /**
     * 通知基础数据主键
     */
    private String noticeKey;

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public String getNoticeKey() {
        return noticeKey;
    }

    public void setNoticeKey(String noticeKey) {
        this.noticeKey = noticeKey;
    }
}
