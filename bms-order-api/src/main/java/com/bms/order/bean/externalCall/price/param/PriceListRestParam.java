package com.bms.order.bean.externalCall.price.param;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhang_qiang1 on 2017/1/9.
 */
public class PriceListRestParam implements Serializable{

    private List<PriceRestParam> paramList;


    public List<PriceRestParam> getParamList() {
        return paramList;
    }

    public void setParamList(List<PriceRestParam> paramList) {
        this.paramList = paramList;
    }

    @Override
    public String toString() {
        return "PriceListRestParam{" +
                "paramList=" + paramList +
                '}';
    }
}
