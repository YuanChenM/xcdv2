package com.batch.order.bean.param;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhang_qiang1 on 2017/1/11.
 */
public class ManufacturerRestParam implements Serializable {
    private List<Long> manufacturerIds;

    public List<Long> getManufacturerIds() {
        return manufacturerIds;
    }

    public void setManufacturerIds(List<Long> manufacturerIds) {
        this.manufacturerIds = manufacturerIds;
    }
}
