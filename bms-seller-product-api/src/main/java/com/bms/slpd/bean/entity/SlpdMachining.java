/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_MACHINING对应的实体SlpdMachining</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdMachining extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 二级分类ID */
    private Long machiningId;
    /** 一级分类ID */
    private Long classesId;
    /** 二级分类编码 */
    private String machiningCode;
    /** 二级分类名称 */
    private String machiningName;
    /** 审核状态，0：待审核，1：正式 */
    private Boolean auditStu;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdMachining() {
    }

    /**
     * <p>二级分类ID</p>
     *
     * @return 二级分类ID
     */
    public Long getMachiningId() {
        return machiningId;
    }

    /**
     * <p>二级分类ID</p>
     *
     * @param machiningId 二级分类ID
     */
    public void setMachiningId(Long machiningId) {
        this.machiningId = machiningId;
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
     * <p>二级分类编码</p>
     *
     * @return 二级分类编码
     */
    public String getMachiningCode() {
        return machiningCode;
    }

    /**
     * <p>二级分类编码</p>
     *
     * @param machiningCode 二级分类编码
     */
    public void setMachiningCode(String machiningCode) {
        this.machiningCode = machiningCode;
    }
    /**
     * <p>二级分类名称</p>
     *
     * @return 二级分类名称
     */
    public String getMachiningName() {
        return machiningName;
    }

    /**
     * <p>二级分类名称</p>
     *
     * @param machiningName 二级分类名称
     */
    public void setMachiningName(String machiningName) {
        this.machiningName = machiningName;
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
