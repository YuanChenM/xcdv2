package com.bms.issue.bean.entity;

import java.util.Date;

import com.framework.base.rest.entity.BaseEntity;

/**
 * 问题订单问题表管理信息
 * @author li_huiqian
 *
 */
public class QuestionHandlingEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
      /** 问题管理ID */
     private Long handlingId;
     
     /**
      * 获取 问题管理ID
      * 
      * @return 问题管理ID
      */
     public Long getHandlingId() {
    	 return this.handlingId;
     }
     
     /**
      * 设置 问题管理ID
      * 
      * @param handlingId 问题管理ID
      */
     public void setHandlingId(Long handlingId) {
    	 this.handlingId = handlingId;
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
     
      /** 问题管理类型 */
     private String handlingType;
     
     /**
      * 获取 问题管理类型
      * 
      * @return 问题管理类型
      */
     public String getHandlingType() {
    	 return this.handlingType;
     }
     
     /**
      * 设置 问题管理类型
      * 
      * @param handlingType 问题管理类型
      */
     public void setHandlingType(String handlingType) {
    	 this.handlingType = handlingType;
     }
     
      /** 申请或建议的内容 */
     private String handlingContent;
     
     /**
      * 获取 申请或建议的内容
      * 
      * @return 申请或建议的内容
      */
     public String getHandlingContent() {
    	 return this.handlingContent;
     }
     
     /**
      * 设置 申请或建议的内容
      * 
      * @param handlingContent 申请或建议的内容
      */
     public void setHandlingContent(String handlingContent) {
    	 this.handlingContent = handlingContent;
     }
     
      /** 提交申请或建议的时间 */
     private Date handlingTime;
     
     /**
      * 获取 提交申请或建议的时间
      * 
      * @return 提交申请或建议的时间
      */
     public Date getHandlingTime() {
    	 return this.handlingTime;
     }
     
     /**
      * 设置 提交申请或建议的时间
      * 
      * @param handlingTime 提交申请或建议的时间
      */
     public void setHandlingTime(Date handlingTime) {
    	 this.handlingTime = handlingTime;
     }
     
      /** 提交申请或建议的人员ID */
     private String handlingUid;
     
     /**
      * 获取 提交申请或建议的人员ID
      * 
      * @return 提交申请或建议的人员ID
      */
     public String getHandlingUid() {
    	 return this.handlingUid;
     }
     
     /**
      * 设置 提交申请或建议的人员ID
      * 
      * @param handlingUid 提交申请或建议的人员ID
      */
     public void setHandlingUid(String handlingUid) {
    	 this.handlingUid = handlingUid;
     }
     
      /** 提交申请或建议的人员名称 */
     private String handlingUname;
     
     /**
      * 获取 提交申请或建议的人员名称
      * 
      * @return 提交申请或建议的人员名称
      */
     public String getHandlingUname() {
    	 return this.handlingUname;
     }
     
     /**
      * 设置 提交申请或建议的人员名称
      * 
      * @param handlingUname 提交申请或建议的人员名称
      */
     public void setHandlingUname(String handlingUname) {
    	 this.handlingUname = handlingUname;
     }
     
      /** 问题结案结论 */
     private String handlingResult;
     
     /**
      * 获取 问题结案结论
      * 
      * @return 问题结案结论
      */
     public String getHandlingResult() {
    	 return this.handlingResult;
     }
     
     /**
      * 设置 问题结案结论
      * 
      * @param handlingResult 问题结案结论
      */
     public void setHandlingResult(String handlingResult) {
    	 this.handlingResult = handlingResult;
     }
     
      /** 申请或建议结论的原因 */
     private String handlingResultReason;
     
     /**
      * 获取 申请或建议结论的原因
      * 
      * @return 申请或建议结论的原因
      */
     public String getHandlingResultReason() {
    	 return this.handlingResultReason;
     }
     
     /**
      * 设置 申请或建议结论的原因
      * 
      * @param handlingResultReason 申请或建议结论的原因
      */
     public void setHandlingResultReason(String handlingResultReason) {
    	 this.handlingResultReason = handlingResultReason;
     }
     
 }
