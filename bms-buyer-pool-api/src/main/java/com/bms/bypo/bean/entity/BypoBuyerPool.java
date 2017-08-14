/*
 * 2017/01/10 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.bypo.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表BYPO_BUYER_POOL对应的实体BypoBuyerPool</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class BypoBuyerPool extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** BUYER_POOL_ID */
    private java.lang.Long buyerPoolId;
    /** LGCS_AREA_CODE */
    private java.lang.String lgcsAreaCode;
    /** LGCS_AREA_NAME */
    private java.lang.String lgcsAreaName;
    /** BUYER_TYPE */
    private java.lang.String buyerType;
    /** BUYER_TYPE_NAME */
    private java.lang.String buyerTypeName;
    /** BUYER_FIRST_CATEGORY */
    private java.lang.String buyerFirstCategory;
    /** BUYER_FIRST_CATEGORY_NAME */
    private java.lang.String buyerFirstCategoryName;
    /** BUYER_SUB_CATEGORY */
    private java.lang.String buyerSubCategory;
    /** BUYER_SUB_CATEGORY_NAME */
    private java.lang.String buyerSubCategoryName;
    /** BUYER_POOL_NAME */
    private java.lang.String buyerPoolName;
    /** BUYER_POOL_CODE */
    private java.lang.String buyerPoolCode;
    //物流区id
    private Long lgcsAreaId;
   //地区主键
    private Long zoneId;
   //地区编码
    private String zoneCode;
   //地区名称
    private String zoneName;
   //配送站主键
    private Long distributionId;
   //配送站表示码
    private String distributionName;
   //配送站编码(全国所有配送站用4位阿拉伯数字，系统自动按新增顺序从0001顺序编码)")
    private String distributionCode;
   //领地ID
    private Long demesneId;
   //领地表示码
    private String demesneName;
   //以配送站为单元用2位阿拉伯数字，系统自动按新增顺序从01顺序编码")
    private String demesneCode;
    
    

    /**
     * <p>默认构造函数</p>
     */
    public BypoBuyerPool() {
    }

    /**
     * <p>BUYER_POOL_ID</p>
     *
     * @return BUYER_POOL_ID
     */
    public java.lang.Long getBuyerPoolId() {
        return buyerPoolId;
    }

    /**
     * <p>BUYER_POOL_ID</p>
     *
     * @param buyerPoolId BUYER_POOL_ID
     */
    public void setBuyerPoolId(java.lang.Long buyerPoolId) {
        this.buyerPoolId = buyerPoolId;
    }
    /**
     * <p>LGCS_AREA_CODE</p>
     *
     * @return LGCS_AREA_CODE
     */
    public java.lang.String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    /**
     * <p>LGCS_AREA_CODE</p>
     *
     * @param lgcsAreaCode LGCS_AREA_CODE
     */
    public void setLgcsAreaCode(java.lang.String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }
    /**
     * <p>LGCS_AREA_NAME</p>
     *
     * @return LGCS_AREA_NAME
     */
    public java.lang.String getLgcsAreaName() {
        return lgcsAreaName;
    }

    /**
     * <p>LGCS_AREA_NAME</p>
     *
     * @param lgcsAreaName LGCS_AREA_NAME
     */
    public void setLgcsAreaName(java.lang.String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }
    /**
     * <p>BUYER_TYPE</p>
     *
     * @return BUYER_TYPE
     */
    public java.lang.String getBuyerType() {
        return buyerType;
    }

    /**
     * <p>BUYER_TYPE</p>
     *
     * @param buyerType BUYER_TYPE
     */
    public void setBuyerType(java.lang.String buyerType) {
        this.buyerType = buyerType;
    }
    /**
     * <p>BUYER_TYPE_NAME</p>
     *
     * @return BUYER_TYPE_NAME
     */
    public java.lang.String getBuyerTypeName() {
        return buyerTypeName;
    }

    /**
     * <p>BUYER_TYPE_NAME</p>
     *
     * @param buyerTypeName BUYER_TYPE_NAME
     */
    public void setBuyerTypeName(java.lang.String buyerTypeName) {
        this.buyerTypeName = buyerTypeName;
    }
    /**
     * <p>BUYER_FIRST_CATEGORY</p>
     *
     * @return BUYER_FIRST_CATEGORY
     */
    public java.lang.String getBuyerFirstCategory() {
        return buyerFirstCategory;
    }

    /**
     * <p>BUYER_FIRST_CATEGORY</p>
     *
     * @param buyerFirstCategory BUYER_FIRST_CATEGORY
     */
    public void setBuyerFirstCategory(java.lang.String buyerFirstCategory) {
        this.buyerFirstCategory = buyerFirstCategory;
    }
    /**
     * <p>BUYER_FIRST_CATEGORY_NAME</p>
     *
     * @return BUYER_FIRST_CATEGORY_NAME
     */
    public java.lang.String getBuyerFirstCategoryName() {
        return buyerFirstCategoryName;
    }

    /**
     * <p>BUYER_FIRST_CATEGORY_NAME</p>
     *
     * @param buyerFirstCategoryName BUYER_FIRST_CATEGORY_NAME
     */
    public void setBuyerFirstCategoryName(java.lang.String buyerFirstCategoryName) {
        this.buyerFirstCategoryName = buyerFirstCategoryName;
    }
    /**
     * <p>BUYER_SUB_CATEGORY</p>
     *
     * @return BUYER_SUB_CATEGORY
     */
    public java.lang.String getBuyerSubCategory() {
        return buyerSubCategory;
    }

    /**
     * <p>BUYER_SUB_CATEGORY</p>
     *
     * @param buyerSubCategory BUYER_SUB_CATEGORY
     */
    public void setBuyerSubCategory(java.lang.String buyerSubCategory) {
        this.buyerSubCategory = buyerSubCategory;
    }
    /**
     * <p>BUYER_SUB_CATEGORY_NAME</p>
     *
     * @return BUYER_SUB_CATEGORY_NAME
     */
    public java.lang.String getBuyerSubCategoryName() {
        return buyerSubCategoryName;
    }

    /**
     * <p>BUYER_SUB_CATEGORY_NAME</p>
     *
     * @param buyerSubCategoryName BUYER_SUB_CATEGORY_NAME
     */
    public void setBuyerSubCategoryName(java.lang.String buyerSubCategoryName) {
        this.buyerSubCategoryName = buyerSubCategoryName;
    }
    /**
     * <p>BUYER_POOL_NAME</p>
     *
     * @return BUYER_POOL_NAME
     */
    public java.lang.String getBuyerPoolName() {
        return buyerPoolName;
    }

    /**
     * <p>BUYER_POOL_NAME</p>
     *
     * @param buyerPoolName BUYER_POOL_NAME
     */
    public void setBuyerPoolName(java.lang.String buyerPoolName) {
        this.buyerPoolName = buyerPoolName;
    }
    /**
     * <p>BUYER_POOL_CODE</p>
     *
     * @return BUYER_POOL_CODE
     */
    public java.lang.String getBuyerPoolCode() {
        return buyerPoolCode;
    }

    /**
     * <p>BUYER_POOL_CODE</p>
     *
     * @param buyerPoolCode BUYER_POOL_CODE
     */
    public void setBuyerPoolCode(java.lang.String buyerPoolCode) {
        this.buyerPoolCode = buyerPoolCode;
    }

    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Long getDistributionId() {
        return distributionId;
    }

    public void setDistributionId(Long distributionId) {
        this.distributionId = distributionId;
    }

    public String getDistributionName() {
        return distributionName;
    }

    public void setDistributionName(String distributionName) {
        this.distributionName = distributionName;
    }

    public String getDistributionCode() {
        return distributionCode;
    }

    public void setDistributionCode(String distributionCode) {
        this.distributionCode = distributionCode;
    }

    public Long getDemesneId() {
        return demesneId;
    }

    public void setDemesneId(Long demesneId) {
        this.demesneId = demesneId;
    }

    public String getDemesneName() {
        return demesneName;
    }

    public void setDemesneName(String demesneName) {
        this.demesneName = demesneName;
    }

    public String getDemesneCode() {
        return demesneCode;
    }

    public void setDemesneCode(String demesneCode) {
        this.demesneCode = demesneCode;
    }
}
