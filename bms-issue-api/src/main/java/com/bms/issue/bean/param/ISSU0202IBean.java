package com.bms.issue.bean.param;

import com.bms.issue.common.rest.param.RestBean;

/**
 * 问题订单问题结案接口Param
 *
 * @author li_huiqian
 */
public class ISSU0202IBean extends RestBean {
    private static final long serialVersionUID = 1L;


    /**
     * 问题ID
     */
    private Long questionId;

    /**
     * 问题订单ID
     */
    private Long issueId;


    /**
     * 问题管理结案时间
     */
    private String questionCloseTime;


    /**
     * 问题管理结案人
     */
    private String questionCloseUid;

    /**
     * 问题管理结案人名称
     */
    private String questionCloseUname;


    private Integer version;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public String getQuestionCloseTime() {
        return questionCloseTime;
    }

    public void setQuestionCloseTime(String questionCloseTime) {
        this.questionCloseTime = questionCloseTime;
    }

    public String getQuestionCloseUid() {
        return questionCloseUid;
    }

    public void setQuestionCloseUid(String questionCloseUid) {
        this.questionCloseUid = questionCloseUid;
    }

    public String getQuestionCloseUname() {
        return questionCloseUname;
    }

    public void setQuestionCloseUname(String questionCloseUname) {
        this.questionCloseUname = questionCloseUname;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
