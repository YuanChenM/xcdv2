package com.bms.order.bean.externalCall.price.result;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhang_qiang1 on 2017/1/4.
 */
public class PriceListRestResult  implements Serializable{

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
