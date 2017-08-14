package com.batch.linv.bean.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by wang_fan on 2017/4/14.
 */
@XStreamAlias("soap:Body")
public class Body {

    @XStreamAlias("ns2:getStockByCodesResponse")
    private StockByCodesResponse  stockByCodesResponse;

    public StockByCodesResponse getStockByCodesResponse() {
        return stockByCodesResponse;
    }

    public void setStockByCodesResponse(StockByCodesResponse stockByCodesResponse) {
        this.stockByCodesResponse = stockByCodesResponse;
    }
}