/*
 * 2017/03/02 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.agif.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表AGIF_BUTLER_EXP_EDUCATION对应的实体AgifButlerExpEducation</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class AgifButlerExpEducation extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** EDUCATION_EXP_ID */
    private Long educationExpId;
    /** BUTLER_ID */
    private String butlerId;
    /** EXP_START */
    private java.util.Date expStart;
    /** EXP_END */
    private java.util.Date expEnd;
    /** SCHOOL */
    private String school;
    /** EDUCATION */
    private String education;
    /** DEGREE */
    private String degree;

    /**
     * <p>默认构造函数</p>
     */
    public AgifButlerExpEducation() {
    }

    /**
     * <p>EDUCATION_EXP_ID</p>
     *
     * @return EDUCATION_EXP_ID
     */
    public Long getEducationExpId() {
        return educationExpId;
    }

    /**
     * <p>EDUCATION_EXP_ID</p>
     *
     * @param educationExpId EDUCATION_EXP_ID
     */
    public void setEducationExpId(Long educationExpId) {
        this.educationExpId = educationExpId;
    }
    /**
     * <p>BUTLER_ID</p>
     *
     * @return BUTLER_ID
     */
    public String getButlerId() {
        return butlerId;
    }

    /**
     * <p>BUTLER_ID</p>
     *
     * @param butlerId BUTLER_ID
     */
    public void setButlerId(String butlerId) {
        this.butlerId = butlerId;
    }
    /**
     * <p>EXP_START</p>
     *
     * @return EXP_START
     */
    public java.util.Date getExpStart() {
        return expStart;
    }

    /**
     * <p>EXP_START</p>
     *
     * @param expStart EXP_START
     */
    public void setExpStart(java.util.Date expStart) {
        this.expStart = expStart;
    }
    /**
     * <p>EXP_END</p>
     *
     * @return EXP_END
     */
    public java.util.Date getExpEnd() {
        return expEnd;
    }

    /**
     * <p>EXP_END</p>
     *
     * @param expEnd EXP_END
     */
    public void setExpEnd(java.util.Date expEnd) {
        this.expEnd = expEnd;
    }
    /**
     * <p>SCHOOL</p>
     *
     * @return SCHOOL
     */
    public String getSchool() {
        return school;
    }

    /**
     * <p>SCHOOL</p>
     *
     * @param school SCHOOL
     */
    public void setSchool(String school) {
        this.school = school;
    }
    /**
     * <p>EDUCATION</p>
     *
     * @return EDUCATION
     */
    public String getEducation() {
        return education;
    }

    /**
     * <p>EDUCATION</p>
     *
     * @param education EDUCATION
     */
    public void setEducation(String education) {
        this.education = education;
    }
    /**
     * <p>DEGREE</p>
     *
     * @return DEGREE
     */
    public String getDegree() {
        return degree;
    }

    /**
     * <p>DEGREE</p>
     *
     * @param degree DEGREE
     */
    public void setDegree(String degree) {
        this.degree = degree;
    }

}
