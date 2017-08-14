package com.batch.order.bean.result;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liutao on 2017/1/10.
 */
public class PriceListRestResult implements Serializable {

    private List<PriceRestResult> priceRestResults;

    public List<PriceRestResult> getPriceRestResults() {
        return priceRestResults;
    }

    public void setPriceRestResults(List<PriceRestResult> priceRestResults) {
        this.priceRestResults = priceRestResults;
    }

    @Override
    public String toString() {
        return "PriceListRestResult{" +
                "priceRestResults=" + priceRestResults +
                '}';
    }
}
