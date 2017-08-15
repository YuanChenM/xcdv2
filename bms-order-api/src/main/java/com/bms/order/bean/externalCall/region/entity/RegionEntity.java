package com.bms.order.bean.externalCall.region.entity;

import java.io.Serializable;

/**
 * 区域实体
 * Created by zhang_qiang1 on 2017/1/6.
 */
public class RegionEntity  implements Serializable{

    /**
     * 区域：区县ID
     */
    private Long countryId;

    /**
     * 获取区域：区县ID
     *
     * @return 区域：区县ID
     */
    public Long getCountryId() {
        return this.countryId;
    }

    /**
     * 设置区域：区县ID
     *
     * @param countryId
     */
    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    /**
     * 区域：城市ID
     */
    private Long cityId;

    /**
     * 获取区域：城市ID
     *
     * @return 区域：城市ID
     */
    public Long getCityId() {
        return this.cityId;
    }

    /**
     * 设置区域：城市ID
     *
     * @param cityId
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * 区域：物流区名称 [【类型待定】]
     */
    private String logisticsZoneName;

    /**
     * 获取区域：物流区名称 [【类型待定】]
     *
     * @return 区域：物流区名称 [【类型待定】]
     */
    public String getLogisticsZoneName() {
        return this.logisticsZoneName;
    }

    /**
     * 设置区域：物流区名称 [【类型待定】]
     *
     * @param logisticsZoneName
     */
    public void setLogisticsZoneName(String logisticsZoneName) {
        this.logisticsZoneName = logisticsZoneName;
    }


    /**
     * 区域：物流区编码 [【类型待定】]
     */
    private String logisticsZoneCode;

    /**
     * 获取区域：物流区编码 [【类型待定】]
     *
     * @return 区域：物流区编码 [【类型待定】]
     */
    public String getLogisticsZoneCode() {
        return this.logisticsZoneCode;
    }

    /**
     * 设置区域：物流区编码 [【类型待定】]
     *
     * @param logisticsZoneCode
     */
    public void setLogisticsZoneCode(String logisticsZoneCode) {
        this.logisticsZoneCode = logisticsZoneCode;
    }

    /**
     * 区域：区县名称 [【类型待定】]
     */
    private String countryName;

    /**
     * 获取区域：区县名称 [【类型待定】]
     *
     * @return 区域：区县名称 [【类型待定】]
     */
    public String getCountryName() {
        return this.countryName;
    }

    /**
     * 设置区域：区县名称 [【类型待定】]
     *
     * @param countryName
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    /**
     * 区域：城市名称 [【类型待定】]
     */
    private String cityName;

    /**
     * 获取区域：城市名称 [【类型待定】]
     *
     * @return 区域：城市名称 [【类型待定】]
     */
    public String getCityName() {
        return this.cityName;
    }

    /**
     * 设置区域：城市名称 [【类型待定】]
     *
     * @param cityName
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * 区域：区域配送站ID
     */
    private Long regionalDistributionStation;

    /**
     * 获取区域：区域配送站ID
     *
     * @return 区域：区域配送站ID
     */
    public Long getRegionalDistributionStation() {
        return this.regionalDistributionStation;
    }

    /**
     * 设置区域：区域配送站ID
     *
     * @param regionalDistributionStation
     */
    public void setRegionalDistributionStation(Long regionalDistributionStation) {
        this.regionalDistributionStation = regionalDistributionStation;
    }

    /**
     * 区域：区域配送站编码
     */
    private String regionalDistributionStationCode;

    /**
     * 获取区域：区域配送站编码
     *
     * @return 区域：区域配送站编码
     */
    public String getRegionalDistributionStationCode() {
        return this.regionalDistributionStationCode;
    }

    /**
     * 设置区域：区域配送站编码
     *
     * @param regionalDistributionStationCode
     */
    public void setRegionalDistributionStationCode(String regionalDistributionStationCode) {
        this.regionalDistributionStationCode = regionalDistributionStationCode;
    }

    /**
     * 区域：区域配送站名称
     */
    private String regionalDistributionStationName;

    /**
     * 获取区域：区域配送站名称
     *
     * @return 区域：区域配送站名称
     */
    public String getRegionalDistributionStationName() {
        return this.regionalDistributionStationName;
    }

    /**
     * 设置区域：区域配送站名称
     *
     * @param regionalDistributionStationName
     */
    public void setRegionalDistributionStationName(String regionalDistributionStationName) {
        this.regionalDistributionStationName = regionalDistributionStationName;
    }


    @Override
    public String toString() {
        return "RegionEntity{" +
                "countryId=" + countryId +
                ", cityId=" + cityId +
                ", logisticsZoneName='" + logisticsZoneName + '\'' +
                ", logisticsZoneCode='" + logisticsZoneCode + '\'' +
                ", countryName='" + countryName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", regionalDistributionStation=" + regionalDistributionStation +
                ", regionalDistributionStationCode='" + regionalDistributionStationCode + '\'' +
                ", regionalDistributionStationName='" + regionalDistributionStationName + '\'' +
                '}';
    }
}
