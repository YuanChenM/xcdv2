package com.bms.order.external.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;

/**
 * Created by ni_shaotang on 2017/3/15.
 */
public class AGIF0205IRestParam extends BaseRestPaginationParam {
    //买手领地关系id
    private Long agentDemesneId;
    //物流区id
    private Long lgcsAreaId;
    //物流区编码
    private String lgcsAreaCode;
    //物流区名称
    private String lgcsAreaName;
    //地区id
    private Long zoneId;
    //地区编码
    private String zoneCode;
    //地区名称
    private String zoneName;
    //配送站id
    private Long distributionId;
    //配送站类型
    private String distributionType;
    //配送站表示码
    private String distributionName;
    //配送站编码
    private String distributionCode;
    //领地id
    private Long demesneId;
    //领地类型
    private String demesneType;
    //领地表示码
    private String demesneName;
    //领地编码
    private String demesneCode;
    //领地授权买手
    private String authorizedAgent;
    //配送站授权合伙人
    private String authorizedPartner;
    //买手ID
    private String agentId;

    public Long getAgentDemesneId() {
        return agentDemesneId;
    }

    public void setAgentDemesneId(Long agentDemesneId) {
        this.agentDemesneId = agentDemesneId;
    }

    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
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

    public String getDistributionType() {
        return distributionType;
    }

    public void setDistributionType(String distributionType) {
        this.distributionType = distributionType;
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

    public String getDemesneType() {
        return demesneType;
    }

    public void setDemesneType(String demesneType) {
        this.demesneType = demesneType;
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

    public String getAuthorizedAgent() {
        return authorizedAgent;
    }

    public void setAuthorizedAgent(String authorizedAgent) {
        this.authorizedAgent = authorizedAgent;
    }

    public String getAuthorizedPartner() {
        return authorizedPartner;
    }

    public void setAuthorizedPartner(String authorizedPartner) {
        this.authorizedPartner = authorizedPartner;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
}
