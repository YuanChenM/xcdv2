package com.bms.byim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by yuan_zhifei on 2017/3/15.
 */
@ApiModel(value = "ButlerBuyerRelationRsPageParam", description = "买家所属的买手和管家信息查询参数")
public class ButlerBuyerRelationRsPageParam extends BaseRestPaginationParam {
    @ApiModelProperty(value = "关系ID")
    private Long relationId;
    @ApiModelProperty(value = "买家ID")
    private String buyerId;
    @ApiModelProperty(value = "买手ID")
    private String agentId;
    @ApiModelProperty(value = "买手姓名")
    private String agentName;
    @ApiModelProperty(value = "买手编码")
    private String agentCode;
    @ApiModelProperty(value = "管家ID")
    private String butlerId;
    @ApiModelProperty(value = "管家姓名")
    private String butlerName;
    @ApiModelProperty(value = "管家编码")
    private String butlerCode;
    @ApiModelProperty(value = "管家帐号")
    private String butlerAccount;
    @ApiModelProperty(value = "管家注册手机号")
    private String butlerTelNo;
    @ApiModelProperty(value = "1:普通会员 2:专属会员")
    private String memberType;
    @ApiModelProperty(value = "1:平台分配 2:买家找管家 3:管家找买家")
    private String bingingType;
    @ApiModelProperty(value = "开始时间")
    private String startTime;
    @ApiModelProperty(value = "结束时间")
    private String endTime;
    @ApiModelProperty(value = "解除关系原因")
    private String releaseReason;
    @ApiModelProperty(value = "是否包含历史信息")
    private boolean isIncludeHistory;
    @ApiModelProperty(value = "物流区ID")
    private Long lgcsAreaId;
    @ApiModelProperty(value = "物流区编码")
    private String lgcsAreaCode;
    @ApiModelProperty(value = "物流区名称")
    private String lgcsAreaName;
    @ApiModelProperty(value = "物流区地区ID")
    private Long zoneId;
    @ApiModelProperty(value = "物流区地区编码")
    private String zoneCode;
    @ApiModelProperty(value = "物流区地区名称")
    private String zoneName;
    @ApiModelProperty(value = "配送站ID")
    private Long distributionId;
    @ApiModelProperty(value = "配送站表示码")
    private String distributionName;
    @ApiModelProperty(value = "配送站编码")
    private String distributionCode;
    @ApiModelProperty(value = "领地ID")
    private Long demesneId;
    @ApiModelProperty(value = "领地表示码")
    private String demesneName;
    @ApiModelProperty(value = "领地编码")
    private String demesneCode;
    @ApiModelProperty(value = "买家姓名")
    private String buyerName;
    @ApiModelProperty(value = "买家编码")
    private String buyerCode;
    @ApiModelProperty(value = "买家账号")
    private String buyerAccount;
    @ApiModelProperty(value = "买家注册手机号")
    private String buyerTelNo;
    @ApiModelProperty(value = "买家店铺号")
    private String buyerStoreNo;
    @ApiModelProperty(value = "买家老板名称")
    private String buyerBossName;
    @ApiModelProperty(value = "买家类型")
    private String buyerType;
    @ApiModelProperty(value = "买家类型名称")
    private String buyerTypeName;
    @ApiModelProperty(value = "批发市场/菜场的Id")
    private String buyerMarketId;
    @ApiModelProperty(value = "批发市场/菜场的名称")
    private String buyerMarketName;
    @ApiModelProperty(value = "管家物流区ID")
    private Long butlerLgcsAreaId;
    @ApiModelProperty(value = "管家物流区编码")
    private String butlerLgcsAreaCode;
    @ApiModelProperty(value = "管家物流区名称")
    private String butlerLgcsAreaName;
    @ApiModelProperty(value = "管家物流区地区ID")
    private Long butlerZoneId;
    @ApiModelProperty(value = "管家物流区地区编码")
    private String butlerZoneCode;
    @ApiModelProperty(value = "管家物流区地区名称")
    private String butlerZoneName;
    @ApiModelProperty(value = "买手物流区ID")
    private Long agentLgcsAreaId;
    @ApiModelProperty(value = "买手物流区编码")
    private String agentLgcsAreaCode;
    @ApiModelProperty(value = "买手物流区名称")
    private String agentLgcsAreaName;
    @ApiModelProperty(value = "买手物流区地区ID")
    private Long agentZoneId;
    @ApiModelProperty(value = "买手物流区地区编码")
    private String agentZoneCode;
    @ApiModelProperty(value = "买手物流区地区名称")
    private String agentZoneName;

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getButlerId() {
        return butlerId;
    }

    public void setButlerId(String butlerId) {
        this.butlerId = butlerId;
    }

    public String getButlerName() {
        return butlerName;
    }

    public void setButlerName(String butlerName) {
        this.butlerName = butlerName;
    }

    public String getButlerCode() {
        return butlerCode;
    }

    public void setButlerCode(String butlerCode) {
        this.butlerCode = butlerCode;
    }

    public String getButlerAccount() {
        return butlerAccount;
    }

    public void setButlerAccount(String butlerAccount) {
        this.butlerAccount = butlerAccount;
    }

    public String getButlerTelNo() {
        return butlerTelNo;
    }

    public void setButlerTelNo(String butlerTelNo) {
        this.butlerTelNo = butlerTelNo;
    }


    public String getBingingType() {
        return bingingType;
    }

    public void setBingingType(String bingingType) {
        this.bingingType = bingingType;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getReleaseReason() {
        return releaseReason;
    }

    public void setReleaseReason(String releaseReason) {
        this.releaseReason = releaseReason;
    }

    public boolean isIncludeHistory() {
        return isIncludeHistory;
    }

    public void setIncludeHistory(boolean includeHistory) {
        isIncludeHistory = includeHistory;
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

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerCode() {
        return buyerCode;
    }

    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    public String getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(String buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    public String getBuyerTelNo() {
        return buyerTelNo;
    }

    public void setBuyerTelNo(String buyerTelNo) {
        this.buyerTelNo = buyerTelNo;
    }

    public String getBuyerStoreNo() {
        return buyerStoreNo;
    }

    public void setBuyerStoreNo(String buyerStoreNo) {
        this.buyerStoreNo = buyerStoreNo;
    }

    public String getBuyerBossName() {
        return buyerBossName;
    }

    public void setBuyerBossName(String buyerBossName) {
        this.buyerBossName = buyerBossName;
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

    public String getBuyerMarketId() {
        return buyerMarketId;
    }

    public void setBuyerMarketId(String buyerMarketId) {
        this.buyerMarketId = buyerMarketId;
    }

    public String getBuyerMarketName() {
        return buyerMarketName;
    }

    public void setBuyerMarketName(String buyerMarketName) {
        this.buyerMarketName = buyerMarketName;
    }

    public Long getButlerLgcsAreaId() {
        return butlerLgcsAreaId;
    }

    public void setButlerLgcsAreaId(Long butlerLgcsAreaId) {
        this.butlerLgcsAreaId = butlerLgcsAreaId;
    }

    public String getButlerLgcsAreaCode() {
        return butlerLgcsAreaCode;
    }

    public void setButlerLgcsAreaCode(String butlerLgcsAreaCode) {
        this.butlerLgcsAreaCode = butlerLgcsAreaCode;
    }

    public String getButlerLgcsAreaName() {
        return butlerLgcsAreaName;
    }

    public void setButlerLgcsAreaName(String butlerLgcsAreaName) {
        this.butlerLgcsAreaName = butlerLgcsAreaName;
    }

    public Long getButlerZoneId() {
        return butlerZoneId;
    }

    public void setButlerZoneId(Long butlerZoneId) {
        this.butlerZoneId = butlerZoneId;
    }

    public String getButlerZoneCode() {
        return butlerZoneCode;
    }

    public void setButlerZoneCode(String butlerZoneCode) {
        this.butlerZoneCode = butlerZoneCode;
    }

    public String getButlerZoneName() {
        return butlerZoneName;
    }

    public void setButlerZoneName(String butlerZoneName) {
        this.butlerZoneName = butlerZoneName;
    }

    public Long getAgentLgcsAreaId() {
        return agentLgcsAreaId;
    }

    public void setAgentLgcsAreaId(Long agentLgcsAreaId) {
        this.agentLgcsAreaId = agentLgcsAreaId;
    }

    public String getAgentLgcsAreaCode() {
        return agentLgcsAreaCode;
    }

    public void setAgentLgcsAreaCode(String agentLgcsAreaCode) {
        this.agentLgcsAreaCode = agentLgcsAreaCode;
    }

    public String getAgentLgcsAreaName() {
        return agentLgcsAreaName;
    }

    public void setAgentLgcsAreaName(String agentLgcsAreaName) {
        this.agentLgcsAreaName = agentLgcsAreaName;
    }

    public Long getAgentZoneId() {
        return agentZoneId;
    }

    public void setAgentZoneId(Long agentZoneId) {
        this.agentZoneId = agentZoneId;
    }

    public String getAgentZoneCode() {
        return agentZoneCode;
    }

    public void setAgentZoneCode(String agentZoneCode) {
        this.agentZoneCode = agentZoneCode;
    }

    public String getAgentZoneName() {
        return agentZoneName;
    }

    public void setAgentZoneName(String agentZoneName) {
        this.agentZoneName = agentZoneName;
    }
}
