package com.bms.issue.bean.param;

import com.bms.issue.common.rest.param.RestFilter;

/**
 * Created by Administrator on 2017/2/21.
 */
public class ISSU0211IFilter extends RestFilter {

    private static final long serialVersionUID = 1L;

    /**
     * 问题ID
     */
    private Long[] questionId;
    /**
     * 问题点ID
     */
    private Long[] itemId;
    /**
     * 问题点描述，模糊检索
     */
    private String itemDesc;
    /**
     * 问题点处理方案，模糊检索
     */
    private String itemSolution;
    /**
     * 问题点方案执行人，模糊检索
     */
    private String itemExcutor;
    /**
     * 问题点方案执行时间开始
     */
    private String itemStartTimeFrom;
    /**
     * 问题点方案执行时间结束
     */
    private String itemStartTimeTo;
    /**
     * 问题点处理完成时间开始
     */
    private String itemEndTimeFrom;
    /**
     * 问题点处理完成时间结束
     */
    private String itemEndTimeTo;
    /**
     * 问题点处理结果，模糊检索
     */
    private String itemResult;
    /**
     * 当事人意见，模糊检索
     */
    private String itemFeedBack;
    /**
     * 问题点结案人，模糊检索
     */
    private String itemCloser;
    /**
     * 问题点结案时间开始
     */
    private String itemCloseTimeFrom;
    /**
     * 问题点结案时间结束
     */
    private String itemCloseTimeTo;
    /**
     * 附件ID
     */
    private Long[] accessoryId;
    /**
     * 文件ID
     */
    private String[] fileId;


    public Long[] getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long[] questionId) {
        this.questionId = questionId;
    }

    public Long[] getItemId() {
        return itemId;
    }

    public void setItemId(Long[] itemId) {
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

    public String getItemStartTimeFrom() {
        return itemStartTimeFrom;
    }

    public void setItemStartTimeFrom(String itemStartTimeFrom) {
        this.itemStartTimeFrom = itemStartTimeFrom;
    }

    public String getItemStartTimeTo() {
        return itemStartTimeTo;
    }

    public void setItemStartTimeTo(String itemStartTimeTo) {
        this.itemStartTimeTo = itemStartTimeTo;
    }

    public String getItemEndTimeFrom() {
        return itemEndTimeFrom;
    }

    public void setItemEndTimeFrom(String itemEndTimeFrom) {
        this.itemEndTimeFrom = itemEndTimeFrom;
    }

    public String getItemEndTimeTo() {
        return itemEndTimeTo;
    }

    public void setItemEndTimeTo(String itemEndTimeTo) {
        this.itemEndTimeTo = itemEndTimeTo;
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

    public String getItemCloseTimeFrom() {
        return itemCloseTimeFrom;
    }

    public void setItemCloseTimeFrom(String itemCloseTimeFrom) {
        this.itemCloseTimeFrom = itemCloseTimeFrom;
    }

    public String getItemCloseTimeTo() {
        return itemCloseTimeTo;
    }

    public void setItemCloseTimeTo(String itemCloseTimeTo) {
        this.itemCloseTimeTo = itemCloseTimeTo;
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
