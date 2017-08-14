/*
 * 2016/12/14 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.bymt.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表BYMT_TERMINAL_MARKET_NOTARGET对应的实体BymtTerminalMarketNotarget</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class BymtTerminalMarketNotarget extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 非目标买家主键 */
    private Long notargetId;
    /** 批发市场UUID */
    private String termMarketId;
    /** 非目标买家名称 */
    private String nobuyerName;
    /** 非买家户数 */
    private Integer nobuyerNum;
    /** 年交易额(单位:元) */
    private java.math.BigDecimal tradeAmount;

    /**
     * <p>默认构造函数</p>
     */
    public BymtTerminalMarketNotarget() {
    }

    /**
     * <p>非目标买家主键</p>
     *
     * @return 非目标买家主键
     */
    public Long getNotargetId() {
        return notargetId;
    }

    /**
     * <p>非目标买家主键</p>
     *
     * @param notargetId 非目标买家主键
     */
    public void setNotargetId(Long notargetId) {
        this.notargetId = notargetId;
    }
    /**
     * <p>批发市场UUID</p>
     *
     * @return 批发市场UUID
     */
    public String getTermMarketId() {
        return termMarketId;
    }

    /**
     * <p>批发市场UUID</p>
     *
     * @param termMarketId 批发市场UUID
     */
    public void setTermMarketId(String termMarketId) {
        this.termMarketId = termMarketId;
    }
    /**
     * <p>非目标买家名称</p>
     *
     * @return 非目标买家名称
     */
    public String getNobuyerName() {
        return nobuyerName;
    }

    /**
     * <p>非目标买家名称</p>
     *
     * @param nobuyerName 非目标买家名称
     */
    public void setNobuyerName(String nobuyerName) {
        this.nobuyerName = nobuyerName;
    }
    /**
     * <p>非买家户数</p>
     *
     * @return 非买家户数
     */
    public Integer getNobuyerNum() {
        return nobuyerNum;
    }

    /**
     * <p>非买家户数</p>
     *
     * @param nobuyerNum 非买家户数
     */
    public void setNobuyerNum(Integer nobuyerNum) {
        this.nobuyerNum = nobuyerNum;
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
