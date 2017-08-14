/*
 * 2017/02/22 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.byim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表BYIM_STANDARD_GRADE对应的实体ByimStandardGrade</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ByimStandardGrade extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** GRADE_STANDARD_ID */
    private Long gradeStandardId;
    /** GRADE_STANDARD */
    private String gradeStandard;
    /** 任一单品量级 */
    private Integer singelAmount;
    /** 所有单品量级 */
    private Integer allAmount;

    /**
     * <p>默认构造函数</p>
     */
    public ByimStandardGrade() {
    }

    /**
     * <p>GRADE_STANDARD_ID</p>
     *
     * @return GRADE_STANDARD_ID
     */
    public Long getGradeStandardId() {
        return gradeStandardId;
    }

    /**
     * <p>GRADE_STANDARD_ID</p>
     *
     * @param gradeStandardId GRADE_STANDARD_ID
     */
    public void setGradeStandardId(Long gradeStandardId) {
        this.gradeStandardId = gradeStandardId;
    }
    /**
     * <p>GRADE_STANDARD</p>
     *
     * @return GRADE_STANDARD
     */
    public String getGradeStandard() {
        return gradeStandard;
    }

    /**
     * <p>GRADE_STANDARD</p>
     *
     * @param gradeStandard GRADE_STANDARD
     */
    public void setGradeStandard(String gradeStandard) {
        this.gradeStandard = gradeStandard;
    }

    public Integer getSingelAmount() {
        return singelAmount;
    }

    public void setSingelAmount(Integer singelAmount) {
        this.singelAmount = singelAmount;
    }

    public Integer getAllAmount() {
        return allAmount;
    }

    public void setAllAmount(Integer allAmount) {
        this.allAmount = allAmount;
    }
}
