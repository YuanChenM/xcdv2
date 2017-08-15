package com.bms.order.bean.externalCall.price.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class PriceChannelQueryEntity implements Serializable {

    private String goodsId;

    private List<PriceChannelResult> priceChannelResultList;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public List<PriceChannelResult> getPriceChannelResultList() {
        return priceChannelResultList;
    }

    public void setPriceChannelResultList(List<PriceChannelResult> priceChannelResultList) {
        this.priceChannelResultList = priceChannelResultList;
    }

    @Override
    public String toString() {
        return "PriceChannelQueryEntity{" +
                "priceChannelResultList=" + priceChannelResultList +
                '}';
    }

    public static class PriceChannelResult implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 商品：商品ID
         */
        private String goodsId;

        /**
         * 获取商品：商品ID
         *
         * @return 商品：商品ID
         */
        public String getGoodsId() {
            return this.goodsId;
        }

        /**
         * 设置商品：商品ID
         *
         * @param goodsId
         */
        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        /**
         * 商品：商品数量
         */
        private BigDecimal goodsQuantity;

        /**
         * 获取商品：商品数量
         *
         * @return 商品：商品数量
         */
        public BigDecimal getGoodsQuantity() {
            return this.goodsQuantity;
        }

        /**
         * 设置商品：商品数量
         *
         * @param goodsQuantity
         */
        public void setGoodsQuantity(BigDecimal goodsQuantity) {
            this.goodsQuantity = goodsQuantity;
        }

        /**
         * 价盘：价格通道等级
         */
        private String pricePlateChannelLevel;

        /**
         * 获取价盘：价格通道等级
         *
         * @return 价盘：价格通道等级
         */
        public String getPricePlateChannelLevel() {
            return this.pricePlateChannelLevel;
        }

        /**
         * 设置价盘：价格通道等级
         *
         * @param pricePlateChannelLevel
         */
        public void setPricePlateChannelLevel(String pricePlateChannelLevel) {
            this.pricePlateChannelLevel = pricePlateChannelLevel;
        }

        /**
         * 价盘：通道开始数量
         */
        private BigDecimal priceChannelStartQuantity;

        /**
         * 获取价盘：通道开始数量
         *
         * @return 价盘：通道开始数量
         */
        public BigDecimal getPriceChannelStartQuantity() {
            return this.priceChannelStartQuantity;
        }

        /**
         * 设置价盘：通道开始数量
         *
         * @param priceChannelStartQuantity
         */
        public void setPriceChannelStartQuantity(BigDecimal priceChannelStartQuantity) {
            this.priceChannelStartQuantity = priceChannelStartQuantity;
        }

        /**
         * 价盘：通道结束数量
         */
        private BigDecimal priceChannelEndQuantity;

        /**
         * 获取价盘：通道结束数量
         *
         * @return 价盘：通道结束数量
         */
        public BigDecimal getPriceChannelEndQuantity() {
            return this.priceChannelEndQuantity;
        }

        /**
         * 设置价盘：通道结束数量
         *
         * @param priceChannelEndQuantity
         */
        public void setPriceChannelEndQuantity(BigDecimal priceChannelEndQuantity) {
            this.priceChannelEndQuantity = priceChannelEndQuantity;
        }

        /**
         * 价盘：价格通道单价
         */
        private BigDecimal priceChannelUnitPrice;

        /**
         * 获取价盘：价格通道单价
         *
         * @return 价盘：价格通道单价
         */
        public BigDecimal getPriceChannelUnitPrice() {
            return this.priceChannelUnitPrice;
        }

        /**
         * 设置价盘：价格通道单价
         *
         * @param priceChannelUnitPrice
         */
        public void setPriceChannelUnitPrice(BigDecimal priceChannelUnitPrice) {
            this.priceChannelUnitPrice = priceChannelUnitPrice;
        }

        @Override
        public String toString() {
            return "PriceChannelDetailEntity{" +
                    "goodsId=" + goodsId +
                    ", goodsQuantity=" + goodsQuantity +
                    ", pricePlateChannelLevel='" + pricePlateChannelLevel + '\'' +
                    ", priceChannelStartQuantity=" + priceChannelStartQuantity +
                    ", priceChannelEndQuantity=" + priceChannelEndQuantity +
                    ", priceChannelUnitPrice=" + priceChannelUnitPrice +
                    '}';
        }
    }
}
