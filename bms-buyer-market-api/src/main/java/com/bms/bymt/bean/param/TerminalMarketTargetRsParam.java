package com.bms.bymt.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * Created by tao_zhifa on 2016/12/15.
 */
@ApiModel(value = "TerminalMarketTargetRsParam", description = "批发市场目标买家汇总信息RsParams")
public class TerminalMarketTargetRsParam extends BaseRestPaginationParam {

    /**
     * 目标买家主键
     */
    @ApiModelProperty(value = "目标买家主键")
    private Long targetId;
    /**
     * 批发市场UUID
     */
    @ApiModelProperty(value = "批发市场UUID")
    private String termMarketId;
    /**
     * 买家类型名称
     */
    @ApiModelProperty(value = "买家类型名称")
    private String buyerName;
    /**
     * 销售产品类型名称
     */
    @ApiModelProperty(value = "销售产品类型名称")
    private String proName;
    /**
     * 买家户数
     */
    @ApiModelProperty(value = "买家户数")
    private Integer buyerNum;
    /**
     * 年交易额(单位:元)
     */
    @ApiModelProperty(value = "年交易额(单位:元)")
    private java.math.BigDecimal tradeAmount;
    @ApiModelProperty(value = "逻辑删除")
    private boolean delFlg;
    @ApiModelProperty(value = "目标买家户数合计")
    private String sumBuyerNum;
    @ApiModelProperty(value = "年交易额合计")
    private BigDecimal sumTradeAmount;

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public String getTermMarketId() {
        return termMarketId;
    }

    public void setTermMarketId(String termMarketId) {
        this.termMarketId = termMarketId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Integer getBuyerNum() {
        return buyerNum;
    }

    public void setBuyerNum(Integer buyerNum) {
        this.buyerNum = buyerNum;
    }

    public BigDecimal getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(BigDecimal tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public String getSumBuyerNum() {
        return sumBuyerNum;
    }

    public void setSumBuyerNum(String sumBuyerNum) {
        this.sumBuyerNum = sumBuyerNum;
    }

    public BigDecimal getSumTradeAmount() {
        return sumTradeAmount;
    }

    public void setSumTradeAmount(BigDecimal sumTradeAmount) {
        this.sumTradeAmount = sumTradeAmount;
    }
}
