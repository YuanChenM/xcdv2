package com.bms.issue.bean.param;

import com.bms.issue.common.rest.param.RestFilter;

/**
 * Created by Administrator on 2017/2/20.
 */
public class ISSU0210IFilter extends RestFilter {

    private static final long serialVersionUID = 1L;

    /**
     * 问题订单ID
     */
    private Long[] issueId;
    /**
     * 问题ID
     */
    private Long[] questionId;
    /**
     * 问题编码，模糊查询
     */
    private String questionCode;
    /**
     * 问题关键词，模糊查询
     */
    private String questionKeyword;
    /**
     * 问题立项人名称，模糊查询
     */
    private String questionStartUname;
    /**
     * 问题结案人名称，模糊查询
     */
    private String questionCloseUname;
    /**
     * 问题立项时间起始
     */
    private String questionStartTimeFrom;
    /**
     * 问题立项时间截止
     */
    private String questionStartTimeTo;
    /**
     * 问题是否结案
     */
    private Boolean questionIsClose;
    /**
     * 问题结案时间起始
     */
    private String questionCloseTimeFrom;
    /**
     * 问题结案时间截止
     */
    private String questionCloseTimeTo;
    /**
     * 附件ID
     */
    private Long[] accessoryId;
    /**
     * 文件ID
     */
    private String[] fileId;

    private String orderCode;

    private String[] issueStatus;

    public String[] getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(String[] issueStatus) {
        this.issueStatus = issueStatus;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Long[] getIssueId() {
        return issueId;
    }

    public void setIssueId(Long[] issueId) {
        this.issueId = issueId;
    }

    public Long[] getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long[] questionId) {
        this.questionId = questionId;
    }

    public String getQuestionCode() {
        return questionCode;
    }

    public void setQuestionCode(String questionCode) {
        this.questionCode = questionCode;
    }

    public String getQuestionKeyword() {
        return questionKeyword;
    }

    public void setQuestionKeyword(String questionKeyword) {
        this.questionKeyword = questionKeyword;
    }

    public String getQuestionStartUname() {
        return questionStartUname;
    }

    public void setQuestionStartUname(String questionStartUname) {
        this.questionStartUname = questionStartUname;
    }

    public String getQuestionCloseUname() {
        return questionCloseUname;
    }

    public void setQuestionCloseUname(String questionCloseUname) {
        this.questionCloseUname = questionCloseUname;
    }

    public String getQuestionStartTimeFrom() {
        return questionStartTimeFrom;
    }

    public void setQuestionStartTimeFrom(String questionStartTimeFrom) {
        this.questionStartTimeFrom = questionStartTimeFrom;
    }

    public String getQuestionStartTimeTo() {
        return questionStartTimeTo;
    }

    public void setQuestionStartTimeTo(String questionStartTimeTo) {
        this.questionStartTimeTo = questionStartTimeTo;
    }

    public Boolean getQuestionIsClose() {
        return questionIsClose;
    }

    public void setQuestionIsClose(Boolean questionIsClose) {
        this.questionIsClose = questionIsClose;
    }

    public String getQuestionCloseTimeFrom() {
        return questionCloseTimeFrom;
    }

    public void setQuestionCloseTimeFrom(String questionCloseTimeFrom) {
        this.questionCloseTimeFrom = questionCloseTimeFrom;
    }

    public String getQuestionCloseTimeTo() {
        return questionCloseTimeTo;
    }

    public void setQuestionCloseTimeTo(String questionCloseTimeTo) {
        this.questionCloseTimeTo = questionCloseTimeTo;
    }

    public Long[] getAccessoryId() {
        return accessoryId;
    }

    public void setAccessoryId(Long[] accessoryId) {
        this.accessoryId = accessoryId;
    }

    public String[] getFileId() {
        return fileId;
    }

    public void setFileId(String[] fileId) {
        this.fileId = fileId;
    }
}
