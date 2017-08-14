package com.bms.issue.bean.param;

import com.bms.issue.archive.impl.QuestionHandling;
import com.bms.issue.bean.entity.QuestionHandlingEntity;
import com.bms.issue.common.rest.param.RestBean;


/**
 * 问题处理/结案建议新增接口Param
 *
 * @author li_huiqian
 */
public class ISSU0208IBean extends RestBean {
    private static final long serialVersionUID = 1L;


    /**
     * 获取 实体
     *
     * @return
     */
    public QuestionHandling getQuestionHandling() {
        QuestionHandlingEntity entity = new QuestionHandlingEntity();
        entity.setQuestionId(questionId);
        entity.setHandlingType(handlingType);
        entity.setHandlingContent(handlingContent);
        entity.setHandlingUid(handlingUid);
        entity.setHandlingUname(handlingUname);
        entity.setHandlingResult(handlingResult);
        entity.setHandlingResultReason(handlingResultReason);
        QuestionHandling questionHandling=new QuestionHandling(entity);
        return questionHandling;
    }


    /**
     * 问题ID
     */
    private Long questionId;


    /**
     * 问题管理类型
     */
    private String handlingType;


    /**
     * 申请或建议的内容
     */
    private String handlingContent;


    /**
     * 提交申请或建议的时间
     */
    private String handlingTime;

    /**
     * 提交申请或建议的人员ID
     */
    private String handlingUid;

    /**
     * 提交申请或建议的人员名称
     */
    private String handlingUname;
    /**
     * 问题结案结论
     */
    private String handlingResult;

    /**
     * 申请或建议结论的原因
     */
    private String handlingResultReason;


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
}
