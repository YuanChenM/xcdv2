package com.bms.issue.bean.entity;

import java.util.Date;

import com.framework.base.rest.entity.BaseEntity;

/**
 * 问题订单总表
 * @author li_huiqian
 *
 */
public class IssueEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
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
     
      /** 问题订单编号 */
     private String issueCode;
     
     /**
      * 获取 问题订单编号
      * 
      * @return 问题订单编号
      */
     public String getIssueCode() {
    	 return this.issueCode;
     }
     
     /**
      * 设置 问题订单编号
      * 
      * @param issueCode 问题订单编号
      */
     public void setIssueCode(String issueCode) {
    	 this.issueCode = issueCode;
     }
     
      /** 原始订单ID */
     private Long orderId;
     
     /**
      * 获取 原始订单ID
      * 
      * @return 原始订单ID
      */
     public Long getOrderId() {
    	 return this.orderId;
     }
     
     /**
      * 设置 原始订单ID
      * 
      * @param orderId 原始订单ID
      */
     public void setOrderId(Long orderId) {
    	 this.orderId = orderId;
     }
     
      /** 原始订单编号 */
     private String orderCode;
     
     /**
      * 获取 原始订单编号
      * 
      * @return 原始订单编号
      */
     public String getOrderCode() {
    	 return this.orderCode;
     }
     
     /**
      * 设置 原始订单编号
      * 
      * @param orderCode 原始订单编号
      */
     public void setOrderCode(String orderCode) {
    	 this.orderCode = orderCode;
     }
     
      /** 原始订单类型 */
     private String orderType;
     
     /**
      * 获取 原始订单类型
      * 
      * @return 原始订单类型
      */
     public String getOrderType() {
    	 return this.orderType;
     }
     
     /**
      * 设置 原始订单类型
      * 
      * @param orderType 原始订单类型
      */
     public void setOrderType(String orderType) {
    	 this.orderType = orderType;
     }
     
      /** 区域：物流区编码 */
     private String logisticsZoneCode;
     
     /**
      * 获取 区域：物流区编码
      * 
      * @return 区域：物流区编码
      */
     public String getLogisticsZoneCode() {
    	 return this.logisticsZoneCode;
     }
     
     /**
      * 设置 区域：物流区编码
      * 
      * @param logisticsZoneCode 区域：物流区编码
      */
     public void setLogisticsZoneCode(String logisticsZoneCode) {
    	 this.logisticsZoneCode = logisticsZoneCode;
     }
     
      /** 区域：物流区名称 */
     private String logisticsZoneName;
     
     /**
      * 获取 区域：物流区名称
      * 
      * @return 区域：物流区名称
      */
     public String getLogisticsZoneName() {
    	 return this.logisticsZoneName;
     }
     
     /**
      * 设置 区域：物流区名称
      * 
      * @param logisticsZoneName 区域：物流区名称
      */
     public void setLogisticsZoneName(String logisticsZoneName) {
    	 this.logisticsZoneName = logisticsZoneName;
     }
     
      /** 区域：物流区ID */
     private Long logisticsZoneId;
     
     /**
      * 获取 区域：物流区ID
      * 
      * @return 区域：物流区ID
      */
     public Long getLogisticsZoneId() {
    	 return this.logisticsZoneId;
     }
     
     /**
      * 设置 区域：物流区ID
      * 
      * @param logisticsZoneId 区域：物流区ID
      */
     public void setLogisticsZoneId(Long logisticsZoneId) {
    	 this.logisticsZoneId = logisticsZoneId;
     }
     
      /** 买家：买家ID */
     private String buyerId;
     
     /**
      * 获取 买家：买家ID
      * 
      * @return 买家：买家ID
      */
     public String getBuyerId() {
    	 return this.buyerId;
     }
     
     /**
      * 设置 买家：买家ID
      * 
      * @param buyerId 买家：买家ID
      */
     public void setBuyerId(String buyerId) {
    	 this.buyerId = buyerId;
     }
     
      /** 买家：买家编码 */
     private String buyerCode;
     
     /**
      * 获取 买家：买家编码
      * 
      * @return 买家：买家编码
      */
     public String getBuyerCode() {
    	 return this.buyerCode;
     }
     
     /**
      * 设置 买家：买家编码
      * 
      * @param buyerCode 买家：买家编码
      */
     public void setBuyerCode(String buyerCode) {
    	 this.buyerCode = buyerCode;
     }
     
      /** 买家：买家名称 */
     private String buyerName;
     
     /**
      * 获取 买家：买家名称
      * 
      * @return 买家：买家名称
      */
     public String getBuyerName() {
    	 return this.buyerName;
     }
     
     /**
      * 设置 买家：买家名称
      * 
      * @param buyerName 买家：买家名称
      */
     public void setBuyerName(String buyerName) {
    	 this.buyerName = buyerName;
     }
     
      /** 发起人类型 */
     private String initiatorType;
     
     /**
      * 获取 发起人类型
      * 
      * @return 发起人类型
      */
     public String getInitiatorType() {
    	 return this.initiatorType;
     }
     
     /**
      * 设置 发起人类型
      * 
      * @param initiatorType 发起人类型
      */
     public void setInitiatorType(String initiatorType) {
    	 this.initiatorType = initiatorType;
     }
     
      /** 发起人ID */
     private String initiatorId;
     
     /**
      * 获取 发起人ID
      * 
      * @return 发起人ID
      */
     public String getInitiatorId() {
    	 return this.initiatorId;
     }
     
     /**
      * 设置 发起人ID
      * 
      * @param initiatorId 发起人ID
      */
     public void setInitiatorId(String initiatorId) {
    	 this.initiatorId = initiatorId;
     }
     
      /** 发起人名称 */
     private String initiatorName;
     
     /**
      * 获取 发起人名称
      * 
      * @return 发起人名称
      */
     public String getInitiatorName() {
    	 return this.initiatorName;
     }
     
     /**
      * 设置 发起人名称
      * 
      * @param initiatorName 发起人名称
      */
     public void setInitiatorName(String initiatorName) {
    	 this.initiatorName = initiatorName;
     }
     
      /** 发起时间 */
     private Date initiateTime;
     
     /**
      * 获取 发起时间
      * 
      * @return 发起时间
      */
     public Date getInitiateTime() {
    	 return this.initiateTime;
     }
     
     /**
      * 设置 发起时间
      * 
      * @param initiateTime 发起时间
      */
     public void setInitiateTime(Date initiateTime) {
    	 this.initiateTime = initiateTime;
     }
     
      /** 问题概述 */
     private String issueDesc;
     
     /**
      * 获取 问题概述
      * 
      * @return 问题概述
      */
     public String getIssueDesc() {
    	 return this.issueDesc;
     }
     
     /**
      * 设置 问题概述
      * 
      * @param issueDesc 问题概述
      */
     public void setIssueDesc(String issueDesc) {
    	 this.issueDesc = issueDesc;
     }
     
      /** 问题订单处理结果 */
     private String issueResult;
     
     /**
      * 获取 问题订单处理结果
      * 
      * @return 问题订单处理结果
      */
     public String getIssueResult() {
    	 return this.issueResult;
     }
     
     /**
      * 设置 问题订单处理结果
      * 
      * @param issueResult 问题订单处理结果
      */
     public void setIssueResult(String issueResult) {
    	 this.issueResult = issueResult;
     }
     
      /** 问题订单处理结论 */
     private String issueDecision;
     
     /**
      * 获取 问题订单处理结论
      * 
      * @return 问题订单处理结论
      */
     public String getIssueDecision() {
    	 return this.issueDecision;
     }
     
     /**
      * 设置 问题订单处理结论
      * 
      * @param issueDecision 问题订单处理结论
      */
     public void setIssueDecision(String issueDecision) {
    	 this.issueDecision = issueDecision;
     }
     
      /** 结案人ID */
     private String closeUid;
     
     /**
      * 获取 结案人ID
      * 
      * @return 结案人ID
      */
     public String getCloseUid() {
    	 return this.closeUid;
     }
     
     /**
      * 设置 结案人ID
      * 
      * @param closeUid 结案人ID
      */
     public void setCloseUid(String closeUid) {
    	 this.closeUid = closeUid;
     }
     
      /** 结案人名称 */
     private String closeUname;
     
     /**
      * 获取 结案人名称
      * 
      * @return 结案人名称
      */
     public String getCloseUname() {
    	 return this.closeUname;
     }
     
     /**
      * 设置 结案人名称
      * 
      * @param closeUname 结案人名称
      */
     public void setCloseUname(String closeUname) {
    	 this.closeUname = closeUname;
     }
     
      /** 结案时间 */
     private Date closeTime;
     
     /**
      * 获取 结案时间
      * 
      * @return 结案时间
      */
     public Date getCloseTime() {
    	 return this.closeTime;
     }
     
     /**
      * 设置 结案时间
      * 
      * @param closeTime 结案时间
      */
     public void setCloseTime(Date closeTime) {
    	 this.closeTime = closeTime;
     }
     
      /** 问题订单状态 */
     private String issueStatus;
     
     /**
      * 获取 问题订单状态
      * 
      * @return 问题订单状态
      */
     public String getIssueStatus() {
    	 return this.issueStatus;
     }
     
     /**
      * 设置 问题订单状态
      * 
      * @param issueStatus 问题订单状态
      */
     public void setIssueStatus(String issueStatus) {
    	 this.issueStatus = issueStatus;
     }
     
 }
