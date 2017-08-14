package com.bms.agif.bean.param;

import java.io.Serializable;

/**
 * Created by guan_zhongheng on 2017/3/15.
 */
public class DemesneParam implements Serializable{

    //配送站主键
    private Long distributionId;
    //配送站編碼
    private String distributionCode;
    //配送站表示碼
    private String distributionName;
    //领地ID
    private Long demesneId;
    //领地分类
    private String demesneType;
    //领地表示码
    private String demesneName;
    //领地编码(地区码+领地地区顺序码 001开始)
    private String demesneCode;
    //领地面积（单位：km²）
    private String demesneArea;
    //所辖区县
    private String managementDistrict;
    //领地边界东向
    private String demesneEast;
    //领地边界南向
    private String demesneSouth;
    //领地边界西向
    private String demesneWest;
    //领地边界北向
    private String demesneNorth;
    //批发市场个数
    private Integer terminalMarketNum;
    //菜场个数(单位：个)
    private Integer foodMarketNum;
    //餐饮聚集区个数(单位：个)
    private Integer cookingGatheringNum;
    //团膳聚集区个数(单位：个)
    private Integer mealsGatheringNum;
    //加工厂个数
    private Integer processNum;
    //领地授权销售合伙人
    private String authorizedAgent;
    //备注
    private String remarks;
    //数据有效性标识(默认为有效)
    private String disableFlg;
    //规划图地址编码
    private String planPic;

    public Long getDistributionId() {
        return distributionId;
    }

    public void setDistributionId(Long distributionId) {
        this.distributionId = distributionId;
    }

    public String getDistributionCode() {
        return distributionCode;
    }

    public void setDistributionCode(String distributionCode) {
        this.distributionCode = distributionCode;
    }

    public String getDistributionName() {
        return distributionName;
    }

    public void setDistributionName(String distributionName) {
        this.distributionName = distributionName;
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

    public String getAuthorizedAgent() {
        return authorizedAgent;
    }

    public void setAuthorizedAgent(String authorizedAgent) {
        this.authorizedAgent = authorizedAgent;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDisableFlg() {
        return disableFlg;
    }

    public void setDisableFlg(String disableFlg) {
        this.disableFlg = disableFlg;
    }

    public String getPlanPic() {
        return planPic;
    }

    public void setPlanPic(String planPic) {
        this.planPic = planPic;
    }
}
