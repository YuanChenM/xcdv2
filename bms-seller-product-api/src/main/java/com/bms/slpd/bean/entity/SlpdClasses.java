/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_CLASSES对应的实体SlpdClasses</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdClasses extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 一级分类ID */
    private Long classesId;
    /** 一级分类编码 */
    private String classesCode;
    /** 一级分类名称 */
    private String classesName;
    /** 审核状态，0：待审核，1：正式 */
    private Boolean auditStu;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdClasses() {
    }

    /**
     * <p>一级分类ID</p>
     *
     * @return 一级分类ID
     */
    public Long getClassesId() {
        return classesId;
    }

    /**
     * <p>一级分类ID</p>
     *
     * @param classesId 一级分类ID
     */
    public void setClassesId(Long classesId) {
        this.classesId = classesId;
    }
    /**
     * <p>一级分类编码</p>
     *
     * @return 一级分类编码
     */
    public String getClassesCode() {
        return classesCode;
    }

    /**
     * <p>一级分类编码</p>
     *
     * @param classesCode 一级分类编码
     */
    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode;
    }
    /**
     * <p>一级分类名称</p>
     *
     * @return 一级分类名称
     */
    public String getClassesName() {
        return classesName;
    }

    /**
     * <p>一级分类名称</p>
     *
     * @param classesName 一级分类名称
     */
    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }
    /**
     * <p>审核状态，0：待审核，1：正式</p>
     *
     * @return 审核状态，0：待审核，1：正式
     */
    public Boolean getAuditStu() {
        return auditStu;
    }

    /**
     * <p>审核状态，0：待审核，1：正式</p>
     *
     * @param auditStu 审核状态，0：待审核，1：正式
     */
    public void setAuditStu(Boolean auditStu) {
        this.auditStu = auditStu;
    }

}
