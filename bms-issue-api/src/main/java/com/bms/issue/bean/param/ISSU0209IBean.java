package com.bms.issue.bean.param;

import com.bms.issue.common.rest.param.RestBean;

/**
 * 问题处理/结案建议编辑接口Param
 *
 * @author li_huiqian
 */
public class ISSU0209IBean extends RestBean {
    private static final long serialVersionUID = 1L;

    private Long handlingId;

    private Long questionId;

    private String handlingType;

    private String handlingContent;

    private String handlingTime;

    private String handlingUid;

    private String handlingUname;

    private String handlingResult;

    private String handlingResultReason;

    private Integer ver;

    public Long getHandlingId() {
        return handlingId;
    }

    public void setHandlingId(Long handlingId) {
        this.handlingId = handlingId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getHandlingType() {
        return handlingType;
    }

    public void setHandlingType(String handlingType) {
        this.handlingType = handlingType;
    }

    public String getHandlingContent() {
        return handlingContent;
    }

    public void setHandlingContent(String handlingContent) {
        this.handlingContent = handlingContent;
    }

    public String getHandlingTime() {
        return handlingTime;
    }

    public void setHandlingTime(String handlingTime) {
        this.handlingTime = handlingTime;
    }

    public String getHandlingUid() {
        return handlingUid;
    }

    public void setHandlingUid(String handlingUid) {
        this.handlingUid = handlingUid;
    }

    public String getHandlingUname() {
        return handlingUname;
    }

    public void setHandlingUname(String handlingUname) {
        this.handlingUname = handlingUname;
    }

    public String getHandlingResult() {
        return handlingResult;
    }

    public void setHandlingResult(String handlingResult) {
        this.handlingResult = handlingResult;
    }

    public String getHandlingResultReason() {
        return handlingResultReason;
    }

    public void setHandlingResultReason(String handlingResultReason) {
        this.handlingResultReason = handlingResultReason;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }
}
