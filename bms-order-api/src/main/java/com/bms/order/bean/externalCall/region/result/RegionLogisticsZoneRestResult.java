package com.bms.order.bean.externalCall.region.result;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhang_qiang1 on 2017/1/4.
 */
public class RegionLogisticsZoneRestResult implements Serializable {


    /**
     * 区域：物流区ID
     */
    private Long logisticsZoneId;

    /**
     * 获取区域：物流区ID
     *
     * @return 区域：物流区ID
     */
    public Long getLogisticsZoneId() {
        return this.logisticsZoneId;
    }

    /**
     * 设置区域：物流区ID
     *
     * @param logisticsZoneId
     */
    public void setLogisticsZoneId(Long logisticsZoneId) {
        this.logisticsZoneId = logisticsZoneId;
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


    private List<RegionCityRestResult> regionCityRestResultList;

    public List<RegionCityRestResult> getRegionCityRestResultList() {
        return regionCityRestResultList;
    }

    public void setRegionCityRestResultList(List<RegionCityRestResult> regionCityRestResultList) {
        this.regionCityRestResultList = regionCityRestResultList;
    }

    @Override
    public String toString() {
        return "RegionLogisticsZoneRestResult{" +
                "logisticsZoneId=" + logisticsZoneId +
                ", logisticsZoneName='" + logisticsZoneName + '\'' +
                ", logisticsZoneCode='" + logisticsZoneCode + '\'' +
                ", regionCityRestResultList=" + regionCityRestResultList +
                '}';
    }
}
