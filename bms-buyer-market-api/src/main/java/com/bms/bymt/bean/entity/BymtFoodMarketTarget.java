/*
 * 2016/12/14 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.bymt.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表BYMT_FOOD_MARKET_TARGET对应的实体BymtFoodMarketTarget</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class BymtFoodMarketTarget extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 目标买家主键 */
    private Long targetId;
    /** 菜场主键UUID */
    private String foodMarketId;
    /** 买家类型名称 */
    private String buyerName;
    /** 销售产品类型名称 */
    private String proName;
    /** 买家户数 */
    private Integer buyerNum;
    /** 年交易额(单位:元) */
    private java.math.BigDecimal tradeAmount;
    /**
     * <p>默认构造函数</p>
     */
    public BymtFoodMarketTarget() {
    }

    /**
     * <p>目标买家主键</p>
     *
     * @return 目标买家主键
     */
    public Long getTargetId() {
        return targetId;
    }

    /**
     * <p>目标买家主键</p>
     *
     * @param targetId 目标买家主键
     */
    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }
    /**
     * <p>菜场主键UUID</p>
     *
     * @return 菜场主键UUID
     */
    public String getFoodMarketId() {
        return foodMarketId;
    }

    /**
     * <p>菜场主键UUID</p>
     *
     * @param foodMarketId 菜场主键UUID
     */
    public void setFoodMarketId(String foodMarketId) {
        this.foodMarketId = foodMarketId;
    }
    /**
     * <p>买家类型名称</p>
     *
     * @return 买家类型名称
     */
    public String getBuyerName() {
        return buyerName;
    }

    /**
     * <p>买家类型名称</p>
     *
     * @param buyerName 买家类型名称
     */
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }
    /**
     * <p>销售产品类型名称</p>
     *
     * @return 销售产品类型名称
     */
    public String getProName() {
        return proName;
    }

    /**
     * <p>销售产品类型名称</p>
     *
     * @param proName 销售产品类型名称
     */
    public void setProName(String proName) {
        this.proName = proName;
    }
    /**
     * <p>买家户数</p>
     *
     * @return 买家户数
     */
    public Integer getBuyerNum() {
        return buyerNum;
    }

    /**
     * <p>买家户数</p>
     *
     * @param buyerNum 买家户数
     */
    public void setBuyerNum(Integer buyerNum) {
        this.buyerNum = buyerNum;
    }
    /**
     * <p>年交易额(单位:元)</p>
     *
     * @return 年交易额(单位:元)
     */
    public java.math.BigDecimal getTradeAmount() {
        return tradeAmount;
    }

    /**
     * <p>年交易额(单位:元)</p>
     *
     * @param tradeAmount 年交易额(单位:元)
     */
    public void setTradeAmount(java.math.BigDecimal tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

}
