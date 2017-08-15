package com.bms.order.bean.externalCall.products.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 商品信息
 * Created by zhang_qiang1 on 2017/1/7.
 */
public class SingleProductEntity implements Serializable {
    /**
     * 商品：商品ID [任意一级可销售层级+销售标签]
     */
    private String goodsId;

    /**
     * 获取商品：商品ID [任意一级可销售层级+销售标签]
     *
     * @return 商品：商品ID [任意一级可销售层级+销售标签]
     */
    public String getGoodsId() {
        return this.goodsId;
    }

    /**
     * 设置商品：商品ID [任意一级可销售层级+销售标签]
     *
     * @param goodsId
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    List<SingleManufacturerEntity> singleManufacturerEntityList;

    List<SingleSellerEntity> singleSellerEntityList;

    public List<SingleManufacturerEntity> getSingleManufacturerEntityList() {
        return singleManufacturerEntityList;
    }

    public void setSingleManufacturerEntityList(List<SingleManufacturerEntity> singleManufacturerEntityList) {
        this.singleManufacturerEntityList = singleManufacturerEntityList;
    }

    public List<SingleSellerEntity> getSingleSellerEntityList() {
        return singleSellerEntityList;
    }

    public void setSingleSellerEntityList(List<SingleSellerEntity> singleSellerEntityList) {
        this.singleSellerEntityList = singleSellerEntityList;
    }





    @Override
    public String toString() {
        return "SingleProductEntity{" +
                "goodsId='" + goodsId + '\'' +
                ", singleManufacturerEntityList=" + singleManufacturerEntityList +
                ", singleSellerEntityList=" + singleSellerEntityList +
                '}';
    }
}
