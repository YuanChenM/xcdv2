package com.bms.issue.bean.param;

import com.bms.issue.archive.impl.QuestionAccessory;
import com.bms.issue.bean.entity.QuestionAccessoryEntity;
import com.bms.issue.common.rest.param.RestBean;
import com.bms.issue.constant.enumeration.AccessoryType;

import java.util.List;

/**
 * 问题订单问题修改接口Param
 *
 * @author li_huiqian
 */
public class ISSU0203IBean extends RestBean {
    private static final long serialVersionUID = 1L;


    /**
     * 问题ID
     */
    private Long questionId;

    /**
     * 问题订单ID
     */
    private Long issueId;

    /**
     * 订单明细ID
     */
    private Long orderDetailId;


    /**
     * 问题一级分类
     */
    private String questionCatagory1;

    /**
     * 问题二级分类
     */
    private String questionCatagory2;


    /**
     * 问题三级分类
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
     * 问题管理立项时间
     */
    private String questionStartTime;


    /**
     * 问题管理立项人ID
     */
    private String questionStartUid;

    /**
     * 问题管理立项人名称
     */
    private String questionStartUname;

    /**
     * 版本号
     */
    private Integer version;


    private List<ISSU0203Accessory> accessorys;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }


    public List<ISSU0203Accessory> getAccessorys() {
        return accessorys;
    }

    public void setAccessorys(List<ISSU0203Accessory> accessorys) {
        this.accessorys = accessorys;
    }

    /**
     * 问题附件
     */
    public static class ISSU0203Accessory {


        /**
         * 问题ID
         */
        private Long questionId;

        /**
         * 附件ID
         */
        private Long accessoryId;


        /**
         * 附件文件ID
         */
        private String fileId;

        /**
         * 附件文件名称
         */
        private String fileName;

        /**
         * 附件文件类型
         */
        private String fileType;

        /**
         * 是否删除
         */
        private Boolean delFlg;


        /**
         * 附件版本号
         */
        private Integer version;

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


        public Long getQuestionId() {
            return questionId;
        }

        public void setQuestionId(Long questionId) {
            this.questionId = questionId;
        }

        public Long getAccessoryId() {
            return accessoryId;
        }

        public void setAccessoryId(Long accessoryId) {
            this.accessoryId = accessoryId;
        }


        public Boolean getDelFlg() {
            return delFlg;
        }

        public void setDelFlg(Boolean delFlg) {
            this.delFlg = delFlg;
        }

        public Integer getVersion() {
            return version;
        }

        public void setVersion(Integer version) {
            this.version = version;
        }
    }

}
