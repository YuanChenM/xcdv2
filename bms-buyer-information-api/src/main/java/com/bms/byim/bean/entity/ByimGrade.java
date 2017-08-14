/*
 * 2017/03/21 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.byim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表byim_grade对应的实体ByimGrade</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ByimGrade extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** GRADE_ID */
    private Long gradeId;
    /** BUYER_ID */
    private String buyerId;
    /** GRADE */
    private String grade;
    /** 单位：箱 */
    private String singelAmount;
    /** 单位：箱 */
    private String allAmount;

    /**
     * <p>默认构造函数</p>
     */
    public ByimGrade() {
    }

    /**
     * <p>GRADE_ID</p>
     *
     * @return GRADE_ID
     */
    public Long getGradeId() {
        return gradeId;
    }

    /**
     * <p>GRADE_ID</p>
     *
     * @param gradeId GRADE_ID
     */
    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }
    /**
     * <p>BUYER_ID</p>
     *
     * @return BUYER_ID
     */
    public String getBuyerId() {
        return buyerId;
    }

    /**
     * <p>BUYER_ID</p>
     *
     * @param buyerId BUYER_ID
     */
    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }
    /**
     * <p>GRADE</p>
     *
     * @return GRADE
     */
    public String getGrade() {
        return grade;
    }

    /**
     * <p>GRADE</p>
     *
     * @param grade GRADE
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }
    /**
     * <p>单位：箱</p>
     *
     * @return 单位：箱
     */
    public String getSingelAmount() {
        return singelAmount;
    }

    /**
     * <p>单位：箱</p>
     *
     * @param singelAmount 单位：箱
     */
    public void setSingelAmount(String singelAmount) {
        this.singelAmount = singelAmount;
    }
    /**
     * <p>单位：箱</p>
     *
     * @return 单位：箱
     */
    public String getAllAmount() {
        return allAmount;
    }

    /**
     * <p>单位：箱</p>
     *
     * @param allAmount 单位：箱
     */
    public void setAllAmount(String allAmount) {
        this.allAmount = allAmount;
    }

}
