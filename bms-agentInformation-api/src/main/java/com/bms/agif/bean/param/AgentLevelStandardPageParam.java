package com.bms.agif.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "AgentLevelStandardPageParam", description = "买手定级标准类")
public class AgentLevelStandardPageParam extends BaseRestPaginationParam {
    @ApiModelProperty(value = "序列号")
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "等级ID")
    private Long levelId;
    @ApiModelProperty(value = "等级名称")
    private String levelName;
    @ApiModelProperty(value = "物流区主键")
    private Long lgcsAreaId;
    @ApiModelProperty(value = "物流区编码")
    private String lgcsAreaCode;
    @ApiModelProperty(value = "物流区名称")
    private String lgcsAreaName;
    @ApiModelProperty(value = "频次常客小计符号")
    private String frequencyTotalSymbol;
    @ApiModelProperty(value = "频次常客小计数量")
    private Integer frequencyTotal;
    @ApiModelProperty(value = "频次一级常客符号")
    private String frequency1Symbol;
    @ApiModelProperty(value = "频次一级常客数量")
    private Integer frequency1;
    @ApiModelProperty(value = "频次二级常客符号")
    private String frequency2Symbol;
    @ApiModelProperty(value = "频次二级常客数量")
    private Integer frequency2;
    @ApiModelProperty(value = "频次三级常客符号")
    private String frequency3Symbol;
    @ApiModelProperty(value = "频次三级常客数量")
    private Integer frequency3;
    @ApiModelProperty(value = "频次四级常客符号")
    private String frequency4Symbol;
    @ApiModelProperty(value = "频次四级常客数量")
    private Integer frequency4;
    @ApiModelProperty(value = "量级常客小计符号")
    private String amountTotalSymbol;
    @ApiModelProperty(value = "量级常客小计数量")
    private Integer amountTotal;
    @ApiModelProperty(value = "量级一级常客符号")
    private String amount1Symbol;
    @ApiModelProperty(value = "量级一级常客数量")
    private Integer amount1;
    @ApiModelProperty(value = "量级二级常客符号")
    private String amount2Symbol;
    @ApiModelProperty(value = "量级二级常客数量")
    private Integer amount2;
    @ApiModelProperty(value = "量级三级常客符号")
    private String amount3Symbol;
    @ApiModelProperty(value = "量级三级常客数量")
    private Integer amount3;
    @ApiModelProperty(value = "量级四级常客符号")
    private String amount4Symbol;
    @ApiModelProperty(value = "量级四级常客数量")
    private Integer amount4;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }

    public String getFrequencyTotalSymbol() {
        return frequencyTotalSymbol;
    }

    public void setFrequencyTotalSymbol(String frequencyTotalSymbol) {
        this.frequencyTotalSymbol = frequencyTotalSymbol;
    }

    public Integer getFrequencyTotal() {
        return frequencyTotal;
    }

    public void setFrequencyTotal(Integer frequencyTotal) {
        this.frequencyTotal = frequencyTotal;
    }

    public String getFrequency1Symbol() {
        return frequency1Symbol;
    }

    public void setFrequency1Symbol(String frequency1Symbol) {
        this.frequency1Symbol = frequency1Symbol;
    }

    public Integer getFrequency1() {
        return frequency1;
    }

    public void setFrequency1(Integer frequency1) {
        this.frequency1 = frequency1;
    }

    public String getFrequency2Symbol() {
        return frequency2Symbol;
    }

    public void setFrequency2Symbol(String frequency2Symbol) {
        this.frequency2Symbol = frequency2Symbol;
    }

    public Integer getFrequency2() {
        return frequency2;
    }

    public void setFrequency2(Integer frequency2) {
        this.frequency2 = frequency2;
    }

    public String getFrequency3Symbol() {
        return frequency3Symbol;
    }

    public void setFrequency3Symbol(String frequency3Symbol) {
        this.frequency3Symbol = frequency3Symbol;
    }

    public Integer getFrequency3() {
        return frequency3;
    }

    public void setFrequency3(Integer frequency3) {
        this.frequency3 = frequency3;
    }

    public String getFrequency4Symbol() {
        return frequency4Symbol;
    }

    public void setFrequency4Symbol(String frequency4Symbol) {
        this.frequency4Symbol = frequency4Symbol;
    }

    public Integer getFrequency4() {
        return frequency4;
    }

    public void setFrequency4(Integer frequency4) {
        this.frequency4 = frequency4;
    }

    public String getAmountTotalSymbol() {
        return amountTotalSymbol;
    }

    public void setAmountTotalSymbol(String amountTotalSymbol) {
        this.amountTotalSymbol = amountTotalSymbol;
    }

    public Integer getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(Integer amountTotal) {
        this.amountTotal = amountTotal;
    }

    public String getAmount1Symbol() {
        return amount1Symbol;
    }

    public void setAmount1Symbol(String amount1Symbol) {
        this.amount1Symbol = amount1Symbol;
    }

    public Integer getAmount1() {
        return amount1;
    }

    public void setAmount1(Integer amount1) {
        this.amount1 = amount1;
    }

    public String getAmount2Symbol() {
        return amount2Symbol;
    }

    public void setAmount2Symbol(String amount2Symbol) {
        this.amount2Symbol = amount2Symbol;
    }

    public Integer getAmount2() {
        return amount2;
    }

    public void setAmount2(Integer amount2) {
        this.amount2 = amount2;
    }

    public String getAmount3Symbol() {
        return amount3Symbol;
    }

    public void setAmount3Symbol(String amount3Symbol) {
        this.amount3Symbol = amount3Symbol;
    }

    public Integer getAmount3() {
        return amount3;
    }

    public void setAmount3(Integer amount3) {
        this.amount3 = amount3;
    }

    public String getAmount4Symbol() {
        return amount4Symbol;
    }

    public void setAmount4Symbol(String amount4Symbol) {
        this.amount4Symbol = amount4Symbol;
    }

    public Integer getAmount4() {
        return amount4;
    }

    public void setAmount4(Integer amount4) {
        this.amount4 = amount4;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
