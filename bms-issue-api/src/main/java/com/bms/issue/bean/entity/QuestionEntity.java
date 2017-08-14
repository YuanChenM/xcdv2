package com.bms.issue.bean.entity;

import java.util.Date;

import com.framework.base.rest.entity.BaseEntity;

/**
 * 问题订单问题表
 * @author li_huiqian
 *
 */
public class QuestionEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
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
     
      /** 问题处理单编号 */
     private String questionCode;
     
     /**
      * 获取 问题处理单编号
      * 
      * @return 问题处理单编号
      */
     public String getQuestionCode() {
    	 return this.questionCode;
     }
     
     /**
      * 设置 问题处理单编号
      * 
      * @param questionCode 问题处理单编号
      */
     public void setQuestionCode(String questionCode) {
    	 this.questionCode = questionCode;
     }
     
      /** 问题订单ID */
     private Long issueId;
     
     /**
      * 获取 问题订单ID
      * 
      * @return 问题订单ID
      */
     public Long getIssueId() {
    	 return this.issueId;
     }
     
     /**
      * 设置 问题订单ID
      * 
      * @param issueId 问题订单ID
      */
     public void setIssueId(Long issueId) {
    	 this.issueId = issueId;
     }
     
      /** 订单明细ID */
     private Long orderDetailId;
     
     /**
      * 获取 订单明细ID
      * 
      * @return 订单明细ID
      */
     public Long getOrderDetailId() {
    	 return this.orderDetailId;
     }
     
     /**
      * 设置 订单明细ID
      * 
      * @param orderDetailId 订单明细ID
      */
     public void setOrderDetailId(Long orderDetailId) {
    	 this.orderDetailId = orderDetailId;
     }
     
      /** 问题一级分类 */
     private String questionCatagory1;
     
     /**
      * 获取 问题一级分类
      * 
      * @return 问题一级分类
      */
     public String getQuestionCatagory1() {
    	 return this.questionCatagory1;
     }
     
     /**
      * 设置 问题一级分类
      * 
      * @param questionCatagory1 问题一级分类
      */
     public void setQuestionCatagory1(String questionCatagory1) {
    	 this.questionCatagory1 = questionCatagory1;
     }
     
      /** 问题二级分类 */
     private String questionCatagory2;
     
     /**
      * 获取 问题二级分类
      * 
      * @return 问题二级分类
      */
     public String getQuestionCatagory2() {
    	 return this.questionCatagory2;
     }
     
     /**
      * 设置 问题二级分类
      * 
      * @param questionCatagory2 问题二级分类
      */
     public void setQuestionCatagory2(String questionCatagory2) {
    	 this.questionCatagory2 = questionCatagory2;
     }
     
      /** 问题三级分类 */
     private String questionCatagory3;
     
     /**
      * 获取 问题三级分类
      * 
      * @return 问题三级分类
      */
     public String getQuestionCatagory3() {
    	 return this.questionCatagory3;
     }
     
     /**
      * 设置 问题三级分类
      * 
      * @param questionCatagory3 问题三级分类
      */
     public void setQuestionCatagory3(String questionCatagory3) {
    	 this.questionCatagory3 = questionCatagory3;
     }
     
      /** 问题关键词 */
     private String questionKeyword;
     
     /**
      * 获取 问题关键词
      * 
      * @return 问题关键词
      */
     public String getQuestionKeyword() {
    	 return this.questionKeyword;
     }
     
     /**
      * 设置 问题关键词
      * 
      * @param questionKeyword 问题关键词
      */
     public void setQuestionKeyword(String questionKeyword) {
    	 this.questionKeyword = questionKeyword;
     }
     
      /** 问题描述 */
     private String questionDesc;
     
     /**
      * 获取 问题描述
      * 
      * @return 问题描述
      */
     public String getQuestionDesc() {
    	 return this.questionDesc;
     }
     
     /**
      * 设置 问题描述
      * 
      * @param questionDesc 问题描述
      */
     public void setQuestionDesc(String questionDesc) {
    	 this.questionDesc = questionDesc;
     }
     
      /** 问题管理立项时间 */
     private Date questionStartTime;
     
     /**
      * 获取 问题管理立项时间
      * 
      * @return 问题管理立项时间
      */
     public Date getQuestionStartTime() {
    	 return this.questionStartTime;
     }
     
     /**
      * 设置 问题管理立项时间
      * 
      * @param questionStartTime 问题管理立项时间
      */
     public void setQuestionStartTime(Date questionStartTime) {
    	 this.questionStartTime = questionStartTime;
     }
     
      /** 问题管理立项人ID */
     private String questionStartUid;
     
     /**
      * 获取 问题管理立项人ID
      * 
      * @return 问题管理立项人ID
      */
     public String getQuestionStartUid() {
    	 return this.questionStartUid;
     }
     
     /**
      * 设置 问题管理立项人ID
      * 
      * @param questionStartUid 问题管理立项人ID
      */
     public void setQuestionStartUid(String questionStartUid) {
    	 this.questionStartUid = questionStartUid;
     }
     
      /** 问题管理立项人名称 */
     private String questionStartUname;
     
     /**
      * 获取 问题管理立项人名称
      * 
      * @return 问题管理立项人名称
      */
     public String getQuestionStartUname() {
    	 return this.questionStartUname;
     }
     
     /**
      * 设置 问题管理立项人名称
      * 
      * @param questionStartUname 问题管理立项人名称
      */
     public void setQuestionStartUname(String questionStartUname) {
    	 this.questionStartUname = questionStartUname;
     }
     
      /** 问题管理是否结案 */
     private Boolean questionIsClose;
     
     /**
      * 获取 问题管理是否结案
      * 
      * @return 问题管理是否结案
      */
     public Boolean isQuestionIsClose() {
    	 return this.questionIsClose;
     }
     
     /**
      * 设置 问题管理是否结案
      * 
      * @param questionIsClose 问题管理是否结案
      */
     public void setQuestionIsClose(Boolean questionIsClose) {
    	 this.questionIsClose = questionIsClose;
     }
     
      /** 问题管理结案时间 */
     private Date questionCloseTime;
     
     /**
      * 获取 问题管理结案时间
      * 
      * @return 问题管理结案时间
      */
     public Date getQuestionCloseTime() {
    	 return this.questionCloseTime;
     }
     
     /**
      * 设置 问题管理结案时间
      * 
      * @param questionCloseTime 问题管理结案时间
      */
     public void setQuestionCloseTime(Date questionCloseTime) {
    	 this.questionCloseTime = questionCloseTime;
     }
     
      /** 问题管理结案人 */
     private String questionCloseUid;
     
     /**
      * 获取 问题管理结案人
      * 
      * @return 问题管理结案人
      */
     public String getQuestionCloseUid() {
    	 return this.questionCloseUid;
     }
     
     /**
      * 设置 问题管理结案人
      * 
      * @param questionCloseUid 问题管理结案人
      */
     public void setQuestionCloseUid(String questionCloseUid) {
    	 this.questionCloseUid = questionCloseUid;
     }
     
      /** 问题管理结案人名称 */
     private String questionCloseUname;
     
     /**
      * 获取 问题管理结案人名称
      * 
      * @return 问题管理结案人名称
      */
     public String getQuestionCloseUname() {
    	 return this.questionCloseUname;
     }
     
     /**
      * 设置 问题管理结案人名称
      * 
      * @param questionCloseUname 问题管理结案人名称
      */
     public void setQuestionCloseUname(String questionCloseUname) {
    	 this.questionCloseUname = questionCloseUname;
     }
     
 }
