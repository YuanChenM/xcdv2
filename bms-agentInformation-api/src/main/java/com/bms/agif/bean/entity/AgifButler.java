/*
 * 2017/03/02 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.agif.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表AGIF_BUTLER对应的实体AgifButler</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class AgifButler extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** BUTLER_ID */
    private String butlerId;
    /** AGENT_ID */
    private String agentId;
    /** BUTLER_CODE */
    private String butlerCode;
    /** BUTLER_NAME */
    private String butlerName;
    /** BUTLER_BIRTHDAY */
    private String butlerBirthday;
    /** BUTLER_SEX */
    private String butlerSex;
    /** BUTLER_WECHAT */
    private String butlerWechat;
    /** BUTLER_QQ */
    private String butlerQq;
    /** 身份证号 */
    private java.lang.String idCardNo;
    /** 存储身份证正面图片上传文件服务器后返回的ID */
    private String idCardFront;
    /** 存储身份证反面图片上传文件服务器后返回的ID */
    private String idCardBack;

    /**
     * <p>默认构造函数</p>
     */
    public AgifButler() {
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
     * <p>AGENT_ID</p>
     *
     * @return AGENT_ID
     */
    public String getAgentId() {
        return agentId;
    }

    /**
     * <p>AGENT_ID</p>
     *
     * @param agentId AGENT_ID
     */
    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
    /**
     * <p>BUTLER_CODE</p>
     *
     * @return BUTLER_CODE
     */
    public String getButlerCode() {
        return butlerCode;
    }

    /**
     * <p>BUTLER_CODE</p>
     *
     * @param butlerCode BUTLER_CODE
     */
    public void setButlerCode(String butlerCode) {
        this.butlerCode = butlerCode;
    }
    /**
     * <p>BUTLER_NAME</p>
     *
     * @return BUTLER_NAME
     */
    public String getButlerName() {
        return butlerName;
    }

    /**
     * <p>BUTLER_NAME</p>
     *
     * @param butlerName BUTLER_NAME
     */
    public void setButlerName(String butlerName) {
        this.butlerName = butlerName;
    }
    /**
     * <p>BUTLER_BIRTHDAY</p>
     *
     * @return BUTLER_BIRTHDAY
     */
    public String getButlerBirthday() {
        return butlerBirthday;
    }

    /**
     * <p>BUTLER_BIRTHDAY</p>
     *
     * @param butlerBirthday BUTLER_BIRTHDAY
     */
    public void setButlerBirthday(String butlerBirthday) {
        this.butlerBirthday = butlerBirthday;
    }
    /**
     * <p>BUTLER_SEX</p>
     *
     * @return BUTLER_SEX
     */
    public String getButlerSex() {
        return butlerSex;
    }

    /**
     * <p>BUTLER_SEX</p>
     *
     * @param butlerSex BUTLER_SEX
     */
    public void setButlerSex(String butlerSex) {
        this.butlerSex = butlerSex;
    }
    /**
     * <p>BUTLER_WECHAT</p>
     *
     * @return BUTLER_WECHAT
     */
    public String getButlerWechat() {
        return butlerWechat;
    }

    /**
     * <p>BUTLER_WECHAT</p>
     *
     * @param butlerWechat BUTLER_WECHAT
     */
    public void setButlerWechat(String butlerWechat) {
        this.butlerWechat = butlerWechat;
    }
    /**
     * <p>BUTLER_QQ</p>
     *
     * @return BUTLER_QQ
     */
    public String getButlerQq() {
        return butlerQq;
    }

    /**
     * <p>BUTLER_QQ</p>
     *
     * @param butlerQq BUTLER_QQ
     */
    public void setButlerQq(String butlerQq) {
        this.butlerQq = butlerQq;
    }
    /**
     * <p>身份证号</p>
     *
     * @return 身份证号
     */
    public java.lang.String getIdCardNo() {
        return idCardNo;
    }

    /**
     * <p>身份证号</p>
     *
     * @param idCardNo 身份证号
     */
    public void setIdCardNo(java.lang.String idCardNo) {
        this.idCardNo = idCardNo;
    }
    /**
     * <p>存储身份证正面图片上传文件服务器后返回的ID</p>
     *
     * @return 存储身份证正面图片上传文件服务器后返回的ID
     */
    public String getIdCardFront() {
        return idCardFront;
    }

    /**
     * <p>存储身份证正面图片上传文件服务器后返回的ID</p>
     *
     * @param idCardFront 存储身份证正面图片上传文件服务器后返回的ID
     */
    public void setIdCardFront(String idCardFront) {
        this.idCardFront = idCardFront;
    }
    /**
     * <p>存储身份证反面图片上传文件服务器后返回的ID</p>
     *
     * @return 存储身份证反面图片上传文件服务器后返回的ID
     */
    public String getIdCardBack() {
        return idCardBack;
    }

    /**
     * <p>存储身份证反面图片上传文件服务器后返回的ID</p>
     *
     * @param idCardBack 存储身份证反面图片上传文件服务器后返回的ID
     */
    public void setIdCardBack(String idCardBack) {
        this.idCardBack = idCardBack;
    }

}
