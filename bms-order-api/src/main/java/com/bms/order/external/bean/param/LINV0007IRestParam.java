package com.bms.order.external.bean.param;

import java.io.Serializable;

/**
 * Created by ni_shaotang on 2017/3/2.
 */
public class LINV0007IRestParam implements Serializable {
    private static final long serialVersionUID = 1L;
    private LINV0007ISource source;
    private LINV0007IAllocation allocation;

    public LINV0007ISource getSource() {
        return source;
    }

    public void setSource(LINV0007ISource source) {
        this.source = source;
    }

    public LINV0007IAllocation getAllocation() {
        return allocation;
    }

    public void setAllocation(LINV0007IAllocation allocation) {
        this.allocation = allocation;
    }
}
