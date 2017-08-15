package com.bms.order.external.bean.param;

import java.io.Serializable;

/**
 * Created by ni_shaotang on 2017/3/2.
 */
public class LINV0015IRestParam implements Serializable {
    private static final long serialVersionUID = 1L;
    private LINV0015ISource source = new LINV0015ISource();
    private LINV0015IAllocation allocation = new LINV0015IAllocation();

    public LINV0015ISource getSource() {
        return source;
    }

    public void setSource(LINV0015ISource source) {
        this.source = source;
    }

    public LINV0015IAllocation getAllocation() {
        return allocation;
    }

    public void setAllocation(LINV0015IAllocation allocation) {
        this.allocation = allocation;
    }
}
