package com.bms.order.bean.externalCall.buyers.result;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhang_qiang1 on 2017/1/11.
 */
public class QueryApproveManufactureRestResult implements Serializable {

    private List<Bs> bsList;

    public List<Bs> getBsList() {
        return bsList;
    }

    public void setBsList(List<Bs> bsList) {
        this.bsList = bsList;
    }

    private List<Manufacture> manufactureList;


    public List<Manufacture> getManufactureList() {
        return manufactureList;
    }

    public void setManufactureList(List<Manufacture> manufactureList) {
        this.manufactureList = manufactureList;
    }

    @Override
    public String toString() {
        return "QueryApproveManufactureRestResult{" +
                "manufactureList=" + manufactureList +
                '}';
    }

    public static class Manufacture implements Serializable {
        private String buyersId;


        public String getBuyersId() {
            return buyersId;
        }

        public void setBuyersId(String buyersId) {
            this.buyersId = buyersId;
        }

        /**
         * 商品：生产商ID
         */
        private Long manufacturerId;

        /**
         * 获取商品：生产商ID
         *
         * @return 商品：生产商ID
         */
        public Long getManufacturerId() {
            return this.manufacturerId;
        }

        /**
         * 设置商品：生产商ID
         *
         * @param manufacturerId
         */
        public void setManufacturerId(Long manufacturerId) {
            this.manufacturerId = manufacturerId;
        }


        /**
         * 商品：生产商编码
         */
        private String manufacturerCode;

        /**
         * 获取商品：生产商编码
         *
         * @return 商品：生产商编码
         */
        public String getManufacturerCode() {
            return this.manufacturerCode;
        }

        /**
         * 设置商品：生产商编码
         *
         * @param manufacturerCode
         */
        public void setManufacturerCode(String manufacturerCode) {
            this.manufacturerCode = manufacturerCode;
        }

        /**
         * 商品：生产商名称
         */
        private String manufacturerName;

        /**
         * 获取商品：生产商名称
         *
         * @return 商品：生产商名称
         */
        public String getManufacturerName() {
            return this.manufacturerName;
        }

        /**
         * 设置商品：生产商名称
         *
         * @param manufacturerName
         */
        public void setManufacturerName(String manufacturerName) {
            this.manufacturerName = manufacturerName;
        }

        @Override
        public String toString() {
            return "Manufacture{" +
                    "buyersId='" + buyersId + '\'' +
                    ", manufacturerId=" + manufacturerId +
                    ", manufacturerCode='" + manufacturerCode + '\'' +
                    ", manufacturerName='" + manufacturerName + '\'' +
                    '}';
        }
    }


    public static class Bs implements Serializable {

        private String buyersId;

        private String bsId;


        public String getBsId() {
            return bsId;
        }

        public void setBsId(String bsId) {
            this.bsId = bsId;
        }


        private String bsCode;


        public String getBsCode() {
            return bsCode;
        }

        public void setBsCode(String bsCode) {
            this.bsCode = bsCode;
        }

        public String getBuyersId() {
            return buyersId;
        }

        public void setBuyersId(String buyersId) {
            this.buyersId = buyersId;
        }

        @Override
        public String toString() {
            return "Bs{" +
                    "bsId='" + bsId + '\'' +
                    ", bsCode='" + bsCode + '\'' +
                    '}';
        }
    }
}
