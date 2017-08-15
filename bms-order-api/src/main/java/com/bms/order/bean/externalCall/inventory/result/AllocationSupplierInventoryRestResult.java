package com.bms.order.bean.externalCall.inventory.result;

import java.io.Serializable;

/**
 * Created by zhang_qiang1 on 2017/1/11.
 */
public class AllocationSupplierInventoryRestResult  implements Serializable {


    private  Boolean isAllocationSuc=true ;//  是否占用成功


    public Boolean getIsAllocationSuc() {
        return isAllocationSuc;
    }

    public void setIsAllocationSuc(Boolean isAllocationSuc) {
        this.isAllocationSuc = isAllocationSuc;
    }
}
