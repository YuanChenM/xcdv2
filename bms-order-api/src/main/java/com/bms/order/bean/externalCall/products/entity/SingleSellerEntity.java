package com.bms.order.bean.externalCall.products.entity;

import java.io.Serializable;

/**
 * 卖家信息
 * Created by zhang_qiang1 on 2017/1/7.
 */
public class SingleSellerEntity implements Serializable {

    /**
     * 商品：卖家ID
     */
    private Long sellerId;

    /**
     * 获取商品：卖家ID
     *
     * @return 商品：卖家ID
     */
    public Long getSellerId() {
        return this.sellerId;
    }

    /**
     * 设置商品：卖家ID
     *
     * @param sellerId
     */
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
    /**
     * 商品：卖家编码
     */
    private String sellerCode;

    /**
     * 获取商品：卖家编码
     *
     * @return 商品：卖家编码
     */
    public String getSellerCode() {
        return this.sellerCode;
    }

    /**
     * 设置商品：卖家编码
     *
     * @param sellerCode
     */
    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    /**
     * 商品：卖家名称
     */
    private String sellerName;

    /**
     * 获取商品：卖家名称
     *
     * @return 商品：卖家名称
     */
    public String getSellerName() {
        return this.sellerName;
    }

    /**
     * 设置商品：卖家名称
     *
     * @param sellerName
     */
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }


    @Override
    public String toString() {
        return "SingleSellerEntity{" +
                "sellerId=" + sellerId +
                ", sellerCode='" + sellerCode + '\'' +
                ", sellerName='" + sellerName + '\'' +
                '}';
    }
}
