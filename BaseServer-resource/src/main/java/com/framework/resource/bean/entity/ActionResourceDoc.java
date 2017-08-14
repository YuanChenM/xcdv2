package com.framework.resource.bean.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.framework.resource.base.entity.BaseEntity;

/**
 * Created by zhang_jian3 on 2016/11/25.
 */
@Document(collection = "actionResourceDoc")
public class ActionResourceDoc extends BaseEntity {
    private String actionId;

    private String actionCode;

    private String actionName;

    private String actionType;

    private String actionDesc;

    private String actionUrl;

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getActionDesc() {
        return actionDesc;
    }

    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }
}
