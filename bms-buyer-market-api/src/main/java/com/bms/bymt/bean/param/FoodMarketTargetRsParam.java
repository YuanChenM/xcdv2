package com.bms.bymt.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * Created by tao_zhifa on 2016/12/16.
 */


@ApiModel(value = "FoodMarketTargetRsParam", description = "菜场目标买家汇总信息RsParam")
public class FoodMarketTargetRsParam extends BaseRestPaginationParam {

    @ApiModelProperty(value = "目标买家主键")
    /** 目标买家主键 */
    private Long targetId;
    @ApiModelProperty(value = "菜场主键UUID")
    /** 菜场主键UUID */
    private String foodMarketId;
    @ApiModelProperty(value = "买家类型名称")
    /** 买家类型名称 */
    private String buyerName;
    @ApiModelProperty(value = "销售产品类型名称")
    /** 销售产品类型名称 */
    private String proName;
    @ApiModelProperty(value = "买家户数")
    /** 买家户数 */
    private Integer buyerNum;
    @ApiModelProperty(value = "年交易额(单位:元)")
    /** 年交易额(单位:元) */
    private java.math.BigDecimal tradeAmount;
    @ApiModelProperty(value = "逻辑删除")
    private boolean delFlg;
    @ApiModelProperty(value = "买家户数总计")
    private String buyerNumAllCount;
    @ApiModelProperty(value = "年交易额总计(单位:元)")
    private BigDecimal tradeAmountAllCount;

    public String getBuyerNumAllCount() {
        return buyerNumAllCount;
    }

    public void setBuyerNumAllCount(String buyerNumAllCount) {
        this.buyerNumAllCount = buyerNumAllCount;
    }

    public BigDecimal getTradeAmountAllCount() {
        return tradeAmountAllCount;
    }

    public void setTradeAmountAllCount(BigDecimal tradeAmountAllCount) {
        this.tradeAmountAllCount = tradeAmountAllCount;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public String getFoodMarketId() {
        return foodMarketId;
    }

    public void setFoodMarketId(String foodMarketId) {
        this.foodMarketId = foodMarketId;
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

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }
}
