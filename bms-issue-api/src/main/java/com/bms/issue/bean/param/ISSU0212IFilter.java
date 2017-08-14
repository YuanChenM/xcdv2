package com.bms.issue.bean.param;

import com.bms.issue.common.rest.param.RestFilter;

/**
 * Created by Administrator on 2017/2/21.
 */
public class ISSU0212IFilter extends RestFilter {
    private static final long serialVersionUID = 1L;

    /**
     * 问题ID
     */
    private Long[] questionId;
    /**
     * 问题管理ID
     */
    private Long[] handlingId;
    /**
     * 问题管理类型
     */
    private String[] handlingType;
    /**
     * 申请或建议的内容，模糊检索
     */
    private String handlingContent;
    /**
     * 提交申请或建议的时间
     */
    private String handlingTimeFrom;
    /**
     * 提交申请或建议的时间
     */
    private String handlingTimeTo;
    /**
     * 提交申请或建议的人员ID
     */
    private String[] handlingUid;
    /**
     * 提交申请或建议的人员名称，模糊检索
     */
    private String handlingUname;
    /**
     * 问题结案结论，模糊检索
     */
    private String handlingResult;
    /**
     * 申请或建议结论的原因，模糊检索
     */
    private String handlingResultReason;

    public Long[] getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long[] questionId) {
        this.questionId = questionId;
    }

    public Long[] getHandlingId() {
        return handlingId;
    }

    public void setHandlingId(Long[] handlingId) {
        this.handlingId = handlingId;
    }

    public String[] getHandlingType() {
        return handlingType;
    }

    public void setHandlingType(String[] handlingType) {
        this.handlingType = handlingType;
    }

    public String getHandlingContent() {
        return handlingContent;
    }

    public void setHandlingContent(String handlingContent) {
        this.handlingContent = handlingContent;
    }

    public String getHandlingTimeFrom() {
        return handlingTimeFrom;
    }

    public void setHandlingTimeFrom(String handlingTimeFrom) {
        this.handlingTimeFrom = handlingTimeFrom;
    }

    public String getHandlingTimeTo() {
        return handlingTimeTo;
    }

    public void setHandlingTimeTo(String handlingTimeTo) {
        this.handlingTimeTo = handlingTimeTo;
    }

    public String[] getHandlingUid() {
        return handlingUid;
    }

    public void setHandlingUid(String[] handlingUid) {
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
}
