package com.bms.order.bean.externalCall.products.entity;

import java.io.Serializable;

/**
 * Created by zhang_qiang1 on 2017/1/7.
 */
public class SingleManufacturerEntity implements Serializable {

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
        return "SingleManufacturerEntity{" +
                "manufacturerId=" + manufacturerId +
                ", manufacturerCode='" + manufacturerCode + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                '}';
    }
}
