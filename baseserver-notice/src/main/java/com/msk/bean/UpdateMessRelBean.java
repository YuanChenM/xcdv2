package com.msk.bean;


import com.framework.base.rest.entity.BaseEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by mao_yejun on 2016/10/13.
 */
public class UpdateMessRelBean extends BaseEntity {
    private List<String> messageRelationId;
    private String status;
    private String receiverCode;
    private Date lookUpTime;
    private List<String> messageIds;
    public String getReceiverCode() {
        return receiverCode;
    }

    public void setReceiverCode(String receiverCode) {
        this.receiverCode = receiverCode;
    }

    public List<String> getMessageRelationId() {
        return messageRelationId;
    }

    public void setMessageRelationId(List<String> messageRelationId) {
        this.messageRelationId = messageRelationId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLookUpTime() {
        return lookUpTime;
    }

    public void setLookUpTime(Date lookUpTime) {
        this.lookUpTime = lookUpTime;
    }

    public List<String> getMessageIds() {
        return messageIds;
    }

    public void setMessageIds(List<String> messageIds) {
        this.messageIds = messageIds;
    }
}
