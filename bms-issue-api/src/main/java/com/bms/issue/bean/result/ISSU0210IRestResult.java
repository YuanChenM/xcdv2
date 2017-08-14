package com.bms.issue.bean.result;

import com.bms.issue.common.rest.result.RestSearchData;

import java.util.List;

/**
 * Created by Administrator on 2017/2/20.
 */
public class ISSU0210IRestResult extends RestSearchData {

    private static final long serialVersionUID = 1L;

    /**
     * 问题订单ID
     */
    private Long issueId;
    /**
     * 问题ID
     */
    private Long questionId;
    /**
     * 问题编码
     */
    private String questionCode;
    /**
     * 问题明细ID
     */
    private Long orderDetailId;
    /**
     * 一级分类
     */
    private String questionCatagory1;
    /**
     * 二级分类
     */
    private String questionCatagory2;
    /**
     * 三级分类
     */
    private String questionCatagory3;
    /**
     * 问题关键词
     */
    private String questionKeyword;
    /**
     * 问题描述
     */
    private String questionDesc;
    /**
     * 问题立项时间
     */
    private String questionStartTime;
    /**
     * 问题立项人ID
     */
    private String questionStartUid;
    /**
     * 问题立项人名称
     */
    private String questionStartUname;
    /**
     * 问题是否立项
     */
    private Boolean questionIsClose;
    /**
     * 问题结案时间
     */
    private String questionCloseTime;
    /**
     * 问题立项人ID
     */
    private String questionCloseUid;
    /**
     * 问题立项人名称
     */
    private String questionCloseUname;
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

    private Integer sortSeq;

    private String orderCode;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getSortSeq() {
        return sortSeq;
    }

    public void setSortSeq(Integer sortSeq) {
        this.sortSeq = sortSeq;
    }

    private List<ISSUAccessorysRestResult> accessorys;

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionCode() {
        return questionCode;
    }

    public void setQuestionCode(String questionCode) {
        this.questionCode = questionCode;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getQuestionCatagory1() {
        return questionCatagory1;
    }

    public void setQuestionCatagory1(String questionCatagory1) {
        this.questionCatagory1 = questionCatagory1;
    }

    public String getQuestionCatagory2() {
        return questionCatagory2;
    }

    public void setQuestionCatagory2(String questionCatagory2) {
        this.questionCatagory2 = questionCatagory2;
    }

    public String getQuestionCatagory3() {
        return questionCatagory3;
    }

    public void setQuestionCatagory3(String questionCatagory3) {
        this.questionCatagory3 = questionCatagory3;
    }

    public String getQuestionKeyword() {
        return questionKeyword;
    }

    public void setQuestionKeyword(String questionKeyword) {
        this.questionKeyword = questionKeyword;
    }

    public String getQuestionDesc() {
        return questionDesc;
    }

    public void setQuestionDesc(String questionDesc) {
        this.questionDesc = questionDesc;
    }

    public String getQuestionStartTime() {
        return questionStartTime;
    }

    public void setQuestionStartTime(String questionStartTime) {
        this.questionStartTime = questionStartTime;
    }

    public String getQuestionStartUid() {
        return questionStartUid;
    }

    public void setQuestionStartUid(String questionStartUid) {
        this.questionStartUid = questionStartUid;
    }

    public String getQuestionStartUname() {
        return questionStartUname;
    }

    public void setQuestionStartUname(String questionStartUname) {
        this.questionStartUname = questionStartUname;
    }

    public Boolean getQuestionIsClose() {
        return questionIsClose;
    }

    public void setQuestionIsClose(Boolean questionIsClose) {
        this.questionIsClose = questionIsClose;
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

    public List<ISSUAccessorysRestResult> getAccessorys() {
        return accessorys;
    }

    public void setAccessorys(List<ISSUAccessorysRestResult> accessorys) {
        this.accessorys = accessorys;
    }
}
