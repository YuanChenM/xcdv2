package com.bms.order.bean.externalCall.region.result;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhang_qiang1 on 2017/1/4.
 */
public class RegionCityRestResult implements Serializable {


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


    private List<RegionCountryRestResult> regionCountryRestResultList;

    public List<RegionCountryRestResult> getRegionCountryRestResultList() {
        return regionCountryRestResultList;
    }

    public void setRegionCountryRestResultList(List<RegionCountryRestResult> regionCountryRestResultList) {
        this.regionCountryRestResultList = regionCountryRestResultList;
    }

    @Override
    public String toString() {
        return "RegionCityRestResult{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", regionCountryRestResultList=" + regionCountryRestResultList +
                '}';
    }
}
