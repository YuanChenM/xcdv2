package com.bms.issue.bean.result;

import com.bms.issue.common.rest.result.RestSearchData;

import java.util.List;

/**
 * Created by Administrator on 2017/2/21.
 */
public class ISSU0211IRestResult extends RestSearchData {

    private static final long serialVersionUID = 1L;

    /**
     * 问题ID
     */
    private Long questionId;
    /**
     * 问题点ID
     */
    private Long itemId;
    /**
     * 问题点描述
     */
    private String itemDesc;
    /**
     * 问题点处理方案
     */
    private String itemSolution;
    /**
     * 问题点方案执行人
     */
    private String itemExcutor;
    /**
     * 问题点方案执行时间
     */
    private String itemStartTime;
    /**
     * 问题点处理完成时间
     */
    private String itemEndTime;
    /**
     * 问题点处理结果
     */
    private String itemResult;
    /**
     * 当事人意见
     */
    private String itemFeedBack;
    /**
     * 问题点结案人
     */
    private String itemCloser;
    /**
     * 问题点结案时间
     */
    private String itemCloseTime;
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

    public Integer getSortSeq() {
        return sortSeq;
    }

    public void setSortSeq(Integer sortSeq) {
        this.sortSeq = sortSeq;
    }

    private List<ISSUAccessorysRestResult> accessorys;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getItemSolution() {
        return itemSolution;
    }

    public void setItemSolution(String itemSolution) {
        this.itemSolution = itemSolution;
    }

    public String getItemExcutor() {
        return itemExcutor;
    }

    public void setItemExcutor(String itemExcutor) {
        this.itemExcutor = itemExcutor;
    }

    public String getItemStartTime() {
        return itemStartTime;
    }

    public void setItemStartTime(String itemStartTime) {
        this.itemStartTime = itemStartTime;
    }

    public String getItemEndTime() {
        return itemEndTime;
    }

    public void setItemEndTime(String itemEndTime) {
        this.itemEndTime = itemEndTime;
    }

    public String getItemResult() {
        return itemResult;
    }

    public void setItemResult(String itemResult) {
        this.itemResult = itemResult;
    }

    public String getItemFeedBack() {
        return itemFeedBack;
    }

    public void setItemFeedBack(String itemFeedBack) {
        this.itemFeedBack = itemFeedBack;
    }

    public String getItemCloser() {
        return itemCloser;
    }

    public void setItemCloser(String itemCloser) {
        this.itemCloser = itemCloser;
    }

    public String getItemCloseTime() {
        return itemCloseTime;
    }

    public void setItemCloseTime(String itemCloseTime) {
        this.itemCloseTime = itemCloseTime;
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
