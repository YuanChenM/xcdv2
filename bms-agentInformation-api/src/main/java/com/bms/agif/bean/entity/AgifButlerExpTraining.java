/*
 * 2017/03/02 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.agif.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表AGIF_BUTLER_EXP_TRAINING对应的实体AgifButlerExpTraining</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class AgifButlerExpTraining extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** TRAINING_EXP_ID */
    private Long trainingExpId;
    /** BUTLER_ID */
    private String butlerId;
    /** EXP_START */
    private java.util.Date expStart;
    /** EXP_END */
    private java.util.Date expEnd;
    /** ORGANIZATION */
    private String organization;
    /** CERTIFICATE */
    private String certificate;

    /**
     * <p>默认构造函数</p>
     */
    public AgifButlerExpTraining() {
    }

    /**
     * <p>TRAINING_EXP_ID</p>
     *
     * @return TRAINING_EXP_ID
     */
    public Long getTrainingExpId() {
        return trainingExpId;
    }

    /**
     * <p>TRAINING_EXP_ID</p>
     *
     * @param trainingExpId TRAINING_EXP_ID
     */
    public void setTrainingExpId(Long trainingExpId) {
        this.trainingExpId = trainingExpId;
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
     * <p>ORGANIZATION</p>
     *
     * @return ORGANIZATION
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * <p>ORGANIZATION</p>
     *
     * @param organization ORGANIZATION
     */
    public void setOrganization(String organization) {
        this.organization = organization;
    }
    /**
     * <p>CERTIFICATE</p>
     *
     * @return CERTIFICATE
     */
    public String getCertificate() {
        return certificate;
    }

    /**
     * <p>CERTIFICATE</p>
     *
     * @param certificate CERTIFICATE
     */
    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

}
