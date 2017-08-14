package com.bms.issue.bean.param;

import com.bms.issue.archive.impl.Issue;
import com.bms.issue.archive.impl.Question;
import com.bms.issue.archive.impl.QuestionAccessory;
import com.bms.issue.bean.entity.QuestionAccessoryEntity;
import com.bms.issue.bean.entity.QuestionEntity;
import com.bms.issue.common.rest.param.RestBean;
import com.bms.issue.constant.enumeration.AccessoryType;
import com.framework.core.utils.DateUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题订单问题新增接口Param
 *
 * @author li_huiqian
 */
public class ISSU0201IBean extends RestBean {

    private static final long serialVersionUID = 1L;

    /** 问题订单ID*/
    private Long issueId;

    /** 订单明细ID*/
    private Long orderDetailId;

    /** 一级分类*/
    private String questionCatagory1;

    /** 二级分类*/
    private String questionCatagory2;

    /** 三级分类*/
    private String questionCatagory3;

    /** 问题关键词*/
    private String questionKeyword;

    /** 问题描述*/
    private String questionDesc;

    /** 问题附件*/
    private List<ISSU0201Accessory> accessorys;

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
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

    public List<ISSU0201Accessory> getAccessorys() {
        return accessorys;
    }

    public void setAccessorys(List<ISSU0201Accessory> accessorys) {
        this.accessorys = accessorys;
    }



    /**
     * 问题附件
     */
    public static class ISSU0201Accessory{

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
            questionAccessoryEntity.setAccessoryType(AccessoryType.QUESTION.getCode());
            questionAccessoryEntity.setFileId(fileId);
            questionAccessoryEntity.setFileName(fileName);
            questionAccessoryEntity.setFileType(fileType);
            QuestionAccessory questionAccessory = QuestionAccessory.build(null).forCreate(questionAccessoryEntity);
            return questionAccessory;
        }
    }


    /**
     * 根据问题订单ID查询问题订单总表
     * @return
     */
    public Issue getIssueById(){
        Issue issue = Issue.build(null).forComplete(issueId);
        return issue;
    }

    public Question createQuestion(){
        List<QuestionAccessory> questionAccessoryList = new ArrayList<>();
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setIssueId(issueId);
        questionEntity.setOrderDetailId(orderDetailId);
        questionEntity.setQuestionCatagory1(questionCatagory1);
        questionEntity.setQuestionCatagory2(questionCatagory2);
        questionEntity.setQuestionCatagory3(questionCatagory3);
        questionEntity.setQuestionKeyword(questionKeyword);
        questionEntity.setQuestionDesc(questionDesc);
        questionEntity.setQuestionIsClose(false);
        Question question = Question.build(null).forCreate(questionEntity);
        if(!CollectionUtils.isEmpty(accessorys)){
            for(ISSU0201Accessory issu0201Accessory : accessorys) {
                questionAccessoryList.add(issu0201Accessory.createQuestionAccessory());
            }
        }
        question.link(questionAccessoryList);
        return question;
    }
}
