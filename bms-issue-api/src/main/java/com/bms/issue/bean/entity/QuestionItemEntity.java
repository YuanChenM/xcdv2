package com.bms.issue.bean.entity;

import java.util.Date;

import com.framework.base.rest.entity.BaseEntity;

/**
 * 问题订单问题表明细问题点
 * @author li_huiqian
 *
 */
public class QuestionItemEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
      /** 问题点ID */
     private Long itemId;
     
     /**
      * 获取 问题点ID
      * 
      * @return 问题点ID
      */
     public Long getItemId() {
    	 return this.itemId;
     }
     
     /**
      * 设置 问题点ID
      * 
      * @param itemId 问题点ID
      */
     public void setItemId(Long itemId) {
    	 this.itemId = itemId;
     }
     
      /** 问题ID */
     private Long questionId;
     
     /**
      * 获取 问题ID
      * 
      * @return 问题ID
      */
     public Long getQuestionId() {
    	 return this.questionId;
     }
     
     /**
      * 设置 问题ID
      * 
      * @param questionId 问题ID
      */
     public void setQuestionId(Long questionId) {
    	 this.questionId = questionId;
     }
     
      /** 问题点描述 */
     private String itemDesc;
     
     /**
      * 获取 问题点描述
      * 
      * @return 问题点描述
      */
     public String getItemDesc() {
    	 return this.itemDesc;
     }
     
     /**
      * 设置 问题点描述
      * 
      * @param itemDesc 问题点描述
      */
     public void setItemDesc(String itemDesc) {
    	 this.itemDesc = itemDesc;
     }
     
      /** 问题点执行方案 */
     private String itemSolution;
     
     /**
      * 获取 问题点执行方案
      * 
      * @return 问题点执行方案
      */
     public String getItemSolution() {
    	 return this.itemSolution;
     }
     
     /**
      * 设置 问题点执行方案
      * 
      * @param itemSolution 问题点执行方案
      */
     public void setItemSolution(String itemSolution) {
    	 this.itemSolution = itemSolution;
     }
     
      /** 问题点方案执行人 */
     private String itemExcutor;
     
     /**
      * 获取 问题点方案执行人
      * 
      * @return 问题点方案执行人
      */
     public String getItemExcutor() {
    	 return this.itemExcutor;
     }
     
     /**
      * 设置 问题点方案执行人
      * 
      * @param itemExcutor 问题点方案执行人
      */
     public void setItemExcutor(String itemExcutor) {
    	 this.itemExcutor = itemExcutor;
     }
     
      /** 问题点方案执行时间 */
     private Date itemStartTime;
     
     /**
      * 获取 问题点方案执行时间
      * 
      * @return 问题点方案执行时间
      */
     public Date getItemStartTime() {
    	 return this.itemStartTime;
     }
     
     /**
      * 设置 问题点方案执行时间
      * 
      * @param itemStartTime 问题点方案执行时间
      */
     public void setItemStartTime(Date itemStartTime) {
    	 this.itemStartTime = itemStartTime;
     }
     
      /** 问题点处理完成时间 */
     private Date itemEndTime;
     
     /**
      * 获取 问题点处理完成时间
      * 
      * @return 问题点处理完成时间
      */
     public Date getItemEndTime() {
    	 return this.itemEndTime;
     }
     
     /**
      * 设置 问题点处理完成时间
      * 
      * @param itemEndTime 问题点处理完成时间
      */
     public void setItemEndTime(Date itemEndTime) {
    	 this.itemEndTime = itemEndTime;
     }
     
      /** 问题点处理结果 */
     private String itemResult;
     
     /**
      * 获取 问题点处理结果
      * 
      * @return 问题点处理结果
      */
     public String getItemResult() {
    	 return this.itemResult;
     }
     
     /**
      * 设置 问题点处理结果
      * 
      * @param itemResult 问题点处理结果
      */
     public void setItemResult(String itemResult) {
    	 this.itemResult = itemResult;
     }
     
      /** 当事人意见 */
     private String itemFeedback;
     
     /**
      * 获取 当事人意见
      * 
      * @return 当事人意见
      */
     public String getItemFeedback() {
    	 return this.itemFeedback;
     }
     
     /**
      * 设置 当事人意见
      * 
      * @param itemFeedback 当事人意见
      */
     public void setItemFeedback(String itemFeedback) {
    	 this.itemFeedback = itemFeedback;
     }
     
      /** 问题点结案人 */
     private String itemCloser;
     
     /**
      * 获取 问题点结案人
      * 
      * @return 问题点结案人
      */
     public String getItemCloser() {
    	 return this.itemCloser;
     }
     
     /**
      * 设置 问题点结案人
      * 
      * @param itemCloser 问题点结案人
      */
     public void setItemCloser(String itemCloser) {
    	 this.itemCloser = itemCloser;
     }
     
      /** 问题点结案时间 */
     private Date itemCloseTime;
     
     /**
      * 获取 问题点结案时间
      * 
      * @return 问题点结案时间
      */
     public Date getItemCloseTime() {
    	 return this.itemCloseTime;
     }
     
     /**
      * 设置 问题点结案时间
      * 
      * @param itemCloseTime 问题点结案时间
      */
     public void setItemCloseTime(Date itemCloseTime) {
    	 this.itemCloseTime = itemCloseTime;
     }
     
 }
