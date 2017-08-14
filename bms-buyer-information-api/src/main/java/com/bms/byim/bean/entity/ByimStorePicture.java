/*
 * 2016/12/29 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.byim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表BYIM_STORE_PICTURE对应的实体ByimStorePicture</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ByimStorePicture extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** PIC_ID */
    private Long picId;
    /** BUYER_ID */
    private String buyerId;
    /** STORE_ID */
    private Long storeId;
    /** LICENSE_TYPE */
    private String licenseType;
    /** 存储图片上传文件服务器后返回的ID */
    private String licensePic;

    /**
     * <p>默认构造函数</p>
     */
    public ByimStorePicture() {
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
     * <p>STORE_ID</p>
     *
     * @return STORE_ID
     */
    public Long getStoreId() {
        return storeId;
    }

    /**
     * <p>STORE_ID</p>
     *
     * @param storeId STORE_ID
     */
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
    /**
     * <p>LICENSE_TYPE</p>
     *
     * @return LICENSE_TYPE
     */
    public String getLicenseType() {
        return licenseType;
    }

    /**
     * <p>LICENSE_TYPE</p>
     *
     * @param licenseType LICENSE_TYPE
     */
    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
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

}
