package com.batch.order.bean.inv.param;

import com.framework.base.rest.param.BaseRestPaginationParam;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liutao on 2017/3/7.
 */
public class LINV0007IParam implements Serializable {

    private static final long serialVersionUID = 1L;

    private LINV0007IAllocationParam allocation;

    private LINV0007ISourceParam source;

    public LINV0007IAllocationParam getAllocation() {
        return allocation;
    }

    public void setAllocation(LINV0007IAllocationParam allocation) {
        this.allocation = allocation;
    }

    public LINV0007ISourceParam getSource() {
        return source;
    }

    public void setSource(LINV0007ISourceParam source) {
        this.source = source;
    }
}
