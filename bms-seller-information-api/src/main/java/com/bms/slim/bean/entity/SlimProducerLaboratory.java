/*
 * 2017/04/18 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表slim_producer_laboratory对应的实体SlimProducerLaboratory</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimProducerLaboratory extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 实验室ID */
    private Long laboratoryId;
    /** 卖家角色ID */
    private Long sellerRoleId;
    /** 面积 */
    private java.math.BigDecimal acreage;
    /** 功能 */
    private String effect;
    /** 投资 */
    private java.math.BigDecimal inverstnent;
    /** 人员 */
    private String member;
    /** 实验室照片URL */
    private String labPicUrl;
    /** 品控组织架构图URL */
    private String orgFrameImgUrl;
    /** 质量控制系统图URL */
    private String qualityCtrlImgUrl;

    /**
     * <p>默认构造函数</p>
     */
    public SlimProducerLaboratory() {
    }

    /**
     * <p>实验室ID</p>
     *
     * @return 实验室ID
     */
    public Long getLaboratoryId() {
        return laboratoryId;
    }

    /**
     * <p>实验室ID</p>
     *
     * @param laboratoryId 实验室ID
     */
    public void setLaboratoryId(Long laboratoryId) {
        this.laboratoryId = laboratoryId;
    }
    /**
     * <p>卖家角色ID</p>
     *
     * @return 卖家角色ID
     */
    public Long getSellerRoleId() {
        return sellerRoleId;
    }

    /**
     * <p>卖家角色ID</p>
     *
     * @param sellerRoleId 卖家角色ID
     */
    public void setSellerRoleId(Long sellerRoleId) {
        this.sellerRoleId = sellerRoleId;
    }
    /**
     * <p>面积</p>
     *
     * @return 面积
     */
    public java.math.BigDecimal getAcreage() {
        return acreage;
    }

    /**
     * <p>面积</p>
     *
     * @param acreage 面积
     */
    public void setAcreage(java.math.BigDecimal acreage) {
        this.acreage = acreage;
    }
    /**
     * <p>功能</p>
     *
     * @return 功能
     */
    public String getEffect() {
        return effect;
    }

    /**
     * <p>功能</p>
     *
     * @param effect 功能
     */
    public void setEffect(String effect) {
        this.effect = effect;
    }
    /**
     * <p>投资</p>
     *
     * @return 投资
     */
    public java.math.BigDecimal getInverstnent() {
        return inverstnent;
    }

    /**
     * <p>投资</p>
     *
     * @param inverstnent 投资
     */
    public void setInverstnent(java.math.BigDecimal inverstnent) {
        this.inverstnent = inverstnent;
    }
    /**
     * <p>人员</p>
     *
     * @return 人员
     */
    public String getMember() {
        return member;
    }

    /**
     * <p>人员</p>
     *
     * @param member 人员
     */
    public void setMember(String member) {
        this.member = member;
    }
    /**
     * <p>实验室照片URL</p>
     *
     * @return 实验室照片URL
     */
    public String getLabPicUrl() {
        return labPicUrl;
    }

    /**
     * <p>实验室照片URL</p>
     *
     * @param labPicUrl 实验室照片URL
     */
    public void setLabPicUrl(String labPicUrl) {
        this.labPicUrl = labPicUrl;
    }
    /**
     * <p>品控组织架构图URL</p>
     *
     * @return 品控组织架构图URL
     */
    public String getOrgFrameImgUrl() {
        return orgFrameImgUrl;
    }

    /**
     * <p>品控组织架构图URL</p>
     *
     * @param orgFrameImgUrl 品控组织架构图URL
     */
    public void setOrgFrameImgUrl(String orgFrameImgUrl) {
        this.orgFrameImgUrl = orgFrameImgUrl;
    }
    /**
     * <p>质量控制系统图URL</p>
     *
     * @return 质量控制系统图URL
     */
    public String getQualityCtrlImgUrl() {
        return qualityCtrlImgUrl;
    }

    /**
     * <p>质量控制系统图URL</p>
     *
     * @param qualityCtrlImgUrl 质量控制系统图URL
     */
    public void setQualityCtrlImgUrl(String qualityCtrlImgUrl) {
        this.qualityCtrlImgUrl = qualityCtrlImgUrl;
    }

}
