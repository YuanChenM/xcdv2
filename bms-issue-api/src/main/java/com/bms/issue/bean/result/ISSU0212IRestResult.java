package com.bms.issue.bean.result;

import com.bms.issue.common.rest.result.RestSearchData;

/**
 * Created by Administrator on 2017/2/21.
 */
public class ISSU0212IRestResult extends RestSearchData {

    private static final long serialVersionUID = 1L;

    /**
     * 问题ID
     */
    private Long questionId;
    /**
     * 问题管理ID
     */
    private Long handlingId;
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
    /**
     * 删除标记
     */
    private Boolean delFlg;
    /**
     * 创建者ID
     */
    private String crtId;
    /**
     * 创建时间(yyyy-MM-dd HH:mm:ss)
     */
    private String crtTime;
    /**
     * 更新者ID
     */
    private String updId;
    /**
     * 更新时间(yyyy-MM-dd HH:mm:ss)
     */
    private String updTime;
    /**
     * 版本
     */
    private Integer ver;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getHandlingId() {
        return handlingId;
    }

    public void setHandlingId(Long handlingId) {
        this.handlingId = handlingId;
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

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public String getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(String crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public String getUpdTime() {
        return updTime;
    }

    public void setUpdTime(String updTime) {
        this.updTime = updTime;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }
}
