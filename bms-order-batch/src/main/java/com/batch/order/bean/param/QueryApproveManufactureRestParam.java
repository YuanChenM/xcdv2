package com.batch.order.bean.param;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhang_qiang1 on 2017/1/11.
 */
public class QueryApproveManufactureRestParam implements Serializable {

    private List<String> buyersIds;


    public List<String> getBuyersIds() {
        return buyersIds;
    }

    public void setBuyersIds(List<String> buyersIds) {
        this.buyersIds = buyersIds;
    }
}
