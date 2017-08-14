/*
 * 2017/02/16 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.region.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表REGN_LOGISTICS_DEMESNE对应的实体RegnLogisticsDemesne</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class RegnLogisticsDemesne extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 领地ID */
    private Long demesneId;
    /** 配送站主键 */
    private Long distributionId;
    /** 领地分类 */
    private String demesneType;
    /** 领地表示码 */
    private String demesneName;
    /** 领地编码(地区码+领地地区顺序码 001开始) */
    private String demesneCode;
    /** 领地面积（单位：km²） */
    private String demesneArea;
    /** 所辖区县 */
    private String managementDistrict;
    /** 领地边界东向 */
    private String demesneEast;
    /** 领地边界南向 */
    private String demesneSouth;
    /** 领地边界西向 */
    private String demesneWest;
    /** 领地边界北向 */
    private String demesneNorth;
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
    private String authorizedAgent;
    /** 备注 */
    private String remarks;
    /** 数据有效性标识(默认为有效) */
    private String disableFlg;
    /** 规划图地址编码 */
    private String planPic;

    /**
     * <p>默认构造函数</p>
     */
    public RegnLogisticsDemesne() {
    }

    /**
     * <p>领地ID</p>
     *
     * @return 领地ID
     */
    public Long getDemesneId() {
        return demesneId;
    }

    /**
     * <p>领地ID</p>
     *
     * @param demesneId 领地ID
     */
    public void setDemesneId(Long demesneId) {
        this.demesneId = demesneId;
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
     * <p>领地分类</p>
     *
     * @return 领地分类
     */
    public String getDemesneType() {
        return demesneType;
    }

    /**
     * <p>领地分类</p>
     *
     * @param demesneType 领地分类
     */
    public void setDemesneType(String demesneType) {
        this.demesneType = demesneType;
    }
    /**
     * <p>领地表示码</p>
     *
     * @return 领地表示码
     */
    public String getDemesneName() {
        return demesneName;
    }

    /**
     * <p>领地表示码</p>
     *
     * @param demesneName 领地表示码
     */
    public void setDemesneName(String demesneName) {
        this.demesneName = demesneName;
    }
    /**
     * <p>领地编码(地区码+领地地区顺序码 001开始)</p>
     *
     * @return 领地编码(地区码+领地地区顺序码 001开始)
     */
    public String getDemesneCode() {
        return demesneCode;
    }

    /**
     * <p>领地编码(地区码+领地地区顺序码 001开始)</p>
     *
     * @param demesneCode 领地编码(地区码+领地地区顺序码 001开始)
     */
    public void setDemesneCode(String demesneCode) {
        this.demesneCode = demesneCode;
    }
    /**
     * <p>领地面积（单位：km²）</p>
     *
     * @return 领地面积（单位：km²）
     */
    public String getDemesneArea() {
        return demesneArea;
    }

    /**
     * <p>领地面积（单位：km²）</p>
     *
     * @param demesneArea 领地面积（单位：km²）
     */
    public void setDemesneArea(String demesneArea) {
        this.demesneArea = demesneArea;
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
     * <p>领地边界东向</p>
     *
     * @return 领地边界东向
     */
    public String getDemesneEast() {
        return demesneEast;
    }

    /**
     * <p>领地边界东向</p>
     *
     * @param demesneEast 领地边界东向
     */
    public void setDemesneEast(String demesneEast) {
        this.demesneEast = demesneEast;
    }
    /**
     * <p>领地边界南向</p>
     *
     * @return 领地边界南向
     */
    public String getDemesneSouth() {
        return demesneSouth;
    }

    /**
     * <p>领地边界南向</p>
     *
     * @param demesneSouth 领地边界南向
     */
    public void setDemesneSouth(String demesneSouth) {
        this.demesneSouth = demesneSouth;
    }
    /**
     * <p>领地边界西向</p>
     *
     * @return 领地边界西向
     */
    public String getDemesneWest() {
        return demesneWest;
    }

    /**
     * <p>领地边界西向</p>
     *
     * @param demesneWest 领地边界西向
     */
    public void setDemesneWest(String demesneWest) {
        this.demesneWest = demesneWest;
    }
    /**
     * <p>领地边界北向</p>
     *
     * @return 领地边界北向
     */
    public String getDemesneNorth() {
        return demesneNorth;
    }

    /**
     * <p>领地边界北向</p>
     *
     * @param demesneNorth 领地边界北向
     */
    public void setDemesneNorth(String demesneNorth) {
        this.demesneNorth = demesneNorth;
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

    public String getAuthorizedAgent() {
        return authorizedAgent;
    }

    /**
     * <p>领地授权销售合伙人</p>
     *
     * @param authorizedAgent 领地授权销售合伙人
     */


    public void setAuthorizedAgent(String authorizedAgent) {
        this.authorizedAgent = authorizedAgent;
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

}
