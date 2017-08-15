package com.bms.order.bean.result;

import com.framework.base.rest.result.BaseRestResult;

/**
 * 处理失败的发货通知单Result
 *
 * @author peng_hao
 */
public class ORDR040101IRestResult extends BaseRestResult {
    private static final long serialVersionUID = 1L;
    /**
     * 处理失败的发货通知单
     */
    private Long sendNotificationCode;

    /**
     * 失败消息编码
     */
    private String  msgCode;

    /**
     * 失败消息
     */
    private String msg;

    public Long getSendNotificationCode() {
        return sendNotificationCode;
    }

    public void setSendNotificationCode(Long sendNotificationCode) {
        this.sendNotificationCode = sendNotificationCode;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
