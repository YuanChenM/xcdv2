package com.bms.slim.bean.entity.target;

import com.bms.slim.bean.BaseTarget;

/**
 * <p>SLIM0239I批量修改生产商检测设备指定更新的字段，true：更新，false：不更新。</p>
 */
public class SlimProducerTestEquipmentTarget extends BaseTarget {

    /** 卖家角色ID */
    private boolean sellerRoleIdFlg;
    /** 设备名称 */
    private boolean testEqpNameFlg;
    /** 设备主要用途 */
    private boolean testEqpUseFlg;
    /** 设备照片 */
    private boolean testEqpPicUrlFlg;

    public boolean isSellerRoleIdFlg() {
        return sellerRoleIdFlg;
    }

    public void setSellerRoleIdFlg(boolean sellerRoleIdFlg) {
        this.sellerRoleIdFlg = sellerRoleIdFlg;
    }

    public boolean isTestEqpNameFlg() {
        return testEqpNameFlg;
    }

    public void setTestEqpNameFlg(boolean testEqpNameFlg) {
        this.testEqpNameFlg = testEqpNameFlg;
    }

    public boolean isTestEqpUseFlg() {
        return testEqpUseFlg;
    }

    public void setTestEqpUseFlg(boolean testEqpUseFlg) {
        this.testEqpUseFlg = testEqpUseFlg;
    }

    public boolean isTestEqpPicUrlFlg() {
        return testEqpPicUrlFlg;
    }

    public void setTestEqpPicUrlFlg(boolean testEqpPicUrlFlg) {
        this.testEqpPicUrlFlg = testEqpPicUrlFlg;
    }
}
