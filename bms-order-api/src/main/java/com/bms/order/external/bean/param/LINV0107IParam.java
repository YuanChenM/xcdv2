package com.bms.order.external.bean.param;

import java.io.Serializable;

/**
 * Created by zheng_xu on 2017/4/17.
 */

public class LINV0107IParam implements Serializable {
    private LINV0107ISourceParam source = new LINV0107ISourceParam();

    private LINV0107IAllocationParam allocation = new LINV0107IAllocationParam();

    public LINV0107ISourceParam getSource() {
        return source;
    }

    public void setSource(LINV0107ISourceParam source) {
        this.source = source;
    }

    public LINV0107IAllocationParam getAllocation() {
        return allocation;
    }

    public void setAllocation(LINV0107IAllocationParam allocation) {
        this.allocation = allocation;
    }
}
