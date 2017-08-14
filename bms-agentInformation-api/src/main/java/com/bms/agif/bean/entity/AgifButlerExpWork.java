/*
 * 2017/03/02 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.agif.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表AGIF_BUTLER_EXP_WORK对应的实体AgifButlerExpWork</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class AgifButlerExpWork extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** WORK_EXP_ID */
    private Long workExpId;
    /** BUTLER_ID */
    private String butlerId;
    /** EXP_START */
    private java.util.Date expStart;
    /** EXP_END */
    private java.util.Date expEnd;
    /** COMPANY */
    private String company;
    /** POST */
    private String post;
    /** JOB */
    private String job;

    /**
     * <p>默认构造函数</p>
     */
    public AgifButlerExpWork() {
    }

    /**
     * <p>WORK_EXP_ID</p>
     *
     * @return WORK_EXP_ID
     */
    public Long getWorkExpId() {
        return workExpId;
    }

    /**
     * <p>WORK_EXP_ID</p>
     *
     * @param workExpId WORK_EXP_ID
     */
    public void setWorkExpId(Long workExpId) {
        this.workExpId = workExpId;
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
     * <p>COMPANY</p>
     *
     * @return COMPANY
     */
    public String getCompany() {
        return company;
    }

    /**
     * <p>COMPANY</p>
     *
     * @param company COMPANY
     */
    public void setCompany(String company) {
        this.company = company;
    }
    /**
     * <p>POST</p>
     *
     * @return POST
     */
    public String getPost() {
        return post;
    }

    /**
     * <p>POST</p>
     *
     * @param post POST
     */
    public void setPost(String post) {
        this.post = post;
    }
    /**
     * <p>JOB</p>
     *
     * @return JOB
     */
    public String getJob() {
        return job;
    }

    /**
     * <p>JOB</p>
     *
     * @param job JOB
     */
    public void setJob(String job) {
        this.job = job;
    }

}
