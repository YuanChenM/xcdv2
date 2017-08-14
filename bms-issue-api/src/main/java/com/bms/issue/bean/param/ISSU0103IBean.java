package com.bms.issue.bean.param;

import com.bms.issue.common.rest.param.RestBean;

/**
 * 问题订单结案提交接口Param
 *
 * @author li_huiqian
 */
public class ISSU0103IBean extends RestBean {
    private static final long serialVersionUID = 1L;

    private Long issueId;

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
