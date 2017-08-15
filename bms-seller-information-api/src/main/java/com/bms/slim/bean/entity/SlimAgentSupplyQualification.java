/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLIM_AGENT_SUPPLY_QUALIFICATION对应的实体SlimAgentSupplyQualification</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimAgentSupplyQualification extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 代理商供应资质ID */
    private Long asqId;
    /** 实体卖家ID */
    private Long entitySellerId;
    /** 代理商名称 */
    private String agentName;
    /** 代理区域 */
    private String agentArea;
    /** 代理产品范围 */
    private String agentProductRange;
    /** 代理销售协议有效期限 */
    private String asaValidPeriod;
    /** 代理销售协议URL */
    private String asaUrl;
    /** 授权人 */
    private String authorizerName;
    /** 被授权人 */
    private String authorizeeName;
    /** 授权产品范围 */
    private String authorizedProductRange;
    /** 授权经营区域 */
    private String authorizedBusinessArea;
    /** 授权有效期限 */
    private String authorizedValidPeriod;
    /** 授权书URL */
    private String authCertUrl;
    /** 食品经营许可证编号 */
    private String foodBizLicNo;
    /** 食品经营许可证有效期限 */
    private String fblValidPeriod;
    /** 食品经营许可证URL */
    private String foodBizLicUrl;

    /**
     * <p>默认构造函数</p>
     */
    public SlimAgentSupplyQualification() {
    }

    /**
     * <p>代理商供应资质ID</p>
     *
     * @return 代理商供应资质ID
     */
    public Long getAsqId() {
        return asqId;
    }

    /**
     * <p>代理商供应资质ID</p>
     *
     * @param asqId 代理商供应资质ID
     */
    public void setAsqId(Long asqId) {
        this.asqId = asqId;
    }
    /**
     * <p>实体卖家ID</p>
     *
     * @return 实体卖家ID
     */
    public Long getEntitySellerId() {
        return entitySellerId;
    }

    /**
     * <p>实体卖家ID</p>
     *
     * @param entitySellerId 实体卖家ID
     */
    public void setEntitySellerId(Long entitySellerId) {
        this.entitySellerId = entitySellerId;
    }
    /**
     * <p>代理商名称</p>
     *
     * @return 代理商名称
     */
    public String getAgentName() {
        return agentName;
    }

    /**
     * <p>代理商名称</p>
     *
     * @param agentName 代理商名称
     */
    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }
    /**
     * <p>代理区域</p>
     *
     * @return 代理区域
     */
    public String getAgentArea() {
        return agentArea;
    }

    /**
     * <p>代理区域</p>
     *
     * @param agentArea 代理区域
     */
    public void setAgentArea(String agentArea) {
        this.agentArea = agentArea;
    }
    /**
     * <p>代理产品范围</p>
     *
     * @return 代理产品范围
     */
    public String getAgentProductRange() {
        return agentProductRange;
    }

    /**
     * <p>代理产品范围</p>
     *
     * @param agentProductRange 代理产品范围
     */
    public void setAgentProductRange(String agentProductRange) {
        this.agentProductRange = agentProductRange;
    }
    /**
     * <p>代理销售协议有效期限</p>
     *
     * @return 代理销售协议有效期限
     */
    public String getAsaValidPeriod() {
        return asaValidPeriod;
    }

    /**
     * <p>代理销售协议有效期限</p>
     *
     * @param asaValidPeriod 代理销售协议有效期限
     */
    public void setAsaValidPeriod(String asaValidPeriod) {
        this.asaValidPeriod = asaValidPeriod;
    }
    /**
     * <p>代理销售协议URL</p>
     *
     * @return 代理销售协议URL
     */
    public String getAsaUrl() {
        return asaUrl;
    }

    /**
     * <p>代理销售协议URL</p>
     *
     * @param asaUrl 代理销售协议URL
     */
    public void setAsaUrl(String asaUrl) {
        this.asaUrl = asaUrl;
    }
    /**
     * <p>授权人</p>
     *
     * @return 授权人
     */
    public String getAuthorizerName() {
        return authorizerName;
    }

    /**
     * <p>授权人</p>
     *
     * @param authorizerName 授权人
     */
    public void setAuthorizerName(String authorizerName) {
        this.authorizerName = authorizerName;
    }
    /**
     * <p>被授权人</p>
     *
     * @return 被授权人
     */
    public String getAuthorizeeName() {
        return authorizeeName;
    }

    /**
     * <p>被授权人</p>
     *
     * @param authorizeeName 被授权人
     */
    public void setAuthorizeeName(String authorizeeName) {
        this.authorizeeName = authorizeeName;
    }
    /**
     * <p>授权产品范围</p>
     *
     * @return 授权产品范围
     */
    public String getAuthorizedProductRange() {
        return authorizedProductRange;
    }

    /**
     * <p>授权产品范围</p>
     *
     * @param authorizedProductRange 授权产品范围
     */
    public void setAuthorizedProductRange(String authorizedProductRange) {
        this.authorizedProductRange = authorizedProductRange;
    }
    /**
     * <p>授权经营区域</p>
     *
     * @return 授权经营区域
     */
    public String getAuthorizedBusinessArea() {
        return authorizedBusinessArea;
    }

    /**
     * <p>授权经营区域</p>
     *
     * @param authorizedBusinessArea 授权经营区域
     */
    public void setAuthorizedBusinessArea(String authorizedBusinessArea) {
        this.authorizedBusinessArea = authorizedBusinessArea;
    }
    /**
     * <p>授权有效期限</p>
     *
     * @return 授权有效期限
     */
    public String getAuthorizedValidPeriod() {
        return authorizedValidPeriod;
    }

    /**
     * <p>授权有效期限</p>
     *
     * @param authorizedValidPeriod 授权有效期限
     */
    public void setAuthorizedValidPeriod(String authorizedValidPeriod) {
        this.authorizedValidPeriod = authorizedValidPeriod;
    }
    /**
     * <p>授权书URL</p>
     *
     * @return 授权书URL
     */
    public String getAuthCertUrl() {
        return authCertUrl;
    }

    /**
     * <p>授权书URL</p>
     *
     * @param authCertUrl 授权书URL
     */
    public void setAuthCertUrl(String authCertUrl) {
        this.authCertUrl = authCertUrl;
    }
    /**
     * <p>食品经营许可证编号</p>
     *
     * @return 食品经营许可证编号
     */
    public String getFoodBizLicNo() {
        return foodBizLicNo;
    }

    /**
     * <p>食品经营许可证编号</p>
     *
     * @param foodBizLicNo 食品经营许可证编号
     */
    public void setFoodBizLicNo(String foodBizLicNo) {
        this.foodBizLicNo = foodBizLicNo;
    }
    /**
     * <p>食品经营许可证有效期限</p>
     *
     * @return 食品经营许可证有效期限
     */
    public String getFblValidPeriod() {
        return fblValidPeriod;
    }

    /**
     * <p>食品经营许可证有效期限</p>
     *
     * @param fblValidPeriod 食品经营许可证有效期限
     */
    public void setFblValidPeriod(String fblValidPeriod) {
        this.fblValidPeriod = fblValidPeriod;
    }
    /**
     * <p>食品经营许可证URL</p>
     *
     * @return 食品经营许可证URL
     */
    public String getFoodBizLicUrl() {
        return foodBizLicUrl;
    }

    /**
     * <p>食品经营许可证URL</p>
     *
     * @param foodBizLicUrl 食品经营许可证URL
     */
    public void setFoodBizLicUrl(String foodBizLicUrl) {
        this.foodBizLicUrl = foodBizLicUrl;
    }

}
