package com.bms.region.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by guan_zhongheng on 2017/2/20.
 */
@ApiModel(value = "RegnLogDistributionParam", description = "物流区县信息类")
public class RegnLogDistributionParam extends RegnLogisticsZoneParam {
    @ApiModelProperty(value = "配送站主键")
    private Long distributionId;
    @ApiModelProperty(value = "配送站表示码")
    private String distributionName;
    @ApiModelProperty(value = "配送站编码(全国所有配送站用4位阿拉伯数字，系统自动按新增顺序从0001顺序编码)")
    private String distributionCode;
    @ApiModelProperty(value = "配送站分类")
    private String distributionType;
    @ApiModelProperty(value = "配送站面积（单位：km²）")
    private String distributionArea;
    @ApiModelProperty(value = "所辖区县")
    private String managementDistrict;
    @ApiModelProperty(value = "配送站边界东向")
    private String distributionEast;
    @ApiModelProperty(value = "配送站边界南向")
    private String distributionSouth;
    @ApiModelProperty(value = "配送站边界西向")
    private String distributionWest;
    @ApiModelProperty(value = "配送站边界北向")
    private String distributionNorth;
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
    @ApiModelProperty(value = "领地授权销售合伙人")
    private String authorizedPartner;
    @ApiModelProperty(value = "备注")
    private String remarks;
    @ApiModelProperty(value = "规划图地址编码")
    private String planPic;
    @ApiModelProperty(value = "销售合伙人ID")
    private String partnerId;


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

    public String getDistributionType() {
        return distributionType;
    }

    public void setDistributionType(String distributionType) {
        this.distributionType = distributionType;
    }

    public String getDistributionArea() {
        return distributionArea;
    }

    public void setDistributionArea(String distributionArea) {
        this.distributionArea = distributionArea;
    }

    public String getManagementDistrict() {
        return managementDistrict;
    }

    public void setManagementDistrict(String managementDistrict) {
        this.managementDistrict = managementDistrict;
    }

    public String getDistributionEast() {
        return distributionEast;
    }

    public void setDistributionEast(String distributionEast) {
        this.distributionEast = distributionEast;
    }

    public String getDistributionSouth() {
        return distributionSouth;
    }

    public void setDistributionSouth(String distributionSouth) {
        this.distributionSouth = distributionSouth;
    }

    public String getDistributionWest() {
        return distributionWest;
    }

    public void setDistributionWest(String distributionWest) {
        this.distributionWest = distributionWest;
    }

    public String getDistributionNorth() {
        return distributionNorth;
    }

    public void setDistributionNorth(String distributionNorth) {
        this.distributionNorth = distributionNorth;
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

    public String getAuthorizedPartner() {
        return authorizedPartner;
    }

    public void setAuthorizedPartner(String authorizedPartner) {
        this.authorizedPartner = authorizedPartner;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPlanPic() {
        return planPic;
    }

    public void setPlanPic(String planPic) {
        this.planPic = planPic;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }
}
