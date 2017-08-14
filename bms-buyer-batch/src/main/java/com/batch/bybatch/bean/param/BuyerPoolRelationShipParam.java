
package com.batch.bybatch.bean.param;

import com.framework.base.web.param.BaseWebPaginationParam;


public class BuyerPoolRelationShipParam extends BaseWebPaginationParam {

    //关系ID
    /**
     * RELATION_SHIP_ID
     */
    private Long relationShipId;
    //买家ID
    /**
     * BUYER_ID
     */
    private String buyerId;
    //买家池ID
    /**
     * BUYER_POOL_ID
     */
    private Long buyerPoolId;
    //买家池名称
    /**
     * BUYER_POOL_NAME
     */
    private String buyerPoolName;
    //买家池编码
    /**
     * BUYER_POOL_CODE
     */
    private String buyerPoolCode;
    //买家池买家一级上线状态
    /**
     * MARKETING_FIRST_STATUS
     */
    private String marketingFirstStatus;
    //买家池买家一级上线状态名称
    /**
     * MARKETING_FIRST_STATUS_NAME
     */
    private String marketingFirstStatusName;
    //买家池买家二级上线状态
    /**
     * MARKETING_SUB_STATUS
     */
    private String marketingSubStatus;
    //买家池买家二级上线状态名称
    /**
     * MARKETING_SUB_STATUS_NAME
     */
    private String marketingSubStatusName;
    //买家池类型
    /**
     * BUYER_POOL_TYPE
     */
    private String buyerPoolType;
    //删除标志
    private boolean delFlg;
    //物流区
    private String lgcsAreaId;
    //物流区
    private String lgcsAreaCode;
    //物流区名称
    private String lgcsAreaName;
    //买家类型
    private String buyerType;
    //买家类型名称
    private String buyerTypeName;
    //买家一级分类
    private String buyerFirstCategory;
    //买家一级分类名称
    private String buyerFirstCategoryName;
    //买家二级分类
    private String buyerSubCategory;
    //买家二级分类名称
    private String buyerSubCategoryName;

    /**
     * <p>默认构造函数</p>
     */
    public BuyerPoolRelationShipParam() {
    }

    @Override
    public boolean equals(Object obj) {
        BuyerPoolRelationShipParam s = (BuyerPoolRelationShipParam) obj;
        return buyerId.equals(s.buyerId) && buyerPoolId.equals(s.buyerPoolId);
    }

    @Override
    public int hashCode() {
        String in = buyerId + buyerPoolId;
        return in.hashCode();
    }

    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }

    public String getBuyerType() {
        return buyerType;
    }

    public void setBuyerType(String buyerType) {
        this.buyerType = buyerType;
    }

    public String getBuyerTypeName() {
        return buyerTypeName;
    }

    public void setBuyerTypeName(String buyerTypeName) {
        this.buyerTypeName = buyerTypeName;
    }

    public String getBuyerFirstCategory() {
        return buyerFirstCategory;
    }

    public void setBuyerFirstCategory(String buyerFirstCategory) {
        this.buyerFirstCategory = buyerFirstCategory;
    }

    public String getBuyerFirstCategoryName() {
        return buyerFirstCategoryName;
    }

    public void setBuyerFirstCategoryName(String buyerFirstCategoryName) {
        this.buyerFirstCategoryName = buyerFirstCategoryName;
    }

    public String getLgcsAreaId() {
        return lgcsAreaId;
    }

    public void setLgcsAreaId(String lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

    public String getBuyerSubCategory() {
        return buyerSubCategory;
    }

    public void setBuyerSubCategory(String buyerSubCategory) {
        this.buyerSubCategory = buyerSubCategory;
    }

    public String getBuyerSubCategoryName() {
        return buyerSubCategoryName;
    }

    public void setBuyerSubCategoryName(String buyerSubCategoryName) {
        this.buyerSubCategoryName = buyerSubCategoryName;
    }

    /**
     * <p>RELATION_SHIP_ID</p>
     *
     * @return RELATION_SHIP_ID
     */
    public Long getRelationShipId() {
        return relationShipId;
    }


    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }

    /**
     * <p>RELATION_SHIP_ID</p>
     *
     * @param relationShipId RELATION_SHIP_ID
     */
    public void setRelationShipId(Long relationShipId) {
        this.relationShipId = relationShipId;
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
     * <p>BUYER_POOL_ID</p>
     *
     * @return BUYER_POOL_ID
     */
    public Long getBuyerPoolId() {
        return buyerPoolId;
    }

    /**
     * <p>BUYER_POOL_ID</p>
     *
     * @param buyerPoolId BUYER_POOL_ID
     */
    public void setBuyerPoolId(Long buyerPoolId) {
        this.buyerPoolId = buyerPoolId;
    }

    /**
     * <p>BUYER_POOL_NAME</p>
     *
     * @return BUYER_POOL_NAME
     */
    public String getBuyerPoolName() {
        return buyerPoolName;
    }

    /**
     * <p>BUYER_POOL_NAME</p>
     *
     * @param buyerPoolName BUYER_POOL_NAME
     */
    public void setBuyerPoolName(String buyerPoolName) {
        this.buyerPoolName = buyerPoolName;
    }

    /**
     * <p>BUYER_POOL_CODE</p>
     *
     * @return BUYER_POOL_CODE
     */
    public String getBuyerPoolCode() {
        return buyerPoolCode;
    }

    /**
     * <p>BUYER_POOL_CODE</p>
     *
     * @param buyerPoolCode BUYER_POOL_CODE
     */
    public void setBuyerPoolCode(String buyerPoolCode) {
        this.buyerPoolCode = buyerPoolCode;
    }

    /**
     * <p>MARKETING_FIRST_STATUS</p>
     *
     * @return MARKETING_FIRST_STATUS
     */
    public String getMarketingFirstStatus() {
        return marketingFirstStatus;
    }

    /**
     * <p>MARKETING_FIRST_STATUS</p>
     *
     * @param marketingFirstStatus MARKETING_FIRST_STATUS
     */
    public void setMarketingFirstStatus(String marketingFirstStatus) {
        this.marketingFirstStatus = marketingFirstStatus;
    }

    /**
     * <p>MARKETING_FIRST_STATUS_NAME</p>
     *
     * @return MARKETING_FIRST_STATUS_NAME
     */
    public String getMarketingFirstStatusName() {
        return marketingFirstStatusName;
    }

    /**
     * <p>MARKETING_FIRST_STATUS_NAME</p>
     *
     * @param marketingFirstStatusName MARKETING_FIRST_STATUS_NAME
     */
    public void setMarketingFirstStatusName(String marketingFirstStatusName) {
        this.marketingFirstStatusName = marketingFirstStatusName;
    }

    /**
     * <p>MARKETING_SUB_STATUS</p>
     *
     * @return MARKETING_SUB_STATUS
     */
    public String getMarketingSubStatus() {
        return marketingSubStatus;
    }

    /**
     * <p>MARKETING_SUB_STATUS</p>
     *
     * @param marketingSubStatus MARKETING_SUB_STATUS
     */
    public void setMarketingSubStatus(String marketingSubStatus) {
        this.marketingSubStatus = marketingSubStatus;
    }

    /**
     * <p>MARKETING_SUB_STATUS_NAME</p>
     *
     * @return MARKETING_SUB_STATUS_NAME
     */
    public String getMarketingSubStatusName() {
        return marketingSubStatusName;
    }

    /**
     * <p>MARKETING_SUB_STATUS_NAME</p>
     *
     * @param marketingSubStatusName MARKETING_SUB_STATUS_NAME
     */
    public void setMarketingSubStatusName(String marketingSubStatusName) {
        this.marketingSubStatusName = marketingSubStatusName;
    }

    /**
     * <p>BUYER_POOL_TYPE</p>
     *
     * @return BUYER_POOL_TYPE
     */
    public String getBuyerPoolType() {
        return buyerPoolType;
    }

    /**
     * <p>BUYER_POOL_TYPE</p>
     *
     * @param buyerPoolType BUYER_POOL_TYPE
     */
    public void setBuyerPoolType(String buyerPoolType) {
        this.buyerPoolType = buyerPoolType;
    }

}
