/*
 * 2017/04/26 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.order.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表ordr_shortsell_detail对应的实体OrdrShortsellDetail</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class OrdrShortsellDetail extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 明细ID */
    private Long detailId;
    /** 沽货订单ID */
    private Long orderId;
    /** CodeMaster,001-SKU，002-商品，需要根据传递编码的长度等条件判定是什么编码 */
    private String materialDataType;
    /** 物料编码，冻期所传递过来 */
    private String materialCode;
    /** 物料名称，冻期所传递过来 */
    private String materialName;
    /** 商品ID，根据物料编码取得 */
    private Long commodityId;
    /** 商品编码，根据物料编码取得 */
    private String commodityCode;
    /** 商品名称，根据物料编码取得 */
    private String commodityName;
    /** 销售单位 */
    private String uom;
    /** 交易数量 */
    private java.math.BigDecimal tradeQty;
    /** 交易价格 */
    private java.math.BigDecimal tradePrice;

    /**
     * <p>默认构造函数</p>
     */
    public OrdrShortsellDetail() {
    }

    /**
     * <p>明细ID</p>
     *
     * @return 明细ID
     */
    public Long getDetailId() {
        return detailId;
    }

    /**
     * <p>明细ID</p>
     *
     * @param detailId 明细ID
     */
    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }
    /**
     * <p>沽货订单ID</p>
     *
     * @return 沽货订单ID
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * <p>沽货订单ID</p>
     *
     * @param orderId 沽货订单ID
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    /**
     * <p>CodeMaster,001-SKU，002-商品，需要根据传递编码的长度等条件判定是什么编码</p>
     *
     * @return CodeMaster,001-SKU，002-商品，需要根据传递编码的长度等条件判定是什么编码
     */
    public String getMaterialDataType() {
        return materialDataType;
    }

    /**
     * <p>CodeMaster,001-SKU，002-商品，需要根据传递编码的长度等条件判定是什么编码</p>
     *
     * @param materialDataType CodeMaster,001-SKU，002-商品，需要根据传递编码的长度等条件判定是什么编码
     */
    public void setMaterialDataType(String materialDataType) {
        this.materialDataType = materialDataType;
    }
    /**
     * <p>物料编码，冻期所传递过来</p>
     *
     * @return 物料编码，冻期所传递过来
     */
    public String getMaterialCode() {
        return materialCode;
    }

    /**
     * <p>物料编码，冻期所传递过来</p>
     *
     * @param materialCode 物料编码，冻期所传递过来
     */
    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }
    /**
     * <p>物料名称，冻期所传递过来</p>
     *
     * @return 物料名称，冻期所传递过来
     */
    public String getMaterialName() {
        return materialName;
    }

    /**
     * <p>物料名称，冻期所传递过来</p>
     *
     * @param materialName 物料名称，冻期所传递过来
     */
    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }
    /**
     * <p>商品ID，根据物料编码取得</p>
     *
     * @return 商品ID，根据物料编码取得
     */
    public Long getCommodityId() {
        return commodityId;
    }

    /**
     * <p>商品ID，根据物料编码取得</p>
     *
     * @param commodityId 商品ID，根据物料编码取得
     */
    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }
    /**
     * <p>商品编码，根据物料编码取得</p>
     *
     * @return 商品编码，根据物料编码取得
     */
    public String getCommodityCode() {
        return commodityCode;
    }

    /**
     * <p>商品编码，根据物料编码取得</p>
     *
     * @param commodityCode 商品编码，根据物料编码取得
     */
    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }
    /**
     * <p>商品名称，根据物料编码取得</p>
     *
     * @return 商品名称，根据物料编码取得
     */
    public String getCommodityName() {
        return commodityName;
    }

    /**
     * <p>商品名称，根据物料编码取得</p>
     *
     * @param commodityName 商品名称，根据物料编码取得
     */
    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }
    /**
     * <p>销售单位</p>
     *
     * @return 销售单位
     */
    public String getUom() {
        return uom;
    }

    /**
     * <p>销售单位</p>
     *
     * @param uom 销售单位
     */
    public void setUom(String uom) {
        this.uom = uom;
    }
    /**
     * <p>交易数量</p>
     *
     * @return 交易数量
     */
    public java.math.BigDecimal getTradeQty() {
        return tradeQty;
    }

    /**
     * <p>交易数量</p>
     *
     * @param tradeQty 交易数量
     */
    public void setTradeQty(java.math.BigDecimal tradeQty) {
        this.tradeQty = tradeQty;
    }
    /**
     * <p>交易价格</p>
     *
     * @return 交易价格
     */
    public java.math.BigDecimal getTradePrice() {
        return tradePrice;
    }

    /**
     * <p>交易价格</p>
     *
     * @param tradePrice 交易价格
     */
    public void setTradePrice(java.math.BigDecimal tradePrice) {
        this.tradePrice = tradePrice;
    }

}
