/*
 * 2017/03/23 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.como.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表como_shelf_list_record对应的实体ComoShelfListRecord</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ComoShelfListRecord extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 记录ID */
    private Long recordId;
    /** 处理类型，CodeMaster */
    private String handleType;
    /** 处理备注 */
    private String handleRemark;
    /** 提交的销售上架日期 */
    private java.util.Date addShelfTime;
    /** 提交的销售下架日期 */
    private java.util.Date offShelfTime;

    /**
     * <p>默认构造函数</p>
     */
    public ComoShelfListRecord() {
    }

    /**
     * <p>记录ID</p>
     *
     * @return 记录ID
     */
    public Long getRecordId() {
        return recordId;
    }

    /**
     * <p>记录ID</p>
     *
     * @param recordId 记录ID
     */
    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }
    /**
     * <p>处理类型，CodeMaster</p>
     *
     * @return 处理类型，CodeMaster
     */
    public String getHandleType() {
        return handleType;
    }

    /**
     * <p>处理类型，CodeMaster</p>
     *
     * @param handleType 处理类型，CodeMaster
     */
    public void setHandleType(String handleType) {
        this.handleType = handleType;
    }
    /**
     * <p>处理备注</p>
     *
     * @return 处理备注
     */
    public String getHandleRemark() {
        return handleRemark;
    }

    /**
     * <p>处理备注</p>
     *
     * @param handleRemark 处理备注
     */
    public void setHandleRemark(String handleRemark) {
        this.handleRemark = handleRemark;
    }
    /**
     * <p>提交的销售上架日期</p>
     *
     * @return 提交的销售上架日期
     */
    public java.util.Date getAddShelfTime() {
        return addShelfTime;
    }

    /**
     * <p>提交的销售上架日期</p>
     *
     * @param addShelfTime 提交的销售上架日期
     */
    public void setAddShelfTime(java.util.Date addShelfTime) {
        this.addShelfTime = addShelfTime;
    }
    /**
     * <p>提交的销售下架日期</p>
     *
     * @return 提交的销售下架日期
     */
    public java.util.Date getOffShelfTime() {
        return offShelfTime;
    }

    /**
     * <p>提交的销售下架日期</p>
     *
     * @param offShelfTime 提交的销售下架日期
     */
    public void setOffShelfTime(java.util.Date offShelfTime) {
        this.offShelfTime = offShelfTime;
    }

}
