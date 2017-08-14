package com.bms.issue.bean.param;

import com.bms.issue.common.rest.param.RestBean;

/**
 * 问题订单修改接口Param
 *
 * @author li_huiqian
 */
public class ISSU0104IBean extends RestBean {
    private static final long serialVersionUID = 1L;

    private Long issueId;

    private String initiatorType;

    private String initiatorId;

    private String initiatorName;

    private String initiateTime;

    private String issueDesc;

    private String closeUid;

    private String closeUname;

    private String closeTime;

    private String issueResult;

    private String issueDecision;

    private Integer ver;

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public String getInitiatorType() {
        return initiatorType;
    }

    public void setInitiatorType(String initiatorType) {
        this.initiatorType = initiatorType;
    }

    public String getInitiatorId() {
        return initiatorId;
    }

    public void setInitiatorId(String initiatorId) {
        this.initiatorId = initiatorId;
    }

    public String getInitiatorName() {
        return initiatorName;
    }

    public void setInitiatorName(String initiatorName) {
        this.initiatorName = initiatorName;
    }

    public String getInitiateTime() {
        return initiateTime;
    }

    public void setInitiateTime(String initiateTime) {
        this.initiateTime = initiateTime;
    }

    public String getIssueDesc() {
        return issueDesc;
    }

    public void setIssueDesc(String issueDesc) {
        this.issueDesc = issueDesc;
    }

    public String getCloseUid() {
        return closeUid;
    }

    public void setCloseUid(String closeUid) {
        this.closeUid = closeUid;
    }

    public String getCloseUname() {
        return closeUname;
    }

    public void setCloseUname(String closeUname) {
        this.closeUname = closeUname;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getIssueResult() {
        return issueResult;
    }

    public void setIssueResult(String issueResult) {
        this.issueResult = issueResult;
    }

    public String getIssueDecision() {
        return issueDecision;
    }

    public void setIssueDecision(String issueDecision) {
        this.issueDecision = issueDecision;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }
}
