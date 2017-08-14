/*
 * 2017/03/08 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.agif.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表agif_agent_demesne对应的实体AgifAgentDemesne</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class AgifAgentDemesne extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 关系ID */
    private java.lang.Long agentDemesneId;
    /** 买手ID */
    private java.lang.String agentId;
    /** 物流区主键 */
    private java.lang.Long lgcsAreaId;
    /** 物流区编码 */
    private java.lang.String lgcsAreaCode;
    /** 物流区名称 */
    private java.lang.String lgcsAreaName;
    /** 物流区划地区主键 */
    private java.lang.Long zoneId;
    /** 物流区划地区编码 */
    private java.lang.String zoneCode;
    /** 物流区划地区名称 */
    private java.lang.String zoneName;
    /** 配送站主键 */
    private java.lang.Long distributionId;
    /** 配送站分类 */
    private java.lang.String distributionType;
    /** 配送站表示码 */
    private java.lang.String distributionName;
    /** 配送站编码(全国所有配送站用4位阿拉伯数字，系统自动按新增顺序从0001顺序编码) */
    private java.lang.String distributionCode;
    /** 配送站授权合伙人 */
    private java.lang.String authorizedPartner;
    /** 领地ID */
    private java.lang.Long demesneId;
    /** 领地分类 */
    private java.lang.String demesneType;
    /** 领地表示码 */
    private java.lang.String demesneName;
    /** 领地编码(以配送站为单元用2位阿拉伯数字，系统自动按新增顺序从01顺序编码) */
    private java.lang.String demesneCode;
    /** 领地授权买手 */
    private java.lang.String authorizedAgent;
    /** 领地面积（单位：km²） */
    private java.lang.String demesneArea;
    /** 所辖区县 */
    private java.lang.String managementDistrict;
    /** 领地边界东向 */
    private java.lang.String demesneEast;
    /** 领地边界南向 */
    private java.lang.String demesneSouth;
    /** 领地边界西向 */
    private java.lang.String demesneWest;
    /** 领地边界北向 */
    private java.lang.String demesneNorth;
    /** 批发市场个数 */
    private java.lang.Integer terminalMarketNum;
    /** 菜场个数(单位：个) */
    private java.lang.Integer foodMarketNum;
    /** 餐饮聚集区个数(单位：个) */
    private java.lang.Integer cookingGatheringNum;
    /** 团膳聚集区个数(单位：个) */
    private java.lang.Integer mealsGatheringNum;
    /** 加工厂个数 */
    private java.lang.Integer processNum;
    /** 规划图附件 */
    private java.lang.String planPic;
    /** 备注 */
    private java.lang.String remarks;

    /**
     * <p>默认构造函数</p>
     */
    public AgifAgentDemesne() {
    }

    /**
     * <p>AGENT_DEMESNE_ID</p>
     *
     * @return AGENT_DEMESNE_ID
     */
    public java.lang.Long getAgentDemesneId() {
        return agentDemesneId;
    }

    /**
     * <p>AGENT_DEMESNE_ID</p>
     *
     * @param agentDemesneId AGENT_DEMESNE_ID
     */
    public void setAgentDemesneId(java.lang.Long agentDemesneId) {
        this.agentDemesneId = agentDemesneId;
    }
    /**
     * <p>AGENT_ID</p>
     *
     * @return AGENT_ID
     */
    public java.lang.String getAgentId() {
        return agentId;
    }

    /**
     * <p>AGENT_ID</p>
     *
     * @param agentId AGENT_ID
     */
    public void setAgentId(java.lang.String agentId) {
        this.agentId = agentId;
    }
    /**
     * <p>物流区主键</p>
     *
     * @return 物流区主键
     */
    public java.lang.Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    /**
     * <p>物流区主键</p>
     *
     * @param lgcsAreaId 物流区主键
     */
    public void setLgcsAreaId(java.lang.Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }
    /**
     * <p>物流区编码</p>
     *
     * @return 物流区编码
     */
    public java.lang.String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    /**
     * <p>物流区编码</p>
     *
     * @param lgcsAreaCode 物流区编码
     */
    public void setLgcsAreaCode(java.lang.String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }
    /**
     * <p>物流区名称</p>
     *
     * @return 物流区名称
     */
    public java.lang.String getLgcsAreaName() {
        return lgcsAreaName;
    }

    /**
     * <p>物流区名称</p>
     *
     * @param lgcsAreaName 物流区名称
     */
    public void setLgcsAreaName(java.lang.String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }
    /**
     * <p>物流区划地区主键</p>
     *
     * @return 物流区划地区主键
     */
    public java.lang.Long getZoneId() {
        return zoneId;
    }

    /**
     * <p>物流区划地区主键</p>
     *
     * @param zoneId 物流区划地区主键
     */
    public void setZoneId(java.lang.Long zoneId) {
        this.zoneId = zoneId;
    }
    /**
     * <p>物流区划地区编码</p>
     *
     * @return 物流区划地区编码
     */
    public java.lang.String getZoneCode() {
        return zoneCode;
    }

    /**
     * <p>物流区划地区编码</p>
     *
     * @param zoneCode 物流区划地区编码
     */
    public void setZoneCode(java.lang.String zoneCode) {
        this.zoneCode = zoneCode;
    }
    /**
     * <p>物流区划地区名称</p>
     *
     * @return 物流区划地区名称
     */
    public java.lang.String getZoneName() {
        return zoneName;
    }

    /**
     * <p>物流区划地区名称</p>
     *
     * @param zoneName 物流区划地区名称
     */
    public void setZoneName(java.lang.String zoneName) {
        this.zoneName = zoneName;
    }
    /**
     * <p>配送站主键</p>
     *
     * @return 配送站主键
     */
    public java.lang.Long getDistributionId() {
        return distributionId;
    }

    /**
     * <p>配送站主键</p>
     *
     * @param distributionId 配送站主键
     */
    public void setDistributionId(java.lang.Long distributionId) {
        this.distributionId = distributionId;
    }
    /**
     * <p>配送站分类</p>
     *
     * @return 配送站分类
     */
    public java.lang.String getDistributionType() {
        return distributionType;
    }

    /**
     * <p>配送站分类</p>
     *
     * @param distributionType 配送站分类
     */
    public void setDistributionType(java.lang.String distributionType) {
        this.distributionType = distributionType;
    }
    /**
     * <p>配送站表示码</p>
     *
     * @return 配送站表示码
     */
    public java.lang.String getDistributionName() {
        return distributionName;
    }

    /**
     * <p>配送站表示码</p>
     *
     * @param distributionName 配送站表示码
     */
    public void setDistributionName(java.lang.String distributionName) {
        this.distributionName = distributionName;
    }
    /**
     * <p>配送站编码(全国所有配送站用4位阿拉伯数字，系统自动按新增顺序从0001顺序编码)</p>
     *
     * @return 配送站编码(全国所有配送站用4位阿拉伯数字，系统自动按新增顺序从0001顺序编码)
     */
    public java.lang.String getDistributionCode() {
        return distributionCode;
    }

    /**
     * <p>配送站编码(全国所有配送站用4位阿拉伯数字，系统自动按新增顺序从0001顺序编码)</p>
     *
     * @param distributionCode 配送站编码(全国所有配送站用4位阿拉伯数字，系统自动按新增顺序从0001顺序编码)
     */
    public void setDistributionCode(java.lang.String distributionCode) {
        this.distributionCode = distributionCode;
    }
    /**
     * <p>配送站授权合伙人</p>
     *
     * @return 配送站授权合伙人
     */
    public java.lang.String getAuthorizedPartner() {
        return authorizedPartner;
    }

    /**
     * <p>配送站授权合伙人</p>
     *
     * @param authorizedPartner 配送站授权合伙人
     */
    public void setAuthorizedPartner(java.lang.String authorizedPartner) {
        this.authorizedPartner = authorizedPartner;
    }
    /**
     * <p>领地ID</p>
     *
     * @return 领地ID
     */
    public java.lang.Long getDemesneId() {
        return demesneId;
    }

    /**
     * <p>领地ID</p>
     *
     * @param demesneId 领地ID
     */
    public void setDemesneId(java.lang.Long demesneId) {
        this.demesneId = demesneId;
    }
    /**
     * <p>领地分类</p>
     *
     * @return 领地分类
     */
    public java.lang.String getDemesneType() {
        return demesneType;
    }

    /**
     * <p>领地分类</p>
     *
     * @param demesneType 领地分类
     */
    public void setDemesneType(java.lang.String demesneType) {
        this.demesneType = demesneType;
    }
    /**
     * <p>领地表示码</p>
     *
     * @return 领地表示码
     */
    public java.lang.String getDemesneName() {
        return demesneName;
    }

    /**
     * <p>领地表示码</p>
     *
     * @param demesneName 领地表示码
     */
    public void setDemesneName(java.lang.String demesneName) {
        this.demesneName = demesneName;
    }
    /**
     * <p>领地编码(以配送站为单元用2位阿拉伯数字，系统自动按新增顺序从01顺序编码)</p>
     *
     * @return 领地编码(以配送站为单元用2位阿拉伯数字，系统自动按新增顺序从01顺序编码)
     */
    public java.lang.String getDemesneCode() {
        return demesneCode;
    }

    /**
     * <p>领地编码(以配送站为单元用2位阿拉伯数字，系统自动按新增顺序从01顺序编码)</p>
     *
     * @param demesneCode 领地编码(以配送站为单元用2位阿拉伯数字，系统自动按新增顺序从01顺序编码)
     */
    public void setDemesneCode(java.lang.String demesneCode) {
        this.demesneCode = demesneCode;
    }
    /**
     * <p>领地授权买手</p>
     *
     * @return 领地授权买手
     */
    public java.lang.String getAuthorizedAgent() {
        return authorizedAgent;
    }

    /**
     * <p>领地授权买手</p>
     *
     * @param authorizedAgent 领地授权买手
     */
    public void setAuthorizedAgent(java.lang.String authorizedAgent) {
        this.authorizedAgent = authorizedAgent;
    }
    /**
     * <p>领地面积（单位：km²）</p>
     *
     * @return 领地面积（单位：km²）
     */
    public java.lang.String getDemesneArea() {
        return demesneArea;
    }

    /**
     * <p>领地面积（单位：km²）</p>
     *
     * @param demesneArea 领地面积（单位：km²）
     */
    public void setDemesneArea(java.lang.String demesneArea) {
        this.demesneArea = demesneArea;
    }
    /**
     * <p>所辖区县</p>
     *
     * @return 所辖区县
     */
    public java.lang.String getManagementDistrict() {
        return managementDistrict;
    }

    /**
     * <p>所辖区县</p>
     *
     * @param managementDistrict 所辖区县
     */
    public void setManagementDistrict(java.lang.String managementDistrict) {
        this.managementDistrict = managementDistrict;
    }
    /**
     * <p>领地边界东向</p>
     *
     * @return 领地边界东向
     */
    public java.lang.String getDemesneEast() {
        return demesneEast;
    }

    /**
     * <p>领地边界东向</p>
     *
     * @param demesneEast 领地边界东向
     */
    public void setDemesneEast(java.lang.String demesneEast) {
        this.demesneEast = demesneEast;
    }
    /**
     * <p>领地边界南向</p>
     *
     * @return 领地边界南向
     */
    public java.lang.String getDemesneSouth() {
        return demesneSouth;
    }

    /**
     * <p>领地边界南向</p>
     *
     * @param demesneSouth 领地边界南向
     */
    public void setDemesneSouth(java.lang.String demesneSouth) {
        this.demesneSouth = demesneSouth;
    }
    /**
     * <p>领地边界西向</p>
     *
     * @return 领地边界西向
     */
    public java.lang.String getDemesneWest() {
        return demesneWest;
    }

    /**
     * <p>领地边界西向</p>
     *
     * @param demesneWest 领地边界西向
     */
    public void setDemesneWest(java.lang.String demesneWest) {
        this.demesneWest = demesneWest;
    }
    /**
     * <p>领地边界北向</p>
     *
     * @return 领地边界北向
     */
    public java.lang.String getDemesneNorth() {
        return demesneNorth;
    }

    /**
     * <p>领地边界北向</p>
     *
     * @param demesneNorth 领地边界北向
     */
    public void setDemesneNorth(java.lang.String demesneNorth) {
        this.demesneNorth = demesneNorth;
    }
    /**
     * <p>批发市场个数</p>
     *
     * @return 批发市场个数
     */
    public java.lang.Integer getTerminalMarketNum() {
        return terminalMarketNum;
    }

    /**
     * <p>批发市场个数</p>
     *
     * @param terminalMarketNum 批发市场个数
     */
    public void setTerminalMarketNum(java.lang.Integer terminalMarketNum) {
        this.terminalMarketNum = terminalMarketNum;
    }
    /**
     * <p>菜场个数(单位：个)</p>
     *
     * @return 菜场个数(单位：个)
     */
    public java.lang.Integer getFoodMarketNum() {
        return foodMarketNum;
    }

    /**
     * <p>菜场个数(单位：个)</p>
     *
     * @param foodMarketNum 菜场个数(单位：个)
     */
    public void setFoodMarketNum(java.lang.Integer foodMarketNum) {
        this.foodMarketNum = foodMarketNum;
    }
    /**
     * <p>餐饮聚集区个数(单位：个)</p>
     *
     * @return 餐饮聚集区个数(单位：个)
     */
    public java.lang.Integer getCookingGatheringNum() {
        return cookingGatheringNum;
    }

    /**
     * <p>餐饮聚集区个数(单位：个)</p>
     *
     * @param cookingGatheringNum 餐饮聚集区个数(单位：个)
     */
    public void setCookingGatheringNum(java.lang.Integer cookingGatheringNum) {
        this.cookingGatheringNum = cookingGatheringNum;
    }
    /**
     * <p>团膳聚集区个数(单位：个)</p>
     *
     * @return 团膳聚集区个数(单位：个)
     */
    public java.lang.Integer getMealsGatheringNum() {
        return mealsGatheringNum;
    }

    /**
     * <p>团膳聚集区个数(单位：个)</p>
     *
     * @param mealsGatheringNum 团膳聚集区个数(单位：个)
     */
    public void setMealsGatheringNum(java.lang.Integer mealsGatheringNum) {
        this.mealsGatheringNum = mealsGatheringNum;
    }
    /**
     * <p>加工厂个数</p>
     *
     * @return 加工厂个数
     */
    public java.lang.Integer getProcessNum() {
        return processNum;
    }

    /**
     * <p>加工厂个数</p>
     *
     * @param processNum 加工厂个数
     */
    public void setProcessNum(java.lang.Integer processNum) {
        this.processNum = processNum;
    }
    /**
     * <p>规划图附件</p>
     *
     * @return 规划图附件
     */
    public java.lang.String getPlanPic() {
        return planPic;
    }

    /**
     * <p>规划图附件</p>
     *
     * @param planPic 规划图附件
     */
    public void setPlanPic(java.lang.String planPic) {
        this.planPic = planPic;
    }
    /**
     * <p>备注</p>
     *
     * @return 备注
     */
    public java.lang.String getRemarks() {
        return remarks;
    }

    /**
     * <p>备注</p>
     *
     * @param remarks 备注
     */
    public void setRemarks(java.lang.String remarks) {
        this.remarks = remarks;
    }


}
