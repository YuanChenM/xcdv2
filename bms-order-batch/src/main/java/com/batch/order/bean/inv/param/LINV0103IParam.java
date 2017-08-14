package com.batch.order.bean.inv.param;

import java.io.Serializable;

/**
 * Created by zheng_xu on 2017/4/14.
 */
public class LINV0103IParam implements Serializable {

    private LINV0103ISourceParam source = new LINV0103ISourceParam();

    private LINV0103IAllocationParam allocation = new LINV0103IAllocationParam();

    public LINV0103ISourceParam getSource() {
        return source;
    }

    public void setSource(LINV0103ISourceParam source) {
        this.source = source;
    }

    public LINV0103IAllocationParam getAllocation() {
        return allocation;
    }

    public void setAllocation(LINV0103IAllocationParam allocation) {
        this.allocation = allocation;
    }
}
