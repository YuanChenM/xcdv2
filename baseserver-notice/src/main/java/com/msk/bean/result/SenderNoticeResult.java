package com.msk.bean.result;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhu_kai1 on 2017/2/21.
 */
public class SenderNoticeResult implements Serializable {

    private String id;
    private String messageContext;
    private String crtId;
    private String title;
    private Date crtTime;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessageContext() {
        return messageContext;
    }

    public void setMessageContext(String messageContext) {
        this.messageContext = messageContext;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }
}
