package com.bms.order.external.bean.param;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ni_shaotang on 2017/3/2.
 */
public class LINV0006IRestParam implements Serializable {
    private static final long serialVersionUID = 1L;
    private LINV0006ISource source = new LINV0006ISource();
    private LINV0006IAllocation allocation = new LINV0006IAllocation();

    public LINV0006ISource getSource() {
        return source;
    }

    public void setSource(LINV0006ISource source) {
        this.source = source;
    }

    public LINV0006IAllocation getAllocation() {
        return allocation;
    }

    public void setAllocation(LINV0006IAllocation allocation) {
        this.allocation = allocation;
    }
}
