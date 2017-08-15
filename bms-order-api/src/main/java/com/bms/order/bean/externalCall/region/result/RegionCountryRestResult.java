package com.bms.order.bean.externalCall.region.result;

import java.io.Serializable;

/**
 * Created by zhang_qiang1 on 2017/1/4.
 */
public class RegionCountryRestResult implements Serializable {
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

    @Override
    public String toString() {
        return "RegionCountryRestResult{" +
                "countryId=" + countryId +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
