package com.bms.slim.bean.result.field;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class SLIM0111AgentSupplyQualificationResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "代理商供应资质ID")
    private Long asqId;
    @ApiModelProperty(value = "实体卖家ID")
    private Long entitySellerId;
    @ApiModelProperty(value = "代理商名称")
    private String agentName;
    @ApiModelProperty(value = "代理区域")
    private String agentArea;
    @ApiModelProperty(value = "代理产品范围")
    private String agentProductRange;
    @ApiModelProperty(value = "代理销售协议有效期限")
    private String asaValidPeriod;
    @ApiModelProperty(value = "代理销售协议URL")
    private String asaUrl;
    @ApiModelProperty(value = "授权人")
    private String authorizerName;
    @ApiModelProperty(value = "被授权人")
    private String authorizeeName;
    @ApiModelProperty(value = "授权产品范围")
    private String authorizedProductRange;
    @ApiModelProperty(value = "授权经营区域")
    private String authorizedBusinessArea;
    @ApiModelProperty(value = "授权有效期限")
    private String authorizedValidPeriod;
    @ApiModelProperty(value = "授权书URL")
    private String authCertUrl;
    @ApiModelProperty(value = "食品经营许可证编号")
    private String foodBizLicNo;
    @ApiModelProperty(value = "食品经营许可证有效期限")
    private String fblValidPeriod;
    @ApiModelProperty(value = "食品经营许可证URL")
    private String foodBizLicUrl;
    @ApiModelProperty(value = "删除标识，true：已删除，false：未删除")
    private Boolean delFlg;
    @ApiModelProperty(value = "新建人ID")
    private String crtId;
    @ApiModelProperty(value = "新建时间")
    private Date crtTime;
    @ApiModelProperty(value = "修改人ID")
    private String updId;
    @ApiModelProperty(value = "修改时间")
    private Date updTime;
    @ApiModelProperty(value = "版本")
    private Integer version;

    public Long getAsqId() {
        return asqId;
    }

    public void setAsqId(Long asqId) {
        this.asqId = asqId;
    }

    public Long getEntitySellerId() {
        return entitySellerId;
    }

    public void setEntitySellerId(Long entitySellerId) {
        this.entitySellerId = entitySellerId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentArea() {
        return agentArea;
    }

    public void setAgentArea(String agentArea) {
        this.agentArea = agentArea;
    }

    public String getAgentProductRange() {
        return agentProductRange;
    }

    public void setAgentProductRange(String agentProductRange) {
        this.agentProductRange = agentProductRange;
    }

    public String getAsaValidPeriod() {
        return asaValidPeriod;
    }

    public void setAsaValidPeriod(String asaValidPeriod) {
        this.asaValidPeriod = asaValidPeriod;
    }

    public String getAsaUrl() {
        return asaUrl;
    }

    public void setAsaUrl(String asaUrl) {
        this.asaUrl = asaUrl;
    }

    public String getAuthorizerName() {
        return authorizerName;
    }

    public void setAuthorizerName(String authorizerName) {
        this.authorizerName = authorizerName;
    }

    public String getAuthorizeeName() {
        return authorizeeName;
    }

    public void setAuthorizeeName(String authorizeeName) {
        this.authorizeeName = authorizeeName;
    }

    public String getAuthorizedProductRange() {
        return authorizedProductRange;
    }

    public void setAuthorizedProductRange(String authorizedProductRange) {
        this.authorizedProductRange = authorizedProductRange;
    }

    public String getAuthorizedBusinessArea() {
        return authorizedBusinessArea;
    }

    public void setAuthorizedBusinessArea(String authorizedBusinessArea) {
        this.authorizedBusinessArea = authorizedBusinessArea;
    }

    public String getAuthorizedValidPeriod() {
        return authorizedValidPeriod;
    }

    public void setAuthorizedValidPeriod(String authorizedValidPeriod) {
        this.authorizedValidPeriod = authorizedValidPeriod;
    }

    public String getAuthCertUrl() {
        return authCertUrl;
    }

    public void setAuthCertUrl(String authCertUrl) {
        this.authCertUrl = authCertUrl;
    }

    public String getFoodBizLicNo() {
        return foodBizLicNo;
    }

    public void setFoodBizLicNo(String foodBizLicNo) {
        this.foodBizLicNo = foodBizLicNo;
    }

    public String getFblValidPeriod() {
        return fblValidPeriod;
    }

    public void setFblValidPeriod(String fblValidPeriod) {
        this.fblValidPeriod = fblValidPeriod;
    }

    public String getFoodBizLicUrl() {
        return foodBizLicUrl;
    }

    public void setFoodBizLicUrl(String foodBizLicUrl) {
        this.foodBizLicUrl = foodBizLicUrl;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
