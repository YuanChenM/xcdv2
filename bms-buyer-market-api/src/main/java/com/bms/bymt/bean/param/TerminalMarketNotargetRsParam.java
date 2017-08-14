package com.bms.bymt.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * Created by yuan_zhifei on 2016/12/16.
 */
@ApiModel(value = "TerminalMarketNotargetRsParam", description = "批发市场非目标买家汇总参数")
public class TerminalMarketNotargetRsParam extends BaseRestPaginationParam {
    @ApiModelProperty(value = "非目标买家主键")
    private Long notargetId;
    @ApiModelProperty(value = "批发市场UUID")
    private String termMarketId;
    @ApiModelProperty(value = "非目标买家名称")
    private String nobuyerName;
    @ApiModelProperty(value = "非买家户数")
    private Integer nobuyerNum;
    @ApiModelProperty(value = "年交易额(单位:元) ")
    private BigDecimal tradeAmount;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;
    @ApiModelProperty(value = "非目标买家户数合计")
    private String sumNoBuyerNum;
    @ApiModelProperty(value = "非目标买家年交易额合计")
    private BigDecimal sumTradeAmount;

    public Long getNotargetId() {
        return notargetId;
    }

    public void setNotargetId(Long notargetId) {
        this.notargetId = notargetId;
    }

    public String getTermMarketId() {
        return termMarketId;
    }

    public void setTermMarketId(String termMarketId) {
        this.termMarketId = termMarketId;
    }

    public String getNobuyerName() {
        return nobuyerName;
    }

    public void setNobuyerName(String nobuyerName) {
        this.nobuyerName = nobuyerName;
    }

    public Integer getNobuyerNum() {
        return nobuyerNum;
    }

    public void setNobuyerNum(Integer nobuyerNum) {
        this.nobuyerNum = nobuyerNum;
    }

    public BigDecimal getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(BigDecimal tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getSumNoBuyerNum() {
        return sumNoBuyerNum;
    }

    public void setSumNoBuyerNum(String sumNoBuyerNum) {
        this.sumNoBuyerNum = sumNoBuyerNum;
    }

    public BigDecimal getSumTradeAmount() {
        return sumTradeAmount;
    }

    public void setSumTradeAmount(BigDecimal sumTradeAmount) {
        this.sumTradeAmount = sumTradeAmount;
    }
}
