package com.bms.order.archive.impl.externalCall.region;

import java.util.List;

import com.bms.order.archive.impl.BsOrder;
import com.bms.order.archive.impl.BuyerOrder;
import com.bms.order.bean.entity.BsOrderAttachedEntity;
import com.bms.order.bean.entity.BuyerOrderAttachedEntity;
import com.bms.order.bean.externalCall.region.entity.RegionEntity;
import com.bms.order.bean.externalCall.region.result.RegionCityRestResult;
import com.bms.order.bean.externalCall.region.result.RegionCountryRestResult;
import com.bms.order.bean.externalCall.region.result.RegionLogisticsZoneRestResult;
import com.bms.order.bean.externalCall.region.result.RegionRestResult;
import com.bms.order.bean.externalCall.region.result.RegionalDistributionStationRestResult;
import com.bms.order.util.BeanUtils;
import com.bms.order.util.ExternalCallUtil;

/**
 * Created by zhang_qiang1 on 2017/1/6.
 */
public class Region {

    /**
     * 查询配送站 页面使用
     *
     * @return
     */
    public RegionalDistributionStationRestResult findDistributionStations() {
        return (RegionalDistributionStationRestResult) ExternalCallUtil
                .setEntityParam(RegionalDistributionStationRestResult.class, 25);
    }

    // 三级联动

    /**
     *
     * @return
     */
    public RegionRestResult findAllRegions() {
        return (RegionRestResult) ExternalCallUtil.setEntityParam(RegionRestResult.class, 3);
    }

    // @Test
    public void test() {
        RegionRestResult restResult = this.findAllRegions();
        List<RegionLogisticsZoneRestResult> regionLogisticsZoneRestResultList = restResult
                .getRegionLogisticsZoneRestResultList();
        for (RegionLogisticsZoneRestResult restResult1 : regionLogisticsZoneRestResultList) {
            System.out.println(restResult1);
        }

        List<RegionCityRestResult> regionCityRestResultList = restResult.getRegionLogisticsZoneRestResultList().get(0)
                .getRegionCityRestResultList();
        for (RegionCityRestResult cityRestResult : regionCityRestResultList) {
            System.out.println(cityRestResult);
        }
        List<RegionCountryRestResult> regionCountryRestResultList = restResult.getRegionLogisticsZoneRestResultList()
                .get(0).getRegionCityRestResultList().get(0).getRegionCountryRestResultList();
        for (RegionCountryRestResult countryRestResult : regionCountryRestResultList) {
            System.out.println(countryRestResult);
        }

    }

    /**
     * 根据买手表中的数据 获取对应的区域信息
     *
     * @param bsOrder
     * @return
     */
    public RegionEntity getRegionByBsOrder(BsOrder bsOrder) {
        BsOrderAttachedEntity bsOrderAttachedEntity = bsOrder.getAttachedEntity();
        RegionEntity regionEntity = new RegionEntity();
        BeanUtils.copyProperties(bsOrderAttachedEntity, regionEntity);
        regionEntity.setLogisticsZoneCode("07");
        regionEntity.setLogisticsZoneName("华东");
        regionEntity.setCityName("上海");
        regionEntity.setCountryName("闵行区");
        regionEntity.setRegionalDistributionStationCode("01");
        regionEntity.setRegionalDistributionStationName("xjd_配送站");
        return regionEntity;
    }

    /**
     * 根据买家表中的数据 获取对应的区域信息
     *
     * @param buyerOrder
     * @return
     */
    @Deprecated
    public RegionEntity getRegionByBuyerOrder(BuyerOrder buyerOrder) {
        BuyerOrderAttachedEntity buyerOrderAttachedEntity = buyerOrder.getAttachedEntity();
        RegionEntity regionEntity = new RegionEntity();
        BeanUtils.copyProperties(buyerOrderAttachedEntity, regionEntity);
        regionEntity.setLogisticsZoneCode("07");
        regionEntity.setLogisticsZoneName("华东");
        regionEntity.setCityName("上海");
        regionEntity.setCountryName("闵行区");
        return regionEntity;
    }

}
