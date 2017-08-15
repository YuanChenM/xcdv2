package com.bms.slim.bean.entity.target;

import com.bms.slim.bean.BaseTarget;

/**
 * <p>SLIM0233I批量修改生产商库容指定更新的字段，true：更新，false：不更新。</p>
 */
public class SlimProducerStorageCapacityTarget extends BaseTarget {

    /** 卖家角色ID */
    private boolean sellerRoleIdFlg;
    /** 原料库容 */
    private boolean materialCapacityFlg;
    /** 成品库容 */
    private boolean productCapacityFlg;
    /** 仓库照URL */
    private boolean warehousePicUrlFlg;

    public boolean isSellerRoleIdFlg() {
        return sellerRoleIdFlg;
    }

    public void setSellerRoleIdFlg(boolean sellerRoleIdFlg) {
        this.sellerRoleIdFlg = sellerRoleIdFlg;
    }

    public boolean isMaterialCapacityFlg() {
        return materialCapacityFlg;
    }

    public void setMaterialCapacityFlg(boolean materialCapacityFlg) {
        this.materialCapacityFlg = materialCapacityFlg;
    }

    public boolean isProductCapacityFlg() {
        return productCapacityFlg;
    }

    public void setProductCapacityFlg(boolean productCapacityFlg) {
        this.productCapacityFlg = productCapacityFlg;
    }

    public boolean isWarehousePicUrlFlg() {
        return warehousePicUrlFlg;
    }

    public void setWarehousePicUrlFlg(boolean warehousePicUrlFlg) {
        this.warehousePicUrlFlg = warehousePicUrlFlg;
    }
}
