package com.bms.slim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLIM0111IParam", description = "批量查询卖家代理商供应资质接口入参")
public class SLIM0111IParam extends BaseRestPaginationParam {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "卖家代理商供应资质Id集合")
    private List<Long> asqIds;
    @ApiModelProperty(value = "实体卖家ID集合")
    private List<Long> entitySellerIds;
    /*@ApiModelProperty(value = "代理商名称")
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
    private String foodBizLicUrl;*/
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public List<Long> getAsqIds() {
        return asqIds;
    }

    public void setAsqIds(List<Long> asqIds) {
        this.asqIds = asqIds;
    }

    public List<Long> getEntitySellerIds() {
        return entitySellerIds;
    }

    public void setEntitySellerIds(List<Long> entitySellerIds) {
        this.entitySellerIds = entitySellerIds;
    }

    /*public String getAgentName() {
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
    }*/

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
