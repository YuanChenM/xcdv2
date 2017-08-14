/*
 * 2017/02/16 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.region.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表REGN_LOGISTICS_DISTRIBUTION对应的实体RegnLogisticsDistribution</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class RegnLogisticsDistribution extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 配送站主键 */
    private Long distributionId;
    /** 物流区划城市主键 */
    private Long zoneId;
    /** 配送站分类 */
    private String distributionType;
    /** 配送站表示码 */
    private String distributionName;
    /** 配送站编码(地区码+配送站地区顺序码 001开始) */
    private String distributionCode;
    /** 配送站面积（单位：km²） */
    private String distributionArea;
    /** 所辖区县 */
    private String managementDistrict;
    /** 配送站边界东向 */
    private String distributionEast;
    /** 配送站边界南向 */
    private String distributionSouth;
    /** 配送站边界西向 */
    private String distributionWest;
    /** 配送站边界北向 */
    private String distributionNorth;
    /** 批发市场个数 */
    private Integer terminalMarketNum;
    /** 菜场个数(单位：个) */
    private Integer foodMarketNum;
    /** 餐饮聚集区个数(单位：个) */
    private Integer cookingGatheringNum;
    /** 团膳聚集区个数(单位：个) */
    private Integer mealsGatheringNum;
    /** 加工厂个数 */
    private Integer processNum;
    /** 领地授权销售合伙人 */
    private String authorizedPartner;
    /** 备注 */
    private String remarks;
    /** 规划图地址编码 */
    private String planPic;
    /** 数据有效性标识(默认为有效) */
    private String disableFlg;

    /**
     * <p>默认构造函数</p>
     */
    public RegnLogisticsDistribution() {
    }

    /**
     * <p>配送站主键</p>
     *
     * @return 配送站主键
     */
    public Long getDistributionId() {
        return distributionId;
    }

    /**
     * <p>配送站主键</p>
     *
     * @param distributionId 配送站主键
     */
    public void setDistributionId(Long distributionId) {
        this.distributionId = distributionId;
    }
    /**
     * <p>物流区划城市主键</p>
     *
     * @return 物流区划城市主键
     */
    public Long getZoneId() {
        return zoneId;
    }

    /**
     * <p>物流区划城市主键</p>
     *
     * @param zoneId 物流区划城市主键
     */
    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    /**
     * <p>配送站分类</p>
     *
     * @return 配送站分类
     */
    public String getDistributionType() {
        return distributionType;
    }

    /**
     * <p>配送站分类</p>
     *
     * @param distributionType 配送站分类
     */
    public void setDistributionType(String distributionType) {
        this.distributionType = distributionType;
    }
    /**
     * <p>配送站表示码</p>
     *
     * @return 配送站表示码
     */
    public String getDistributionName() {
        return distributionName;
    }

    /**
     * <p>配送站表示码</p>
     *
     * @param distributionName 配送站表示码
     */
    public void setDistributionName(String distributionName) {
        this.distributionName = distributionName;
    }
    /**
     * <p>配送站编码(地区码+配送站地区顺序码 001开始)</p>
     *
     * @return 配送站编码(地区码+配送站地区顺序码 001开始)
     */
    public String getDistributionCode() {
        return distributionCode;
    }

    /**
     * <p>配送站编码(地区码+配送站地区顺序码 001开始)</p>
     *
     * @param distributionCode 配送站编码(地区码+配送站地区顺序码 001开始)
     */
    public void setDistributionCode(String distributionCode) {
        this.distributionCode = distributionCode;
    }
    /**
     * <p>配送站面积（单位：km²）</p>
     *
     * @return 配送站面积（单位：km²）
     */
    public String getDistributionArea() {
        return distributionArea;
    }

    /**
     * <p>配送站面积（单位：km²）</p>
     *
     * @param distributionArea 配送站面积（单位：km²）
     */
    public void setDistributionArea(String distributionArea) {
        this.distributionArea = distributionArea;
    }
    /**
     * <p>所辖区县</p>
     *
     * @return 所辖区县
     */
    public String getManagementDistrict() {
        return managementDistrict;
    }

    /**
     * <p>所辖区县</p>
     *
     * @param managementDistrict 所辖区县
     */
    public void setManagementDistrict(String managementDistrict) {
        this.managementDistrict = managementDistrict;
    }
    /**
     * <p>配送站边界东向</p>
     *
     * @return 配送站边界东向
     */
    public String getDistributionEast() {
        return distributionEast;
    }

    /**
     * <p>配送站边界东向</p>
     *
     * @param distributionEast 配送站边界东向
     */
    public void setDistributionEast(String distributionEast) {
        this.distributionEast = distributionEast;
    }
    /**
     * <p>配送站边界南向</p>
     *
     * @return 配送站边界南向
     */
    public String getDistributionSouth() {
        return distributionSouth;
    }

    /**
     * <p>配送站边界南向</p>
     *
     * @param distributionSouth 配送站边界南向
     */
    public void setDistributionSouth(String distributionSouth) {
        this.distributionSouth = distributionSouth;
    }
    /**
     * <p>配送站边界西向</p>
     *
     * @return 配送站边界西向
     */
    public String getDistributionWest() {
        return distributionWest;
    }

    /**
     * <p>配送站边界西向</p>
     *
     * @param distributionWest 配送站边界西向
     */
    public void setDistributionWest(String distributionWest) {
        this.distributionWest = distributionWest;
    }
    /**
     * <p>配送站边界北向</p>
     *
     * @return 配送站边界北向
     */
    public String getDistributionNorth() {
        return distributionNorth;
    }

    /**
     * <p>配送站边界北向</p>
     *
     * @param distributionNorth 配送站边界北向
     */
    public void setDistributionNorth(String distributionNorth) {
        this.distributionNorth = distributionNorth;
    }
    /**
     * <p>批发市场个数</p>
     *
     * @return 批发市场个数
     */
    public Integer getTerminalMarketNum() {
        return terminalMarketNum;
    }

    /**
     * <p>批发市场个数</p>
     *
     * @param terminalMarketNum 批发市场个数
     */
    public void setTerminalMarketNum(Integer terminalMarketNum) {
        this.terminalMarketNum = terminalMarketNum;
    }
    /**
     * <p>菜场个数(单位：个)</p>
     *
     * @return 菜场个数(单位：个)
     */
    public Integer getFoodMarketNum() {
        return foodMarketNum;
    }

    /**
     * <p>菜场个数(单位：个)</p>
     *
     * @param foodMarketNum 菜场个数(单位：个)
     */
    public void setFoodMarketNum(Integer foodMarketNum) {
        this.foodMarketNum = foodMarketNum;
    }
    /**
     * <p>餐饮聚集区个数(单位：个)</p>
     *
     * @return 餐饮聚集区个数(单位：个)
     */
    public Integer getCookingGatheringNum() {
        return cookingGatheringNum;
    }

    /**
     * <p>餐饮聚集区个数(单位：个)</p>
     *
     * @param cookingGatheringNum 餐饮聚集区个数(单位：个)
     */
    public void setCookingGatheringNum(Integer cookingGatheringNum) {
        this.cookingGatheringNum = cookingGatheringNum;
    }
    /**
     * <p>团膳聚集区个数(单位：个)</p>
     *
     * @return 团膳聚集区个数(单位：个)
     */
    public Integer getMealsGatheringNum() {
        return mealsGatheringNum;
    }

    /**
     * <p>团膳聚集区个数(单位：个)</p>
     *
     * @param mealsGatheringNum 团膳聚集区个数(单位：个)
     */
    public void setMealsGatheringNum(Integer mealsGatheringNum) {
        this.mealsGatheringNum = mealsGatheringNum;
    }
    /**
     * <p>加工厂个数</p>
     *
     * @return 加工厂个数
     */
    public Integer getProcessNum() {
        return processNum;
    }

    /**
     * <p>加工厂个数</p>
     *
     * @param processNum 加工厂个数
     */
    public void setProcessNum(Integer processNum) {
        this.processNum = processNum;
    }
    /**
     * <p>领地授权销售合伙人</p>
     *
     * @return 领地授权销售合伙人
     */
    public String getAuthorizedPartner() {
        return authorizedPartner;
    }

    /**
     * <p>领地授权销售合伙人</p>
     *
     * @param authorizedPartner 领地授权销售合伙人
     */
    public void setAuthorizedPartner(String authorizedPartner) {
        this.authorizedPartner = authorizedPartner;
    }
    /**
     * <p>备注</p>
     *
     * @return 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * <p>备注</p>
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    /**
     * <p>规划图地址编码</p>
     *
     * @return 规划图地址编码
     */
    public String getPlanPic() {
        return planPic;
    }

    /**
     * <p>规划图地址编码</p>
     *
     * @param planPic 规划图地址编码
     */
    public void setPlanPic(String planPic) {
        this.planPic = planPic;
    }
    /**
     * <p>数据有效性标识(默认为有效)</p>
     *
     * @return 数据有效性标识(默认为有效)
     */
    public String getDisableFlg() {
        return disableFlg;
    }

    /**
     * <p>数据有效性标识(默认为有效)</p>
     *
     * @param disableFlg 数据有效性标识(默认为有效)
     */
    public void setDisableFlg(String disableFlg) {
        this.disableFlg = disableFlg;
    }

}
