package com.bms.order.bean.externalCall.inventory.entity;

import java.io.Serializable;

/**
 * 使用场景 平台，卖家，供应商 占用
 * Created by zhang_qiang1 on 2017/1/11.
 */
public class InventoryAllocationEntity implements Serializable {


    private Boolean isAllocationSuc = true;//  是否占用成功




    public Boolean getIsAllocationSuc() {
        return isAllocationSuc;
    }

    public void setIsAllocationSuc(Boolean isAllocationSuc) {
        this.isAllocationSuc = isAllocationSuc;
    }



}
