package com.bms.order.external.bean.param;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ni_shaotang on 2017/3/2.
 */
public class YDPRestParam implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Long> omsOrderIds;

    public List<Long> getOmsOrderIds() {
        return omsOrderIds;
    }

    public void setOmsOrderIds(List<Long> omsOrderIds) {
        this.omsOrderIds = omsOrderIds;
    }
}
