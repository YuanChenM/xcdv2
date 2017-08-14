package com.batch.linv.bean.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Created by wang_fan on 2017/4/14.
 */
@XStreamAlias("ns2:getStockByCodesResponse")
public class StockByCodesResponse{

    @XStreamAsAttribute()
    private String  result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}