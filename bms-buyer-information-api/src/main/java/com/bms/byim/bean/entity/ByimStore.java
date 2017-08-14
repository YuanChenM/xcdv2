/*
 * 2017/01/06 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.byim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表BYIM_STORE对应的实体ByimStore</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ByimStore extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** STORE_ID */
    private Long storeId;
    /** BUYER_ID */
    private String buyerId;
    /** MARKET_ID */
    private String marketId;
    /** MARKET_CODE */
    private String marketCode;
    /** MARKET_NAME */
    private String marketName;
    /** 0:表示菜场;1:表示批发市场 */
    private String marketType;
    /** 批发市场是指批发市场级别;菜场指菜场类别 */
    private String marketScale;
    /** LEGAL_PAPER_NAME */
    private String legalPaperName;
    /** LEGAL_PAPER_TYPE */
    private String legalPaperType;
    /** LEGAL_PAPER_NO */
    private String legalPaperNo;
    /** 存储图片上传文件服务器后返回的ID */
    private String legalPaperPic;
    /** STORE_ADDR */
    private String storeAddr;
    /** STORE_NO */
    private String storeNo;
    /** STORE_TEL */
    private String storeTel;
    /** STORE_WEBSITE */
    private String storeWebsite;
    /** STORE_WECHAT */
    private String storeWechat;
    /** STORE_LICENSE_TYPE */
    private String storeLicenseType;
    /** STORE_LICENSE_NO */
    private String storeLicenseNo;
    /** true:表示默认店铺;false:表示不是默认店铺 */
    private Boolean defaultStoreFlg;
    /** REGISTRANT_ID */
    private java.lang.String registrantId;
    /** REGISTRANT_DATE */
    private java.util.Date registrantDate;
    /** PRE_REGISTRANT_ID */
    private java.lang.String preRegistrantId;
    /** PRE_REGISTRATION_DATE */
    private java.util.Date preRegistrationDate;
    /**
     * <p>默认构造函数</p>
     */
    public ByimStore() {
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
     * <p>MARKET_ID</p>
     *
     * @return MARKET_ID
     */
    public String getMarketId() {
        return marketId;
    }

    /**
     * <p>MARKET_ID</p>
     *
     * @param marketId MARKET_ID
     */
    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }
    /**
     * <p>MARKET_CODE</p>
     *
     * @return MARKET_CODE
     */
    public String getMarketCode() {
        return marketCode;
    }

    /**
     * <p>MARKET_CODE</p>
     *
     * @param marketCode MARKET_CODE
     */
    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }
    /**
     * <p>MARKET_NAME</p>
     *
     * @return MARKET_NAME
     */
    public String getMarketName() {
        return marketName;
    }

    /**
     * <p>MARKET_NAME</p>
     *
     * @param marketName MARKET_NAME
     */
    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }
    /**
     * <p>0:表示菜场;1:表示批发市场</p>
     *
     * @return 0:表示菜场;1:表示批发市场
     */
    public String getMarketType() {
        return marketType;
    }

    /**
     * <p>0:表示菜场;1:表示批发市场</p>
     *
     * @param marketType 0:表示菜场;1:表示批发市场
     */
    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }
    /**
     * <p>批发市场是指批发市场级别;菜场指菜场类别</p>
     *
     * @return 批发市场是指批发市场级别;菜场指菜场类别
     */
    public String getMarketScale() {
        return marketScale;
    }

    /**
     * <p>批发市场是指批发市场级别;菜场指菜场类别</p>
     *
     * @param marketScale 批发市场是指批发市场级别;菜场指菜场类别
     */
    public void setMarketScale(String marketScale) {
        this.marketScale = marketScale;
    }
    /**
     * <p>LEGAL_PAPER_NAME</p>
     *
     * @return LEGAL_PAPER_NAME
     */
    public String getLegalPaperName() {
        return legalPaperName;
    }

    /**
     * <p>LEGAL_PAPER_NAME</p>
     *
     * @param legalPaperName LEGAL_PAPER_NAME
     */
    public void setLegalPaperName(String legalPaperName) {
        this.legalPaperName = legalPaperName;
    }
    /**
     * <p>LEGAL_PAPER_TYPE</p>
     *
     * @return LEGAL_PAPER_TYPE
     */
    public String getLegalPaperType() {
        return legalPaperType;
    }

    /**
     * <p>LEGAL_PAPER_TYPE</p>
     *
     * @param legalPaperType LEGAL_PAPER_TYPE
     */
    public void setLegalPaperType(String legalPaperType) {
        this.legalPaperType = legalPaperType;
    }
    /**
     * <p>LEGAL_PAPER_NO</p>
     *
     * @return LEGAL_PAPER_NO
     */
    public String getLegalPaperNo() {
        return legalPaperNo;
    }

    /**
     * <p>LEGAL_PAPER_NO</p>
     *
     * @param legalPaperNo LEGAL_PAPER_NO
     */
    public void setLegalPaperNo(String legalPaperNo) {
        this.legalPaperNo = legalPaperNo;
    }
    /**
     * <p>存储图片上传文件服务器后返回的ID</p>
     *
     * @return 存储图片上传文件服务器后返回的ID
     */
    public String getLegalPaperPic() {
        return legalPaperPic;
    }

    /**
     * <p>存储图片上传文件服务器后返回的ID</p>
     *
     * @param legalPaperPic 存储图片上传文件服务器后返回的ID
     */
    public void setLegalPaperPic(String legalPaperPic) {
        this.legalPaperPic = legalPaperPic;
    }
    /**
     * <p>STORE_ADDR</p>
     *
     * @return STORE_ADDR
     */
    public String getStoreAddr() {
        return storeAddr;
    }

    /**
     * <p>STORE_ADDR</p>
     *
     * @param storeAddr STORE_ADDR
     */
    public void setStoreAddr(String storeAddr) {
        this.storeAddr = storeAddr;
    }
    /**
     * <p>STORE_NO</p>
     *
     * @return STORE_NO
     */
    public String getStoreNo() {
        return storeNo;
    }

    /**
     * <p>STORE_NO</p>
     *
     * @param storeNo STORE_NO
     */
    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }
    /**
     * <p>STORE_TEL</p>
     *
     * @return STORE_TEL
     */
    public String getStoreTel() {
        return storeTel;
    }

    /**
     * <p>STORE_TEL</p>
     *
     * @param storeTel STORE_TEL
     */
    public void setStoreTel(String storeTel) {
        this.storeTel = storeTel;
    }
    /**
     * <p>STORE_WEBSITE</p>
     *
     * @return STORE_WEBSITE
     */
    public String getStoreWebsite() {
        return storeWebsite;
    }

    /**
     * <p>STORE_WEBSITE</p>
     *
     * @param storeWebsite STORE_WEBSITE
     */
    public void setStoreWebsite(String storeWebsite) {
        this.storeWebsite = storeWebsite;
    }
    /**
     * <p>STORE_WECHAT</p>
     *
     * @return STORE_WECHAT
     */
    public String getStoreWechat() {
        return storeWechat;
    }

    /**
     * <p>STORE_WECHAT</p>
     *
     * @param storeWechat STORE_WECHAT
     */
    public void setStoreWechat(String storeWechat) {
        this.storeWechat = storeWechat;
    }
    /**
     * <p>STORE_LICENSE_TYPE</p>
     *
     * @return STORE_LICENSE_TYPE
     */
    public String getStoreLicenseType() {
        return storeLicenseType;
    }

    /**
     * <p>STORE_LICENSE_TYPE</p>
     *
     * @param storeLicenseType STORE_LICENSE_TYPE
     */
    public void setStoreLicenseType(String storeLicenseType) {
        this.storeLicenseType = storeLicenseType;
    }
    /**
     * <p>STORE_LICENSE_NO</p>
     *
     * @return STORE_LICENSE_NO
     */
    public String getStoreLicenseNo() {
        return storeLicenseNo;
    }

    /**
     * <p>STORE_LICENSE_NO</p>
     *
     * @param storeLicenseNo STORE_LICENSE_NO
     */
    public void setStoreLicenseNo(String storeLicenseNo) {
        this.storeLicenseNo = storeLicenseNo;
    }
    /**
     * <p>true:表示默认店铺;false:表示不是默认店铺</p>
     *
     * @return true:表示默认店铺;false:表示不是默认店铺
     */
    public Boolean getDefaultStoreFlg() {
        return defaultStoreFlg;
    }

    /**
     * <p>true:表示默认店铺;false:表示不是默认店铺</p>
     *
     * @param defaultStoreFlg true:表示默认店铺;false:表示不是默认店铺
     */
    public void setDefaultStoreFlg(Boolean defaultStoreFlg) {
        this.defaultStoreFlg = defaultStoreFlg;
    }

    /**
     * <p>REGISTRANT_ID</p>
     *
     * @return REGISTRANT_ID
     */
    public java.lang.String getRegistrantId() {
        return registrantId;
    }

    /**
     * <p>REGISTRANT_ID</p>
     *
     * @param registrantId REGISTRANT_ID
     */
    public void setRegistrantId(java.lang.String registrantId) {
        this.registrantId = registrantId;
    }
    /**
     * <p>REGISTRANT_DATE</p>
     *
     * @return REGISTRANT_DATE
     */
    public java.util.Date getRegistrantDate() {
        return registrantDate;
    }

    /**
     * <p>REGISTRANT_DATE</p>
     *
     * @param registrantDate REGISTRANT_DATE
     */
    public void setRegistrantDate(java.util.Date registrantDate) {
        this.registrantDate = registrantDate;
    }
    /**
     * <p>PRE_REGISTRANT_ID</p>
     *
     * @return PRE_REGISTRANT_ID
     */
    public java.lang.String getPreRegistrantId() {
        return preRegistrantId;
    }

    /**
     * <p>PRE_REGISTRANT_ID</p>
     *
     * @param preRegistrantId PRE_REGISTRANT_ID
     */
    public void setPreRegistrantId(java.lang.String preRegistrantId) {
        this.preRegistrantId = preRegistrantId;
    }
    /**
     * <p>PRE_REGISTRATION_DATE</p>
     *
     * @return PRE_REGISTRATION_DATE
     */
    public java.util.Date getPreRegistrationDate() {
        return preRegistrationDate;
    }
    /**
     * <p>PRE_REGISTRATION_DATE</p>
     *
     * @param preRegistrationDate PRE_REGISTRATION_DATE
     */
    public void setPreRegistrationDate(java.util.Date preRegistrationDate) {
        this.preRegistrationDate = preRegistrationDate;
    }


}
