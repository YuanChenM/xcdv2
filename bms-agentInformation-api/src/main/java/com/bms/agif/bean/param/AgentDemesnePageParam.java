package com.bms.agif.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by guan_zhongheng on 2017/3/2.
 */
@ApiModel(value = "AgentDemesnePageParam",
        description = "买手领地关联信息类")
public class AgentDemesnePageParam extends AgentPageParam {

    @ApiModelProperty(value = "RELATION_ID")
    private Long agentDemesneId;
    @ApiModelProperty(value = "物流区主键")
    private Long lgcsAreaId;
    @ApiModelProperty(value = "物流区编码")
    private String lgcsAreaCode;
    @ApiModelProperty(value = "物流区名称")
    private String lgcsAreaName;
    @ApiModelProperty(value = "物流区划地区主键")
    private Long zoneId;
    @ApiModelProperty(value = "物流区划地区编码")
    private String zoneCode;
    @ApiModelProperty(value = "物流区划地区名称")
    private String zoneName;
    @ApiModelProperty(value = "配送站主键")
    private Long distributionId;
    @ApiModelProperty(value = "配送站分类")
    private String distributionType;
    @ApiModelProperty(value = "配送站表示码")
    private String distributionName;
    @ApiModelProperty(value = "配送站编码(全国所有配送站用4位阿拉伯数字，系统自动按新增顺序从0001顺序编码)")
    private String distributionCode;
    @ApiModelProperty(value = "配送站授权合伙人")
    private String authorizedPartner;
    @ApiModelProperty(value = "领地ID")
    private Long demesneId;
    @ApiModelProperty(value = "领地分类")
    private String demesneType;
    @ApiModelProperty(value = "领地表示码")
    private String demesneName;
    @ApiModelProperty(value = "领地编码(以配送站为单元用2位阿拉伯数字，系统自动按新增顺序从01顺序编码)")
    private String demesneCode;
    @ApiModelProperty(value = "领地授权买手")
    private String authorizedAgent;
    @ApiModelProperty(value = "领地面积（单位：km²）")
    private String demesneArea;
    @ApiModelProperty(value = "所辖区县 ")
    private String managementDistrict;
    @ApiModelProperty(value = "领地边界东向")
    private String demesneEast;
    @ApiModelProperty(value = "领地边界南向")
    private String demesneSouth;
    @ApiModelProperty(value = "领地边界西向")
    private String demesneWest;
    @ApiModelProperty(value = "领地边界北向")
    private String demesneNorth;
    @ApiModelProperty(value = "批发市场个数")
    private Integer terminalMarketNum;
    @ApiModelProperty(value = "菜场个数(单位：个)")
    private Integer foodMarketNum;
    @ApiModelProperty(value = "餐饮聚集区个数(单位：个)")
    private Integer cookingGatheringNum;
    @ApiModelProperty(value = "团膳聚集区个数(单位：个)")
    private Integer mealsGatheringNum;
    @ApiModelProperty(value = "加工厂个数")
    private Integer processNum;
    @ApiModelProperty(value = "规划图附件")
    private String planPic;
    @ApiModelProperty(value = "备注")
    private String remarks;
    
    
    public Long getAgentDemesneId() {
        return agentDemesneId;
    }

    public String getDemesneArea() {
        return demesneArea;
    }

    public void setDemesneArea(String demesneArea) {
        this.demesneArea = demesneArea;
    }

    public String getManagementDistrict() {
        return managementDistrict;
    }

    public void setManagementDistrict(String managementDistrict) {
        this.managementDistrict = managementDistrict;
    }

    public String getDemesneEast() {
        return demesneEast;
    }

    public void setDemesneEast(String demesneEast) {
        this.demesneEast = demesneEast;
    }

    public String getDemesneSouth() {
        return demesneSouth;
    }

    public void setDemesneSouth(String demesneSouth) {
        this.demesneSouth = demesneSouth;
    }

    public String getDemesneWest() {
        return demesneWest;
    }

    public void setDemesneWest(String demesneWest) {
        this.demesneWest = demesneWest;
    }

    public String getDemesneNorth() {
        return demesneNorth;
    }

    public void setDemesneNorth(String demesneNorth) {
        this.demesneNorth = demesneNorth;
    }

    public Integer getTerminalMarketNum() {
        return terminalMarketNum;
    }

    public void setTerminalMarketNum(Integer terminalMarketNum) {
        this.terminalMarketNum = terminalMarketNum;
    }

    public Integer getFoodMarketNum() {
        return foodMarketNum;
    }

    public void setFoodMarketNum(Integer foodMarketNum) {
        this.foodMarketNum = foodMarketNum;
    }

    public Integer getCookingGatheringNum() {
        return cookingGatheringNum;
    }

    public void setCookingGatheringNum(Integer cookingGatheringNum) {
        this.cookingGatheringNum = cookingGatheringNum;
    }

    public Integer getMealsGatheringNum() {
        return mealsGatheringNum;
    }

    public void setMealsGatheringNum(Integer mealsGatheringNum) {
        this.mealsGatheringNum = mealsGatheringNum;
    }

    public Integer getProcessNum() {
        return processNum;
    }

    public void setProcessNum(Integer processNum) {
        this.processNum = processNum;
    }

    public String getPlanPic() {
        return planPic;
    }

    public void setPlanPic(String planPic) {
        this.planPic = planPic;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public String getAuthorizedPartner() {
        return authorizedPartner;
    }

    public void setAuthorizedPartner(String authorizedPartner) {
        this.authorizedPartner = authorizedPartner;
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
}
