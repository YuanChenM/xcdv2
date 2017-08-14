package com.bms.issue.bean.entity;


import com.framework.base.rest.entity.BaseEntity;

/**
 * 问题附件
 * @author li_huiqian
 *
 */
public class QuestionAccessoryEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
      /** 问题附件ID */
     private Long accessoryId;
     
     /**
      * 获取 问题附件ID
      * 
      * @return 问题附件ID
      */
     public Long getAccessoryId() {
    	 return this.accessoryId;
     }
     
     /**
      * 设置 问题附件ID
      * 
      * @param accessoryId 问题附件ID
      */
     public void setAccessoryId(Long accessoryId) {
    	 this.accessoryId = accessoryId;
     }
     
      /** 附件所属主体类型 */
     private String accessoryType;
     
     /**
      * 获取 附件所属主体类型
      * 
      * @return 附件所属主体类型
      */
     public String getAccessoryType() {
    	 return this.accessoryType;
     }
     
     /**
      * 设置 附件所属主体类型
      * 
      * @param accessoryType 附件所属主体类型
      */
     public void setAccessoryType(String accessoryType) {
    	 this.accessoryType = accessoryType;
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
     
      /** 附件文件 */
     private String fileId;
     
     /**
      * 获取 附件文件
      * 
      * @return 附件文件
      */
     public String getFileId() {
    	 return this.fileId;
     }
     
     /**
      * 设置 附件文件
      * 
      * @param fileId 附件文件
      */
     public void setFileId(String fileId) {
    	 this.fileId = fileId;
     }
     
      /** 附件名称 */
     private String fileName;
     
     /**
      * 获取 附件名称
      * 
      * @return 附件名称
      */
     public String getFileName() {
    	 return this.fileName;
     }
     
     /**
      * 设置 附件名称
      * 
      * @param fileName 附件名称
      */
     public void setFileName(String fileName) {
    	 this.fileName = fileName;
     }
     
      /** 附件类型 */
     private String fileType;
     
     /**
      * 获取 附件类型
      * 
      * @return 附件类型
      */
     public String getFileType() {
    	 return this.fileType;
     }
     
     /**
      * 设置 附件类型
      * 
      * @param fileType 附件类型
      */
     public void setFileType(String fileType) {
    	 this.fileType = fileType;
     }
     
 }
