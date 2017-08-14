/*
 * 2016/12/14 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.bymt.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表BYMT_FOOD_MARKET_BASIC对应的实体BymtFoodMarketBasic</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class BymtFoodMarketBasic extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 菜场主键UUID */
    private String foodMarketId;
    /** 菜场编码(分类2+物流区2+地区3+区县2+菜场区县顺序码3) */
    private String foodMarketCode;
    /** 菜场名称 */
    private String foodMarketName;
    /** 菜场地址 */
    private String foodMarketAddress;
    /** 菜场类型 */
    private String foodMarketLevel;
    /** 地段类型 */
    private String scopeType;
    /** 物流区编码 */
    private String lgcsAreaCode;
    /** 物流区名称 */
    private String lgcsAreaName;
    /** 物流区ID */
    private Long lgcsAreaId;
    /** 地区ID */
    private Long zoneId;
    /** 地区编码 */
    private String zoneCode;
    /** 地区名称 */
    private String zoneName;
    /** 区县ID */
    private Long districtId;
    /** 区县名称 */
    private String districtName;
    /** 区县编码 */
    private String districtCode;
    /** 占地面积(单位:亩) */
    private Integer coverArea;

    /**
     * <p>默认构造函数</p>
     */
    public BymtFoodMarketBasic() {
    }

    /**
     * <p>菜场主键UUID</p>
     *
     * @return 菜场主键UUID
     */
    public String getFoodMarketId() {
        return foodMarketId;
    }

    /**
     * <p>菜场主键UUID</p>
     *
     * @param foodMarketId 菜场主键UUID
     */
    public void setFoodMarketId(String foodMarketId) {
        this.foodMarketId = foodMarketId;
    }
    /**
     * <p>菜场编码(分类2+物流区2+地区3+区县2+菜场区县顺序码3)</p>
     *
     * @return 菜场编码(分类2+物流区2+地区3+区县2+菜场区县顺序码3)
     */
    public String getFoodMarketCode() {
        return foodMarketCode;
    }

    /**
     * <p>菜场编码(分类2+物流区2+地区3+区县2+菜场区县顺序码3)</p>
     *
     * @param foodMarketCode 菜场编码(分类2+物流区2+地区3+区县2+菜场区县顺序码3)
     */
    public void setFoodMarketCode(String foodMarketCode) {
        this.foodMarketCode = foodMarketCode;
    }
    /**
     * <p>菜场名称</p>
     *
     * @return 菜场名称
     */
    public String getFoodMarketName() {
        return foodMarketName;
    }

    /**
     * <p>菜场名称</p>
     *
     * @param foodMarketName 菜场名称
     */
    public void setFoodMarketName(String foodMarketName) {
        this.foodMarketName = foodMarketName;
    }
    /**
     * <p>菜场地址</p>
     *
     * @return 菜场地址
     */
    public String getFoodMarketAddress() {
        return foodMarketAddress;
    }

    /**
     * <p>菜场地址</p>
     *
     * @param foodMarketAddress 菜场地址
     */
    public void setFoodMarketAddress(String foodMarketAddress) {
        this.foodMarketAddress = foodMarketAddress;
    }
    /**
     * <p>菜场类型</p>
     *
     * @return 菜场类型
     */
    public String getFoodMarketLevel() {
        return foodMarketLevel;
    }

    /**
     * <p>菜场类型</p>
     *
     * @param foodMarketLevel 菜场类型
     */
    public void setFoodMarketLevel(String foodMarketLevel) {
        this.foodMarketLevel = foodMarketLevel;
    }
    /**
     * <p>地段类型</p>
     *
     * @return 地段类型
     */
    public String getScopeType() {
        return scopeType;
    }

    /**
     * <p>地段类型</p>
     *
     * @param scopeType 地段类型
     */
    public void setScopeType(String scopeType) {
        this.scopeType = scopeType;
    }
    /**
     * <p>物流区编码</p>
     *
     * @return 物流区编码
     */
    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    /**
     * <p>物流区编码</p>
     *
     * @param lgcsAreaCode 物流区编码
     */
    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }
    /**
     * <p>物流区名称</p>
     *
     * @return 物流区名称
     */
    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    /**
     * <p>物流区名称</p>
     *
     * @param lgcsAreaName 物流区名称
     */
    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }

    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
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

    /**
     * <p>区县名称</p>
     *
     * @return 区县名称
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * <p>区县名称</p>
     *
     * @param districtName 区县名称
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
    /**
     * <p>区县编码</p>
     *
     * @return 区县编码
     */
    public String getDistrictCode() {
        return districtCode;
    }

    /**
     * <p>区县编码</p>
     *
     * @param districtCode 区县编码
     */
    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }
    /**
     * <p>占地面积(单位:亩)</p>
     *
     * @return 占地面积(单位:亩)
     */
    public Integer getCoverArea() {
        return coverArea;
    }

    /**
     * <p>占地面积(单位:亩)</p>
     *
     * @param coverArea 占地面积(单位:亩)
     */
    public void setCoverArea(Integer coverArea) {
        this.coverArea = coverArea;
    }

}
