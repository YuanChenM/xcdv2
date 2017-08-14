package com.bms.issue.bean.param;

import com.bms.issue.archive.impl.QuestionAccessory;
import com.bms.issue.archive.impl.QuestionItem;
import com.bms.issue.bean.entity.QuestionAccessoryEntity;
import com.bms.issue.bean.entity.QuestionItemEntity;
import com.bms.issue.common.rest.param.RestBean;
import com.bms.issue.constant.enumeration.AccessoryType;
import com.framework.core.utils.DateUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 问题点新增接口Param
 *
 * @author li_huiqian
 */
public class ISSU0206IBean extends RestBean {
    private static final long serialVersionUID = 1L;
    private Long questionId;//问题ID
    private String itemDesc;//问题点描述
    private String itemSolution;//问题点执行方案
    private String itemExcutor;//问题点方案执行人
    private String itemStartTime;//问题点方案执行时间(yyyy-MM-dd HH;mm:ss)
    private String itemEndTime;//问题点处理完成时间
    private String itemResult;//问题点处理结果
    private String itemFeedBack;//当事人意见
    private String itemCloser;//问题点结案人
    private String itemCloseTime;//问题点结案时间(yyyy-MM-dd HH;mm:ss)
    /** 问题附件*/
    private List<ISSU0206Accessory> accessorys;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
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

    public List<ISSU0206Accessory> getAccessorys() {
        return accessorys;
    }

    public void setAccessorys(List<ISSU0206Accessory> accessorys) {
        this.accessorys = accessorys;
    }

    /**
     * 问题附件
     */
    public static class ISSU0206Accessory{

        /** 附件文件ID*/
        private String fileId;

        /** 附件文件名称*/
        private String fileName;

        /** 附件文件类型*/
        private String fileType;

        public String getFileId() {
            return fileId;
        }

        public void setFileId(String fileId) {
            this.fileId = fileId;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getFileType() {
            return fileType;
        }

        public void setFileType(String fileType) {
            this.fileType = fileType;
        }

        public QuestionAccessory createQuestionAccessory(){
            QuestionAccessoryEntity questionAccessoryEntity = new QuestionAccessoryEntity();
            questionAccessoryEntity.setAccessoryType(AccessoryType.QUESTION_POINT.getCode());
            questionAccessoryEntity.setFileId(fileId);
            questionAccessoryEntity.setFileName(fileName);
            questionAccessoryEntity.setFileType(fileType);
            QuestionAccessory questionAccessory = QuestionAccessory.build(null).forCreate(questionAccessoryEntity);
            return questionAccessory;
        }
    }
    public QuestionItem createQuestionItem(){
        List<QuestionAccessory> questionAccessoryList = new ArrayList<>();
        QuestionItemEntity entity = new QuestionItemEntity();
        entity.setQuestionId(questionId);
        entity.setItemDesc(itemDesc);
        entity.setItemSolution(itemSolution);
        entity.setItemExcutor(itemExcutor);
        entity.setItemStartTime(DateUtils.parseDateTime(itemStartTime));
        entity.setItemEndTime(DateUtils.parseDateTime(itemEndTime));
        entity.setItemResult(itemResult);
        entity.setItemFeedback(itemFeedBack);
        entity.setItemCloser(itemCloser);
        entity.setItemCloseTime(DateUtils.parseDateTime(itemCloseTime));
        QuestionItem questionItem = QuestionItem.build(null).forCreate(entity);
        if(!CollectionUtils.isEmpty(accessorys)){
            for(ISSU0206Accessory issu0206Accessory : accessorys) {
                questionAccessoryList.add(issu0206Accessory.createQuestionAccessory());
            }
        }
        questionItem.link(questionAccessoryList);
        return questionItem;
    }
}
