package com.bms.bymt.bean.result;

import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by tao_zhifa on 2016/12/28.
 */
public class BasePageResult<T extends Serializable> extends BaseRestPaginationResult<T> {

    @ApiModelProperty(value = "买家户数总计")
    private String buyerNumCount;
    @ApiModelProperty(value = "年交易额总计(单位:元)")
    private BigDecimal tradeAmountCount;

    public String getBuyerNumCount() {
        return buyerNumCount;
    }

    public void setBuyerNumCount(String buyerNumCount) {
        this.buyerNumCount = buyerNumCount;
    }

    public BigDecimal getTradeAmountCount() {
        return tradeAmountCount;
    }

    public void setTradeAmountCount(BigDecimal tradeAmountCount) {
        this.tradeAmountCount = tradeAmountCount;
    }
}
