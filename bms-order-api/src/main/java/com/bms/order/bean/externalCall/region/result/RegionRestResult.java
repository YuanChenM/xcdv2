package com.bms.order.bean.externalCall.region.result;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhang_qiang1 on 2017/1/4.
 */
public class RegionRestResult implements Serializable {

    private List<RegionLogisticsZoneRestResult> regionLogisticsZoneRestResultList;


    public List<RegionLogisticsZoneRestResult> getRegionLogisticsZoneRestResultList() {
        return regionLogisticsZoneRestResultList;
    }

    public void setRegionLogisticsZoneRestResultList(List<RegionLogisticsZoneRestResult> regionLogisticsZoneRestResultList) {
        this.regionLogisticsZoneRestResultList = regionLogisticsZoneRestResultList;
    }

    @Override
    public String toString() {
        return "RegionRestResult{" +
                "regionLogisticsZoneRestResultList=" + regionLogisticsZoneRestResultList +
                '}';
    }
}
