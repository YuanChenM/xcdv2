/*
 * 2017/03/02 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.agif.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表AGIF_AGENT_LEVEL_STANDARD对应的实体AgifAgentLevelStandard</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class AgifAgentLevelStandard extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** LEVEL_ID */
    private Long levelId;
    /** LEVEL_NAME */
    private String levelName;
    /** 物流区主键 */
    private Long lgcsAreaId;
    /** 物流区编码 */
    private String lgcsAreaCode;
    /** 物流区名称 */
    private String lgcsAreaName;
    /** 0：等于，1：大于，2：小于，3：小于等于，4：大于等于 */
    private String frequencyTotalSymbol;
    /** FREQUENCY_TOTAL */
    private Integer frequencyTotal;
    /** 0：等于，1：大于，2：小于，3：小于等于，4：大于等于 */
    private String frequency1Symbol;
    /** FREQUENCY_1 */
    private Integer frequency1;
    /** 0：等于，1：大于，2：小于，3：小于等于，4：大于等于 */
    private String frequency2Symbol;
    /** FREQUENCY_2 */
    private Integer frequency2;
    /** 0：等于，1：大于，2：小于，3：小于等于，4：大于等于 */
    private String frequency3Symbol;
    /** FREQUENCY_3 */
    private Integer frequency3;
    /** 0：等于，1：大于，2：小于，3：小于等于，4：大于等于 */
    private String frequency4Symbol;
    /** FREQUENCY_4 */
    private Integer frequency4;
    /** 0：等于，1：大于，2：小于，3：小于等于，4：大于等于 */
    private String amountTotalSymbol;
    /** AMOUNT_TOTAL */
    private Integer amountTotal;
    /** 0：等于，1：大于，2：小于，3：小于等于，4：大于等于 */
    private String amount1Symbol;
    /** AMOUNT_1 */
    private Integer amount1;
    /** 0：等于，1：大于，2：小于，3：小于等于，4：大于等于 */
    private String amount2Symbol;
    /** AMOUNT_2 */
    private Integer amount2;
    /** 0：等于，1：大于，2：小于，3：小于等于，4：大于等于 */
    private String amount3Symbol;
    /** AMOUNT_3 */
    private Integer amount3;
    /** 0：等于，1：大于，2：小于，3：小于等于，4：大于等于 */
    private String amount4Symbol;
    /** AMOUNT_4 */
    private Integer amount4;

    /**
     * <p>默认构造函数</p>
     */
    public AgifAgentLevelStandard() {
    }

    /**
     * <p>LEVEL_ID</p>
     *
     * @return LEVEL_ID
     */
    public Long getLevelId() {
        return levelId;
    }

    /**
     * <p>LEVEL_ID</p>
     *
     * @param levelId LEVEL_ID
     */
    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }
    /**
     * <p>LEVEL_NAME</p>
     *
     * @return LEVEL_NAME
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * <p>LEVEL_NAME</p>
     *
     * @param levelName LEVEL_NAME
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
    /**
     * <p>物流区主键</p>
     *
     * @return 物流区主键
     */
    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    /**
     * <p>物流区主键</p>
     *
     * @param lgcsAreaId 物流区主键
     */
    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }
    /**
     * <p>物流区编码</p>
     *
     * @return 物流区编码
     */
    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    /**
     * <p>物流区编码</p>
     *
     * @param lgcsAreaCode 物流区编码
     */
    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }
    /**
     * <p>物流区名称</p>
     *
     * @return 物流区名称
     */
    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    /**
     * <p>物流区名称</p>
     *
     * @param lgcsAreaName 物流区名称
     */
    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }
    /**
     * <p>0：等于，1：大于，2：小于，3：小于等于，4：大于等于</p>
     *
     * @return 0：等于，1：大于，2：小于，3：小于等于，4：大于等于
     */
    public String getFrequencyTotalSymbol() {
        return frequencyTotalSymbol;
    }

    /**
     * <p>0：等于，1：大于，2：小于，3：小于等于，4：大于等于</p>
     *
     * @param frequencyTotalSymbol 0：等于，1：大于，2：小于，3：小于等于，4：大于等于
     */
    public void setFrequencyTotalSymbol(String frequencyTotalSymbol) {
        this.frequencyTotalSymbol = frequencyTotalSymbol;
    }
    /**
     * <p>FREQUENCY_TOTAL</p>
     *
     * @return FREQUENCY_TOTAL
     */
    public Integer getFrequencyTotal() {
        return frequencyTotal;
    }

    /**
     * <p>FREQUENCY_TOTAL</p>
     *
     * @param frequencyTotal FREQUENCY_TOTAL
     */
    public void setFrequencyTotal(Integer frequencyTotal) {
        this.frequencyTotal = frequencyTotal;
    }
    /**
     * <p>0：等于，1：大于，2：小于，3：小于等于，4：大于等于</p>
     *
     * @return 0：等于，1：大于，2：小于，3：小于等于，4：大于等于
     */
    public String getFrequency1Symbol() {
        return frequency1Symbol;
    }

    /**
     * <p>0：等于，1：大于，2：小于，3：小于等于，4：大于等于</p>
     *
     * @param frequency1Symbol 0：等于，1：大于，2：小于，3：小于等于，4：大于等于
     */
    public void setFrequency1Symbol(String frequency1Symbol) {
        this.frequency1Symbol = frequency1Symbol;
    }
    /**
     * <p>FREQUENCY_1</p>
     *
     * @return FREQUENCY_1
     */
    public Integer getFrequency1() {
        return frequency1;
    }

    /**
     * <p>FREQUENCY_1</p>
     *
     * @param frequency1 FREQUENCY_1
     */
    public void setFrequency1(Integer frequency1) {
        this.frequency1 = frequency1;
    }
    /**
     * <p>0：等于，1：大于，2：小于，3：小于等于，4：大于等于</p>
     *
     * @return 0：等于，1：大于，2：小于，3：小于等于，4：大于等于
     */
    public String getFrequency2Symbol() {
        return frequency2Symbol;
    }

    /**
     * <p>0：等于，1：大于，2：小于，3：小于等于，4：大于等于</p>
     *
     * @param frequency2Symbol 0：等于，1：大于，2：小于，3：小于等于，4：大于等于
     */
    public void setFrequency2Symbol(String frequency2Symbol) {
        this.frequency2Symbol = frequency2Symbol;
    }
    /**
     * <p>FREQUENCY_2</p>
     *
     * @return FREQUENCY_2
     */
    public Integer getFrequency2() {
        return frequency2;
    }

    /**
     * <p>FREQUENCY_2</p>
     *
     * @param frequency2 FREQUENCY_2
     */
    public void setFrequency2(Integer frequency2) {
        this.frequency2 = frequency2;
    }
    /**
     * <p>0：等于，1：大于，2：小于，3：小于等于，4：大于等于</p>
     *
     * @return 0：等于，1：大于，2：小于，3：小于等于，4：大于等于
     */
    public String getFrequency3Symbol() {
        return frequency3Symbol;
    }

    /**
     * <p>0：等于，1：大于，2：小于，3：小于等于，4：大于等于</p>
     *
     * @param frequency3Symbol 0：等于，1：大于，2：小于，3：小于等于，4：大于等于
     */
    public void setFrequency3Symbol(String frequency3Symbol) {
        this.frequency3Symbol = frequency3Symbol;
    }
    /**
     * <p>FREQUENCY_3</p>
     *
     * @return FREQUENCY_3
     */
    public Integer getFrequency3() {
        return frequency3;
    }

    /**
     * <p>FREQUENCY_3</p>
     *
     * @param frequency3 FREQUENCY_3
     */
    public void setFrequency3(Integer frequency3) {
        this.frequency3 = frequency3;
    }
    /**
     * <p>0：等于，1：大于，2：小于，3：小于等于，4：大于等于</p>
     *
     * @return 0：等于，1：大于，2：小于，3：小于等于，4：大于等于
     */
    public String getFrequency4Symbol() {
        return frequency4Symbol;
    }

    /**
     * <p>0：等于，1：大于，2：小于，3：小于等于，4：大于等于</p>
     *
     * @param frequency4Symbol 0：等于，1：大于，2：小于，3：小于等于，4：大于等于
     */
    public void setFrequency4Symbol(String frequency4Symbol) {
        this.frequency4Symbol = frequency4Symbol;
    }
    /**
     * <p>FREQUENCY_4</p>
     *
     * @return FREQUENCY_4
     */
    public Integer getFrequency4() {
        return frequency4;
    }

    /**
     * <p>FREQUENCY_4</p>
     *
     * @param frequency4 FREQUENCY_4
     */
    public void setFrequency4(Integer frequency4) {
        this.frequency4 = frequency4;
    }
    /**
     * <p>0：等于，1：大于，2：小于，3：小于等于，4：大于等于</p>
     *
     * @return 0：等于，1：大于，2：小于，3：小于等于，4：大于等于
     */
    public String getAmountTotalSymbol() {
        return amountTotalSymbol;
    }

    /**
     * <p>0：等于，1：大于，2：小于，3：小于等于，4：大于等于</p>
     *
     * @param amountTotalSymbol 0：等于，1：大于，2：小于，3：小于等于，4：大于等于
     */
    public void setAmountTotalSymbol(String amountTotalSymbol) {
        this.amountTotalSymbol = amountTotalSymbol;
    }
    /**
     * <p>AMOUNT_TOTAL</p>
     *
     * @return AMOUNT_TOTAL
     */
    public Integer getAmountTotal() {
        return amountTotal;
    }

    /**
     * <p>AMOUNT_TOTAL</p>
     *
     * @param amountTotal AMOUNT_TOTAL
     */
    public void setAmountTotal(Integer amountTotal) {
        this.amountTotal = amountTotal;
    }
    /**
     * <p>0：等于，1：大于，2：小于，3：小于等于，4：大于等于</p>
     *
     * @return 0：等于，1：大于，2：小于，3：小于等于，4：大于等于
     */
    public String getAmount1Symbol() {
        return amount1Symbol;
    }

    /**
     * <p>0：等于，1：大于，2：小于，3：小于等于，4：大于等于</p>
     *
     * @param amount1Symbol 0：等于，1：大于，2：小于，3：小于等于，4：大于等于
     */
    public void setAmount1Symbol(String amount1Symbol) {
        this.amount1Symbol = amount1Symbol;
    }
    /**
     * <p>AMOUNT_1</p>
     *
     * @return AMOUNT_1
     */
    public Integer getAmount1() {
        return amount1;
    }

    /**
     * <p>AMOUNT_1</p>
     *
     * @param amount1 AMOUNT_1
     */
    public void setAmount1(Integer amount1) {
        this.amount1 = amount1;
    }
    /**
     * <p>0：等于，1：大于，2：小于，3：小于等于，4：大于等于</p>
     *
     * @return 0：等于，1：大于，2：小于，3：小于等于，4：大于等于
     */
    public String getAmount2Symbol() {
        return amount2Symbol;
    }

    /**
     * <p>0：等于，1：大于，2：小于，3：小于等于，4：大于等于</p>
     *
     * @param amount2Symbol 0：等于，1：大于，2：小于，3：小于等于，4：大于等于
     */
    public void setAmount2Symbol(String amount2Symbol) {
        this.amount2Symbol = amount2Symbol;
    }
    /**
     * <p>AMOUNT_2</p>
     *
     * @return AMOUNT_2
     */
    public Integer getAmount2() {
        return amount2;
    }

    /**
     * <p>AMOUNT_2</p>
     *
     * @param amount2 AMOUNT_2
     */
    public void setAmount2(Integer amount2) {
        this.amount2 = amount2;
    }
    /**
     * <p>0：等于，1：大于，2：小于，3：小于等于，4：大于等于</p>
     *
     * @return 0：等于，1：大于，2：小于，3：小于等于，4：大于等于
     */
    public String getAmount3Symbol() {
        return amount3Symbol;
    }

    /**
     * <p>0：等于，1：大于，2：小于，3：小于等于，4：大于等于</p>
     *
     * @param amount3Symbol 0：等于，1：大于，2：小于，3：小于等于，4：大于等于
     */
    public void setAmount3Symbol(String amount3Symbol) {
        this.amount3Symbol = amount3Symbol;
    }
    /**
     * <p>AMOUNT_3</p>
     *
     * @return AMOUNT_3
     */
    public Integer getAmount3() {
        return amount3;
    }

    /**
     * <p>AMOUNT_3</p>
     *
     * @param amount3 AMOUNT_3
     */
    public void setAmount3(Integer amount3) {
        this.amount3 = amount3;
    }
    /**
     * <p>0：等于，1：大于，2：小于，3：小于等于，4：大于等于</p>
     *
     * @return 0：等于，1：大于，2：小于，3：小于等于，4：大于等于
     */
    public String getAmount4Symbol() {
        return amount4Symbol;
    }

    /**
     * <p>0：等于，1：大于，2：小于，3：小于等于，4：大于等于</p>
     *
     * @param amount4Symbol 0：等于，1：大于，2：小于，3：小于等于，4：大于等于
     */
    public void setAmount4Symbol(String amount4Symbol) {
        this.amount4Symbol = amount4Symbol;
    }
    /**
     * <p>AMOUNT_4</p>
     *
     * @return AMOUNT_4
     */
    public Integer getAmount4() {
        return amount4;
    }

    /**
     * <p>AMOUNT_4</p>
     *
     * @param amount4 AMOUNT_4
     */
    public void setAmount4(Integer amount4) {
        this.amount4 = amount4;
    }

}
