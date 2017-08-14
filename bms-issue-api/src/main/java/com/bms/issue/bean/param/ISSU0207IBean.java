package com.bms.issue.bean.param;

import com.bms.issue.common.rest.param.RestBean;

import java.util.List;

/**
 * 问题点编辑接口Param
 * bean
 *
 * @author li_huiqian
 */
public class ISSU0207IBean extends RestBean {
    private static final long serialVersionUID = 1L;

    private Long itemId;
    private Long questionId;
    private String itemDesc;
    private String itemSolution;
    private String itemExcutor;
    private String itemStartTime;
    private String itemEndTime;
    private String itemResult;
    private String itemFeedBack;
    private String itemCloser;
    private String itemCloseTime;
    private Integer version;

    private List<ISSU0207Accessory> accessorys;

    public List<ISSU0207Accessory> getAccessorys() {
        return accessorys;
    }

    public void setAccessorys(List<ISSU0207Accessory> accessorys) {
        this.accessorys = accessorys;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }


    /**
     * 问题附件
     */
    public static class ISSU0207Accessory {


        /**
         * 问题ID
         */
        private Long questionId;

        /**
         * 问题点id
         */
        private Long itemId;

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

        public Long getItemId() {
            return itemId;
        }

        public void setItemId(Long itemId) {
            this.itemId = itemId;
        }
    }
}
