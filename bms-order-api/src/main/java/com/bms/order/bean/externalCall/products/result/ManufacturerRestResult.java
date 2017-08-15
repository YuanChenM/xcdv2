package com.bms.order.bean.externalCall.products.result;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhang_qiang1 on 2017/1/11.
 */
public class ManufacturerRestResult implements Serializable {


    private List<Manufacturer> manufacturerList;

    public List<Manufacturer> getManufacturerList() {
        return manufacturerList;
    }

    public void setManufacturerList(List<Manufacturer> manufacturerList) {
        this.manufacturerList = manufacturerList;
    }


    @Override
    public String toString() {
        return "ManufacturerRestResult{" +
                "manufacturerList=" + manufacturerList +
                '}';
    }

    public  static  class  Manufacturer implements  Serializable{
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
            return "Manufacturer{" +
                    "manufacturerId=" + manufacturerId +
                    ", manufacturerCode='" + manufacturerCode + '\'' +
                    ", manufacturerName='" + manufacturerName + '\'' +
                    '}';
        }
    }


}
