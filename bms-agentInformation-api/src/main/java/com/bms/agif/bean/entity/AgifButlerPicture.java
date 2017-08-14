/*
 * 2017/03/02 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.agif.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表AGIF_BUTLER_PICTURE对应的实体AgifButlerPicture</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class AgifButlerPicture extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** PIC_ID */
    private Long picId;
    /** BUTLER_ID */
    private String butlerId;
    /** 存储图片上传文件服务器后返回的ID */
    private String licensePic;
    /** DEFAULT_FLG */
    private java.lang.Boolean defaultFlg;

    /**
     * <p>默认构造函数</p>
     */
    public AgifButlerPicture() {
    }

    /**
     * <p>PIC_ID</p>
     *
     * @return PIC_ID
     */
    public Long getPicId() {
        return picId;
    }

    /**
     * <p>PIC_ID</p>
     *
     * @param picId PIC_ID
     */
    public void setPicId(Long picId) {
        this.picId = picId;
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
     * <p>存储图片上传文件服务器后返回的ID</p>
     *
     * @return 存储图片上传文件服务器后返回的ID
     */
    public String getLicensePic() {
        return licensePic;
    }

    /**
     * <p>存储图片上传文件服务器后返回的ID</p>
     *
     * @param licensePic 存储图片上传文件服务器后返回的ID
     */
    public void setLicensePic(String licensePic) {
        this.licensePic = licensePic;
    }
    /**
     * <p>是否默认照片</p>
     *
     * @return 是否默认照片
     */
    public java.lang.Boolean getDefaultFlg() {
        return defaultFlg;
    }

    /**
     * <p>是否默认照片</p>
     *
     * @param defaultFlg 是否默认照片
     */
    public void setDefaultFlg(java.lang.Boolean defaultFlg) {
        this.defaultFlg = defaultFlg;
    }
}
