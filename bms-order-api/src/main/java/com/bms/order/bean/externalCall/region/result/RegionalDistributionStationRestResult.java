package com.bms.order.bean.externalCall.region.result;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhang_qiang1 on 2017/1/12.
 */
public class RegionalDistributionStationRestResult implements Serializable {

    List<DistributionStation> distributionStationList;

    public List<DistributionStation> getDistributionStationList() {
        return distributionStationList;
    }

    public void setDistributionStationList(List<DistributionStation> distributionStationList) {
        this.distributionStationList = distributionStationList;
    }


    @Override
    public String toString() {
        return "RegionalDistributionStationRestResult{" +
                "distributionStationList=" + distributionStationList +
                '}';
    }

    public static class DistributionStation implements Serializable {
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
            return "DistributionStation{" +
                    "regionalDistributionStation=" + regionalDistributionStation +
                    ", regionalDistributionStationCode='" + regionalDistributionStationCode + '\'' +
                    ", regionalDistributionStationName='" + regionalDistributionStationName + '\'' +
                    '}';
        }
    }
}
